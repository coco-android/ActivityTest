package com.example.wangzz.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 1. 返回首页
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        // 2. 打开url 打开本地浏览器
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        // 3. 获取上一个活动的数据
        final Intent intent = getIntent();
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String extra_data = intent.getStringExtra("extra_data");
                Toast.makeText(SecondActivity.this, "您传递的数据是：" + extra_data, Toast.LENGTH_SHORT).show();
            }
        });

        // 4. 传递数据给上一个活动
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                intent1.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

    /**
     * 重写Back返回键处理事件
     */
    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("data_return", "Hello FirstActivity 这是Back键返回给FirstActivity的数据");
        setResult(RESULT_OK, intent);
        finish();
    }

}
