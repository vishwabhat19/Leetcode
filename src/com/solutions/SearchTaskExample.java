package com.solutions;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SearchTask extends RecursiveTask<Integer>
{

	private static final long serialVersionUID = 1L;

	int arr[], searchElement, start, end;

	public SearchTask(int[] arr, int searchElement, int start, int end)
	{
		super();
		this.arr = arr;
		this.searchElement = searchElement;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute()
	{
		int size = end - start + 1;
		if (size > 3)
		{
			int mid = (end + start) / 2;
			SearchTask task1 = new SearchTask(arr, searchElement, start, mid);
			SearchTask task2 = new SearchTask(arr, searchElement, mid + 1, end);
			task1.fork();
			task2.fork();
			int result = task1.join() + task2.join();
			return result;
		}
		else
		{
			return processSearch();
		}
	}

	private Integer processSearch()
	{
		int frequency = 0;
		for (int i = start; i <= end; i++)
		{
			if (arr[i] == searchElement)
				frequency++;
		}
		return frequency;
	}

}

public class SearchTaskExample
{

	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 4, 56, 343, 22, 11, 66, 88, 2, 45, 2, 4, 2, 2 };
		int searchElement = 2;
		int start = 0;
		int end = arr.length - 1;
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		SearchTask searchTask = new SearchTask(arr, searchElement, start, end);
		int result = forkJoinPool.invoke(searchTask);
		System.out.println("Frequency: " + result);

	}
}
