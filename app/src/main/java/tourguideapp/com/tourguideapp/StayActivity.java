package tourguideapp.com.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StayActivity extends AppCompatActivity {

    ListView mListView;
    private ContentAdapter mContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mListView = findViewById(R.id.food_list);

        final ArrayList<Content> content = new ArrayList<Content>();

        content.add(new Content(R.drawable.accord, "Hotel Accord", "T.Nagar", "12AM IST to 12PM IST", R.string.hotelaccord_text));
        content.add(new Content(R.drawable.meredian, "Le Royal Méridien", "St.Thomas Mount", "12AM IST to 12PM IST", R.string.meredian_text));

        content.add(new Content(R.drawable.raintree, "The Raintree Hotel", "Anna Salai", "12AM IST to 12PM IST", R.string.raintree_text));

        content.add(new Content(R.drawable.residencytowers, "Residency Towers", "T.Nagar", "12AM to 12PM IST", R.string.residencytowers_text));
        final ContentAdapter contentAdapter = new ContentAdapter(this, content);
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
