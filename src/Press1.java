import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Press1
{
    public static int x;
    public static int y;
    public static boolean IsVisible;
    public static BufferedImage image;

    Press1()
    {
        x = 600;
        y = 300;
        IsVisible = true;
        try {
            image = ImageIO.read(new File("src/start.png"));
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
