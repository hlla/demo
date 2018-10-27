package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

final class ck
  implements cb
{
  public final List a = new ArrayList();
  public final Notification.Builder b;
  public final cg c;
  public final Bundle d = new Bundle();
  
  ck(cg paramcg)
  {
    this.c = paramcg;
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.b = new Notification.Builder(paramcg.h, paramcg.c);; this.b = new Notification.Builder(paramcg.h))
    {
      Object localObject2 = paramcg.o;
      Object localObject1 = this.b.setWhen(((Notification)localObject2).when).setSmallIcon(((Notification)localObject2).icon, ((Notification)localObject2).iconLevel).setContent(((Notification)localObject2).contentView).setTicker(((Notification)localObject2).tickerText, null).setVibrate(((Notification)localObject2).vibrate).setLights(((Notification)localObject2).ledARGB, ((Notification)localObject2).ledOnMS, ((Notification)localObject2).ledOffMS);
      if ((((Notification)localObject2).flags & 0x2) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((Notification.Builder)localObject1).setOngoing(bool);
        if ((((Notification)localObject2).flags & 0x8) != 0) {}
        for (bool = true;; bool = false)
        {
          localObject1 = ((Notification.Builder)localObject1).setOnlyAlertOnce(bool);
          if ((((Notification)localObject2).flags & 0x10) != 0) {}
          for (bool = true;; bool = false)
          {
            localObject1 = ((Notification.Builder)localObject1).setAutoCancel(bool).setDefaults(((Notification)localObject2).defaults).setContentTitle(paramcg.g).setContentText(paramcg.f).setContentInfo(null).setContentIntent(paramcg.e).setDeleteIntent(((Notification)localObject2).deleteIntent);
            if ((((Notification)localObject2).flags & 0x80) != 0) {}
            for (bool = true;; bool = false)
            {
              ((Notification.Builder)localObject1).setFullScreenIntent(null, bool).setLargeIcon(paramcg.m).setNumber(paramcg.p).setProgress(paramcg.u, paramcg.s, paramcg.t);
              if (Build.VERSION.SDK_INT < 21) {
                this.b.setSound(((Notification)localObject2).sound, ((Notification)localObject2).audioStreamType);
              }
              ArrayList localArrayList;
              int i;
              label426:
              label447:
              label467:
              label488:
              int j;
              if (Build.VERSION.SDK_INT >= 16)
              {
                this.b.setSubText(null).setUsesChronometer(false).setPriority(paramcg.r);
                localArrayList = paramcg.a;
                int k = localArrayList.size();
                i = 0;
                if (i < k)
                {
                  cd localcd = (cd)localArrayList.get(i);
                  Notification.Action.Builder localBuilder;
                  if (Build.VERSION.SDK_INT >= 20)
                  {
                    localBuilder = new Notification.Action.Builder(localcd.b, localcd.i, localcd.a);
                    localObject1 = localcd.f;
                    if (localObject1 == null)
                    {
                      localObject1 = localcd.e;
                      if (localObject1 == null)
                      {
                        localObject1 = new Bundle();
                        ((Bundle)localObject1).putBoolean("android.support.allowGeneratedReplies", localcd.c);
                        if (Build.VERSION.SDK_INT < 24)
                        {
                          ((Bundle)localObject1).putInt("android.support.action.semanticAction", localcd.g);
                          if (Build.VERSION.SDK_INT < 28)
                          {
                            ((Bundle)localObject1).putBoolean("android.support.action.showsUserInterface", localcd.h);
                            localBuilder.addExtras((Bundle)localObject1);
                            this.b.addAction(localBuilder.build());
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    localBuilder.setSemanticAction(localcd.g);
                    break label488;
                    localBuilder.setAllowGeneratedReplies(localcd.c);
                    break label467;
                    localObject1 = new Bundle((Bundle)localObject1);
                    break label447;
                    localObject1 = co.a((co[])localObject1);
                    int m = localObject1.length;
                    j = 0;
                    while (j < m)
                    {
                      localBuilder.addRemoteInput(localObject1[j]);
                      j += 1;
                    }
                    break label426;
                    this.a.add(cl.a(this.b, localcd));
                  }
                }
                localObject1 = paramcg.i;
                if (localObject1 != null) {
                  this.d.putAll((Bundle)localObject1);
                }
                if (Build.VERSION.SDK_INT < 20)
                {
                  if (paramcg.n) {
                    this.d.putBoolean("android.support.localOnly", true);
                  }
                  localObject1 = paramcg.j;
                  if (localObject1 != null)
                  {
                    this.d.putString("android.support.groupKey", (String)localObject1);
                    if (!paramcg.k) {
                      break label1145;
                    }
                    this.d.putBoolean("android.support.isGroupSummary", true);
                  }
                }
              }
              for (;;)
              {
                if (Build.VERSION.SDK_INT >= 19)
                {
                  this.b.setShowWhen(paramcg.v);
                  if (Build.VERSION.SDK_INT < 21)
                  {
                    localObject1 = paramcg.q;
                    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
                    {
                      localObject1 = this.d;
                      localArrayList = paramcg.q;
                      ((Bundle)localObject1).putStringArray("android.people", (String[])localArrayList.toArray(new String[localArrayList.size()]));
                    }
                  }
                }
                if (Build.VERSION.SDK_INT >= 20) {
                  this.b.setLocalOnly(paramcg.n).setGroup(paramcg.j).setGroupSummary(paramcg.k).setSortKey(null);
                }
                if (Build.VERSION.SDK_INT >= 21)
                {
                  this.b.setCategory(paramcg.b).setColor(paramcg.d).setVisibility(0).setPublicVersion(null).setSound(((Notification)localObject2).sound, ((Notification)localObject2).audioAttributes);
                  localObject1 = paramcg.q;
                  j = ((ArrayList)localObject1).size();
                  i = 0;
                  while (i < j)
                  {
                    localObject2 = (String)((ArrayList)localObject1).get(i);
                    this.b.addPerson((String)localObject2);
                    i += 1;
                  }
                  if (paramcg.l.size() > 0)
                  {
                    localObject1 = paramcg.a().getBundle("android.car.EXTENSIONS");
                    if (localObject1 != null) {
                      break label1142;
                    }
                    localObject1 = new Bundle();
                  }
                }
                label1142:
                for (;;)
                {
                  localObject2 = new Bundle();
                  i = 0;
                  for (;;)
                  {
                    if (i >= paramcg.l.size())
                    {
                      ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
                      paramcg.a().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
                      this.d.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
                      if (Build.VERSION.SDK_INT >= 24) {
                        this.b.setExtras(paramcg.i).setRemoteInputHistory(null);
                      }
                      if (Build.VERSION.SDK_INT >= 26)
                      {
                        this.b.setBadgeIconType(0).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
                        if (!TextUtils.isEmpty(paramcg.c)) {
                          this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
                        }
                      }
                      return;
                    }
                    ((Bundle)localObject2).putBundle(Integer.toString(i), cl.a((cd)paramcg.l.get(i)));
                    i += 1;
                  }
                }
                label1145:
                this.d.putBoolean("android.support.useSideChannel", true);
              }
            }
          }
        }
      }
    }
  }
  
  public final Notification.Builder a()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */