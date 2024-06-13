import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen is the main display when the user opens up the game
 * 
 * @author (Herman Isayenka) 
 * @version (June 2024)
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
        
        World instructionWorld = new instructionScreen();
        
        
        Label titleLabel = new Label("Space Invaders",70);
        addObject(titleLabel,320,50);
        
        
        

        
        MyWorld world = new MyWorld();

        Button button = new Button("play.png", world);
        addObject(button, 132, 150);
        
        Button2 button1 = new Button2("instructions.png", instructionWorld);
        addObject(button1, 132,280);
        
        Label highestScoreLabel = new Label("Highest Score: " + MyWorld.getHighestScore(),60);
        addObject(highestScoreLabel, 230, 370);
    }
}
