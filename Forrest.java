import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Forrest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Forrest extends Actor
{
    private GreenfootImage[] run = new GreenfootImage[5];
    private GreenfootImage[] runback = new GreenfootImage[5];
    private GreenfootImage idle;
    private int currentimage, currentimage2;
    private int delay=0;
    private int speed=5;
    private boolean jumping=false;
    private int vSpeed=1;
    private int acceleration=1;
    private int jumpStrength =13;public int leverPosition =0;
    private int gemCounter=0;  
    private int keyCounter=0;  


    public Forrest(){
        int i=0;
        while(i<5){
            run[i] = new GreenfootImage("run"+(i+1)+".png");
            runback[i] = new GreenfootImage("runback"+(i+1)+".png");
            i++;
        }
        
        idle = new GreenfootImage("idle.png");
        setImage("idle.png");
        currentimage=0;
        currentimage2=0;

    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("D")){
            CheckObstacle();
            move(speed);
            if(jumping==false){
                if(delay%3 == 0){
                    runForrest();
               }
            }
            else{
                 setImage("run4.png"); 
            }

        }
        else{
            if(Greenfoot.isKeyDown("A")){
            CheckObstacle();
            move(-speed);
            if(jumping==false){
                if(delay%3 == 0){
                    runbackForrest();
                }
            }
            else{
                setImage("runback4.png"); 
            }
        }   
        else{
               setImage("idle.png"); 
            }
        }
        delay++;
        wallAbove();
        checkFall();
        if(Greenfoot.isKeyDown("W")&&jumping==false){
            jump();
        }
        
        collectGem();
        endGame();
    }    
    
    public int endGame(){
        if(isTouching(JgTempleDoor.class)&&keyCounter==1){
            return 1;
        }
        else
        {return 0;}
    }
    
    private void collectGem(){
        Actor gem = getOneIntersectingObject(Gem.class);
        Actor key = getOneIntersectingObject(Key.class);

        if(gem != null){
            getWorld().removeObject(gem);
            gemCounter++;
        }
        if(key != null){
            getWorld().removeObject(key);
            keyCounter=1;
        }   
    }
    public int getKeyCounter(){
        return keyCounter;
    }

    public boolean wallAbove(){
        int spriteHeight = getImage().getHeight();
        int yDistance = (int) (spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Wall.class);
        if(ceiling!=null){
            vSpeed=1;
            bopHead(ceiling);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public void bopHead(Actor ceiling){
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight +getImage().getHeight())/2;
        setLocation(getX(),newY);
    }
    
    public void checkFall(){
        if(onGround()){
            vSpeed=0;
            jumping=false;
        }
        else{
            fall();
        }
    }
    
    
    public void fall(){
        setLocation(getX(),getY()+vSpeed);
        vSpeed=vSpeed+acceleration;
    }
    
    public void jump(){
        jumping=true;
        vSpeed=-jumpStrength;
        fall();
    }
    
    public boolean onGround(){
        Wall under = null;
        int counter = 1;
        int max = vSpeed;
        while(counter <= max && under == null){
            under = (Wall)getOneObjectAtOffset(0,getImage().getHeight()/2+counter,Wall.class);
            counter++;
        }
        if(under!=null){
            int newY;
            newY=under.getY()-(under.getImage().getHeight()/2)-((getImage().getHeight()/2))+5;
            setLocation(getX(),newY);
        }
        return under!=null;
    }
    
    
    public void runForrest(){
       
        if(currentimage == 4){
            currentimage = 0;
        }
        else {
            currentimage++;
        }
         setImage(run[currentimage]);
    }
     public void runbackForrest(){
        if(currentimage2 == 4){
            currentimage2 = 0;
        }
        else {
            currentimage2++;
        }
         setImage(runback[currentimage2]);
    }
    
    
    public void CheckObstacle(){
        if(Greenfoot.isKeyDown("D")){
            Actor Wall= getOneObjectAtOffset(30,0,Wall.class);    
            if(Wall!=null){ move(-5);}
            }
        if(Greenfoot.isKeyDown("A")){
            Actor Wall= getOneObjectAtOffset(-30,0,Wall.class);    
            if(Wall!=null){ move(5);}
            }
       
        }
        

    
    
    }
