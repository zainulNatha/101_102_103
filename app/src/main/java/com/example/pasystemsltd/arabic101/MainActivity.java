package com.example.pasystemsltd.arabic101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //set event//
        setSingleEvent(mainGrid);
    }


    private void setSingleEvent(GridLayout mainGrid) {
        //loop all child items of main grid//
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //cast object to cardView

            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalI == 0) //open topic one//
                    {
                        Intent intent = new Intent(MainActivity.this, Numbers.class);
                        startActivity(intent);
                    }

                    else if (finalI == 1) //open topic two//
                    {
                        Intent intent = new Intent(MainActivity.this, Days.class);
                        startActivity(intent);
                    }

                    else if (finalI == 2) //open topic three//
                    {
                        Intent intent = new Intent(MainActivity.this, Family.class);
                        startActivity(intent);
                    }
                    else if (finalI == 3) //open topic four//
                    {
                        Intent intent = new Intent(MainActivity.this, House.class);
                        startActivity(intent);
                    }
                    else if (finalI == 4) //open topic five//
                    {
                        Intent intent = new Intent(MainActivity.this, Travel.class);
                        startActivity(intent);
                    }
                    else if (finalI == 5) //open topic six//
                    {
                        Intent intent = new Intent(MainActivity.this, Directions.class);
                        startActivity(intent);
                    }





                }
            });
        }







    }
}
