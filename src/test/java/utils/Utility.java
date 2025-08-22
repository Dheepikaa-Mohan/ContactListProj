package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public String sheetname;
	public static WebDriver driver;
	public static ExtentReports extent;
	public String testName,testDescription,testAuthor;
	public static ExtentTest test;
	public void launchBrowserAndLoadUrl (String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",  "C:\\Users\\surya\\Downloads\\edgedriver_win64\\msedgedriver.exe");
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
		XSSFWorkbook book =new XSSFWorkbook("C:\\Users\\surya\\eclipse-workspace\\ContactListProj\\src\\test\\resources\\Data\\list.xlsx");
		
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
	public static String screenShot(String name) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path="C:\\Users\\surya\\eclipse-workspace\\ContactListProj\\src\\test\\resources\\testOutput\\snaps"+name+timestamp+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(src,dest);
		return path;
	}
}
	























