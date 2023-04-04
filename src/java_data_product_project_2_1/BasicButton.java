package java_data_product_project_2_1;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BasicButton extends JButton {

	public ImageIcon BTN;
	public ImageIcon BTN_pressed;

	public BasicButton(ImageIcon btn, ImageIcon btn_pressed) {
		BTN = btn;
		BTN_pressed = btn_pressed;
		setIcon(BTN);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);

		addMouseListener(new ButtonEvent());

	}
	public void EnemySelected () {}
	public void CardSelecting() {}
	public void WeaponSelected() {}
	
	class ButtonEvent implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			EnemySelected();
			CardSelecting();
			WeaponSelected();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			setIcon(BTN_pressed);
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setIcon(BTN);
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

	}

}
