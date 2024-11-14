package labw3d2.asignment_1;

public class Heap {
	int size;
	int[] array;
	
	public Heap(int size) {
		this.size = size;
		array = new int[size];
	}
	
	public int buildHeapTopdown() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			int val = (int)(Math.random()*100);
			System.out.println("add " + val + " to position " + i);
			array[i] = val;
			count += upHeap(array, i);
		}
		
		return count;
	}
	
	private int upHeap(int[] array, int num) {
		int count = 0;
		int i = num;
		while (i > 0) {
			if (array[i / 2] < array[i]) {
				int temp = array[i];
				array[i] = array[i / 2];
				array[i / 2] = temp;
			}
			count++;
			i = i / 2;
		}
		System.out.println("num = " + num + " count = " + count);
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
