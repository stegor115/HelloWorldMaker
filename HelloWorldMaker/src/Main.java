//Stephen Gordon
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]){
		String s = "Hello World";
		//WriteToOutFile(s);
		ReadFile();
	} //end method
	
	public static boolean WriteToOutFile(String s){
		BufferedWriter w = null;
		try{
			w = new BufferedWriter(new FileWriter(new File( "potato.txt" )));
			w.write( s );
			int initialTime = (int) System.currentTimeMillis();
			for(int i = 1; i<1000500; i++){ //writes it a million times because science
				w.newLine();
				w.write( s );
			} //end for
			int afterTime = (int) System.currentTimeMillis();
			w.close();
			System.out.println("Time to Produce File: " + (afterTime-initialTime) + "ms");
		}//end try
		catch( IOException e ){
			System.out.println("Unable to write to file");
			return false;
		} //end catch
		catch( Exception e ){
			System.out.println("Unknown error occured");
			e.printStackTrace();
			return false;
		} //end catch
		return true;
	} //end WriteToOutFile method
	
	public static void ReadFile(){ //TO:DO -- Make it work with a different string, rather than all the same
		BufferedReader b = null;
		String line;
		String prevLine = "This will be replaced";
		LinkedList<String> difLinesList = new LinkedList<String>();
		LinkedList<Integer> intList = new LinkedList<Integer>();
		int lineCount = 0;
		try{
			b = new BufferedReader(new FileReader("potato.txt"));
			line = b.readLine();
			int initialTime = (int) System.currentTimeMillis();
			
			while(line != null && prevLine != null){
				if(!prevLine.equals(line) && !difLinesList.contains(line)){
					//System.out.print(line);
					difLinesList.add(line);
					intList.add(0);
				} //end if, will only print if not the same
				for(int i = 0; i<difLinesList.size(); i++){
					if(difLinesList.get(i).equals(line)){
						intList.set(i, intList.get(i) + 1);
					}// end if
				} //end for
				prevLine = line;
				line = b.readLine();
				lineCount++;
			} //end while
			
			//while(line != null){
			//	System.out.println(line);		Spooky Loop
			//	line = b.readLine();
			//	lineCount++;
			//}//end while
			
			int afterTime = (int) System.currentTimeMillis();
			
			for(int i = 0; i<difLinesList.size(); i++){
				System.out.println(difLinesList.get(i) + " x " + intList.get(i));
			} //end for
			System.out.print("Total Number of Lines: " + lineCount);
			System.out.println();
			System.out.println("Read time: " + (afterTime-initialTime) + "ms");
		} //end try
		catch(IOException e){
			System.out.println("Error");
			e.printStackTrace();
		} //end catch
	} //end ReadFile
}