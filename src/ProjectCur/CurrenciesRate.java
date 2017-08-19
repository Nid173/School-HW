package ProjectCur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.w3c.dom.NodeList;

public class CurrenciesRate implements CurrencyConvestion {
	
	
	
	private getCurrencies getXmlInfo;
	
	
	
	
	
	public CurrenciesRate(){
		getXmlInfo = new getCurrencies();
	} 

	@Override
	public void readFile(File file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocalDateTime fillFile(File file) {
		try{
		FileWriter fw = new FileWriter(file);
		BufferedWriter buff = new BufferedWriter(fw);
		NodeList name = getXmlInfo.getName();
		NodeList unit= getXmlInfo.getUnit(); 
		NodeList currencyCode = getXmlInfo.getCurrencyCode();
		NodeList country = getXmlInfo.getCountry();
		NodeList rate = getXmlInfo.getRate();
		NodeList change = getXmlInfo.getChange();
		
        int length = name.getLength();
        for(int i=0; i<length; i++)
        {
         buff.write(name.item(i).getFirstChild().getNodeValue() + ",");
         buff.write(unit.item(i).getFirstChild().getNodeValue() + ",");
         buff.write(currencyCode.item(i).getFirstChild().getNodeValue() + ",");
         buff.write(country.item(i).getFirstChild().getNodeValue() + ",");
         buff.write(rate.item(i).getFirstChild().getNodeValue() + ",");
         buff.write(change.item(i).getFirstChild().getNodeValue());
         buff.write("\n");
        }
        buff.close();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		
        LocalDateTime now = LocalDateTime.now();
        return now;

	}

	//@Override
	//public LocalDateTime updateFile(File File) {
		// TODO Auto-generated method stub
		
	//}

	//@Override
	//public double conversion(double curFrom, double curTo, double amount ) {
		
		// TODO Auto-generated method stub
	//	return 0;
	//}
	
	 public String[] getFullLine(int i,String path) throws FileNotFoundException{
	    	
	    	String[] AA = new String[6];
 
	    	File file = new File(path);
	    	Scanner scan = new Scanner(file);
	    	String line;
	    		for(int j=0;j!=i+1;j++){
	    	    line = scan.nextLine();
	    	    	if (j == i ){
	    	    		AA = line.split("[,]");
	    	    }
	    	    }
	    	    scan.close();
	    	    return AA;
	    	    //...
	    	}
}
