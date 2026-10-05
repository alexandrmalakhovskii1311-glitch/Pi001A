import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class test2 extends JFrame {
    public character pers = new character();
    public BufferedImage fon;
    public character1 pers1 = new character1();
    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && pers.x < 1920) {
                pers.x++;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT && pers.x > 0) {
                pers.x--;
                repaint();

            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN && pers.y < 1080) {
                pers.y++;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_UP && pers.y > 0) {
                pers.y--;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_D && pers1.x < 1920) {
                pers1.x++;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_A && pers1.x > 0) {
                pers1.x--;
                repaint();

            }
            if (e.getKeyCode() == KeyEvent.VK_S && pers1.y < 1080) {
                pers1.y++;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_W && pers1.y > 0) {
                pers1.y--;
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };


    test2()
    {
        try {
            fon = ImageIO.read(new File("src/misurina-sunset.jpg"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
        setSize(1920, 1080);
        setTitle("Minecraft");
        addKeyListener(kl);
    }

    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(pers.image, pers.x, pers.y, this);
        g.drawImage(pers1.image, pers1.x, pers1.y, this);

       /* g.drawLine(100, 300, 100, 500);
        g.drawLine(100, 300, 400, 300);
        g.drawLine(100, 500, 400, 500);
        g.drawLine(400, 300, 400, 500);
        g.drawLine(100, 300, 250, 250);
        g.drawLine(250, 250, 400, 300);
        g.drawRect(300, 200, 50, 100);
        g.drawRect(250, 350, 100, 150);
        */
    }


    public static void main(String[] args)
    {
        new test2();
        /*character bread = new character();
        System.out.println(bread.x+" "+bread.y+" "+bread.IsVisible);
        bread.move(1, 1);
        System.out.println(bread.x +" "+ bread.y +" "+ bread.IsVisible); */
    }
}
