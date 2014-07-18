package ch1to3;

import java.util.*;

public class Property {

	/* @SuppressWarnings("static-access") */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date());
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("----Memory Usage:---");
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total Memory = " + rt.totalMemory()
				+ " Free Memory = " + rt.freeMemory());
		/*
		 * try { Thread.currentThread().sleep(5 * 1000); } catch
		 * (InterruptedException e) { }
		 */
	}
}
