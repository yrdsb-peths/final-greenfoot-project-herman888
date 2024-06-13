import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the bullet class and it is responsible for killing the skeletons and zombies in the game.
 * @author (herman Isayenka) 
 * @version (June 2024)
 */
public class Bullet extends Actor
{
    
    private boolean hasCollided = false;
    
    public Bullet()
    {
        GreenfootImage image = new GreenfootImage("images/bulett2.png");
        image.scale(75,75);
        setImage(image);
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        move(5);
        
       
        if(isAtEdge())
        {
            
            getWorld().removeObject(this);
        }
    }
    
    
    
    
}
