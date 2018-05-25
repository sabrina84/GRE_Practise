package sample;

import java.io.*;
import java.util.ArrayList;

class BufferedReaderDemo {
  public static void main(String args[]) throws Exception
  {
	  BufferedReader br=null;
	  ArrayList<String>al = new ArrayList<>();
  	/*FileReader fr = new FileReader("wordlist.csv");
  	BufferedReader br=new BufferedReader(fr);
  	while(true)
  	{
  		String s=br.readLine();
  		if(s==null) break;
  		System.out.println (s);
  	}
  	br.close();
  	fr.close();*/
	  try {
		  br = new BufferedReader(new FileReader("wordlist.csv"));
		  String read = null;
		  while ((read = br.readLine()) != null) {
			  String[] splited = read.split(",");
			  for (String part : splited) {
				  al.add(part);
				 // System.out.println(part);
			  }
		  }
	  } catch (IOException e) {
		  System.out.println("There was a problem: " + e);
		  e.printStackTrace();
	  } finally {
		  try {
			  br.close();
		  } catch (Exception e) {
		  }
	  }
	  for(int k=0; k<al.size(); k+=3)System.out.println(al.get(k));



  }
}