import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    String facing = "right";
    
    public Hero()
    {
        setImage(idleRight[0]);
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/hero_walk/idle" + i + ".png");
            int newWidth = 150;  
            int newHeight = 150;
            idleRight[i].scale(newWidth, newHeight);
        }
        
        
        
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/hero_walk/idle" + i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(150,150);
        }
        setImage(idleRight[0]);
        //animationTimer.mark();
        
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
        
        
        
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
        
        
        
        
        
        
    }
    
    //GreenfootImage idle = new GreenfootImage("images/hero_idle/idle0.png");
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
            facing = "right";
        }// Add your action code here.
        animateHero();
    }
    
}
