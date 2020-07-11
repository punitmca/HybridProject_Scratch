package com.Hybridproject.testCases;

import com.Hybridproject.Utilities.XLUtils;
import com.Hybridproject.pageobject.LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Login_002 extends BaseClass
{
    @Test(dataProvider="LoginData")
    public void loginDDT(String uname, String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(uname);
        logger.info("userName Provided");
        lp.setPassword(pwd);
        logger.info("Password provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        if (isAlerPresent() == true) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("login failed");
        } else
        Assert.assertTrue(true);
        logger.warn("login passed");
        lp.clickLogout();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

    }


    public boolean isAlerPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
                     return false;
        }

    }


    @DataProvider(name = "LoginData")
    Object [][] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/com/Hybridproject/testData/LoginData.xlsx";

        int rowcount = XLUtils.getRowCount(path,"Sheet1");
        int colcount = XLUtils.getCellCount(path,"Sheet1",1);

        String loginData[][] = new String[rowcount][colcount];
        for (int i =1; i<=rowcount; i++){
            for (int j=0; j<colcount;j++){
                loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }


        return loginData;

    }
}
