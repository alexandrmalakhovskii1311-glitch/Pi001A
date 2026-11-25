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

        javax.swing.Timer ShipReload = new javax.swing.Timer(1000 , new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ship.reload = false;
                ShipReload.stop();
            }
        });
        javax.swing.Timer ShipTimer = new javax.swing.Timer(20 , new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ship.rotateL == true) {
                    ship.angle -= 2;
                    ship.rotateL = false;
                }
                else if (ship.angle < 0) ship.angle += 1.5;
                if (ship.angle < 0 && ship.angle > -1.5) ship.angle = 0;
                if (ship.rotateR == true) {
                    ship.angle += 2;
                    ship.rotateR = false;
                }
                else if (ship.angle > 0) ship.angle -= 1.5;
                if (ship.angle > 0 && ship.angle < 1.5) ship.angle = 0;
            }
        });

        javax.swing.Timer spawnTimer = new javax.swing.Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Meteor newMeteor = new Meteor();
                m.add(newMeteor);
            }
        });

        javax.swing.Timer MeteorTimer = new javax.swing.Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = m.size() - 1; i >= 0; i--) {
                    m.get(i).x += m.get(i).dx;
                    m.get(i).y += m.get(i).dy;

                    if (m.get(i).y > 1100 || m.get(i).x < -400 || m.get(i).x > 1300) {
                        m.remove(i);
                    }
                }
                Rectangle ShipRect = new Rectangle(
                        ship.x + 40,
                        ship.y + 30,
                        ship.image.getWidth() - 85,
                        ship.image.getHeight() - 60
                );

                for (int j = m.size() - 1; j >= 0; j--) {
                    Rectangle meteorRect = new Rectangle(
                            m.get(j).x + 15,
                            m.get(j).y + 15,
                            m.get(j).image.getWidth() - 30,
                            m.get(j).image.getHeight() - 30
                    );

                    if (ShipRect.intersects(meteorRect)) {
                        MeteorTimer.stop();
                        laserTimer.stop();
                        spawnTimer.stop();
                        ShipTimer.stop();
                        ShipReload.stop();
                        dispose();
                        new GameOver();
                        break;
                    }
                }

                repaint();

            }
        });

        javax.swing.Timer laserTimer = new javax.swing.Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = l.size() - 1; i >= 0; i--) {
                    l.get(i).y -= 10 * Math.cos(l.get(i).angleLaser / 180 * 3.1415);
                    l.get(i).x += 10 * Math.sin(l.get(i).angleLaser / 180 * 3.1415);

                    if (l.get(i).y < -100) {
                        l.remove(i);
                        continue;
                    }

                    Rectangle laserRect = new Rectangle(
                            l.get(i).x,
                            l.get(i).y,
                            l.get(i).image.getWidth(),
                            l.get(i).image.getHeight()
                    );

                    for (int j = m.size() - 1; j >= 0; j--) {
                        Rectangle meteorRect = new Rectangle(
                                m.get(j).x + 15,
                                m.get(j).y + 15,
                                m.get(j).image.getWidth() - 30,
                                m.get(j).image.getHeight() - 30
                        );

                        if (laserRect.intersects(meteorRect)) {
                            m.remove(j);
                            l.remove(i);
                            break;
                        }
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
            ShipTimer.start();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.drawImage(fon, 0, 0, getWidth(), getHeight(), this);
            g2d.rotate(ship.angle / 180 * 3.1415, ship.x + 100, ship.y + 100);
            g2d.drawImage(ship.image, ship.x, ship.y, this);
            g2d.rotate( -ship.angle / 180 * 3.1415, ship.x + 100, ship.y + 100);
            g2d.drawImage(exit.image, 700, 0, this);

            for (int i = 0; i < l.size(); i++) {
                g2d.rotate(l.get(i).angleLaser / 180 * 3.1415, l.get(i).x + 10, l.get(i).y + 25);
                g2d.drawImage(l.get(i).image, l.get(i).x, l.get(i).y, this);
                g2d.rotate(-l.get(i).angleLaser / 180 * 3.1415, l.get(i).x + 10, l.get(i).y + 25);
            }

            for (int i = 0; i < m.size(); i++) {
                g2d.drawImage(m.get(i).image, m.get(i).x, m.get(i).y, this);
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
            if (e.getKeyCode() == KeyEvent.VK_LEFT && panel.ship.x > -20) {
                panel.ship.x -= 7;
                panel.repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && panel.ship.x < 595) {
                panel.ship.x += 7;
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
                if (panel.ship.reload == false) {
                    laser newLaser = new laser();
                    newLaser.x = (int) (panel.ship.x + 90 * Math.cos(panel.ship.angle / 180 * 3.1415));
                    newLaser.y = (int) (panel.ship.y + 90 * Math.abs(Math.sin(panel.ship.angle / 180 * 3.1415)));
                    newLaser.angleLaser = panel.ship.angle;
                    panel.l.add(newLaser);
                    panel.repaint();
                    panel.ship.reload = true;
                    panel.ShipReload.start();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && panel.ship.angle < 40)  {
                panel.ship.rotateR = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT && panel.ship.angle > -40) {
                panel.ship.rotateL = true;
            } 
         }
        public void keyReleased(KeyEvent e) {


        }
    };

    Game() {
        setTitle("Game");
        setSize(800, 1000);

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













