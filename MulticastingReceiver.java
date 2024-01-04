
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;

public class MulticastingReceiver 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		String group = args[0];
		
		//Open a Multicast socket on the specified port
		MulticastSocket ms = new MulticastSocket(5000);
		ms.joinGroup(InetAddress.getByName(group));
		
		byte[] buf = new byte[1024];
		
				
		//constructs a Datagram packet for receiving the packets of specified length
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		ms.receive(dp);
		String str = new String(dp.getData(),0,dp.getLength());
		
		System.out.println(str);
		
		DatagramPacket dp2 = new DatagramPacket(buf, 1024);
		
		ms.receive(dp2);
		String str2 = new String(dp2.getData(),0,dp2.getLength());
		
		System.out.println(str2);
		
		//leave the group
		ms.leaveGroup(InetAddress.getByName(group));

		//closing the Datagram Socket
		ms.close();

	}

}
