package com.thewizardbeards.getcultured;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
//import android.view.Menu;

public class DescriptiononeActivity<E> extends Activity {
    private static final String FromCategory = null;
    String[][] arts = {{"karis"}, {"morris"}, {"smith"}, {"artleague"}, {"artcenter"}, {"soba"}};
    String[][] museums = {{"sandbox"}, {"coastaldiscovery"}, {"gullah"}, {"heritagelibrary"}, {"penncenter"}};
    String[][] theaters = {{"mayriver"}, {"hhdance"}, {"mainstreet"}, {"shorenotes"}, {"hhsymphony"}};
    String[][] parks = {{"heyward"}, {"mitchellville"}};
    String[][] res = null;
    String strflg;
    String orgChosen;

    /**
     * Returns the name of the logo resource as a context usable identifier.
     *
     * @param context
     * @param imageName
     * @return
     */
    public static int getLogoImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName + "_logo", null, context.getPackageName());
    }

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.descriptionone, menu);
//		return true;
//	}
//	

    /**
     * Returns the name of the central image resource as a context usable identifier.
     *
     * @param context
     * @param imageName
     * @return
     */
    public static int getCentralImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName + "_image", null, context.getPackageName());
    }

    /**
     * Returns the name of the description message resource as a context usable identifier.
     *
     * @param context
     * @param message
     * @return
     */
    public static int getMessage(Context context, String message) {
        return context.getResources().getIdentifier("string/string_" + message, null, context.getPackageName());
    }

    /**
     * Returns the name of the address resource as a context usable identifier.
     *
     * @param context
     * @param address
     * @return
     */
    public static int getAddress(Context context, String address) {
        return context.getResources().getIdentifier("string/add_" + address, null, context.getPackageName());
    }

    /**
     * Returns the name of the phone resource as a context usable identifier.
     *
     * @param context
     * @param phone
     * @return
     */
    public static int getPhone(Context context, String phone) {
        return context.getResources().getIdentifier("string/phone_" + phone, null, context.getPackageName());
    }

    /**
     * Returns the name of the link resource as a context usable identifier
     *
     * @param context
     * @param link
     * @return
     */
    public static int getLink(Context context, String link) {
        return context.getResources().getIdentifier("string/link_" + link, null, context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptionone);


        //get the intent and retrieve flag and category string
        //set values of respective fields and variables
        Intent intent = getIntent();
        if (null != intent) {
            int flg = intent.getFlags();
            strflg = intent.getStringExtra(FromCategory);
            orgChosen = intent.getStringExtra("OrganizationChosen");
            generateRes(strflg);
            textImageChanger(flg);
        }

        setTitle(orgChosen);

    }

    /**
     * Sets all layout elements based on the position which was clicked on the previous
     * activity.
     *
     * @param flg
     */
    private void textImageChanger(int flg) {
        ImageView logo = (ImageView) findViewById(R.id.logo);
        logo.setImageResource(getLogoImageId(this, res[flg][0]));

        ImageView centralImageView = (ImageView) findViewById(R.id.centralImageView);
        centralImageView.setImageResource(getCentralImageId(this, res[flg][0]));

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(getMessage(this, res[flg][0]));

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(getAddress(this, res[flg][0]));

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(getPhone(this, res[flg][0]));

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(getLink(this, res[flg][0]));


    }

    /**
     * For met condition sets the value of the res array. This will be used to determine
     * what organizations are loaded.
     *
     * @param stringflag
     */
    public void generateRes(String stringflag) {
        if (stringflag.equals("galleries")) {
            res = arts;
        } else if (stringflag.equals("museums")) {
            res = museums;
        } else if (stringflag.equals("theaters")) {
            res = theaters;
        } else if (stringflag.equals("parks")) {
            res = parks;
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        DescriptiononeActivity.this.finish();
    }


}
