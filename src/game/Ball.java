package game;

import java.awt.*;
import java.util.Random;

public class Ball {

    public int moveX,moveY,amountOfHits;
    public int x,y, width = 25, height =25 ;
    public Random random;
    private Pong pong;

    public Ball(Pong pong){
        this.random = new Random();
        this.pong = pong;
        spawn();
        //this.moveX = -1 + random.nextInt(1);
        //move of ball  lines up
    }


    public Ball(){
    random = new Random();
    }

    public void update(Paddle paddle1,Paddle paddle2) {
        int ballSpeed =5;

        this.x += moveX = ballSpeed;
        this.y += moveY = ballSpeed;
        System.out.println(moveX);
        System.out.println(moveY);

        if (this.x +width > pong.width || this.x < 0) {
            if (this.moveY < 0){
                this.moveY = random.nextInt(4);
            }
            else{
                this.moveY = -random.nextInt(4);
            }
        }

        if(colissionDetection(paddle1) == 1){

           this.moveX = 1 + (amountOfHits/5);
           this.moveY = -2 + random.nextInt(4);

           if (moveY == 0){
               moveY =1;
           }
           amountOfHits++;
       }
        else if(colissionDetection(paddle2) == 1){

            this.moveX = - 1 - (amountOfHits/5);
            this.moveY = -2 + random.nextInt(4);

            if (moveY ==0){
                moveY =1;
            }
            amountOfHits++;
        }
        else if(colissionDetection(paddle1) == 2){
             paddle2.score++;
             spawn();
        }
        else if(colissionDetection(paddle2) == 2){
            paddle1.score++;
            spawn();
        }
    }

    public void spawn(){
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
    }

    public int colissionDetection(Paddle paddle){

        if (this.x < paddle.x + paddle.width && this.x + width > paddle.x &&
                this.y < paddle.y + paddle.height && this.y + height > paddle.y) {

            return 1;

        }
      else  if((paddle.x > x + width && paddle.paddleNumber == 1) ||
                (paddle.x < x && paddle.paddleNumber == 2 )){

            return 2;
        }

        return 0;
    }
         // reakcja pilki na odbicie od paddla


    public void render (Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x,y,width,height);
    }

}
