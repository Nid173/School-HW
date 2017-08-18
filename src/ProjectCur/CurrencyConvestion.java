package ProjectCur;
import java.io.File;
import java.sql.Date;

public interface CurrencyConvestion {
	public void readFile(File file);
	public Date fillFile(File file);
	public Date updateFile(File File);
	public double conversion(double curFrom, double curTo,double amount);	
	
	

}
