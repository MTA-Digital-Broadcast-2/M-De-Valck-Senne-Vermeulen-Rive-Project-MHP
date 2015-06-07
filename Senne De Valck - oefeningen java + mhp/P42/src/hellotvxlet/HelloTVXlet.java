package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;

import org.havi.ui.*;
import org.havi.ui.event.*;

import java.lang.System;

public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    private HStaticText tekstLabel, juist, fout;
    
    private HTextButton knop1, knop2, knop3, knop4, help;
    
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
        
        tekstLabel = new HStaticText("TEKST");
        juist = new HStaticText("Juist");
        fout = new HStaticText("Fout");
        
        tekstLabel.setLocation(100,100);
        tekstLabel.setSize(400,100);
        tekstLabel.setBackground(new DVBColor(150,150,150,179));
        tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        juist.setLocation(100,100);
        juist.setSize(400,100);
        juist.setBackground(new DVBColor(150,150,150,179));
        juist.setBackgroundMode(HVisible.BACKGROUND_FILL);
        juist.setVisible(false);
        
        fout.setLocation(100,100);
        fout.setSize(400,100);
        fout.setBackground(new DVBColor(150,150,150,179));
        fout.setBackgroundMode(HVisible.BACKGROUND_FILL);
        fout.setVisible(false);
        
        knop1 = new HTextButton("A");
        knop1.setLocation(100,200);
        knop1.setSize(100,50);
        knop1.setBackground(new DVBColor(0,0,0,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop2 = new HTextButton("B");
        knop2.setLocation(200,200);
        knop2.setSize(100,50);
        knop2.setBackground(new DVBColor(0,0,0,179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop3 = new HTextButton("C");
        knop3.setLocation(300,200);
        knop3.setSize(100,50);
        knop3.setBackground(new DVBColor(0,0,0,179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop4 = new HTextButton("D");
        knop4.setLocation(400,200);
        knop4.setSize(100,50);
        knop4.setBackground(new DVBColor(0,0,0,179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        help = new HTextButton("HELP");
        help.setLocation(400,300);
        help.setSize(100,50);
        help.setBackground(new DVBColor(0,0,0,179));
        help.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop1.setFocusTraversal(help, help, knop4, knop2);
        knop2.setFocusTraversal(help, help, knop1, knop3);
        knop3.setFocusTraversal(help, help, knop2, knop4);
        knop4.setFocusTraversal(help, help, knop3, knop1);
        help.setFocusTraversal(knop1, knop1, knop1, knop1);
        
        scene.add(tekstLabel);
        scene.add(knop1);
        scene.add(knop2);
        scene.add(knop3);
        scene.add(knop4);
        
        scene.add(juist);
        scene.add(fout);
        scene.add(help);
        
        knop1.requestFocus();
        
        knop1.setActionCommand("knop1_pressed");
        knop2.setActionCommand("knop2_pressed");
        knop3.setActionCommand("knop3_pressed");
        knop4.setActionCommand("knop4_pressed");
        help.setActionCommand("help_pressed");
        
        knop1.addHActionListener(this);
        knop2.addHActionListener(this);
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        help.addHActionListener(this);
    }

    public void startXlet() 
    {
        if(debug)
        {
            System.out.println("Xlet Start");
        }
        
        scene.validate();
        scene.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //System.out.println(e.getActionCommand());
        String command = e.getActionCommand();
        
        if (command.equals("knop1_pressed"))
        {
            juist.setVisible(true);
            tekstLabel.setVisible(false);
            fout.setVisible(false);
        }else if (command.equals("knop2_pressed"))
        {
            //do something
        }else if (command.equals("knop3_pressed"))
        {
            //do something
        }else if (command.equals("knop4_pressed"))
        {
            //do something
        }else if (command.equals("help_pressed"))
        {
            knop3.setVisible(false);
            knop4.setVisible(false);
        }
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
     
    }
}
