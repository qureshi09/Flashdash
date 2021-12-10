package testCases;

import commanFunctions.CommanFunctions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.Login_Page_Object;

public class Login extends CommanFunctions {


@Test(priority = 0)
    public void loginWithInvalidCredentials(){
        try{
            PageFactory.initElements(driver, Login_Page_Object.class);


            Login_Page_Object.email.sendKeys("Abc@gmail.com");

            Login_Page_Object.password.sendKeys("123456789");


            Login_Page_Object.loginBtn.click();
            String msg=Login_Page_Object.errorMessage.getText().toString();
            String sb=msg.substring(7,68);
            System.out.print(sb);
                try{
                    Assert.assertEquals(sb,
                            "\n" +
                                    "You have entered an invalid email/password, Please try again");
                }catch (Exception e){
                    System.out.println(e);
                }

            Login_Page_Object.email.clear();
            Login_Page_Object.password.clear();

        }catch (Exception e){
            System.out.println(e);
        }

    }


    //@Test(priority=1)
    public void login(){

try{
    PageFactory.initElements(driver, Login_Page_Object.class);

    Login_Page_Object.email.sendKeys(properties.getProperty("username"));

    Login_Page_Object.password.sendKeys(properties.getProperty("password"));

    Login_Page_Object.loginBtn.click();



}catch (Exception e){
    System.out.println(e);
}

    }




}
