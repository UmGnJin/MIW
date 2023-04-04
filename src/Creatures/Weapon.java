package Creatures;
import TurnSystem.*;
import Creatures.*;
import StageSystem.CombatStage;

import java.util.ArrayList;

import CombatSystem.*;

public class Weapon {
	public int Dmg, Def;
	public double Dmgx, Defx;
	public ArrayList<Status> Buff, DeBuff;
	public String ToolTip, Name;
	public Condition Con = new Condition();
	public int[] Use = {0, 0, 0, 0};
	public int Cost;
	public void Set(int dmg, int def, double dmgx, double defx, ArrayList<Status> buff, ArrayList<Status> debuff, int[] use, String name)
	{
		Dmg = dmg;
		Def = def;
		Dmgx = dmgx;
		Defx = defx;
		Buff = buff;
		DeBuff = debuff;
		Use = use;
		Name = name;
		Cost = (int) ((Dmg + Def)*(1+Dmgx+Defx));
	}
	public void SetCondition(String[] shape, int value, boolean higher, boolean same, boolean onlysame)
	{
		Con.Shape = shape;
		Con.Value = value;
		Con.Higher = higher;
		Con.Same = same;
		Con.OnlySame = onlysame;
	}
	public void Copy(Weapon Target)
	{
		Dmg = Target.Dmg;
		Def = Target.Def;
		Dmgx = Target.Dmgx;
		Defx = Target.Defx;
		Buff = Target.Buff;
		DeBuff = Target.DeBuff;
		Use = Target.Use;
		ToolTip = Target.ToolTip;
		Name = Target.Name;
		Con = Target.Con;
		Cost = Target.Cost;
	}
	public void Damage(Monster Target, int num)
	{
		Target.CHP -= num;
	}
	public void Guard(int num)
	{
		GameStart.player.Shield += num;
	}
	public void Buff(int num)
	{
		GameStart.player.status.add(Buff.get(num));
	}
	public void DeBuff(Monster Target, int num)
	{
		boolean isDeBuffed = false;
		for(int k = 0;k<Target.status.size();k++)
		{
			if(Target.status.get(k).name.equals(DeBuff.get(num).name))
			{
				Target.status.get(k).stack += DeBuff.get(num).stack;
				isDeBuffed = true;
				return;
			}
		}
		if (isDeBuffed == false)
			Target.status.add(DeBuff.get(num).GiveStatus());
	}
	public void Use(int num, int sum)
	{
		System.out.printf("플레이어는 %s을(를) 사용했다!\n", Name);
		int DMG = Dmg;
		int DEF = Def;
		int DMGx = (int) (sum*Dmgx);
		int DEFx = (int) (sum*Defx);
		DMG += DMGx;
		DEF += DEFx;
		DMG += GameStart.player.STR;
		DEF += GameStart.player.DEX;
		int FDMG = DMG;
		int FDEF = DEF;
		for(int k = 0;k<GameStart.player.status.size();k++)
		{
		if (GameStart.player.status.get(k).name.equals("약화"))
		{
			DMG -= (int) (FDMG/4);
			break;
		}
		}
		Monster Target = GameStart.Enemy.get(num);
		for(int k = 0;k<Target.status.size();k++)
		{
		if (Target.status.get(k).name.equals("취약"))
		{
			DMG += (int) (FDMG/4);
			System.out.println("취약 추가 데미지!");
			break;
		}
		}
		for(int k = 0;k<Use[0];k++)
		{
			Damage(Target, DMG);
			System.out.printf("%s에게  %d데미지!\n", Target.name, DMG);
		}
		for(int k = 0;k<Use[1];k++)
		{
			Guard(DEF);
			System.out.printf("%d 방어도 획득!\n", DEF);
		}
		for(int k = 0;k<Use[2];k++)
		{
			Buff(k);
			System.out.printf("%s 효과 획득!\n", Buff.get(k).name);
		}
		for(int k = 0;k<Use[3];k++)
		{
			DeBuff(Target, k);
			System.out.printf("%s에게  %s 효과 부여!\n", Target.name, DeBuff.get(k).name);
		}
	}
}
