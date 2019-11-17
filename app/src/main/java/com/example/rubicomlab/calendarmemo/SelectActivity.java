package com.example.rubicomlab.calendarmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rubicom Lab on 2016-06-04.
 */
public class SelectActivity extends AppCompatActivity {
    int month;
    int start;
    int last;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectday);
        month = getIntent().getIntExtra("month", 0);
        start = getIntent().getIntExtra("start", 0);
        last = getIntent().getIntExtra("last", 0);
        setcalArray();
    }

    public void setcalArray()
    {
        i = 1;
        TextView themonth = (TextView)findViewById(R.id.themonth);
        themonth.setTextSize(35);
        themonth.setText(String.valueOf(month));
        Button b1 = (Button)findViewById(R.id.button1);
        if(start<=0)
        {
            b1.setText(String.valueOf(i));
            i++;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=0)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 0);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b2 = (Button)findViewById(R.id.button2);
        if(start<=1)
        {
            b2.setText(String.valueOf(i));
            i++;
        }
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=1)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 1);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b3 = (Button)findViewById(R.id.button3);
        if(start<=2)
        {
            b3.setText(String.valueOf(i));
            i++;
        }
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=2)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 2);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b4 = (Button)findViewById(R.id.button4);
        if(start<=3)
        {
            b4.setText(String.valueOf(i));
            i++;
        }
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=3)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 3);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b5 = (Button)findViewById(R.id.button5);
        if(start<=4)
        {
            b5.setText(String.valueOf(i));
            i++;
        }
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=4)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 4);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b6 = (Button)findViewById(R.id.button6);
        if(start<=5)
        {
            b6.setText(String.valueOf(i));
            i++;
        }
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=5)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 5);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b7 = (Button)findViewById(R.id.button7);
        if(start<=6)
        {
            b7.setText(String.valueOf(i));
            i++;
        }
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start<=6)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 1);
                    resultIntent.putExtra("yeol", 6);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });

        Button b8 = (Button)findViewById(R.id.button8);
        b8.setText(String.valueOf(i));
        i++;
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent resultIntent = new Intent();
               resultIntent.putExtra("hang", 2);
               resultIntent.putExtra("yeol", 0);
               setResult(RESULT_OK, resultIntent);
               finish();
            }
        });
        Button b9 = (Button)findViewById(R.id.button9);
        b9.setText(String.valueOf(i));
        i++;
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent resultIntent = new Intent();
               resultIntent.putExtra("hang", 2);
               resultIntent.putExtra("yeol", 1);
               setResult(RESULT_OK, resultIntent);
               finish();
            }
        });
        Button b10 = (Button)findViewById(R.id.button10);
        b10.setText(String.valueOf(i));
        i++;
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent resultIntent = new Intent();
                 resultIntent.putExtra("hang", 2);
                 resultIntent.putExtra("yeol", 2);
                 setResult(RESULT_OK, resultIntent);
                 finish();
            }
        });
        Button b11 = (Button)findViewById(R.id.button11);
        b11.setText(String.valueOf(i));
        i++;
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 2);
                resultIntent.putExtra("yeol", 3);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b12 = (Button)findViewById(R.id.button12);
        b12.setText(String.valueOf(i));
        i++;
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 2);
                resultIntent.putExtra("yeol", 4);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b13 = (Button)findViewById(R.id.button13);
        b13.setText(String.valueOf(i));
        i++;
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 2);
                resultIntent.putExtra("yeol", 5);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b14 = (Button)findViewById(R.id.button14);
        b14.setText(String.valueOf(i));
        i++;
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 2);
                resultIntent.putExtra("yeol", 6);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        Button b15 = (Button)findViewById(R.id.button15);
        b15.setText(String.valueOf(i));
        i++;
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 0);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b16 = (Button)findViewById(R.id.button16);
        b16.setText(String.valueOf(i));
        i++;
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 1);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b17 = (Button)findViewById(R.id.button17);
        b17.setText(String.valueOf(i));
        i++;
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 2);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b18 = (Button)findViewById(R.id.button18);
        b18.setText(String.valueOf(i));
        i++;
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 3);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b19 = (Button)findViewById(R.id.button19);
        b19.setText(String.valueOf(i));
        i++;
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 4);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b20 = (Button)findViewById(R.id.button20);
        b20.setText(String.valueOf(i));
        i++;
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 5);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b21 = (Button)findViewById(R.id.button21);
        b21.setText(String.valueOf(i));
        i++;
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 3);
                resultIntent.putExtra("yeol", 6);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        Button b22 = (Button)findViewById(R.id.button22);
        b22.setText(String.valueOf(i));
        i++;
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 0);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b23 = (Button)findViewById(R.id.button23);
        b23.setText(String.valueOf(i));
        i++;
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 1);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b24 = (Button)findViewById(R.id.button24);
        b24.setText(String.valueOf(i));
        i++;
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 2);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b25 = (Button)findViewById(R.id.button25);
        b25.setText(String.valueOf(i));
        i++;
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 3);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b26 = (Button)findViewById(R.id.button26);
        b26.setText(String.valueOf(i));
        i++;
        b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 4);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b27 = (Button)findViewById(R.id.button27);
        b27.setText(String.valueOf(i));
        i++;
        b27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 5);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        Button b28 = (Button)findViewById(R.id.button28);
        b28.setText(String.valueOf(i));
        i++;
        b28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hang", 4);
                resultIntent.putExtra("yeol", 6);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        Button b29 = (Button)findViewById(R.id.button29);
        if(last>=i)
        {
            b29.setText(String.valueOf(i));
            i++;
        }
        b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=29-start) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 0);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b30 = (Button)findViewById(R.id.button30);
        if(last>=i)
        {
            b30.setText(String.valueOf(i));
            i++;
        }
        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>= 30-start) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 1);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b31 = (Button)findViewById(R.id.button31);
        if(last>=i)
        {
            b31.setText(String.valueOf(i));
            i++;
        }
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=31-start) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 2);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b32 = (Button)findViewById(R.id.button32);
        if(last>=i)
        {
            b32.setText(String.valueOf(i));
            i++;
        }
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=32-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 3);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b33 = (Button)findViewById(R.id.button33);
        if(last>=i)
        {
            b33.setText(String.valueOf(i));
            i++;
        }
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=33-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 4);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b34 = (Button)findViewById(R.id.button34);
        if(last>=i)
        {
            b34.setText(String.valueOf(i));
            i++;
        }
        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=34-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 5);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b35 = (Button)findViewById(R.id.button35);
        if(last>=i)
        {
            b35.setText(String.valueOf(i));
            i++;
        }
        b35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=35-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 5);
                    resultIntent.putExtra("yeol", 6);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });

        Button b36 = (Button)findViewById(R.id.button36);
        if(last>=i)
        {
            b36.setText(String.valueOf(i));
            i++;
        }
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=36-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 6);
                    resultIntent.putExtra("yeol", 0);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b37 = (Button)findViewById(R.id.button37);
        if(last>=i)
        {
            b37.setText(String.valueOf(i));
            i++;
        }
        b37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=37-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 6);
                    resultIntent.putExtra("yeol", 1);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b38 = (Button)findViewById(R.id.button38);
        if(last>=i)
        {
            b38.setText(String.valueOf(i));
            i++;
        }
        b38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last>=38-start)
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hang", 6);
                    resultIntent.putExtra("yeol", 2);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b39 = (Button)findViewById(R.id.button39);
        b39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b40 = (Button)findViewById(R.id.button40);
        b40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b41 = (Button)findViewById(R.id.button41);
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
        Button b42 = (Button)findViewById(R.id.button42);
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectActivity.this,"날짜초과범위입니다",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
