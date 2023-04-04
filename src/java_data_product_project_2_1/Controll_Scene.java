package java_data_product_project_2_1;
import java.awt.*;
import javax.swing.*;

import TurnSystem.*;


public class Controll_Scene {

	public static int Screen_WID = 800;
	public static int Screen_HIGH = 600;
	public static JFrame fram = new JFrame();
	public static Main_menu panel01;
	public static Other_Scene panel02;
	
	public Controll_Scene( ) {
		
		//Color b = new Color(255,255,255);
		fram = new JFrame();
		panel01 = new Main_menu(fram);
		panel02= new Other_Scene(fram);
		
		fram.add(panel01);
	}
	
	public void SetScen() {
		
		
		fram.setUndecorated(true);
		//디폴트 UI를 제거
		fram.setBounds(0, 0, Screen_WID, Screen_HIGH);
		fram.setResizable(false);
		fram.setLocationRelativeTo(null);
		fram.setLayout(null);
		// 수정하는 좌표값 그대로 적용된다.
		fram.setBackground(new Color(0, 0, 0, 255));
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setVisible(true);	
	}
	
	public static void Change(JFrame jf, JPanel jp) {
		jf.getContentPane().removeAll();
		jf.getContentPane().add(jp);
		jf.revalidate();
		jf.repaint();
	}

}
