package game;

import java.awt.*;
import java.util.Random;

public class Ball {

    public int moveX,moveY;
    public int x,y, width = 25, height =25 ;
    public Random random;
    public Ball(Pong pong){
        this.random = new Random();
        this.x = pong.width / 2 -this.width /2;
        this.y = pong.height / 2- this.height /2;

        this.moveY = -2 + random.nextInt(4);
        if (moveY ==0){
            moveY =1;
        }
        if (random.nextBoolean()){
            moveX =1;
        }
        else{
        moveX = -1;
        }
        this.moveX = -1 + random.nextInt(1);
        //move of ball  lines up
    }


    public Ball(){
    random = new Random();
    }

    public void update(Paddle paddle1,Paddle paddle2) {

        this.x += moveX;
        this.y += moveY;

        if(colissionDetection(paddle1) == 1){
           this.moveX = 1;
           this.moveY = -2 + random.nextInt(4);
       }
        else if(colissionDetection(paddle2) == 1){
            this.moveX = -1;
            this.moveY = -2 + random.nextInt(4);
            if (moveY ==0){
                moveY =1;
            }

        }
        else if(colissionDetection(paddle1) == 2){
            paddle2.score++;
        }
        else if(colissionDetection(paddle2) == 2){
            paddle1.score++;
        }
    }

    public int colissionDetection(Paddle paddle){
        if (paddle.x > x || paddle.x< x+width) {
            if(paddle.y > + y + height || paddle.y +height< y) {
            return 1;//
            }
            else{
                return 2;//
            }
        }
        return 0;
    }
        //colision reakcja pilki na odbicie


    public void render (Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x,y,width,height);
    }

}
