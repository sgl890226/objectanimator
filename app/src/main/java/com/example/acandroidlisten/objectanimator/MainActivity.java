package com.example.acandroidlisten.objectanimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import com.example.acandroidlisten.objectanimator.Lifecycle.MyActivity;
import com.example.acandroidlisten.objectanimator.MyProgressBar.MainProActivity;
import com.example.acandroidlisten.objectanimator.animator.MainAnimatorActivity;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.Main1Activity;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.Main2Activity;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        //     Log.i("ssss","MD5encrypt:"+MD5encrypt("20180913000206309"+"list"+"1435660288"+"iGRBlCT3BYVzmIXFEDy7"));
        Log.i("ssss","方法1:"+getSecondTimestampTwo(new Date()));
        Log.i("ssss","方法2:"+System.currentTimeMillis());
        Log.i("ssss","方法3:"+getGMTTime("GMT+8"));
    }
    public static Long getGMTTime(String gmt) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(gmt));
        cal.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
        //String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        long timeInMillis = cal.getTimeInMillis();
        return timeInMillis;
    }

    /**
     * 获取精确到秒的时间戳
     * @param date
     * @return
     */
    public static int getSecondTimestampTwo(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(this, MainAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(this, Main1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(this, MainProActivity.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(this, MyActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * MD5加密 32位
     *
     * @param plaintext 明文
     * @return ciphertext 密文
     */
    public final static String MD5encrypt(String plaintext) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = plaintext.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
