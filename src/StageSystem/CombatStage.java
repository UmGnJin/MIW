package StageSystem;
import java.util.*;
import TurnSystem.*;
import Creatures.*;
import CreaturesInfo.*;
import CombatSystem.*;
import DeckSystem.*;
public class CombatStage extends Stage {
	ArrayList<Monster> EnemyList = new ArrayList<>();
	int[] enemyInfo;
	public void StageInfo(int[] enemy)
	{
		Deck.ShuffleDeck(Deck.StandardDeck.size());
		for(int k = 0;k<enemy.length;k++)
			EnemyList.add(MonsterInfo.GiveMonster(enemy[k]));
		enemyInfo = enemy;
	}
	public void StageStart()
	{
		for(int k = 0;k<EnemyList.size();k++)
			GameStart.Enemy.add(EnemyList.get(k));
		TurnSystem.TurnStart();
	}
	public void GameOver(boolean win)
	{
		if (win == true)
		{
			System.out.println("½Â¸®!");
			EnemyList.clear();
			NextStage();
		}
		else
		{
			System.out.println("ÆÐ¹è...");
		}
	}
	public void Copy(CombatStage Target)
	{
		StageInfo(Target.enemyInfo);
	}
	
}
