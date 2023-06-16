package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage_Assertion {
        WebDriver driver=null;
        public HomePage_Assertion(WebDriver driver)
        {
            this.driver=driver;
        }
        public void setSearchText(String value) {
            String loc="//input[@id='searchbox']";
            WebElement ele= this.driver.findElement(By.xpath(loc));
            ele.sendKeys(value);
        }
        public void clickSearchText() {
            String loc="//input[@id='searchsubmit']";
            WebElement ele= this.driver.findElement(By.xpath(loc));
            ele.click();
        }

        public String getH1Heading() {
            String loc="//section[@id='main']/h1";
            WebElement ele= this.driver.findElement(By.xpath(loc));
            return ele.getText();
        }

    }


