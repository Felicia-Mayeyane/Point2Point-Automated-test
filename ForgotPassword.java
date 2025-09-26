import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPassword {
    public static void main(String[] args) {
     

        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
           
            driver.get("https://point-to-point-remix-production.up.railway.app");

            // Maximize the window
            driver.manage().window().maximize();

            // Set up explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Wait for the email field and enter the email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='radix-:R58n6fcvbjsq:']")
            ));
            emailField.clear();
            emailField.sendKeys("feliciamayeyane@gmail.com");

            // Locate and click the 'Continue' button
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                            "body > div.radix-themes > div > div.rt-Grid.rt-r-gtc.rt-r-gtr.rt-r-ai-center.rt-r-jc-center.rt-r-p-4.rt-r-ga > div > div.rt-reset.rt-BaseCard.rt-Card.rt-r-size-4.xs\\:rt-r-size-5.rt-variant-surface > form > div > div > button"
                    )
            ));
            continueButton.click();

            // Wait for redirect to password screen
            wait.until(ExpectedConditions.urlContains("/password"));

            // Wait for the 'Forgot password' link to be visible and click it
            WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/form/div/div[2]/div[1]/a")
            ));
            forgotPasswordLink.click();

            // Wait for the forgot password email field and enter the email
            WebElement forgotPasswordEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='radix-:rc:']")
            ));
            forgotPasswordEmailField.clear();
            forgotPasswordEmailField.sendKeys("feliciamayeyane@gmail.com");

            // Locate and click the 'Send reset instructions' button
            WebElement sendResetInstructionsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div/button")
            ));
            sendResetInstructionsButton.click();

           

            System.out.println("Forgot password flow completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
