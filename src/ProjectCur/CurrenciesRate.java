package ProjectCur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	public void fillFile(File file) {
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
         buff.write(name.item(i).getFirstChild().getNodeValue() + ", ");
         buff.write(unit.item(i).getFirstChild().getNodeValue() + ", ");
         buff.write(currencyCode.item(i).getFirstChild().getNodeValue() + ", ");
         buff.write(country.item(i).getFirstChild().getNodeValue() + ", ");
         buff.write(rate.item(i).getFirstChild().getNodeValue() + ", ");
         buff.write(change.item(i).getFirstChild().getNodeValue());
         buff.write("\n");
        }
        buff.close();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		
		
	}

	@Override
	public Date updateFile(File File) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double conversion(double curFrom, double curTo, double amount ) {
		// TODO Auto-generated method stub
		return 0;
	}


}
