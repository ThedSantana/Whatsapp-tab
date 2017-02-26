package com.example.firoz.tab;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity{

    TabHost tabHost;
    TabHost.TabSpec tabSpec1;
    TabHost.TabSpec tabSpec2;
    TabHost.TabSpec tabSpec3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabHost=(TabHost)findViewById(android.R.id.tabhost);

        tabHost.setup();

        tabSpec1=tabHost.newTabSpec("Tab 1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Call");
        Intent i1=new Intent(this,ActivityOne.class);
        tabSpec1.setContent(i1);



        tabSpec2=tabHost.newTabSpec("Tab 2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Message");
        Intent i2=new Intent(this,ActivityTwo.class);
        tabSpec2.setContent(i2);



        tabSpec3=tabHost.newTabSpec("Tab 3");
        tabSpec3.setContent(R.id.tab3);
        tabSpec3.setIndicator("Contacts");
        Intent i3=new Intent(this,ActivityThree.class);
        tabSpec3.setContent(i3);

        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);




    }

}
