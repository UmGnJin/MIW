package java_data_product_project_2_1;

import javax.swing.ImageIcon;

import DeckSystem.Deck;
import StageSystem.CombatStage;
import TurnSystem.GameStart;

public class Enemy_Select extends BasicButton {
	String Enemy_Name = "";
	public Enemy_Select(ImageIcon btn, ImageIcon btn_pressed) {
		super(btn, btn_pressed);
	}
	public void EnemySelected () {
		if(Other_Scene.choseweapon.get(0).IsInWeapon) {
			Other_Scene.choseweapon.get(0).WeaponTemp.Use(0, 5);
			
		}
		System.out.print("���� �����մϴ�.\n");
	}
	
	public void LoadEnemy() {
		//Other_Scene.EnemySelectAry.clear();
		for(int i =0;i < GameStart.Enemy.size(); i++) {
			Other_Scene.EnemySelectAry.add(GameStart.Enemy.get(i).img);
		}
	}
	
	/*int sum = 0;
		RTU.clear();// ���õ� ī�� ����
		// ���õ� ī�带 ���꿡 �߰�
		for (int k = 0; k < Deck.Hand.size(); k++) {
			if (Deck.Hand.get(k).Picked == true) {
				sum += Deck.Hand.get(k).value;
				Deck.DiscardedCards.add(Deck.Hand.get(k));
				Deck.Hand.remove(k);
				k--;
			}

		}
		// ���⸦ ���, �Է� ��, ��� ��
		SelectedWeapon.Use(target - 1, sum);
		if (GameStart.Enemy.get(target - 1).CHP <= 0) {
			CombatStage.Die(target - 1);
			if (GameStart.Enemy.isEmpty() == true) {
				CombatStage.GameOver(true);
				return;
			}
		}
		EInfo();*/
	
}
