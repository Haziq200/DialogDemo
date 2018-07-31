package sg.edu.rp.dmsd.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnEx;
    Button btnDemo4;
    Button btnDemo5;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvEx;
    TextView tvDemo4;
    TextView tvDemo5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnEx = findViewById(R.id.buttonEx);
        tvEx = findViewById(R.id.textViewEx);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */

                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
              myBuilder.setTitle("Demo 2 Buttons Dialog");
              myBuilder.setMessage("Select one of the Button below.");
              myBuilder.setCancelable(false);

              //Configure the 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });


                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);

                //OBtain the UI component in the input.xml layout
                //it needs to be defined as "final", so that it can be used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog1 = inflater.inflate(R.layout.exercise,null);

                final EditText etEx = viewDialog1.findViewById(R.id.editTextNum1);
                final EditText etEx2 = viewDialog1.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog1);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      int Num1 = Integer.parseInt(etEx.getText().toString());
                      int Num2 = Integer.parseInt(etEx2.getText().toString());
                      int total = Num1 + Num2;
                      tvEx.setText("The sum is " + String.valueOf(total));
                    }
                });
                myBuilder.setCancelable(false);
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

       btnDemo4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                       tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                   }
               };
               Calendar c = Calendar.getInstance();
               int year = c.get(Calendar.YEAR);
               int month = c.get(Calendar.MONTH);
               int day =  c.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,year,month,day);
             myDateDialog.show();
           }
       });

       btnDemo5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                       tvDemo5.setText("Time: " + hourofDay + ":" + minute);
                   }
               };
               Calendar c = Calendar.getInstance();
               int minute = c.get(Calendar.HOUR_OF_DAY);
               int hour = c.get(Calendar.MINUTE);
               TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,hour,minute,true);
               myTimeDialog.show();
           }
       });

    }
}
