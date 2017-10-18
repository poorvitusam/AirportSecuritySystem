package src.airportSecurityState.util;


import java.io.BufferedWriter;
import java.util.ArrayList;

public class Results implements FileDisplayInterface {
	private ArrayList<String> results;
	private FileProcessor fp;
	
	/**
	 * Assign file processor object
	 * @param fileProcessor
	 */
	public Results(FileProcessor fileProcessor) {
		fp = fileProcessor;
		results = new ArrayList<String>();
	}
	
	/**
	 * Call function to write in file 
	 */
	public void writeToFile(String s) {
		fp.writeLine(s);
	}
	
	public void writeToStdout(String s) {
		System.out.println(s);
	}
	
	/**
	 * Store entry in result object
	 * @param name of test
	 * @param result if passed or failed
	 * @param message if error then message
	 */
	public void writeResultToFile() {
		for(String entry:results) {
			writeToFile(entry);
		}
	}
	
	/**
	 * Form the the string with the node to store
	 * @param node B number and courses are extracted from here
	 */
	public void storeResult(Node node) {
		String result = node.getKey() + ": ";
		for(String entry : node.getValue()) {
			result += entry + " ";
		}
		result += "\n";
		results.add(result);
	}
	
	/**
	 * Store the sum of the contents in the array 
	 * @param myArrayList
	 * @param fp
	 */
	public void printNodes(Node node) {
		traverseTree(node);
	}
	
	/**
	 * Inorder traversal of the tree
	 * @param node start node
	 */
	public void traverseTree(Node node) {
		if(node != null ) {
			traverseTree(node.getLeft());
			storeResult(node);
			traverseTree(node.getRight());
		}
	}
}

