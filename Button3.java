import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button3 here.
 * 
 * @author (Herman Isayenka) 
 * @version (June 2024)
 */
public class Button3 extends Actor
{
    
    private GreenfootImage objectiveImage;
    private World objectiveWorld;
    
    public Button3(String objectiveImageFile, World objectiveWorld)
    {
        objectiveImage = new GreenfootImage("objective.png");
        objectiveImage.scale(300,150);
        setImage(objectiveImage);
        this.objectiveWorld = objectiveWorld;
    }
    
    /**
     * Act - do whatever the Button3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(objectiveWorld);
        }
    }
}
