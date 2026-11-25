import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ship {
    public static int x;
    public static int y;
    public double angle = 0;
    public boolean rotateL = false;
    public boolean rotateR = false;
    public boolean reload = false;
    public static boolean IsVisible;
    public static BufferedImage image;

    Ship()
    {
        x = 300;
        y = 650;
        IsVisible = true;
        try {
            image = ImageIO.read(new File("src/ship.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void move(int dx, int dy)
    {
        x+=dx;
        y+=dx;
    }

}
