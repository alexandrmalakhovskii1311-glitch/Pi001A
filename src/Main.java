import java.awt.*;
public class Main extends Frame {
    public Main()
    {
        setTitle("first drawing");
        setSize(2560,1600);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D isa = (Graphics2D) g;
        g.setColor(Color.BLACK);
        //((Graphics2D)g).setBackground(Color.YELLOW);
        g.fillOval(1200, 700, 200, 120);
        g.drawOval(1350, 680, 65, 60);

    }
    public static void main(String[] args)
    {
        new Main();
    }
}
