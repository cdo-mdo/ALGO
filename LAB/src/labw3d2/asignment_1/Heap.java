package labw3d2.asignment_1;

public class Heap {
	int size;
	int[] array;
	
	public Heap(int size) {
		this.size = size;
		array = new int[size + 1];
		array[0] = 0;
	}
	
	public int buildHeapTopdown() {
		int count = 0;
		for (int i = 1; i <= size; i++) {
			int val = (int)(Math.random()*100);
			array[i] = val;
			count += upHeap(array, i);
		}
		
		return count;
	}
	
	private int upHeap(int[] array, int num) {
		int count = 0;
		int i = num;
		while (i > 1) {
			count++;
			if (array[i] > array[i / 2]) {
				int temp = array[i];
				array[i] = array[i / 2];
				array[i / 2] = temp;
			}
			else {
				break;
			}
			i = i / 2;
		}
		return count;
	}
	
	public void print() {
		System.out.println();
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ", ");
			}
			else {
				System.out.print(array[i]);
			}
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		System.out.println(heap.buildHeapTopdown());
		heap.print();
	}
}
