package Sorting_Algorithms;

//selection sort
public class Training {
    static void quickStart(int[] input,int start,int end){
        if(end-start<2)
            return;
        int pivotIndex=partition(input,start,end);
        quickStart(input,start,pivotIndex);
        quickStart(input,pivotIndex+1,end);
    }

    private static int partition(int[] input,int start,int end){
        int pivot=input[start];
        int i=start;
        int j=end;
        while(i<j){
            while(i<j && input[--j]>=pivot);
            if(i<j)
                input[i]=input[j];
            while(i<j && input[++i]<=pivot);
            if(i<j)
                input[j]=input[i];
        }
        input[i]=pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] intArray = { -15, 23, 65, 22, 51, -5, 0 };
        quickStart(intArray,0,intArray.length);
        for(int e:intArray)
            System.out.println(e);
    }
}
