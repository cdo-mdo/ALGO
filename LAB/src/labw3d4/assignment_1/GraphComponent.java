package labw3d4.assignment_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphComponent {
	int[][] adjacencyMatrix;
	
	public GraphComponent(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
	
	public int getAllComponentsDFS() {
		int[] vertices = new int[adjacencyMatrix.length];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = 0;
		}
		int count = 0;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == 0) {
				count++;
				updateComponentDFS(vertices, i, count);
			} 
		}
		for (int i = 0; i < vertices.length; i++) {
			System.out.print(vertices[i] + " ");
		}
		System.out.println();
		return count;
	}
	
	private void updateComponentDFS(int[] arr, int pos, int count) {
		Stack<Integer> stack = new Stack<>();
		stack.push(pos);
		arr[pos] = count;
		while (!stack.isEmpty()) {
			int num = stack.pop().intValue();
			System.out.println("DEBUG-0 " + num);
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				int n = adjacencyMatrix[num][i];
				if (n != 0 && arr[i] == 0) {
					arr[i] = count;
					stack.push(i);
				}
			}
		}
	}
	
	public int getAllComponentsBFS() {
		int[] vertices = new int[adjacencyMatrix.length];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = 0;
		}
		int count = 0;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == 0) {
				count++;
				updateComponentBFS(vertices, i, count);
			} 
		}
		for (int i = 0; i < vertices.length; i++) {
			System.out.print(vertices[i] + " ");
		}
		System.out.println();
		return count;
	}
	
	private void updateComponentBFS(int[] arr, int pos, int count) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(pos);
		arr[pos] = count;
		while (!queue.isEmpty()) {
			int num = queue.poll().intValue();
			System.out.println("DEBUG-0 " + num);
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				int n = adjacencyMatrix[num][i];
				if (n != 0 && arr[i] == 0) {
					arr[i] = count;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{0, 1, 1, 0, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 0, 1},
			{1, 1, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 1, 1, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0, 0}
		};
		
		GraphComponent graph = new GraphComponent(matrix);
		System.out.println(graph.getAllComponentsDFS());
		
		System.out.println(graph.getAllComponentsBFS());
	}
}
