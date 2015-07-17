package com.example.amit.resultchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 13-Jul-15.
 */
public class Subjects extends Activity {

    private int noOfSubjects;
    private int credits[];
    private String subs[];
    private EditText subss[];
    private  int flag=0;
    private Spinner credt[];
    private List<String> credts;
    private ArrayAdapter<String> dataAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        noOfSubjects = extras.getInt("No of subjects");
        ScrollView sv = new ScrollView(this);
        credt = new Spinner[noOfSubjects+1];
        credts = new ArrayList<String>();
        credts.add("5");
        credts.add("4");
        credts.add("3");
        credts.add("2");
        credts.add("1");
        credts.add("0");
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,credts);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.VERTICAL);
        l1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        subss = new EditText[noOfSubjects+1];
        credits = new int[noOfSubjects];
        credt = new Spinner[noOfSubjects+1];
        subs = new String[noOfSubjects];
        for (int i = 0; i <= noOfSubjects; i++) {
            subss[i] = new EditText(this);
            credt[i] = new Spinner(this);
            if (i < noOfSubjects) {
                subss[i].setLayoutParams(lparams);
                credt[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                credt[i].setAdapter(dataAdapter);
                subss[i].setHint("Enter name of " + (i + 1) + " subject and credits below:");
                l1.addView(subss[i]);
            //    l1.addView(creditss[i]);
                l1.addView(credt[i]);
            } else {
                Button submit = new Button(this);
                submit.setText("Next");
                l1.addView(submit);
                sv.addView(l1);
                setContentView(sv);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  Toast.makeText(getApplicationContext(), creditss[0].getText().toString(), Toast.LENGTH_SHORT).show();
                        for (int j = 0; j < noOfSubjects; j++) {
                            if(!((subss[j].getText().toString()).equals(""))) {
                                subs[j] = subss[j].getText().toString();
                                //credits[j] = Integer.valueOf(creditss[j].getText().toString());
                                credits[j] = Integer.valueOf(credt[j].getSelectedItem().toString());
                                flag=0;
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Dude!!! Write something (Atleast here)", Toast.LENGTH_SHORT).show();
                                flag=1;
                            }

                        }
                        if(flag==0) {
                            Intent i = new Intent(Subjects.this, Result.class);
                            Bundle extras1 = new Bundle();
                            extras1.putStringArray("Subjects", subs);
                            extras1.putIntArray("Credits", credits);
                            extras1.putInt("No Of Subjects", noOfSubjects);
                            i.putExtras(extras1);
                            startActivity(i);
                        }
                    }
                });
            }
        }







    }
}
