package java_data_product_project_2_1;

import javax.swing.ImageIcon;

import CombatSystem.CombatSystem;
import DeckSystem.Card;
import DeckSystem.Deck;
import TurnSystem.GameStart;

public class Card_Button extends BasicButton {
	public Card TempCard = null;

	public Card_Button(ImageIcon btn, ImageIcon btn_pressed) {
		super(btn, btn_pressed);
	}

	public void CardSelecting() {
		if (Other_Scene.choseweapon.get(0).IsInWeapon) {// �̰� ����
				if (CombatSystem.Check(TempCard, Other_Scene.selctedweapon.Con)) {
					
					Other_Scene.GameLog.append("����� ���� ����� ī�尡 ���� �ɶ��� ����Ѵ�. ī���� ���"+TempCard.shape+"\n");
				}
			}
		/*for (int wp_btn = 0; wp_btn < 6; wp_btn++) {
			
		}*/// �߰� �� �ݺ���
		
		
		System.out.print("�̰� ��µǸ� ī�� ��ư�� �Լ��� ȣ���\n");
		
	}

}
