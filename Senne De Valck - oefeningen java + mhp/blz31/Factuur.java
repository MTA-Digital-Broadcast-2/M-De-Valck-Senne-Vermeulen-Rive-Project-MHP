public class Factuur implements Betaalbaar
{

    public int factuurNr;
    public float factuurBedrag;
    
    public void betaal()
    {
        System.out.println("Betaal het factuur " + factuurNr + " voor een bedrag van " + factuurBedrag + ".");
    }
    
    public Factuur(int nummer, float bedrag)
    {
        this.factuurNr = nummer;
        this.factuurBedrag = bedrag;
    }
}