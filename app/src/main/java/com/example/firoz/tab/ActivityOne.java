package com.example.firoz.tab;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityOne extends Activity {

    EditText e1;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        e1=(EditText)findViewById(R.id.number);
        b=(Button)findViewById(R.id.call);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=e1.getText().toString();
                Intent call=new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+number));

                //check whether the user granted the permission or not. if not, call will not be connected.
                if(ActivityCompat.checkSelfPermission(ActivityOne.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity(call);
            }
        });

    }
}
