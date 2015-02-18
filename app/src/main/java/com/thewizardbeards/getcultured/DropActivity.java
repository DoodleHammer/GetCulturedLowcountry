package com.thewizardbeards.getcultured;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.HashMap;
//import android.view.Menu;

public class DropActivity extends Activity {

    ListView lv;

    String[] categories = new String[]{"Arts & Galleries", "Museums & Exhibits", "Theatres & Music", "Sites & Parks", "Magical Wizard Beards"};
    int[] imageLogos = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);

        //finding the list view in the layout
        lv = (ListView) findViewById(R.id.listView);

		

		/*
         * Sets the array list which will create the main menu list view names
		 */
        List<HashMap<String, ?>> alist = new ArrayList<HashMap<String, ?>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("label", categories[i]);
            alist.add(hm);
        }
        //assigns the to and from which will be passed onto the simle adapter.
        String[] from = {"label"};
        int[] to = {R.id.label};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), alist, R.layout.activity_dropdown, from, to);

        //the adapter is set and list view is created
        lv.setAdapter(adapter);

        //the listener is set for each individual list view element
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
				/* 
				 * Starts an activity depending on the position.
				 */
                if (position == 4) {
                    Intent intent = new Intent(DropActivity.this, DescriptionActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(DropActivity.this, LinkActivity.class);
                    intent.addFlags(position);
                    startActivity(intent);
                }
            }
        });


    }

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.drop, menu);
//		return true;
//	}


}
	
