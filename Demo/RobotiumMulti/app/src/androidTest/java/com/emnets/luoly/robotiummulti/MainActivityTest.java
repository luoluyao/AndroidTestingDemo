package com.emnets.luoly.robotiummulti;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.By;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by HuangChao on 2016/1/25.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    private int sleep_time = 1500;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();//这个方法将结束掉所有在测试执行过程中打开的activity
    }
    	/*
	 * 对截屏进行测试
	 * 注意：被测app需要
	 * android.permission.WRITE_EXTERNAL_STORAGE的权限
	 */

    public void test01() {
        solo.sleep(sleep_time);
        solo.takeScreenshot();
    }

	/*
	 * 对listview进行点击
	 *
	 */
    
    public void test02(){
        solo.sleep(sleep_time);
        solo.clickOnText("测试19");
        solo.takeScreenshot();
        solo.sleep(sleep_time);
    }

 	/*
	 *点击操作
	 */

    public void test03() {
        solo.sleep(sleep_time);
        solo.clickOnButton("Button 1");
        solo.clickOnButton("Button 2");
        solo.sleep(sleep_time);
    }

    /*
     * 失败情况
     *
     */
    
    public void test04(){
        solo.sleep(sleep_time);
        solo.clickOnText("测试测试");
        solo.takeScreenshot();
        solo.sleep(sleep_time);
    }
    

    /*
     *测试webview
     * 使用TextContent
     */

    public void test05(){
        solo.sleep(sleep_time);
        solo.enterTextInWebElement(By.id("index-kw"), "浙江大学");
        solo.sleep(sleep_time);
        solo.clickOnWebElement(By.textContent("百度一下"));
        solo.sleep(sleep_time);
        solo.clickOnWebElement(By.textContent("-首页"));
        solo.sleep(sleep_time);

    }

    /*
     *基于cssSelector
     */

    public void test06(){
        solo.sleep(sleep_time);
        solo.enterTextInWebElement(By.cssSelector("textarea"), "浙江大学");
        solo.sleep(sleep_time);
        solo.clickOnWebElement(By.className("se-bn"));
        solo.sleep(sleep_time);
        solo.clickOnWebElement(By.className("c-blocka"), 7);
        solo.sleep(sleep_time);

    }

    /*
     *  xpath 的方法
     */
    public void test07(){
        solo.sleep(sleep_time);
        solo.enterTextInWebElement(By.xpath("/html/body/div/div/div/form/div/textarea"), "浙江大学");
        solo.sleep(sleep_time);
        solo.clickOnWebElement(By.xpath("/html/body/div/div/div/form/div/div/button"));
        solo.sleep(sleep_time);
        solo.clickOnWebElement(By.className("c-blocka"), 7);
        solo.sleep(sleep_time);
    }


}