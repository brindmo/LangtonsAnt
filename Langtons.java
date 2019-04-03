public class Langtons 
{
	private boolean[][] plane;
	private Ant ant;
	private final Direction North = new Direction(0, 1);
	private final Direction South = new Direction(0, -1);
	private final Direction East = new Direction(1, 0);
	private final Direction West = new Direction(-1, 0);
	
	
	public Langtons(int height, int width)
	{
		plane = new boolean[height][width];
		Ant ant = new Ant(width/2, height/2);
		while ((ant.xCoord > 0 && ant.xCoord < width - 1) && (ant.yCoord > 0 && ant.yCoord < height - 1))
		{
			moveAnt(ant);
		}
	}
	
	public void moveAnt(Ant ant)
	{
		this.ant = ant;
		//move the ant to new coordinates on the basis of its current direction
		ant.setCoords(ant.xCoord + ant.getCurrDirection().getXCoord(), ant.yCoord + ant.getCurrDirection().getYCoord());
		//reverse black/white value
		plane[ant.xCoord][ant.yCoord] = !plane[ant.xCoord][ant.yCoord];
		//move the ant left if the square is black, right if white
		if (plane[ant.xCoord][ant.yCoord] == true)
		{
			//turn left
			if (ant.getCurrDirection().getXCoord() == 0 && ant.getCurrDirection().getYCoord() == 1)
			{
				ant.setCurrDirection(West);
			}
			else if (ant.getCurrDirection().getXCoord() == -1 && ant.getCurrDirection().getYCoord() == 0)
			{
				ant.setCurrDirection(South);
			}
			else if (ant.getCurrDirection().getXCoord() == 0 && ant.getCurrDirection().getYCoord() == -1)
			{
				ant.setCurrDirection(East);
			}
			else if (ant.getCurrDirection().getXCoord() == 1 && ant.getCurrDirection().getYCoord() == 0)
			{
				ant.setCurrDirection(North);
			}
		}
		else
		{
			//turn right
			if (ant.getCurrDirection().getXCoord() == 0 && ant.getCurrDirection().getYCoord() == 1)
			{
				ant.setCurrDirection(East);
			}
			else if (ant.getCurrDirection().getXCoord() == -1 && ant.getCurrDirection().getYCoord() == 0)
			{
				ant.setCurrDirection(North);
			}
			else if (ant.getCurrDirection().getXCoord() == 0 && ant.getCurrDirection().getYCoord() == -1)
			{
				ant.setCurrDirection(West);
			}
			else if (ant.getCurrDirection().getXCoord() == 1 && ant.getCurrDirection().getYCoord() == 0)
			{
				ant.setCurrDirection(South);
			}
		}
	}
	
	private class Direction
	{
		private int x;
		private int y;
		
		public Direction(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public int getXCoord()
		{
			return x;
		}
		
		public int getYCoord()
		{
			return y;
		}
		
		//There's a possibility for a custom comparator here to ease comparisons, such as those in moveAnt()
	}
	
	private class Ant
	{
		private Direction currDirection;
		
		private int xCoord;
		private int yCoord;
		
		public Ant(int xCoord, int yCoord)
		{
			currDirection = North;
			this.xCoord = xCoord;
			this.yCoord = yCoord;
		}
		
		public void setCoords(int xCoord, int yCoord)
		{
			this.xCoord = xCoord;
			this.yCoord = yCoord;
		}
		
		public Direction getCurrDirection()
		{
			return currDirection;
		}
		
		public void setCurrDirection(Direction currDirection)
		{
			this.currDirection = currDirection;
		}
	}
	
	public boolean[][] getPlane()
	{
		return plane;
	}
}
