import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (Herman Isayenka ) 
 * @version (June 2024)
 */
public class Hero extends Actor
{
    
    // VARIABLES
    
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    GreenfootImage[] idleSpace = new GreenfootImage[4];
    GreenfootSound coinSound = new GreenfootSound("coinsound.mp3");
    GreenfootSound deathSound = new GreenfootSound("deathsound.mp3");
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer transitionTimer = new SimpleTimer();
    SimpleTimer fireTimer = new SimpleTimer();
    int score = 0;
    boolean playOnce = false;
    private int firingInterveral = 500;
    String facing = "right";
    boolean Down = false;
    boolean transitioning = false;
    
    public Hero()
    {
        // My Idles
        setImage(idleRight[0]);
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/hero_walk/idle" + i + ".png");
            int newWidth = 90;  
            int newHeight = 90;
            idleRight[i].scale(newWidth, newHeight);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/hero_walk/idle" + i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(90,90);
        }
        
        for(int i = 0; i < idleSpace.length; i++)
        {
            idleSpace[i] = new GreenfootImage("images/hero_idle/idle" + i + ".png");
            idleSpace[i].scale(90,90);
        }
        setImage(idleRight[0]);
        animationTimer.mark();
        fireTimer.mark();
        
    }


   
    int imageIndex = 0;
    // animation for the hero
    public void animateHero()
    {
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        
        if(Down)
        {
            setImage(idleSpace[imageIndex]);
            if(imageIndex < idleSpace.length )
            {
                imageIndex++;
            }
            else
            {
                if(!playOnce)
                {
                    transitioning = true;
                    transitionTimer.mark();
                    Down = false;
                    imageIndex = 0;
                    
                }
                
            }
            if(imageIndex >= idleSpace.length) 
            {
            
            imageIndex = 0;
            }
        
            return;
        }
        
        if(transitioning)
        {
            if(transitionTimer.millisElapsed() >= 500)
            {
                transitioning = false;
            }
            else
            {
                return;
            }
        }
    
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
    
    // This is to fire the bullet when space key is pressed and when down key
    public void fireBullet()
    {

        if(fireTimer.millisElapsed() > firingInterveral)
        {
            Bullet bullet = new Bullet();
            bullet.setImage(new GreenfootImage("images/bulett2.png"));
            bullet.getImage().scale(50,50);
            
            getWorld().addObject(bullet, getX(), getY());
            
            if (Greenfoot.isKeyDown("space"))
            {
                bullet.setRotation(270); 
            }
            
            else if(facing.equals("right"))
            {
                bullet.setRotation(0);
               
            }
            else if(facing.equals("left"))
            {
                bullet.setRotation(180);
            }
            
            
            fireTimer.mark();
        }
    }
    
    
    
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
        }
        else if(Greenfoot.isKeyDown("space"))
        {
            Down = true;
            playOnce = true;
            imageIndex = 3;
            fireBullet();
        }
        else if(Down && !Greenfoot.isKeyDown("space"))
        {
            Down = false;
            playOnce = false;
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            fireBullet();
        }
        checkCollision();
        checkZombieCollision();
        checkForCoin();
        
       
        eat();
        collectMagnet();
        
        
        
        animateHero();
    }
    
    // I want to decrease firing interveral 
    public void changeFiringInterveral(int amount)
    {
        firingInterveral -= amount;
        firingInterveral = Math.max(100, firingInterveral);
        
    }
    
    // Checks if Enemy touched hero
    public void checkCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
    
            
            MyWorld world = (MyWorld)getWorld();
            deathSound.play();
            world.removeHeart();
            
            getWorld().removeObject(enemy);
            
        }
    }
    
    // Checks if Zombie touched hero
    public void checkZombieCollision()
    {
        Actor zombie = (Zombie) getOneIntersectingObject(Zombie.class);
        if(zombie != null)
        {
            getWorld().removeObject(zombie);
            MyWorld world = (MyWorld)getWorld();
            deathSound.play();
            world.removeHeart();
        }
    }
    
    // This is to "eat" the coin
    public void eat()
    {
        if(isTouching(Coin.class))
        {
            removeTouching(Coin.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            coinSound.play();
        }
    }
    
    // This is so that after i touch the magnet it dissapears and puts it in an on state
    public void collectMagnet()
    {
        Actor magnet = getOneIntersectingObject(Magnet.class);
        if(magnet != null)
        {
            getWorld().removeObject(magnet);
            MyWorld world = (MyWorld) getWorld();
            world.activateMagnet();
            
        }
    }
    
    
    // Checks for coin
    public void checkForCoin()
    {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if(coin != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.removeCoin(coin);
            coinSound.play();
            world.removeObject(coin);
        }
    }
    
    
    
}
