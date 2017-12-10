package com.demo;

import java.util.ArrayList;

import com.demo.cache.Cache;
import com.demo.multiuser.SessionGenerator;

public class Demo
{

	public static void main(String[] args) throws Exception
	{
		int a = 5;
		int b = 7;
		int result = 0;

		a++;
		a = b + 1;

		if (a < 0)
		{
			System.out.println("searching");
			result = binarySearch(2);
			System.err.println(result);
			result = binarySearch(5);
			System.out.println(result);
		} else
		{
			System.out.println("not searching");
		}

		System.out.println("printing series");

		for (int i = 0; i < 10; i++)
		{
			result(binarySearch(i));
			System.out.println(i);
		}

		SessionGenerator.generate();

		cacheTest();
	}

	static void result(int a)
	{
		System.out.println("found at " + a);
	}

	@SuppressWarnings("boxing")
	private static void cacheTest() throws InterruptedException
	{
		Cache cache = new Cache(50);

		ArrayList<Integer> list = new ArrayList<Integer>();

		//changing thread name
		Thread.currentThread().setName("hello");

		try
		{
			for (int i = 0; i < 100; i++)
			{
				cache.put(i, i);
				list.add(i);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		Thread.sleep(2000);
		try
		{
			for (int i = 0; i < 100; i++)
			{
				Object x = cache.get(i);
				if (x != null)
				{
					int val = (Integer) x;
					System.out.println(val);
				} else
				{
					System.out.println("null");
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int binarySearch(int key)
	{
		int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int first = 0, upto = sorted.length - 1;
		while (first < upto)
		{
			int mid = (first + upto) / 2; // Compute mid point.
			if (key < sorted[mid])
			{
				upto = mid; // repeat search in bottom half.
			} else if (key > sorted[mid])
			{
				first = mid + 1; // Repeat search in top half.
			} else
			{
				return mid; // Found it. return position
			}
		}
		return -(first + 1); // Failed to find key
	}
}
