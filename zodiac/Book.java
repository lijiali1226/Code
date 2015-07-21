package com.yntravelsky.zodiac.lijiali;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.regex.Matcher;
//import java.util.Scanner;
//import java.util.regex.Pattern;

/**
 * Split English words from a txt document, sort and print by occurrence
 * 
 * @author ljl
 * @since 20140521
 */

public class Book {
	private String booktext = " ";

	public Book(String s) throws IOException {
		readBook(s);
	}

	/**
	 * Read from txt file to string
	 * 
	 * @param s
	 * @throws IOException
	 */
	public void readBook(String s) throws IOException {
		FileReader fr = new FileReader(new File(s));
		// Scanner scanner = new Scanner(fr);
		// try {
		// while (scanner.hasNextLine()) {
		// booktext += scanner.nextLine() + " ";
		// }
		BufferedReader br = new BufferedReader(fr);

		// FileInputStream fis = new FileInputStream(new File(s));
		// InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		// BufferedReader br = new BufferedReader(isr);

		/*
		 * StringBuilder is unsafe but faster than StringBuffer and String
		 */
		StringBuilder sb = new StringBuilder();
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb = sb.append(line);
				sb = sb.append(" ");
			}
			booktext = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件读取异常！");
		} finally {
			// scanner.close();
			br.close();
		}
	}

	/**
	 * Remove special characters
	 */
	public void filter() {
		// ----- Version 1.0-----
		// String[] filter = { ",", ".", "?", ":", "\"", ";", "(", ")", "!",
		// "*", "—", "#", "[", "]", "/", "$", "--", "@", "%" };
		// for (int i = 0; i < filter.length; i++)
		// booktext = booktext.replace(filter[i], " ");

		/* booktext = booktext.replaceAll("\\pP", " "); */

		// booktext.replaceAll("'(?!s |m |re |ll |ve |t |am |d |S |M |RE |LL |VE |T |AM |D )", " ");
		// booktext = booktext.replaceAll("[\\d+]", "");
		// booktext = booktext.replaceAll("- ", "");

		// ----- Version 2.0----------
		booktext = booktext.replaceAll("[0-9]+\\.[A-Z]+\\.[0-9]*\\s*", " ");
		booktext = booktext.replaceAll(",|\\.|;|:|!|\\?|\\*|—|#|\\[|\\]|\\$|--|@|_|%|\\(|\\)|\"|“|”|&|»|\\||…|/|\\\\",
				" ");
		booktext = booktext.replaceAll("'{1}[\\s]{1,}|[\\s]{1,}'{1}|- |\\b\\d+-\\d+\\b|\\s\\d+\\s", " ");

		// ---- Version 3.0----
		// Problem of ' & Slower than others
		// Pattern p = Pattern
		// .compile("[0-9]+.[A-Z]+.[0-9]*\\s*|,|\\.|;|:|!|\\?|\\*|—|#|\\[|\\]|\\$|--|@|_|%|\\(|\\)|/|\"|\\\\|'{1}[\\s]{1}|[\\s]{1}'{1}|\\b\\d+-*\\d+\\b|- |\\d+");
		// Matcher m = p.matcher(booktext);
		// for (int i = 0; i < booktext.length(); i++) {
		// m.reset();
		// booktext = m.replaceAll(" ");
		// }
	}

	public int bookLength() {
		return booktext.length();
	}

	public String getFirstSentence() {
		int endoffirstsentence = booktext.indexOf(".");
		return booktext.substring(0, endoffirstsentence + 1);
	}

	public void convertToLowerCase() {
		booktext = booktext.toLowerCase();
	}

	public void convertToUpperCase() {
		booktext = booktext.toUpperCase();
	}

	public int occurenceOfWord(String word) {
		while (word.length() > 0) {
			int lengthwithoutword = booktext.replace(" " + word + " ", "").length();
			return (bookLength() - lengthwithoutword) / (word.length() + 2);
		}
		return 0;
	}

	public void occurenceOfEachWord() {
		List<String> list = new ArrayList<String>();

		booktext = booktext.replaceAll("\\s\\d+\\s", " ");
		String[] s = booktext.split(" ");

		/*
		 * Remove duplicate
		 */
		for (int i = 0; i < s.length; i++) {
			if (!list.contains(s[i])) {
				list.add(s[i]);
			}
		}

		String[] keyarray = list.toArray(new String[list.size()]);

		// System.out.println(list.size());
		// System.out.println(Arrays.toString(list.toArray()));

		// for (int i = 0; i < keyarray.length; i++) {
		// System.out.println(keyarray[i]);
		// }

		int[] valuearray = new int[keyarray.length];

		for (int i = 0; i < keyarray.length; i++) {
			valuearray[i] = occurenceOfWord(keyarray[i]);
			if (valuearray[i] == 0 && keyarray[i].length() > 1)
				valuearray[i] = 1;
		}

		// for (int i = 0; i < keyarray.length; i++) {
		// System.out.println(keyarray[i] + "  " + valuearray[i]);
		// }

		List<PairValue> pairlist = new ArrayList<PairValue>();
		for (int i = 0; i < keyarray.length; i++) {
			pairlist.add(new PairValue(keyarray[i], valuearray[i]));
		}

		// for (PairValue pair : pairlist) {
		// System.out.println(pair.getKey() + "\t\t" + pair.getValue());
		// }

		// for(int i=0;i<pairlist.size();i++){
		// System.out.println(pairlist.get(i));
		// }
		// System.out.println();
		// System.out.println();

		Collections.sort(pairlist);

		for (PairValue pair : pairlist) {
			System.out.printf("%-30s %d\n", pair.getKey(), pair.getValue());
		}
	}

	/**
	 * Store each word and its occurrence
	 */
	public class PairValue implements Comparable<PairValue> {
		private String key;
		private int value;

		public PairValue(String key, int value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}

		@Override
		public int compareTo(PairValue o) {
			// TODO Auto-generated method stub
			return (this.value > o.getValue() ? -1 : (this.value == o.getValue() ? 0 : 1));
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Book b = new Book("JavaSource/test/lijiali/english_analyse5.txt");
		b.filter();
		// System.out.println(b.bookLength());
		// System.out.println(b.getFirstSentence());
		// System.out.println(b.occurenceOfWord("Game"));
		// b.convertToUpperCase();
		b.convertToLowerCase();
		b.occurenceOfEachWord();
	}
}
