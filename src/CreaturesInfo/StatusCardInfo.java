package CreaturesInfo;

import java.util.ArrayList;

import Creatures.Pattern;
import Creatures.Status;
import DeckSystem.Card;

public class StatusCardInfo {
	static ArrayList<Card> StatusCardList = new ArrayList<>();
	public static void LoadStatusCardInfo()
	{
		Card Dizziness = new Card();//000
		Dizziness.Set("어지러움", "", null, false, 0);
		StatusCardList.add(Dizziness);
	}
	public static Card GiveStatusCard(int num)
	{
		Card SC = new Card();
		SC.Copy(StatusCardList.get(num));
		return SC;
	}
}
