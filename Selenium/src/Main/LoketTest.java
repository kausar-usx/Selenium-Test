package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoketTest {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();


		        // Create a new instance of the ChromeDriver
		        WebDriver driver1 = new ChromeDriver();

		        // Launch the webloketr.com website
		        driver1.get("https://www.loket.com/");

		        // Accept the cookie consent dialog (if present)
		        try {
		            WebElement acceptButton = driver1.findElement(By.id("cn-accept-cookie"));
		            acceptButton.click();
		        } catch (NoSuchElementException e) {
		            // Cookie consent dialog not found, continue with the test
		        }

		        // Find the search input field
		        WebElement searchInput = driver1.findElement(By.id("search"));
		        searchInput.sendKeys("Acer predator");

		        // Submit the search form
		        searchInput.submit();

		        // Wait for the search results page to load
		        WebDriverWait wait = new WebDriverWait(driver1, 10);
		        wait.until(ExpectedConditions.titleContains("Search Results"));

		        // Get the search results
		        WebElement searchResults = driver1.findElement(By.id("search-results"));
		        List<WebElement> searchItems = searchResults.findElements(By.className("search-item"));

		        // Verify that search results are displayed
		        if (!searchItems.isEmpty()) {
		            System.out.println("Search results found!");
		        } else {
		            System.out.println("No search results found.");
		        }

		        // Click on the first search result
		        WebElement firstSearchResult = searchItems.get(0);
		        firstSearchResult.click();

		        // Wait for the details page to load
		        wait.until(ExpectedConditions.titleContains("Details"));

		        // Get the details of the selected item
		        WebElement itemTitle = driver1.findElement(By.id("item-title"));
		        WebElement itemDescription = driver1.findElement(By.id("item-description"));

		        // Print the details of the selected item
		        System.out.println("Title: " + itemTitle.getText());
		        System.out.println("Description: " + itemDescription.getText());

		        // Close the browser
		        driver1.quit();
		    }
		}
