import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
* 
* @author Senne De Valck
* @version 1
*/

public class EersteProg
{
    /**
    * Dit is de main functie, ier start het programma
    *
    * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline.
    */
    
	public static void main(String args[])
    {
		drukaf(100);
    }
    private static void drukaf(int m)
    {
        int a;
        for (a=0; a < m; a++)
        {
            System.out.println(a);
        }
    }
}