package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pong implements ActionListener {

    public static Pong pong;

    int width=800,height = 720;
    public Render render;

    public Pong() {
        Timer timer = new Timer(20,this);
        JFrame jframe = new JFrame("Pong");
        render = new Render();

        jframe.setSize(width,height);
        jframe.setVisible(true);
        jframe.add(render);

        timer.start();
    }

    public void update(){

    }

    public void render(Graphics graphics){

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        render.repaint();

    }

    public static void main(String[] args) {
        pong = new Pong();
    }
}
