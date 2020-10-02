import java.util.Arrays;

public class Quick3Way {

	public static void quicksort(int[] A, int l, int r) {
		if (!(r <= l)) {
			int lessThan = l;
			int moreThan = r;
			int p = A[l];
			int i = l + 1;
			while(i <= moreThan) {
				if (p > A[i]) {
					swap(A, lessThan++, i++);
				}else if (p < A[i]) {
					swap(A, i, moreThan--);
				}else {
					i++;
				}
			}
			quicksort(A, l, lessThan-1);
			quicksort(A, moreThan+1, r);
		}
	}

	public static void swap(int [] A, int r, int l) {
		int temp;
		temp = A[r];
   		A[r] = A[l];
   		A[l] = temp;
	}
	public static void main (String[] args){
		int[] A = { 6, 5, 0, 4, 1, 8, 3 };
		quicksort (A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}
}
