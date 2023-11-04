package ListenersPack;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Utilities_P.C_44_TNG_Utilities implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
	
		this.driver=((Utilities_P.C_44_TNG_Utilities)result.getInstance()).driver;
		try {
			Screenshots("Success");
			log.info("Test Passed and Screenshot Taken. ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		this.driver=((Utilities_P.C_44_TNG_Utilities)result.getInstance()).driver;
		try {
			Screenshots("Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

}
