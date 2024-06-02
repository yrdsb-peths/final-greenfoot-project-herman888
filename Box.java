import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    private int speed = 1;
    
    GreenfootImage box = new GreenfootImage("boxfall.png");
    /**
     * Act - do whatever the Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Box()
    {
        box.scale(50,50);
        setImage(box);
    }
    public void act()
    {
        setLocation(getX(), getY() + speed);
        
        if(getY() >= getWorld().getHeight() - 1)
        {
            getWorld().removeObject(this);
        }
    }
}
