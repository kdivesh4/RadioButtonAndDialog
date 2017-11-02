package com.example.diveshkumar.radiobuttonanddialog;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = (RadioButton) findViewById(R.id.item1);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Radio Button is SeLECTED", Toast.LENGTH_SHORT).show();
            }
        });


        rg = (RadioGroup) findViewById(R.id.item2);
        rb2 = (RadioButton) findViewById(R.id.item3);
        rb3 = (RadioButton) findViewById(R.id.item4);
        rb4 = (RadioButton) findViewById(R.id.item5);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.item3:
                        Toast.makeText(MainActivity.this, rb2.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item4:
                        Toast.makeText(MainActivity.this, rb3.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item5:
                        Toast.makeText(MainActivity.this, rb4.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        button = (Button) findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(MainActivity.this)
                        .setTitle("This is pretty cool!!")
                        .setText("wow..")
                        .setBackgroundColorRes(R.color.colorAccent)
                        .enableSwipeToDismiss()
                        .setDuration(5000)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "AlertER clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder mybuilder = new AlertDialog.Builder(MainActivity.this);
        mybuilder.setTitle("ARE YOU INTRESRTED ? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes'Intrested", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Not Interested", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = mybuilder.create();
        alertDialog.show();
    }


 }



