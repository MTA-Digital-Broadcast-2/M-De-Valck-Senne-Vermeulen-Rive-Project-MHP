package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.dvb.event.*;
import java.awt.*;
import java.awt.event.*;

import org.havi.ui.*;
import org.havi.ui.event.*;

import java.lang.System;

public class HelloTVXlet implements Xlet, HActionListener, UserEventListener {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    int xMove, yMove;
    MijnComponent myImage;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException 
    {
        if(debug)
        {
            System.out.println("Xlet Init");
        }
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        myImage = new MijnComponent("test.png", 0, 0);

        scene.add(myImage);
    }

    public void startXlet() 
    {
        if(debug)
        {
            System.out.println("Xlet Start");
        }
        EventManager manager = EventManager.getInstance();
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
        
        scene.validate();
        scene.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
     
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    yMove -= 10;
                    myImage.move(xMove, yMove);
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    yMove += 10;
                    myImage.move(xMove, yMove);
                    break;
            }
        }
    }
}
