
package com.android.cz.studydemo.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.cz.studydemo.R;
import com.android.cz.studydemo.tablayout.TabLayoutActivity;

import static android.R.attr.id;

/**
 * 通知的用法，详细参考下面博客
 * http://blog.csdn.net/zhixuan322145/article/details/51277903
 */
public class NotificationActivity extends AppCompatActivity {
    private static final String TAG = "TestToolBarActivity";
    private NotificationManager manager;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }
    public void simpleNotifi(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_menu_camera);
        Bitmap bd = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        builder.setLargeIcon(bd);
        builder.setTicker("asadsf");
        builder.setContentTitle("New Notification");
        builder.setContentText("This is a new notification");
        //通知更新，设置通知数量
        builder.setNumber(++num);

        /*
        Android 5.0(API level 21)开始，当屏幕未上锁且亮屏时，通知可以以小窗口形式显示。用户可以在不离开当前应用前提下操作该通知。
         以下两种情况会显示浮动通知:
        1. setFullScreenIntent()，如上述示例。
        2. 通知拥有高优先级且使用了铃声和振
         */
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        manager.notify(1, builder.build());
    }

    public void actionNotifi(View view) {

        Intent intent = new Intent(this, TabLayoutActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);


        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("Action Notification")
                .setSmallIcon(R.drawable.ic_menu_gallery)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .setContentText("Click to start TabActivity")
                .setContentTitle("New Message")
                .setAutoCancel(true)
                .build();

        manager.notify(2, notification);

    }

    public void bigNotifi(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_menu_camera);
        Bitmap bd = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        builder.setLargeIcon(bd);
        builder.setTicker("Big style");
        builder.setContentTitle("New Notification");
//        builder.setContentText("This is a new notification");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("This is a big notification,it's long text on screen.so,we must used big style to show."));
        Bitmap big = BitmapFactory.decodeResource(getResources(), R.drawable.mm);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(big));
//        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        manager.notify(3, builder.build());
    }

    private   NotificationCompat.Builder mBuilder;
    public void progressNotifi(View view){
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Picture Download")
                .setContentText("Download in progress")
                .setSmallIcon(R.drawable.ic_menu_manage);//不设置大图片，默认的会用小图标修饰

        // 使用setProgress(0, 0, true)来表示进度不明确的进度条
//        mBuilder.setProgress(0, 0, true);
//        manager.notify(id, mBuilder.build());

        // Start a lengthy operation in a background thread
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int incr;
                        for (incr = 0; incr <= 100; incr+=5) {
                            mBuilder.setProgress(100, incr, false);
                            manager.notify(id, mBuilder.build());
                            try {
                                // Sleep for 5 seconds
                                Thread.sleep(1*1000);
                            } catch (InterruptedException e) {
                                Log.d(TAG, "sleep failure");
                            }
                        }
                        mBuilder.setContentText("Download complete")//下载完成
                                .setProgress(0,0,false);    //移除进度条
                        manager.notify(id, mBuilder.build());
                    }
                }
        ).start();
    }

/**
 * Android 5.0(API level 21)开始，通知可以显示在锁屏上。用户可以通过设置选择是否允许敏感的通知内容显示在安全的锁屏上。
 你的应用可以通过setVisibility()控制通知的显示等级:

 VISIBILITY_PRIVATE : 显示基本信息，如通知的图标，但隐藏通知的全部内容
 VISIBILITY_PUBLIC : 显示通知的全部内容
 VISIBILITY_SECRET : 不显示任何内容，包括图标
 */
}
