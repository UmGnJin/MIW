package java_data_product_project_2_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Creatures.Monster;
import Creatures.Weapon;
import TurnSystem.GameStart;

public class Other_Scene extends JPanel {
	// ��� �̹��� ��¿� �ʿ��� ����
	private Image scnim;
	private Graphics scngp;
	
	// ��� �̹���, �Ŵ���
	private Image fstpanel = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/gamescene.png")).getImage();

	private JLabel menubar = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/label.png")));
	// ���� �ý��� �α� ���
	public static JTextArea GameLog = new JTextArea();
	private JScrollPane scroll = new JScrollPane(GameLog);
	//�÷��̾� �� ���� 
	private JLabel PlayerLabel = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/test.png")));
	private JLabel EnemyLabel = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/test.png")));
	private JLabel PlayerInfo = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/crature_inf.png")));
	private JLabel EnemyInfol = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/crature_inf.png")));
	/*
	private JLabel EnemyNameIcon = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/enemyname.png")));
	*/
	private JLabel EnemyName = new JLabel();
	
	// ���� ���� ��ư �� �ٸ� ����
	private static ImageIcon NextBtn = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/next.png"));
	private static ImageIcon NextBtn_pressed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/next_pressed.png"));
	
	private static Enemy_Select NextEnmey = new Enemy_Select(NextBtn, NextBtn_pressed); 
	
	private static ImageIcon PreBtn = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/pre.png"));
	private static ImageIcon PreBtn_pressed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/pre_pressed.png"));
	
	private static Enemy_Select PreEnmey = new Enemy_Select(PreBtn, PreBtn_pressed); 
	
	private static ImageIcon EmyNme = new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/enemyname.png"));
	private static ImageIcon EmyNme_pressed = new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/enemyname_pressed.png"));
	
	public static Enemy_Select chose_enemy =new Enemy_Select(EmyNme, EmyNme_pressed);
	
	public static ArrayList<ImageIcon> EnemySelectAry;
	
	// ���� ��ư
	private JLabel weapontable = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/weapontable.png")));

	private static ImageIcon defualtWeapon = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/weapon.png"));
	private static ImageIcon defualtWeapon_pressed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/weapon_pressed.png"));
	
	public static ArrayList<Weapon_Button> choseweapon = new ArrayList<>();
	public static Weapon selctedweapon;// = GameStart.player.Inventory.get(0); // ���� �ʿ�
	/*public static Weapon_Button[] choseweapon = {new Weapon_Button(defualtWeapon, defualtWeapon_pressed),*/
	
	// 
	/* ���⸦ ���� �� ���� �̹����� �޴´�,
	 * 
	*/
	// ���� ��ư�� ����
	private int wp_wd = 170;
	private int wp_hg = 120;
	private int wpwd_btwn = 20;
	private int wphg_btwn = 10;

	// ī�� ��ư
	private JLabel cardtable = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/cardtable.png")));
	
	private static ImageIcon defualtCard = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/card.png"));
	private static ImageIcon defualtCard_pressed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/card_pressed.png"));
	/* �ڵ尡 ���� �� ��
	 * deck.draw ���� �����Ͽ� �̹����� �߰�,
	 * ��ư�� ������ �� �ڵ� ������ �����ؼ� ���õȰ��� �ʱ�ȭ rtu�� �߰�,
	 * ���� ��ư�� �ٽ� ������ ���õ� false,
	 * ���� ��ư�� ������ ���� ����(���� �ʿ�)
	 * 
	 * 
	*/
	
	public static ArrayList<Card_Button> handcard = new ArrayList<>();
	/*public static Card_Button[] handcard = {
			new Card_Button(defualtCard, defualtCard_pressed),
	};*/
	
	// ī�� ��ư�� ����0
	private int card_wd = 40;
	private int card_hg = 62;
	private int card_btwn = 10;
	
	// ���� ���� ��ư
	private ImageIcon BTN = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN.png"));
	private ImageIcon BTNpreesed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN_preesed.png"));

	private JButton exitBTN0 = new JButton(BTN);
	private JButton exitBTN = new JButton(BTN);

	private int musX = 0, musY = 0;

