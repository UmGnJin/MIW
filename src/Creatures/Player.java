package Creatures;
import java.util.ArrayList;

import CreaturesInfo.StatusCardInfo;
import CreaturesInfo.WeaponInfo;
import DeckSystem.Card;
import DeckSystem.Deck;

public class Player extends Creature{
	public ArrayList<Weapon> Inventory = new ArrayList<>();
	String job;
	public final int OriginalDraw = 10;
	public int BaseDraw = 10;
	public Player()
	{
		MHP = 50;
		CHP = 50;
		Gold = 20;
		name = "�÷��̾�";
		STR = 0;
		DEX = 0;
	}
	
	public void StatusCheck()
	{
		for(int k = 0;k<this.status.size();k++)
		{
			switch(this.status.get(k).name)
			{
				case "��������":
					for(int num = 0;num<this.status.get(k).stack;num++)
					{
						Deck.StandardDeck.add(0, StatusCardInfo.GiveStatusCard(0));
						System.out.println("��������");
					}
					this.status.remove(k);
					k--;
					break;
				case "��":
					CHP -= this.status.get(k).stack;
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				case "��ȭ":
					this.status.get(k).stack -= 1;
					if (status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				case "���":
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				case "��� �¼�":
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.Shield = 0;
						this.status.remove(k);
						k--;
					}
					break;
				case "���� ȸ��":
					this.CHP += this.status.get(k).stack;
					if (this.CHP > this.MHP)
						this.CHP = this.MHP;
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				default:
					System.out.println("���� : ���ǵ��� ���� �����̻��Դϴ�.");
					break;
			}
		}
	}
}
