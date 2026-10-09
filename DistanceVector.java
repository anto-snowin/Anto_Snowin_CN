import java.util.Scanner;
 
public class DistanceVector {
static final int INF = 999;
 
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
 
System.out.print("Enter number of routers: ");
int n = in.nextInt();
 
int[][] cost = new int[n][n];
int[][] dist = new int[n][n];
int[][] hop  = new int[n][n];
 
System.out.println("Enter cost matrix (use 999 for no direct link):");
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
cost[i][j] = in.nextInt();
dist[i][j] = cost[i][j];
hop[i][j] = (cost[i][j] < INF) ? j : -1;
}
}
 
// Every router repeatedly learns from its neighbours
boolean changed;
do {
changed = false;
for (int i = 0; i < n; i++) {
for (int nb = 0; nb < n; nb++) {
if (i == nb || cost[i][nb] >= INF) continue;
for (int j = 0; j < n; j++) {
if (dist[nb][j] >= INF) continue;
int viaNb = cost[i][nb] + dist[nb][j];
if (viaNb < dist[i][j]) {
dist[i][j] = viaNb;
hop[i][j] = nb;
changed = true;
}
}
}
}
} while (changed);
 
System.out.println("\nFinal Distance Vector Tables");
for (int i = 0; i < n; i++) {
System.out.println("\nRouter " + i);
System.out.println("Dest\tCost\tNext Hop");
for (int j = 0; j < n; j++) {
String via = (hop[i][j] == -1) ? "-" : String.valueOf(hop[i][j]);
String c = (dist[i][j] >= INF) ? "INF" : String.valueOf(dist[i][j]);
System.out.println(j + "\t" + c + "\t" + via);
}
}
in.close();
}
}
