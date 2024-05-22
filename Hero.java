import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    
    GreenfootImage[] idle = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    public Hero()
    {
        setImage(idle[0]);
        for(int i = 0; i < 6; i++)
        {
            idle[i] = new GreenfootImage("images/hero_walk/idle" + i + ".png");
            int newWidth = 150;  
            int newHeight = 150;
            idle[i].scale(newWidth, newHeight);
        }
        
        setImage(idle[0]);
        animationTimer.mark();
    }


   // GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    //GreenfootImage idle = new GreenfootImage("images/hero_walk/idle0.png");
    int imageIndex = 0;
    public void animateHero()
    {
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    //GreenfootImage idle = new GreenfootImage("images/hero_idle/idle0.png");
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }// Add your action code here.
        animateHero();
    }
    
}
