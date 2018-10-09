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
