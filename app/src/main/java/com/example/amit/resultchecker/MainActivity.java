package com.example.amit.resultchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText noSubjects;
    private Button noSubjectsButton;
    private int noOfSubjects;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noSubjects = (EditText) findViewById(R.id.no_subjects);
        noSubjectsButton = (Button) findViewById(R.id.no_subjects_button);
        noSubjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(noSubjects.getText().toString()).equals("")) {
                    noOfSubjects = Integer.parseInt(noSubjects.getText().toString());
                /*s = String.valueOf(noOfSubjects);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();*/
                    Intent i;
                    i = new Intent(MainActivity.this, Subjects.class);
                    i.putExtra("No of subjects", noOfSubjects);
                    startActivity(i);

                }
                else
                    Toast.makeText(getApplicationContext(), "Dude!!! Write something (Atleast here)", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
