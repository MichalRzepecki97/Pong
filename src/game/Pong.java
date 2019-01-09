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
    public boolean bot = false;
    public boolean w,s, down, up;

    public Pong() {
        Timer timer = new Timer(20,this);
        JFrame jframe = new JFrame("Pong");
        renderer = new Renderer();


        jframe.setSize(width +15,height);
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



        graphics.setColor(Color.black);
        graphics.setStroke(new BasicStroke(5f));
        graphics.drawLine(width / 2,0,width / 2  ,height);
        //linia po srodku

        player1.render(graphics);
        player2.render(graphics);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        update();
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
    }
}
