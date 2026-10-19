import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends Frame {
    public Ship ship = new Ship();
    public Press2 exit = new Press2();
    public laser las = new laser();
    public laser[] l = new laser[50];

    public BufferedImage fon;
    public boolean flag = false;
    //Timer time = new Timer(239, new ActionListener {
    // });
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getPoint().x > 700 && e.getPoint().x < 800 && e.getPoint().y > 0 && e.getPoint().y < 150) {
                dispose();
                new menu();
                repaint();
            }
        }
        @Override
        public void mouseReleased(MouseEvent e) {        }
        @Override
        public void mouseEntered(MouseEvent e) {        }
        @Override
        public void mouseExited(MouseEvent e) {        }
    };
    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {          }
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                ship.x -= 3;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                ship.x += 3;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_UP && ship.y > 400)
            {
                ship.y -= 3;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN && ship.y < 850)
            {
                ship.y += 3;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                flag= !flag;
                repaint();
                /* las.x = ship.x;
                las.y = ship.y;
                Timer time = new Timer(0.1, new ActionListener {

                });*/

            }
        }
        @Override
        public void keyReleased(KeyEvent e) {            }
    };
    Game()
    {
        try {
            fon = ImageIO.read(new File ("src/fon.png"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        setTitle("Game");
        setSize(800,1000);
        setVisible(true);
        addKeyListener(kl);
        addMouseListener(ml);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(ship.image, ship.x, ship.y, this);
        g.drawImage(exit.image, 700, 0, this);
        if (flag) {
           g.drawImage(las.image, las.x, las.y, this);
       }

    }
    public static void main(String[] args)
    {
        new Game();
    }
}


