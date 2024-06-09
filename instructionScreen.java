import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class instructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class instructionScreen extends World
{

    /**
     * Constructor for objects of class instructionScreen.
     * 
     */
    public instructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label titleLabel = new Label("How To Play",70);
        addObject(titleLabel,300,50);
        
        Label label1 = new Label("Use \u2190 and \u2192 to Move ",40);
        addObject(label1,300,250);
        
        Label label2 = new Label("Use \u2193 to Shoot Side to Side",40);
        addObject(label2,300,350);
        
        Label label3 = new Label("Use <space> to Shoot Up",40);
        addObject(label3, 300, 300);
        
        World objectiveWorld = new objectiveWorld();
        
        Button3 button2 = new Button3("objective.png", objectiveWorld);
        addObject(button2, 300,150);
        
    }
}
