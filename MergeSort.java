// This is my code
// Nicole Schneider
// CS312

package default;

import java.io.*;
import java.util.*;
import java.lang.*;

public class MergeSort
{
  protected Integer [] myArray;
  protected Integer [] tempArray;
  protected int length;

  public static void main(String args[])
  {
    ArrayList<Integer> myList = new ArrayList<Integer>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{
      Integer tempInteger;
      String str;
      while((str=br.readLine()) != null)
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


    MergeSort myMerge = new MergeSort();

    myArray1 = myMerge.sort(myArray1);
    for (int x : myArray1)
      System.out.println(x);
  }

  public Integer [] sort(Integer [] myArray1)
  {
    this.myArray = myArray1;
    this.length = myArray1.length;
    this.tempArray = new Integer [myArray1.length];
    recursiveMerge(0, length-1);
    return myArray1;
  }

  private void recursiveMerge(int lowerIndex, int higherIndex)
  {  
    if (lowerIndex < higherIndex)
    {
      int middle = lowerIndex + (higherIndex - lowerIndex)/2;
      recursiveMerge(lowerIndex, middle); // sort left
      recursiveMerge(middle + 1, higherIndex); // sort right
      mergeParts(lowerIndex, middle, higherIndex);
    }
  }
 
  private void mergeParts(int lowerIndex, int middle, int higherIndex)
  {
      for (int i = lowerIndex; i <= higherIndex; i++)
        tempArray[i] = myArray[i]; 

      int i = lowerIndex;
      int j = middle + 1;
      int k = lowerIndex;

      while (i <= middle && j <= higherIndex)
      {
       if (tempArray[i] <= tempArray[j])
       {
         myArray[k] = tempArray[i];
         i++;
       }
       else
       {
         myArray[k] = tempArray[j];
         j++;
       }
       k++;
     }
    
     while (i <= middle)
     {
       myArray[k] = tempArray[i];
       k++;
       i++;
     }  
  }
}
