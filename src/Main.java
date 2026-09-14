import java.awt.*;
public class Main extends Frame {
    public Main()
    {
        setTitle("first drawing");
        setSize(800,640);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D isa = (Graphics2D) g;
        g.setColor(Color.ORANGE);
        //((Graphics2D)g).setBackground(Color.YELLOW);
        g.fillOval(300, 250, 150, 150);
        g.drawLine(460, 325, 560,325);
        g.drawLine(375, 410, 375,500);
        g.drawLine(290, 325, 190,325);
        g.drawLine(375, 240, 375,140);
        g.drawLine(430, 250, 490,200);
        g.drawLine(330, 390, 270,440);
        g.drawLine(430, 390, 490,440);
        g.drawLine(330, 250, 270,200);

    }
    public static void main(String[] args)
    {
        new Main();
    }
}
