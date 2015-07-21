package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangle2 {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		b.add(1);
		b.add(1);
		if(numRows==0) return list;
		if (numRows == 1)
			list.add(a);
		 else {
			list.add(a);
			list.add(b);
			for (int i = 2; i < numRows; i++) {
				list.add(getRow(list.get(i-1)));
			}
		}
		return list;
	}
	
	
	public static List<Integer> getRow(List<Integer> a){
		int n=a.size()+1;
		List<Integer> b = new ArrayList<Integer>(n);
		b.add(1);
		for(int i=0;i<=a.size()-2;i++){
			b.add(a.get(i)+a.get(i+1));
		}
		b.add(1);
		return b;
	}

	public static void main(String args[]) {
		System.out.println(generate(5));
		System.out.println(generate(2));
		System.out.println(generate(3));
		System.out.println(generate(0));
	}
}
