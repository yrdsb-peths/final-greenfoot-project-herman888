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
    
    private Heart[] hearts;
    private int currentHeartIndex;
    
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
        
        hearts = new Heart[3];
        currentHeartIndex = hearts.length - 1;
        
        for(int i = 0; i < hearts.length; i++)
        {
            hearts[i] = new Heart();
            addObject(hearts[i], 50 + i * 75, 20);
        }
        
        
    }
    
    public void removeHeart()
    {
        if(currentHeartIndex >= 0)
        {
            removeObject(hearts[currentHeartIndex]);
            hearts[currentHeartIndex] = null;
            currentHeartIndex--;
        }
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
