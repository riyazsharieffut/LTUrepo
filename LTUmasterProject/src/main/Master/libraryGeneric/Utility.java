package libraryGeneric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class Utility {




    /* Function Name : Static or Dead Wait
     * Description   : 
     * Parameters    :  waitTimeSec
     * Author & Date : LTU & 31 May 2021 
     * Modified Date :*/
    public static void staticWait(int waitTimeSec) throws InterruptedException {

    		Thread.sleep(1000 * waitTimeSec);
    }



    /* Function Name : Dynamic Expicit wait Presence of Element
     * Description   : 
     * Parameters    :  driver, waitTimeSec, locator, locatorValue
     * Author & Date : LTU & 31 May 2021 
     * Modified Date :*/

    public static void dynamicWait(WebDriver driver, int waitTimeSec, String locator, String locatorValue) {
        if (locator == "id") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
        } else if (locator == "name") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
        } else if (locator == "className") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
        } else if (locator == "cssSelector") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
        } else if (locator == "linkText") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorValue)));
        } else if (locator == "partialLinkText") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorValue)));
        } else if (locator == "tagName") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorValue)));
        } else if (locator == "xpath") {
            new WebDriverWait(driver, waitTimeSec).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
        } else {
            Reporter.log("Please enter correct locator" + locator, true);
        }


    }




    public static void elementVisibledynamicwait(WebDriver driver, int timeOutInSeconds, String locator, String locatorvalue) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        switch (locator) {
            case "id":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
                break;
            case "name":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
                break;
            case "className":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorvalue)));
                break;
            case "linkText":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorvalue)));
                break;
            case "partiallinktext":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorvalue)));
                break;
            case "tagName":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorvalue)));
                break;
            case "xpath":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
                break;
            case "cssSelector":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
                break;
            default:
                Reporter.log("not matching locator", true);
                break;
        }
    }


    /* Function Name : Handling Java popup alert
     * Description   : 
     * Parameters    : WebDriver 
     * Author & Date : Touheed Aslam 
     * Modified Date :DD/Aug/2020 */
    public static void acceptalert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissalert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertMessage(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }



    /* Function Name : Handling dropdownlist
     * Description   : 
     * Parameters    : Webelement , text,index, value 
     * Author & Date : Touheed Aslam 
     * Modified Date :DD/Aug/2020 */
    public static void selectByVisbleText(WebElement list, String text) {
        new Select(list).selectByVisibleText(text);
    }


    public static void selectByIndex(WebElement list, int index) {
        new Select(list).selectByIndex(index);
    }

    public static void selectByValue(WebElement list, String value) {
        new Select(list).selectByValue(value);
    }


    /* Function Name : Handling Drop Menu / Mouse Hover Event and Context click
     * Description   : Using Actions Class which takes WebDriver as Argument
     * Parameters    :  WebDriver , WebElement
     * Author & Date : LTU & 31 May 2021 
     * Modified Date :*/
    public static void mouseHover(WebDriver driver, WebElement webelement) {
        new Actions(driver).moveToElement(webelement).click().perform();
    }


    public static void contextClick(WebDriver driver, WebElement webelement) {
        new Actions(driver).contextClick().perform();
    }





    /* Function Name : Alert Popup
     * Description   : Handling Alert Popup using SwitchTo
     * Parameters    :  WebDriver
     * Author & Date : LTU & 31-May-2021
     * Modified Date :*/



    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }


    /* Function Name : Closing Child Browsers
     * Description   : Close Child Browsers using SwitchTo
     * Parameters    :  WebDriver
     * Author & Date : LTU & 31-May-2021
     * Modified Date :*/

    public static void closeChildBrowser(WebDriver driver) {
        Set < String > windowsHandle = driver.getWindowHandles();
        Iterator < String > i = windowsHandle.iterator();

        String parent = i.next();


        while (i.hasNext()) {

            String child = i.next();
            driver.switchTo().window(child);
            driver.close();
        }

        driver.switchTo().window(parent);

    }

    /* Function Name : Handling popup using AutoIt
     * Description   : 
     * Parameters    :  exe file genereated by Autoit/vb scripts
     * Author & Date : LTU & 31-May-2021
     * Modified Date :*/

    public void autoITHandlingPopup(String actionTypepopupFilePath) {

        try {
            Runtime.getRuntime().exec(actionTypepopupFilePath);
        } catch (IOException e) {

            System.out.println("Please check input execution file");

        }
    }


    /* Function Name : switchToWindow
     * Description   : 
     * Parameters    : Webelement , title
     * Author & Date : Touheed Aslam 
     * Modified Date :DD/Aug/2020 */
    public static void switchToWindow(WebDriver driver, String title) {
        Iterator < String > i = driver.getWindowHandles().iterator();
        while (i.hasNext()) {
            driver.switchTo().window(i.next());

            if (driver.getTitle().equalsIgnoreCase(title)) {
                Reporter.log("Switched to window having" + title, true);
                break;
            }

        }
    }

    /* Function Name : Switch to Tab
     * Description   : use this functions to S/w tab
     * Parameters    : TabNumber index 1
     * Author & Date : Touheed Aslam DD/Aug/2020
     * Modified Date :*/

    //to perform action on new tab
    public static void swtichToTab(WebDriver driver, int TabNo) {
        ArrayList < String > windowHandles = new ArrayList < String > (driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(TabNo - 1));
    }



    /* Function Name : scrollTillWebelement
     * Description   : 
     * Parameters    : TabNumber
     * Author & Date : Touheed Aslam DD/Aug/2020
     * Modified Date :*/
    public static void scrollTillWebelement(WebDriver driver, WebElement webelement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webelement);
    }




    /* Function Name : Handling Frames
     * Description   : By Index, WebElement, FrameName
     * Parameters    :  index, WebElement, FrameName
     * Author & Date : LTU & 02-June-2021
     * Modified Date :*/



    public void framesbyIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);

    }

    public void framesbyWebelement(WebDriver driver, WebElement webelement) {
        driver.switchTo().frame(webelement);

    }

    public void framesbyWebelement(WebDriver driver, String frameName) {
        driver.switchTo().frame(frameName);

    }


    public void returnToMainPageFromFrames(WebDriver driver) {
        driver.switchTo().defaultContent();

    }




    /* Function Name : Returns Numeric Value Out Of A String(AlphaNumeric or With Any Special Characters)
     * Description   : 
     * Parameters    :  
     * Author & Date : LTU & 20-June-2021
     * Modified Date :*/

    public static int returnNumericString(String alphaNumData) {

        String returnString = "";

        // Creating array of string length
        char[] ch = new char[alphaNumData.length()];

        // Copy character by character into array
        for (int i = 0; i < alphaNumData.length(); i++) {
            ch[i] = alphaNumData.charAt(i);
        }

        //Fetching only integers
        for (int j = 0; j < ch.length; j++) {
            if (Character.isDigit(ch[j]) == true) {
                returnString = returnString + ch[j];
            }
        }

        //Returning the Numeric String to Integer
        return Integer.parseInt(returnString);

    }

    /* Function Name : To convert the Alpanumeric String to Numeric String
     * Description   : 
     * Parameters    : AlphaNumeric String
     * Author & Date : Touheed Aslam DD/Aug/2020
     * Modified Date :*/

    public static String ConvertToNumericString(String inputString)

    {

        String outputString = "";

        for (char ch: inputString.toCharArray()) {
            if (Character.isDigit(ch)) {

                outputString = outputString + ch;
            }
        }

        return outputString;

    }
    //To convert the Numeric String  to Integer
    public static int AlpaNumericToInteger(String inputString) {

        return Integer.parseInt(ConvertToNumericString(inputString));

    }


    /* Function Name : Take Screenshots
     * Description   : 
     * Parameters    : driver , path to save , pick name
     * Author & Date : Touheed Aslam 
     * Modified Date :21/June/2021 */
    public static String takeScreenShot(WebDriver driver, String path, String picName) {

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path + picName + ".jpg");

            try {
                Files.copy(src, dest); //https://www.journaldev.com/861/java-copy-file
                //FileUtils.copyFile(src, dest); //not supproting now
            } catch (IOException e) {
                Reporter.log("file not copied to destination", true);
            }


        } catch (Exception e) {

            Reporter.log("Exception while taking screenshot " + e.getMessage(), true);
        }

        return path + picName + ".jpg";

    }


    /* Function Name : Taking Screenshots On Failure
     * Description   : 
     * Parameters    : driver , path to save , pick name
     * Author & Date : LTU Team 
     * Modified Date :30/June/2021 */

    public static void takeScreenshotOnPassOrFailure(WebDriver driver, ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            Utility.takeScreenShot(driver, "./screenshot/failedTC/", result.getName());

        } else {
            Utility.takeScreenShot(driver, "./screenshot/passedTC/", result.getName());
        }

    }

    /* Function Name : Extent Report Generation
     * Description   : 
     * Parameters    : testCaseName , screenshotPath
     * Author & Date : LTU Team 
     * Modified Date :07/July/2021 */


    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void extentReport(String testCaseName, String screenshotPath) {

        // start reporters
        htmlReporter = new ExtentHtmlReporter("./ExtentReports/ExtentReports.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it
        logger = extent.createTest(testCaseName);

        logger.log(Status.INFO, "Information : " + testCaseName);



        // test with snapshot
        // logger.addScreenCaptureFromPath(screenshotPath);

        // calling flush writes everything to the log file
        extent.flush();
    }



}