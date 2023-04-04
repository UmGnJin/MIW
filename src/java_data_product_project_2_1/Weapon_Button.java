package java_data_product_project_2_1;

import javax.swing.ImageIcon;

import Creatures.Weapon;

public class Weapon_Button extends BasicButton {
	public Weapon WeaponTemp ;
	public Boolean IsInWeapon = false;
	public Weapon_Button(ImageIcon btn, ImageIcon btn_pressed) {
		super(btn, btn_pressed);
	}
	public void WeaponSelected() {
		Other_Scene.selctedweapon = WeaponTemp;
		IsInWeapon = true;
		TurnSystem.TurnSystem.HInfo();
		System.out.print(WeaponTemp.Name+" 이게 출력되면 무기 버튼의 함수가 호출됨\n");
	}
}
