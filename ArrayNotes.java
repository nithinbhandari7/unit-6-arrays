import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
terms to know
array - a homogeneous (data is all of the same type) and contiguous (elements are stored sequentially)
	list with a defined length
base type - the data type being stored in an array
array element - a single data point in an array
length - the number of elements in the array
index/subscript - what you can use to identify a particular array element
	valid indexes range from 0 to length-1
ArrayIndexOutOfBoundsException - the run time error that occurs when a programmer tries to
	access an element that doesn't exist (via an invalid index)
for each loop (enhanced for loop).  Can be used if:
	1. you don't need to modify array elements (using =)
	2. you don't need to refer to the index of an element for any reason
 */
public class ArrayNotes{
	public static void main(String[] args) throws FileNotFoundException {
		//array declaration
		boolean[] truthValues;
		String[] words;
		
		double[] floats = new double[10]; //allocates memory for an array
		System.out.println(Arrays.toString(floats));
		
		char[] letterGrades = {'a', 'b', 'c', 'd', 'e'};
		//length of an array can never be changed, only the values
		letterGrades[4] = 'f';
		System.out.println(letterGrades[4]);
		
		int[] values = getList("nums", 100);
		System.out.println(Arrays.toString(values));
		System.out.println("There are " + countEvens(values) + " even numbers in values.");
	}
	
	public static int[] getList(String fileName, int n) throws FileNotFoundException {
		int[] nums = new int[n];
		Scanner fileScan = new Scanner(new File(fileName));
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = fileScan.nextInt();
		}
		
		fileScan.close();
		return nums;
	}
	
	public static int countEvens(int[] ar) {
		int count = 0;
		
		//here temp gets assigned the value of each subsequent element in ar
		//for each iteration of the loop
		for(int temp : ar)
			if(temp % 2 == 0)
				count++;
		
		return count;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	public static int sum(int[] ar) {
		int sum = 0;
		for(int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}
		return sum;
	}
	
	public static double average(int[] ar) {
		return sum(ar)/(double)ar.length;
	}
	
	public static int indexOf(int[] ar, int target) {
		for(int i = 0; i < ar.length; i++) 
			if(ar[i] == target)
				return i;
		return -1;
	}
	
	public static int[] getDeepCopy(int[] ar) {
		int[] copy = new int[ar.length];
		for(int i = 0; i < ar.length; i++)
			copy[i] = ar[i];
		return copy;
	}
	
	public static int findMinElement(int[] ar) {
		int min = ar[0];
		for(int temp : ar)
			if(temp < min)
				min = temp;
		return min;
	}
	
	public static int findMinIndex(int[] ar) {
		int min = ar[0];
		int indx = 0;
		for(int i = 0; i < ar.length; i++)
			if(ar[i] < min) {
				ar[i] = min;
				indx = i;
			}
		return indx;
	}
	
	public static int[] reverse(int[] ar) {
		int[] reverse = new int[ar.length];
		for(int i = ar.length-1; i>=0; i--) {
			reverse[ar.length - i - 1] = ar[i];
		}
		return reverse;
	}
	
	public static void common(int[] ar, int[] ry) {
		for(int i = 0; i < ar.length; i++)
			for(int j = 0; j < ry.length; j++)
				if(ar[i] == ry[j])
					System.out.println(ar[i]);
	}
	
	public static boolean isAscending(int[] ar) {
		boolean tf = false;
		for(int i = 0; i < ar.length; i++)
			if(ar[i] < ar[i + 1]) 
				tf = true;
			else 
				tf = false;
		return tf;
	}
	
	public static int largeSmallDiff(int[] ar) {
		int min = ar[0];
		for(int i = 0; i < ar.length; i++)
			if(ar[i] < min)
				min = ar[i];
		
		int max = ar[0];
		for(int i = 0; i < ar.length; i++)
			if(ar[i] > max)
				max = ar[i];
		
		return max-min;
	}
	
	public static int maxDiff(int[] ar) {
		int maxDiff = 0;
		for(int i = 0; i < ar.length; i++)
			if(Math.abs(ar[i] - ar[i + 1]) > maxDiff)
				maxDiff = Math.abs(ar[i] - ar[i + 1]);
		return maxDiff;
	}
}

/*
EXAMPLES
1. write a function that returns an array filled with numbers from a file
2: count the number of even numbers that exist in an array of type int
3: public static int findMinElement(int[] arr)
4: public static int findMinIndex(int[] arr)
5: public static void squareContents(int[] arr)
6: public static void swap(int[] arr, int i, int j)
7: return the sum of an int array
8. return the average of an int array
9. find the index of the first occurrence of an element (return -1 if DNE)
10. create a deep copy of an array
11. return an array that is the reverse of an array of type int
12. print common elements between two arrays
13. return true if an array is in ascending order, false otherwise
14. return the difference between the largest and smallest values in an int array
15. find the max difference between consecutive values in an array
*/



/*
1) C
2) D
3) C
4) B
5) C
6) A
*/