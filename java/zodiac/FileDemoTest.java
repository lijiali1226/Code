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
		float a = 0f, b = 0f, c = 0f, d = 0f, a1 = 0f, b1 = 0f, c1 = 0f, d1 = 0f;
		for (int i = 0; i < 3; i++) {
			long start = System.currentTimeMillis();

			String txt = FileDemo.readTxt("JavaSource/test/lijiali/character_analyse_complex5.txt");
			long time1 = System.currentTimeMillis();

			Map<Character, Integer> m = FileDemo.analyseStr(txt);
			long time2 = System.currentTimeMillis();

			List<Map.Entry<Character, Integer>> sortTxt = FileDemo.sortMap(m);
			Iterator<Entry<Character, Integer>> it1 = sortTxt.iterator();
			while (it1.hasNext()) {
				Entry<Character, Integer> entry = it1.next();
				Character key = entry.getKey();
				Integer value = entry.getValue();
				System.out.println("字符：\"" + key + "\" 共有：" + value + "个");
			}

			long end = System.currentTimeMillis();

			a = time1 - start;
			b = time2 - time1;
			c = end - time2;
			d = end - start;
			System.out.printf("时间/s: %.2f %.2f %.2f %.2f\n", a / 1000, b / 1000, c / 1000, d / 1000);
			Thread.sleep(50000);

			a1 += a;
			b1 += b;
			c1 += c;
			d1 += d;
		}
		System.out.printf("时间/s: %.2f %.2f %.2f %.2f", Math.round(a1 / 3) / 1000.0, Math.round(b1 / 3) / 1000.0,
				Math.round(c1 / 3) / 1000.0, Math.round(d1 / 3) / 1000.0);
	}
}
