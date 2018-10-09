package tourguideapp.com.tourguideapp;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentAdapter extends ArrayAdapter<Content> {


    public ContentAdapter(Context context, ArrayList<Content> words) {
        super(context, 0, words);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View cardItem = convertView;
        if (cardItem == null) {
            cardItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_item, parent, false);

            Content currentContent = getItem(position);

            TextView title_text = cardItem.findViewById(R.id.title_text);
            title_text.setText(currentContent.getmTitle());

            TextView location_text = cardItem.findViewById(R.id.location_text);
            location_text.setText(currentContent.getmLocation());

            ImageView image = cardItem.findViewById(R.id.imageView);
            image.setImageResource(currentContent.getmImageResourceId());
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        return cardItem;
    }
}
