package com.yntravelsky.zodiac.lijiali;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Compute Fibonacci number by ForkJoin
 * 
 * @author ljl
 * @since 20140528
 * @see http://www.ibm.com/developerworks/cn/java/j-lo-forkjoin/
 */

class FibonacciForkJoin extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	final int n;

	FibonacciForkJoin(int n) {
		this.n = n;
	}

	private int compute(int small) {
		final int[] results = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };
		return results[small];
	}

	public Long compute() {
		if (n <= 10) {
			return (long) compute(n);
		}
		FibonacciForkJoin f1 = new FibonacciForkJoin(n - 1);
		FibonacciForkJoin f2 = new FibonacciForkJoin(n - 2);
		// System.out.println("fork new thread for " + (n - 1));
		f1.fork();
		// System.out.println("fork new thread for " + (n - 2));
		f2.fork();
		return f1.join() + f2.join();
		// Single fork
		// return f1.join()+f2.compute();
	}

	/*
	 * int num max 29
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final int num = 29;
		long start = System.currentTimeMillis();
		ForkJoinTask<Long> fjt = new FibonacciForkJoin(num);
		ForkJoinPool fjpool = new ForkJoinPool();
		Future<Long> result = fjpool.submit(fjt);
		System.out.println("Fibonacci(" + num + ") = " + result.get());
		long end = System.currentTimeMillis();
		fjpool.shutdown();
		System.out.printf("The elapsed time is %d ms", end - start);
	}
}
