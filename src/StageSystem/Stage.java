package StageSystem;

import java.util.ArrayList;
import java.util.Scanner;

import Creatures.Monster;
import TurnSystem.GameStart;
import map.MapMaker.Node;

public class Stage 
{
	public static void GameOver()
	{
			System.out.println("패배...");
	}

	public void StageStart()
	{
		
	}
	public void Use()
	{
		
	}
	public static void NextStage()
	{
		Scanner sc = new Scanner(System.in);
		int num = 0;
		if (GameStart.Curnode.maptype.equals("Boss"))
		{
			System.out.println("당신은 무사히 이상한 나라에서 탈출했습니다! -THE END-");
			System.exit(0);
		}
		else
		{
		while(num <1 || num > GameStart.Curnode.path.size())
		{
		System.out.println("다음 방을 선택하세요.");
			for (int j = 0; j < GameStart.Curnode.path.size(); j++)
			{
				Node tempNode = GameStart.Curnode.path.get(j);
				System.out.printf("%d.%8s  ", j+1, tempNode.nodeName);
			}
			num = sc.nextInt();
			if(num <1 || num > GameStart.Curnode.path.size())
			{
				System.out.println("오류 : 범위 밖의 값입니다.");
			}	
			else
			{
				GameStart.Curnode = GameStart.Curnode.path.get(num-1);
				GameStart.Curnode.StageStart();
			}
		}
		}
}
}
