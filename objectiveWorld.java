import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class allows me to spread the idea of what the game has its features and things they should look out for in my game
 * 
 * @author (Herman Isayenka ) 
 * @version (June 2024)
 */
public class objectiveWorld extends World
{

    /**
     * Constructor for objects of class objectiveWorld.
     * 
     */
    public objectiveWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        
        Label label1 = new Label("Objective", 70);
        addObject(label1,350,50);
        
        Label label2 = new Label("The hero must reach a score of 50 to complete the game", 25);
        addObject(label2,310,125);
        
        Label label3 = new Label("To get a score the hero must shoot the mobs which drop coins", 25);
        addObject(label3,346,155);
        
        Label label4 = new Label("When a box is dropping the hero can shoot it to receive a magnet", 25);
        addObject(label4,360,185);
        
        Label label5 = new Label("The magnet collects all the coins on the map screen ", 25);
        addObject(label5,290,215);
        
        Label label6 = new Label("The Zombies drop 2 coins and the Skeletons drop 1 coin ", 25);
        addObject(label6,315,245);
        
        Label label7 = new Label("The Meteor that falls down prvents skeletons from entering ", 25);
        addObject(label7,335,275);
        
        Label label8 = new Label("Every time you level up your bullet speed increases ", 25);
        addObject(label8,290,305);
        
        Label label9 = new Label("Every time you level up more skeletons are added to each spawn", 25);
        addObject(label9,357,335);
        
        Label label10 = new Label("You have 3 hearts once you run out the game is over", 25);
        addObject(label10,290,365);
        
        
        
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
           
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
