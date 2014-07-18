package com.yntravelsky.zodiac.lijiali;

import com.yntravelsky.zodiac.lijun.FileDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Chinese word analyze using Forkjoin and one ConcurrentHashMap and char[], print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140616
 * 
 */

public class FileDemoForkJoin3 extends RecursiveTask<Map<Character, Integer>> {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -823982928198744881L;

	private static char[] txt;
	private int start,end,threshold = 200_000;
	private ConcurrentMap<Character, Integer> txtMap;
	

	FileDemoForkJoin3(int start, int end, int threshold, ConcurrentMap<Character, Integer> txtMap) {
		this.start = start;
		this.end = end;
		this.threshold = threshold;
		this.txtMap = txtMap;
	}

	private Map<Character, Integer> compute(int start, int end) {
		Map<Character, Integer> m = analyseStr(start, end, txtMap);
		return m;
	}

	public Map<Character, Integer> compute() {

		if ((end - start) <= threshold) {
			return compute(start, end);
		}

		int n = (int) ((txt.length / threshold) + 1);
		// System.out.println("txt.length(): " + txt.length);
		// System.out.println("n: " + n);

		List<ForkJoinTask<Map<Character, Integer>>> tasks = new ArrayList<ForkJoinTask<Map<Character, Integer>>>();
		for (int j = 0; j < n; j++) {
			final int _s = j * threshold;
			final int _e = Math.min((j + 1) * threshold, txt.length);
			tasks.add(new FileDemoForkJoin3(_s, _e, threshold, txtMap));
		}

		invokeAll(tasks);

		return txtMap;
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		txt = FileDemo.readTxt2Chars("JavaSource/test/hzy/测试文档3.txt", "utf-8");

		ConcurrentMap<Character, Integer> map = new ConcurrentHashMap<Character, Integer>();

		ForkJoinTask<Map<Character, Integer>> fjt = new FileDemoForkJoin3(0, txt.length, 500_000, map);
		ForkJoinPool fjpool = new ForkJoinPool();
		Future<Map<Character, Integer>> result = fjpool.submit(fjt);

		try {
			sortAndPrint(result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		fjpool.shutdown();
		System.out.printf("The elapsed time is %d ms", end - start);

	}

	static void sortAndPrint(Map<Character, Integer> m) {

		List<Map.Entry<Character, Integer>> sortTxt = FileDemo.sortMap(m);
		Iterator<Entry<Character, Integer>> it1 = sortTxt.iterator();

		while (it1.hasNext()) {
			Entry<Character, Integer> entry = it1.next();
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("字符：\"" + key + "\" 共有：" + value + "个");
		}
	}

	public static ConcurrentMap<Character, Integer> analyseStr(int start, int end, ConcurrentMap<Character, Integer> tm) {

		for (int i = start; i < end; i++) {

			Character c = txt[i];

			tm.putIfAbsent(c, 0);
			addOne(tm, c);
		}
		return tm;
	}

	/**
	 * 执行计数+1的操作
	 * 
	 * @param tm
	 * @param c
	 */
	private static void addOne(ConcurrentMap<Character, Integer> tm, Character c) {

		boolean addSucces = false;

		final int olcCount = tm.get(c);
		final int newCount = olcCount + 1;
		addSucces = tm.replace(c, olcCount, newCount);
		if (addSucces) {
			return;
		} else {
			addOne(tm, c);
		}
	}
}
