package Sorting;

public class Sorter implements SortChallenge{
    public static void main(String args[])
    {
    	Sorter s = new Sorter();
int[] testArray = {24,12,8,12,19,12,8,4,24};
int[] sortedasc = s.simpleSort(testArray, true);
int[] sorteddesc =s.simpleSort(testArray, false);

		System.out.print("[");
       for(int i=0; i<testArray.length; i++)
       {
    	   if(i!=testArray.length-1)
    		   System.out.print(sortedasc[i]+ ", ");
    	   else
    		   System.out.print(sortedasc[i]+ "] ");
    		   
       }
       System.out.println("");
       System.out.print("[");
        for(int i=0; i<testArray.length; i++)
        {
           if(i!=testArray.length-1)
     		   System.out.print(sorteddesc[i]+ ", ");
     	   else
     		   System.out.print(sorteddesc[i]+ "] ");
    
        }
        System.out.println("");
        System.out.println("");
        s.printSortedFrequency(testArray);
        int unique =s.numberOfUniqueValues(testArray);
        System.out.println("\n"+unique +" Unique Values");
    }

    public int[] simpleSort(int[] list, boolean ascending)
    {
        for(int i=0; i<list.length-1; i++)
        {
            int min = i;
            for(int j =i+1; j<list.length; j++)
            {
                if(list[j] < list[min])
                {
                    min=j;
                }
            }
            //looks for index of smallest number in the sublist
            int temp = list[min];
            list[min]=list[i];
            list[i]= temp;
            //set the min number to temp  and swap min to first element of sublist
        }
        //if ascending is false reverse the list and return it
        if(ascending==false)
        {
           int[] reverselist = new int[list.length];
           int k=0;
           for(int i= list.length-1; i>=0; i--)
           {
               reverselist[k]=list[i];
               k++;
           }
           return reverselist;
        }


        return list;
    }
    public void printSortedFrequency(int[] list)
    {
     int[] list2 = simpleSort(list,true);
     int[] listwithoutdupe = removeDupe(list2); //list without duplicates using helper method
     int[] occurrence = new int[list.length]; //array to track occurrences
     for(int i=0; i<list2.length-1; i++)
     {
         int counter =1; 
         int number=list2[i]; //extract number from sorted list
        for(int j=i+1; j<list2.length; j++)
        {
         if(number== list2[j])
         {
             counter++;
         }
        }
        occurrence[i]=counter;
     }
     for(int k=0; k<listwithoutdupe.length; k++)
     {
         if(occurrence[k]==1)
             System.out.println(listwithoutdupe[k] + " appears " + occurrence[k] + " time");
         else
             System.out.println(listwithoutdupe[k] + " appears " + occurrence[k] + " times");
     }
     //using the list without duplicates 
     //print the occurrences from the original list of each value 
    }
    public int[] removeDupe(int[] list)
    {
      int[] tempArray = new int[list.length];
      int j=0;
      int removalcounter=0; 
      //after duplicate is removed list size remains same
      //so use tracker for how many times a duplicate is removed
      for(int i=0; i<list.length-1; i++)
      {
          int current = list[i];
          if(current !=list[i+1])
          {
              tempArray[j++]=current;
          }
          if(current==list[i+1])
          {
        	  removalcounter++;
          }
      }
      tempArray[j++]=list[list.length-1];
      int[] finalArray = new int[tempArray.length-removalcounter];
      for(int i=0; i<finalArray.length; i++)
      {
    	  finalArray[i]=tempArray[i];
      }
      //create a new array that has no duplicates and no remaining 0s
      return finalArray;
    }
    public int numberOfUniqueValues(int[] list)
    {
    	//call removedupe and return its length since it contains only unique values
        int[] tempArray = removeDupe(list);
        return tempArray.length;
    }
}
