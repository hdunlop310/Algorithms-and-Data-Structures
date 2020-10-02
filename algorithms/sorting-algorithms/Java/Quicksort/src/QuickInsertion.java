import java.util.Arrays;

public class QuickInsertion {
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

	public static void insertionSort(int[] A) {
		int n = A.length;
		for (int j = 1; j < n; j++) {
			int key = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] > key) {
				A[i + 1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;
		}
	}

	public static void quicksort(int[] A, int p, int r, int k) {
		if (p < r) {
			if (r - p < k) {
				insertionSort(A);
			} else {
				int q = partition(A, p, r);
				quicksort(A, p, q - 1, k);
				quicksort(A, q + 1, r, k);
			}
		}
	}
	
	public static void swap(int[] A, int l, int r) {
		int temp = A[l];
		A[l] = A[r];
		A[r] = temp;
	}

	public static void main(String[] args) {
		int[] A = { 6, 5, 0, 4, 1, 8, 3 };
		quicksort(A, 0, A.length-1, 2);
		System.out.println(Arrays.toString(A));

	}
}
