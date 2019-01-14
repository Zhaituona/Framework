package base;

public class Util extends CommonClass {

    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLiCIT_WAIT =10;

    public void switchToFrame(){

        driver.switchTo().frame("mainpanel");
    }

}
