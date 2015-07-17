package com.example.amit.resultchecker;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 14-Jul-15.
 */
public class Result extends Activity {

    private String subs[];
    private TextView temp[];
    private int credits[];
    private int noOfSubjects;
    private String grades[];
    private int gradess[];
    private double result;
    private Spinner[] grad;
    private TextView welomeText;
    private List <String> grads;
    private ArrayAdapter<String> dataAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        noOfSubjects = extras.getInt("No Of Subjects");
        ScrollView sv = new ScrollView(this);
        temp = new TextView[noOfSubjects+1];
        grad = new Spinner[noOfSubjects+1];
        grads = new ArrayList<String>();
        grads.add("A+");
        grads.add("A");
        grads.add("B+");
        grads.add("B");
        grads.add("C+");
        grads.add("C");
        grads.add("IF");
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,grads);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.VERTICAL);
        l1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        subs = extras.getStringArray("Subjects");
        credits = extras.getIntArray("Credits");
        grades = new String[noOfSubjects];
        gradess = new int[noOfSubjects];
        welomeText = new TextView(this);
        welomeText.setLayoutParams(lparams);
        welomeText.setText("Enter grades of subject: ");
        l1.addView(welomeText);
        /* TextView t1 = new TextView(this);
        t1.setText("hi");
        t1.setLayoutParams(lparams);
        l1.addView(t1);*/
        for (int i = 0; i <= noOfSubjects; i++) {
            grad[i] = new Spinner(this);
            temp[i] = new TextView(this);
            if (i < noOfSubjects) {/*
                subjects[i].setLayoutParams(lparams);
                subjects[i].setHint("Enter Grade of " + subs[i] + ": ");
                l1.addView(subjects[i]);
                */
                grad[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                grad[i].setAdapter(dataAdapter);
                //Toast.makeText(getApplicationContext(), subs[i].toString(), Toast.LENGTH_SHORT).show();
                temp[i].setText(subs[i]+": ");
                temp[i].setLayoutParams(lparams);
                l1.addView(temp[i]);
                l1.addView(grad[i]);
            } else {
                Button submit = new Button(this);
                submit.setText("Get Result");
                l1.addView(submit);
                sv.addView(l1);
                setContentView(sv);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  Toast.makeText(getApplicationContext(), creditss[0].getText().toString(), Toast.LENGTH_SHORT).show();
                        for (int j = 0; j < noOfSubjects; j++) {
 /*                           if(!((subjects[j].getText().toString()).equals("")))
                            grades[j] = subjects[j].getText().toString();
                            else
                                Toast.makeText(getApplicationContext(), "Dude!!! Write something (Atleast here)", Toast.LENGTH_SHORT).show();
*/
                            grades[j] = grad[j].getSelectedItem().toString();
                        }
                        for (int j = 0; j < noOfSubjects; j++) {

                            if(grades[j].equals("a+")||grades[j].equals("A+"))
                                gradess[j] = 10;
                            else if(grades[j].equals("a")||grades[j].equals("A"))
                                gradess[j] = 9;
                            else if(grades[j].equals("b+")||grades[j].equals("B+"))
                                gradess[j] = 8;
                            else if(grades[j].equals("b")||grades[j].equals("B"))
                                gradess[j] = 7;
                            else if(grades[j].equals("c+")||grades[j].equals("C+"))
                                gradess[j] = 6;
                            else if(grades[j].equals("c")||grades[j].equals("c"))
                                gradess[j] = 5;
                            else if(grades[j].equals("if")||grades[j].equals("IF")||grades[j].equals("iF")||grades[j].equals("If"))
                                gradess[j] = 0;
                        }

                        float sum =0,tot=0,temp=0,temp1=0;

                        for (int j = 0; j < noOfSubjects; j++) {
                            temp = (float)(credits[j]*gradess[j]);
                          sum = sum+temp;
                            temp1 = (float)credits[j];
                            tot = tot+temp1;
                            result = sum/tot;
                        }
                        Toast.makeText(getApplicationContext(), "Your result: "+result, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }

        }
}
