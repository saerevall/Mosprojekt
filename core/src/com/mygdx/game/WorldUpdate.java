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
    public World world;
    Box roofbox1, floorbox1, rightbox1, leftbox1;
    Box roofbox2, floorbox2, rightbox2, leftbox2;
    Box roofbox3, floorbox3, rightbox3, leftbox3;

    public final Ball ball;
    public final Box floor;
    public final Box roof;
    public final Box rwall;
    public final Box lwall;
    Body ballBody, floorBody, roofBody, rwallBody, lwallBody;
    Body boxRoofBody1, boxFloorBody1, boxRightBody1, boxLeftBody1;
    Body boxRoofBody2, boxFloorBody2, boxRightBody2, boxLeftBody2;
    Body boxRoofBody3, boxFloorBody3, boxRightBody3, boxLeftBody3;

    public static Vector2 worldGravity = new Vector2(0, -9.82f);
    public static final float FORCE = 10f;
    public static final float PIXELS_TO_METERS = 100f;
    public static final int BOXES = 2;

    public WorldUpdate(){

        rand = new Random();
        world = new World(new Vector2(0f, 0f), true);



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

        updateObstacles();

    }

    public void update(float dt){
        world.step(1/60f, 6, 2);
        world.setContactListener(new ContactListener() {

            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();



                if(fixtureA.getBody() != null && fixtureB.getBody() != null) {

                    if(fixtureA.getBody().equals(boxRoofBody1) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxRoofBody1)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(floorBody) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(floorBody)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxRoofBody2) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxRoofBody2)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxRoofBody3) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxRoofBody3)&& fixtureA.getBody().equals(ballBody)    )
                    {
                        ball.vel.y = -ball.vel.y * 0.85f;
                        Gdx.app.log("Ovanifran", "Ovanifran");
                        endContact(contact);
                    }
                    if(fixtureA.getBody().equals(boxFloorBody1) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxFloorBody1)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(roofBody) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(roofBody)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxFloorBody2) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxFloorBody2)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxFloorBody3) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxFloorBody3)&& fixtureA.getBody().equals(ballBody) )
                    {
                        ball.vel.y = -ball.vel.y * 0.85f;
                        Gdx.app.log("Underifran", "Underifran");
                        endContact(contact);
                    }
                    if(fixtureA.getBody().equals(boxRightBody1) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxRightBody1)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(lwallBody)&& fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(lwallBody)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxRightBody2) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxRightBody2)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxRightBody3) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxRightBody3)&& fixtureA.getBody().equals(ballBody))
                    {
                        ball.vel.x = -ball.vel.x * 0.85f;
                        Gdx.app.log("Hogerifran", "Hogerifran");
                        endContact(contact);
                    }
                    if(fixtureA.getBody().equals(boxLeftBody1) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxLeftBody1) && fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(rwallBody) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(rwallBody)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxLeftBody2) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxLeftBody2)&& fixtureA.getBody().equals(ballBody)
                            || fixtureA.getBody().equals(boxLeftBody3) && fixtureB.getBody().equals(ballBody)
                            || fixtureB.getBody().equals(boxLeftBody3)&& fixtureA.getBody().equals(ballBody))
                    {
                        ball.vel.x = -ball.vel.x * 0.85f;
                        Gdx.app.log("Vansterifran", "Vansterifran");
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


        updateSolids(dt);
    }

    private void updateBall(float dt){

       //ball.circleBody.position.set(30, 30);
        ball.update(dt);
        Vector2 newPos = new Vector2(ballBody.getPosition().x + (ball.vel.x * dt), ballBody.getPosition().y + (ball.vel.y * dt));
        //Gdx.app.log("Suge mig röv", "x :" + ball.vel.x + "y :" + ball.vel.y);
        ballBody.setTransform(newPos.x, newPos.y, 0);

    }
    private void updateObstacles(){




               float x1 = rand.nextFloat() * 1800;
               float y1 = rand.nextFloat() * 900;

               roofbox1 = new Box(20f, 20f, new Vector2(x1+20f, y1+20f));
               boxRoofBody1 = world.createBody(roofbox1.boxBody);
               boxRoofBody1.createFixture(roofbox1.boxShape, 0.0f);

               floorbox1 = new Box(20f, 20f, new Vector2(x1+20f, y1-20f));
               boxFloorBody1 = world.createBody(floorbox1.boxBody);
               boxFloorBody1.createFixture(floorbox1.boxShape, 0.0f);

               rightbox1 = new Box(20f, 20f, new Vector2(x1+40f, y1));
               boxRightBody1 = world.createBody(rightbox1.boxBody);
               boxRightBody1.createFixture(rightbox1.boxShape, 0.0f);

               leftbox1 = new Box(20f, 20f, new Vector2(x1, y1));
               boxLeftBody1 = world.createBody(leftbox1.boxBody);
               boxLeftBody1.createFixture(leftbox1.boxShape, 0.0f);


                float x2 = rand.nextFloat() * 1800;
                float y2 = rand.nextFloat() * 900;

                 roofbox2 = new Box(20f, 20f, new Vector2(x2+20f, y2+20f));
                 boxRoofBody2 = world.createBody(roofbox2.boxBody);
                 boxRoofBody2.createFixture(roofbox2.boxShape, 0.0f);

                 floorbox2 = new Box(20f, 20f, new Vector2(x2+20f, y2-20f));
                 boxFloorBody2 = world.createBody(floorbox2.boxBody);
                 boxFloorBody2.createFixture(floorbox2.boxShape, 0.0f);

                 rightbox2 = new Box(20f, 20f, new Vector2(x2+40f, y2));
                 boxRightBody2 = world.createBody(rightbox2.boxBody);
                 boxRightBody2.createFixture(rightbox2.boxShape, 0.0f);

                 leftbox2 = new Box(20f, 20f, new Vector2(x2, y2));
                 boxLeftBody2 = world.createBody(leftbox2.boxBody);
                 boxLeftBody2.createFixture(leftbox2.boxShape, 0.0f);



                float x3 = rand.nextFloat() * 1800;
                float y3 = rand.nextFloat() * 900;


                   roofbox3 = new Box(20f, 20f, new Vector2(x3+20f, y3+20f));
                   boxRoofBody3 = world.createBody(roofbox3.boxBody);
                   boxRoofBody3.createFixture(roofbox3.boxShape, 0.0f);

                   floorbox3 = new Box(20f, 20f, new Vector2(x3+20f, y3-20f));
                   boxFloorBody3 = world.createBody(floorbox3.boxBody);
                   boxFloorBody3.createFixture(floorbox3.boxShape, 0.0f);

                   rightbox3 = new Box(20f, 20f, new Vector2(x3+40f, y3));
                   boxRightBody3 = world.createBody(rightbox3.boxBody);
                   boxRightBody3.createFixture(rightbox3.boxShape, 0.0f);

                   leftbox3 = new Box(20f, 20f, new Vector2(x3, y3));
                   boxLeftBody3 = world.createBody(leftbox3.boxBody);
                   boxLeftBody3.createFixture(leftbox3.boxShape, 0.0f);





    }




    private void updateSolids(double dt){

    }

    public void ballForce(Vector2 Force){

        Force = Force.nor().scl(FORCE);
       // Gdx.app.log("Suge mig röv", "x :" + Force.x + " y :" + Force.y);
        ball.vel = ball.vel.add(Force);
    }

}