// This is my code
// Nicole Schneider
// CS312

package default;

import java.util.*;
import java.io.*;
import java.lang.*;

public class QuickSort
{
  Integer [] myArray;
  
  public static void main(String args[])
  {
    ArrayList<Integer> myList = new ArrayList<Integer>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{
      Integer tempInteger;
      String str;
      while((str=br.readLine()) != null )
      {
        tempInteger = Integer.parseInt(str);
        myList.add(tempInteger);
      }
    }
    catch (IOException ioe)
    {
      System.out.println("IO Exception found!");
    }

    Integer [] myArray1 = new Integer [myList.size()];
    myArray1 = myList.toArray(myArray1);
    
    QuickSort qs = new QuickSort(myArray1);
    qs.recursiveQuickSort(0, myArray1.length - 1);

    qs.printArray();
  }
  
  public QuickSort(Integer [] arr)
  {
    this.myArray = arr;
  }

  public void printArray()
  {
    for (int x : myArray)
      System.out.println(x);
  }

  public void recursiveQuickSort(int indexA, int indexB)
  {
    int i = indexA;
    int j = indexB;
    int pivot = myArray[indexA + (indexB-indexA)/2];

    while (i <= j)
    {
      while (myArray[i] < pivot)
        i++;
      while (myArray[j] > pivot)
        j--;
      if (i <= j)
      {
        int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;

        i++;
        j--;
      }
    }
    if (indexA < j)
      recursiveQuickSort(indexA,j);
    if (i < indexB)
      recursiveQuickSort(i,indexB);
  }
}
