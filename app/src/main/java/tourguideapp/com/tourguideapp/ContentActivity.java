package tourguideapp.com.tourguideapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    String mTitle, mLocation, mTimings, mAbout;
    int mImageID;
    TextView mTitleTextView, mLocationTextView, mTimingsTextView, mAboutTextView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        mTitleTextView = (TextView) findViewById(R.id.title_textView);
        mLocationTextView = (TextView) findViewById(R.id.location_textView);
        mTimingsTextView = (TextView) findViewById(R.id.timings_textView);
        mAboutTextView = (TextView) findViewById(R.id.about_textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        mTitle = getIntent().getStringExtra("mTitle");
        mLocation = getIntent().getStringExtra("mLocation");
        mTimings = getIntent().getStringExtra("mTimings");
        mAbout = getIntent().getStringExtra("mAbout");

        int id = getIntent().getIntExtra("mImage", mImageID);
        imageView.setImageResource(id);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mTitleTextView.setText(mTitle);
        mLocationTextView.setText(mLocation);
        mTimingsTextView.setText(mTimings);
        mAboutTextView.setText(mAbout);

    }
}