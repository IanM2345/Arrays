/*
 * Ian Mwai Gachoki
 * 3132394
 */
package griffith;

import java.util.Arrays;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		//Task 1
		String[] normalArray= {"this","is","the","final"};
		
		// Reverses the array
		String[] reversedArray= reverse(normalArray);
		
		// Prints out the reversed array using the loops to ensure its all encased in colons, coma's and speech marks.
		System.out.print("{");
		
		for (int i=0; i< reversedArray.length; i++) {
		   System.out.print("\""+ reversedArray[i]+"\"");
		   if (i< reversedArray.length -1) {
			   System.out.print(", ");
		   }
		}
		System.out.print("}");
		
		System.out.println();
		
		//Task 2
		int[] values= {5,9,6,8,12};
		
		int divisor =3;
		
		int[] result= divisible(values, divisor);
		
		//Prints the array containing only values divisible by the divisor
		System.out.println(Arrays.toString(result));
		
		
		//Task 3
		char[][] grid= {
				{'1','2','3'},
				{'4','5','6'},
				{'7','8','9'}
		};
		
		    System.out.println("-----------------");
			System.out.println("  Original  ");
			System.out.println("-----------------");
			
			// Prints the original grid containing the char above in a table format	
			for (int i=0;i<grid.length;i++) {
				for (int j=0; j<grid[i].length; j++) {
					System.out.print(grid[i][j]+"    ");
				}
				System.out.println();
			}
				
			// Rotates the grid three times and prints each rotation
			for (int rotation =1; rotation<=3; rotation++) {
				grid = rotateGrid(grid);
				System.out.println("----------------");
				System.out.println("  Rotation "+ rotation);
				System.out.println("----------------");
				for (char[] row:grid) {
					for (char cell : row) {
						System.out.print(cell+"      ");
					}
					System.out.println();
				}
			}
			System.out.println();
			
			//Task 4
			Item[] items = {
					new Item("Cookies",1.5,20.0),
					new Item("Blender",50.0,15.0),
					new Item("Laptop",570.0,18.0),
					new Item("Desktop Pc",560.0,25.0)
			};
			
			//Prints the details for each item from the list of arrays above in one line
			for (Item item : items) {
				System.out.println(item.getName()+", "+item.getBasePrice()+", "+item.getVat()+", "+item.salePrice());
			}
			System.out.println();
			
			//Finds the item with the highest value including vat implications
			Item highestPriceVat= items[0];
			for (Item item: items) {
				if(item.salePrice()>highestPriceVat.salePrice()) {
					highestPriceVat = item;
				}
			}
			
				System.out.println("Highest Priced item including Vat " +highestPriceVat.getName());
				
				//Finds item with highest value excluding vat
				Item highestPrice= items[0];
				for (Item item: items) {
					if(item.getBasePrice()>=highestPrice.getBasePrice()) {
						highestPrice = item;
					}
				}
				
					System.out.println("Highest Priced item excluding Vat " +highestPrice.getName());
	}
	
	public static String[] reverse(String[] array) {
		
		//Task 1
		//Method to reverse an array of Strings
		String[] reversedArray = new String[array.length];
		
		//The following loop iterates through each element of the original array, starting from index 0 and going up to the array's length. It assigns the value of the corresponding element to the current position in the reversed array.
		for (int i=0; i<array.length ;i++) {
			
			reversedArray[i]= array[array.length-i-1];
		}
		
		return reversedArray;
		
	}
	
	public static int[] divisible(int[] values, int divisor) {
		
		
		//Task 2
		//Method to find divisible values in an array
		int count=0;
		
		for(int value: values) {
			// Iterate through each value in the array
			if (value != 0 && value%divisor == 0) {
				 // Check if the value is not zero and is divisible by the divisor with a remainder of zero
				count++;
			}
		}
		
		int[] divisibleValues = new int[count];
		int index =0;
		for(int value:values) {
			// Iterate through each value in the array 'values' again.
			if (value !=0 && value%divisor == 0) {
				// Check if the value is not zero and is divisible by the divisor with a remainder of zero
				divisibleValues[index] =value;
				// If the condition is met, assign the value to the current position in 'divisibleValues'
				index++;
				// Increment the index to move to the next position in 'divisibleValues'
			}
		}
		
		 
		return divisibleValues;
	}
	
	public static char[][] rotateGrid(char[][] grid){
		
		//Task 3
		 // Method to rotate a 2D char array clockwise
		int n= grid.length;
		char[][] rotateGrid = new char[n][n];
		
		for (int i=0; i<n/2;i++) {
			// Iterate through the outer layer of the grid from top to bottom.
			for (int j=i; j<n-i-1;j++) {
				// Iterate through each element in the current layer, excluding the last element.
				 char temp = grid[i][j];
				 //Stores the current element as a temporary value
	                rotateGrid[i][j] = grid[n - 1 - j][i];
	             // Rotate the top row elements to the right column.
	                rotateGrid[n - 1 - j][i] = grid[n - 1 - i][n - 1 - j];
	             // Rotate the right column elements to the bottom row
	                rotateGrid[n - 1 - i][n - 1 - j] = grid[j][n - 1 - i];
	             // Rotate the bottom row elements to the left column.
	                rotateGrid[j][n - 1 - i] = temp;
	             // Rotate the left column elements to the top row using the temporary variable
			}
		}
		
		for (int i =0;i<n;i++) {
			// Iterate through each row of the grid.
			for (int j=0; j<n;j++) {
				 // Iterate through each column of the grid.
				if(rotateGrid[i][j]==0) {
					//The code assigns the corresponding element from the original grid if the element in the rotated grid is empty.
					rotateGrid[i][j] = grid[i][j];
				}
			}
		}
		return rotateGrid;
	}
}
