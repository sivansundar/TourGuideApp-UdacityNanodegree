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

        mListView = (ListView) findViewById(R.id.events_list);

        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content("Blood Chutney - by Karthik Kumar", "Royapettah", "7PM", "Karthik Kumar's Blood Chutney is a Standup Comedy special about hypocrisy, shaming, guilt, quitting and such inevitable, tragic yet fun(ny) life events." +
        "\n \n" + "Quoting KK \"What was my blood will flow like chutney – main course comedy, side dish blood”, he uses all his life’s ups and downs and carefully curates them into hilarious jokes making even the most awkward instances into the funniest ones. He successfully manages to take every possible embarrassing thing that has ever happened to him and make you laugh till your jaws hurt."
        + "\n \n \n " + "The show begins at 7PM @ The Madras Music Academy, Royapettah, Chennai"));
        content.add(new Content("Valluvar Kottam", "Valluvar Kottam", "5AM to 12PM", "Historic significance blah blah"));

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
                startActivity(intent);
            }
        });
    }
}
