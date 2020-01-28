package sample;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Code {
	public void maxElement(int n,int[] a)
	{
		int index = -1;
		for(int i=0;i<n;i++)
		{
			if(i>0 && i<n-1 && a[i]>a[i-1] && a[i]>a[i+1]) // checks if neighbors are smaller than current element
			{
				index=i; //storing index of max element
				break;
			}
		}
		System.out.println("index of max element->"+index); 
	}
	
	public void smallestMissingInteger(int n,int[] a)
	{
		int element=-1;
		Arrays.sort(a);
		int[] b =  new int[a[n-1]];
		for(int i=0;i<a[n-1];i++)
		{
			b[i]=i+1;
		}
		for(int i=0;i<n;i++)
		{
			
			int y = b[i];
			boolean test = IntStream.of(a).anyMatch(x -> x == y);
			if(test == false)
			{
				element = b[i];
				break;
			}
		}
		System.out.println("smallest missing element->"+element);
		
	}
	public static void main(String[] args) 
    {
		int n,choice;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of elements you want in array:");
		n = s.nextInt();
		int a[] = new int[n];
		System.out.println("Enter all the elements:");
		for(int i = 0; i < n; i++)
		{
			a[i] = s.nextInt();
		}
		Code m = new Code();
		System.out.print("Enter (1 or 2): \n 1.for Smallest Missing Positive Integer \n 2.for Max Element (which is greater than its neighbor):\n");
		choice = s.nextInt();
		switch(choice) {
		  case 1:
			  m.smallestMissingInteger(n, a);
		    break;
		  case 2:
			  m.maxElement(n,a);
		    break;
		  default:
			  System.out.println("Wrong Choice!");
		}
    }
	
}
