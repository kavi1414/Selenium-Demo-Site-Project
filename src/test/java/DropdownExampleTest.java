import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void dropdownTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownExampleTest() throws InterruptedException {

//1.1) ways of select values in Basic dropdown
        driver.get("https://leafground.com/select.xhtml");

        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);


//Godk drpdown menu wala varibale type ek thma select kiynne
//Selectorhub ek yodnne ctrl+F ghla adal sthnay hewimedi e element ekt adal tika udta chlanya wema walkwimata

//1.2) Get the number of dropDown options
        List<WebElement> listodOptioms = select.getOptions();
        int size = listodOptioms.size();
        System.out.println("Number of elemnts in dropDown : " + size);

        for (WebElement elemnt : listodOptioms) {
            System.out.println(elemnt.getText());
        }

//1.3) using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);
//1.4) Selecting value in a Bootstrap dropdown
// mewa select kiyn tag name ekn newi armba wenne emanisa mewa bootstrap dropdown mewge ewge kohmd krnne kiyla balmu
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listofdropdown2values) {
            String dropDownvalue = element.getText();
            if (dropDownvalue.equals("USA")) {
                element.click();
                break;
            }
        }
    }

//2) Google Search - pick a value from suggestions
    @Test
            public void googleSearchDropDown() throws InterruptedException {
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("Palitha");//q gaththe e element eke name eken
            Thread.sleep(2000);
            List<WebElement> googlesearchList = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]"));
            //methan krnne list ite 10k tye em nis ekenuth piatha tewarapperumage list ekt ghin eke e namat adal div ek select krla ek type krnw mn htne
            System.out.println(googlesearchList.size());
            for (WebElement element : googlesearchList) {
            System.out.println(element.getText()); //Awshy tik print un na ?
        }

        }


//3) Handle Hidden Auto Suggestions Drop Down And Search using DOM Debugger Trick
//Methn wenne api mkkhri ekk searh krm eke nam klin wage plt enwa butekk select krm anith ewa nthii wela select krpu ek wtrk search box eke pennawa
}
