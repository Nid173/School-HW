/*Nidal nawatha 308349109
 * Sry its little messy but it works :) 
 * */
package ProjectCur;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 window = new GUI1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    	File file = new File("asd.txt");
    	if(!file.exists())
    	{
    		file.createNewFile();
    	}
    	CurrenciesRate x = new CurrenciesRate();
    	
    	
    	Timer timer = new Timer ();
    	TimerTask t = new TimerTask () {
    		
    	    public void run () {
    		System.out.println( x.fillFile(file));
    	    }
    	    };

    	     timer.schedule (t, 0l,86400000);
    	
//    	String[] s = new String[6];
//    	String[] j = new String[6];
//    	s = x.getFullLine(2, "asd.txt");
//    	j = x.getFullLine(3, "asd.txt");
//    	for(int i=0;i<6;i++){
//    	System.out.println(j[i]);
    	}}
  
    
