import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/** Insertion sort of an array
	 * 
	 * This is Question 3
	 * 
	 * TODO Where N is the number of elements in the array 'arr' the complexity is:
	 *
	 * O(?)
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {
		//initializing a boolean variable and assigning it true value
				boolean s = true;
				while (s == true) {
					s = false;
					//iterating through the array and sorting the list
					for (int i = 0; i < (arr.length-1); i++) {
						if (arr[i+1] < arr[i]) {
							int temp = arr[i + 1];
							arr[i+1]=arr[i];
							arr[i]=temp;
							s = true;
						}
					}
				}
			}


	/** Quick sort of an array. This method creates a new array with
	 * its values sorted, based on the values in the unsorted input array S.
	 * 
	 * This is Question 5
	 * 
	 * TODO Where N is the number of elements in the array 'S' the complexity is:
	 *
	 * O(?)
	 * 
	 * @param S the unsorted input array
	 * @return the sorted output array
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		//CHECKING THE SIZE OF THE ARRAY LIST AND THEN RETURNING IF THE SIZE IS LESS OR EQUAL TO 1
				if (S.size()<=1){
					return S;
				}
				//GETTING THE MIDDLE ELEMENT
				int middle = S.get(S.size()/2);
				//STORING THE ELEMENTS OF S THAT R LESS THAN THE MIDDLE
				ArrayList<Integer> less = new ArrayList<Integer>();
				//STORING THE ELEMENTS OF S THAT ARE EQUAL TO THE MIDDLE
				ArrayList<Integer> equal = new ArrayList<Integer>();
				//STORING OF ELEMENTS OF S THAT ARE MORE THAN THE MIDDLE
				ArrayList<Integer> greater = new ArrayList<Integer>();
				
				while (!S.isEmpty ()) {
					//DELETING THE FIRST ELEMENT
					int delete = S.get(0);
					S.remove(0);
					//IF THE DELETED ELEMENT IS LESSER THAN THE MIDDLE, THEN ADD IT TO LESS
					if (delete < middle) {
						less.add(delete);
					}
					//IF THE DELETED ELEMENT IS GREATER THAN THE PIVOT , THEN ADD IT TO THE GREATER
					else if (delete > middle) {
						greater.add(delete);
					}
					//IF THE DELETED ELEMENT IS EQUAL TO THE PIVOT , THEN ADD IT TO THE EQUAL
					else {
						equal.add(delete);
					}
				}
				//USING THE RECURSION TO SORT THE ELEMENTS IS THE ARRAY LESS AND GREATER
				quickSort(less);
				quickSort(greater);
				// ADDING ALL OF THE SUB ARRAYS IN THE S
				S.addAll(less);
				S.addAll(equal);
				S.addAll(greater);
				//RETURNING S
				return S;
			}
     /** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}
