package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent.CrimeActivity;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent.CrimeListActivity;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.drag_and_draw.DragAndDrawActivity;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.geo_quiz.QuizActivity;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.hello_moon.HelloMoonActivity;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.photo_gallery.PhotoGalleryActivity;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.remote_control.RemoteControlActivity;


public class MainActivity extends ActionBarActivity {
    private ListView list;
    private ArrayAdapter<String> adapter;
    private String[] chapterNames;
    private Class[] clazz = new Class[]{
            QuizActivity.class,
            CrimeListActivity.class,
            HelloMoonActivity.class,
            RemoteControlActivity.class,
            PhotoGalleryActivity.class,
            DragAndDrawActivity.class
    };

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
                intent = new Intent(MainActivity.this, clazz[((int) id)]);
                startActivity(intent);
            }
        });
    }
}
