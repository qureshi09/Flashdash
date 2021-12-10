package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Object {

    @FindBy(xpath="//span[contains(text(),\" Leaderboard for \")]")
    public static WebElement title;

    @FindBy(className="alert-danger")
    public static WebElement errorMessage;

    @FindBy(name="email")
    public static WebElement email;


    @FindBy(name="password")
    public static WebElement password;

    @FindBy(xpath="/html/body/div/div[2]/div/div/form/div[3]/button")
    public static WebElement loginBtn;



}
