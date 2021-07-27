package com.example.notificationapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mbtnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnShow=findViewById(R.id.btnNotify);
        mbtnShow.setOnClickListener(new btnlistener());
    }

    public class  btnlistener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"demo",Toast.LENGTH_LONG).show();
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            {
                NotificationChannel channel=new NotificationChannel("NewNotification","NewNotification", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager=getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }


            NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("This is new Notificaton")
                    .setContentText("This is content Text")
                    .setAutoCancel(true);

            Intent notificationIntent=new Intent(MainActivity.this,
                    notification.class);
            notificationIntent.putExtra("message","This is notification message");

            PendingIntent pendingintent=PendingIntent.getActivity(MainActivity.this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingintent);
            NotificationManagerCompat manager=NotificationManagerCompat.from(MainActivity.this);
            manager.notify(999,builder.build());



        }
    }
}