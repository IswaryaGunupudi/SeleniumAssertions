import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage_Assertion;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class _7_Assertions_Computer_Database {

        WebDriver driver = null;

        @BeforeMethod
        public void setUp() throws IOException, ParseException {
            // String url = "https://computer-database.gatling.io/";
            String chromeDriverPath = "C:\\software\\chromedriver_win32\\chromedriver.exe";
            String urlSoftPath = "src/main/resources/UrlAssertion.json";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            FileReader fr = new FileReader(urlSoftPath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            JSONObject jsonObject = (JSONObject) obj;
            String url = (String) jsonObject.get("url");
            System.out.println(url);
            driver.get(url);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void searchComputerUsingAlphabet() throws InterruptedException, IOException, ParseException {
            //try{
            String searchComputerDataPath = "src/main/resources/SearchComputerAssertion.json";
            FileReader fr = new FileReader(searchComputerDataPath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject tc = (JSONObject) jsonObject.get("tc01");
            String searchText = (String) tc.get("searchText");
            System.out.println(searchText);
            String expectedMessage = "Computers found";
            HomePage_Assertion hp = new HomePage_Assertion(driver);
            hp.setSearchText(searchText);
            hp.clickSearchText();
            Thread.sleep(5000);
            String actualMessage = hp.getH1Heading();
            SoftAssertions softly = new SoftAssertions();
            softly.assertThat(actualMessage).contains(expectedMessage);
            String[] arrMessage = actualMessage.split(" ");
            int numberOfComputers = parseInt(arrMessage[0]);
            softly.assertThat(numberOfComputers).isGreaterThanOrEqualTo(1);
            assertThat(numberOfComputers).isGreaterThanOrEqualTo(100);

        }

        @Test
        public void searchComputerUsingNumber() throws InterruptedException, IOException, ParseException {
            //try{
            String searchComputerDataPath = "src/main/resources/SearchComputerAssertion.json";
            FileReader fr = new FileReader(searchComputerDataPath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject tc = (JSONObject) jsonObject.get("tc04");
            String searchText = (String) tc.get("searchText");
            System.out.println(searchText);
            String expectedMessage = "Computers found";
            HomePage_Assertion hp = new HomePage_Assertion(driver);
            hp.setSearchText(searchText);
            hp.clickSearchText();
            Thread.sleep(5000);
            String actualMessage = hp.getH1Heading();
            SoftAssertions softly = new SoftAssertions();
            softly.assertThat(actualMessage).contains(expectedMessage);
            String[] arrMessage = actualMessage.split(" ");
            int numberOfComputers = parseInt(arrMessage[0]);
            softly.assertThat(numberOfComputers).isGreaterThanOrEqualTo(1);
            assertThat(numberOfComputers).isGreaterThanOrEqualTo(100);

        }
    }



