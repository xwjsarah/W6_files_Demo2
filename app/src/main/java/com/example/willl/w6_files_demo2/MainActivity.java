package com.example.willl.w6_files_demo2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText title;
    private EditText body;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title= (EditText) findViewById(R.id.title);
        body = (EditText) findViewById(R.id.body);
        tv=(TextView) findViewById(R.id.tex1);
    }

    public void save(View view) {

        try {
            FileOutputStream outputStream = openFileOutput(title.getText().toString().replace(" ",""), MODE_APPEND);
            outputStream.write(body.getText().toString().getBytes());
            outputStream.close();
            Snackbar.make(view, "File Saved", Snackbar.LENGTH_SHORT).show();

        }
        catch (Exception e) {
            Log.e("Error", e.getMessage());
        }

    }

    public void load(View view) {
        String temp="";
        String listOffile="";

        try {
            File filedir = getFilesDir();
            File[] files= filedir.listFiles();
            for(File file:files)
            listOffile+=file.getName() + "\n";


            FileInputStream inputStream = openFileInput(title.getText().toString().replace(" ",""));

            int c;
            while ((c=inputStream.read())!=-1){

                temp+=Character.toString((char)c);
            }

        }catch (Exception e){}
        tv.setText(temp + "\n" + listOffile);
    }
}
