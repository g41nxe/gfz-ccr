import io.DataImport;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Main {
	private final static Logger l = Logger.getLogger(Main.class.getName());

	static List<List<Float>> data = null;

	static String PathToDataFile = "src/test.txt";

	public static void main(String[] argv) throws Exception {
		File file = new File(PathToDataFile);

		DataImport di = new DataImport(file);
		try {
			data = di.importFromTxt();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		List<Float> ccr = math.Calc.ccr(data.get(1), data.get(2)); 
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(ccr);
	}
}
