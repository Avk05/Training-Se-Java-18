package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;

import ru.st.selenium.pages.TestBase;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddFilmPositiveAndRemoveTest extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Test
  public void testAddFilm() throws Exception {
	driver.get(baseUrl + "/php4dvd/");
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("submit")).click();	   
	  
	  
    driver.findElement(By.xpath("//*[@id='content']/section/nav/ul/li[1]/div//img")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//*[@id='updateform']/table/tbody/tr[2]/td[2]/input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("AAA");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("BBB");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2000");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("120");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("1");
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.id("loaned_yes")).click();
    driver.findElement(By.name("loanname")).clear();
    driver.findElement(By.name("loanname")).sendKeys("XXX");
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Very good!");
    driver.findElement(By.name("taglines")).clear();
    driver.findElement(By.name("taglines")).sendKeys("AAA");
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys("AAA");
    driver.findElement(By.name("plots")).clear();
    driver.findElement(By.name("plots")).sendKeys("AAA");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("Russian");
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys("No");
    driver.findElement(By.name("audio")).clear();
    driver.findElement(By.name("audio")).sendKeys("MP3");
    driver.findElement(By.name("video")).clear();
    driver.findElement(By.name("video")).sendKeys("MP4");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("Russia");
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys("AAA");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("XYZ");
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys("QWE");
    driver.findElement(By.name("producer")).clear();
    driver.findElement(By.name("producer")).sendKeys("ASD");
    driver.findElement(By.name("music")).clear();
    driver.findElement(By.name("music")).sendKeys("ZXC");
    driver.findElement(By.name("cast")).clear();
    driver.findElement(By.name("cast")).sendKeys("RTY");
    driver.findElement(By.id("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//img[@alt='Remove']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//img[@alt='Remove']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
