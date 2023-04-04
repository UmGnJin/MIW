package CreaturesInfo;

import java.util.ArrayList;

import Creatures.*;

public class WeaponInfo {
	public static ArrayList<Weapon> WeaponList = new ArrayList<>();
	public static void LoadWeaponInfo()
	{
		Weapon SpadeSpear = new Weapon();//000
		ArrayList<Status> DeBuff000 = new ArrayList<>();
		DeBuff000.add(new Status("���", 1));
		SpadeSpear.Set(5, 0, 0.5, 0, null, DeBuff000, new int[]{1, 0, 0, 1}, "�����̵� â");
		SpadeSpear.SetCondition(new String[] {"Spade"}, 0, true, true, false);
		SpadeSpear.ToolTip = "�����̵� ����� â���� �� ��� ������ ��� 1�� 5+(0.5 Spade)��ŭ ���ظ� �ݴϴ�.";
		WeaponList.add(SpadeSpear);
		
		Weapon DiamondSpear = new Weapon();//001
		ArrayList<Status> DeBuff001 = new ArrayList<>();
		DeBuff001.add(new Status("���", 1));
		DiamondSpear.Set(5, 0, 0.5, 0, null, DeBuff001, new int[]{1, 0, 0, 1}, "���̾Ƹ�� â");
		DiamondSpear.SetCondition(new String[] {"Diamond"}, 0, true, true, false);
		DiamondSpear.ToolTip = "���̾Ƹ�� ����� â���� �� ��� ������ ��� 1�� 5+(0.5 Diamond)��ŭ ���ظ� �ݴϴ�.";
		WeaponList.add(DiamondSpear);
		
		Weapon HeartSpear = new Weapon();//002
		ArrayList<Status> DeBuff002 = new ArrayList<>();
		DeBuff002.add(new Status("���", 1));
		HeartSpear.Set(5, 0, 0.5, 0, null, DeBuff002, new int[]{1, 0, 0, 1}, "��Ʈ â");
		HeartSpear.SetCondition(new String[] {"Heart"}, 0, true, true, false);
		HeartSpear.ToolTip = "��Ʈ ����� â���� �� ��� ������ ��� 1�� 5+(0.5 Heart)��ŭ ���ظ� �ݴϴ�.";
		WeaponList.add(HeartSpear);
		
		Weapon CloverSpear = new Weapon();//003
		ArrayList<Status> DeBuff003 = new ArrayList<>();
		DeBuff003.add(new Status("���", 1));
		CloverSpear.Set(5, 0, 0.5, 0, null, DeBuff003, new int[]{1, 0, 0, 1}, "Ŭ�ι� â");
		CloverSpear.SetCondition(new String[] {"Clover"}, 0, true, true, false);
		CloverSpear.ToolTip = "Ŭ�ι� ����� â���� �� ��� ������ ��� 1�� 5+(0.5 Clover)��ŭ ���ظ� �ݴϴ�.";
		WeaponList.add(CloverSpear);
		
		Weapon AceofWeapon = new Weapon();//004
		AceofWeapon.Set(1, 0, 14, 0, null, null, new int[]{1, 0, 0, 0}, "AoW");
		AceofWeapon.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 1, false, false, true);
		AceofWeapon.ToolTip = "���� �� �ϳ�����, '�ϳ�'���� ���� �����Դϴ�. �� ����� ���̽�(1) ī�常 ��� �����մϴ�. ������ 1+(14 Ace)��ŭ�� ���ظ� �ݴϴ�.";
		WeaponList.add(AceofWeapon);
		
