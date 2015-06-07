package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;

import org.havi.ui.*;
import org.havi.ui.event.*;

import java.util.Timer;

import java.lang.System;

public class HelloTVXlet implements Xlet, HActionListener {

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
        
        scene = HSceneFactory.getInstance().getDefaultHScene();
        myImage = new MijnComponent("sterren.png", 0, 0);
        scene.add(myImage);
        
    }

    public void startXlet() 
    {
        if(debug)
        {
            System.out.println("Xlet Start");
        }
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(myImage);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
        
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
}
