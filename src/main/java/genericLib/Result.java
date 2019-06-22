package genericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener , IAutoConstants{
	
	
	

	static int passCount=0, failCount=0, skipCount=0;
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		
		Reporter.log("=====starting execution======"+ result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name =result.getName();
		Reporter.log("Test :"+ name +" is PASSSED", true);
		passCount++;
		
		
		

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		Reporter.log("Test :"+name +"is FAIL ", true);
		failCount++;
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		Reporter.log("Test :"+name +"is SKIPPED ", true);
		skipCount++;
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onStart(ITestContext context) {
		Reporter.log("---------Starting Test---------",true);
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		
	}

	
	
	

}

