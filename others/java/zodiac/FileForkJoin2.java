package com.yntravelsky.zodiac.lijiali;


import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
//import java.util.Map.Entry;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

//import org.apache.commons.io.FileUtils;

//import com.yntravelsky.zodiac.lijun.FileDemo;
import com.yntravelsky.zodiac.lijiali.FileDemoForkJoin;



/**
 * analyze Chinese txt files using forkjoin and one ConcurrentMap, print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140618
 */
public class FileForkJoin2 extends RecursiveTask<ConcurrentMap<Character, Integer>> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1832538919815886886L;
	private static ConcurrentMap<Character, Integer> txtMap = new ConcurrentHashMap<Character, Integer>();
	private static List<String> filelist = new ArrayList<String>();
	private String path = "";
	private static int filesum, charsum;

	FileForkJoin2(List<String> filelist, String path) {
		FileForkJoin2.filelist = filelist;
		this.path = path;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		filelist = FileForkJoin.readFile("d:/test_txt");

		ForkJoinTask<ConcurrentMap<Character, Integer>> fjt = new FileForkJoin2(filelist, "");
		ForkJoinPool fjpool = new ForkJoinPool();
		Future<ConcurrentMap<Character, Integer>> result = fjpool.submit(fjt);

		try {
			FileDemoForkJoin.sortAndPrint(result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("总文件数：" + filesum);
		for (int value : txtMap.values()) {
			charsum += value;
		}
		System.out.println("总字符数：" + charsum);

		long end = System.currentTimeMillis();
		fjpool.shutdown();
		System.out.printf("The elapsed time is %d ms\n", (end - start));
	}

	private ConcurrentMap<Character, Integer> compute(String path) {
		return analyseEach(path);
	}

	public ConcurrentMap<Character, Integer> compute() {
		if (!path.equals("")) {
			return compute(path);
		}

		List<ForkJoinTask<ConcurrentMap<Character, Integer>>> tasks = new ArrayList<ForkJoinTask<ConcurrentMap<Character, Integer>>>();
		for (int j = 0; j < filelist.size(); j++) {
			String s = filelist.get(j);
			if (s.endsWith("txt") || s.endsWith("TXT"))
				tasks.add(new FileForkJoin2(filelist, s));
		}

		invokeAll(tasks);

		filesum = tasks.size();
		return txtMap;
	}

	public static ConcurrentMap<Character, Integer> analyseEach(String path) {
		String txt_ = FileForkJoin.readTxt(path);
		ConcurrentMap<Character, Integer> m = analyseStr(txt_, txtMap);
		return m;
	}

	public static ConcurrentMap<Character, Integer> analyseStr(String txt, ConcurrentMap<Character, Integer> tm) {

		char[] zi = txt.toCharArray();

		for (int i = 0; i < zi.length; i++) {

			Character c = zi[i];

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
	public static void addOne(ConcurrentMap<Character, Integer> tm, Character c) {

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