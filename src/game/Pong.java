package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong implements ActionListener, KeyListener {

    public static Pong pong;
    int width=800,height = 720;
    public Renderer renderer;
    public Paddle player1,player2;
    public Ball ball;
    public boolean bot = false;
    public boolean w,s, down, up;
    public int gameStatus = 0;// 0= stopped



    public Pong() {
        Timer timer = new Timer(20,this);
        JFrame jframe = new JFrame("Pong");
        renderer = new Renderer();


        jframe.setSize(width +15,height +35);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(renderer);
        jframe.addKeyListener(this);
        start();

        timer.start();
    }

    public void start(){
        player1 = new Paddle(this,1);
        player2 = new Paddle(this,2);
        ball = new Ball(this);

    }

    public void update(){
        if (w){
            player1.move(true);
        }
        if (s){
            player1.move(false);
        }
        if (up){
            player2.move(true);
        }
        if (down){
            player2.move(false);
        }

    }


    public void render(Graphics2D graphics){

        graphics.setColor(Color.GRAY);
        graphics.fillRect(0,0,width,height);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //wygładzanie

        if (gameStatus==0){
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Rockwell",3,30));
            graphics.drawString("PONG",width /2 -47,50);

            graphics.setFont(new Font("Rockwell",2,20));
            graphics.drawString("pojedynczy gracz - nacisnij spacje ",width /2 -120,height /2 - 30);
            graphics.drawString("wielu graczy - nacisnij enter",width /2 -120,height /2 + 30);
        }

        if (gameStatus == 2 || gameStatus == 1) {
            graphics.setColor(Color.black);
            graphics.setStroke(new BasicStroke(7f));
            graphics.drawLine(width / 2, 0, width / 2, height);
            //linia po srodku
            player1.render(graphics);
            player2.render(graphics);
            ball.render(graphics);
        }

            if (gameStatus==1){
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Rockwell",1,30));
                graphics.drawString("Pauza",width /2 -20,height /2 - 25);
            }
        }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStatus ==2){

            update();
        }

        renderer.repaint();

    }

    public static void main(String[] args) {
        pong = new Pong();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_W){
            w = true;
        }
        if (id == KeyEvent.VK_S){
            s = true;
        }
        if (id == KeyEvent.VK_DOWN){
            down = true;
        }

        if (id == KeyEvent.VK_UP){
            up = true;
        }
//check

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_W){
            w = false;
        }
        if (id == KeyEvent.VK_S){
            s = false;
        }
        if (id == KeyEvent.VK_DOWN){
            down = false;
        }

        if (id == KeyEvent.VK_UP){
            up = false;
        }
        if(id ==KeyEvent.VK_SPACE){
            if (gameStatus ==0 || gameStatus ==1){
                gameStatus = 2;
            }
            if (gameStatus ==1){

            }
        }
    }
}
