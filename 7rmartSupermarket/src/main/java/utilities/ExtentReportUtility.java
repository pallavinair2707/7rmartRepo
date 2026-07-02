package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { // multiple testcases should not collide so, synchronization is provided.
																		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // LOCATION OF the HTML REPORT TO BE GENERATED
																										

		reporter.config().setReportName("7rmartsupermarket"); // config().setReportName("7Mart Project") 2 methods in
																// ExtentSparkReporter
		extentReports.attachReporter(reporter); // attaching of extend report and extendssparkrep for report generation
		extentReports.setSystemInfo("Organization", "Obsquara"); // organization name
		extentReports.setSystemInfo("Name", "Pallavi"); // team member's name
		return extentReports; // createExtentReports() returns extentReports
	}
}