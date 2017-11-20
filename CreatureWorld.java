import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Brayden Hall) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    private boolean playerOneTurn;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this); 
        start = true;
        prepareCreature();
        Greenfoot.start();
    }
    
    public void prepareCreature()
    {
        addObject( playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        addObject( playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
    }
    
     public Creature getPlayerOne()
    {
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }
    
    public void setTurnNumber( boolean turn)
    {
        playerOneTurn = turn;
    }
    
    public boolean getTurnNumber()
    {
        return playerOneTurn;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
       public void act()
    {
        if ( start == true )
        {
           playerOneName=JOptionPane.showInputDialog("Player One, please enter your name",null);
           playerTwoName=JOptionPane.showInputDialog("Player Two, please enter your name",null);
           playerOneTurn = true;
           start = false;
        }
        else if(playerOneTurn == true)
        {
            showText ( playerOneName + "Your Turn" , getWidth()/2, getHeight() / 2);
            showText ( "", getWidth()/2, getHeight()/+26 );
        }
        else if(playerOneTurn == false)
        {
            showText ( playerTwoName + " your turn", getWidth()/2, getHeight()/2 );
            showText ( "", getWidth()/2, getHeight()/+26 );
        }
        
        if( playerOneMenusAdded == false )
        {
           oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
           oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
           addObject( oneFightMenu, 173, getHeight() - 100 );
           addObject( oneSwitchMenu, 241, getHeight() - 100 );
           playerOneMenusAdded = true;
        }
        
        if( playerTwoMenusAdded == false )
        {
            twoFightMenu =  new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
            twoSwitchMenu = new Menu( " Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            addObject( twoFightMenu, 133, 75 );
            addObject( twoSwitchMenu, 199, 75 );
            playerTwoMenusAdded = true;
        }
            
        
        List allObjects=getObjects(null);
        if (playerTwoCreature. getHealthBar().getCurrent() <=0 )
        {
            removeObjects(allObjects);
            showText("Player Two Wins",getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
        
        if ( playerOneCreature. getHealthBar().getCurrent() <=0 )
        {
            removeObjects(allObjects);
            showText("Player One Wins",getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
    }
}

