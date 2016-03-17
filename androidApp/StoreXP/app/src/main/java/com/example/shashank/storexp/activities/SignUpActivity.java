package com.example.shashank.storexp.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shashank.storexp.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText mName=(EditText)findViewById(R.id.name);
        EditText mEmail=(EditText)findViewById(R.id.email);
        EditText mPassword=(EditText)findViewById(R.id.password);
        EditText mPhone=(EditText)findViewById(R.id.phone_num);
        EditText mEnter_OTP=(EditText)findViewById(R.id.enter_otp);

        Button mSend_OTP= (Button)findViewById(R.id.send_otp);
        Button mVerify_OTP= (Button)findViewById(R.id.verify_otp);
        Button mCreate_Account= (Button)findViewById(R.id.create_account);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/Brandon_Grotesque_Regular.ttf");
        mSend_OTP.setTypeface(typeface);
        mVerify_OTP.setTypeface(typeface);
        mCreate_Account.setTypeface(typeface);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
