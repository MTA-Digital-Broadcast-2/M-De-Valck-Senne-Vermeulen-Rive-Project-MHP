import java.lang.*;

public class Oef5 {

    public static void main(String args[])
    {
      
      int limit = 100;
    
      for(int number = 3; number <= limit; number++)
      {
          if(isPrime(number))
          {
              System.out.println(number);
          }
      }

    }
    public static boolean isPrime(int number)
    {
        for(int i=2; i<number; i++)
        {
           if(number%i == 0)
           {
               return false;
           }
        }
        return true;
    }
}