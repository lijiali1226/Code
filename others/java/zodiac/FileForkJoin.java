package com.yntravelsky.zodiac.lijiali;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import org.apache.commons.io.FileUtils;

//import com.yntravelsky.zodiac.lijun.FileDemo;
import com.yntravelsky.zodiac.lijiali.FileDemoForkJoin;
import com.yntravelsky.zodiac.lijiali.FileDemoForkJoin2;
import com.yntravelsky.zodiac.lijun.FileDemo;

/**
 * analyze Chinese txt files using forkjoin, print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140617
 */
public class FileForkJoin extends RecursiveTask<Map<Character, Integer>> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1832538919815886886L;
	private static Map<Character, Integer> txtMap = new HashMap<Character, Integer>();
	private static List<String> filelist = new ArrayList<String>();
	private String path = "";
	private static int filesum, charsum;

	FileForkJoin(List<String> filelist, String path) {
		FileForkJoin.filelist = filelist;
		this.path = path;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		filelist = readFile("d:/test_txt");
		// for (int j = 0; j < filelist.size(); j++) {
		// System.out.println(filelist.get(j));
		// }

		ForkJoinTask<Map<Character, Integer>> fjt = new FileForkJoin(filelist, "");
		ForkJoinPool fjpool = new ForkJoinPool();
		Future<Map<Character, Integer>> result = fjpool.submit(fjt);

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

	private Map<Character, Integer> compute(String path) {
		return analyseEach(path);
	}

	public Map<Character, Integer> compute() {
		if (!path.equals("")) {
			return compute(path);
		}

		List<ForkJoinTask<Map<Character, Integer>>> tasks = new ArrayList<ForkJoinTask<Map<Character, Integer>>>();
		for (int j = 0; j < filelist.size(); j++) {
			String s = filelist.get(j);
			if (s.endsWith("txt") || s.endsWith("TXT"))
				tasks.add(new FileForkJoin(filelist, s));
		}
		filesum = tasks.size();
		invokeAll(tasks);
		// long time1 = System.currentTimeMillis();
		for (final ForkJoinTask<Map<Character, Integer>> task : tasks) {
			txtMap = FileDemoForkJoin2.addMap(txtMap, task.join());
		}
		// long time2 = System.currentTimeMillis();
		// System.out.printf("addmap time: %d ms\n", (time2 - time1));
		return txtMap;
	}

	public static List<String> readFile(String filepath) {

		File file = new File(filepath);
		String[] list = file.list();
		// for(int i=0;i<list.length;i++)
		// System.out.println(list[i]);
		// List<String> filelist = new ArrayList<String>();

		if (file.isFile()) {
			filelist.add(file.getAbsolutePath());
		} else if (file.isDirectory()) {
			for (int i = 0; i < list.length; i++) {
				File readfile = new File(filepath + "\\" + list[i]);
				if (readfile.isFile()) {
					filelist.add(readfile.getAbsolutePath());
				} else if (readfile.isDirectory()) {
					readFile(filepath + "\\" + list[i]);
				}
			}
		}
		return filelist;
	}

	public static Map<Character, Integer> analyseEach(String path) {
		String txt_ = readTxt(path);
		Map<Character, Integer> m = FileDemo.analyseStr(txt_);
		return m;
	}

	public static String readTxt(String txtSourse) {
		try {
			File file = new File(txtSourse);
			if (file.isFile() && file.exists()) {
				String txt_read = FileUtils.readFileToString(file, "gbk");
				return txt_read;
			} else {
				System.out.println("文件不存在！");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件读取异常！");
			return null;
		}
	}

}