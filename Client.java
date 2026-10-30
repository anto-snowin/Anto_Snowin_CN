import java.io.*;
import java.net.*;
import java.net.InetAddress;
class Client {
    public static final int PORT = 4000;
    public static void main(String args[]) {
        Socket sock = null;
        PrintStream ps = null;
        System.out.println(" Trying to connect");
        try {
            sock = new Socket(InetAddress.getLocalHost(), PORT);
            ps = new PrintStream(sock.getOutputStream());
            ps.println(" Hi from client");
            BufferedReader is = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            System.out.println(is.readLine());
        } catch (SocketException e) {
            System.out.println("SocketException " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } finally {
            try {
                if (sock != null) {
                    sock.close();
                }
            } catch (IOException ie) {
                System.out.println(" Close Error :" + ie.getMessage());
            }
        }
    }
}
