package tourguideapp.com.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {


    ListView mListView;
    private ContentAdapter mContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        mListView = findViewById(R.id.events_list);

        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.drawable.bc, "Blood Chutney - by Karthik Kumar", "Royapettah", "Oct17th - 7PM IST ", R.string.bloodchutney_text));

        content.add(new Content(R.drawable.orutimepakalam,"Evam Presents Jagan and Mervyn in OTP", "Alliance Francaise of Madras", "Dec1st - 7:30PM IST", R.string.orutimepakalam_text));

        content.add(new Content(R.drawable.seanroldan,"Sean Roldan Live", "Sir Mutha Venkatasubba Rao Concert Hall", "Oct27th - 6PM IST", R.string.seanroldanlive_text));

      content.add(new Content(R.drawable.agam, "Octavia - Agam", "Bishop Heber Hall", "Oct15th - 7PM", R.string.octiviaAgam_text));

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
