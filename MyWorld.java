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
    public static int highestScore = 0;
    private Label scoreLabel;
    
    private Heart[] hearts;
    private int currentHeartIndex;
    
    private boolean isGameOver = false;
    private int gameOverDelay = 300;
    
    private boolean boxSpawned = false;
    
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
        
        int heart0X = 250;
        int heart1X = 325;
        int heart2X = 400;
        
        int heartY = 40;
        
        hearts[0] = new Heart();
        addObject(hearts[0], heart0X, heartY);
        
        hearts[1] = new Heart();
        addObject(hearts[1], heart1X, heartY);
        
        hearts[2] = new Heart();
        addObject(hearts[2], heart2X, heartY);
        
        //gameOverTimer = new SimpleTimer();
        
        
    }
    
    public void removeHeart()
    {
        if(currentHeartIndex >= 0)
        {
            removeObject(hearts[currentHeartIndex]);
            hearts[currentHeartIndex] = null;
            currentHeartIndex--;
            
            if(currentHeartIndex < 0)
            {
                gameOver();
            }
        }
    }
    
    
    
    public void gameOver()
    {
        if(score > highestScore)
        {
            highestScore = score;
        }
        
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        
        isGameOver = true;
        gameOverDelay = 300;
        
    }
    
    
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            createBox();
        }
    }
    
    public void createBox()
    {
        Box box = new Box();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(box, x, y);
    }
    
    public void act()
    {
        if(!isGameOver)
        {
           spawnEnemy(); 
           
           
        }
        else
        {
            if(gameOverDelay > 0)
            {
                gameOverDelay--;
                
            }
            else
            {
                Greenfoot.setWorld(new titleScreen());
            }
            
            
        }
    }
    
  
    
    
    public void spawnEnemy()
    {
        if(enemySpawnTimer.millisElapsed() > 5000)
        {
            Enemy enemy = new Enemy();
            addObject(enemy, getWidth(), 300);
            enemySpawnTimer.mark();
        }
    }
    
    public static int getHighestScore()
    {
        return highestScore;
    }
    
   
    
}
