package com.example.firoz.tab;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ActivityThree extends Activity {

    ListView listView;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        listView=(ListView)findViewById(R.id.listViewContacts);

        Cursor cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");


        String[] fromColumns={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        int[] toViews={R.id.contactName,R.id.contactNumber};

        if(cursor!=null)
        {
            adapter=new SimpleCursorAdapter(this,R.layout.contactlist,cursor,fromColumns,toViews);
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tv=(TextView)view.findViewById(R.id.contactNumber);
                String phonecall=tv.getText().toString();

                Intent call=new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+phonecall));

                if(ActivityCompat.checkSelfPermission(ActivityThree.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity(call);

            }
        });
    }
}
