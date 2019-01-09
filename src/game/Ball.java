package game;

import java.awt.*;

public class Ball {

    public int x,y, width, height;


    public Ball(){

    }
    public void update(Paddle paddle1, Paddle paddle2) {
        if (paddle1.x > x) {

        }
        if (paddle1.x < x + width) {
            if(paddle1.y > + y+height || paddle1.y +height< y){

            }
        }
        //colision

    }
    public void render (Graphics graphics){

    }

}
