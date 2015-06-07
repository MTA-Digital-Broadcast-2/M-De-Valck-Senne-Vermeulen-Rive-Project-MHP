/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.*;
import org.havi.ui.*;

public class MijnComponent extends HComponent
{
    private Image bmap;
    private MediaTracker mtrack;
    
    public MijnComponent(String bitmapnaam, int xPos, int yPos) 
    {
        bmap = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(bmap, 0);
        
        try
        {
            mtrack.waitForAll();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        this.setBounds(xPos, yPos, bmap.getWidth(null), bmap.getWidth(null));
    }
    public void move(int xMove, int yMove)
    {
        this.setBounds(xMove, yMove, bmap.getWidth(this), bmap.getHeight(this));
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(bmap, 0, 0, null);
    }
}