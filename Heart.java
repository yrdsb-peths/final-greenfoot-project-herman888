import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
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
