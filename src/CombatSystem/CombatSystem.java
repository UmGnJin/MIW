package CombatSystem;
import DeckSystem.*;

public class CombatSystem {
	public static boolean Check(Card card, Condition con)
	{
		boolean SC = false;
		boolean NC = false;
		for(int k = 0;k<con.Shape.length;k++)
		{
			if (card.shape.equals(con.Shape[k]))
			{
				SC = true;
				break;
			}
			SC = false;
		}
		if (con.OnlySame == true)
		{
			if (card.value == con.Value)
				NC = true;
			else
				NC = false;
		}
		else if (con.Higher == true)
		{
			if (con.Same == true)
			{
				if (card.value >= con.Value)
					NC = true;
				else
					NC = false;
			}
			else
			{
				if (card.value > con.Value)
					NC = true;
				else
					NC = false;
			}
		}
		else if (con.Higher == false)
		{
			if (con.Same == true)
			{
				if (card.value <= con.Value)
					NC = true;
				else
					NC = false;
			}
			else
			{
				if (card.value < con.Value)
					NC = true;
				else
					NC = false;
			}
		}
		if (SC == true && NC == true)
			return true;
		else
			return false;
	}
}
