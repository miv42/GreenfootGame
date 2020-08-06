import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lever here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lever extends Actor
{
    /**
     * Act - do whatever the Lever wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public boolean leverPosition =false;
    private GreenfootImage lever1;
    private GreenfootImage lever2;

    
    public Lever(){
        lever1= new GreenfootImage("lever1.png");
        lever2= new GreenfootImage("lever2.png");
    }
    
    public void act() 
    {
        pullLever();
    }    
    
    public void pullLever(){
        if(isTouching(Forrest.class)){
            if(Greenfoot.isKeyDown("E") &&leverPosition==false ){
            	    leverPosition=true;
          	        setImage(lever2);
           		    getWorld().getObjects(JgLedge.class).get(0).setLocation(66,533);               
				}
            }
        }
    }

