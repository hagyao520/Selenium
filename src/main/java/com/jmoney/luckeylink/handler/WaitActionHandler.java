package com.jmoney.luckeylink.handler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.jmoney.luckeylink.base.TestStep;

/**
 * 等待动作处理类
 */
public class WaitActionHandler {
	
	/**
	 * 强制等待
	 * @param map
	 * @param step
	 */
	public void waitForced(TestStep step){
		try {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			String waitTime = step.getValue();
			Thread.sleep(Long.valueOf(waitTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Web端隐式等待
	 * @param map
	 * @param step
	 */
	public void webImplicit(TestStep step){
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		long waitTime = Long.valueOf(step.getValue());
		step.getWebDriver().manage().timeouts().implicitlyWait(waitTime, TimeUnit.MILLISECONDS);	
	}

	/**
	 * Android端隐式等待
	 * @param map
	 * @param step
	 */
	public void androidImplicit(TestStep step){
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		long waitTime = Long.valueOf(step.getValue());
		step.getAndroidDriver().manage().timeouts().implicitlyWait(waitTime, TimeUnit.MILLISECONDS);	
	}
	
	/**
     * 在给定的时间内去查找元素，如果没找到则超时，抛出异常
     * */
    public static void waitForElementToLoad(WebDriver driver, int timeOut, final By By) {
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(By);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");
        }
    }
}
