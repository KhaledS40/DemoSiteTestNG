package AddExtentionAndProxyEX;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddingExtentionAndProxyExample {

    public static void main(String[] args) {

    /*
        .   Adding Extension
        .   In order to Bypass the privacy connection error page, we have to create ChromeOptions class with its object
     */

        ChromeOptions option = new ChromeOptions();

        /*
            .   /*when we wanna open any extensions with our browser
				 * we use object of our chrome options which option and hit dot. then select addExtension method
				 * inside the argument for the add Extension barracade, we should give the path for that file, we should download it and
				 get the path and put it inside the argument

         */
				 //options.addExtensions("path of file");


        WebDriver driver = new ChromeDriver(option);

        /* How to set proxy in the project
         * First setting up chrome options and passing the options object in the chromedriver argument
         * we have to create Proxy class and its object
         * then using the chromeOptions object which is option and hit dot. then select on of the method for the proxy there are so many it depends how the company set up the proxy
         * then using options object hit dot. then get setCapability method and it takes two arguments one we pass "proxy" as string and the other one proxy the object of the proxy class
         *
         */

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        option.setCapability("proxy", proxy);
    }
}
