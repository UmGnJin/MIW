package CreaturesInfo;
import java.util.*;

import javax.swing.ImageIcon;

import Creatures.*;
public class MonsterInfo {
	public static ArrayList<Monster> MonsterList = new ArrayList<>();
	public static void LoadMonsterInfo()
	{
		Monster SpadeSoilder = new Monster();//000
		SpadeSoilder.Set("스페이드 창병", 35, 35, 17);
		SpadeSoilder.pattern.add(PatternInfo.GivePattern(0));
		SpadeSoilder.pattern.get(0).Mon = SpadeSoilder;
		SpadeSoilder.pattern.add(PatternInfo.GivePattern(5));
		SpadeSoilder.pattern.get(1).Mon = SpadeSoilder;
		SpadeSoilder.img = new ImageIcon();
		MonsterList.add(SpadeSoilder);
		
		Monster DiamondSoilder = new Monster();//001
		DiamondSoilder.Set("다이아몬드 창병", 35, 35, 17);
		DiamondSoilder.pattern.add(PatternInfo.GivePattern(0));
		DiamondSoilder.pattern.get(0).Mon = DiamondSoilder;
		DiamondSoilder.pattern.add(PatternInfo.GivePattern(5));
		DiamondSoilder.pattern.get(1).Mon = DiamondSoilder;
		DiamondSoilder.img = new ImageIcon();
		MonsterList.add(DiamondSoilder);
		
		Monster HeartSoilder = new Monster();//002
		HeartSoilder.Set("하트 창병", 35, 35, 17);
		HeartSoilder.pattern.add(PatternInfo.GivePattern(0));
		HeartSoilder.pattern.get(0).Mon = HeartSoilder;
		HeartSoilder.pattern.add(PatternInfo.GivePattern(5));
		HeartSoilder.pattern.get(1).Mon = HeartSoilder;
		HeartSoilder.img = new ImageIcon();
		MonsterList.add(HeartSoilder);
		
		Monster CloverSoilder = new Monster();//003
		CloverSoilder.Set("클로버 창병", 35, 35, 17);
		CloverSoilder.pattern.add(PatternInfo.GivePattern(0));
		CloverSoilder.pattern.get(0).Mon = CloverSoilder;
		CloverSoilder.pattern.add(PatternInfo.GivePattern(5));
		CloverSoilder.pattern.get(1).Mon = CloverSoilder;
		CloverSoilder.img = new ImageIcon();
		MonsterList.add(CloverSoilder);
		
		Monster SpadeShielder = new Monster();//004
		SpadeShielder.Set("스페이드 방패병", 35, 35, 17);
		SpadeShielder.pattern.add(PatternInfo.GivePattern(1));
		SpadeShielder.pattern.add(PatternInfo.GivePattern(3));
		SpadeShielder.img = new ImageIcon();
		for(int k = 0;k<SpadeShielder.pattern.size();k++)
			SpadeShielder.pattern.get(k).Mon = SpadeShielder;
		MonsterList.add(SpadeShielder);
		
		Monster DiamondShielder = new Monster();//005
		DiamondShielder.Set("다이아몬드 방패병", 35, 35, 17);
		DiamondShielder.pattern.add(PatternInfo.GivePattern(1));
		DiamondShielder.pattern.add(PatternInfo.GivePattern(3));
		DiamondShielder.img = new ImageIcon();
		for(int k = 0;k<DiamondShielder.pattern.size();k++)
			DiamondShielder.pattern.get(k).Mon = DiamondShielder;
		MonsterList.add(DiamondShielder);

		Monster HeartShielder = new Monster();//006
		HeartShielder.Set("하트 방패병", 35, 35, 17);
		HeartShielder.pattern.add(PatternInfo.GivePattern(1));
		HeartShielder.pattern.add(PatternInfo.GivePattern(3));
		HeartShielder.img = new ImageIcon();
		for(int k = 0;k<HeartShielder.pattern.size();k++)
			HeartShielder.pattern.get(k).Mon = HeartShielder;
		MonsterList.add(HeartShielder);
		
		Monster CloverShielder = new Monster();//007
		CloverShielder.Set("클로버 방패병", 35, 35, 17);
		CloverShielder.pattern.add(PatternInfo.GivePattern(1));
		CloverShielder.pattern.add(PatternInfo.GivePattern(3));
		CloverShielder.img = new ImageIcon();
		for(int k = 0;k<CloverShielder.pattern.size();k++)
			CloverShielder.pattern.get(k).Mon = CloverShielder;
		MonsterList.add(CloverShielder);
		
		Monster DiamondKing = new Monster();//008
		DiamondKing.Set("다이아몬드 킹", 100, 100, 100);
		DiamondKing.pattern.add(PatternInfo.GivePattern(4));
		DiamondKing.pattern.add(PatternInfo.GivePattern(0));
		DiamondKing.pattern.get(1).Set(7, 0, null, null, new int[] {2, 0, 0, 0}, "연속 찌르기");
		DiamondKing.pattern.add(PatternInfo.GivePattern(5));
		DiamondKing.pattern.add(PatternInfo.GivePattern(5));
		DiamondKing.pattern.add(PatternInfo.GivePattern(5));
		DiamondKing.pattern.add(PatternInfo.GivePattern(5));
		DiamondKing.pattern.add(PatternInfo.GivePattern(5));
		DiamondKing.pattern.add(PatternInfo.GivePattern(2));
		DiamondKing.pattern.get(0).Disposable = true;
		for(int k = 0;k<DiamondKing.pattern.size();k++)
			DiamondKing.pattern.get(k).Mon = DiamondKing;
		DiamondKing.img = new ImageIcon();
		MonsterList.add(DiamondKing);
	}
	public static Monster GiveMonster(int num)
	{
		Monster Mon = new Monster();
		Mon.Copy(MonsterList.get(num));
		for(int k = 0;k<Mon.pattern.size();k++)
		{
			Mon.pattern.get(k).Mon = Mon;
		}
		return Mon;
		
	}

}
