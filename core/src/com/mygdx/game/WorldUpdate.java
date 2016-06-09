package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Random;


/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {

    Random rand;
    World world;
    Box[] roofboxes, floorboxes, rightboxes, leftboxes;
    public final Ball ball;
    public final Box floor;
    public final Box roof;
    public final Box rwall;
    public final Box lwall;
    Body ballBody, floorBody, roofBody, rwallBody, lwallBody;
    Body[] boxRoofBody, boxFloorBody, boxRightBody, boxLeftBody;
    public static Vector2 worldGravity = new Vector2(0, -9.82f);
    public static final float FORCE = 10f;
    public static final float PIXELS_TO_METERS = 100f;
    public static final int BOXES = 0;

    public WorldUpdate(){

        rand = new Random();
        world = new World(new Vector2(0f, 0f), true);

        roofboxes = new Box[BOXES];
        floorboxes = new Box[BOXES];
        rightboxes = new Box[BOXES];
        leftboxes = new Box[BOXES];

        boxRoofBody = new Body[BOXES];
        boxFloorBody = new Body[BOXES];
        boxRightBody = new Body[BOXES];
        boxLeftBody = new Body[BOXES];

        ball = new Ball(300,300);
        floor = new Box(Gdx.graphics.getWidth(), 20f ,new Vector2(0, 10));
        roof = new Box(Gdx.graphics.getWidth(), 20f ,new Vector2(0, Gdx.graphics.getHeight() -10));
        rwall = new Box(20f, Gdx.graphics.getHeight() ,new Vector2(Gdx.graphics.getWidth() - 10, 0));
        lwall = new Box(20f, Gdx.graphics.getHeight() ,new Vector2(25, 0));

        ballBody = world.createBody(ball.circleBody);
        floorBody = world.createBody(floor.boxBody);
        roofBody = world.createBody(roof.boxBody);
        rwallBody = world.createBody(rwall.boxBody);
        lwallBody = world.createBody(lwall.boxBody);

        ballBody.createFixture(ball.circleDef);
        floorBody.createFixture(floor.boxShape, 0.0f);
        roofBody.createFixture(roof.boxShape, 0.0f);
        rwallBody.createFixture(rwall.boxShape, 0.0f);
        lwallBody.createFixture(lwall.boxShape, 0.0f);


        for (int i = 0; i < BOXES; i++)
        {
            float x = rand.nextFloat() * 1800;
            float y = rand.nextFloat() * 900;

            roofboxes[i] = new Box(20f, 20f, new Vector2(x+20f, y+20f));
            boxRoofBody[i] = world.createBody(roofboxes[i].boxBody);
            boxRoofBody[i].createFixture(roofboxes[i].boxShape, 0.0f);

            floorboxes[i] = new Box(20f, 20f, new Vector2(x+20f, y-20f));
            boxFloorBody[i] = world.createBody(floorboxes[i].boxBody);
            boxFloorBody[i].createFixture(floorboxes[i].boxShape, 0.0f);

            rightboxes[i] = new Box(20f, 20f, new Vector2(x+40f, y));
            boxRightBody[i] = world.createBody(rightboxes[i].boxBody);
            boxRightBody[i].createFixture(rightboxes[i].boxShape, 0.0f);

            leftboxes[i] = new Box(20f, 20f, new Vector2(x, y));
            boxLeftBody[i] = world.createBody(leftboxes[i].boxBody);
            boxLeftBody[i].createFixture(leftboxes[i].boxShape, 0.0f);
        }
    }

    public void update(float dt){
        world.step(1/60f, 6, 2);
        world.setContactListener(new ContactListener() {

            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();



                if(fixtureA.getBody() != null && fixtureB.getBody() != null) {

                    if(fixtureA.getBody().equals(boxRoofBody) || fixtureB.getBody().equals(boxRoofBody)
                            || fixtureA.getBody().equals(floorBody) || fixtureB.getBody().equals(floorBody)) {
                        ball.vel.y = -ball.vel.y * 0.85f;
                        endContact(contact);
                    }
                    if(fixtureA.getBody().equals(boxFloorBody) || fixtureB.getBody().equals(boxFloorBody)
                            || fixtureA.getBody().equals(roofBody) || fixtureB.getBody().equals(roofBody)){
                        ball.vel.y = -ball.vel.y * 0.85f;
                        endContact(contact);
                    }
                    if(fixtureA.getBody().equals(boxRightBody) || fixtureB.getBody().equals(boxRightBody)
                            || fixtureA.getBody().equals(lwallBody) || fixtureB.getBody().equals(lwallBody)){
                        ball.vel.x = -ball.vel.x * 0.85f;
                        endContact(contact);

                    }
                    if(fixtureA.getBody().equals(boxLeftBody) || fixtureB.getBody().equals(boxLeftBody)
                            || fixtureA.getBody().equals(rwallBody) || fixtureB.getBody().equals(rwallBody)){
                        ball.vel.x = -ball.vel.x * 0.85f;
                        endContact(contact);
                    }

                }
            }

            @Override
            public void endContact(Contact contact) {


            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }

        });
        updateBall(dt);
        updateObstacles(dt);
        updateSolids(dt);
    }

    private void updateBall(float dt){

       //ball.circleBody.position.set(30, 30);
        ball.update(dt);
        Vector2 newPos = new Vector2(ballBody.getPosition().x + (ball.vel.x * dt), ballBody.getPosition().y + (ball.vel.y * dt));
        //Gdx.app.log("Suge mig röv", "x :" + ball.vel.x + "y :" + ball.vel.y);
        ballBody.setTransform(newPos.x, newPos.y, 0);

    }
    private void updateObstacles(double dt){

    }

    private void updateSolids(double dt){

    }

    public void ballForce(Vector2 Force){

        Force = Force.nor().scl(FORCE);
       // Gdx.app.log("Suge mig röv", "x :" + Force.x + " y :" + Force.y);
        ball.vel = ball.vel.add(Force);
    }

}