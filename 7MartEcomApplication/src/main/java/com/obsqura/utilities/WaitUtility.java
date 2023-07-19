package com.obsqura.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility extends FileReaderUtility {

	public void IW_ImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
	}

	public void EW_presenceOfElement(By path, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
		wait.until(ExpectedConditions.presenceOfElementLocated(path));
	}

	public void EW_visibilityOfElement(By path, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(path));
	}

	public void EW_elementToBeClickable(By path, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
		wait.until(ExpectedConditions.elementToBeClickable(path));
	}

	public void EW_elementToBeSelected(By path, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
		wait.until(ExpectedConditions.elementToBeSelected(path));
	}

	public void FW_FluentWait(By path, WebDriver driver) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(getFluentWaitTimeOut()))
				.pollingEvery(Duration.ofSeconds(getFluentWaitPollingTime())).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(path));
	}


}
