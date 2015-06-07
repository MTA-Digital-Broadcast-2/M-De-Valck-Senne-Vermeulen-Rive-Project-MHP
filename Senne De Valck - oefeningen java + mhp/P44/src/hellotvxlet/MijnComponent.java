/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.dvb.ui.*;
import java.awt.*;

import org.havi.ui.*;

public class MijnComponent extends HComponent
{
    public MijnComponent(int xPos, int yPos, int wSize, int hSize)
    {
        this.setBounds(xPos, yPos, wSize, hSize);
    }
    public void paint(Graphics g){
        g.setColor(new DVBColor(0, 0, 179, 150));
        g.fillRoundRect(20, 100, 200, 100, 40, 40);
        g.setColor(new DVBColor(255, 255, 0, 150));
        g.drawString("TEST", 45, 160);    
    }
}
