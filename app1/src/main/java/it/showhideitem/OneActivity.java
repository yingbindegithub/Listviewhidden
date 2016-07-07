package it.showhideitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {
    private ListView listViewDan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        listViewDan = (ListView) findViewById(R.id.listView);
        ArrayList<String> data = new ArrayList<>();
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        listViewDan = (ListView) findViewById(R.id.listView);
        OneAdapter adapter = new OneAdapter(this, data);
        listViewDan.setAdapter(adapter);
    }
}
