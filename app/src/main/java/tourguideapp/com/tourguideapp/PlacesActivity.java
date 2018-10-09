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
