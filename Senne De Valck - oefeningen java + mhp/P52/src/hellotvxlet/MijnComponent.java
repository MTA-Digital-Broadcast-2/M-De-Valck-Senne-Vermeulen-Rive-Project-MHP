/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent{
   
    public String text = "Uw keuze: ";
    
    public MijnComponent(int X, int Y, int H, int W, String text)
    {
        this.setBounds(X,Y,H,W);
        this.text = text;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawString( text, 10, 20);
    }


}