	public Other_Scene(JFrame mf) {
		/*GameStart.NewStage.stage.StageStart();
		 * gamestartŬ�������� ������ ���� �Ѱ��� ���� ���� ���
		 * �� Ŭ�������� �Ͻ��� �Լ��� ȣ���Ѵ�.
		 * ���� ��ư�� Ȱ��ȭ �ǰ� �� �� �ڵ� ��ư�� ��Ȱ��ȭ
		 * ���� ���� �� ���� ��Ȱ��ȭ ī�� Ȱ��ȭ 
		 * ī��  ���� �� ������ ��ư ������ ȭ�鿡 ���õǾ� �ִ� ���Ϳ��� ���� ����
		 * ������ ����  sleep�Լ��� õõ�� �α׷� ��� �� �÷��̾��� ������ ��ȯ
		 *  */
		
		exitBTN.setBounds(655, 500, 145, 100);
		exitBTN.setBorderPainted(false);
		exitBTN.setContentAreaFilled(false);
		exitBTN.setFocusPainted(false);
		exitBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBTN.setIcon(BTNpreesed);
				exitBTN.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitBTN.setIcon(BTN);
				exitBTN.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//TurnSystem.TurnSystem.TurnStart();
			}

		});
		exitBTN0.setBounds(0, 500, 145, 100);
		exitBTN0.setBorderPainted(false);
		exitBTN0.setContentAreaFilled(false);
		exitBTN0.setFocusPainted(false);
		exitBTN0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBTN0.setIcon(BTNpreesed);
				exitBTN0.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitBTN0.setIcon(BTN);
				exitBTN0.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(100); // ����
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

		});
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				musX = e.getX();
				musY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				mf.setLocation(x - musX, y - musY); // �巡�׸� ������ ������ ����ó�� �ۿ���. �̵��ϴ� ���� �г��� �ƴ϶� ������
			}
		});
		chose_enemy.LoadEnemy();
		
		// �ý��� �α�
		scroll.setBounds(100, 10, 600, 80);
		add(scroll);// ��ũ�� ��ü
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);// ��ũ���� �ʿ� �Ҷ��� Ȱ��
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);// ���� ��ũ�� ��Ȱ��ȭ
        GameLog.setCaretPosition(GameLog.getDocument().getLength());// ��ũ���� �Ʒ��� ������
        GameLog.setEditable(false); // ����ڰ� �ؽ�Ʈ ��� �Ұ�
        
		// ������, �޴���
		add(exitBTN);
		add(exitBTN0);
		menubar.setBounds(0, 0, 800, 100);
		add(menubar);
		
		// �÷��̾� ���� �� �̹���
		PlayerLabel.setBounds(0, 100, 200, 300);
		add(PlayerLabel);
		PlayerInfo.setBounds(0, 400, 200, 100);
		add(PlayerInfo);
		
		// ���� ���� �� ����
		// ���� ȸ�� ��ư
		NextEnmey.setBounds(750, 100, 50, 50);
		add(NextEnmey);
		PreEnmey.setBounds(600, 100, 50, 50);
		add(PreEnmey);
		
		// ���� ���� ��ư
		EnemyName.setBounds(650, 100, 100, 50);
		EnemyName.setHorizontalAlignment(0);
		EnemyName.setFont(new Font("����",Font.PLAIN, 25));
		EnemyName.setForeground(Color.WHITE);
		EnemyName.setText("����0");
		add(EnemyName);
		chose_enemy.setBounds(650, 100, 100, 50);
		add(chose_enemy);
		
		// ���� �̹���, ����
		EnemyLabel.setBounds(600, 100, 200, 300);
		EnemyLabel.setIcon(EnemySelectAry.get(0));
		add(EnemyLabel);
		EnemyInfol.setBounds(600, 400, 200, 100);
		add(EnemyInfol);
		// ���� ����, ����
		for (int wphg = 0; wphg < 3; wphg++) {
			for (int wpwd = 0; wpwd < 2; wpwd++) {
				choseweapon.add(new Weapon_Button(defualtWeapon, defualtWeapon_pressed));
				choseweapon.get(wphg * 2 + wpwd).setBounds(200 + wpwd_btwn + (wpwd_btwn + wp_wd) * wpwd,
						110 + (wphg_btwn + wp_hg) * wphg, wp_wd, wp_hg);
				add(choseweapon.get(wphg * 2 + wpwd));
			}
		}
		//choseweapon.get(0).WeaponTemp = GameStart.player.Inventory.get(0); ���⼭�� �� ������ �ȵɱ�
		// ���� �ʿ�
		weapontable.setBounds(200, 100, 400, 400);
		add(weapontable);
		
		// ī�� ����Ʈ�� ī�� ��ư �߰� �� ��ġ
		for(int i = 0; i < 10; i++) {
			handcard.add(new Card_Button(defualtCard, defualtCard_pressed));
			handcard.get(i).setBounds(155 + ((card_btwn + card_wd) * i), 519, card_wd, card_hg);
			add(handcard.get(i));
		}
		
		// 10 62 10 62 10 62
		// 3 * 20 + 170 * = 400
		// 4 * 10+ 3 * 120 = 400

		cardtable.setBounds(145, 500, 510, 100);
		add(cardtable);
		setLayout(null);
		setBounds(0, 0, Controll_Scene.Screen_WID, Controll_Scene.Screen_HIGH);
		setVisible(true);
	}

	public void paint(Graphics g) {
		scnim = createImage(Controll_Scene.Screen_WID, Controll_Scene.Screen_HIGH);
		scngp = scnim.getGraphics();
		// ��ũ�� �̹����� �̿��ؼ� ��ũ�� ��ü�� ����
		scndw(scngp);
		g.drawImage(scnim, 0, 0, null);//
	}

	public void scndw(Graphics g) {
		g.drawImage(fstpanel, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
