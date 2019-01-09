package game;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {
private static final long serialVersion =1l;

      @Override
    protected void paintComponent(Graphics graphics){
          super.paintComponent(graphics);

          Pong.pong.render((Graphics2D) graphics);
      }
}
