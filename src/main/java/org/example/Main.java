package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        static String url="https://jqueryui.com/droppable/";
        WebDriver driver;



        public void startChromeBrowser() {
            WebDriverManager.chromedriver().setup();//setup required initially.
            driver=new ChromeDriver();
            driver.manage().window().maximize();

        }


        public void draganddroptest() throws InterruptedException {
            driver.get(url);
            //switch to frame
            driver.switchTo().frame(0);// By index approach

            //locate an element of drag and drop box
            WebElement source=driver.findElement(By.id("draggable"));
            WebElement destination=driver.findElement(By.id("droppable"));

            //before dropping
            String pretext=destination.getText();//drop here
            String precolor=destination.getCssValue("background-color");
            System.out.println(pretext);
            System.out.println(precolor);

            //perform an action-
            Actions actions=new Actions(driver);
            actions.dragAndDrop(source, destination).perform();

            Thread.sleep(2000);

            //after dropping
            String aftertext=destination.getText();//drop here
            String aftercolor=destination.getCssValue("background-color");
            System.out.println(aftertext);
            System.out.println(aftercolor);



            //validate
            if(aftertext.equals("Dropped!") && aftercolor.equals("rgba(255, 250, 144, 1)"))
            {
                System.out.println("Drag and Drop sucessfully done.");
            }else {
                System.out.println("Drag and Drop operation are not done properly");
            }
        }

       
        public void closeChromeBrowser() {
            driver.quit();
        }

    }
