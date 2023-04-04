package Events;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Creatures.*;
import CreaturesInfo.*;
import DeckSystem.Deck;
import TurnSystem.GameStart;

public class Merchant extends Event {
	public ArrayList<Weapon> Catalog = new ArrayList<>();
	public void Use()
	{
		System.out.println("떼껄룩. 아, 둘러보란 뜻이야.");
		Random random = new Random();
		for(int k = 0;k<6;k++)
		{
			Catalog.add(WeaponInfo.GiveWeapon(random.nextInt(WeaponInfo.WeaponList.size())));
		}
		for(int k = 0;k<Catalog.size();k++)
		{
			System.out.print((k+1) + "." + Catalog.get(k).Name + "(" + Catalog.get(k).Cost + ") ");
		}
			System.out.println("\n뭘 사려고? 왼쪽부터 1번 2번.. 그렇게 고르라고. 갈거면 999인거 알지?");
			System.out.println("보유 골드량 : " + GameStart.player.Gold);
			
		
	}
	public void Leave()
	{
		System.out.println("다음에 보자고 !!!");
		end = true;
	}
	
	public void Sell(int num)
	{
		if (num+1 < 1 || num+1 > Catalog.size())
		{
			System.out.println("그건 여기 없는 번호잖아!");
		}
		else
		{
			
		
		if (GameStart.player.Inventory.size()==6)
		{
			System.out.println("장비가 가득한데? 더 들고 갈 순 없을테니 관둬.");
			return;
		}
		if(Catalog.get(num).Cost <= GameStart.player.Gold)
		{
			GameStart.player.Gold -= Catalog.get(num).Cost;
			GameStart.player.Inventory.add(Catalog.get(num));
			Catalog.remove(num);
			System.out.println("잘 쓰라고!");
		}
		else
		{
			System.out.println("이봐, 돈이 부족한걸?");
		}
		}
		Use();
	}
	
}
