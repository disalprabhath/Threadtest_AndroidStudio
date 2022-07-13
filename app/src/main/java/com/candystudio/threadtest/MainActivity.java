package com.candystudio.threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/* 1st */
        LinearLayout linlaystart = new LinearLayout(this);
        linlaystart.setOrientation(LinearLayout.VERTICAL);
        setContentView(linlaystart);

        Button btx = new Button(this);
        btx.setText("started");
        linlaystart.addView(btx);
/* 2nd */
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int m=0; m<=5; m++) {
                    for (int k = 0; k <= 5000000; k++) {
                        String cc="nummmm:"+k;
                    }
                    Log.e("loopcount","step:"+m+"done");

                    int finalM = m;
                    runOnUiThread(new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Button btstep = new Button(MainActivity.this);
                            btstep.setText("step:"+ finalM +"done");
                            linlaystart.addView(btstep);

                        }
                    }));





                }

            }  }).start();
    }
}