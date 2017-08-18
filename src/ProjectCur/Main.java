package ProjectCur;
import java.io.File;
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

public class Main
{
    public static void main(String args[]) throws IOException
    {
    	File file = new File("asd.txt");
    	if(!file.exists())
    	{
    		file.createNewFile();
    	}
    	CurrenciesRate x = new CurrenciesRate();
    	x.fillFile(file);
    }
}