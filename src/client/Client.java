package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private Socket socket;
	private String operation;
	private String endPoint;
	
	public Client() {
		try {
			this.socket = new Socket("localhost",3600);
			this.operation = "";
			this.endPoint = "";
			initDataStreams();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ObjectOutputStream getObjectOutStream() {
		return objectOutStream;
	}


	public void setObjectOutStream(ObjectOutputStream objectOutStream) {
		this.objectOutStream = objectOutStream;
	}


	public ObjectInputStream getObjectInStream() {
		return objectInStream;
	}

	public void setObjectInStream(ObjectInputStream objectInStream) {
		this.objectInStream = objectInStream;
	}

	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	private void initDataStreams() throws IOException{
		this.objectOutStream = new ObjectOutputStream(this.socket.getOutputStream());
		this.objectInStream = new ObjectInputStream(this.socket.getInputStream());
		
	}
	
}