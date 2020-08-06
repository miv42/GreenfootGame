import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class verticalLever here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class verticalLever extends Lever
{
    /**
     * Act - do whatever the verticalLever wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        public boolean leverPosition2 =false;
        private GreenfootImage lever4;
        public int keyCounter;
    public verticalLever(){
        lever4= new GreenfootImage("lever4.png");
    }
        
    public void act() 
    {
        
        pullLever2();
        checkKeyCounter();
    } 
    public void checkKeyCounter(){
        keyCounter = getWorld().getObjects(Forrest.class).get(0).getKeyCounter();
    }
        public void pullLever2(){
        if(isTouching(Forrest.class)){
            if(leverPosition2==false && Greenfoot.isKeyDown("E") && keyCounter==1){
                leverPosition2=true;
                setImage(lever4);
                getWorld().getObjects(JgTempleDoor.class).get(0).setImage("JgTempleDoorOpen.png");
            }
        }
    }
}
