package com.emnets.luoly.robotiummulti;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private ListView listView;
    static final int Count_Listview = 20;
    private List<TestClass> list;

    Button Btn1 = null;
    Button Btn2 = null;

    private WebView webView;

    private String webIp="http://www.baidu.com/";
   // private String webIp="http://www.zju.edu.cn/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Btn1 = (Button) findViewById(R.id.button1);
        Btn2 = (Button) findViewById(R.id.button2);

        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);

/*
        listView = new ListView(this);
        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<TestClass>();
        // 集合中添加定义好的数据
        for (int i = 0; i < Count_Listview; i++) {
            TestClass tc = new TestClass();
            tc.setId(i + 1);
            tc.setName("测试" + (i + 1));
            list.add(tc);
        }

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
        listView.setAdapter(myAdapter);
*/

        initWebView();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Btn1.setText("Clicked");
                break;
            case R.id.button2:
                Btn2.setText("Clicked");
                break;

            default:
                break;
        }

    }


    private void initWebView(){
        webView = (WebView) findViewById(R.id.webView);
        //启用支持javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //WebView加载web资源
        webView.loadUrl(webIp);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}