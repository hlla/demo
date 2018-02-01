package example.com.testui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

public class NotificationBuilderCompat extends Notification.Builder {

    public NotificationBuilderCompat(Context context) {
        super(context);
    }

/*    // 20
    public NotificationBuilderCompat addAction (Notification.Action action) {
        return this;
    }*/
    // 16

    public static final int PRIORITY_DEFAULT = 0x00000000;
    public static final int PRIORITY_HIGH = 0x00000001;
    public static final int PRIORITY_LOW = 0xffffffff;
    public static final int PRIORITY_MAX = 0x00000002;
    public static final int PRIORITY_MIN = 0xfffffffe;

    /**
     * Notification visibility: Show this notification in its entirety on all lockscreens.
     *
     * {@see #visibility}
     */
    public static final int VISIBILITY_PUBLIC = 1;

    /**
     * Notification visibility: Show this notification on all lockscreens, but conceal sensitive or
     * private information on secure lockscreens.
     *
     * {@see #visibility}
     */
    public static final int VISIBILITY_PRIVATE = 0;

    /**
     * Notification visibility: Do not reveal any part of this notification on a secure lockscreen.
     *
     * {@see #visibility}
     */
    public static final int VISIBILITY_SECRET = -1;

    public NotificationBuilderCompat addAction (int icon, CharSequence title, PendingIntent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.addAction(icon, title, intent);
        }
        return this;
    }
/*    // 20
    public NotificationBuilderCompat addExtras (Bundle extras) {
        return this;
    }
    // 21
    public NotificationBuilderCompat addPerson (String uri) {
        return this;
    }
*/
    // 16
    public Notification build() {
        if (Build.VERSION.SDK_INT >= 16) {
            return super.build();
        } else {
            return super.getNotification();
        }
    }
/*
    // 20
    public NotificationBuilderCompat extend(Notification.Extender extender) {
        return this;
    }
    // 21
    public NotificationBuilderCompat setCategory (String category) {
        return this;
    }
    // 21
    public NotificationBuilderCompat setColor (int argb) {
        return this;
    }*/

    // 19
    public NotificationBuilderCompat setExtras (Bundle extras) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.setExtras(extras);
        }
        return this;
    }
/*    // 20
    public NotificationBuilderCompat setGroup(String groupKey) {
        return this;
    }
    // 20
    public NotificationBuilderCompat setGroupSummary (boolean isGroupSummary) {
        return this;
    }
    // 20
    public NotificationBuilderCompat setLocalOnly (boolean localOnly) {
        return this;
    }*/
    // 16
    public NotificationBuilderCompat setPriority (int pri) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.setPriority(pri);
        }
        return this;
    }
/*    // 21
    public NotificationBuilderCompat setPublicVersion (Notification n) {
         return this;
     }*/
    // 17
    public NotificationBuilderCompat setShowWhen (boolean show) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.setShowWhen(show);
        }
        return this;
    }
/*    // 20
    public NotificationBuilderCompat setSortKey (String sortKey) {
        return this;
    }
    // 21
    public NotificationBuilderCompat setSound (Uri sound, AudioAttributes audioAttributes) {
        return this;
    }*/
    // 16
    public NotificationBuilderCompat setStyle (Notification.Style style) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.setStyle(style);
        }
        return this;
    }
    // 16
    public NotificationBuilderCompat setSubText (CharSequence text) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.setSubText(text);
        }
        return this;
    }
    // 16
    public NotificationBuilderCompat setUsesChronometer (boolean b) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.setUsesChronometer(b);
        }
        return this;
    }
    // 21
    public NotificationBuilderCompat setVisibility (int visibility) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setVisibility(visibility);
        }
        return this;
    }
}
