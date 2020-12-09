
import java.io.IOException;
import java.util.Random;

public class QuickSort 
{ 
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
    // Driver program 
    public static void main(String args[]) throws IOException 
    { 
        DataView dv = new DataView();
        DataInput di = new DataInput();

        System.out.println("Enter number of array:");
        int length = 0;
        length = di.getInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }
        dv.printArray(arr, dv.message[0]);
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, length-1);       
        //System.out.println("sorted array"); 
        dv.printArray(arr, dv.message[1]);
    } 
} 



import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chung
 */
public class DataInput {
    Scanner sc = new Scanner(System.in);


    public int getInt() throws IOException  {
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if(number>0){
                break;
                }
                else{
                System.out.println("Please input number > 0");
                }
                    
            } catch (NumberFormatException e) {
             System.out.println("Please input number");
            }
        }
        return number;
    }
}


