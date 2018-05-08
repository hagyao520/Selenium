package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jmoney.xiyuyou.base.TestUnit;
import com.jmoney.xiyuyou.service.RunUnitService;
import com.jmoney.xiyuyou.service.WebXmlParseService;

public class GiteeLogin {
	
	private static RunUnitService runService;
	
	@BeforeTest
	private void stup() throws Exception{
		TestUnit testunit = WebXmlParseService.parse("src/test/java/TestCaseXml/GiteeLogin.xml");
		runService = new RunUnitService(testunit);
		System.out.println("----------------------------------------【码云自动登录流程】---------------------------------------");
	}
	
	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在火狐浏览器中，输入Gitee域名后，可以正常访问");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在登录界面，输入正确的账号和密码，点击登录按钮后，可以正常登录成功");
	}
	
	@AfterTest
	public void TearDown(){
		runService.closeBrowser();
	}
}
