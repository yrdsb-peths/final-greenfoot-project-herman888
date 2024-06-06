import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    
    GreenfootImage[] idleZombie = new GreenfootImage[6];
    GreenfootImage[] deadIdle = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    int imageIndex = 0;
    boolean dying = false;
    
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!dying)
        {
            moveRight();
            animateZombie();
            bulletDetection();// Add your action code here.
        }
        else
        {
            animateDeath();
        }
    }
    
    public void moveRight()
    {
        setLocation(getX()+2, getY());
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
        }
        
        
    }
    
    public Zombie()
    {
        for(int i = 0; i < idleZombie.length; i++)
        {
            idleZombie[i] = new GreenfootImage("images/zombie_idle/zombie" + i + ".png");
            idleZombie[i].scale(75,75);
        }
        
        for(int i = 0; i < deadIdle.length; i++)
        {
            deadIdle[i] = new GreenfootImage("images/zombiedead_idle/zombiedead" + i +".png");
            deadIdle[i].scale(75,75);
        }
        setImage(idleZombie[0]);
        animationTimer.mark();
    }
    
    public void animateZombie()
    {
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        setImage(idleZombie[imageIndex]);
        imageIndex = (imageIndex + 1) % idleZombie.length;
    }
    
    public void bulletDetection()
    {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        
        if(bullet != null && getWorld() != null)
        {
            getWorld().removeObject(bullet);
            die();
        }
    }
    
    public boolean isDying()
    {
        return dying;
    }
    
    public void animateDeath()
    {
        if(animationTimer.millisElapsed()<100)
        {
            return;
        }
        animationTimer.mark();
        
        if(imageIndex < deadIdle.length - 1)
        {
            setImage(deadIdle[imageIndex]);
            imageIndex++;
        }
        else
        {
            getWorld().removeObject(this);
        }
        
        
    }
    
    public void die()
    {
        dying = true;
        imageIndex = 0;
        animationTimer.mark();
        spawnCoin();
        
    }
    
    public void spawnCoin()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world.isMagnetActive())
        {
            world.increaseScore();
        }
        else
        {
            Coin coin = new Coin();
            getWorld().addObject(coin, getX(), getY());
            getWorld().addObject(coin, getX() + 2, getY());
            getWorld().addObject(coin, getX() - 2, getY());
            
            world.addCoin(coin);
        }
        
    }
}
