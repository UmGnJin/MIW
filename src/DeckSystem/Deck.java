package DeckSystem;
import java.util.*;
public class Deck
{
	
	public static ArrayList<Card> StandardDeck = new ArrayList<>();
	public static ArrayList<Card> DiscardedCards = new ArrayList<>();
	public static ArrayList<Card> Hand = new ArrayList<>();
	public static void MakeDeck()
	
	{
		String Shape = "";
		for(int i=0;i<4;i++)
		{
			switch(i)
			{
			case 0:
				Shape = "Spade";
				break;
			case 1:
				Shape = "Diamond";
				break;
			case 2:
				Shape = "Heart";
				break;
			case 3:
				Shape = "Clover";
				break;
			default:
			}
			for(int j=1;j<14;j++)
			{
				Card card = new Card();
				card.shape = Shape;
				card.value = j;
				switch(j)
				{
				case 11:
					card.num = "J";
					break;
				case 12:
					card.num = "Q";
					break;
				case 13:
					card.num = "K";
					break;
				case 1 : 
					card.num = "A";
					break;
				default:
					card.num = "" + j;
				}
				StandardDeck.add(card);
			}
		}
		ShuffleDeck(52);
	}
	public static void EndShuffle()
	{
		StandardDeck.addAll(DiscardedCards);
		ShuffleDeck(StandardDeck.size());
		DiscardedCards.clear();
	}
	public static void ShuffleDeck(int num)
	{
		Collections.shuffle(StandardDeck);
	}
	public static void DrawCard()
	{
		if (StandardDeck.size() == 0)
		{
			StandardDeck.addAll(DiscardedCards);
			ShuffleDeck(StandardDeck.size());
			DiscardedCards.clear();
			System.out.println("버린 카드 섞음");
		}
		if (Hand.size()==10)
		{
			System.out.println("오류 : 패는 최대 10장입니다.");
		}
		else
		{
			Hand.add(StandardDeck.get(0));
			StandardDeck.remove(0);
		}
	}
	public static void DisCard()
	{
		for(int a=0;a<Hand.size();a++)
		{
			DiscardedCards.add(Hand.get(a));
		}
		Hand.clear();
	}
}
