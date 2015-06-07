import java.lang.*;

public class Oef6 {

    public static void main(String args[]) 
    {
        int a[] = {12,34,56,78,123,234,99,88};
        int top = 0;
        
        for(int number = 0; number < a.length; number++){
            if (top < a[number]) 
            {
                top = a[number];
            }
        }
        System.out.println(top);
    }
}