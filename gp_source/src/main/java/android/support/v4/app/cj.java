package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

public final class cj
  implements ch
{
  public int a = 1;
  private ArrayList b = new ArrayList();
  private Bitmap c;
  private String d;
  private int e = -1;
  private int f;
  private int g = 8388613;
  private int h;
  private int i = 0;
  private String j;
  private PendingIntent k;
  private int l = 80;
  private int m;
  private ArrayList n = new ArrayList();
  
  public final cg a(cg paramcg)
  {
    Bundle localBundle = new Bundle();
    if (!this.b.isEmpty())
    {
      ArrayList localArrayList1 = new ArrayList(this.b.size());
      ArrayList localArrayList2 = this.b;
      int i3 = localArrayList2.size();
      i1 = 0;
      while (i1 < i3)
      {
        cd localcd = (cd)localArrayList2.get(i1);
        if (Build.VERSION.SDK_INT < 20)
        {
          localArrayList1.add(cl.a(localcd));
          i1 += 1;
        }
        else
        {
          Notification.Action.Builder localBuilder = new Notification.Action.Builder(localcd.b, localcd.i, localcd.a);
          localObject = localcd.e;
          if (localObject != null) {}
          for (localObject = new Bundle((Bundle)localObject);; localObject = new Bundle())
          {
            ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", localcd.c);
            if (Build.VERSION.SDK_INT < 24) {}
            for (;;)
            {
              localBuilder.addExtras((Bundle)localObject);
              localObject = localcd.f;
              if (localObject != null)
              {
                localObject = co.a((co[])localObject);
                int i4 = localObject.length;
                int i2 = 0;
                while (i2 < i4)
                {
                  localBuilder.addRemoteInput(localObject[i2]);
                  i2 += 1;
                }
              }
              localArrayList1.add(localBuilder.build());
              break;
              localBuilder.setAllowGeneratedReplies(localcd.c);
            }
          }
        }
      }
      localBundle.putParcelableArrayList("actions", localArrayList1);
    }
    int i1 = this.a;
    if (i1 != 1) {
      localBundle.putInt("flags", i1);
    }
    Object localObject = this.k;
    if (localObject != null) {
      localBundle.putParcelable("displayIntent", (Parcelable)localObject);
    }
    if (!this.n.isEmpty())
    {
      localObject = this.n;
      localBundle.putParcelableArray("pages", (Parcelable[])((ArrayList)localObject).toArray(new Notification[((ArrayList)localObject).size()]));
    }
    localObject = this.c;
    if (localObject != null) {
      localBundle.putParcelable("background", (Parcelable)localObject);
    }
    i1 = this.f;
    if (i1 != 0) {
      localBundle.putInt("contentIcon", i1);
    }
    i1 = this.g;
    if (i1 != 8388613) {
      localBundle.putInt("contentIconGravity", i1);
    }
    i1 = this.e;
    if (i1 != -1) {
      localBundle.putInt("contentActionIndex", i1);
    }
    i1 = this.i;
    if (i1 != 0) {
      localBundle.putInt("customSizePreset", i1);
    }
    i1 = this.h;
    if (i1 != 0) {
      localBundle.putInt("customContentHeight", i1);
    }
    i1 = this.l;
    if (i1 != 80) {
      localBundle.putInt("gravity", i1);
    }
    i1 = this.m;
    if (i1 != 0) {
      localBundle.putInt("hintScreenTimeout", i1);
    }
    localObject = this.j;
    if (localObject != null) {
      localBundle.putString("dismissalId", (String)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      localBundle.putString("bridgeTag", (String)localObject);
    }
    paramcg.a().putBundle("android.wearable.EXTENSIONS", localBundle);
    return paramcg;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */