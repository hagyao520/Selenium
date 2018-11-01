package com.jmoney.luckeylink.handler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jmoney.luckeylink.base.TestStep;
import com.jmoney.luckeylink.util.AppiumUtil;
import com.jmoney.luckeylink.util.SeleniumUtil;

/**
 * <br>处理界面上的点击操作，即如果当前操作为点击，<br/>
 * 则选中脚本中配置的节点，并执行点击操作</br>
 *
 * @author  102051
 * @email   mengxiw@dafycredit.com
 * @date    2017年7月26日 上午10:27:26
 * @version 1.0
 * @since   1.0
 */
public class ClickActionHandler {
	
	/**
	 * <br>Web端点击操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void webClick(TestStep step) throws Exception{ 
		try {
			 System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			 step.getWebDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			 SeleniumUtil.getElement(step).click();
			 Thread.sleep(600);	 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * <br>Web端选项框点击操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void selectClick(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		WebDriver driver = step.getWebDriver();
		WebElement selectElem = SeleniumUtil.getElement(step);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectElem).click().perform();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath(step.getValue())).click();
    }
	
	/**
	 * <br>Web端滚动到元素操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void scrollElement(TestStep step) throws Exception {
    	System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		WebDriver driver = step.getWebDriver();
        WebElement e = SeleniumUtil.getElement(step);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",e);
        e.click();
    }

	/**
	 * <br>Web端点击浏览器弹出框的确定键</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void clickOk(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getWebDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		step.getWebDriver().switchTo().alert().accept();
	}
	
	/**
	 * <br>Web端点击浏览器弹出框的取消键</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void clickCancel(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getWebDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		step.getWebDriver().switchTo().alert().dismiss();
	}
	
	/**
	 * <br>Web端执行浏览器文本弹出框的文本输入</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void clickText(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getWebDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		step.getWebDriver().switchTo().alert().sendKeys(step.getValue());
    }
	
	/**
	 * <br>Android点击操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void androidClick(TestStep step) throws Exception{ 
		try {
			 System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			 step.getAndroidDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			 AppiumUtil.getElement(step).click(); 
			 Thread.sleep(300);	 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
