package driver;

import java.io.IOException;

import javax.swing.JFrame;

import views.ChatView;
import views.SplashScreen;

public class Driver {

	public static void main(String[] args) {
//		new SplashScreen();
		
		ChatView cv;
		try {
			cv = new ChatView();
			JFrame jf = new JFrame();
			jf.setSize(900,900);
			jf.setVisible(true);
			jf.add(cv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
