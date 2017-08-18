package ProjectCur;
import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
import java.net.HttpURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class getCurrencies {
	
	private NodeList name;
	private NodeList unit; 
	private NodeList currencyCode;
	private NodeList country;
	private NodeList rate;
	private NodeList change;

public getCurrencies(){
	fillNodeLists();	
	}
	
		
public void fillNodeLists(){
	        InputStream is = null;
	        HttpURLConnection con = null;
	        try
	        {
	            URL url = new URL("http://www.boi.org.il/currency.xml");
	            con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.connect();
	            is = con.getInputStream();
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.parse(is);
	            name = doc.getElementsByTagName("NAME");
	            unit = doc.getElementsByTagName("UNIT");
	            currencyCode = doc.getElementsByTagName("CURRENCYCODE");
	            country = doc.getElementsByTagName("COUNTRY");
	            rate = doc.getElementsByTagName("RATE");
	            change = doc.getElementsByTagName("CHANGE");
//	            int length = name.getLength();
//	            for(int i=0; i<length; i++)
//	            {
//	                System.out.println("\n\n"+
//	                    name.item(i).getFirstChild().getNodeValue() + "\n" +
//	                    unit.item(i).getFirstChild().getNodeValue() + "\n" +
//	                    currencyCode.item(i).getFirstChild().getNodeValue() + "\n" +
//	                    country.item(i).getFirstChild().getNodeValue() + "\n" +
//	                    rate.item(i).getFirstChild().getNodeValue() + "\n" +
//	                    change.item(i).getFirstChild().getNodeValue());;
//	            }
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        catch(ParserConfigurationException e)
	        {
	            e.printStackTrace();
	        }
	        catch(SAXException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	          if(is!=null)
	          {
	              try
	              {
	                  is.close();
	              }
	              catch(IOException e)
	              {
	                  e.printStackTrace();
	              }
	          }
	          if(con!=null)
	          {
	              con.disconnect();
	          }
	        }
	    }


public NodeList getName() {
	return name;
}


public void setName(NodeList name) {
	this.name = name;
}


public NodeList getUnit() {
	return unit;
}


public void setUnit(NodeList unit) {
	this.unit = unit;
}


public NodeList getCurrencyCode() {
	return currencyCode;
}


public void setCurrencyCode(NodeList currencyCode) {
	this.currencyCode = currencyCode;
}


public NodeList getCountry() {
	return country;
}


public void setCountry(NodeList country) {
	this.country = country;
}


public NodeList getRate() {
	return rate;
}


public void setRate(NodeList rate) {
	this.rate = rate;
}


public NodeList getChange() {
	return change;
}


public void setChange(NodeList change) {
	this.change = change;
}


	

}
