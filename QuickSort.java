public class QuickSort {
	private int[] array;
	private int length;
	
	public static void main(String[] args){
		int[] inputArray={3,2,5,7,1};
		QuickSort qs = new QuickSort();
		qs.sort(inputArray);
		for(int i=0; i<inputArray.length;i++){
			System.out.print(inputArray[i]);
		}	
	}
	
	public void sort(int[] inputArray){
		if(inputArray == null || inputArray.length==0) return;
		this.array = inputArray;
		this.length = inputArray.length;
		quickSort(0,length-1);
		
	}
	
	public void quickSort(int low, int high){
		int i = low;
		int j = high;
		//take the middle element as pivot number
		int pivot = array[(low+high)/2];
		//Divide into two arrays
		while(i<=j){
			while(array[i]<pivot){
				i++;
			}
			while(array[j]>pivot){
				j--;
			}
			if(i<=j){
				int t = array[i];
				array[i] = array[j];
				array[j] = t;
				i++;
				j--;
			}
		}
		if(low<j) quickSort(low,j);  
		if(i<high) quickSort(i,high);
	}
}

