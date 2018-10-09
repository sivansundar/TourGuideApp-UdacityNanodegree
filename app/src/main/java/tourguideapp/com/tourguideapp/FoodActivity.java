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

        mListView = findViewById(R.id.food_list);

        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.drawable.rayarmess,"Rayar Mess", "Mylapore, Chennai", "7AM to 10AM", R.string.rayarmess_text));
        content.add(new Content(R.drawable.borderparrota, "Courtallam Border Rahmath Kadai", "T. Nagar, Chennai", "11AM to 7PM", R.string.borderparotta_text));
        content.add(new Content(R.drawable.azizatho, "Burmeese Atho", "George Town", "4PM IST to 1AM IST", R.string.azizatho_text));

        content.add(new Content(R.drawable.ponnusamy,"Hotel Ponnusamy", "Royapettah", "12PM IST to 11PM IST", R.string.ponnusamy_text));
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
