package DeckSystem;

import javax.swing.ImageIcon;

public class Card {
		public String shape;
		public String num;
		ImageIcon img;
		public boolean Picked = false;
		public int value;
		public void Copy(Card Card)
		{
			shape = Card.shape;
			num = Card.num;
			img = Card.img;
			Picked = Card.Picked;
			value = Card.value;
		}
		public void Set(String Shape, String Num, ImageIcon Img, boolean picked, int Value)
		{
			shape = Shape;
			num = Num;
			img = Img;
			Picked = picked;
			value = Value;
		}
}

