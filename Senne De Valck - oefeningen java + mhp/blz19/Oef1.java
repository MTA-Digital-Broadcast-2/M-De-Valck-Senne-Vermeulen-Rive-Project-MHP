import java.lang.*;

public class Oef1
{
	public static void main(String args[])
    {
		calc();
    }
    private static void calc()
    {
        int a;
        int b;
        
        for (a = 1; a < 10; a++)
        {
            for (b = 1; b < 10; b++)
            {
                int c = b*a;
                System.out.println(a + " x " + b + " = " + c);
            }
        }
    }
}