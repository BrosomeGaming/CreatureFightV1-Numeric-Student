/**
 * Write a description of class FightCommands here.
 * /**
 * Write a description of class FightCommands here.
 * 
 * @author (Brayden Hall) 
 * @version (a version number or a date)
 */
public class FightCommands implements MenuCommands 
{
	public void execute( int idx, Creature c )
	{
		c.attack( idx );
	}
}


