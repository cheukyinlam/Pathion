package com.example.matthew.myapplication.dummy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Matthew on 2/26/2015.
 */
public class EventDataController {
    private ArrayList<EventDataStorage> all_events = new ArrayList<EventDataStorage>();
    public EventDataController(JSONArray eventarray){
        int num_Events = eventarray.length();
        for(int i=0; i < num_Events; i++){
            JSONObject jobj = new JSONObject();
            jobj = eventarray.optJSONObject(i);
            EventDataStorage single_event_data = new EventDataStorage(jobj);
        }
    }
    public ArrayList<EventDataStorage> getEvents(){
        return all_events;
    }

}
