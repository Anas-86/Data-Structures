package Sorting_Algorithms;

public class Unknown {
    public static void main(String[] args) {
        int[] array = {5, 8, 1, 3, 0, -5, -23, 85, 3, -15, 45};

        System.out.println(array[search(array,5)]);
    }


    public static int search(int[] array, int value){
        int start=0;
        int end=array.length-1;
        boolean found=false;

        int m;
        if(array.length%2==0){
            m=(end-start)/2;
        }else{
            m=(int)((end-start)/2-0.5);
        }

        while(start<end && !found && (end-start)==1){


            if(array[m]==value){
                found=true;
            }else if(array[m]<value){
                start=m+1;
            }else {
                end=m;
            }
        }
        System.out.println(found);

        return m;
    }

}

