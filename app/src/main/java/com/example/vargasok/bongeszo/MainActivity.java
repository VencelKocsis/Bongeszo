package com.example.vargasok.bongeszo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    public static final String URL_MESSAGE = "-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "ITT A VILÁG VÉGE! ÚJRAÉLEDT AZ INTERNETEXPLORER!!!  :(", Toast.LENGTH_LONG).show();

        String[] urls = new String[]{"https://www.google.com", "https://www.facebook.com", "https://www.tesla.com", "https://www.spacex.com", "https://github.com"};

        final ListView listView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(urls, this);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String message = (String) listView.getItemAtPosition(position);
                Log.i("selectedFromList", message);
                //String message = ((TextView)view).getText().toString();

                Log.i("URL: ", message);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message));

                String title = "Please select";
                Intent chooser = Intent.createChooser(intent, title);

                if(intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(chooser);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No Activity found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
