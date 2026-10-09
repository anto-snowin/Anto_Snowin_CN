import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class ARP {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
 
// ARP table : IP address -> MAC address
Map<String, String> arpTable = new HashMap<>();
arpTable.put("192.168.1.1", "AA:BB:CC:DD:EE:01");
arpTable.put("192.168.1.2", "AA:BB:CC:DD:EE:02");
arpTable.put("192.168.1.3", "AA:BB:CC:DD:EE:03");
 
System.out.print("Enter the IP address: ");
String ipAddr = in.nextLine().trim();
 
if (arpTable.containsKey(ipAddr)) {
System.out.println("Resolved MAC Address: " + arpTable.get(ipAddr));
} else {
System.out.println("No entry found for the IP address " + ipAddr);
}
 
in.close();
}
}

