import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TimeSortAlg {
	public static ArrayList<Integer> arrayFromFile(String filename) throws IOException {
		File file = new File("C:\\Users\\Heather\\Documents\\Programming Projects\\Algorithms-and-Data-Structures\\Algorithms\\Sorting-Algorithms\\Java\\Sorting Alg\\"+filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));

		ArrayList<Integer> array = new ArrayList<Integer>();
		String number;
		while ((number = reader.readLine()) != null) {
			int num = Integer.parseInt(number);
			array.add(num);
		}
		reader.close();
		return array;
	}
	
	public static void TestSortingAlgorithms(int[] unsorted, int[] array) {
		Arrays.sort(unsorted);
		if (unsorted.equals(array)) {
			System.out.println("Sorted Correctly? true");
		}else {
			System.out.println("Sorted Correctly? false");
		}
	}
	
	public static int[] convertList(ArrayList<Integer> array) {
		int[] primitiveList = new int[array.size()];
		for (int i = 0; i < primitiveList.length; i++) {
			primitiveList[i] = array.get(i).intValue();
		}
		return primitiveList;
	}
	
	public static void TimeSortingAlgorithms(int[] array, String filename) {
		System.out.println("-------------------------------------------------");
		System.out.println("Time taken to sort (in nanoseconds) " + filename);
		System.out.println();
		
		Part1ATime(array);
		Part1BTime(array);
		Part1CTime(array);
		Part1DTime(array);
	}
	
	public static void Part1ATime(int[] array) {
		int[] unsorted = array;
		long time1 = System.nanoTime();
		Quicksort.quicksort(array, 0, array.length - 1);
		long time2 = System.nanoTime();
		String time = String.valueOf(time2 - time1);
		System.out.println("quicksort (partition): " + time);
		TestSortingAlgorithms(unsorted, array);

		System.out.println();
	}
	
	public static void Part1BTime(int[] array) {
		int[] unsorted = array;
		long time1 = System.nanoTime();
		QuickInsertion.quicksort(array, 0, array.length - 1, 2);
		long time2 = System.nanoTime();
		String time = String.valueOf(time2 - time1);
		System.out.println("quicksort (insertion sort): " + time);
		TestSortingAlgorithms(unsorted, array);
		
		System.out.println();
	}
	
	public static void Part1CTime(int[] array) {
		int[] unsorted = array;
		long time1 = System.nanoTime();
		QuickMedian.quicksort(array, 0, array.length - 1, 2);
		long time2 = System.nanoTime();
		String time = String.valueOf(time2 - time1);
		System.out.println("quicksort (median of three): " + time);
		TestSortingAlgorithms(unsorted, array);
		
		System.out.println();
	}
	
	public static void Part1DTime(int[] array) {
		int[] unsorted = array;
		long time1 = System.nanoTime();
		Quick3Way.quicksort(array, 0, array.length - 1);
		long time2 = System.nanoTime();
		String time = String.valueOf(time2 - time1);
		System.out.println("quicksort (3-way quicksort): " + time);
		TestSortingAlgorithms(unsorted, array);
		
		System.out.println();
	}
	


	public static void main(String[] args) throws IOException {
		ArrayList<String> files = new ArrayList<String>();
		files.add("int10.txt");
		files.add("int50.txt");
		files.add("int100.txt");
		//files.add("int1000.txt");
		//files.add("int20k.txt");
		//files.add("int500k.txt");
		//files.add("intBig.txt");
		//files.add("dutch.txt");
		for (String file : files) {
			ArrayList<Integer> array = arrayFromFile(file);
			TimeSortingAlgorithms(convertList(array), file);
		}
	}
}
