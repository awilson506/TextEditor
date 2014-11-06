/**
	 * Name: Adam Wilson
	 * StudentID: 0543568
	 * Project: 4
	 * Class: COSC 600 
	 * 
	 * 
	 * This program reads in the commands $insert, $line, $print, $search
	 * and $done to exit the text editor simulations.  To simulate a text
	 * editor this program inserts each line of text along with a line number
	 * into a linked list.  Each line of data gets it's own node and within that
	 * node there is the line data and the line number.  Once the linked 
	 * list is loaded up with the data it can then be manipulated with the $line
	 * and $insert command.  If $line of m is not set the $insert function will 
	 * just insert at the end of the linked list.  If $line of m is set then it 
	 * will insert the data after the line which has been set. The $print uses
	 * polymorphism.  If two lines are given with the $print command it 
	 * will print the data within those lines.  If no parameters are given 
	 * it will use recursion to print out the whole list.
	 *  
	 */
public class Main {

	public static void main(String[] args) {
		//start the text editor simulation
		Driver.startEditor();
	}
}
