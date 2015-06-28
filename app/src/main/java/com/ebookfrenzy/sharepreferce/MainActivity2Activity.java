package com.ebookfrenzy.sharepreferce;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2Activity extends AppCompatActivity {

    private static final String DEFAULT = "na" ;
    TextView userNameTextView, passwordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        userNameTextView = (TextView)findViewById(R.id.textView5);
        passwordTextView = (TextView)findViewById(R.id.textView6);
    }

    public void load(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", DEFAULT);
        String password = sharedPreferences.getString("password", DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)) {
            Toast.makeText(this, "NoData was Found", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Data Loaded Successfully", Toast.LENGTH_LONG).show();
            userNameTextView.setText(name);
            passwordTextView.setText(password);
        }

    }

    public void previous(View view) {

        Toast.makeText(this, "previous", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
