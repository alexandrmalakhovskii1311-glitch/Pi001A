import java.util.Scanner;
public class test {

    public static void main(String[]args) {
        Scanner name = new Scanner(System.in);
        //String str = name.next();
        int a = name.nextInt();
        System.out.println(a);
        heart_n(a);
    }
    public static void heart()
    {
        System.out.print('♥');
    }
    public static void heart_n(int n)
    {
        for (int i = 0; i < n; i++)
        {
        System.out.print("67  ");
        if ((i + 1) % 10 == 0) System.out.println("");
        }
    }
}
