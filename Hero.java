import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle = new GreenfootImage[3];
    SimpleTimer animationTimer = new SimpleTimer();
    public Hero()
    {
        setImage(idle[0]);
        for(int i = 0; i < 3; i++)
        {
            idle[i] = new GreenfootImage("images/hero_walk/idle" + i + ".png");
        }
        setImage(idle[0]);
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
