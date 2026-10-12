import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Press2
{
    public static int x;
    public static int y;
    public static boolean IsVisible;
    public static BufferedImage image;

    Press2()
    {
        x = 1800;
        y = 0;
        IsVisible = true;
        try {
            image = ImageIO.read(new File("src/выйти.png"));
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
