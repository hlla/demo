package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ag.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class RemindDialog
  extends Activity
{
  private static boolean fEh;
  private static List<String> qUa;
  private String fJC;
  private ad handler;
  private h oGr;
  private List<String> qTZ;
  private ag.d qUb;
  
  static
  {
    GMTrace.i(5812835581952L, 43309);
    qUa = new ArrayList();
    fEh = false;
    GMTrace.o(5812835581952L, 43309);
  }
  
  public RemindDialog()
  {
    GMTrace.i(5811493404672L, 43299);
    this.fJC = "";
    this.qTZ = new ArrayList();
    this.handler = new ad();
    this.qUb = new ag.d()
    {
      public final void h(String paramAnonymousString, long paramAnonymousLong)
      {
        GMTrace.i(5813104017408L, 43311);
        v.d("MicroMsg.RemindDialog", "onVoiceRemind " + paramAnonymousString);
        RemindDialog.a(RemindDialog.this).add(paramAnonymousString);
        RemindDialog.b(RemindDialog.this);
        GMTrace.o(5813104017408L, 43311);
      }
    };
    GMTrace.o(5811493404672L, 43299);
  }
  
  private void bna()
  {
    GMTrace.i(5811761840128L, 43301);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5813909323776L, 43317);
        StringBuffer localStringBuffer = new StringBuffer();
        Iterator localIterator = RemindDialog.a(RemindDialog.this).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (bf.mA(str)) {
            localStringBuffer.append("\n\n");
          } else {
            localStringBuffer.append(str + "\n\n");
          }
        }
        if (RemindDialog.d(RemindDialog.this) != null) {
          RemindDialog.d(RemindDialog.this).setMessage(localStringBuffer);
        }
        GMTrace.o(5813909323776L, 43317);
      }
    });
    GMTrace.o(5811761840128L, 43301);
  }
  
  public static void r(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(5812164493312L, 43304);
    v.d("MicroMsg.RemindDialog", "show " + fEh + " remind " + paramString2);
    if (fEh)
    {
      qUa.add(paramString2);
      GMTrace.o(5812164493312L, 43304);
      return;
    }
    qUa.clear();
    fEh = true;
    if (ap.vd().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      GMTrace.o(5812164493312L, 43304);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
    GMTrace.o(5812164493312L, 43304);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(5811627622400L, 43300);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new h.a(this);
    paramBundle.zR(R.l.faJ);
    paramBundle.SW(" ");
    paramBundle.zU(R.l.faG).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(5811359186944L, 43298);
        paramAnonymousDialogInterface = d.bmQ();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.gd(RemindDialog.c(RemindDialog.this));
        }
        if (o.fs(ap.getNotification().qh()))
        {
          RemindDialog.this.finish();
          GMTrace.o(5811359186944L, 43298);
          return;
        }
        b.imb.e(new Intent().putExtra("Chat_User", RemindDialog.c(RemindDialog.this)), RemindDialog.this);
        RemindDialog.this.finish();
        GMTrace.o(5811359186944L, 43298);
      }
    });
    paramBundle.zV(R.l.faI).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(5813640888320L, 43315);
        paramAnonymousDialogInterface = d.bmQ();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.gd(RemindDialog.c(RemindDialog.this));
        }
        RemindDialog.this.finish();
        GMTrace.o(5813640888320L, 43315);
      }
    });
    paramBundle.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(5813372452864L, 43313);
        RemindDialog.this.finish();
        GMTrace.o(5813372452864L, 43313);
      }
    });
    this.fJC = getIntent().getStringExtra("_RemindDialog_User");
    Object localObject = getIntent().getStringExtra("_RemindDialog_Remind");
    this.qTZ.clear();
    this.qTZ.add(localObject);
    localObject = qUa.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.qTZ.add(str);
    }
    this.oGr = paramBundle.WD();
    this.oGr.setCanceledOnTouchOutside(false);
    this.oGr.show();
    bna();
    GMTrace.o(5811627622400L, 43300);
  }
  
  public void onPause()
  {
    GMTrace.i(5812030275584L, 43303);
    fEh = false;
    d locald = d.bmQ();
    if (locald != null) {
      locald.b(this.qUb);
    }
    super.onPause();
    GMTrace.o(5812030275584L, 43303);
  }
  
  public void onResume()
  {
    GMTrace.i(5811896057856L, 43302);
    fEh = true;
    d locald = d.bmQ();
    if (locald != null) {
      locald.a(this.qUb);
    }
    super.onResume();
    GMTrace.o(5811896057856L, 43302);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */