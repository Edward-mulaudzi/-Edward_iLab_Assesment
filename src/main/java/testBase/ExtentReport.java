package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableMethods.PropertiesFile;

public class ExtentReport {

	static ExtentReports extent;

	public static ExtentReports setupExtentReport() throws Exception
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String reportPath = System.getProperty("user.dir")+"/reports/ExecutionReport_"+actualDate+".html";

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		extent = new ExtentReports();
		extent.attachReporter(sparkReport);

		sparkReport.config().setDocumentTitle("iLbaTechnicalAssessment");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("iLabTechnicalAssessment Report");

		extent.setSystemInfo("Executed on Enviroment: ",PropertiesFile.getPropertyValue("url"));
		extent.setSystemInfo("Executed on Browser : ", PropertiesFile.getPropertyValue("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed By User : ",System.getProperty("user.name"));
		return extent;
	}


}
