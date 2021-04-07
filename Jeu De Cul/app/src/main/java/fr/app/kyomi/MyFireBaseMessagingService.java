package fr.app.kyomi;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessagingService extends FirebaseMessagingService {
    private static final String CANAL = "MyNotifCanal";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String myMessage = remoteMessage.getNotification().getBody();
        Log.d("FirebaseMessage", "Vous venez de recevoir une notification: " + myMessage);

        // Make notif
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CANAL);
        notificationBuilder.setContentTitle("Ma Super Notif");
        notificationBuilder.setContentText(myMessage);
        // Icon
        notificationBuilder.setSmallIcon(R.drawable.logojc);

        // Actions
            //Redirection
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://moonofsimon.wixsite.com/kyomismaps/maps"));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // Add Action
            notificationBuilder.setContentIntent(pendingIntent);


        // Send Notif
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            // Make Vibration
            long[] vibrationPattern = {500, 1000};
            notificationBuilder.setVibrate(vibrationPattern);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = getString(R.string.notification_channel_id);
            String channelTitle  = getString(R.string.notification_channel_title);
            String channelDescription  = getString(R.string.notification_channel_desc);
            NotificationChannel channel = new NotificationChannel(channelId, channelTitle, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);
            notificationManager.createNotificationChannel(channel);
            notificationBuilder.setChannelId(channelId);
        }

        notificationManager.notify(1, notificationBuilder.build());
    }
}
