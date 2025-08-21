import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("135");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void ButtonExample() {
        //1) Click and confirm Title(Click krt psse hri page ekt gyd blnnai tyne ek adurganne title eken)
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)) {
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //2)Find the position of the submit button
        driver.navigate().back();
        //ID ek unique da blnna ctrl+F ekk dila search krl blnn one
        WebElement getposition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint = getposition.getLocation();
        int x = xypoint.getX();
        int y = xypoint.getY();
        System.out.println("x: " + x + " y: " + y);


        //3)Find the save button colour
        WebElement buttoncolour = driver.findElement(By.id("j_idt88:j_idt90"));
        String color = buttoncolour.getCssValue("background");
        System.out.println("color: " + color);

        //4)Find the height and the width of the button
        WebElement size =driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height is" + height + "Width is " + width);

    }
}
