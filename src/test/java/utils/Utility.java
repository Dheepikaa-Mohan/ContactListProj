package utils;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Utility {
	public String sheetname;
	public static WebDriver driver;
	public void launchBrowserAndLoadUrl (String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();	
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	public void browserClose() {
	driver.close();
	}
	public static String[][] readExcel(String sheetname) throws IOException {
		XSSFWorkbook book =new XSSFWorkbook("C:\\Users\\surya\\eclipse-workspace\\demoblaze\\src\\test\\resources\\Data\\list.xlsx");
		
		XSSFSheet sheet = book.getSheet(sheetname);
				int rowCount = sheet.getLastRowNum();
				int columnCount = sheet.getRow(0).getLastCellNum();
				String [] []data=new String[rowCount][columnCount];
				
				for(int i=1; i<=rowCount; i++) {
					
					XSSFRow row = sheet.getRow(i);
					if (row == null) continue;
					for(int j=0; j<columnCount ; j++) {
						XSSFCell cell = row.getCell(j);
						  if (cell == null) {
				                data[i - 1][j] = ""; 
				            } else {
				                DataFormatter formatter = new DataFormatter();
				                data[i - 1][j] = formatter.formatCellValue(cell).trim();
				            }

				            System.out.print(data[i - 1][j] + " ");
				        }
				        System.out.println();
				    }
			book.close();
				return data;
	}
}
	























