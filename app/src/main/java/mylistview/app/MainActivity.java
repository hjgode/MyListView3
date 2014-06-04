package mylistview.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    String TAG = "MyListView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inflate your View
        setContentView(R.layout.activity_main);
        // Get references to UI widgets
        final ListView myListView = (ListView)findViewById(R.id.myListView);

        final String[] bibles = new String[] { "New World Translation 2013", "New World Translation 1984", "Revised New King James Version", "New International Version"};

        // Create the Array List of to do items
        final ArrayList<String> todoItems = new ArrayList<String>();

        // Create the Array Adapter to bind the array to the List View
        final ArrayAdapter<String> aa;
        //aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bibles);
        // Bind the Array Adapter to the List View
        myListView.setAdapter(aa);

        final Toast toast;

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                String  itemValue    = (String) myListView.getItemAtPosition(position);
                Log.i(TAG, itemValue);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"\n  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
