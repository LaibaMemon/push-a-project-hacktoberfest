import java.util.Arrays;
class BinarySearching{
	public static int binarySearch(char arr[],char x)
	{
		int lowerBound =0;
		int upperBound =arr.length-1;
		x = Character.toLowerCase(x);
		while(lowerBound<=upperBound){
			System.out.println("Inside");
			if(upperBound<lowerBound){
				System.out.println("Inside braek!");
				break;
			}
			int midpoint = lowerBound+(upperBound-lowerBound)/2;
			if(arr[midpoint]<x)
				lowerBound = midpoint+1;
			if(arr[midpoint]>x)
				upperBound = midpoint-1;
			if(arr[midpoint]==x)
				return midpoint;
		}
		System.out.println("Outside");
		return -1;
	}
	public static void main(String[] args) {
		char arr[]={'z','b','C','d','e'};
		for(int i=0;i<arr.length;i++)
			arr[i]=Character.toLowerCase(arr[i]);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		char find = 'c';
		int i = binarySearch(arr,find);
		if(i>-1)
			System.out.println("Index of "+find+" is : "+i);
		else
			System.out.println("Element not found in array!");
	}
}
