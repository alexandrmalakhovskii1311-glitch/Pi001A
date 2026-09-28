public class character
{
    public static int x;
    public static int y;
    public static boolean IsVisible;

    character()
    {
        x = 0;
        y = 0;
        IsVisible = true;
    }
    public static void move(int dx, int dy)
    {
        x+=dx;
        y+=dx;
    }

}
