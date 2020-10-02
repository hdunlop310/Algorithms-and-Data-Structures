import java.util.ArrayList;
import java.util.Arrays;

public class GenerateAlgSort {
	public static int generateRandomNumber(int min, int max) {
		double x = Math.random();
		int num = (int) (x * ((max - min) + 1)) + min;
		return num;
	}
	
	public static void TestSortingAlgorithms(int[] unsorted, int[] array) {
		Arrays.sort(unsorted);
		if (unsorted.equals(array)) {
			System.out.println("Sorted Correctly? true");
		}else {
			System.out.println("Sorted Correctly? false");
		}
	}
	

	public static ArrayList<Integer> generateArray() {
		ArrayList<Integer> array = new ArrayList<>();
		int noOfElements = generateRandomNumber(0, 10000);
		while (array.size() != noOfElements) {
			int element = generateRandomNumber(0, 10000);
			if (!array.contains(element)) {
				array.add(element);
			}
		}
		return array;
	}


	public static int[] convertList(ArrayList<Integer> array) {
		int[] primitiveList = new int[array.size()];
		for (int i = 0; i < primitiveList.length; i++) {
			primitiveList[i] = array.get(i).intValue();
		}
		return primitiveList;
	}

	public static int[] sortedOrReverse(int[] array) {
		int max = 2;
		int min = 1;
		double x = Math.random();
		int num = (int) (x * ((max - min) + 1)) + min;
		if (num == 1) {
			return insertionSortNormalReverse.insertionSortDecs(array);
		} else {
			return insertionSortNormalReverse.insertionSort(array);
		}
	}


	public static void main(String[] args) {
		ArrayList<Integer> array = generateArray();
		int[] arrayPrimative = convertList(array);
		int[] unsorted = arrayPrimative;
		int[] list = sortedOrReverse(arrayPrimative);
		QuickMedian.quicksort(list, 0, array.size() - 1, 2);
		TestSortingAlgorithms(unsorted, list);
		//System.out.println(Arrays.toString(list));
	}
}