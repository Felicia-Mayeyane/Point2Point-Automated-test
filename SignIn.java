import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignIn {
    public static void main(String[] args) {


        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website with the provided link
            driver.get("https://point-to-point-remix-production.up.railway.app");

            // Maximize the window
            driver.manage().window().maximize();

            // Set up explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Wait for the email field to be present
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='radix-:R58n6fcvbjsq:']")
            ));
            emailField.clear();
            emailField.sendKeys("adebola@bridgelabs.design");

            // Locate the 'Continue' button using the CSS selector
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                            "body > div.radix-themes > div > div.rt-Grid.rt-r-gtc.rt-r-gtr.rt-r-ai-center.rt-r-jc-center.rt-r-p-4.rt-r-ga > div > div.rt-reset.rt-BaseCard.rt-Card.rt-r-size-4.xs\\:rt-r-size-5.rt-variant-surface > form > div > div > button"
                    )
            ));
            continueButton.click();

            // Wait for the redirect to the password page
            wait.until(ExpectedConditions.urlContains("passionate-balloon-58-staging.authkit.app/password"));

            // Wait for the password field to be present
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='radix-:r1:']")
            ));
            passwordField.clear();
            passwordField.sendKeys("TestSomething13#");

            // Locate the 'Sign In' button using XPath
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/form/div/button")
            ));
            signInButton.click();

            // Optional: Wait for success (dashboard or final redirect)
            wait.until(ExpectedConditions.urlContains("point-to-point-remix-production.up.railway.app/callback"));

            System.out.println("Sign-in flow completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}




