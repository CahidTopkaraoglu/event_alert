package com.example.eventalert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Event {
    private String Name;
    private String Description;
    private Date Time;
    private boolean IsDone;
    private int ImageID;

    public Event(){}
    public Event(String Name, String Description, Date Time, boolean IsDone, int ImageId){
        this.setName(Name);
        this.setDescription(Description);
        this.setTime(Time);
        this.setDone(IsDone);
        this.setImageID(ImageId);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public boolean getDone() {
        return IsDone;
    }

    public void setDone(boolean done) {
        IsDone = done;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public static ArrayList<Event> getData() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        int eventImages[] =
            {
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue,
                R.drawable.ic_alert_blue
            };
        String[] eventNames =
            {
                "Kahvaltı",
                "İşe Gidiş",
                "İş Başlangıcı",
                "Birinci Mola",
                "İşe Devam",
                "Öğle Molası",
                "İşe Devam",
                "İkinci Mola",
                "İşe Devam",
                "İş Çıkışı",
                "Okula Gidiş",
                "Ders Başlangıcı",
                "Ders Bitişi",
                "Eve Yolculuk"
            };

        String[] eventDecriptions =
            {
                "Kahvaltı yapmayı unutma!",
                "İşe gitmek için evden çıkmalısın!",
                "İşe başlama zamanı! Kolay Gelsin ^_^",
                "Bir Molayı hakettin!",
                "İşe dönme vakti :(",
                "Öğle arası geldi! Yemek Zamanı...",
                "İşe dönmek gerek!",
                "İkinci molayı hakkettin!",
                "İşe dönme vakti geldi.",
                "Bugünlük bu kadar yeter. Sonraki iş gününde görüşmek üzere.",
                "Okula gitmek için yola koyulmalısın.",
                "Ders başlıyor. Kolay gelsin.",
                "Ders bitmek üzere dayan.",
                "Eve dönmek üzere yola çıkmalısın."
            };

        for (int i = 0; i < eventNames.length; i++) {
            Event temp = new Event();
            temp.setName(eventNames[i]);
            temp.setDescription(eventDecriptions[i]);
            temp.setTime(Calendar.getInstance().getTime());
            temp.setDone(false);
            temp.setImageID(eventImages[i]);
            eventList.add(temp);
        }
        return eventList;
    }
}
