import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    
    GreenfootImage[] idleLeft = new GreenfootImage[4];
    SimpleTimer animationTimer = new SimpleTimer();
    int imageIndex = 0;
    
    public Enemy()
    {
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/enemy_idle/idle" + i + ".png");
            idleLeft[i].scale(75,75);
        }
            setImage(idleLeft[0]);
            animationTimer.mark();
    }
    
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveLeft();
        animateEnemy();// Add your action code here.
    }
    
    public void moveLeft()
    {
        setLocation(getX()-2, getY());
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
        }
        
        
    }
    
    public void animateEnemy()
    {
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        setImage(idleLeft[imageIndex]);
        imageIndex = (imageIndex + 1) % idleLeft.length;
    }
}
