package ProjectCur;
import java.io.File;
import java.sql.Date;
import java.time.LocalDateTime;

public interface CurrencyConvestion {
	public void readFile(File file);
	public LocalDateTime fillFile(File file);	
	

}
