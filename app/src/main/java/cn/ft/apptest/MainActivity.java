package cn.ft.apptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<CallRecordsBean> list = ContactsUtils.getCallRecords(MainActivity.this);
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(JsonFormatUtils.formatJson(JSON.toJSONString(list)));
        Log.i("123456", "onCreate: "+JsonFormatUtils.formatJson(JSON.toJSONString(list)));
    }

}
