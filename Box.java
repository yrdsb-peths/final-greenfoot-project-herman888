import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    private int speed = 1;
    
    GreenfootImage box = new GreenfootImage("boxfall.png");
    private GreenfootImage[] idleBox = new GreenfootImage[12];
    private boolean animating = false;
    private int animationIndex = 0;
    private SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Box()
    {
        box.scale(100,100);
        setImage(box);
        
        for(int i = 0; i < idleBox.length; i++)
        {
            idleBox[i] = new GreenfootImage("images/box_idle/box" + i + ".png");
            idleBox[i].scale(100,100);
        }
    }
    public void act()
    {
        if(!animating)
        {
            setLocation(getX(), getY() + 1);
            checkCollision();
            
        }
        else
        {
            animateBox();
        }
        
        if(isAtBottom())
        {
            getWorld().removeObject(this);
        }
        
        
    }
    
    private boolean isAtBottom()
    {
        
        World world = getWorld();
        if(world != null)
        {
            int worldHeight = getWorld().getHeight();
        
            return getY() >= worldHeight - 1;
        }
        return false;
        
    }
    
    private void checkCollision()
    {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if(bullet != null)
        {
            getWorld().removeObject(bullet);
            startAnimation();
        }
    }
    
    private void startAnimation()
    {
        animating = true;
        animationIndex = 0;
        animationTimer.mark();
    }
    
    private void animateBox()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(animationIndex < idleBox.length)
        {
            setImage(idleBox[animationIndex]);
            animationIndex++;
            
        }
        else
        {
            MyWorld world = (MyWorld) getWorld();
            animating = false;
            world.addObject(new Magnet(), getX(), 300);
            getWorld().removeObject(this);
           
            
        }
        
    }
    
}
