import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {


    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("135");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
        Thread.sleep(3000);//URL ekt gyt psse thappr gank wait krnn onenm
    }

    @Test
    public void textBoxTests() {
        //01) Type your name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Kavishka Jayathilaka");
        //Type name sendKeys
        //Thoragnn wdam sdusu ID ek ilgt name ilgt class  but oy ekakwath nthm xpath thma ynn wenne Ekenm one ekk aniwa hoygnn plwan

        //02)Append Country to this City
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("India");
        //Tyne wachne tyedim thm aluth wachne enne

        //03)Verify if text box is disabled
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled" + enabled);

        //Control ek obl click krm e function eke return type ek hoyagn plwan
        //isEnabled,isSelected,isDisplayed option 3 k tynwa psse blmu ewagen mkd wenne kiyl


        //04)Clear the typed text
        //*[@id="j_idt88:j_idt95"]
        WebElement cleartext = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        cleartext.clear();
        //Ud api copy krpu xpath eki () thul tyn path eki madak wenas thul tyn ekt \"\" wdipur kllk awill \" \" wenuwat '' mehm dmmth hri


        //05) Retrieve the typed text.
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        //Value ek kiyne eke text box eke yamk tynawane ek attribute ek thm value kiynne
        System.out.println(value);

//06) Type email and Tab. Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("kavishkajayathilake04@gmail.com" + Keys.TAB + "confirm control move to the next element");
        //Tab ek ebwam plle text box ekt ghin eke ithru tik type wenawa
    }
}