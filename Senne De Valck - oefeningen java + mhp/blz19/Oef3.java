import java.lang.*;

public class Oef3
{
	public static void main(String args[])
    {
		calc();
    }
    private static void calc()
    {
        double pi = 0;
        double container = 0;
        double breuk = 0;
        int switcher = 1;
        for (double teller = 1; teller < 10000; teller += 2)
        {
            breuk = 1 / teller;
            if (switcher == 1)
            {
                container += breuk;
                switcher = 0;
            }
            else
            {
                container -= breuk;
                switcher = 1;
            }
        }
        pi = 4 * container;
        System.out.println("pi = " + pi);
    }
}