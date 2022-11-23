package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

   String baseUrl="https://www.saucedemo.com/";
   @Before
    public void browserSerUp(){
       openBrowser(baseUrl);
   }
 @Test
 public void userShouldLoginSuccessfullyWithValidCredential() {
     sendTextToElement(By.id("user-name"), "standard_user");
     sendTextToElement(By.id("password"), "secret_sauce");
     clickOnElement(By.id("login-button"));
     String expectedMessage="PRODUCTS";
String actualMessage=getMessageText(By.xpath("//span[@class='title']"));
     Assert.assertEquals(expectedMessage,actualMessage);

 }
@Test
public void verifyThatSixProductsAreDisplayedOnPage(){
    sendTextToElement(By.id("user-name"), "standard_user");
    sendTextToElement(By.id("password"), "secret_sauce");
    clickOnElement(By.id("login-button"));
//List<WebElement> items= driver.findElements(By.xpath("//div[@class='inventory_list']"));//not working
    List<WebElement> itemsOnScreen= driver.findElements(By.className("inventory_item"));
   // List<WebElement> items= driver.findElements(By.className("inventory_item_description"));//working bcoz there is one common attribute
    //between all 6 elements

    //verify that six message displayed on a page
System.out.println("Products displayed on a page are : "+itemsOnScreen.size());
/*int []actualDisplayItems= new int[]{itemsOnScreen.size()};
int expectedItem[]={6};
Assert.assertArrayEquals(expectedItem, actualDisplayItems);*/
int actualitem=6;
int expectedItems=itemsOnScreen.size();
Assert.assertEquals(actualitem,expectedItems);
}
@Test

   @After
    public void tearDown(){
       //closeBrowser();
   }



}