		Weapon BeanShooter = new Weapon();//005
		BeanShooter.Set(2, 0, 2, 0, null, null, new int[]{2, 0, 0, 0}, "��� �߻��");
		BeanShooter.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 2, false, false, true);
		BeanShooter.ToolTip = "���� ���� �߻��մϴ�. ���� 2�� ī�常 ��� �����մϴ�. 2+(2*2) �������� �ݴϴ�. ���� ���� �߻��մϴ�. ���� 2�� ī�常 ��� �����մϴ�. 2+(2*2) �������� �ݴϴ�.";
		WeaponList.add(BeanShooter);
		
		Weapon MouseMedicine = new Weapon();//006
		ArrayList<Status> DeBuff006 = new ArrayList<>();
		DeBuff006.add(new Status("���", 1));
		MouseMedicine.Set(5, 0, 0, 0, null, DeBuff006, new int[]{0, 0, 0, 1}, "���");
		MouseMedicine.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 0, true, true, false);
		MouseMedicine.ToolTip = "����ε� ����� �ɾ��. �����̻��� �ƴ� �ƹ� ī�峪 ���� ���1�� �ɾ� �ݴϴ�. �� �常 �ᵵ �ȴٱ���!";
		WeaponList.add(MouseMedicine);
		
		Weapon Pla_stick = new Weapon();//007
		ArrayList<Status> DeBuff007 = new ArrayList<>();
		DeBuff007.add(new Status("��ȭ", 2));
		Pla_stick.Set(3, 0, 0.3, 0, null, DeBuff006, new int[]{1, 0, 0, 1}, "�ö�-��ƽ");
		Pla_stick.SetCondition(new String[] {"Spade", "Diamond", "Heart", "Clover"}, 0, true, true, false);
		Pla_stick.ToolTip = "�ö�ƽ ������Դϴ�. ������ �� �� ���� ������(?) ���� ����...������.... �ƹ� ī�峪 ��� �����մϴ�. ��󿡰� ��ȭ 2�� 3+(0.3 SUM) ���ظ� �ݴϴ�.";
		WeaponList.add(Pla_stick);
		
		Weapon RedStaff = new Weapon();//008
		ArrayList<Status> Buff008 = new ArrayList<>();
		Buff008.add(new Status("����ȸ��", 3));
		RedStaff.Set(0, 1, 0, 0.5, Buff008, null, new int[]{0, 1, 1, 0}, "���� ������");
		RedStaff.SetCondition(new String[] {"Diamond", "Heart"}, 0, true, true, false);
		RedStaff.ToolTip = "���̾Ƹ��� ��Ʈ�� ����� ��� �������Դϴ�. ���̾Ƹ��/��Ʈ ī�常 ��� �����ϸ�, 1+(0.5 RED)���� ��� ����ȸ�� 3�� ����ϴ�.";
		WeaponList.add(RedStaff);
		
		Weapon BlackStaff = new Weapon();//009
		ArrayList<Status> DeBuff009 = new ArrayList<>();
		DeBuff009.add(new Status("��", 3));
		BlackStaff.Set(1, 0, 0.5, 0, null, DeBuff009, new int[]{1, 0, 0, 1}, "���� ������");
		BlackStaff.SetCondition(new String[] {"Spade", "Clover"}, 0, true, true, false);
		BlackStaff.ToolTip = "�����̵�� Ŭ�ι��� ����� ��� �������Դϴ�. �����̵�/Ŭ�ι� ī�常 ��� �����ϸ�, 1+(0.5 BLACK)���ظ� �ְ� �� 3�� �ο��մϴ�.";
		WeaponList.add(BlackStaff);
		
		Weapon SpadeShield = new Weapon();//010
		ArrayList<Status> Buff010 = new ArrayList<>();
		Buff010.add(new Status("��� �¼�", 1));
		SpadeShield.Set(0, 5, 0, 0.5, Buff010, null, new int[]{0, 1, 1, 0}, "�����̵� ����");
		SpadeShield.SetCondition(new String[] {"Spade"}, 0, true, true, false);
		SpadeShield.ToolTip = "�����̵� ����� ���и� ��� 5+(0.5 Spade)���� ��� ��� �¼� ȿ���� ����ϴ�. ��� �¼��� ������ ��� ���� �ҽ��ϴ�.";
		WeaponList.add(SpadeShield);

		Weapon DiamondShield = new Weapon();//011
		ArrayList<Status> Buff011 = new ArrayList<>();
		Buff011.add(new Status("��� �¼�", 1));
		DiamondShield.Set(0, 5, 0, 0.5, Buff011, null, new int[]{0, 1, 1, 0}, "���̾Ƹ�� ����");
		DiamondShield.SetCondition(new String[] {"Diamond"}, 0, true, true, false);
		DiamondShield.ToolTip = "���̾Ƹ�� ����� ���и� ��� 5+(0.5 Diamond)���� ��� ��� �¼� ȿ���� ����ϴ�. ��� �¼��� ������ ��� ���� �ҽ��ϴ�.";
		WeaponList.add(DiamondShield);
		
		Weapon HeartShield = new Weapon();//012
		ArrayList<Status> Buff012 = new ArrayList<>();
		Buff012.add(new Status("��� �¼�", 1));
		HeartShield.Set(0, 5, 0, 0.5, Buff012, null, new int[]{0, 1, 1, 0}, "��Ʈ ����");
		HeartShield.SetCondition(new String[] {"Heart"}, 0, true, true, false);
		HeartShield.ToolTip = "��Ʈ ����� ���и� ��� 5+(0.5 Heart)���� ��� ��� �¼� ȿ���� ����ϴ�. ��� �¼��� ������ ��� ���� �ҽ��ϴ�.";
		WeaponList.add(HeartShield);
		
		Weapon CloverShield = new Weapon();//013
		ArrayList<Status> Buff013 = new ArrayList<>();
		Buff013.add(new Status("��� �¼�", 1));
		CloverShield.Set(0, 5, 0, 0.5, Buff013, null, new int[]{0, 1, 1, 0}, "Ŭ�ι� ����");
		CloverShield.SetCondition(new String[] {"Clover"}, 0, true, true, false);
		CloverShield.ToolTip = "Ŭ�ι� ����� ���и� ��� 5+(0.5 Clover)���� ��� ��� �¼� ȿ���� ����ϴ�. ��� �¼��� ������ ��� ���� �ҽ��ϴ�.";
		WeaponList.add(CloverShield);
	    
	}
	public static Weapon GiveWeapon(int num)
	{
		Weapon weapon = new Weapon();
		weapon.Copy(WeaponList.get(num));
		return weapon;
		
	}
}
