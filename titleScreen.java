import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleScreen extends World
{

    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero,450,275);
        
        
        Label titleLabel = new Label("Space Invaders",70);
        addObject(titleLabel,320,50);
        

        
        MyWorld world = new MyWorld();

        Button button = new Button("play.png", world);
        addObject(button, 147, 280);
        
        Label highestScoreLabel = new Label("Highest Score: " + MyWorld.getHighestScore(),60);
        addObject(highestScoreLabel, getWidth() / 2, getHeight() / 2 + 2);
    }
}
