/**********************************************
Author: Patrick Vandergrift
Date: Oct. 3rd, 2026
Description: Java program that implements and compares two memory allocation algorithms
  Best & First Fit
***********************************************/
import java.util.*;

public class Main 
{
  public static void main(String[] args)
  {
    int[] blocks = {100, 500, 200, 300, 600};
    int[] processes = {212, 417, 112, 426};
    System.out.println("FIRST FIT");
    firstFit(blocks.clone(), processes);
    
    System.out.println("\nBEST FIT");
    bestFit(blocks.clone(), processes);
  }
  
  // Implement First Fit
  static void firstFit(int[] blocks, int[] processes)
  {
    // For each process, find the first block
    for(int i=0; i<processes.length; i++) // Processes
    {
      for(int j=0; j<blocks.length; j++) //Blocks
      {
        if(blocks[j] > processes[i])
        {
          blocks[j] = blocks[j] - processes[i]; //Allocate Block & reduce block size
          System.out.printf("Block: " + j + ", allocated by " + "Process " + i + "\n");
          System.out.printf("Block: " + j + ", now has " + blocks[j] + " space \n \n");
          break;
        }
      }
    }
  }

  // Implement Best Fit
  static void bestFit(int[] blocks, int[] processes)
  {
    int smallestLargest;
    // TODO
    // For each process, find the smallest block
    // that is large enough and allocate it.
    for(int i=0; i<processes.length; i++)
    {
      smallestLargest = -1;
      for(int j=0; j<blocks.length; j++)
      {
        if((smallestLargest == -1 || blocks[j] < blocks[smallestLargest]) && blocks[j] > processes[i])
        {
          smallestLargest = j;
          // System.out.printf("1Current Smallest Block: " + j + ", Block size: " +
          blocks[smallestLargest] + "\n");
        }
        if(j+1 == blocks.length) //End Clause
        {
          blocks[smallestLargest] = blocks[smallestLargest] - processes[i]; //Allocate Block & reduce block size
          System.out.printf("Block: " + smallestLargest + ", allocated by " + "Process " + i + "\n");
          System.out.printf("Block: " + smallestLargest + ", now has " + blocks[smallestLargest] + " space \n \n");
          break;
        }
      }
    }
  }
  
}
