import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button2 here.
 * 
 * @author (Herman Isayenka) 
 * @version (June 2024)
 */
public class Button2 extends Actor
{
    private GreenfootImage instructionImage;
    private World instructionWorld;
    

    
    public Button2(String instructionImageFile, World instructionWorld)
    {
        instructionImage = new GreenfootImage("Instructions.png");
        instructionImage.scale(300,150);
        setImage(instructionImage);
        this.instructionWorld = instructionWorld;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(instructionWorld);
        }
    }
}
