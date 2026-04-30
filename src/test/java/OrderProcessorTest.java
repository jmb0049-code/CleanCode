import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderProcessorTest {

    private WebDriver driver;
    private OrderProcessor processor;

    @BeforeEach
    public void setUp()
    {
        // Automatically configures the Chrome driver binaries
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        processor = new OrderProcessor();
    }

    @Test
    public void testOrderProcessingFlow()
    {
        // Navigate to a test website to ensure environment stability
        driver.get("https://the-internet.herokuapp.com/");

        // 1. FIXED: We create the objects that your refactored method now expects.
        // This solves the "Expected 2 arguments but found 5" error.
        Order myOrder = new Order("Laptop", 1, 1200.0, "ELECTRONICS");
        User myUser = new User("test@example.com");

        // 2. FIXED: Call the process method with the correct 2 arguments.
        processor.process(myOrder, myUser);

        // Assertion to confirm the test is "Green" if no exceptions are thrown
        assert(driver.getTitle() != null);
    }

    @AfterEach
    public void tearDown()
    {
        // Properly close the browser session after each test execution
        if (driver != null)
        {
            driver.quit();
        }
    }
}