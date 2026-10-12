import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class menu extends JFrame {
    public Press1 p1 = new Press1();
    public BufferedImage fon;
    public Press2 p2 = new Press2();
    public Press3 p3 = new Press3();
    MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getPoint().x > 600 && e.getPoint().x < 950 && e.getPoint().y > 300 && e.getPoint().y < 391) {;
            }
                new Settings();}
                System.exit(0);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    menu()
    {
        try {
            fon = ImageIO.read(new File("src/фон.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
        setTitle("Cosmic Shooter Pre-Alpha000");
        addMouseListener(ml);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(p1.image, p1.x, p1.y, this);
        g.drawImage(p2.image, p2.x, p2.y, this);
        g.drawImage(p3.image, p3.x, p3.y, this);
    }

    public static void main(String[] args)
    {
        new menu();
    }
}

