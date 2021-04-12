package views;

import javax.swing.*;

import loginregisterprompt.LoginRegisterPrompt;

import java.awt.*;

public class SplashScreen {
    JFrame frame;
    JLabel image=new JLabel(new ImageIcon("splashimage.jpeg"));
    JLabel text=new JLabel("Micro Star Cable Company Ltd");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    
    public SplashScreen()
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);

    }
    public void addImage(){
        image.setSize(600,200);
        frame.add(image);
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(70,220,600,40);
        text.setForeground(Color.WHITE);
        frame.add(text);
    }
    public void addMessage()
    {
        message.setBounds(250,320,200,40);
        message.setForeground(Color.WHITE);
        message.setFont(new Font("arial",Font.BOLD,15));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.gray);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("LOADING "+Integer.toString(i)+"%");
                i++;
                if(i==100) {
                	frame.dispose();
                	new LoginRegisterPrompt();
                } 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
