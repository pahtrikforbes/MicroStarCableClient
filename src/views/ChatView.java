package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import client.Client;
import models.User;
import utils.CustomizedException;



public class ChatView extends JInternalFrame implements InternalFrameListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton sendMessage;
    private JTextField messageBox;
    private JTextArea chatBox;
    private JPanel mainPanel;
    private JPanel southPanel;
    private GridBagConstraints leftBoxContraints;
    private GridBagConstraints rightBoxContraints;
    private Client client;
    
    public ChatView() throws IOException {
    	super("Live Chat");
    	mainPanel = new JPanel();
    	southPanel = new JPanel();
    	sendMessage = new JButton("Send Message");
    	messageBox = new JTextField(30);
    	chatBox = new JTextArea();
    	leftBoxContraints = new GridBagConstraints();
    	rightBoxContraints = new GridBagConstraints();
        client = new Client();
        readMessage.start();
        showForm();
        
        BasicInternalFrameUI basic = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener li : basic.getNorthPane().getMouseListeners()) {
			basic.getNorthPane().removeMouseListener(li);
		}
    }
    
    public void createWindow()
    {
       //Setting properties of JInternalFrame; i.e this frame
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE); 
        
		
    }
    
    public void setLocationAndSize() {
    	this.mainPanel.setLayout(new BorderLayout());
    	this.southPanel.setLayout(new GridBagLayout());
    	this.southPanel.setBackground(Color.BLUE);
        this.mainPanel.setBounds(220, 5, 500, 600);
        this.messageBox.requestFocusInWindow();
        this.chatBox.setEditable(false);
        this.chatBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        this.chatBox.setLineWrap(true);
        
        //leftBoxContraints
        this.leftBoxContraints.anchor = GridBagConstraints.LINE_START;
        this.leftBoxContraints.fill = GridBagConstraints.HORIZONTAL;
        this.leftBoxContraints.weightx = 512.0D;
        this.leftBoxContraints.weighty = 1.0D;
        
        //rightBoxContraints
        this.rightBoxContraints.insets = new Insets(0, 10, 0, 0);
        this.rightBoxContraints.anchor = GridBagConstraints.LINE_END;
        this.rightBoxContraints.fill = GridBagConstraints.NONE;
        this.rightBoxContraints.weightx = 1.0D;
        this.rightBoxContraints.weighty = 1.0D;
    }
    
    public void addComponentsToFrame() {
    	
    	 mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);
    	 southPanel.add(messageBox, leftBoxContraints);
         southPanel.add(sendMessage, rightBoxContraints);
         mainPanel.add(BorderLayout.SOUTH, southPanel);
         this.add(mainPanel);
         sendMessage.addActionListener(this);
    }
    
    public void showForm() {
   	 this.createWindow(); 
   	 this.setLocationAndSize(); 
   	 this.addComponentsToFrame();
   }
    
 		
 		// readMessage thread
 		Thread readMessage = new Thread(new Runnable()
 		{
 			@Override
 			public void run() {

 				try {
					client.initDataStreams();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 				 while(true) {
		               String response;
						try {
							response = (String)client.getObjectInStream().readObject();
							if(response.equalsIgnoreCase("success")) {
								response = (String)client.getObjectInStream().readObject();
								 chatBox.append(response+"\n");
							}else {
								chatBox.append("Error while trying to send message.\n");
							}
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
		           }
			}
 		});

    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		User user = null;;
		if (messageBox.getText().length() < 1) {
            // do nothing
        } else if (messageBox.getText().equals(".clear")) {
        	 chatBox.setText("Cleared all messages\n");
             messageBox.setText("");
        } else {
            
            Client client = new Client();
            client.setOperation("chat");
            client.setEndPoint("chat");
            
            String message =  messageBox.getText();
            try {
				client.initDataStreams();
				client.getObjectOutStream().writeObject(client.getOperation());
				client.getObjectOutStream().writeObject(client.getEndPoint());
				client.getObjectOutStream().writeObject(message);
				
				String success = (String)client.getObjectInStream().readObject();
				
				if(success.equalsIgnoreCase("success")) {
					String responseMessage = (String)client.getObjectInStream().readObject();
					// messageBox.setText(responseMessage);
					 System.out.println(responseMessage);
				}
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        messageBox.requestFocusInWindow();
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

}
