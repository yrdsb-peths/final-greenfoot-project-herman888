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
    SimpleTimer magnetTimer = new SimpleTimer();
    private int score = 0;
    public static int highestScore = 0;
    private Label scoreLabel;
    
    private Heart[] hearts;
    private int currentHeartIndex;
    
    private boolean isGameOver = false;
    private int gameOverDelay = 300;
    
    public boolean boxSpawned = false;
    private boolean magnetActive = false;
    
    private static final int MAX_COINS = 50;
    private Coin[] coins = new Coin[MAX_COINS];
    private int coinIndex = 0;
    
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
    
    
    //This allows me to remove the heart each death and when it hits 0 hearts game is over
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
    
    
    // This what occurs when the game is over it checks 
    // my score at the end as well as displays a screem
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
    
    
    // This is what happens in my code when coins are being tooken by 
    // the hero, every 5 points a box spawns, at a random x value
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 2 == 0)
        {
            createBox();
        }
    }
    
    // Creating the box
    public void createBox()
    {
        Box box = new Box();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(box, x, y);
    }
    
    // spawns enemy and checks if magnet on
    public void act()
    {
        if(!isGameOver)
        {
           spawnEnemy(); 
           checkMagnetEffect();
           
           
        }
        else
        {
            //This is my delay
            if(gameOverDelay > 0)
            {
                gameOverDelay--;
                
            }
            //This is taking me back to title screen
            else
            {
                Greenfoot.setWorld(new titleScreen());
            }
            
            
        }
    }
    
    
    public void activateMagnet()
    {
        magnetActive = true;
        magnetTimer.mark();
        Clock clock = new Clock();
        addObject(clock, 550, 30);
    }
    
    // This is to make sure magnet only last 5000 millis
    public void checkMagnetEffect()
    {
        if(magnetActive && magnetTimer.millisElapsed()> 6000)
        {
            magnetActive = false;
            collectAllCoins();
        }
        else if(magnetActive)
        {
            collectAllCoins();
        }
    }
    
    
  
    // spawn an enemy every 5 millis
    
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
    
    public boolean isMagnetActive()
    {
        return magnetActive;
    }
    
    
    // collect all the coins from the array that i made contaning all the coins that have been collected / created
    public void collectAllCoins()
    {
        for (int i = 0; i < coinIndex; i++)
        {
            increaseScore();
            removeObject(coins[i]);
            coins[i] = null; 
        }
        coinIndex = 0;  
    }
    
    
    // removes the coin from the array
    public void removeCoin(Coin coin)
    {
        for(int i = 0; i < coinIndex; i++)
        {
            if(coins[i] == coin)
            {
                for(int j = i; j < coinIndex - 1; j++)
                {
                    coins[j] = coins[j + 1];
                }
                coins[coinIndex - 1] = null;
                coinIndex--;
                break;
            }
        }
        
    }
    
    // used in enemy class
    public void addCoin(Coin coin) 
    {
        if (coinIndex < MAX_COINS) 
        {
            coins[coinIndex] = coin;
            coinIndex++;
        }
    }
   
    
}
