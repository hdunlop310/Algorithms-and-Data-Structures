import java.util.Arrays;

public class Quicksort {
	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r ; j++) {
			if (A[j] <= x) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i+1, r);
		return i + 1;
	}
	
	public static void swap(int[] A, int l, int r) {
		int temp = A[l];
		A[l] = A[r];
		A[r] = temp;
	}

	public static void sort(int[] A, int p, int r) {
		if (p < r) {
			int q = sort(A, p, r);
			sort(A, p, q - 1);
			sort(A, q + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] A = { 6, 5, 0, 4, 1, 8, 3 };
		sort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}
}
