package com.example.eventalert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventListActivity extends AppCompatActivity {

    RecyclerView event_list_rcylview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        //View uzerindeki butonları elde ediyoruz
        final Button addEventButton = (Button) findViewById(R.id.add_event_button);
        final Button eventCalendarButton = (Button) findViewById(R.id.event_calendar_button);

        //Yeni Event olusturma butonuna tiklandiginda ilgili aktiviteyi aciyoruz
        addEventButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent userPreferences = new Intent(EventListActivity.this, EventCreateActivity.class);
                startActivity(userPreferences);
            }
        });

        //Calendar butonuna tiklandiginda ilgili aktiviteyi aciyoruz
        eventCalendarButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent userPreferences = new Intent(EventListActivity.this, EventCalendarActivity.class);
                startActivity(userPreferences);
            }
        });

        event_list_rcylview = (RecyclerView) findViewById(R.id.event_list_recylerview);

        EventAdapter productAdapter = new EventAdapter(this, Event.getData());
        event_list_rcylview.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        event_list_rcylview.setLayoutManager(linearLayoutManager);


    }
}
