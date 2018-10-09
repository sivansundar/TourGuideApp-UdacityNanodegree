/*
 *
 * ```
 *
 *  * PROJECT LICENSE
 *  *
 *  * This project was submitted by Sivan Chakravarthy as part of the Nanodegree At Udacity.
 *  *
 *  * As part of Udacity Honor code, your submissions must be your own work, hence
 *  * submitting this project as yours will cause you to break the Udacity Honor Code
 *  * and the suspension of your account.
 *  *
 *  * Me, the author of the project, allow you to check the code as a reference, but if
 *  * you submit it, it's your own responsibility if you get expelled.
 *  *
 *  * Copyright (c) 2018 Sivan Chakravarthy
 *  *
 *  * Besides the above notice, the following license applies and this license notice
 *  * must be included in all works derived from this project.
 *  *
 *  * MIT License
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in all
 *  * copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  * SOFTWARE.
 *  *
 *
 * ```
 */

package tourguideapp.com.tourguideapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    String mTitle, mLocation, mTimings;
    int mImageID, mAbout;
    TextView mTitleTextView, mLocationTextView, mTimingsTextView, mAboutTextView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        mTitleTextView = findViewById(R.id.title_textView);
        mLocationTextView = findViewById(R.id.location_textView);
        mTimingsTextView = findViewById(R.id.timings_textView);
        mAboutTextView = findViewById(R.id.about_textView);
        imageView = findViewById(R.id.imageView);

        mTitle = getIntent().getStringExtra("mTitle");
        mLocation = getIntent().getStringExtra("mLocation");
        mTimings = getIntent().getStringExtra("mTimings");
        mAbout = getIntent().getIntExtra("mAbout", mAbout);

        int id = getIntent().getIntExtra("mImage", mImageID);
        imageView.setImageResource(id);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mTitleTextView.setText(mTitle);
        mLocationTextView.setText(mLocation);
        mTimingsTextView.setText(mTimings);
        mAboutTextView.setText(mAbout);

    }
}
