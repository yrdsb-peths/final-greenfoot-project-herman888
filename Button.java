import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage playImage;
    private World targetWorld;
    
    
    
    
    public Button(String playImageFile, World targetWorld)
    {
        playImage = new GreenfootImage("play.png");
        playImage.scale(300,150);
        setImage(playImage);
        this.targetWorld = targetWorld;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(targetWorld);
        }
    }
}
