import java.lang.*;

public class Oef2
{
	public static void main(String args[])
    {
		calc();
    }
    private static void calc()
    {
        int jaar = 2009;
        String maand = "februari";
        String naam = "";
        int nummer = 1;
        int weekdag;
        while ( nummer < 29 )
        {
            for ( weekdag = 1; weekdag < 8; weekdag++)
            {
                if ( weekdag == 1){naam = "zondag";}
                if ( weekdag == 2){naam = "maandag";}
                if ( weekdag == 3){naam = "dinsdag";}
                if ( weekdag == 4){naam = "woensdag";}
                if ( weekdag == 5){naam = "donderdag";}
                if ( weekdag == 6){naam = "vrijdag";}
                if ( weekdag == 7){naam = "zaterdag";}
                System.out.println(naam + " " + nummer + " " + maand + " " + jaar);
                nummer++;
            }
            weekdag = 1;
        }
    }
}