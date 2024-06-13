import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This acts as a shield for the hero because the enemys cant come into the game when this is activated
 * 
 * @author (Herman Isayenka) 
 * @version (June 2024)
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
