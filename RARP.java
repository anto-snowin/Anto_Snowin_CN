import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class RARP {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
 
// RARP table : MAC address -> IP address
Map<String, String> rarpTable = new HashMap<>();
rarpTable.put("AA:BB:CC:DD:EE:01", "192.168.1.1");
rarpTable.put("AA:BB:CC:DD:EE:02", "192.168.1.2");
rarpTable.put("AA:BB:CC:DD:EE:03", "192.168.1.3");
 
System.out.print("Enter the MAC address: ");
String macAddr = in.nextLine().trim().toUpperCase();
 
if (rarpTable.containsKey(macAddr)) {
System.out.println("Resolved IP Address: " + rarpTable.get(macAddr));
} else {
System.out.println("No entry found for the MAC address " + macAddr);
}
 
in.close();
}
}
