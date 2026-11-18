import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameOver extends JFrame {
    public static BufferedImage image;

    GameOver() {
        try {
            image = ImageIO.read(new File("src/GameOver.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setSize(1300, 1200);
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

}
