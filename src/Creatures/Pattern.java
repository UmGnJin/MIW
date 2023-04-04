package Creatures;

import java.util.ArrayList;

import CombatSystem.Condition;
import StageSystem.CombatStage;
import StageSystem.Stage;
import TurnSystem.GameStart;

public class Pattern {
	public int Dmg, Def;
	public ArrayList<Status> Buff, DeBuff;
	public String Name;
	public int[] Use = {0, 0, 0, 0};
	public Monster Mon;
	public boolean Disposable = false;
	public void Set(int dmg, int def, ArrayList<Status> buff, ArrayList<Status> debuff, int[] use, String name)
	{
		Dmg = dmg;
		Def = def;
		Buff = buff;
		DeBuff = debuff;
		Use = use;
		Name = name;
	}
	public void Copy(Pattern Target)
	{
		Dmg = Target.Dmg;
		Def = Target.Def;
		Buff = Target.Buff;
		DeBuff = Target.DeBuff;
		Use = Target.Use;
		Name = Target.Name;
	}
	public void Damage(int DMG)
	{
		GameStart.player.CHP -= DMG;
		System.out.println(DMG + "������!");
		if (GameStart.player.CHP <= 0)
			Stage.GameOver();
	}
	public void Guard(int DEF)
	{
		Mon.Shield += DEF;
		System.out.println(Mon.name + "�� " +DEF + "�� ȹ��!");
	}
	public void Buff(int num)
	{
		Mon.status.add(Buff.get(num));
		System.out.println(Mon.name + "�� " + Buff.get(num).name + "ȿ�� ȹ��!");
	}
	public void DeBuff(int num)
	{
		boolean isDeBuffed = false;
		for(int k = 0;k<GameStart.player.status.size();k++)
		{
			if(GameStart.player.status.get(k).name.equals(DeBuff.get(num).name))
			{
				GameStart.player.status.get(k).stack += DeBuff.get(num).stack;
				isDeBuffed = true;
				return;
			}
		}
		if (isDeBuffed == false)
			GameStart.player.status.add(DeBuff.get(num).GiveStatus());
		System.out.println(Mon.name + "�� ��ſ��� " + DeBuff.get(num).name + "ȿ�� �ο�!");
	}
	public void Use()
	{
		int DMG = Dmg;
		int DEF = Def;
		DMG += Mon.STR;
		DEF += Mon.DEX;
		int FDMG = DMG;
		int FDEF = DEF;
		for(int k = 0;k<Mon.status.size();k++)
		{
		if (Mon.status.get(k).name.equals("��ȭ"))
		{
			DMG -= (int) (FDMG/4);
			break;
		}
		}
		for(int k = 0;k<GameStart.player.status.size();k++)
		{
		if (GameStart.player.status.get(k).name.equals("���"))
		{
			DMG += (int) (FDMG/4);
			break;
		}
		}
		System.out.printf("%s�� %s��(��) ����ߴ�!\n", Mon.name, Name);
		for(int k = 0;k<Use[0];k++)
		{
			Damage(DMG);
		}
		for(int k = 0;k<Use[1];k++)
		{
			Guard(DEF);
		}
		for(int k = 0;k<Use[2];k++)
		{
			Buff(k);
		}
		for(int k = 0;k<Use[3];k++)
		{
			DeBuff(k);
		}
	}
}
