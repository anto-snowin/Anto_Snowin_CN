import java.util.Arrays;
import java.util.Scanner;
 
public class LinkState {
static final int INF = 9999;
 
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
 
System.out.print("Enter number of routers: ");
int n = in.nextInt();
 
int[][] graph = new int[n][n];
System.out.println("Enter cost matrix (0 = no link):");
for (int i = 0; i < n; i++)
for (int j = 0; j < n; j++)
graph[i][j] = in.nextInt();
 
System.out.print("Enter source router (0 to " + (n - 1) + "): ");
int src = in.nextInt();
if (src < 0 || src >= n) {
System.out.println("Invalid source router.");
return;
}
 
int[] dist = new int[n];
int[] prev = new int[n];
boolean[] done = new boolean[n];
Arrays.fill(dist, INF);
Arrays.fill(prev, -1);
dist[src] = 0;
 
for (int round = 0; round < n; round++) {
// pick the closest router not yet finalised
int u = -1;
for (int i = 0; i < n; i++)
if (!done[i] && (u == -1 || dist[i] < dist[u]))
u = i;
if (u == -1 || dist[u] == INF) break;
done[u] = true;
 
// relax the links of u
for (int v = 0; v < n; v++) {
if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
dist[v] = dist[u] + graph[u][v];
prev[v] = u;
}
}
}
 
System.out.println("\nShortest paths from router " + src + ":");
for (int i = 0; i < n; i++) {
if (dist[i] == INF) {
System.out.println(src + " -> " + i + " : unreachable");
continue;
}
StringBuilder path = new StringBuilder();
for (int x = i; x != -1; x = prev[x])
path.insert(0, x + (x == i ? "" : " -> "));
System.out.println(src + " -> " + i + " : cost = " + dist[i] + "   path: " + path);
}
in.close();
}
}
