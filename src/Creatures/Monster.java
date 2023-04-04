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
				case "�ݰ�":
					this.STR = 5;
					this.DEX = 5;
					System.out.println(this.name + "�� ���� ��ø�� 5�� �Ǿ���!");
					this.status.get(k).stack -= 1;
					if (this.status.get(k).stack == 0)
					{
						this.status.remove(k);
						k--;
					}
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
					if (this.status.get(k).stack == 0)
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
				default:
					System.out.println("���� : ���ǵ��� ���� �����̻��Դϴ�.");
					break;
			}
		}
	}
}
