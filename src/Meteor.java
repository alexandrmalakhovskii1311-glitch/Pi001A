import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Meteor {
    Random random = new Random();
    public int x;
    public int y;
    public int dx;
    public int dy;
    public boolean IsVisible;

    public static BufferedImage image;

    static {
        try {
            image = ImageIO.read(new File("src/метеор.png"));
        } catch (Exception e) {
            System.err.println("Не удалось загрузить картинку лазера: " + e.getMessage());
        }
    }

    public Meteor() {
        x = random.nextInt(1200) - 200;
        y = random.nextInt(200) - 400;
        if (x >= 400) dx = random.nextInt(8) - 10;
        else dx = random.nextInt(8) + 2;
        dy = random.nextInt(8) + 2;

        IsVisible = true;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
