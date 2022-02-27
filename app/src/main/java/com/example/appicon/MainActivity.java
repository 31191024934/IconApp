package com.example.appicon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView myGird;
    String randomIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGird=findViewById(R.id.myGirdView);
        List<Integer> listIcons = Arrays.asList(
                8986, 0x1F603, 0x1F605, 0x1F60D, 0x1F60F,
                0x1F618, 0x1F621, 0x1F625, 0x1F628, 0x1F62D,
                0x1F637, 0x1F61D, 0x1F616, 0x1F609, 0x1F60B,
                0x1F635, 0x1F633, 0x1F624, 0x1F61C, 0x1F60A);
        List data = new ArrayList();
        for (int i = 0; i < listIcons.size(); i++) {
            data.add(new String(Character.toChars(listIcons.get(i))));
        }
        IconActivity iconActivity=new IconActivity(getApplicationContext(),R.layout.icon_desgin,data);
        myGird.setAdapter(iconActivity);
        List<String> result=new ArrayList<>(data);
        randomIcon=RandomIcon(result);
        myGird.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v = (TextView) view;
                if(v.getText().toString().equals(randomIcon)){
                    result.remove(randomIcon);
                    v.setText("");
                }
                randomIcon=RandomIcon(result);
            }
        });
    }
    private String RandomIcon(List<String> list)
    {
        Random rand = new Random();
        String result = list.get(rand.nextInt(list.size()));
        TextView target = findViewById(R.id.viewRandomIcon);
        target.setText(result);
        return result;
    }
}