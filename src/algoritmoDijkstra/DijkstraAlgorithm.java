package algoritmoDijkstra;



	import java.util.*;
	public class DijkstraAlgorithm {
	
	    public static void dijkstra(int[][] graph, int startNode) {
	        int numNodes = graph.length;
	        int[] distance = new int[numNodes];
	        boolean[] visited = new boolean[numNodes];

	        // Inicializa todas las distancias como infinito y marca todos los nodos como no visitados
	        Arrays.fill(distance, Integer.MAX_VALUE);
	        Arrays.fill(visited, false);

	        // La distancia al nodo de inicio es siempre 0
	        distance[startNode] = 0;

	        for (int i = 0; i < numNodes - 1; i++) {
	            // Encuentra el nodo con la distancia mínima no procesada
	            int minNode = findMinNode(distance, visited);

	            // Marca el nodo como visitado
	            visited[minNode] = true;

	            // Actualiza las distancias de los nodos adyacentes al nodo actual
	            for (int j = 0; j < numNodes; j++) {
	                if (!visited[j] && graph[minNode][j] != 0 && distance[minNode] != Integer.MAX_VALUE
	                        && distance[minNode] + graph[minNode][j] < distance[j]) {
	                    distance[j] = distance[minNode] + graph[minNode][j];
	                }
	            }
	        }

	        // Imprime las distancias desde el nodo de inicio
	        printDistances(distance, startNode);
	    }

	    public static int findMinNode(int[] distance, boolean[] visited) {
	        int minDistance = Integer.MAX_VALUE;
	        int minNode = -1;

	        for (int i = 0; i < distance.length; i++) {
	            if (!visited[i] && distance[i] < minDistance) {
	                minDistance = distance[i];
	                minNode = i;
	            }
	        }

	        return minNode;
	    }

	    public static void printDistances(int[] distance, int startNode) {
	        System.out.println("Distancias desde el nodo " + startNode + " a todos los demás nodos:");
	        for (int i = 0; i < distance.length; i++) {
	            System.out.println("Nodo " + i + ": " + distance[i]);
	        }
	    }

	    public static void main(String[] args) {
	        // Ejemplo de un grafo ponderado representado como una matriz de adyacencia
	        int[][] graph = {
	            {0, 4, 0, 0, 0, 0, 0, 8, 0},
	            {4, 0, 8, 0, 0, 0, 0, 11, 0},
	            {0, 8, 0, 7, 0, 4, 0, 0, 2},
	            {0, 0, 7, 0, 9, 14, 0, 0, 0},
	            {0, 0, 0, 9, 0, 10, 0, 0, 0},
	            {0, 0, 4, 14, 10, 0, 2, 0, 0},
	            {0, 0, 0, 0, 0, 2, 0, 1, 6},
	            {8, 11, 0, 0, 0, 0, 1, 0, 7},
	            {0, 0, 2, 0, 0, 0, 6, 7, 0}
	        };

	        int startNode = 0;

	        dijkstra(graph, startNode);
	    }
	}



