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

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    ListView mListView;
    private ContentAdapter mContentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        mListView = findViewById(R.id.places_list);


        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.drawable.marina, "Marina Beach", "Near Fort St.George", "5AM to 12PM", R.string.marina_text));

        content.add(new Content(R.drawable.valluvarkottam, "Valluvar Kottam", "Valluvar Kottam", "5AM to 12PM", R.string.valluvarkottam_text));
        content.add(new Content(R.drawable.kapaleeshwarar, "Kapaleeshwarar Temple", "Mylapore", "6AM to 8PM", R.string.kapaleeshwarar_text));
        content.add(new Content(R.drawable.govtmuseum, "Government Museum", "Egmore", "9:30AM to 5PM", R.string.govtmuseum_text));

        ContentAdapter contentAdapter = new ContentAdapter(this, content);
        mListView.setAdapter(contentAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Content contentposition = content.get(position);

                Intent intent = new Intent(getBaseContext(), ContentActivity.class);
                intent.putExtra("mTitle", contentposition.getmTitle());
                intent.putExtra("mLocation", contentposition.getmLocation());
                intent.putExtra("mTimings", contentposition.getmTimings());
                intent.putExtra("mAbout", contentposition.getmAbout());
                intent.putExtra("mImage", contentposition.getmImageResourceId());
                startActivity(intent);
            }
        });
    }
}
