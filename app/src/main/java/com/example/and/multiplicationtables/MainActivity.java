package com.example.and.multiplicationtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    int maxTable=10;
    int minTable=1;

    public void generateTables(int timesNumber){
        int min=1;
        int max=10;
        ArrayList table=new ArrayList();
        for (int j=min; j<=max;j++){
            table.add(j*timesNumber);
        }
        ArrayAdapter myAd= new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, table);
        myListView.setAdapter(myAd);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView=(ListView) findViewById(R.id.listView);
        SeekBar control=(SeekBar) findViewById(R.id.seekBar);
        control.setMax(maxTable+1);
        generateTables(5);
        control.setProgress(5);
        control.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                generateTables(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });    }
}
