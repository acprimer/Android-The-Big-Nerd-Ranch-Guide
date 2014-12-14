package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.geo_quiz.QuizActivity;


public class MainActivity extends ActionBarActivity {
    private ListView list;
    private ArrayAdapter<String> adapter;
    private String[] chapterNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        chapterNames = getResources().getStringArray(R.array.chapter);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chapterNames);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch ((int) id) {
                    case 0:
                        intent = new Intent(MainActivity.this, QuizActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
