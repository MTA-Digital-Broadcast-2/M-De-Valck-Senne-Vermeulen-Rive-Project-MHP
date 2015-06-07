import java.lang.*;

public class Main {

    public static void main(String args[]) 
    {
        Werknemer jan = new Werknemer("Jan", "Jansens", 1, 1000);
        Werknemer bart = new Werknemer("Bart", "Jansens", 2, 1000);
        Werknemer tim = new Werknemer("Tim", "Jansens", 3, 1000);
        Werknemer jonas = new Werknemer("Jonas", "Jansens", 4, 1000);
        
        PartTimeWerknemer ben = new PartTimeWerknemer("Ben", "Jansens", 4, 1000, 10);
        PartTimeWerknemer sam = new PartTimeWerknemer("Sam", "Jansens", 4, 1000, 10);
        
        StudentWerknemer benno = new StudentWerknemer("Benno", "Jansens", 4, 1000, 10);
        
        jan.salarisVerhogen(10);
        bart.salarisVerhogen(10);
        
        ben.salarisVerhogen(10);
        
        System.out.println(jan.getSalaris());
        System.out.println(bart.getSalaris());
        System.out.println(tim.getSalaris());
        System.out.println(jonas.getSalaris());
        
        System.out.println(ben.getSalaris());
        System.out.println(sam.getSalaris());
        
        
        jan.setRSZ(21);
        System.out.println(jan.getRSZ());
        sam.setRSZ(15);
        System.out.println(sam.getRSZ());
        System.out.println(benno.getRSZ());
        
        jan.betaal();        
        ben.betaal();
        benno.betaal();
        
        Factuur factuur = new Factuur(1, 1000);
        factuur.betaal();
        
    }
}