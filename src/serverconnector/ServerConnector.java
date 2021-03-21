package serverconnector;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnector {

	public Socket getSocket() throws UnknownHostException, IOException {
	return	new Socket("localhost",3600);
	}
}
