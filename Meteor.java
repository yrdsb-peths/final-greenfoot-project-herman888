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
    SimpleTimer lifeTimer = new SimpleTimer();
    
    int speed = 2;
    int finalY = 300;
    
    
    public Meteor()
    {
        Meteor.scale(100,100);
        setImage(Meteor);
        lifeTimer.mark();
        
    }
    
    
    public void act()
    {
        if(getY() < finalY)
        {
            setLocation(getX(), getY() + 1);
        }
       
        
        if(lifeTimer.millisElapsed() > 12000)
        {
            getWorld().removeObject(this);
        }
        
    }
}
