import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
    public class StepImplementation extends BaseTest{
        AppiumDriver driver;
        Logger logger = LogManager.getLogger(LogSetup.class);

        @Step("<wait> saniye bekle")
        public void waitForSecond(int wait) throws InterruptedException {
            Thread.sleep(1000 * wait);
        }


        @Step("id <id> li elementi bul ve <text> alanını kontrol et")
        public void textAreaControlId(String id,String text){
            Assert.assertTrue("Element text değerini içerir",appiumDriver.findElement(By.id(id)).getText().contains(text));
            logger.info("Idli elementin text alani kontrol edildi.");
        }

        @Step("Xpath <xpath> içeren elementi bul ve <text> alanını kontrol et")
        public void textAreaControlXpath(String xpath, String text){
            Assert.assertTrue("Element text değerini içerir",appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
            logger.info("Xpath'li elementin text alani kontrol edildi.");
        }


        @Step("<id> id'li elemente tıkla")
        public void clickByid(String selectorid) {
            appiumDriver.findElement(By.id(selectorid)).click();
            logger.info("Id'li elemente tiklandi.");
        }




        @Step("<id> id'li elemente <text> yaz")
        public void sendKeysById(String id, String text) {
            appiumDriver.findElement(By.id(id)).sendKeys(text);
            logger.info("Id'li elementin text alanina yazildi.");
        }

        @Step("<xpath> li elemente tıkla")
        public void clickByXpath(String xpath){appiumDriver.findElement(By.xpath(xpath)).click();
            logger.info("Xpath'li elemente tiklandi.");
        }

        @Step("Sayfayı aşağı kaydır")
        public void scrollAction(){
            final int ANIMATION_TIME = 200;
            final int PRESS_TIME = 200;
            int edgeBorder = 10;
            PointOption pointOptionStart, pointOptionEnd;
            Dimension dims = appiumDriver.manage().window().getSize();
            pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
            pointOptionEnd = PointOption.point(dims.width/2, edgeBorder);
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        }



        @Step("Elementler <xpath> arasından rastgele bir tanesini seç ve tıkla")
        public void clickRandomelement(String xpath){
            Random random = new Random();
            List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
            int index = random.nextInt(products.size());
            products.get(index).click();
            logger.info("Xpatli'li elementten rastgele bir tanesi secildi ve tiklandi.");
        }




    }
