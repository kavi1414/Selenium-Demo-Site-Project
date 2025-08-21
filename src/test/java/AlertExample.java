import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void alertTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/alert.xhtml;jsessionid=node012otthdb77ni716hxqn68f8phl3904090.node0");
    }

    @Test
    public void alertExample() throws InterruptedException {
        //1)Alert(Simple Dialog
            //Alert eka element ekk newei ema nisa find element walin baha ehidi alert ekat switch wennai one
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert =driver.switchTo().alert();
        alert.accept();

        //2)Alert(Confirm Dialog)

        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1 =driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

//3)Alert (Prompt Dialog)
        WebElement promtBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promtBox.click();
        Alert alert2 =driver.switchTo().alert();
        Thread.sleep(3000);
        String alerttext = alert.getText();//E alert eke yam deyk sdhan wel tyenm ek siplay krnwa (Api type krn de newi)
        System.out.println("Alert text is :" + alerttext);
        alert2.sendKeys("My name is hashir");//Type wen ek penn type wen na
        alert2.accept();

    }

}
