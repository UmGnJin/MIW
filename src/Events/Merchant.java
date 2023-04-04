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
		System.out.println("������. ��, �ѷ����� ���̾�.");
		Random random = new Random();
		for(int k = 0;k<6;k++)
		{
			Catalog.add(WeaponInfo.GiveWeapon(random.nextInt(WeaponInfo.WeaponList.size())));
		}
		for(int k = 0;k<Catalog.size();k++)
		{
			System.out.print((k+1) + "." + Catalog.get(k).Name + "(" + Catalog.get(k).Cost + ") ");
		}
			System.out.println("\n�� �����? ���ʺ��� 1�� 2��.. �׷��� �����. ���Ÿ� 999�ΰ� ����?");
			System.out.println("���� ��差 : " + GameStart.player.Gold);
			
		
	}
	public void Leave()
	{
		System.out.println("������ ���ڰ� !!!");
		end = true;
	}
	
	public void Sell(int num)
	{
		if (num+1 < 1 || num+1 > Catalog.size())
		{
			System.out.println("�װ� ���� ���� ��ȣ�ݾ�!");
		}
		else
		{
			
		
		if (GameStart.player.Inventory.size()==6)
		{
			System.out.println("��� �����ѵ�? �� ��� �� �� �����״� ����.");
			return;
		}
		if(Catalog.get(num).Cost <= GameStart.player.Gold)
		{
			GameStart.player.Gold -= Catalog.get(num).Cost;
			GameStart.player.Inventory.add(Catalog.get(num));
			Catalog.remove(num);
			System.out.println("�� �����!");
		}
		else
		{
			System.out.println("�̺�, ���� �����Ѱ�?");
		}
		}
		Use();
	}
	
}
