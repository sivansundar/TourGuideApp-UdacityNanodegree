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

        mListView = (ListView) findViewById(R.id.places_list);



        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.drawable.marina,"Marina Beach", "Near Fort St.George", "5AM to 12PM", "Marina Beach is a natural urban beach in Chennai, Tamil Nadu, India, along the Bay of Bengal. The beach runs from near Fort St. George in the north to Foreshore Estate in the south, a distance of 6.0 km (3.7 mi), making it the longest natural urban beach in the country. " +
                "\n" + " The Marina is primarily sandy, unlike the short, rocky formations that make up the Juhu Beach in Mumbai. The average width of the beach is 300 m (980 ft) and the width at the widest stretch is 437 m (1,434 ft). Bathing and swimming at the Marina Beach are legally prohibited because of the dangers, as the undercurrent is very turbulent. " +
                "\n" + "It is one of the most crowded beaches in the country and attracts about 30,000 visitors a day during weekdays and 50,000 visitors a day during the weekends and on holidays.During summer months, about 15,000 to 20,000 people visit the beach daily."));

        content.add(new Content(R.drawable.valluvarkottam,"Valluvar Kottam", "Valluvar Kottam", "5AM to 12PM", "Valluvar Kottam is a popular monument in Chennai, dedicated to the classical Tamil poet, philosopher, and saint, Thiruvalluvar. It is located at the intersection of the Kodambakkam High road and the Village road. The monument now stands at what was once the deepest point of a local lake.\n" +
                "\n" +
                "Valluvar Kottam was constructed by Kalaignar M.Karunanidhi during 1970s in the memory of Thiruvalluvar, who wrote his famous Thirukkural some 2,000 years ago. All 133 chapters and 1330 verses of the Thirukkural are inscribed on bas-relief in the front-hall's corridors.\n" +
                "\n" +
                "The construction of Valluvar Kottam is similar to a temple chariot, like a replica of the temple chariot in Thiruvarur. A life-size statue of Thiruvalluvar has been installed in the 39-m-high chariot.\n" +
                "\n" +
                "The auditorium of Valluvar Kottam can accommodate around 4,000 people.\n" +
                "\n" +
                "The architect of the memorial is South Indian traditional architect V. Ganapati Sthapati, who is also the architect of the Thiruvalluvar Statue at Kanyakumari."));
        content.add(new Content(R.drawable.kapaleeshwarar,"Kapaleeshwarar Temple", "Mylapore", "6AM to 8PM", "Kapaleeshwarar Temple is a Hindu temple dedicated to Shiva located in Mylapore, Chennai in the Indian state of Tamil Nadu. " +
                "\n" + "The form of Shiva's consort Parvati worshipped at this temple is called Karpagambal is from Tamil. The temple was built around the 7th century CE in Dravidian architecture."));
        content.add(new Content(R.drawable.govtmuseum,"Government Museum", "Egmore", "9:30AM to 5PM", "The Government Museum or Madras Museum is a museum of human history and culture located in the neighbourhood of Egmore in Chennai, India. " +
                "\n" + "Started in 1851, it is the second oldest museum in India after the Indian Museum in Kolkata. It is particularly rich in archaeological and numismatic collections."));

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
            intent.putExtra("mImage",contentposition.getmImageResourceId());
            startActivity(intent);
            }
        });
    }
}
