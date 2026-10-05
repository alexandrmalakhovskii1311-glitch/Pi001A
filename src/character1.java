import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class character1
{
    public static int x;
    public static int y;
    public static boolean IsVisible;
    public static BufferedImage image;

    character1()
    {
        x = 600;
        y = 700;
        IsVisible = true;
        try {
            image = ImageIO.read(new File("src/gojo.png"));
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
