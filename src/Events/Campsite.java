package Events;

import java.util.Scanner;

import TurnSystem.GameStart;

public class Campsite extends Event{
	boolean Rest = false;
	boolean Delete = false;
	public void Use()
	{
		System.out.println("당신은 한 야영지를 발견했다. 작은 모닥불을 피울 재료와 알 수 없는 장치가 있다.");
		System.out.println("자세히 살펴 보니, 마법적 장치는 모닥불과 연결되어 모닥불이 켜지면 작동하지 않게 되는 것 같다.");
		System.out.println("마법적 장치는 내 카드를 하나 집어넣을 수 있을 정도의 투입구가 달려 있다. 필요없는 카드를 처분하는 것도 좋을 것 같다.");
		System.out.println("마법적 장치가 작동하면, 연결된 모닥불 재료들이 사라질 것이다.");
		System.out.println("무엇을 할까?");
		System.out.print("1.모닥불을 피우고 쉰다.(최대 체력의 30%)회복   2.기계를 작동시킨다.(덱에서 카드 1장 제거)  999.야영지를 떠난다.");
			
		
	}
	public void Rest()
	{
		if (Rest == false)
		{
		GameStart.player.CHP += (int) (GameStart.player.MHP*0.3);
		System.out.println("당신의 체력이 회복되었다.");
		Rest = true;
		Delete = true;
		}
		else {
			System.out.println("이제 모닥불을 피울 재료가 없다. 야영지에서 더 이상 쉴 수는 없을 것 같다.");
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
			System.out.println("미구현입니다. gui부분이 완성되면 추가하겠습니다.");
		Delete = true;
		Rest = true;
		}
		else
		{
			System.out.println("기계는 이제 비활성화되었다. 이 기계는 더 이상 작동하지 않을 것이다.");
		}
		Use();
	}
}
