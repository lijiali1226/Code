package com.yntravelsky.zodiac.lijiali;

//import com.sun.corba.se.impl.io.ObjectStreamClass;
import com.yntravelsky.zodiac.lijun.FileDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Chinese word analyze using forkjoin and several HashMaps, print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140616
 * 
 */

public class FileDemoForkJoin2 extends RecursiveTask<Map<Character, Integer>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5204375894592844970L;

	private String txt;
	private Map<Character, Integer> txtMap;
	private int threshold = 200_000;

	FileDemoForkJoin2(String txt, int threshold) {
		this.txt = txt;
		this.threshold = threshold;
	}

	 static Map<Character, Integer> addMap(Map<Character, Integer> m1, Map<Character, Integer> m2) {

		if (m1 == null)
			return m2;

		// --------------version 1---------------------------------------------
		for (Map.Entry<Character, Integer> entry1 : m1.entrySet()) {
			for (Map.Entry<Character, Integer> entry2 : m2.entrySet()) {
				if (entry1.getKey().equals(entry2.getKey())) {
					// m1.remove(entry1.getKey());
					m1.put(entry1.getKey(), entry1.getValue() + entry2.getValue());
					m2.remove(entry2.getKey());
					break;
				}
			}
		}

		// ------------------version 2--------------------------------------------
		// for (Iterator<Character> iter1 = m1.keySet().iterator(); iter1.hasNext();) {
		// Character key1, key2;
		// Integer value1, value2;
		// key1 = iter1.next();
		// value1 = m1.get(key1);
		// for (Iterator<Character> iter2 = m2.keySet().iterator(); iter2.hasNext();) {
		// key2 = iter2.next();
		// value2 = m2.get(key2);
		// if (key1.equals(key2)) {
		// m1.put(key1, value1 + value2);
		// iter2.remove();
		// break;
		// }
		// }
		// }

		// -------------------version 3------------------------------------
		// Iterator<Character> iter1 = m1.keySet().iterator();
		// Character key1, key2;
		// Integer value1, value2;
		// while (iter1.hasNext()) {
		// key1 = iter1.next();
		// value1 = m1.get(key1);
		// for (Iterator<Character> iter2 = m2.keySet().iterator(); iter2.hasNext();) {
		// key2 = iter2.next();
		// value2 = m2.get(key2);
		// if (key1.equals(key2)) {
		// m1.put(key1, value1 + value2);
		// iter2.remove();
		// break;
		// }
		// }
		// }
		// -------------------------------------------------------------------------------

		m1.putAll(m2);
		return m1;

	}

	private Map<Character, Integer> compute(String txt) {
		Map<Character, Integer> m = analyseStr(txt);
		return m;
	}

	public Map<Character, Integer> compute() {
		if (txt.length() <= threshold)
			return compute(txt);

		// ------------------------version 1--------------------------------------
		int n = (int) Math.ceil(txt.length() / (double) threshold);
		// ------------------------version 2--------------------------------------
		// int n = (int) ((txt.length() / threshold) + 1);
		// ----------------------------------------------------------------------

		// System.out.println("txt.length(): " + txt.length());
		// System.out.println("n: " + n);

		// ------------------------version 1------------------------------------
		// for (int j = 0; j < n; j++) {
		// final int _s = j * threshold;
		// final int _e = Math.min((j + 1) * threshold, txt.length());
		// // System.out.println(_s + " - " + _e);
		// FileDemoForkJoin2 f = new FileDemoForkJoin2(txt.substring(_s, _e), threshold);
		// f.fork();
		// txtMap = addMap(txtMap, f.join());
		// }

		// -------------------------version 2-------------------------------------------
		List<ForkJoinTask<Map<Character, Integer>>> tasks = new ArrayList<ForkJoinTask<Map<Character, Integer>>>();
		for (int j = 0; j < n; j++) {
			final int _s = j * threshold;
			final int _e = Math.min((j + 1) * threshold, txt.length());
			tasks.add(new FileDemoForkJoin2(txt.substring(_s, _e), threshold));
		}

		for (final ForkJoinTask<Map<Character, Integer>> task : invokeAll(tasks)) {
			txtMap = addMap(txtMap, task.join());
		}
		// ----------------------------------------------------------------------------------

		return txtMap;
	}

	public static void main(String[] args) {
		// System.out.println(ObjectStreamClass.getSerialVersionUID(FileDemoForkJoin2.class));
		long start = System.currentTimeMillis();
		String txt_ = FileDemo.readTxt("JavaSource/test/lijiali/character_analyse_complex4.txt");

		ForkJoinTask<Map<Character, Integer>> fjt = new FileDemoForkJoin2(txt_, 200_000);
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

	public static Map<Character, Integer> analyseStr(String txt) {
		char[] zi = txt.toCharArray();
		// Map<Character, Integer> tm = new ConcurrentHashMap<Character, Integer>();
		Map<Character, Integer> tm = new HashMap<Character, Integer>();

		for (int i = 0; i < zi.length; i++) {
			if (!tm.containsKey(zi[i])) {
				tm.put(zi[i], 1);

			} else {
				int count = tm.get(zi[i]) + 1;
				tm.put(zi[i], count);
			}
		}

		return tm;
	}
}
