package com.example.matthew.myapplication.dummy;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

/**
 * Created by Matthew on 2/26/2015.
 */
public class EventDataStorage implements Parcelable {
    EventDataStorage(JSONObject eventdata){
        EventName = eventdata.optString("name");
        EventCaption = eventdata.optString("caption");
        EventImageURL = eventdata.optString("url");
        EventDescriptionURL = eventdata.optString("image");
    };
    public String EventName;
    String EventCaption;
    String EventImageURL;
    String EventDescriptionURL;

    public String toString(){
        return EventName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(EventName);
    }
    public static final Creator<EventDataStorage> CREATOR
            = new Parcelable.Creator<EventDataStorage>(){
        public EventDataStorage createFromParcel(Parcel in){
            return new EventDataStorage(in);
        }
        public EventDataStorage[] newArray(int size){
            return new EventDataStorage[size];
        }
    };

    private EventDataStorage(Parcel in){
        EventName = in.readString();
    }
}
