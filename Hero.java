import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Hero()
    {
        GreenfootImage idle = new GreenfootImage("images/hero_idle/idle0.png");
        int newWidth = 150;  
        int newHeight = 150;
        idle.scale(newWidth, newHeight);
        setImage(idle);
        
        
        
    }
    
    //GreenfootImage idle = new GreenfootImage("images/hero_idle/idle0.png");
    
    int newWidth = 50;  
    int newHeight = 50;
    public void act()
    {
        // Add your action code here.
    }
}
