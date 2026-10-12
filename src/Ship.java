import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ship {
    public static int x;
    public static int y;
    public static int ax = 0;
    public static int ay = 0;
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
