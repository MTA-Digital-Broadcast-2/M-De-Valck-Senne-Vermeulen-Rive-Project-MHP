/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

public class MijnTimerTask extends TimerTask{
    private MijnComponent component;
    private int yMove;
    
    public MijnTimerTask(MijnComponent component) 
    {
        this.component = component;
    }
    
    public void run()
    {
        System.out.println("Timer method");
        yMove++;
        this.component.move(0, yMove);
    }

}
