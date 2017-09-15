package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.d.e;
import java.io.File;

public final class b
{
  public int gLJ;
  
  public b()
  {
    GMTrace.i(529220501504L, 3943);
    this.gLJ = 0;
    GMTrace.o(529220501504L, 3943);
  }
  
  private static boolean av(Context paramContext)
  {
    GMTrace.i(529623154688L, 3946);
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      GMTrace.o(529623154688L, 3946);
      return false;
    }
    boolean bool = paramContext.isWiredHeadsetOn();
    GMTrace.o(529623154688L, 3946);
    return bool;
  }
  
  private static boolean dU(int paramInt)
  {
    GMTrace.i(529488936960L, 3945);
    if ((paramInt & 0x1) > 0)
    {
      GMTrace.o(529488936960L, 3945);
      return true;
    }
    GMTrace.o(529488936960L, 3945);
    return false;
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification, String paramString)
  {
    GMTrace.i(529354719232L, 3944);
    int i;
    if (com.tencent.mm.i.f.sk())
    {
      i = 0;
      paramString = paramNotification;
      if (paramNotification == null) {
        paramString = new Notification();
      }
      v.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramString.defaults), g.a(paramString.vibrate), paramString.sound });
      if (paramBoolean2) {
        paramString.vibrate = bf.ijF;
      }
      if (paramBoolean1)
      {
        paramNotification = com.tencent.mm.i.f.sp();
        if (!av(paramContext)) {
          break label214;
        }
        i = 0;
        paramString.sound = null;
        f.a.gLV.di(paramNotification);
        v.i("MicroMsg.NotificationDefaults", "initDefaults, wireOn & playSound by ourselves: %s(if null play follow system notification sound)", new Object[] { paramNotification });
      }
      for (;;)
      {
        v.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Integer.valueOf(i), g.a(paramString.vibrate), paramString.sound });
        this.gLJ = i;
        i = this.gLJ;
        GMTrace.o(529354719232L, 3944);
        return i;
        label214:
        if ((paramNotification != null) && (paramNotification != d.e.gST))
        {
          i = 0;
          paramString.sound = Uri.parse(paramNotification);
        }
        else
        {
          i = 1;
        }
      }
    }
    v.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramNotification.defaults), paramNotification.vibrate, paramNotification.sound });
    boolean bool1;
    int j;
    if (paramBoolean1) {
      if (av(paramContext))
      {
        bool1 = true;
        j = 0;
      }
    }
    for (;;)
    {
      i = j;
      if (paramBoolean2) {
        i = j | 0x2;
      }
      String str = com.tencent.mm.i.f.sp();
      if (bf.mA(paramString)) {
        v.d("MicroMsg.NotificationDefaults", "msgContent is null");
      }
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (new File(str).exists()) {
          paramString = d.e.gST;
        }
      }
      boolean bool2;
      label398:
      label413:
      label432:
      boolean bool3;
      if (p.gRb.gPV != 2)
      {
        bool2 = true;
        if (!bool2) {
          break label678;
        }
        if ((i & 0x2) <= 0) {
          break label610;
        }
        j = 1;
        if (j == 0) {
          break label673;
        }
        i &= 0xFFFFFFFD;
        bf.k(paramContext, true);
        paramBoolean1 = true;
        if ((!dU(i)) || (bool1)) {
          break label666;
        }
        f.a.gLV.di(paramString);
        i &= 0xFFFFFFFE;
        bool3 = true;
        paramBoolean2 = paramBoolean1;
        paramBoolean1 = bool3;
      }
      for (;;)
      {
        if (bool1)
        {
          j = i & 0xFFFFFFFE;
          f.a.gLV.di(paramString);
          bool3 = true;
        }
        for (;;)
        {
          this.gLJ = j;
          v.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", new Object[] { Integer.valueOf(paramNotification.defaults), g.a(paramNotification.vibrate), paramNotification.sound, paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool3) });
          i = this.gLJ;
          GMTrace.o(529354719232L, 3944);
          return i;
          bool1 = false;
          j = 1;
          break;
          bool2 = false;
          break label398;
          label610:
          j = 0;
          break label413;
          bool3 = paramBoolean1;
          j = i;
          if (dU(i))
          {
            bool3 = paramBoolean1;
            j = i;
            if (paramString != null)
            {
              j = i & 0xFFFFFFFE;
              paramNotification.sound = Uri.parse(paramString);
              bool3 = paramBoolean1;
            }
          }
        }
        label666:
        paramBoolean2 = paramBoolean1;
        paramBoolean1 = false;
        continue;
        label673:
        paramBoolean1 = false;
        break label432;
        label678:
        paramBoolean2 = false;
        paramBoolean1 = false;
      }
      bool1 = false;
      j = 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */