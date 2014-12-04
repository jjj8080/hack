
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MB on 04/12/14.
 */
public class ReadManager {



    public static void readXMLDataInFile(String name) throws IOException {

    	
    	BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
    	 
    	  StringBuffer stringBuffer = new StringBuffer();
    	  String line = null;
    	 
    	  while((line =bufferedReader.readLine())!=null){
    	 
    	   stringBuffer.append(line);
    	  }
    	   
    	  System.out.println(stringBuffer);
    	  parseXML(stringBuffer.toString());
    	 }
    	


		public static void parseXML(String data) { 
			
		//trade id
		System.out.println(data.substring(nthOccurrence(data, '"', 0)+1, (nthOccurrence(data, '"', 1))));
		
		// version id
		System.out.println(data.substring(nthOccurrence(data, '"', 2)+1, (nthOccurrence(data, '"', 3))));
		
		// source
		System.out.println(data.substring(nthOccurrence(data, '"', 4)+1, (nthOccurrence(data, '"', 5))));

		//counterparty id
		System.out.println(data.substring(nthOccurrence(data, '"', 6)+1, (nthOccurrence(data, '"', 7))));

		//counterparty name
		System.out.println(data.substring(nthOccurrence(data, '"', 7)+2, (nthOccurrence(data, '/', 0)-1)));
		
		// trader id
		System.out.println(data.substring(nthOccurrence(data, '"', 8)+1, (nthOccurrence(data, '"', 9))));
		
		//trader name
		System.out.println(data.substring(nthOccurrence(data, '"', 9)+3, (nthOccurrence(data, '/', 1)-1)));

		//book name
		System.out.println(data.substring(data.lastIndexOf("<book>")+6, data.indexOf("</book>")));
		
		//timestamp
		System.out.println(data.substring(data.lastIndexOf("<timestamp>")+11, data.indexOf("</timestamp>")));
		
		//product type
		System.out.println(data.substring(nthOccurrence(data, '"', 10)+1, (nthOccurrence(data, '"', 11))));
		
		//buy ccy 
		System.out.println(data.substring(data.indexOf("<ccy>")+5,data.indexOf("</ccy>")));
		
		// amount
		System.out.println(data.substring(data.indexOf("<amount>")+8,data.indexOf("</amount>")));
		
		// sell ccy
		System.out.println(data.substring(data.indexOf("<sell>")+8,data.indexOf("</sell>")-5));

		
		
		
		
		}
		
		public static int nthOccurrence(String str, char c, int n) {
		    int pos = str.indexOf(c, 0);
		    while (n-- > 0 && pos != -1)
		        pos = str.indexOf(c, pos+1);
		    return pos;
		}


		}

    



