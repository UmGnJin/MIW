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
		name = "플레이어";
		STR = 0;
		DEX = 0;
	}
	
	public void StatusCheck()
	{
		for(int k = 0;k<this.status.size();k++)
		{
			switch(this.status.get(k).name)
			{
				case "어지러움":
					for(int num = 0;num<this.status.get(k).stack;num++)
					{
						Deck.StandardDeck.add(0, StatusCardInfo.GiveStatusCard(0));
						System.out.println("어질어질");
					}
					this.status.remove(k);
					k--;
					break;
				case "독":
					CHP -= this.status.get(k).stack;
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				case "약화":
					this.status.get(k).stack -= 1;
					if (status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				case "취약":
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
					break;
				case "방어 태세":
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.Shield = 0;
						this.status.remove(k);
						k--;
					}
					break;
				case "지속 회복":
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
					System.out.println("오류 : 정의되지 않은 상태이상입니다.");
					break;
			}
		}
	}
}
