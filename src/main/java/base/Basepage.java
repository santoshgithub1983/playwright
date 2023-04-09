package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import userInterface.common.PlaywrightDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Basepage {
    private Playwright playwright;
    public Browser browser;
    public Page page;
    private static Properties OR = new Properties();
    private static FileInputStream fis;
    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
    private static ThreadLocal<Browser> br = new ThreadLocal<>();
    private static ThreadLocal<Page> pg = new ThreadLocal<>();

    public Basepage(){
        page = PlaywrightDriver.getPage();
    }

}
