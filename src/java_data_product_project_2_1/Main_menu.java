package java_data_product_project_2_1;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main_menu extends JPanel {
	private Image scnim;
	private Graphics scngp;

	private Image fstpanel = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/main.png")).getImage();

	private JLabel menubar = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/label.png")));

	private ImageIcon ExitBtnIcon = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN.png"));
	private ImageIcon ExitBtnPressedIcon = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN_preesed.png"));
	private ImageIcon TransBtnIcon = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN.png"));
	private ImageIcon TransBtnPreesedIcon = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN_preesed.png"));

	
	
	private JButton ExitBtn = new JButton(ExitBtnIcon);
	private JButton TransBtn = new JButton(ExitBtnIcon);
	
	private int musX = 0, musY = 0;

	public Main_menu(JFrame mf) {
		menubar.setBounds(0, 0, 800, 50);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.print("눌");
				musX = e.getX();
				musY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				mf.setLocation(x - musX, y - musY); // 드래그를 시작한 지점이 원점처럼 작용함. 이동하는 것은 패널이 아니라 프레임
			}
		});
		

		ExitBtn.setBounds(200, 200, 200, 100);
		ExitBtn.setBorderPainted(false);
		ExitBtn.setContentAreaFilled(false);
		ExitBtn.setFocusPainted(false);
		ExitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ExitBtn.setIcon(ExitBtnPressedIcon);
				ExitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ExitBtn.setIcon(ExitBtnIcon);
				ExitBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(100);					//지연
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

		});
		
		
		TransBtn.setBounds(200, 400, 200, 100);
		TransBtn.setBorderPainted(false);
		TransBtn.setContentAreaFilled(false);
		TransBtn.setFocusPainted(false);
		TransBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				TransBtn.setIcon(TransBtnPreesedIcon);
				TransBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				TransBtn.setIcon(TransBtnIcon);
				TransBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(100);					//지연
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				//버튼을 누르면 실행
				System.out.print("눌림");
				Controll_Scene.Change(mf, Controll_Scene.panel02);
			}

		});
		
		add(menubar);
		add(ExitBtn);
		add(TransBtn);

		setLayout(null);
		setBounds(0, 0, Controll_Scene.Screen_WID, Controll_Scene.Screen_HIGH);
		setVisible(true);
	}

	public void paint(Graphics g) {
		scnim = createImage(Controll_Scene.Screen_WID, Controll_Scene.Screen_HIGH);
		scngp = scnim.getGraphics();
		// 스크린 이미지를 이용해서 스크인 객체를 새성
		scndw(scngp);
		g.drawImage(scnim, 0, 0, null);//
	}

	public void scndw(Graphics g) {
		g.drawImage(fstpanel, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
