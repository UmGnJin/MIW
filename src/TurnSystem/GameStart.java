package TurnSystem;
import java.util.*;
import CombatSystem.*;
import Creatures.*;
import CreaturesInfo.*;
import DeckSystem.*;
import Events.Merchant;
import StageSystem.CombatStage;
import java_data_product_project_2_1.*;
import map.*;


public class GameStart {
	public static Player player = new Player();
	//public static Node NewStage;
	public static ArrayList<Monster> Enemy = new ArrayList<>();
	//public static Controll_Scene ConScen = new Controll_Scene();
	public static MapMaker mm;
	public static map.MapMaker.Node Curnode;
	public static void main(String[] args)
	{
		Random random = new Random();
		//System.out.println("테스트 게임 : 콘솔창 텍스트로 진행합니다.");
		Deck.MakeDeck();
		PatternInfo.LoadPatternInfo();
		MonsterInfo.LoadMonsterInfo();	
		WeaponInfo.LoadWeaponInfo();
		StatusCardInfo.LoadStatusCardInfo();
		CombatStageInfo.LoadCombatStageInfo();
		player.Inventory.add(WeaponInfo.GiveWeapon(random.nextInt(4)));
		player.Inventory.add(WeaponInfo.GiveWeapon(random.nextInt(4)+10));
		MapMaker mm = new MapMaker();
		//Curnode = mm.NodeList.get(0).get(random.nextInt(3));
		Curnode = mm.NodeList.get(11).get(0);
		//ConScen.SetScen();
		Curnode.StageStart();
	}
	public static void Die(int k)
	{
		System.out.println(Enemy.get(k).name + "이(가) 쓰러졌다.");
		Enemy.remove(k);
	}
}
