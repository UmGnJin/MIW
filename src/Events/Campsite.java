package Events;

import java.util.Scanner;

import TurnSystem.GameStart;

public class Campsite extends Event{
	boolean Rest = false;
	boolean Delete = false;
	public void Use()
	{
		System.out.println("����� �� �߿����� �߰��ߴ�. ���� ��ں��� �ǿ� ���� �� �� ���� ��ġ�� �ִ�.");
		System.out.println("�ڼ��� ���� ����, ������ ��ġ�� ��ںҰ� ����Ǿ� ��ں��� ������ �۵����� �ʰ� �Ǵ� �� ����.");
		System.out.println("������ ��ġ�� �� ī�带 �ϳ� ������� �� ���� ������ ���Ա��� �޷� �ִ�. �ʿ���� ī�带 ó���ϴ� �͵� ���� �� ����.");
		System.out.println("������ ��ġ�� �۵��ϸ�, ����� ��ں� ������ ����� ���̴�.");
		System.out.println("������ �ұ�?");
		System.out.print("1.��ں��� �ǿ�� ����.(�ִ� ü���� 30%)ȸ��   2.��踦 �۵���Ų��.(������ ī�� 1�� ����)  999.�߿����� ������.");
			
		
	}
	public void Rest()
	{
		if (Rest == false)
		{
		GameStart.player.CHP += (int) (GameStart.player.MHP*0.3);
		System.out.println("����� ü���� ȸ���Ǿ���.");
		Rest = true;
		Delete = true;
		}
		else {
			System.out.println("���� ��ں��� �ǿ� ��ᰡ ����. �߿������� �� �̻� �� ���� ���� �� ����.");
		}
		Use();
	}
	public void Leave()
	{
		end = true;
		
	}
	public void DeleteCard()
	{
		if (Delete == false)
		{
			System.out.println("�̱����Դϴ�. gui�κ��� �ϼ��Ǹ� �߰��ϰڽ��ϴ�.");
		Delete = true;
		Rest = true;
		}
		else
		{
			System.out.println("���� ���� ��Ȱ��ȭ�Ǿ���. �� ���� �� �̻� �۵����� ���� ���̴�.");
		}
		Use();
	}
}
