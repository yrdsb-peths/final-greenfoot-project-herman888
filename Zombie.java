import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (Herman isayenka) 
 * @version {June 2024)
 */
public class Zombie extends Actor
{
    
    // VARIABLES
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
        
        //Idles
        for(int i = 0; i < idleZombie.length; i++)
        {
            idleZombie[i] = new GreenfootImage("images/zombie_idle/zombie" + i + ".png");
            idleZombie[i].scale(50,75);
        }
        
        for(int i = 0; i < deadIdle.length; i++)
        {
            deadIdle[i] = new GreenfootImage("images/zombiedead_idle/zombiedead" + i +".png");
            deadIdle[i].scale(50,75);
        }
        setImage(idleZombie[0]);
        animationTimer.mark();
    }
    
    
    // animate the zombie
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
    
    // Detetects if zombie got shot by bullet
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
    
    //Loop through idle when dead
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
    
    // die
    public void die()
    {
        dying = true;
        imageIndex = 0;
        animationTimer.mark();
        spawnCoin();
        
    }
    
    
    //Drop a coin when dead
    public void spawnCoin()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world.isMagnetActive())
        {
            world.increaseScore();
        }
        else
        {
            Coin coin1 = new Coin();
            getWorld().addObject(coin1, getX(), getY());
            world.addCoin(coin1);
            
            Coin coin2 = new Coin();
            getWorld().addObject(coin2, getX() + 20, getY());
            world.addCoin(coin2);
        }
        
    }
}
