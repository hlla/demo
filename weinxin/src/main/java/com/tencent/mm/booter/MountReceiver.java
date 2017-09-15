package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MountReceiver
  extends BroadcastReceiver
{
  private String action;
  private Context context;
  private ad gJF;
  
  public MountReceiver()
  {
    GMTrace.i(499021512704L, 3718);
    this.context = null;
    this.action = "";
    this.gJF = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool1 = true;
        GMTrace.i(497008246784L, 3703);
        paramAnonymousMessage = MountReceiver.a(MountReceiver.this);
        boolean bool2 = ap.zb();
        if (MountReceiver.b(MountReceiver.this) == null) {}
        for (;;)
        {
          v.d("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b", new Object[] { paramAnonymousMessage, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(f.sa()) });
          if (MountReceiver.b(MountReceiver.this) != null) {
            break;
          }
          GMTrace.o(497008246784L, 3703);
          return;
          bool1 = false;
        }
        if (!f.sa())
        {
          GMTrace.o(497008246784L, 3703);
          return;
        }
        com.tencent.mm.ui.base.s.eQ(MountReceiver.b(MountReceiver.this));
        GMTrace.o(497008246784L, 3703);
      }
    };
    GMTrace.o(499021512704L, 3718);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(499155730432L, 3719);
    if ((paramContext == null) || (paramIntent == null) || (u.mA(paramIntent.getAction())))
    {
      GMTrace.o(499155730432L, 3719);
      return;
    }
    this.context = paramContext;
    this.action = paramIntent.getAction();
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    v.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", new Object[] { this.action, Boolean.valueOf(ap.zb()), com.tencent.mm.compatible.util.e.hgi, str1 });
    boolean bool = this.action.equals("android.intent.action.MEDIA_MOUNTED");
    if ((!bool) && (!this.action.equals("android.intent.action.MEDIA_EJECT")) && (!this.action.equals("android.intent.action.MEDIA_SHARED")))
    {
      GMTrace.o(499155730432L, 3719);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.hgi.equalsIgnoreCase("/dev/null")) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i != 0) {}
      try
      {
        localObject = new StatFs(com.tencent.mm.compatible.util.e.hgi);
        v.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { com.tencent.mm.compatible.util.e.hgi, Integer.valueOf(((StatFs)localObject).getBlockSize()), Integer.valueOf(((StatFs)localObject).getBlockCount()), Integer.valueOf(((StatFs)localObject).getAvailableBlocks()) });
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          v.e("MicroMsg.MountReceiver", "CheckSD failed :%s", new Object[] { localException.getMessage() });
          j = 0;
          continue;
          l = 12L;
          continue;
          paramIntent = new com.tencent.mm.storage.s(w.hgg + "SdcardInfo.cfg");
          String str2 = (String)paramIntent.get(1, "");
          i = ((Integer)paramIntent.get(2, Integer.valueOf(0))).intValue();
          j = Build.VERSION.SDK_INT;
          String str3 = com.tencent.mm.compatible.util.e.hgi;
          paramIntent.set(1, str1);
          paramIntent.set(2, Integer.valueOf(j));
          com.tencent.mm.compatible.util.e.dw(str1);
          v.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), str1, str3, com.tencent.mm.compatible.util.e.hgi });
        }
        GMTrace.o(499155730432L, 3719);
        return;
      }
      paramIntent = paramIntent.getData();
      if (paramIntent == null) {
        break label621;
      }
      paramIntent = paramIntent.getPath();
      if (!com.tencent.mm.compatible.util.e.hgi.equalsIgnoreCase(paramIntent))
      {
        if ((!bool) || (j != 0)) {
          break label611;
        }
        localObject = g.oSF;
        if (!com.tencent.mm.compatible.util.e.hgi.equalsIgnoreCase("/dev/null")) {
          break;
        }
        l = 9L;
        ((g)localObject).a(340L, l, 1L, false);
        if ((u.mA(str1)) || (!str1.equalsIgnoreCase(paramIntent))) {
          break label601;
        }
        if (new File(w.hgg + "SdcardInfo.cfg").exists()) {
          break label460;
        }
        v.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", new Object[] { com.tencent.mm.compatible.util.e.hgi, str1, Integer.valueOf(Build.VERSION.SDK_INT) });
        com.tencent.mm.compatible.util.e.hgi = str1;
        com.tencent.mm.compatible.util.e.dw(str1);
      }
      if (!bool) {
        break label657;
      }
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(496337158144L, 3698);
          v.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", new Object[] { MountReceiver.a(MountReceiver.this), Boolean.valueOf(ap.zb()) });
          if (!ap.zb())
          {
            GMTrace.o(496337158144L, 3698);
            return;
          }
          h.vI().vv();
          ap.yY();
          c.vt();
          MountReceiver.c(MountReceiver.this).sendEmptyMessage(0);
          GMTrace.o(496337158144L, 3698);
        }
      });
      GMTrace.o(499155730432L, 3719);
      return;
    }
    label460:
    label601:
    label611:
    GMTrace.o(499155730432L, 3719);
    return;
    label621:
    paramIntent = g.oSF;
    if (bool) {}
    for (long l = 13L;; l = 14L)
    {
      paramIntent.a(340L, l, 1L, false);
      break;
    }
    label657:
    com.tencent.mm.ui.base.s.eP(paramContext);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(495397634048L, 3691);
        v.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", new Object[] { MountReceiver.a(MountReceiver.this), Boolean.valueOf(ap.zb()) });
        if (!ap.zb())
        {
          GMTrace.o(495397634048L, 3691);
          return;
        }
        h.vI().vv();
        ap.yY();
        c.vt();
        GMTrace.o(495397634048L, 3691);
      }
    });
    GMTrace.o(499155730432L, 3719);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/MountReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */