package com.yntravelsky.zodiac.lijiali;

import com.yntravelsky.zodiac.lijun.FileDemo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Call methods from FileDemo.java, print each word and its occurrence and elapsed time
 * 
 * @author ljl
 * @since 20140515
 * 
 */

/*
 * iterate three times for test
 */
public class FileDemoTest {
	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 3; i++) {
			String path = "JavaSource/test/hzy/测试文档2.txt";
			test(path);
			test(path, "UTF-8");
			// Thread.sleep(5000);
		}
	}

	public static String readTest(String path) {
		String text = FileDemo.readTxt(path);
		return text;
	}

	public static char[] readTest(String path, String encode) {
		char[] text = FileDemo.readTxt2Chars(path, encode);
		return text;
	}

	public static void test(String path) {
		long start = System.currentTimeMillis();

		String text = readTest(path);
		long time1 = System.currentTimeMillis();

		Map<Character, Integer> m = FileDemo.analyseStr(text);
		long time2 = System.currentTimeMillis();

		sortAndPrint(m);
		long end = System.currentTimeMillis();
		System.out.println("----------------------------读字符串------------------------------");
		System.out.printf("读文件时间: %.2fs  分析文件时间:%.2fs  排序输出时间:%.2fs  总时间: %.2fs\n", (time1 - start) / 1000.0,
				(time2 - time1) / 1000.0, (end - time2) / 1000.0, (end - start) / 1000.0);
		System.out.println();
	}

	public static void test(String path, String encode) {
		long start = System.currentTimeMillis();

		char[] text = readTest(path, encode);
		long time1 = System.currentTimeMillis();

		Map<Character, Integer> m = FileDemo.analyseStr(text);
		long time2 = System.currentTimeMillis();

		sortAndPrint(m);
		long end = System.currentTimeMillis();

		System.out.println("-----------------------------读字符------------------------------");
		System.out.printf("读文件时间: %.2fs  分析文件时间:%.2fs  排序输出时间:%.2fs  总时间: %.2fs\n", (time1 - start) / 1000.0,
				(time2 - time1) / 1000.0, (end - time2) / 1000.0, (end - start) / 1000.0);
		System.out.println();
	}

	public static void sortAndPrint(Map<Character, Integer> m) {
		List<Map.Entry<Character, Integer>> sortTxt = FileDemo.sortMap(m);
		Iterator<Entry<Character, Integer>> it1 = sortTxt.iterator();
		while (it1.hasNext()) {
			Entry<Character, Integer> entry = it1.next();
			Character key = entry.getKey();
			Integer value = entry.getValue();
			// System.out.println("字符：\"" + key + "\" 共有：" + value + "个");
		}
	}
}
