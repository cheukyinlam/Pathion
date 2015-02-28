package com.example.matthew.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;

import com.example.matthew.myapplication.dummy.EventDataController;
import com.example.matthew.myapplication.dummy.EventDataStorage;

import org.json.JSONArray;

import java.util.ArrayList;


/**
 * An activity representing a list of Events. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link EventDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link EventListFragment} and the item details
 * (if present) is a {@link EventDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link EventListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class EventListActivity extends FragmentActivity
        implements EventListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private final String TAG = "EventYolo!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Intent intent = getIntent();

        // Show the Up button in the action bar.
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        EventDataController dc = null;
        ArrayList<EventDataStorage> event_data;
        final String eventurl = "https://www.dropbox.com/s/hr932j39u05gucp/events.json?dl=1";
        JSONParser Jparser = new JSONParser();
        Log.d(TAG, "jparser");
        JSONArray event_Jarray = Jparser.getJSONArrFromUrl(eventurl);
        Log.d(TAG, "passed_jparser");
        if (event_Jarray != null) {
            dc = new EventDataController(event_Jarray);
            Log.d(TAG, "pass into data controller");
            event_data = dc.getEvents();
        }

        FragmentManager fm = getSupportFragmentManager();
        setContentView(R.layout.activity_event_list);


        if (findViewById(R.id.event_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((EventListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.event_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
       EventListFragment lf = (EventListFragment) fm.findFragmentByTag("List");
        if ( lf == null) {
            lf = new EventListFragment();
            Bundle arguments = new Bundle();
            arguments.putParcelableArrayList("events", dc.getEvents());
            lf.setArguments(arguments);
            Log.v("myApp", "List Activity: Create a new List Fragment " + lf);
            fm.beginTransaction().replace(R.id.event_list, lf, "List").commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Callback method from {@link EventListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(EventDataStorage e) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            //arguments.putString(EventDetailFragment.ARG_ITEM_ID, id);
            arguments.putParcelable("event", e);
            EventDetailFragment fragment = new EventDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.event_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, EventDetailActivity.class);
            //detailIntent.putExtra(EventDetailFragment.ARG_ITEM_ID, id);
            detailIntent.putExtra("event", e);
            startActivity(detailIntent);
        }
    }


}
