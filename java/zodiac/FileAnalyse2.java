package com.yntravelsky.zodiac.lijiali;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
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
import com.yntravelsky.zodiac.lijiali.FileForkJoin2;

/**
 * analyze Chinese txt files sequentially using one ConcurrentMap, print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140618
 */
public class FileAnalyse2 {

	private static ConcurrentMap<Character, Integer> txtMap = new ConcurrentHashMap<Character, Integer>();
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

		// long time1 = System.currentTimeMillis();

		for (String task : tasks) {
			txtMap = FileForkJoin2.analyseEach(task);
		}
		// long time2 = System.currentTimeMillis();

		FileDemoForkJoin.sortAndPrint(txtMap);

		System.out.println("总文件数：" + filesum);
		for (int value : txtMap.values()) {
			charsum += value;
		}
		System.out.println("总字符数：" + charsum);

		long end = System.currentTimeMillis();
		System.out.printf("The elapsed time is %d ms\n", (end - start));
		// System.out.printf("analyse time: %d ms\n", (time2 - time1));

	}
}
