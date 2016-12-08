package com.javatechig.gridviewexample;

import java.util.ArrayList;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends ActionBarActivity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());
                //Start details activity
                startActivity(intent);
            }
        });
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.grid_item_layout);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.grid_item_layout);
        }
    }

    /**
     * Prepare some dummy data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
       /* for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(0, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + 4));
        }*/
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija1);
        imageItems.add(new ImageItem(bitmap,"Turistička zajednica BPK"));

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija2);
        imageItems.add(new ImageItem(bitmap1,"Turistička zajednica BPK"));

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija3);
        imageItems.add(new ImageItem(bitmap2,"Turistička zajednica BPK"));

        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija4);
        imageItems.add(new ImageItem(bitmap3,"Turistička zajednica BPK"));

        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija5);
        imageItems.add(new ImageItem(bitmap4,"Turistička zajednica BPK"));

        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija6);
        imageItems.add(new ImageItem(bitmap5,"Turistička zajednica BPK"));

        Bitmap bitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija7);
        imageItems.add(new ImageItem(bitmap6,"Turistička zajednica BPK"));

        Bitmap bitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.kategorija8);
        imageItems.add(new ImageItem(bitmap7,"Turistička zajednica BPK"));


        return imageItems;
    }
}