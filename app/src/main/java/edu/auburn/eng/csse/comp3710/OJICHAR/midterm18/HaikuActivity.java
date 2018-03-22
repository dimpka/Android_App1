package edu.auburn.eng.csse.comp3710.OJICHAR.midterm18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;


public class HaikuActivity extends AppCompatActivity {

    Spinner spinner;

    private RadioButton mAdjectivesButton;
    private RadioButton mNounsButton;
    private RadioButton mVerbsButton;
    private RadioButton mOthersButton;
    private Button mDeleteButton;
    private Button mStartOverButton;
    private Button mDisplayButton;
    private Button mAddButton;
    //private TextView mTextView;
    private int position;
    private  String str;
    String selectedText;
    String tmp;
    int count1, count2, count3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haiku);




        mDeleteButton = (Button)findViewById(R.id.deleteButton);
        mStartOverButton = (Button)findViewById(R.id.startoverButton);
        mDisplayButton = (Button)findViewById(R.id.displayButton);
        mAddButton = (Button)findViewById(R.id.addButton);


        spinner = (Spinner)findViewById(R.id.spinner);

        TextView textElement = (TextView) findViewById(R.id.textView25);
        String modifyText;
        modifyText = textElement.getText().toString();
        textElement.setText(modifyText);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Toast.makeText(HaikuActivity.this, selectedText, Toast.LENGTH_SHORT).show();
                if(selectedText != null && view != null) {
                    str = selectedText.substring(1);
                    position = Integer.parseInt(selectedText.substring(0, 1));
                    //tmp = selectedText.substring(0,1);
                    //Toast.makeText(HaikuActivity.this, tmp , Toast.LENGTH_SHORT).show();
                    AppendText();
                }

            }
        });


        mStartOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startOver();
            }
        });


        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteButton();




            }
        });




    }





    private void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_adjButton:
                if (checked)
                    loadAdj();
                //Toast.makeText(HaikuActivity.this, R.string.clicks, Toast.LENGTH_SHORT).show();
                // Ninjas rule
                break;
            case R.id.radio_nounButton:
                if (checked)
                    loadNouns();
                // Pirates are the best
                //Toast.makeText(HaikuActivity.this, R.string.clicks2, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_verbsButton:
                if (checked)
                    loadVerbs();
                // Ninjas rule
                break;

            case R.id.radio_otherButton:
                if (checked)
                    loadOthers();
                // Others rule
                break;


        }
    }

    //Load Nouns only
    private void loadNouns(){
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.nouns, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedText = spinner.getSelectedItem().toString();
                TextView ediTxt = (TextView) findViewById(R.id.addButton);
                ediTxt.setText("ADD " + selectedText.substring(1) + " TO HAIKU");


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //loads Adjectives ONly
    private void loadAdj(){
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.adjectives, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                TextView editTxt = (TextView) findViewById(R.id.addButton);
                selectedText = spinner.getSelectedItem().toString();
                editTxt.setText("ADD " + selectedText.substring(1) + " TO HAIKU");





            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //Loads Verbs only
    private void loadVerbs(){

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.verbs, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedText = spinner.getSelectedItem().toString();
                TextView ediTxt = (TextView) findViewById(R.id.addButton);
                ediTxt.setText("ADD " + selectedText.substring(1) + " TO HAIKU");





            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //loads Others Onlu
    public void loadOthers(){
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.other, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedText = spinner.getSelectedItem().toString();
                TextView ediTxt = (TextView) findViewById(R.id.addButton);
                ediTxt.setText("ADD " + selectedText.substring(1) + " TO HAIKU");



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Method for Appending Text
    private void AppendText(){

        if (position == 1 && count1 < 5) {

            TextView textElement = (TextView) findViewById(R.id.textView25);
            String modifyText;
            modifyText = textElement.getText().toString();
            modifyText = modifyText + " " +  str;
            textElement.setText(modifyText);
            count1++;
        }
        else if (position == 2 && count2 < 7 ){
            TextView textElement = (TextView) findViewById(R.id.textView26);
            String modifyText;
            modifyText = textElement.getText().toString();
            modifyText = modifyText + " " +  str;
            textElement.setText(modifyText);
            count2++;

        }
        else if(position == 3 && count3 < 5){
            TextView textElement = (TextView) findViewById(R.id.textView27);
            String modifyText;
            modifyText = textElement.getText().toString();
            modifyText = modifyText + " " +  str;
            textElement.setText(modifyText);
            count3++;
        }


    }

    //method that parses strings
    private void parseString(){
        String num = selectedText.substring(1,2);
        str = selectedText.substring(2);
        position = Integer.parseInt(num);

    }


    private void deleteButton(){

        int d_length = selectedText.length();
        int txtV_length, new_length;
        String modifyText, new_String;
        //Toast.makeText(HaikuActivity.this, "", Toast.LENGTH_SHORT).show();

        if (selectedText != null) {

            if (position == 1 && count1 > 0) {
                TextView textElement1 = (TextView) findViewById(R.id.textView25);
                modifyText = textElement1.getText().toString();
                txtV_length = modifyText.length();
                new_length = txtV_length - d_length;
                new_String = modifyText.substring(0, new_length);
                textElement1.setText(new_String);
                //selectedText = " ";
                count1--;


            } else if (position == 2 && count2 > 0) {
                TextView textElement2 = (TextView) findViewById(R.id.textView26);
                modifyText = textElement2.getText().toString();
                txtV_length = modifyText.length();
                new_length = txtV_length - d_length;
                new_String = modifyText.substring(0, new_length);
                textElement2.setText(new_String);
                //selectedText = " ";
                count2--;


            } else if (position == 3 && count3 > 0) {
                TextView textElement3 = (TextView) findViewById(R.id.textView27);
                modifyText = textElement3.getText().toString();
                txtV_length = modifyText.length();
                new_length = txtV_length - d_length;
                new_String = modifyText.substring(0, new_length);
                textElement3.setText(new_String);
                //selectedText = " ";
                count3--;


            }
        }


    }


    //Startover Button
    private void startOver(){
        TextView textElement1 = (TextView) findViewById(R.id.textView25);

        textElement1.setText("1)");
        count1 = 0;
        TextView textElement2 = (TextView) findViewById(R.id.textView26);

        textElement2.setText("2)");
        count2 = 0;
        TextView textElement3 = (TextView) findViewById(R.id.textView27);

        textElement3.setText("3)");
        count3 = 0;

    }






}
