package userInterface.common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PlaywrightDriver {
    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    public static PlaywrightDriver playwrightDriver;
    private Playwright playwright;
    public Browser browser;
    public Page page;
    public static Properties OR = new Properties();
    public static Properties config = new Properties();
    private static FileInputStream fis;
    private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
    private static ThreadLocal<Browser> br = new ThreadLocal<>();
    private static ThreadLocal<Page> pg = new ThreadLocal<>();

    PlaywrightDriver() {
        try {
            fis = new FileInputStream("./src/main/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            OR.load(fis);
            log.info("OR Properties file loaded.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            fis = new FileInputStream("./src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            config.load(fis);
            log.info("config Properties file loaded.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        playwright = Playwright.create();
        pw.set(playwright);

        if (config.get("browser").equals("chrome")) {
            log.info("Launching Chrome browser");
            browser = getPlaywright().chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        } else if (config.get("browser").equals("firefox")) {
            log.info("Launching firefox browser");
            browser = getPlaywright().firefox()
                    .launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false));
        }
        br.set(browser);
        page= getBrowser().newPage();
        pg.set(page);
    }

    public static Playwright getPlaywright(){
        return pw.get();
    }
    public static Browser getBrowser(){
        return br.get();
    }
    public static Page getPage(){
        return pg.get();
    }

    public static void setupDriver(){
        playwrightDriver = new PlaywrightDriver();
    }

    public static void openPage(String url){
        getPage().navigate(url);
    }

    public static void closeBrowser(){
        getPage().close();
        getBrowser().close();
    }
    public void quitPlaywright(){
        if(getPage()!=null){
            playwright.close();
        }
    }
}
