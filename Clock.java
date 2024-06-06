import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock extends Actor
{
    
    private int imageIndex = 0;
    
    GreenfootImage[] idleClock = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Act - do whatever the Clock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Clock()
    {
        
        setImage(idleClock[0]);
        for(int i = 0; i < idleClock.length; i++)
        {
            idleClock[i] = new GreenfootImage("images/clockbar_idle/clockbar"+ i + ".png");
            idleClock[i].scale(100,100);
        }
        animationTimer.mark();
        
    }
    
    
    public void act()
    {
        animateClock();
        
        MyWorld world = (MyWorld) getWorld();
        if(!world.isMagnetActive())
        {
            getWorld().removeObject(this);
        }
    }
    
    private void animateClock()
    {
        if(animationTimer.millisElapsed() > 1000)
        {
           imageIndex = (imageIndex + 1) % idleClock.length;
            setImage(idleClock[imageIndex]); 
            animationTimer.mark();
        }
        
    }
}
