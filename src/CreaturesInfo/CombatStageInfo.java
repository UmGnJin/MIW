package CreaturesInfo;

import java.util.*;

import Creatures.Monster;
import StageSystem.*;
public class CombatStageInfo {
	static ArrayList<CombatStage> CombatStageList = new ArrayList<>();
	public static void LoadCombatStageInfo()
	{
		CombatStage St000= new CombatStage();//000 �����̵� â��*3
		St000.StageInfo(new int[] {0, 0, 0});
		CombatStageList.add(St000);
		
		CombatStage St001= new CombatStage();//001 ���̾� â��*3
		St001.StageInfo(new int[] {1, 1, 1});
		CombatStageList.add(St001);
		
		CombatStage St002= new CombatStage();//002 ��Ʈ â��*3
		St002.StageInfo(new int[] {2, 2, 2});
		CombatStageList.add(St002);
		
		CombatStage St003= new CombatStage();//003 Ŭ�ι� â��*3
		St003.StageInfo(new int[] {3, 3, 3});
		CombatStageList.add(St003);
		
		CombatStage St004= new CombatStage();//004  �����̵� ���к�*2+�����̵� â��*1
		St004.StageInfo(new int[] {4, 0, 4});
		CombatStageList.add(St004);
		
		CombatStage St005= new CombatStage();//005 ���̾Ƹ�� ���к�*2+���̾Ƹ�� â��*1
		St005.StageInfo(new int[] {5, 1, 5});
		CombatStageList.add(St005);
		
		CombatStage St006= new CombatStage();//006 ��Ʈ ���к�*2+��Ʈ â��*1
		St006.StageInfo(new int[] {6, 2, 4});
		CombatStageList.add(St006);
		
		CombatStage St007= new CombatStage();//007 Ŭ�ι� ���к�*2+Ŭ�ι� â��*1
		St007.StageInfo(new int[] {7, 3, 7});
		CombatStageList.add(St007);
		
		CombatStage St008= new CombatStage();//008 �����̵� ŷ *1
		St008.StageInfo(new int[] {8});
		CombatStageList.add(St008);
	}
	public static CombatStage GiveCombatStage(int num)
	{
		CombatStage CS = new CombatStage();
		CS.Copy(CombatStageList.get(num));
		return CS;
		
	}
}
