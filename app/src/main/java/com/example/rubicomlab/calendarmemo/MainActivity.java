package com.example.rubicomlab.calendarmemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SELECT_JANUARY = 1;
    public static final int REQUEST_CODE_SELECT_FEBRUARY = 2;
    public static final int REQUEST_CODE_SELECT_MARCH = 3;
    public static final int REQUEST_CODE_SELECT_APRIL = 4;
    public static final int REQUEST_CODE_SELECT_MAY = 5;
    public static final int REQUEST_CODE_SELECT_JUNE = 6;
    public static final int REQUEST_CODE_SELECT_JULY = 7;
    public static final int REQUEST_CODE_SELECT_AUGUST = 8;
    public static final int REQUEST_CODE_SELECT_SEPTEMBER = 9;
    public static final int REQUEST_CODE_SELECT_OCTOBER = 10;
    public static final int REQUEST_CODE_SELECT_NOVEMBER = 11;
    public static final int REQUEST_CODE_SELECT_DECEMBER = 12;
    public static int hang;
    public static int yeol;
    public static int command = 0;
    private String path;
    public static void setTextViewColorPartial(TextView view, String fulltext, String subtext, int color) {
        view.setText(fulltext, TextView.BufferType.SPANNABLE);
        Spannable str = (Spannable) view.getText();
        int i = fulltext.indexOf(subtext);
        str.setSpan(new ForegroundColorSpan(color), i, i + subtext.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    Calendar cal= new GregorianCalendar();
    private String[] calHeader = {"일","월","화","수","목","금","토"};
    private String[][] calDate1 = new String[7][7];
    private String[][] calDate2 = new String[7][7];
    private String[][] calDate3 = new String[7][7];
    private String[][] calDate4 = new String[7][7];
    private String[][] calDate5 = new String[7][7];
    private String[][] calDate6 = new String[7][7];
    private String[][] calDate7 = new String[7][7];
    private String[][] calDate8 = new String[7][7];
    private String[][] calDate9 = new String[7][7];
    private String[][] calDate10 = new String[7][7];
    private String[][] calDate11 = new String[7][7];
    private String[][] calDate12 = new String[7][7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToday();
        setCalendar();
        setmemo();
    }

    public void setmemo()
    {
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        //Toast.makeText(this,path,Toast.LENGTH_LONG).show();
        onTextReading();
    }

    public void setToday()
    {
        TextView date = (TextView)findViewById(R.id.date);
        String daycontent = String.format("%02d", cal.get(Calendar.DATE));
        if(command == 0) date.setText((cal.get(Calendar.MONTH)+1)+" 월 " + daycontent+" 일");
    }

    public void setCalendar() {
        int i = 0, h = 0, days = 0;
        int nextmonthstart;
        String content;
        LinearLayout calview = (LinearLayout)findViewById(R.id.calendarLayout);
        /*********************************calendar1 start******************************************/
        Button month1 = new Button(this);
        month1.setTextSize(15);
        nextmonthstart = 4;
        h = nextmonthstart;
        cal.set(2016,Calendar.JANUARY,15);
        final int startday1 = nextmonthstart+1;
        final int lastday1 = cal.getActualMaximum(cal.DATE);
        final int thismonth1 = 1;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate1[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate1[i][h] = content;
        }
        nextmonthstart = h;
        month1.setText("1"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate1[i][h] == null) month1.setText(month1.getText() + "__" + " ");
                else month1.setText(month1.getText() + calDate1[i][h] + " ");
            }
            month1.setText(month1.getText() + "\n");
        }
        calview.addView(month1);

        month1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth1);
                intent.putExtra("start", startday1);
                intent.putExtra("last", lastday1);
                startActivityForResult(intent, REQUEST_CODE_SELECT_JANUARY);
            }
        });
        if(calDate1[hang][yeol] !=null && command == REQUEST_CODE_SELECT_JANUARY)
        {
            setTextViewColorPartial(month1,month1.getText().toString(),calDate1[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("1 월 " + calDate1[hang][yeol]+" 일");
        }
        /*********************************calendar1 finish*****************************************/
        /*********************************calendar2 start******************************************/
        Button month2 = new Button(this);
        month2.setTextSize(15);
        h = nextmonthstart;
        final int startday2 = nextmonthstart+1;
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday2 = cal.getActualMaximum(cal.DATE);
        final int thismonth2 = 2;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate2[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate2[i][h] = content;
        }
        nextmonthstart = h;
        month2.setText("2"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate2[i][h] == null) month2.setText(month2.getText() + "__" + " ");
                else month2.setText(month2.getText() + calDate2[i][h] + " ");
            }
            month2.setText(month2.getText() + "\n");
        }
        calview.addView(month2);

        month2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth2);
                intent.putExtra("start", startday2);
                intent.putExtra("last", lastday2);
                startActivityForResult(intent, REQUEST_CODE_SELECT_FEBRUARY);
            }
        });
        if(calDate2[hang][yeol] !=null && command == REQUEST_CODE_SELECT_FEBRUARY)
        {
            setTextViewColorPartial(month2,month2.getText().toString(),calDate2[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("2 월 " + calDate2[hang][yeol]+" 일");
        }
        /*********************************calendar2 finish*****************************************/
        /*********************************calendar3 start******************************************/
        Button month3 = new Button(this);
        month3.setTextSize(15);
        h = nextmonthstart;
        final int startday3 = nextmonthstart+1;
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday3 = cal.getActualMaximum(cal.DATE);
        final int thismonth3 = 3;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate3[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate3[i][h] = content;
        }
        nextmonthstart = h;
        month3.setText("3"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate3[i][h] == null) month3.setText(month3.getText() + "__" + " ");
                else month3.setText(month3.getText() + calDate3[i][h] + " ");
            }
            month3.setText(month3.getText() + "\n");
        }
        calview.addView(month3);

        month3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth3);
                intent.putExtra("start", startday3);
                intent.putExtra("last", lastday3);
                startActivityForResult(intent, REQUEST_CODE_SELECT_MARCH);
            }
        });
        if(calDate3[hang][yeol] !=null && command == REQUEST_CODE_SELECT_MARCH)
        {
            setTextViewColorPartial(month3,month3.getText().toString(),calDate3[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("3 월 " + calDate3[hang][yeol]+" 일");
        }
        /*********************************calendar3 finish*****************************************/
        /*********************************calendar4 start******************************************/
        Button month4 = new Button(this);
        month4.setTextSize(15);
        h = nextmonthstart;
        final int startday4 = nextmonthstart+1;
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday4 = cal.getActualMaximum(cal.DATE);
        final int thismonth4 = 4;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate4[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate4[i][h] = content;
        }
        nextmonthstart = h;
        month4.setText("4"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate4[i][h] == null) month4.setText(month4.getText() + "__" + " ");
                else month4.setText(month4.getText() + calDate4[i][h] + " ");
            }
            month4.setText(month4.getText() + "\n");
        }
        calview.addView(month4);

        month4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth4);
                intent.putExtra("start", startday4);
                intent.putExtra("last", lastday4);
                startActivityForResult(intent, REQUEST_CODE_SELECT_APRIL);
            }
        });
        if(calDate4[hang][yeol] !=null && command == REQUEST_CODE_SELECT_APRIL)
        {
            setTextViewColorPartial(month4,month4.getText().toString(),calDate4[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("4 월 " + calDate4[hang][yeol]+" 일");
        }
        /*********************************calendar4 finish*****************************************/
        /*********************************calendar5 start******************************************/
        Button month5 = new Button(this);
        month5.setTextSize(15);
        h = nextmonthstart;
        final int startday5 = nextmonthstart+1;
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday5 = cal.getActualMaximum(cal.DATE);
        final int thismonth5 = 5;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate5[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate5[i][h] = content;
        }
        nextmonthstart = h;
        month5.setText("5"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate5[i][h] == null) month5.setText(month5.getText() + "__" + " ");
                else month5.setText(month5.getText() + calDate5[i][h] + " ");
            }
            month5.setText(month5.getText() + "\n");
        }
        calview.addView(month5);

        month5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth5);
                intent.putExtra("start", startday5);
                intent.putExtra("last", lastday5);
                startActivityForResult(intent, REQUEST_CODE_SELECT_MAY);
            }
        });
        if(calDate5[hang][yeol] !=null && command == REQUEST_CODE_SELECT_MAY)
        {
            setTextViewColorPartial(month5,month5.getText().toString(),calDate5[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("5 월 " + calDate5[hang][yeol]+" 일");
        }
        /*********************************calendar5 finish*****************************************/
        /*********************************calendar6 start****************************************/
        Button month6 = new Button(this);
        month6.setTextSize(15);
        h = nextmonthstart;
        final int startday6 = nextmonthstart+1;
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday6 = cal.getActualMaximum(cal.DATE);
        final int thismonth6 = 6;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate6[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate6[i][h] = content;
        }
        nextmonthstart = h;
        month6.setText("6"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate6[i][h] == null) month6.setText(month6.getText() + "__" + " ");
                else month6.setText(month6.getText() + calDate6[i][h] + " ");
            }
            month6.setText(month6.getText() + "\n");
        }
        calview.addView(month6);

        month6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth6);
                intent.putExtra("start", startday6);
                intent.putExtra("last", lastday6);
                startActivityForResult(intent, REQUEST_CODE_SELECT_JUNE);
            }
        });
        if(calDate6[hang][yeol] !=null && command == REQUEST_CODE_SELECT_JUNE)
        {
            setTextViewColorPartial(month6,month6.getText().toString(),calDate6[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("6 월 " + calDate6[hang][yeol]+" 일");
        }
        /************************************calendar6 finish************************************/
        /**********************************calendar7 start*************************************/
        h = nextmonthstart;
        final int startday7 = nextmonthstart+1;
        Button month7 = new Button(this);
        month7.setTextSize(15);
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday7 = cal.getActualMaximum(cal.DATE);
        final int thismonth7 = 7;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate7[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate7[i][h] = content;
        }
        nextmonthstart = h;
        month7.setText("7"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate7[i][h] == null) month7.setText(month7.getText() + "__" + " ");
                else month7.setText(month7.getText() + calDate7[i][h] + " ");
            }
            month7.setText(month7.getText() + "\n");
        }
        calview.addView(month7);

        month7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth7);
                intent.putExtra("start", startday7);
                intent.putExtra("last", lastday7);
                startActivityForResult(intent, REQUEST_CODE_SELECT_JULY);
            }
        });
        if(calDate7[hang][yeol] !=null && command == REQUEST_CODE_SELECT_JULY)
        {
            setTextViewColorPartial(month7,month7.getText().toString(),calDate7[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("7 월 " + calDate7[hang][yeol]+" 일");
        }
        /**************************calendar7 finish********************************************/
        /************************************calendar8 start***********************************/
        h = nextmonthstart;
        final int startday8 = nextmonthstart+1;
        Button month8 = new Button(this);
        month8.setTextSize(15);
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday8 = cal.getActualMaximum(cal.DATE);
        final int thismonth8 = 8;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate8[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate8[i][h] = content;
        }
        nextmonthstart = h;
        month8.setText("8"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate8[i][h] == null) month8.setText(month8.getText() + "__" + " ");
                else month8.setText(month8.getText() + calDate8[i][h] + " ");
            }
            month8.setText(month8.getText() + "\n");
        }
        calview.addView(month8);
        month8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth8);
                intent.putExtra("start", startday8);
                intent.putExtra("last", lastday8);
                startActivityForResult(intent, REQUEST_CODE_SELECT_AUGUST);
            }
        });
        if(calDate8[hang][yeol] !=null && command == REQUEST_CODE_SELECT_AUGUST)
        {
            setTextViewColorPartial(month8,month8.getText().toString(),calDate8[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("8 월 " + calDate8[hang][yeol]+" 일");
        }
        /******************************calendar8 finish*******************************************/
        /******************************calendar9 start********************************************/
        h = nextmonthstart;
        final int startday9 = nextmonthstart+1;
        Button month9 = new Button(this);
        month9.setTextSize(15);
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday9 = cal.getActualMaximum(cal.DATE);
        final int thismonth9 = 9;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate9[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate9[i][h] = content;
        }
        nextmonthstart = h;
        month9.setText("9"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate9[i][h] == null) month9.setText(month9.getText() + "__" + " ");
                else month9.setText(month9.getText() + calDate9[i][h] + " ");
            }
            month9.setText(month9.getText() + "\n");
        }
        calview.addView(month9);
        month9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth9);
                intent.putExtra("start", startday9);
                intent.putExtra("last", lastday9);
                startActivityForResult(intent, REQUEST_CODE_SELECT_SEPTEMBER);
            }
        });
        if(calDate9[hang][yeol] !=null && command == REQUEST_CODE_SELECT_SEPTEMBER)
        {
            setTextViewColorPartial(month9,month9.getText().toString(),calDate9[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("9 월 " + calDate9[hang][yeol]+" 일");
        }
        /******************************calendar9 finish*******************************************/
        /******************************calendar10 start*******************************************/
        h = nextmonthstart;
        final int startday10 = nextmonthstart+1;
        Button month10 = new Button(this);
        month10.setTextSize(15);
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday10 = cal.getActualMaximum(cal.DATE);
        final int thismonth10 = 10;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate10[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate10[i][h] = content;
        }
        nextmonthstart = h;
        month10.setText("10"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate10[i][h] == null) month10.setText(month10.getText() + "__" + " ");
                else month10.setText(month10.getText() + calDate10[i][h] + " ");
            }
            month10.setText(month10.getText() + "\n");
        }
        calview.addView(month10);
        month10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth10);
                intent.putExtra("start", startday10);
                intent.putExtra("last", lastday10);
                startActivityForResult(intent, REQUEST_CODE_SELECT_OCTOBER);
            }
        });
        if(calDate10[hang][yeol] !=null && command == REQUEST_CODE_SELECT_OCTOBER)
        {
            setTextViewColorPartial(month10,month10.getText().toString(),calDate10[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("10 월 " + calDate10[hang][yeol]+" 일");
        }
        /******************************calendar10 finish*******************************************/
        /******************************calendar11 start********************************************/
        h = nextmonthstart;
        final int startday11 = nextmonthstart+1;
        Button month11 = new Button(this);
        month11.setTextSize(15);
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday11 = cal.getActualMaximum(cal.DATE);
        final int thismonth11 = 11;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate11[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate11[i][h] = content;
        }
        nextmonthstart = h;
        month11.setText("11"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate11[i][h] == null) month11.setText(month11.getText() + "__" + " ");
                else month11.setText(month11.getText() + calDate11[i][h] + " ");
            }
            month11.setText(month11.getText() + "\n");
        }
        calview.addView(month11);

        month11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth11);
                intent.putExtra("start", startday11);
                intent.putExtra("last", lastday11);
                startActivityForResult(intent, REQUEST_CODE_SELECT_NOVEMBER);
            }
        });
        if(calDate11[hang][yeol] !=null && command == REQUEST_CODE_SELECT_NOVEMBER)
        {
            setTextViewColorPartial(month11,month11.getText().toString(),calDate11[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("11 월 " + calDate11[hang][yeol]+" 일");
        }
        /*****************************calendar11 finish********************************************/
        /*****************************calendar12 start********************************************/
        h = nextmonthstart;
        final int startday12 = nextmonthstart+1;
        Button month12 = new Button(this);
        month12.setTextSize(15);
        cal.set(cal.DATE,cal.DATE+30);
        final int lastday12 = cal.getActualMaximum(cal.DATE);
        final int thismonth12 = 12;
        //Toast.makeText(this,String.valueOf(h),Toast.LENGTH_SHORT).show();
        for(i = 0;i < 7; i++)
        {
            calDate12[0][i] = calHeader[i];
        }
        i = 1;
        for(days = 1; days <= cal.getActualMaximum(cal.DATE); days++)
        {
            h++;
            if(h == 7)
            {
                i++;
                h = 0;
            }
            content = String.format("%02d",days);
            calDate12[i][h] = content;
        }
        nextmonthstart = h;
        month12.setText("12"+"\n");
        for (i = 0; i < 7; i++) {
            for (h = 0; h < 7; h++) {
                if (calDate12[i][h] == null) month12.setText(month12.getText() + "__" + " ");
                else month12.setText(month12.getText() + calDate12[i][h] + " ");
            }
            month12.setText(month12.getText() + "\n");
        }
        calview.addView(month12);

        month12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                ComponentName name = new ComponentName("com.example.rubicomlab.calendarmemo","com.example.rubicomlab.calendarmemo.SelectActivity");
                intent.setComponent(name);
                intent.putExtra("month", thismonth12);
                intent.putExtra("start", startday12);
                intent.putExtra("last", lastday12);
                startActivityForResult(intent, REQUEST_CODE_SELECT_DECEMBER);
            }
        });
        if(calDate12[hang][yeol] !=null && command == REQUEST_CODE_SELECT_DECEMBER)
        {
            setTextViewColorPartial(month12,month12.getText().toString(),calDate12[hang][yeol],0xffff7011);
            TextView date = (TextView)findViewById(R.id.date);
            date.setText("12 월 " + calDate12[hang][yeol]+" 일");
        }
        command = 0;
        /****************************************calendar12 finish**********************************/
    }

    private void onTextWriting(String title,String body){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        file = new File(path+File.separator+title+".txt");
        try{
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(body.getBytes());
            fos.close();
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
        }catch(IOException e) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void onTextReading()
    {
        TextView date = (TextView) findViewById(R.id.date);
        TextView memo = (TextView)findViewById(R.id.memo);
        try
        {
            FileInputStream fis = new FileInputStream(path+File.separator+date.getText().toString()+".txt");
            byte[] data = new byte[fis.available()];
            while(fis.read(data) != -1){;}
            fis.close();
            memo.setText(new String(data));
        }catch (FileNotFoundException e){
            Toast.makeText(this,date.getText().toString()+"의 메모가 존재하지 않습니다",Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
        }
    }

    private AlertDialog createDialogBox()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("안내");
        builder.setMessage("정말 삭제하시겠습니까?");

        builder.setPositiveButton("예", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton)
            {
                Toast.makeText(MainActivity.this,"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                TextView date = (TextView)findViewById(R.id.date);
                File file = new File(path+File.separator+date.getText().toString()+".txt");
                file.delete();
                TextView memo = (TextView)findViewById(R.id.memo);
                memo.setText("");
                onTextReading();
            }
        });
        builder.setNegativeButton("아니오",new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialog, int whichButton)
           {
           }
        });
        AlertDialog dialog = builder.create();
        return dialog;
    }

    public void onButtonClickederasememo(View v)
    {
        AlertDialog dialog = createDialogBox();
        dialog.show();
    }

    public void onButtonClickededit(View v) { inflateedit(); }
    private void inflateedit()
    {
        final LinearLayout inflateedit = (LinearLayout) findViewById(R.id.inflateedit);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.editmemo,inflateedit,true);
        final Button writememo = (Button)findViewById(R.id.writememo);
        writememo.setVisibility(View.INVISIBLE);
        final Button erasememo = (Button)findViewById(R.id.erasememo);
        erasememo.setVisibility(View.INVISIBLE);
        final Button save = (Button)findViewById(R.id.save);    //저장
        final Button cancel = (Button)findViewById(R.id.cancel);    //취소
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                writememo.setVisibility(View.VISIBLE);
                erasememo.setVisibility(View.VISIBLE);
                TextView editText = (TextView)findViewById(R.id.editText);
                TextView date = (TextView)findViewById(R.id.date);
                if(editText.getText().toString().getBytes().length <= 0){onButtonClickederasememo(v);}
                else onTextWriting(date.getText().toString(),editText.getText().toString());
                onTextReading();
                //TextView memo = (TextView)findViewById(R.id.memo);
                //memo.setText(editText.getText().toString());
                inflateedit.removeAllViews();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                inflateedit.removeAllViews();
                writememo.setVisibility(View.VISIBLE);
                erasememo.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this,"편집취소",Toast.LENGTH_SHORT).show();
                onTextReading();
            }
        });
        EditText editText = (EditText)findViewById(R.id.editText);
        TextView memo = (TextView)findViewById(R.id.memo);
        editText.setText(memo.getText().toString());
        memo.setText("");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult(requestCode,resultCode,intent);

        if(requestCode == REQUEST_CODE_SELECT_JUNE)
        {
            if(resultCode == RESULT_OK)
            {
                hang = intent.getIntExtra("hang",0);
                yeol = intent.getIntExtra("yeol",0);
                finish();
                command = REQUEST_CODE_SELECT_JUNE;
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        }
        else if (requestCode == REQUEST_CODE_SELECT_JULY)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_JULY;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_AUGUST)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_AUGUST;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_SEPTEMBER)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_SEPTEMBER;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_OCTOBER)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_OCTOBER;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_NOVEMBER)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_NOVEMBER;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_DECEMBER)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_DECEMBER;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_MAY)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_MAY;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_APRIL)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_APRIL;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_MARCH)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_MARCH;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_FEBRUARY)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_FEBRUARY;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else if(requestCode == REQUEST_CODE_SELECT_JANUARY)
        {
            if(resultCode == RESULT_OK) {
                hang = intent.getIntExtra("hang", 0);
                yeol = intent.getIntExtra("yeol", 0);
                finish();
                command = REQUEST_CODE_SELECT_JANUARY;
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
        else Toast.makeText(this,"날짜를 다시 선택해주세요",Toast.LENGTH_SHORT).show();
    }
}
