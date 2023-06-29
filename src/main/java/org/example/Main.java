//        **********************KEYBOARD ACTIONS AND UPLOAD FILE**********************
package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class Main {
    public static void main(String[] args){
//      Setting up chrome options to block unnecessary pop-up notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

//      Change web driver according to your browser. Here Chrome browser has been used.
        WebDriver driver = new ChromeDriver(options);

//      Launching Facebook SignUp webpage
        driver.get("https://www.facebook.com/signup/");

//      Maximizing window size
        driver.manage().window().maximize();

//      Adding implicit wait to allow all web elements to load properly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      Action class's object to handle all web element's actions
        Actions actions = new Actions(driver);
        WebElement firstName = driver.findElement(By.name("firstname"));

//      Entering first name in capitals using keyboard actions
        actions.
                moveToElement(firstName).
                click().
                keyDown(Keys.SHIFT).
                sendKeys("bhuvan").
                keyUp(Keys.SHIFT).
                build().
                perform();


//      Copying the text from first name input box using keyboard actions
        actions.
                keyDown(Keys.CONTROL).
                sendKeys("A").
                keyUp(Keys.CONTROL).
                keyDown(Keys.CONTROL).
                sendKeys("C").
                keyUp(Keys.CONTROL).
                build().
                perform();

//      Opening the context menu inside the last name input box using keyboard actions
        actions.contextClick(driver.findElement(By.name("lastname"))).perform();

        try {

//            //----Robot class to select Paste option from contextmenu
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

//          Phone number input box
            WebElement phoneNum = driver.findElement(By.name("reg_email__"));

//          Entering phone number inside the input box
            phoneNum.sendKeys("9999999999");

/*
//      This will only work if we're logged in!
//              Clicking on suggested password
//                  First Context Menu
                    actions.moveToElement(driver.findElement(By.name("reg_passwd__"))).contextClick().perform();
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    Thread.sleep(1000);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);

//                  Second context menu
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    Thread.sleep(1000);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
*/

//          Navigating and switching context to plagiarism-checker website
            driver.navigate().to("https://smallseotools.com/plagiarism-checker/");
            driver.switchTo().window(driver.getWindowHandle());

//          Scrolling down to the upload file element using Javascript executor scroll
            JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollBy(0,700)","");


            try{
//              Uploading Answers.txt file
                Thread.sleep(3000);
                WebElement uploadFile = driver.findElement(By.name("fileUpload"));
                actions.moveToElement(uploadFile);
                uploadFile.sendKeys(System.getProperty("user.dir")+"/src/main/resources/Answers.txt");
                Thread.sleep(3000);

            }catch (Exception e){
                e.printStackTrace();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.close();
        System.out.println("File Uploaded Successfully!");
        System.out.println("\nThank You!");
    }
}
//        **********************THANK YOU**********************

/*CREDITS:
    Bhuvan Kohli
    bhuvan.kohli@geminisolutions.com
*/