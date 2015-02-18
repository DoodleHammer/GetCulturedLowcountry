package com.thewizardbeards.getcultured;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import android.view.Menu;

public class LinkActivity extends Activity {
    protected String FromCategory;
    String[] arts = {"Karis Art Gallery", "Morris & Whiteside Art Gallery", "Smith Art Gallery", "Art League of Hilton Head", "Art Center of Coastal Carolina", "Society of Bluffton Artists"};
    String[] museums = {"The Sandbox: Interactive Children's Museum", "Coastal Discovery Museum", "Gullah Museum of Hilton Head", "Heritage Library", "The Penn Center"};
    String[] theaters = {"Mayriver Theater Co.", "Hilton Head Dance School & Theater", "Mainstreet Youth Theatre", "Shore Notes", "Hilton Head Symphony Orchestra"};
    String[] parks = {"Historic Heyward House", "Mitchellville Freedom Park"};
    String[] chosenCat = {"Arts & Galleries", "Museums & Exhibits", "Theatres & Music", "Sites & Parks", "Magical Wizard Beards"};
    String[] finArray = null;
    int arLength;
    private String descriptionString;
    private String clickOrigin;
    private String cob;//click origin button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        //retrieve flags passed from previous activity
        Intent intent = getIntent();
        int flg = intent.getFlags();

        //set the values of array and description string
        //get array length
        if (flg == 0) {
            arLength = arts.length;
            finArray = arts;
            descriptionString = "galleries";
            clickOrigin = "ag";
        } else if (flg == 1) {
            arLength = museums.length;
            finArray = museums;
            descriptionString = "museums";
            clickOrigin = "me";
        } else if (flg == 2) {
            arLength = theaters.length;
            finArray = theaters;
            descriptionString = "theaters";
            clickOrigin = "tm";
        } else if (flg == 3) {
            arLength = parks.length;
            finArray = parks;
            descriptionString = "parks";
            clickOrigin = "sp";
        }

        setTitle(chosenCat[flg]);

        ListView lv = (ListView) findViewById(R.id.listView);

		/*
         * Fill in the values of the list view with the array list selected
		 */
        List<HashMap<String, ?>> alist = new ArrayList<HashMap<String, ?>>();
        for (int i = 0; i < arLength; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("label", finArray[i]);
            alist.add(hm);
        }
        String[] from = {"label"};//values to be passed into the adapter
        int[] to = {R.id.label};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), alist, R.layout.activity_dropdown, from, to);

        //Setting of the adapter
        lv.setAdapter(adapter);
		
		/*
		 * Determines what occurs when a list view element aka a button is clicked. Based on position this passes a flag
		 * and the category onto the next activity.
		 */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                cob = clickOrigin + position;
                // here we need to start the service in the background to send the
                // data to the server
                // we send the survey data from somewhere else
                // we also need to make a call to retrieve the uuid associated with the device/app
                // and attached forward it to the service to send along with the cob information
                Intent intent = new Intent(LinkActivity.this, DescriptiononeActivity.class);
                intent.addFlags(position);
                intent.putExtra(FromCategory, descriptionString);
                intent.putExtra("OrganizationChosen", finArray[position]);
                startActivity(intent);
            }
        });

    }

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.link, menu);
//		return true;
//	}

}







