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
	// 배경 이미지 출력에 필요한 변수
	private Image scnim;
	private Graphics scngp;
	
	// 배경 이미지, 매뉴바
	private Image fstpanel = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/gamescene.png")).getImage();

	private JLabel menubar = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/label.png")));
	// 게임 시스템 로그 출력
	public static JTextArea GameLog = new JTextArea();
	private JScrollPane scroll = new JScrollPane(GameLog);
	//플레이어 및 몬스터 
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
	
	// 몬스터 선택 버튼 및 다른 정보
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
	
	// 무기 버튼
	private JLabel weapontable = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/weapontable.png")));

	private static ImageIcon defualtWeapon = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/weapon.png"));
	private static ImageIcon defualtWeapon_pressed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/weapon_pressed.png"));
	
	public static ArrayList<Weapon_Button> choseweapon = new ArrayList<>();
	public static Weapon selctedweapon;// = GameStart.player.Inventory.get(0); // 조정 필요
	/*public static Weapon_Button[] choseweapon = {new Weapon_Button(defualtWeapon, defualtWeapon_pressed),*/
	
	// 
	/* 무기를 얻을 때 무기 이미지를 받는다,
	 * 
	*/
	// 무기 버튼의 정보
	private int wp_wd = 170;
	private int wp_hg = 120;
	private int wpwd_btwn = 20;
	private int wphg_btwn = 10;

	// 카드 버튼
	private JLabel cardtable = new JLabel(
			new ImageIcon(Controll_Scene.class.getResource("../java_data_product_project_2_1/images/cardtable.png")));
	
	private static ImageIcon defualtCard = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/card.png"));
	private static ImageIcon defualtCard_pressed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/card_pressed.png"));
	/* 핸드가 생성 될 때
	 * deck.draw 에서 접근하여 이미지를 추가,
	 * 버튼이 눌렸을 때 핸드 변수에 접근해서 선택된것을 초기화 rtu에 추가,
	 * 같은 버튼을 다시 누르면 선택됨 false,
	 * 공격 버튼을 누르면 몬스터 공격(구현 필요)
	 * 
	 * 
	*/
	
	public static ArrayList<Card_Button> handcard = new ArrayList<>();
	/*public static Card_Button[] handcard = {
			new Card_Button(defualtCard, defualtCard_pressed),
	};*/
	
	// 카드 버튼의 정보0
	private int card_wd = 40;
	private int card_hg = 62;
	private int card_btwn = 10;
	
	// 대충 만든 버튼
	private ImageIcon BTN = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN.png"));
	private ImageIcon BTNpreesed = new ImageIcon(
			Controll_Scene.class.getResource("../java_data_product_project_2_1/images/BTN_preesed.png"));

	private JButton exitBTN0 = new JButton(BTN);
	private JButton exitBTN = new JButton(BTN);

	private int musX = 0, musY = 0;

	public Other_Scene(JFrame mf) {
		/*GameStart.NewStage.stage.StageStart();
		 * gamestart클래스에서 정보를 정리 한것을 토대로 정보 출력
		 * 이 클래스에서 턴시작 함수를 호출한다.
		 * 무기 버튼이 활성화 되고 그 때 핸드 버튼은 비활성화
		 * 무기 선택 뒤 무기 비활성화 카드 활성화 
		 * 카드  선택 후 턴정료 버튼 누르면 화면에 선택되어 있는 몬스터에게 연산 적용
		 * 몬스터의 턴을  sleep함수로 천천히 로그로 띄운 뒤 플레이어의 턴으로 전환
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
					Thread.sleep(100); // 지연
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
				mf.setLocation(x - musX, y - musY); // 드래그를 시작한 지점이 원점처럼 작용함. 이동하는 것은 패널이 아니라 프레임
			}
		});
		chose_enemy.LoadEnemy();
		
		// 시스템 로그
		scroll.setBounds(100, 10, 600, 80);
		add(scroll);// 스크롤 객체
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);// 스크롤이 필요 할때만 활성
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);// 수평 스크롤 비활성화
        GameLog.setCaretPosition(GameLog.getDocument().getLength());// 스크롤을 아래로 내려줌
        GameLog.setEditable(false); // 사용자가 텍스트 편비 불가
        
		// 턴종료, 메뉴바
		add(exitBTN);
		add(exitBTN0);
		menubar.setBounds(0, 0, 800, 100);
		add(menubar);
		
		// 플레이어 정보 및 이미지
		PlayerLabel.setBounds(0, 100, 200, 300);
		add(PlayerLabel);
		PlayerInfo.setBounds(0, 400, 200, 100);
		add(PlayerInfo);
		
		// 몬스터 선택 및 정보
		// 몬스터 회전 버튼
		NextEnmey.setBounds(750, 100, 50, 50);
		add(NextEnmey);
		PreEnmey.setBounds(600, 100, 50, 50);
		add(PreEnmey);
		
		// 몬스터 선택 버튼
		EnemyName.setBounds(650, 100, 100, 50);
		EnemyName.setHorizontalAlignment(0);
		EnemyName.setFont(new Font("돋음",Font.PLAIN, 25));
		EnemyName.setForeground(Color.WHITE);
		EnemyName.setText("몬스터0");
		add(EnemyName);
		chose_enemy.setBounds(650, 100, 100, 50);
		add(chose_enemy);
		
		// 몬스터 이미지, 정보
		EnemyLabel.setBounds(600, 100, 200, 300);
		EnemyLabel.setIcon(EnemySelectAry.get(0));
		add(EnemyLabel);
		EnemyInfol.setBounds(600, 400, 200, 100);
		add(EnemyInfol);
		// 무기 정렬, 선택
		for (int wphg = 0; wphg < 3; wphg++) {
			for (int wpwd = 0; wpwd < 2; wpwd++) {
				choseweapon.add(new Weapon_Button(defualtWeapon, defualtWeapon_pressed));
				choseweapon.get(wphg * 2 + wpwd).setBounds(200 + wpwd_btwn + (wpwd_btwn + wp_wd) * wpwd,
						110 + (wphg_btwn + wp_hg) * wphg, wp_wd, wp_hg);
				add(choseweapon.get(wphg * 2 + wpwd));
			}
		}
		//choseweapon.get(0).WeaponTemp = GameStart.player.Inventory.get(0); 여기서는 왜 접근이 안될까
		// 조정 필요
		weapontable.setBounds(200, 100, 400, 400);
		add(weapontable);
		
		// 카드 리스트에 카드 버튼 추가 및 배치
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
		// 스크린 이미지를 이용해서 스크린 객체를 새성
		scndw(scngp);
		g.drawImage(scnim, 0, 0, null);//
	}

	public void scndw(Graphics g) {
		g.drawImage(fstpanel, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
