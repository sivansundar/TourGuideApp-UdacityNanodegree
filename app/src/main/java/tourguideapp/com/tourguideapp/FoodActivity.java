package tourguideapp.com.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    ListView mListView;
    private ContentAdapter mContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mListView = (ListView) findViewById(R.id.food_list);

        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content("Rayar Mess", "Mylapore, Chennai", "7AM to 10AM \n ", "Tucked in a small lane in Mylapore, this 12 seater eatery is run by 4th generation owners. Kabaleeshwar Temple and Rayar's Mess is one of my favorite routines that I wish to have for a long long time.\n" +
                "\n" +
                "They are open for just 3 hrs in the morning and evening, has a very limited menu and a crammed eating space - Rayar's Mess is an unassuming, honest and endearing place serving simple food.\n" +
                "\n" +
                "The place has it's loyal customers - customers who are willing to wait 20-30 mins for a seat despite knowing you are only going to have to choose between idli, vada and pongal every single day. No frills, no confusion, not too many things on the menu, you go there to get fed some simple tasty food."));

        content.add(new Content("Courtallam Border Rahmath Kadai", "T. Nagar, Chennai", "11AM to 7PM", "The story of the border parotta is intertwined with the story of a road that winds between Punnaloor in Kerala and Shenkottai in Tamil Nadu. As this road snakes down the Western Ghats, one of the first villages it reaches on the Tamil Nadu side is Piranoor. " +
                "\n" + "Till 1956, there was a toll gate in the village, signifying the border between Tamil Nadu and Kerala, and the place soon came to be known (and is still referred to) as just “Border”. It became a trading post between the two states and a pit stop for lorry crew and busloads of travellers, and a number of parotta stalls started proliferating in the area. " +
                "\n" + "Years later, when Courtallam, which is just three km away, became a popular tourist destination, more people flocked to “Border” as well. But among a host of stalls, one that had visitors throughout the year was Rahmath Parotta Kadai. That small stall, in the last 45 years, has gone on to become a tourist attraction by itself."));

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
