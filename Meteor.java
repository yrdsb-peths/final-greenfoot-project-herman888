import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Actor
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage Meteor = new GreenfootImage("meteor.png");
    
    private int speed = 2;
    private int finalY = 300;
    
    
    public Meteor()
    {
        Meteor.scale(75,75);
        setImage(Meteor);
        
    }
    
    
    public void act()
    {
        if(getY() < finalY)
        {
            setLocation(getX(), getY() + speed);
        }
    }
}
