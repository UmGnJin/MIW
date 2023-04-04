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
		if (Other_Scene.choseweapon.get(0).IsInWeapon) {// 이걸 웨펀
				if (CombatSystem.Check(TempCard, Other_Scene.selctedweapon.Con)) {
					
					Other_Scene.GameLog.append("무기와 같은 모양인 카드가 선택 될때만 출력한다. 카드의 모양"+TempCard.shape+"\n");
				}
			}
		/*for (int wp_btn = 0; wp_btn < 6; wp_btn++) {
			
		}*/// 추가 될 반복문
		
		
		System.out.print("이게 출력되면 카드 버튼의 함수가 호출됨\n");
		
	}

}
