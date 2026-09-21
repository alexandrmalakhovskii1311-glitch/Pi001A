import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Frame {
    public int x = 0;
    public int y = 0;
    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                System.out.println("l");
                x--;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                System.out.println("r");
                x++;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
                System.out.println("u");
                y--;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                System.out.println("d");
                y++;
                repaint();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
    public Main()
    {
        setTitle("The Sun");
        setSize(800,640);
        setVisible(true);
        addKeyListener(kl);
    }
    public void paint(Graphics g)
    {

        super.paint(g);
        Graphics2D isa = (Graphics2D) g;
        /*
        g.setColor(Color.ORANGE);
        //((Graphics2D)g).setBackground(Color.YELLOW);
        g.fillOval(300, 250, 150, 150);
        g.drawLine(460, 325, 560,325);
        g.drawLine(375, 410, 375,500);
        g.drawLine(290, 325, 190,325);
        g.drawLine(375, 240, 375,140);
        g.drawLine(430, 250, 490,200);
        g.drawLine(330, 390, 270,440);
        g.drawLine(430, 390, 490,440);
        g.drawLine(330, 250, 270,200);
        for (int x = 0; x < 600; x++) {
        */
        g.setColor(Color.RED);
        g.fillOval(x,y,50,50);
        //for (long i = 0; i < 999999999; i++){}
        //g.fillOval(600,200,50,50);
    }
    public static void main(String[] args)
    {
        new Main();
    }
}

/*
Условный оператор
if (условие)
{
    команды;
}
else
{
    команды;
}
*/
