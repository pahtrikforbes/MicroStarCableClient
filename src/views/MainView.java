package views;


import javax.swing.*;

public class MainView extends JFrame{
	private JMenu menu, menu2, menu3, menu4;
	private JButton logoutBtn;
	private JMenuBar menuBar;
	private JMenuItem i1, i2, i3, i4, i5, i6, i7;
	private JPanel panel;
	private JInternalFrame iframe;
	private JButton button1, button2;
	private JDesktopPane desktopPane;
  public static void main(String[] args) {
  MainView d = new MainView();
  }
  public MainView(){
	  super("Micro Star Cable");
	    menu  = new JMenu("Users");
		menu2 = new JMenu("Complaints");
		menu3 = new JMenu("Responses");
		menu4 = new JMenu("Accounts");
		menuBar = new JMenuBar();
		logoutBtn = new JButton("LOGOUT");
        
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  iframe = new JInternalFrame("Internal frame");
  iframe.setToolTipText("This is internal frame");
  panel = new JPanel();
  button1 = new JButton("Ok");
  button1.setToolTipText("This is Ok button of internal frame");
  panel.add(button1);
  button2 = new JButton("Cancel");
  button2.setToolTipText("This is cancel button of internal frame");
  panel.add(button2);
  iframe.add(panel);
  iframe.setSize(250,300);
  iframe.setVisible(true);
  desktopPane = new JDesktopPane();
  desktopPane.add(iframe);
  this.add(desktopPane);
  this.setSize(400,400);
  this.setVisible(true);
  }
}