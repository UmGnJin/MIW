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
			System.out.println("�й�...");
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
			System.out.println("����� ������ �̻��� ���󿡼� Ż���߽��ϴ�! -THE END-");
			System.exit(0);
		}
		else
		{
		while(num <1 || num > GameStart.Curnode.path.size())
		{
		System.out.println("���� ���� �����ϼ���.");
			for (int j = 0; j < GameStart.Curnode.path.size(); j++)
			{
				Node tempNode = GameStart.Curnode.path.get(j);
				System.out.printf("%d.%8s  ", j+1, tempNode.nodeName);
			}
			num = sc.nextInt();
			if(num <1 || num > GameStart.Curnode.path.size())
			{
				System.out.println("���� : ���� ���� ���Դϴ�.");
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
