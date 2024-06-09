import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (Herman Isayenka) 
 * @version (June 2024)
 */
public class Enemy extends Actor
{
    // VARIABLES
    
    GreenfootImage[] idleLeft = new GreenfootImage[4];
    GreenfootImage[] deadIdle = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    int imageIndex = 0;
    boolean dying = false;
    
    public Enemy()
    {
        //Idles
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/enemy_idle/idle" + i + ".png");
            idleLeft[i].scale(75,75);
        }
        
        for(int i = 0; i < deadIdle.length; i++)
        {
            deadIdle[i] = new GreenfootImage("images/enemy_dead/dead" + i +".png");
            deadIdle[i].scale(75,75);
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
        if(!dying)
        {
            moveLeft();
            animateEnemy();
            bulletDetection();// Add your action code here.
            
            checkCollisionWithMeteor();
            
        }
        else
        {
            animateDeath();
        }
        
    }
    
    // Movement
    public void moveLeft()
    {
        setLocation(getX()-2, getY());
        if(getX() <= 0)
        {
            if(getWorld() != null)
            {
                getWorld().removeObject(this);
            }
            
        }
        
        
    }
    
    // Animation when walking
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
    
    public void die()
    {
        dying = true;
        imageIndex = 0;
        animationTimer.mark();
        spawnCoin();
        
    }
    
    // Animate when die
    public void animateDeath()
    {
        if(animationTimer.millisElapsed()<45)
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
            if(getWorld() != null)
            {
                getWorld().removeObject(this);
            }
            
        }
        
        
    }
    
    public boolean isDying()
    {
        return dying;
    }
    
    // Checks if its been hit by a bullet
    public void bulletDetection()
    {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        
        if(bullet != null && getWorld() != null)
        {
            getWorld().removeObject(bullet);
            Greenfoot.delay(1);
            die();
        }
    }
    
    // The meteor is able to block them moves them away 
    private void checkCollisionWithMeteor()
    {
        Meteor meteor = (Meteor) getOneIntersectingObject(Meteor.class);
        if(meteor != null && meteor.getWorld() != null)
        {
            setLocation(getX() + 5, getY());
        }
    }
    
   
    // Spawns a coin when dead
    public void spawnCoin()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world != null && world.isMagnetActive())
        {
            world.increaseScore();
        }
        else if(world != null)
        {
            Coin coin = new Coin();
            getWorld().addObject(coin, getX(), getY());
            world.addCoin(coin);
        }
        
    }
}
