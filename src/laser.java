import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class laser {
    public int x;
    public int y;
    public boolean IsVisible;

    public static BufferedImage image;

    static {
        try {
            image = ImageIO.read(new File("src/заряд.png"));
        } catch (Exception e) {
            System.err.println("Не удалось загрузить картинку лазера: " + e.getMessage());
        }
    }

    public laser() {
        x = 600;
        y = 300;
        IsVisible = true;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
