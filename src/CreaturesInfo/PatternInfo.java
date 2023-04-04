package CreaturesInfo;

import java.util.ArrayList;
import Creatures.*;
public class PatternInfo {
	static ArrayList<Pattern> PatternList = new ArrayList<>();
	public static void LoadPatternInfo()
	{
		Pattern Poke= new Pattern();//000
		Poke.Set(7, 0, null, null, new int[] {1, 0, 0, 0}, "찌르기");
		PatternInfo.PatternList.add(Poke);
		
		Pattern ShieldGuard = new Pattern();//001
		ShieldGuard.Set(0, 7, null, null, new int[] {0, 1, 0, 0}, "방패 막기");
		PatternList.add(ShieldGuard);

		Pattern XinChao = new Pattern();//002
		XinChao.Set(5, 0, null, null, new int[] {3, 0, 0, 0}, "삼조격");
		PatternList.add(XinChao);
		
		Pattern ShieldBash = new Pattern();//003
		ArrayList<Status> DeBuff003 = new ArrayList<>();
		DeBuff003.add(new Status("어지러움", 1));
		ShieldBash.Set(3, 0, null, DeBuff003, new int[] {1, 0, 0, 1}, "방패 후려치기");
		PatternList.add(ShieldBash);
		
		Pattern Diamond = new Pattern();//004
		ArrayList<Status> Buff004 = new ArrayList<>();
		Buff004.add(new Status("금강", 999));
		Diamond.Set(0, 0, Buff004, null, new int[] {0, 0, 1, 0}, "금강");
		PatternInfo.PatternList.add(Diamond);
		
		Pattern PoketheWeakness= new Pattern();//005
		ArrayList<Status> DeBuff005 = new ArrayList<>();
		DeBuff005.add(new Status("약화", 1));
		PoketheWeakness.Set(7, 0, null, DeBuff005, new int[] {1, 0, 0, 1}, "약점 찌르기");
		PatternInfo.PatternList.add(PoketheWeakness);
		
	}
	public static Pattern GivePattern(int num)
	{
		Pattern PL = new Pattern();
		PL.Copy(PatternList.get(num));
		return PL;
	}
}
