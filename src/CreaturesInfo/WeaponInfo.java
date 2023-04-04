package CreaturesInfo;

import java.util.ArrayList;

import Creatures.*;

public class WeaponInfo {
	public static ArrayList<Weapon> WeaponList = new ArrayList<>();
	public static void LoadWeaponInfo()
	{
		Weapon SpadeSpear = new Weapon();//000
		ArrayList<Status> DeBuff000 = new ArrayList<>();
		DeBuff000.add(new Status("취약", 1));
		SpadeSpear.Set(5, 0, 0.5, 0, null, DeBuff000, new int[]{1, 0, 0, 1}, "스페이드 창");
		SpadeSpear.SetCondition(new String[] {"Spade"}, 0, true, true, false);
		SpadeSpear.ToolTip = "스페이드 모양의 창으로 찔러 대상 적에게 취약 1과 5+(0.5 Spade)만큼 피해를 줍니다.";
		WeaponList.add(SpadeSpear);
		
		Weapon DiamondSpear = new Weapon();//001
		ArrayList<Status> DeBuff001 = new ArrayList<>();
		DeBuff001.add(new Status("취약", 1));
		DiamondSpear.Set(5, 0, 0.5, 0, null, DeBuff001, new int[]{1, 0, 0, 1}, "다이아몬드 창");
		DiamondSpear.SetCondition(new String[] {"Diamond"}, 0, true, true, false);
		DiamondSpear.ToolTip = "다이아몬드 모양의 창으로 찔러 대상 적에게 취약 1과 5+(0.5 Diamond)만큼 피해를 줍니다.";
		WeaponList.add(DiamondSpear);
		
		Weapon HeartSpear = new Weapon();//002
		ArrayList<Status> DeBuff002 = new ArrayList<>();
		DeBuff002.add(new Status("취약", 1));
		HeartSpear.Set(5, 0, 0.5, 0, null, DeBuff002, new int[]{1, 0, 0, 1}, "하트 창");
		HeartSpear.SetCondition(new String[] {"Heart"}, 0, true, true, false);
		HeartSpear.ToolTip = "하트 모양의 창으로 찔러 대상 적에게 취약 1과 5+(0.5 Heart)만큼 피해를 줍니다.";
		WeaponList.add(HeartSpear);
		
		Weapon CloverSpear = new Weapon();//003
		ArrayList<Status> DeBuff003 = new ArrayList<>();
		DeBuff003.add(new Status("취약", 1));
		CloverSpear.Set(5, 0, 0.5, 0, null, DeBuff003, new int[]{1, 0, 0, 1}, "클로버 창");
		CloverSpear.SetCondition(new String[] {"Clover"}, 0, true, true, false);
		CloverSpear.ToolTip = "클로버 모양의 창으로 찔러 대상 적에게 취약 1과 5+(0.5 Clover)만큼 피해를 줍니다.";
		WeaponList.add(CloverSpear);
		
		Weapon AceofWeapon = new Weapon();//004
		AceofWeapon.Set(1, 0, 14, 0, null, null, new int[]{1, 0, 0, 0}, "AoW");
		AceofWeapon.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 1, false, false, true);
		AceofWeapon.ToolTip = "세상에 단 하나뿐인, '하나'들을 위한 무기입니다. 각 모양의 에이스(1) 카드만 사용 가능합니다. 적에게 1+(14 Ace)만큼의 피해를 줍니다.";
		WeaponList.add(AceofWeapon);
		
