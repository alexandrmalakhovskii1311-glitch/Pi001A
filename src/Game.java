import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game extends Frame {
    public Ship ship = new Ship();
    public Press2 exit = new Press2();
    public ArrayList<laser> l = new ArrayList<laser>();
    public BufferedImage fon;

    private final javax.swing.Timer laserTimer = new javax.swing.Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < l.size(); i++) {
                laser currentLaser = l.get(i);
                currentLaser.y -= 10;

                if (currentLaser.y < -100) {
                    l.remove(i);
                    i--;
                }
            }
            repaint();
        }
    });

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getPoint().x > 700 && e.getPoint().x < 800 && e.getPoint().y > 0 && e.getPoint().y < 150) {
                laserTimer.stop();
                dispose();
                new menu();
            }
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    };

    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                ship.x -= 5;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                ship.x += 5;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_UP && ship.y > 400) {
                ship.y -= 4;
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN && ship.y < 850) {
                ship.y += 4;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                laser newLaser = new laser();
                newLaser.x = ship.x + 90;
                newLaser.y = ship.y;
                l.add(newLaser);

                repaint();

                if (!laserTimer.isRunning()) {
                    laserTimer.start();
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {}
    };

    Game() {
        try {
            fon = ImageIO.read(new File ("src/fon.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("Game");
        setSize(800,1000);
        setVisible(true);
        addKeyListener(kl);
        addMouseListener(ml);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(ship.image, ship.x, ship.y, this);
        g.drawImage(exit.image, 700, 0, this);

        for (int i = 0; i < l.size(); i++) {
            g.drawImage(l.get(i).image, l.get(i).x, l.get(i).y, this);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}






