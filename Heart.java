import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the image that is displayed to represnt how many more lives the hero has
 * 
 * @author (Herman Isayenka) 
 * @version (June 2024)
 */
public class Heart extends Actor
{
    
    GreenfootImage image = new GreenfootImage("heart.png");
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Heart()
    {
        image.scale(75,75);
        setImage(image);
    }
}
