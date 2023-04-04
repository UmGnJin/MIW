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
		System.out.println(DMG + "데미지!");
		if (GameStart.player.CHP <= 0)
			Stage.GameOver();
	}
	public void Guard(int DEF)
	{
		Mon.Shield += DEF;
		System.out.println(Mon.name + "가 " +DEF + "방어도 획득!");
	}
	public void Buff(int num)
	{
		Mon.status.add(Buff.get(num));
		System.out.println(Mon.name + "가 " + Buff.get(num).name + "효과 획득!");
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
		System.out.println(Mon.name + "가 당신에게 " + DeBuff.get(num).name + "효과 부여!");
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
		if (Mon.status.get(k).name.equals("약화"))
		{
			DMG -= (int) (FDMG/4);
			break;
		}
		}
		for(int k = 0;k<GameStart.player.status.size();k++)
		{
		if (GameStart.player.status.get(k).name.equals("취약"))
		{
			DMG += (int) (FDMG/4);
			break;
		}
		}
		System.out.printf("%s는 %s을(를) 사용했다!\n", Mon.name, Name);
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
