package com.thewizardbeards.getcultured;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;


public class DescriptionActivity extends Activity {


    /**
     * Locates the views on the Main Description activity and assigns values.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        //central Image is set
        ImageView centralImageView = (ImageView) findViewById(R.id.centralImageView);
        centralImageView.setImageResource(R.drawable.wizard_square);


        // address
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(R.string.add_zero);


        //email
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(Html.fromHtml("<a href=\"mailto:" + getString(R.string.email) + "?subject=" + getString(R.string.email_subject) + "\">" + getString(R.string.email) + "</a>"));
        textView4.setMovementMethod(LinkMovementMethod.getInstance());

        //link
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText(R.string.link_zero);

    }


    @Override
    protected void onStop() {
        super.onStop();
        DescriptionActivity.this.finish();
    }

}
