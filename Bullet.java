import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    
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
        checkCollision();
        move(5);
       
        if(isAtEdge())
        {
            
            getWorld().removeObject(this);
        }
    }
    
    private void checkCollision()
    {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy != null && enemy.getWorld() !=null && !enemy.isDying())
        {
            enemy.die();
            getWorld().removeObject(this);
            //enemy.die();
        }
    }
}
