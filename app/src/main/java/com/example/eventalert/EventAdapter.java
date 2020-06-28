package com.example.eventalert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    ArrayList<Event> mEventList;
    LayoutInflater inflater;

    public EventAdapter(Context context, ArrayList<Event> events) {
        inflater = LayoutInflater.from(context);
        this.mEventList = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_item_card, parent, false);
        EventViewHolder holder = new EventViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event selectedEvent = mEventList.get(position);
        holder.setData(selectedEvent, position);
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView eventName, eventDescription, eventTime;
        CheckBox eventIsDone;
        ImageView eventImage, deleteevent;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventName = (TextView) itemView.findViewById(R.id.event_name);
            eventDescription = (TextView) itemView.findViewById(R.id.event_description);
            eventTime = (TextView) itemView.findViewById(R.id.event_time);
            eventImage = (ImageView) itemView.findViewById(R.id.event_image);
            deleteevent = (ImageView) itemView.findViewById(R.id.delete_event);
            eventIsDone = (CheckBox) itemView.findViewById(R.id.is_done_checkbox);
            deleteevent.setOnClickListener(this);
        }

        public void setData(Event selectedProduct, int position) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            this.eventTime.setText(dateFormat.format(selectedProduct.getTime()));
            this.eventName.setText(selectedProduct.getName());
            this.eventDescription.setText(selectedProduct.getDescription());
            this.eventImage.setImageResource(selectedProduct.getImageID());
            this.eventIsDone.setSelected(selectedProduct.getDone());
        }

        @Override
        public void onClick(View v) {
        }
    }
}
