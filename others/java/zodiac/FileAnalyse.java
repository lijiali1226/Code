package com.yntravelsky.zodiac.lijiali;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.ForkJoinTask;
//import java.util.concurrent.Future;
//import java.util.concurrent.RecursiveTask;
//import org.apache.commons.io.FileUtils;

//import com.yntravelsky.zodiac.lijun.FileDemo;
import com.yntravelsky.zodiac.lijiali.FileDemoForkJoin;
import com.yntravelsky.zodiac.lijiali.FileDemoForkJoin2;

/**
 * analyze Chinese txt files sequentially, print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140617
 */
public class FileAnalyse {

	private static Map<Character, Integer> txtMap = new HashMap<Character, Integer>();
	private static List<String> filelist = new ArrayList<String>();
	private static int filesum, charsum;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		filelist = FileForkJoin.readFile("d:/test_txt");

		List<String> tasks = new ArrayList<String>();
		for (int j = 0; j < filelist.size(); j++) {
			String s = filelist.get(j);
			if (s.endsWith("txt") || s.endsWith("TXT"))
				tasks.add(s);
		}
		filesum = tasks.size();

		// for (String path : tasks) {
		// txtMap = FileDemoForkJoin2.addMap(txtMap, FileForkJoin.analyseEach(path));
		// }

		// long time1 = System.currentTimeMillis();
		List<Map<Character, Integer>> maps = new ArrayList<Map<Character, Integer>>();
		for (String path : tasks) {
			maps.add(FileForkJoin.analyseEach(path));
		}

		// long time2 = System.currentTimeMillis();
		for (Map<Character, Integer> map : maps) {
			txtMap = FileDemoForkJoin2.addMap(txtMap, map);
		}

		// long time3 = System.currentTimeMillis();
		FileDemoForkJoin.sortAndPrint(txtMap);

		System.out.println("总文件数：" + filesum);
		for (int value : txtMap.values()) {
			charsum += value;
		}
		System.out.println("总字符数：" + charsum);

		long end = System.currentTimeMillis();
		System.out.printf("The elapsed time is %d ms\n", (end - start));
		// System.out.printf("analyse time: %d ms\n", (time2 - time1));
		// System.out.printf("addmap time: %d ms\n", (time3 - time2));
	}
}
