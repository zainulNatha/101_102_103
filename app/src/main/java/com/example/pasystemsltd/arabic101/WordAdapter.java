package com.example.pasystemsltd.arabic101;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PAsystemsltd on 07/02/2018.
 */

public class WordAdapter extends ArrayAdapter<WordClass> {

    public WordAdapter(Activity context, ArrayList<WordClass>words){

        super(context,0,words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
//check if view being reused otherwise inflate view//
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }

        // get the object located at this position on list//
        WordClass currentLessons_class= getItem(position);

        TextView ArabicTextView=(TextView) listItemView.findViewById(R.id.Arabic);
        //set text on arabic text  view//
        ArabicTextView.setText(currentLessons_class.getArabicWord());

        TextView TransliterationTextView=(TextView) listItemView.findViewById(R.id.transliteration);
        //set text on transliteration text  view//
        TransliterationTextView.setText(currentLessons_class.getArabicTransliteration());

        TextView TranslationTextView=(TextView) listItemView.findViewById(R.id.translation);
        //set text on translation text  view//
        TranslationTextView.setText(currentLessons_class.getTranslation());

        //RETURN WHOLE LIST ITEM LAYOUT (3 TEXT VIEWS AND IMAGE VIEW), SHOWN IN LIST VIEW//
        return  listItemView;
    }

}
