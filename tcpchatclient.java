import java.io.*;
import java.net.*;
class tcpchatclient {
    public static void main(String args[]) throws Exception {
        Socket Clt;
        PrintWriter toServer;
        BufferedReader fromUser, fromServer;
        try {
            Clt = new Socket(InetAddress.getLocalHost(), 4000);
            toServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(Clt.getOutputStream())), true);
            fromServer = new BufferedReader(new InputStreamReader(Clt.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));
            String CltMsg, SrvMsg;
            System.out.println("Type \"end\" to Quit");
            while (true) {
                System.out.print("Message to Server : ");
                CltMsg = fromUser.readLine();
                toServer.println(CltMsg);
                if (CltMsg == null || CltMsg.equalsIgnoreCase("end"))
                    break;
                SrvMsg = fromServer.readLine();
                if (SrvMsg == null || SrvMsg.equalsIgnoreCase("end"))
                    break;
                System.out.println("Server : " + SrvMsg);
            }
            System.out.println("\nDisconnected");
            toServer.close();
            fromServer.close();
            fromUser.close();
            Clt.close();
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
    }
}
