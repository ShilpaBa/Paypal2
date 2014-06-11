package com.example.paypal2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;

/**
 * This class shows all the downloaded images in grid view to user 
 * 
 * @author Shilpa Bambore
 */
public class ImageListActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d("onCreate", "before setting load");
        setContentView(R.layout.activity_image_list);
 
        GridView gridView = (GridView) findViewById(R.id.grid_view);
 
        Log.d("onCreate", "starting image download");
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter());
        
        Log.d("onCreate", "download load completed");
 
        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
 
            	Log.d("setOnItemClickListener", "clicked image - "+ position + "  id - " + id);
                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), ImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }

}
/*
extends ListActivity  implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_image_list);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        
        setListAdapter(new ImageAdapter());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ImageDownloader.Mode mode = ImageDownloader.Mode.NO_ASYNC_TASK;
        
        if (checkedId == R.id.correctButton) {
            mode = ImageDownloader.Mode.CORRECT;
        }else if (checkedId == R.id.randomButton) {
                mode = ImageDownloader.Mode.NO_DOWNLOADED_DRAWABLE;
        }
        
        ((ImageAdapter) getListAdapter()).getImageDownloader().setMode(mode);
    }
}*/