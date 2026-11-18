import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game extends JFrame {

    class GamePanel extends JPanel {
        public Ship ship = new Ship();
        public Press2 exit = new Press2();
        public ArrayList<laser> l = new ArrayList<>();
        public ArrayList<Meteor> m = new ArrayList<>();
        public BufferedImage fon;

        // Таймер спавна метеоров раз в 5 секунд
        javax.swing.Timer spawnTimer = new javax.swing.Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Meteor newMeteor = new Meteor();
                m.add(newMeteor);
            }
        });

        // Таймер движения метеоров напрямую по их dx и dy
        javax.swing.Timer MeteorTimer = new javax.swing.Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = m.size() - 1; i >= 0; i--) {
                    m.get(i).x += m.get(i).dx;
                    m.get(i).y += m.get(i).dy;

                    if (m.get(i).y > 1100 || m.get(i).x < -400 || m.get(i).x > 1300) {
                        m.remove(i);
                    }
                }
                repaint();
            }
        });

        // Таймер движения лазеров
        javax.swing.Timer laserTimer = new javax.swing.Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = l.size() - 1; i >= 0; i--) {
                    l.get(i).y -= 10;
                    if (l.get(i).y < -100) {
                        l.remove(i);
                    }
                }
                repaint();
            }
        });

        GamePanel() {
            try {
                fon = ImageIO.read(new File("src/fon.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            laserTimer.start();
            MeteorTimer.start();
            spawnTimer.start();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.drawImage(fon, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(ship.image, ship.x, ship.y, this);
            g.drawImage(exit.image, 700, 0, this);

            for (int i = 0; i < l.size(); i++) {
                g.drawImage(l.get(i).image, l.get(i).x, l.get(i).y, this);
            }

            for (int i = 0; i < m.size(); i++) {
                g.drawImage(m.get(i).image, m.get(i).x, m.get(i).y, this);
            }
        }
    }

    GamePanel panel;

    MouseListener ml = new MouseListener() {
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {
            if (e.getPoint().x > 700 && e.getPoint().x < 800 && e.getPoint().y > 0 && e.getPoint().y < 150) {
                panel.laserTimer.stop();
                panel.MeteorTimer.stop();
                panel.spawnTimer.stop();
                dispose();
                new menu();
            }
        }
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    };

    KeyListener kl = new KeyListener() {
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                panel.ship.x -= 5;
                panel.repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                panel.ship.x += 5;
                panel.repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_UP && panel.ship.y > 400) {
                panel.ship.y -= 4;
                panel.repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN && panel.ship.y < 850) {
                panel.ship.y += 4;
                panel.repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                laser newLaser = new laser();
                newLaser.x = panel.ship.x + 90;
                newLaser.y = panel.ship.y;
                panel.l.add(newLaser);
                panel.repaint();
            }
        }
        public void keyReleased(KeyEvent e) {}
    };

    Game() {
        setTitle("Game");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new GamePanel();
        add(panel);

        addKeyListener(kl);
        addMouseListener(ml);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}












