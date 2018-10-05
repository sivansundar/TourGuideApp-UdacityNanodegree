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
        content.add(new Content(R.drawable.bc, "Blood Chutney - by Karthik Kumar", "Royapettah", "Oct17th - 7PM IST ", "Karthik Kumar's Blood Chutney is a Standup Comedy special about hypocrisy, shaming, guilt, quitting and such inevitable, tragic yet fun(ny) life events." +
        "\n \n" + "Quoting KK \"What was my blood will flow like chutney – main course comedy, side dish blood”, he uses all his life’s ups and downs and carefully curates them into hilarious jokes making even the most awkward instances into the funniest ones. He successfully manages to take every possible embarrassing thing that has ever happened to him and make you laugh till your jaws hurt."
        + "\n \n \n " + "The show begins at 7PM @ The Madras Music Academy, Royapettah, Chennai"));

        content.add(new Content(R.drawable.orutimepakalam,"Evam Presents Jagan and Mervyn in OTP", "Alliance Francaise of Madras", "Dec1st - 7:30PM IST", "Octavia is an inter-hall and inter-collegiate music fest hosted by the Bishop Heber Hall of Madras Christian College. The fest was started in the year 1981. Since then, Octavia has been Chennai's most-awaited music fest happening annually. The fest concludes with an electrifying performance from a reputed music band. So, what are you waiting for? Book your tickets right away!"));

        content.add(new Content(R.drawable.seanroldan,"Sean Roldan Live", "Sir Mutha Venkatasubba Rao Concert Hall", "Oct27th - 6PM IST", "The composer, singer, lyricist - Sean Roldan will be performing his super hit film numbers combined with his popular independent tunes. A concert that Chennai people wouldn't wanna miss!" +
        "\n \n" + " > Seats is available to ticket holders on the first serve basis only.\n \n> " +
                "Entry on one pass is valid for one person only.\n \n> " +
                "Entry will start from 6:00 pm onwards and the gate will be closed by 6:30 pm.\n \n> " +
                "The right of admission reserved with the organisers.\n \n> " +
                "The organisers reserve the right to frisk the ticket holder at entry points for security reasons.\n \n> " +
                "No food and beverages from outside are permitted.\n \n> " +
                "The organisers do not take any responsibility for the loss or theft of any personal belongings.\n \n> " +
                "The event is subject to force majeure conditions.\n \n> " +
                "The consumption of any banned substance is strictly prohibited including cigarettes\n \n> " +
                "Potentially dangerous objects like a matchbox, lighter, aerosol liquid, sharp objects, firearms or replica of fire are not allowed."));

      content.add(new Content(R.drawable.agam, "Octavia - Agam", "Bishop Heber Hall", "Oct15th - 7PM", "Octavia is an inter-hall and inter-collegiate music fest hosted by the Bishop Heber Hall of Madras Christian College. The fest was started in the year 1981. Since then, Octavia has been Chennai's most-awaited music fest happening annually. The fest concludes with an electrifying performance from Agam which you cannot afford to miss. So, what are you waiting for? Book your tickets right away!"));


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
