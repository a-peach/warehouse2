package LifeGame;

public class Logic
{
	private int Status;  //细胞状态：0是死细胞；1是活细胞
	private int NumberAroundCell;  //细胞周围活细胞的数目
	
	Logic()
	{
		Status = 0;
		NumberAroundCell = 0;
	}
	Logic(int g_Status , int g_NumberAroundCell)
	{
		Status = g_Status;
		NumberAroundCell = g_NumberAroundCell;
	}
	
	public void setStatus(int g_Status)
	{
		Status = g_Status;
	}
	public int getStatus()
	{
		return Status;
	}
	
	public void setNumberAroundCell(int g_NumberAroundCell)
	{
		NumberAroundCell = g_NumberAroundCell;
	}
	public int getNumberAroundCell()
	{
		return NumberAroundCell;
	}
	
	public void gameCycle()
	{  //游戏数据的更新及游戏规则
		if(NumberAroundCell > 3 || NumberAroundCell <2)
			this.setStatus(0);
		else if(NumberAroundCell == 3)
			this.setStatus(1);
		
	}
}