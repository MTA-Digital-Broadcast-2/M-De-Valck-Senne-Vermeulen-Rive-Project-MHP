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
import org.davic.resources.*;

public class HelloTVXlet implements Xlet, HBackgroundImageListener, UserEventListener, HActionListener, ResourceClient {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    int counter;
    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage bg1 = new HBackgroundImage("pizza1.jpg");
    private HBackgroundImage bg2 = new HBackgroundImage("pizza2.jpg");
    private HBackgroundImage bg3 = new HBackgroundImage("pizza3.jpg");
    private HBackgroundImage bg4 = new HBackgroundImage("pizza4.jpg");
    
    public void notifyRelease(ResourceProxy proxy){};
    public void release(ResourceProxy proxy){};
    public boolean requestRelease(ResourceProxy proxy, Object requestData){return false;}
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException 
    {
        if(debug)
        {
            System.out.println("Xlet Init");
        }
        this.actueleXletContext = context;
        
        MijnComponent mc = new MijnComponent(400,30,200,200, "");
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        screen = HScreen.getDefaultHScreen();
        bgDevice = screen.getDefaultHBackgroundDevice();
        if(bgDevice.reserveDevice(this))
        {
            System.out.println("BackgroundImage device has been reserverd");
        }
        else
        {
            System.out.println("Background image device cannot be reserved");
        }
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try
        {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
        bg1.load(this);
        bg2.load(this);
        bg3.load(this);
        bg4.load(this);
        
    }

    public void startXlet() throws XletStateChangeException 
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
        repository.addKey(HRcEvent.VK_ENTER);
        
        manager.addUserEventListener(this, repository);
        
        scene.validate();
        scene.setVisible(true);
    }
    public void changeIMG(int counter)
    {
        String image = "bg" + counter;
        if(image.equals("bg1"))
        {
            try
            {
            bgConfiguration.displayImage(bg1);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        if(image.equals("bg2"))
        {
            try
            {
            bgConfiguration.displayImage(bg2);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        if(image.equals("bg3"))
        {
            try
            {
            bgConfiguration.displayImage(bg3);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        if(image.equals("bg4"))
        {
            try
            {
            bgConfiguration.displayImage(bg4);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
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

    public void imageLoaded(HBackgroundImageEvent e) {
        try{
            bgConfiguration.displayImage(bg1);
        }
        catch(Exception s)
        {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Load failed!");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    counter++;
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    counter--;
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT PRESSED");
                    counter--;
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT PRESSED");
                    counter++;
                    break;
                case HRcEvent.VK_ENTER:
                    System.out.println("VK_ENTER PRESSED");
                    choosePizza(counter);
                break;
            }
            if(counter > 4)
            {
                counter = 1;
            }
            if(counter < 1)
            {
                counter = 4;
            }
            changeIMG(counter);
            System.out.println(counter);
        }
    }
    public void choosePizza(int number)
    {
        scene.repaint();
        if(number == 1)
        {
            MijnComponent keuze = new MijnComponent(350,50,200,200, "Meat Lover's");
            scene.add(keuze);
        }
        if(number == 2)
        {
            MijnComponent keuze = new MijnComponent(350,150,200,200, "Pepperoni Lover's");
            scene.add(keuze);
        }
        if(number == 3)
        {
            MijnComponent keuze = new MijnComponent(350,250,200,200, "Cheese Lover's");
            scene.add(keuze);
        }
        if(number == 4)
        {
            MijnComponent keuze = new MijnComponent(350,350,200,200, "Vegi Lover's");
            scene.add(keuze);
        }
        scene.validate();
        scene.setVisible(true);
        scene.repaint();
    }
}
