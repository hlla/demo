package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.performance.b.a.a;
import com.tencent.mm.performance.c.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public final class d
{
  public static HashMap<String, WeakReference<Object>> igI;
  public c igJ;
  
  static
  {
    GMTrace.i(13133607337984L, 97853);
    igI = new HashMap();
    GMTrace.o(13133607337984L, 97853);
  }
  
  public d(final Context paramContext)
  {
    GMTrace.i(13133473120256L, 97852);
    this.igJ = new c();
    if (this.igJ.Nf())
    {
      this.igJ.a(new a());
      if ((com.tencent.mm.performance.c.a.isEnabled()) && (this.igJ.Ng()))
      {
        this.igJ.mm(com.tencent.mm.performance.c.c.TYPE);
        this.igJ.a(new c.c()
        {
          public final void a(final com.tencent.mm.performance.d.d<Object> paramAnonymousd, boolean paramAnonymousBoolean)
          {
            GMTrace.i(13134412644352L, 97859);
            final Object localObject = paramAnonymousd.get();
            if (localObject == null)
            {
              GMTrace.o(13134412644352L, 97859);
              return;
            }
            v.e("MicroMsg.WxPerformace", "memoryleak===" + localObject.getClass().toString() + "   " + paramAnonymousBoolean);
            if (localObject.getClass().equals(MemoryLeakActivity.class))
            {
              GMTrace.o(13134412644352L, 97859);
              return;
            }
            com.tencent.mm.bl.b.bNV();
            if (paramAnonymousd.get() == null)
            {
              GMTrace.o(13134412644352L, 97859);
              return;
            }
            localObject = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
            localObject = (String)localObject + "_" + paramAnonymousd.igr.replace('.', '_');
            final AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext).setTitle("UILeak found!").setMessage("Dumping hprof...").setCancelable(false).create();
            localAlertDialog.getWindow().setType(2005);
            localAlertDialog.setOnShowListener(new DialogInterface.OnShowListener()
            {
              public final void onShow(DialogInterface paramAnonymous2DialogInterface)
              {
                GMTrace.i(13140318224384L, 97903);
                ae.v(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(13133070467072L, 97849);
                    String str = com.tencent.mm.bl.b.Sw(d.1.1.this.igL);
                    d.1.1.this.igM.dismiss();
                    if ((str != null) && (str.length() > 0))
                    {
                      com.tencent.mm.performance.c.a.h(aa.getContext(), str, d.1.1.this.igN.igr);
                      GMTrace.o(13133070467072L, 97849);
                      return;
                    }
                    v.e("MicroMsg.WxPerformace", "Failed to dump hprof file, do not wake up analyse app.");
                    GMTrace.o(13133070467072L, 97849);
                  }
                });
                GMTrace.o(13140318224384L, 97903);
              }
            });
            localAlertDialog.show();
            GMTrace.o(13134412644352L, 97859);
          }
        });
      }
    }
    if (this.igJ.Nh()) {
      this.igJ.a(new a.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
        {
          GMTrace.i(13138976047104L, 97893);
          v.e("MicroMsg.WxPerformace", "onMemoryDangerLow percentage:" + paramAnonymousLong1 + " max:" + paramAnonymousLong2 + " used:" + paramAnonymousLong3);
          GMTrace.o(13138976047104L, 97893);
        }
        
        public final void b(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
        {
          GMTrace.i(13139110264832L, 97894);
          v.e("MicroMsg.WxPerformace", "onMemoryDangerMiddle percentage:" + paramAnonymousLong1 + " max:" + paramAnonymousLong2 + " used:" + paramAnonymousLong3);
          GMTrace.o(13139110264832L, 97894);
        }
        
        public final void c(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
        {
          GMTrace.i(13139244482560L, 97895);
          v.e("MicroMsg.WxPerformace", "onMemoryDangerHigh percentage:" + paramAnonymousLong1 + " max:" + paramAnonymousLong2 + " used:" + paramAnonymousLong3);
          GMTrace.o(13139244482560L, 97895);
        }
      });
    }
    b.igD = 3000;
    Object localObject = this.igJ;
    if (((c)localObject).igH == null)
    {
      ((c)localObject).igH = new b("MonitorHandlerThread", (c)localObject);
      ((c)localObject).igH.start();
      paramContext = ((c)localObject).igH;
      localObject = ((c)localObject).igH.getLooper();
      if (localObject == null) {
        throw new IllegalArgumentException("setHandler, threadLooper is null");
      }
      paramContext.mHandler = new b.1(paramContext, (Looper)localObject);
      paramContext.mHandler.sendEmptyMessageDelayed(1, b.igD);
    }
    GMTrace.o(13133473120256L, 97852);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/wxperformancetool/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */