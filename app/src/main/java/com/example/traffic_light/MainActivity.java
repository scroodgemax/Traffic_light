package com.example.traffic_light;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ConstraintLayout mConstraintLayout;
private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.constrint_Layout);
        mInfoTextView = (TextView) findViewById(R.id.textView);
        Button yellowButton = (Button) findViewById(R.id.button_yellow);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText(R.string.yellow);
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.yellowColor));
            }
        });
    }

    public void onRedButtonClick(View view) {
    mInfoTextView.setText(R.string.red);
    mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.redColor));
        Toast toast = Toast.makeText(getApplicationContext(),"STOP IT!!! Stupid!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 320);
        toast.show();
    }

    public void onGreenButtonClick(View view) {
        mInfoTextView.setText(R.string.green);
        mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor));
        Toast toast3 = Toast.makeText(getApplicationContext(),
                "GO!", Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        ImageView goImageView = new ImageView(getApplicationContext());
        goImageView.setImageResource(R.drawable.go1);
        toastContainer.addView(goImageView, 0);
        toast3.show();
    }
}
