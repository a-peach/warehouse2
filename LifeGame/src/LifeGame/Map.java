package LifeGame;

import java.util.Random;

public class Map {
	final static public int x = 30;
	final static public int y = 30;
	
	public static Logic[][] initMap()  //初始化地图
	{
		Logic [][]map=new Logic[x][y];
		for(int i=0 ;i<x ;i++)
		{
			for(int j=0 ;j<y ;j++)
			{
				map[i][j] = new Logic();
				if(j%2 == 0)
					map[i][j].setStatus(1);//初始化地图细胞状态，后期链接UI可自助设置
				else
					map[i][j].setStatus(0);//初始化地图细胞状态，后期链接UI可自助设置
				//Random random=new Random();
    			//map[i][j].setStatus(random.nextInt(2));
			}
		}
		/*map[1][0].setStatus(1);
		map[2][1].setStatus(1);
    	map[2][0].setStatus(1);
    	map[1][1].setStatus(1);*/
		return map;
	}
	
	public static void getNumberAroundCell(Logic[][] map)
	{
		for(int i=0 ;i<x ;i++)
		{
			for(int j=0 ;j<y ;j++)
			{
				int liveNumber=0;
				if(i>0 && j>0)
					liveNumber+=map[i-1][j-1].getStatus(); //记录该细胞左上角细胞状态
				if(i>0)
					liveNumber+=map[i-1][j].getStatus();   //记录该细胞上边细胞状态
				if(j>0)
					liveNumber+=map[i][j-1].getStatus();   //记录该细胞左边细胞状态
				if(i<x-1 && j<y-1)
					liveNumber+=map[i+1][j+1].getStatus(); //记录该细胞右下角细胞状态
				if(i<x-1)
					liveNumber+=map[i+1][j].getStatus();   //记录该细胞下边细胞状态
				if(j<y-1)
					liveNumber+=map[i][j+1].getStatus();   //记录该细胞右边细胞状态
				if(i>0 && j<y-1)
					liveNumber+=map[i-1][j+1].getStatus(); //记录该细胞右上角细胞状态
				if(i<x-1 && j>0)
					liveNumber+=map[i+1][j-1].getStatus(); //记录该细胞左下角细胞状态
				
				map[i][j].setNumberAroundCell(liveNumber); //设置该坐标周围活细胞数目
			}
		}
	}
	
	public static int update(Logic[][] map)//更新之后判断细胞状态是否改变
	{
		int count=0;
		for(int i=0 ;i<x ;i++)
		{
			for(int j=0 ;j<y ;j++)
			{
				int status=map[i][j].getStatus();
				map[i][j].gameCycle();
				if(status==map[i][j].getStatus())
					count++;  //count应当和计时器相连接
			}
		}
		return count;
	}

}


