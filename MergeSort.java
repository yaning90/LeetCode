public class MergeSort {
	private int[] array;
	private int[] tempArray;
	private int length;
	
	public static void main(String[] args){
		int[] inputArray={3,2,5,7,1};
		MergeSort ms = new MergeSort();
		ms.sort(inputArray);
		for(int i=0;i<inputArray.length;i++){
			//System.out.print(i);
			System.out.print(inputArray[i]);
		}
	}
	public void sort(int[] inputArray){
		this.array = inputArray;
		this.length= inputArray.length;
		this.tempArray = new int[length];
		doMergeSort(0,length-1);
	}
	private void doMergeSort(int low, int high){
		if(low<high){
			int middle = (low+high)/2;
			// Sort the left side of the array
			doMergeSort(low,middle);
			// Sort the right side of the array
			doMergeSort(middle+1,high);
			merge(low,middle,high);
		}
	}
	private void merge(int low, int middle, int high){
		for(int i=low;i<=high;i++){
			tempArray[i] = array[i];
		}
		int i = low;
		int j = middle+1;
		int k = low;
		while(i<=middle&&j<=high){
			if(tempArray[i]<= tempArray[j]){
				array[k]=tempArray[i];
				i++;
			}
			else{
				array[k]=tempArray[j];
				j++;
			}
			k++;
		}
		while(i<=middle){
			array[k] = tempArray[i];
			k++;
			i++;
		}
	}
}

