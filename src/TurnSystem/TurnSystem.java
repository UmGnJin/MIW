package TurnSystem;
import java.util.*;

import DeckSystem.*;
import StageSystem.CombatStage;
import CombatSystem.*;
import Creatures.*;
public class TurnSystem {
	  static ArrayList<Card> RTU = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static Weapon SelectedWeapon;
	public static int TurnNum = 0;
	public static void Info()
	{
		EInfo();
		PInfo();
		HInfo();
	}
	public static void EInfo()
	{
		System.out.printf("적 : ");
		for(int k=0;k<GameStart.Enemy.size();k++)
		{
			System.out.printf("%d.%s(HP : %d+%d / %d)", k+1, GameStart.Enemy.get(k).name, GameStart.Enemy.get(k).CHP, GameStart.Enemy.get(k).Shield, GameStart.Enemy.get(k).MHP);
			if (GameStart.Enemy.get(k).status.isEmpty() != true)
			{
				System.out.printf("[상태이상 : ");
				for(int j = 0;j<GameStart.Enemy.get(k).status.size();j++)
				{
					System.out.printf("%s %d", GameStart.Enemy.get(k).status.get(j).name, GameStart.Enemy.get(k).status.get(j).stack);
					if (j+1 != GameStart.Enemy.get(k).status.size())
						System.out.printf(", ");
				}
				System.out.printf("]");
			}
			if (k+1 != GameStart.Enemy.size())
			{
				System.out.printf(", ");
			}
			
		}
		System.out.println();
	}
	public static void HInfo()
	{
		System.out.printf("패 : ");
		for(int a=0;a<Deck.Hand.size();a++)
		{
		System.out.printf("%d.%s%s", a+1, Deck.Hand.get(a).shape, Deck.Hand.get(a).num);
		if (Deck.Hand.get(a).Picked == true)
			System.out.printf("(선택됨)   ");
		else
			System.out.printf("   ");
		}
		System.out.println();
	}
	public static void PInfo()
	{
		System.out.printf("플레이어 : ");
		System.out.printf(" HP : (%d+%d / %d)\n", GameStart.player.CHP, GameStart.player.Shield, GameStart.player.MHP);
	}
	public static void WInfo()
	{
		System.out.printf("장비 : ");
		for(int k = 0;k<GameStart.player.Inventory.size();k++)
		{
			System.out.printf("%d.%s ", k+1, GameStart.player.Inventory.get(k).Name);
		}
		System.out.println();
	}
	public static void TurnStart()
	{
		TurnNum++;
		System.out.print(GameStart.Curnode.nodeName);
		System.out.printf("%d번째 턴\n", TurnNum);
		GameStart.player.StatusCheck();
		DrawCard(GameStart.player.BaseDraw);
	}
	public static void DrawCard(int num)
	{
		for(int k = 0;k < num; k++)
			Deck.DrawCard();
		MPhase();
		
	}
	public static void MPhase()
	{
		System.out.println("당신의 차례입니다.");
		PInfo();
		EInfo();
		SelectWeapon();
	}
	public static void SelectWeapon()
	{
		int st = 0;
		while (st != 999)
		{
			System.out.println("사용할 장비를 선택해 주세요. 좌측부터 1~n으로 선택하세요. 999를 눌러 턴을 종료할 수 있습니다.");
			WInfo();
			st = sc.nextInt();
			if (st == 999)
				TurnEnd();
			else if (st<1 || st>GameStart.player.Inventory.size())
			{
				System.out.println("오류 : 범위 밖의 값입니다.");
			}
			else
			{
				System.out.println(GameStart.player.Inventory.get(st-1).Name + "을(를) 선택했습니다.");
				System.out.println("효과  : " + GameStart.player.Inventory.get(st-1).ToolTip);
				SelectedWeapon = GameStart.player.Inventory.get(st-1);
				SelectCard();
			}
				
			
		}
	}
	public static void SelectCard()
	{
		int num = 0;
		while(num != 999)
		{
			System.out.println("사용할 카드들을 선택해 주세요. 좌측부터 1~n으로 선택하세요. 1000을 눌러 사용할 카드들을 확정하세요. 999를 눌러 이전 과정으로 돌아갈 수 있습니다.");
			HInfo();
			num = sc.nextInt();
		if (num == 999)
		{
			RTU.clear();
			for(int k =0;k<Deck.Hand.size();k++)
			{
				Deck.Hand.get(k).Picked = false;
			}
			SelectWeapon();
		}
		else if (num == 1000)
		{
			if (RTU.size() == 0)
				System.out.println("오류 : 선택한 카드가 없습니다.");
			else
			{
				SelectTarget();
				break;
			}
		}
		else if ((num<1 || num>Deck.Hand.size()) && num != 999)
		{
			System.out.println("오류 : 범위 밖의 값입니다.");
		}
		else
		{
			if (CombatSystem.Check(Deck.Hand.get(num-1), SelectedWeapon.Con) == true)
			{
				if (Deck.Hand.get(num-1).Picked == true)
				{
					RTU.remove(Deck.Hand.get(num-1));
					Deck.Hand.get(num-1).Picked = false;
				}
				else
				{
					RTU.add(Deck.Hand.get(num-1));
					Deck.Hand.get(num-1).Picked = true;
				}
			}
			else
			{
				System.out.println("오류 : 조건에 맞는 대상이 아닙니다.");
			}
		}
		}
	}
	public static void SelectTarget()
	{
			int target =0;
			while(target != 999)
			{
				System.out.println("대상을 선택하세요. 좌측부터 1~n으로 선택하세요. 999를 눌러 이전 과정으로 돌아갈 수 있습니다.");
				EInfo();
				target = sc.nextInt();
				if (target == 999)
				{
					RTU.clear();
					for(int k =0;k<Deck.Hand.size();k++)
					{
						Deck.Hand.get(k).Picked = false;
					}
					SelectCard();
				}
				else if (target<1 || target>GameStart.Enemy.size())
				{
					System.out.println("오류 : 범위 밖의 값입니다.");
				}
				else
				{
					int sum = 0;
					RTU.clear();
					for(int k =0;k<Deck.Hand.size();k++)
					{
						if (Deck.Hand.get(k).Picked == true)
						{
							sum += Deck.Hand.get(k).value;
							Deck.DiscardedCards.add(Deck.Hand.get(k));
							Deck.Hand.get(k).Picked = false;
							Deck.Hand.remove(k);
							k--;
							
						}
							
					}
					SelectedWeapon.Use(target-1, sum);
					if (GameStart.Enemy.get(target-1).CHP <=0)
					{
						GameStart.Die(target-1);
						if (GameStart.Enemy.isEmpty()==true)
						{
							Deck.DisCard();
							Deck.EndShuffle();
							TurnNum = 0;
							GameStart.Curnode.Cstage.GameOver(true);
							return;
						}
					}
					EInfo();
				break;
				}
			}
	}
	public static void TurnEnd()
	{
		System.out.println("턴 종료");
		Deck.DisCard();
		EPhase();
	}
	public static void EPhase()
	{
		System.out.println("적의 차례입니다.");
		for(int a =0;a<GameStart.Enemy.size();a++)
		{
			GameStart.Enemy.get(a).StatusCheck();
		}
		for(int a =0;a<GameStart.Enemy.size();a++)
		{
			GameStart.Enemy.get(a).UsePattern();
			if (GameStart.player.CHP <=0)
			{
				GameStart.Curnode.Cstage.GameOver(false);
				return;
			}
		}
		TurnStart();
	}

}