		Weapon BeanShooter = new Weapon();//005
		BeanShooter.Set(2, 0, 2, 0, null, null, new int[]{2, 0, 0, 0}, "콩알 발사기");
		BeanShooter.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 2, false, false, true);
		BeanShooter.ToolTip = "콩을 콩콩 발사합니다. 숫자 2인 카드만 사용 가능합니다. 2+(2*2) 데미지를 줍니다. 콩을 콩콩 발사합니다. 숫자 2인 카드만 사용 가능합니다. 2+(2*2) 데미지를 줍니다.";
		WeaponList.add(BeanShooter);
		
		Weapon MouseMedicine = new Weapon();//006
		ArrayList<Status> DeBuff006 = new ArrayList<>();
		DeBuff006.add(new Status("취약", 1));
		MouseMedicine.Set(5, 0, 0, 0, null, DeBuff006, new int[]{0, 0, 0, 1}, "쥐약");
		MouseMedicine.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 0, true, true, false);
		MouseMedicine.ToolTip = "쥐약인데 취약을 걸어요. 상태이상이 아닌 아무 카드나 쓰면 취약1을 걸어 줍니다. 한 장만 써도 된다구요!";
		WeaponList.add(MouseMedicine);
		
		Weapon Pla_stick = new Weapon();//007
		ArrayList<Status> DeBuff007 = new ArrayList<>();
		DeBuff007.add(new Status("약화", 2));
		Pla_stick.Set(3, 0, 0.3, 0, null, DeBuff006, new int[]{1, 0, 0, 1}, "플라-스틱");
		Pla_stick.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 0, true, true, false);
		Pla_stick.ToolTip = "플라스틱 막대기입니다. 맞으면 알 수 없는 이유로(?) 점점 힘이...빠진다.... 아무 카드나 사용 가능합니다. 대상에게 약화 2와 3+(0.3 SUM) 피해를 줍니다.";
		WeaponList.add(Pla_stick);
		
		Weapon RedStaff = new Weapon();//008
		ArrayList<Status> Buff008 = new ArrayList<>();
		Buff008.add(new Status("지속회복", 3));
		RedStaff.Set(0, 1, 0, 0.5, Buff008, null, new int[]{0, 1, 1, 0}, "붉은 지팡이");
		RedStaff.SetCondition(new String[] {"Diamond", "Heart"}, 0, true, true, false);
		RedStaff.ToolTip = "다이아몬드와 하트의 기운이 담긴 지팡이입니다. 다이아몬드/하트 카드만 사용 가능하며, 1+(0.5 RED)방어도를 얻고 지속회복 3을 얻습니다.";
		WeaponList.add(RedStaff);
		
		Weapon BlackStaff = new Weapon();//009
		ArrayList<Status> DeBuff009 = new ArrayList<>();
		DeBuff009.add(new Status("독", 3));
		BlackStaff.Set(1, 0, 0.5, 0, null, DeBuff009, new int[]{1, 0, 0, 1}, "검은 지팡이");
		BlackStaff.SetCondition(new String[] {"Spade", "Clover"}, 0, true, true, false);
		BlackStaff.ToolTip = "스페이드와 클로버의 기운이 담긴 지팡이입니다. 스페이드/클로버 카드만 사용 가능하며, 1+(0.5 BLACK)피해를 주고 독 3을 부여합니다.";
		WeaponList.add(BlackStaff);
		
		Weapon SpadeShield = new Weapon();//010
		ArrayList<Status> Buff010 = new ArrayList<>();
		Buff010.add(new Status("방어 태세", 1));
		SpadeShield.Set(0, 5, 0, 0.5, Buff010, null, new int[]{0, 1, 1, 0}, "스페이드 방패");
		SpadeShield.SetCondition(new String[] {"Spade"}, 0, true, true, false);
		SpadeShield.ToolTip = "스페이드 모양의 방패를 들어 5+(0.5 Spade)방어도를 얻고 방어 태세 효과를 얻습니다. 방어 태세가 끝나면 모든 방어도를 잃습니다.";
		WeaponList.add(SpadeShield);

		Weapon DiamondShield = new Weapon();//011
		ArrayList<Status> Buff011 = new ArrayList<>();
		Buff011.add(new Status("방어 태세", 1));
		DiamondShield.Set(0, 5, 0, 0.5, Buff011, null, new int[]{0, 1, 1, 0}, "다이아몬드 방패");
		DiamondShield.SetCondition(new String[] {"Diamond"}, 0, true, true, false);
		DiamondShield.ToolTip = "다이아몬드 모양의 방패를 들어 5+(0.5 Diamond)방어도를 얻고 방어 태세 효과를 얻습니다. 방어 태세가 끝나면 모든 방어도를 잃습니다.";
		WeaponList.add(DiamondShield);
		
		Weapon HeartShield = new Weapon();//012
		ArrayList<Status> Buff012 = new ArrayList<>();
		Buff012.add(new Status("방어 태세", 1));
		HeartShield.Set(0, 5, 0, 0.5, Buff012, null, new int[]{0, 1, 1, 0}, "하트 방패");
		HeartShield.SetCondition(new String[] {"Heart"}, 0, true, true, false);
		HeartShield.ToolTip = "하트 모양의 방패를 들어 5+(0.5 Heart)방어도를 얻고 방어 태세 효과를 얻습니다. 방어 태세가 끝나면 모든 방어도를 잃습니다.";
		WeaponList.add(HeartShield);
		
		Weapon CloverShield = new Weapon();//013
		ArrayList<Status> Buff013 = new ArrayList<>();
		Buff013.add(new Status("방어 태세", 1));
		CloverShield.Set(0, 5, 0, 0.5, Buff013, null, new int[]{0, 1, 1, 0}, "클로버 방패");
		CloverShield.SetCondition(new String[] {"Clover"}, 0, true, true, false);
		CloverShield.ToolTip = "클로버 모양의 방패를 들어 5+(0.5 Clover)방어도를 얻고 방어 태세 효과를 얻습니다. 방어 태세가 끝나면 모든 방어도를 잃습니다.";
		WeaponList.add(CloverShield);
	    
	}
	public static Weapon GiveWeapon(int num)
	{
		Weapon weapon = new Weapon();
		weapon.Copy(WeaponList.get(num));
		return weapon;
		
	}
}
