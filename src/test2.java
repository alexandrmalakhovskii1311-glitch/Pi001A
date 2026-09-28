import javax.swing.*;
import java.awt.*;

public class test2 extends JFrame {

    test2()
    {
        setVisible(true);
        setSize(1920, 1080);
        setTitle("Minecraft");
    }

    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawLine(100, 300, 100, 500);
        g.drawLine(100, 300, 400, 300);
        g.drawLine(100, 500, 400, 500);
        g.drawLine(400, 300, 400, 500);
        g.drawLine(100, 300, 250, 250);
        g.drawLine(250, 250, 400, 300);
        g.drawRect(300, 200, 50, 100);
        g.drawRect(250, 350, 100, 150);
    }


    public static void main(String[] args)
    {
        new test2();
        /*character bread = new character();
        System.out.println(bread.x+" "+bread.y+" "+bread.IsVisible);
        bread.move(1, 1);
        System.out.println(bread.x +" "+ bread.y +" "+ bread.IsVisible); */
    }
}
