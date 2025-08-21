import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_Checkbox_Example {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radio_Tests() {
        //Find the default select radio button
        driver.get("https://leafground.com/radio.xhtml");
        Boolean Chrome = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        Boolean Firfox = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        Boolean Safari = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        Boolean Edge = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (Chrome) {
            String Chromelabel = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println(" Default is : " + Chromelabel);
        } else if (Firfox) {
            String Firefoxlabel = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println(" Default is : " + Firefoxlabel);
        } else if (Safari) {
            String Safarilabel = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println(" Default is : " + Safarilabel);
        } else if (Edge) {
            String Edgelabel = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println(" Default is : " + Edge);
        }

        //2) Select the age group (Only if not selected)
        WebElement Myagegroup = driver.findElement(By.id("j_idt87:city2:0"));
        Boolean ischecked = Myagegroup.isSelected();
        if(!ischecked){
            //Label ek select karath click wenawane emnisa adl eke label eke xpath ek hoyl ek click krmu
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    

    }

    @Test
    public void Checkbox_Tests() {
        //1)Select wanted checkboxes and verifying those checkbxes selected Status
        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element : checkBoxList) {
            if (!element.getText().equals("Others")) {
                element.click();
            }
        }

        for (int i = 1; i <= checkBoxList.size(); i++) {
            boolean checkBoxStatus = driver.findElement(By.id("//table[@id='j_idt87:basic']//input[" + i+ "]")).isSelected();
            System.out.println("CheckBox " + i + " selected status is : " + checkBoxStatus);

        }
    }
}
