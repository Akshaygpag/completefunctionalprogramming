package com.bridgelabz.functionalprogramming.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utility {
	static int counter = 0;
	static char[] value;

	public static final void setString(String data) {
		value = data.toCharArray();

	}

	public static int callRecurssive(int current, int end) {
		recurssivePermutation(current, end);
		System.out.println("The value of arrangements inrecurssive is " + counter);
return counter;
	}

	// ARRAY.LENGTH-1 IS TIMES
	public static final void recurssivePermutation(int current, int end) {

		if (current == end) {
			counter++;
			return;
		}
		int ref = current;
		while (ref <= end) {

			swap(value, ref, current);

			recurssivePermutation(current + 1, end);

			swap(value, ref, current);
			ref++;
		}

	}

	private static String printArray(char[] value) {
		// RETURN THE ARRAY
		return new String(value);
	}

	public static final char[] swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		return array;

	}

	public static int iterativePermutation(int curr, int end) {
		List<StringBuffer> containsPermutes = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		List<StringBuffer> containsCopy = new ArrayList<>();
		for (int i = end; i >= 0; i--) {
			// TO GET ELEMENTS TO BE INSERTED INTO THE ARRAYLIST TO CALCULATE NTH PERMU FROM
			// N-1 PERMU

			String element = String.valueOf(value[i]);// get element
			// IF THE ELEMENT IS THE FIRST SELECTED ELEMENT
			if (sb.length() == 0) {
				sb.append(element);
				containsPermutes.add(new StringBuffer(element));
			} 
			else 
			{
				// IF THE IS NEED FOR PERMUTATION OF N FROM N-1
				for (int j = 0; j < containsPermutes.size(); j++) {
					int lastPos = containsPermutes.get(j).length();
					int startPos = 0;

					// FETCH EACH INDEX AND TRY TO PLACE THE VALUE AT THAT INDEX FOR EACH N-1
					// PERMUTATION AVAILABLE
					while (startPos <= lastPos) {
						String data = containsPermutes.get(j).toString();
						StringBuffer strCopy = new StringBuffer(data);
						strCopy.insert(startPos, element);
						containsCopy.add(strCopy);
						startPos++;
						strCopy = null;

					}

				}
				// COPY TO BE REPLACED BY ORIGINAL AND CLEAR OUT THE WASTE MEMORY
				containsPermutes.clear();
				containsPermutes.addAll(containsCopy);
				containsCopy.clear();

			}

		}
		// RESULT
		System.out.println(containsPermutes.size() + "  : is the no of arragements generated in iterative method");
		return containsPermutes.size();
	}
	public static final int getRandomInt() {

		Random rand = new Random();
		return rand.nextInt()%10;

	}
	static Scanner scanner = new Scanner(System.in);
	public static final Object[][] setArrayData(int row, int col) {

		Scanner scan = new Scanner(System.in);
		Object arrayData[][] = getArrayData(row, col);

		scan.close();
		return arrayData;

	}

	private static Object[][] getArrayData(int row, int col) {
		// LETS USER SELECT THE TYPE OF DATA TO BE INPUTED

		System.out.println("Select the type of array to be created 1.Integer 2.Double 3.Boolean ");
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		switch (value) {
		case "1":
			return integerDataSet(row, col);
		case "2":
			return doubleDataSet(row, col);
		case "3":
			return booleanDataSet(row, col);
		default:
			System.out.println("Invalid choice selected");

		}

		// TAKES IN INPUT VALUES OF THE DATA THAT IS TO BE SET
		return null;
	}

	private static Object[][] booleanDataSet(int row, int col) {
		// TAKES THE USER VALUES FOR THE BOOLEAN
System.out.println("you have selected the boolean data type");
		Boolean[][] arrayData = new Boolean[row][col];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				System.out.println("Enter the data at [" + i + "]" + "[" + j + "]");
				arrayData[i][j] = Boolean.valueOf(scan.nextBoolean());

			}

		}
		return arrayData;
	}

	private static Object[][] doubleDataSet(int row, int col) {
		// TAKES ALL THE CODES FOR THE DOUBLE
		Double[][] arrayData = new Double[row][col];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				System.out.println("Enter the data at [" + i + "]" + "[" + j + "]");
			try {
				
				arrayData[i][j] = Double.valueOf(scan.nextDouble());
			}
catch(Exception e) {
	
	System.out.println("exception at the message is "+e.getMessage());
	e.printStackTrace();
	
	
}
			}

		}
		return arrayData;
	}

	private static Object[][] integerDataSet(int row, int col) {
		// TAKES ALL THE CODES FOR INTEGER
		Integer[][] arrayData = new Integer[row][col];
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				System.out.println("Enter the data at [" + i + "]" + "[" + j + "]");
				arrayData[i][j] = scan.nextInt();

			}

		}
		return arrayData;

	}

	public static final int[] setSingleIntArrayData(int len) {
		int array[] = new int[len];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter data at " + i + " position");
			array[i] = scan.nextInt();

		}
		scan.close();
		return array;

	}

	public static void printTicTacToe(char game[][]) {
		// GENERATES VISUAL TO THE PLAYER
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {

				sb.append("\t" + game[i][j] + "");

			}
			sb.append("\n");

		}
		System.out.println(sb.toString());

	}
	public static int getIntergerValue() {
		
		
		return scanner.nextInt();
		
	}
}
