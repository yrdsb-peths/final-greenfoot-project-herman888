import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    SimpleTimer enemySpawnTimer = new SimpleTimer();
    private int score = 0;
    private Label scoreLabel;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Hero hero = new Hero();
        addObject(hero, 300, 300);
        
        enemySpawnTimer.mark();
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void act()
    {
        spawnEnemy();
    }
    
    //public void increaseScore(int points)
    //{
        //score += points;
        //scoreLabel.setText("Score: " + score);
        
    //}
    
    
    public void spawnEnemy()
    {
        if(enemySpawnTimer.millisElapsed() > 5000)
        {
            Enemy enemy = new Enemy();
            addObject(enemy, getWidth(), 300);
            enemySpawnTimer.mark();
        }
    }
    
    
}
