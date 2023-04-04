package Creatures;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import DeckSystem.Card;
import DeckSystem.Deck;

public class Monster extends Creature{
	public ArrayList<Pattern> pattern = new ArrayList<>();
	public int patternNum = 0;
	public void Set(String Name, int mhp, int chp, int gold)
	{
		name = Name;
		MHP = mhp;
		CHP = chp;
		Gold = gold;
		STR = 0;
		DEX = 0;
	}
	public void Copy(Monster Target)
	{
		name = Target.name;
		MHP = Target.MHP;
		CHP = Target.CHP;
		Gold = Target.Gold;
		pattern = Target.pattern;
	}
	public void UsePattern()
	{
		pattern.get(patternNum).Use();
		if (pattern.get(patternNum).Disposable == true)
		{
			pattern.remove(patternNum);
			patternNum -= 1;
		}
		patternNum += 1;
		if (patternNum == pattern.size())
			patternNum = 0;
		
	}
	public void StatusCheck()
	{
		
		for(int k = 0;k<this.status.size();k++)
		{
			switch(this.status.get(k).name)
			{
				case "금강":
					this.STR = 5;
					this.DEX = 5;
					System.out.println(this.name + "의 힘과 민첩이 5가 되었다!");
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
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
					if (this.status.get(k).stack == 0)
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
				default:
					System.out.println("오류 : 정의되지 않은 상태이상입니다.");
					break;
			}
		}
	}
}
