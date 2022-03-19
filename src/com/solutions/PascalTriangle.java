package com.streams;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		List<List<Integer>> lists = generatePascalTriangle(5);
		
		for(List<Integer> list : lists) {
			for(Integer n : list) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
		
	}
	
	public static List<List<Integer>> generatePascalTriangle(int n) {
		
		List<List<Integer>> pList = new ArrayList<List<Integer>>();
		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		pList.add(firstRow);
		
		for(int rows = 1; rows < n; rows++) {
			List<Integer> rowList = new ArrayList<Integer>();
			List<Integer> prevList = pList.get(rows-1);
			
			rowList.add(1);
			
			for(int columns=1; columns < rows; columns++) {
				rowList.add(prevList.get(columns-1)+prevList.get(columns));
			}
			
			rowList.add(1);
			pList.add(rowList);
		}
		
		return pList;
	}

}
