import java.lang.*;

public class Oef7 {

    public static void main(String args[]) 
    {
        int a[] = {12,34,56,78,123,234,99,88};
        int b[];
        b = new int[8];
        
        for(int i = 0; i < a.length; i++)
        {
            int top = 0;
            int pos = 0;
            
            for(int j = 0; j < a.length; j++)
            {
                if (top < a[j]) 
                {
                    top = a[j];
                    pos = j;
                }
            }
            System.out.println(top);
            a[pos] = 0;
            b[i] = top;
        }
        System.out.println(b);
    }
}