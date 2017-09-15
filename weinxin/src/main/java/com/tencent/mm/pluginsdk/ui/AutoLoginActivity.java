package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  public AutoLoginActivity()
  {
    GMTrace.i(1162191306752L, 8659);
    GMTrace.o(1162191306752L, 8659);
  }
  
  public static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.f paramf, String paramString, int paramInt)
  {
    GMTrace.i(1162862395392L, 8664);
    Signature[] arrayOfSignature = p.aQ(paramContext, paramString);
    Object localObject = "";
    paramContext = (Context)localObject;
    if (arrayOfSignature != null)
    {
      paramContext = (Context)localObject;
      if (arrayOfSignature.length > 0)
      {
        int j = arrayOfSignature.length;
        int i = 0;
        for (;;)
        {
          paramContext = (Context)localObject;
          if (i >= j) {
            break;
          }
          paramContext = arrayOfSignature[i];
          localObject = (String)localObject + p.Mi(com.tencent.mm.a.g.n(paramContext.toByteArray())) + "|";
          i += 1;
        }
      }
    }
    localObject = paramContext;
    if (paramContext.length() > 1) {
      localObject = paramContext.substring(0, paramContext.length() - 1);
    }
    paramContext = new JSONObject();
    try
    {
      paramContext.put("raw_package_name", bf.ap(paramString, ""));
      paramContext.put("package_name", bf.ap(paramf.field_packageName, ""));
      paramContext.put("raw_signature", localObject);
      paramContext.put("signature", bf.ap(paramf.field_signature, ""));
      paramContext.put("scene", paramInt);
      paramString = new gn();
      paramString.fLE.appId = paramf.field_appId;
      paramString.fLE.opType = 3;
      paramString.fLE.fFj = paramContext.toString();
      com.tencent.mm.sdk.b.a.uql.m(paramString);
      GMTrace.o(1162862395392L, 8664);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        v.i("MicroMsg.AutoLoginActivity", "doIfAppInValid, jsonException = " + paramString.getMessage());
      }
    }
  }
  
  private void xe(int paramInt)
  {
    GMTrace.i(1162593959936L, 8662);
    switch (paramInt)
    {
    default: 
      v.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = " + paramInt);
      a(b.sGz, getIntent());
      GMTrace.o(1162593959936L, 8662);
      return;
    case -1: 
      a(b.sGy, getIntent());
      GMTrace.o(1162593959936L, 8662);
      return;
    case 0: 
      aOW();
      GMTrace.o(1162593959936L, 8662);
      return;
    }
    a(b.sGA, getIntent());
    GMTrace.o(1162593959936L, 8662);
  }
  
  public abstract void a(b paramb, Intent paramIntent);
  
  public boolean aOW()
  {
    GMTrace.i(1162728177664L, 8663);
    if ((!ap.za()) || (ap.uP()))
    {
      v.w("MicroMsg.AutoLoginActivity", "not login");
      Intent localIntent1 = new Intent(this, getClass());
      localIntent1.putExtras(getIntent());
      localIntent1.addFlags(67108864);
      localIntent1.setDataAndType(getIntent().getData(), getIntent().getType());
      localIntent1.setAction(getIntent().getAction());
      Intent localIntent2 = new Intent();
      localIntent2.putExtras(getIntent());
      com.tencent.mm.bb.d.a(this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", localIntent2, localIntent1);
      GMTrace.o(1162728177664L, 8663);
      return true;
    }
    GMTrace.o(1162728177664L, 8663);
    return false;
  }
  
  protected final boolean bDR()
  {
    GMTrace.i(17762105688064L, 132338);
    GMTrace.o(17762105688064L, 132338);
    return true;
  }
  
  public int getLayoutId()
  {
    GMTrace.i(1162996613120L, 8665);
    GMTrace.o(1162996613120L, 8665);
    return -1;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    GMTrace.i(1162325524480L, 8660);
    super.onCreate(paramBundle);
    zb(8);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      v.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      GMTrace.o(1162325524480L, 8660);
      return;
    }
    com.tencent.mm.bb.d.bGH();
    v.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = r.a(paramBundle, "wizard_activity_result_code", -2);
    v.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = " + i);
    if (i != -2)
    {
      xe(i);
      GMTrace.o(1162325524480L, 8660);
      return;
    }
    if (!u(paramBundle))
    {
      v.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      GMTrace.o(1162325524480L, 8660);
      return;
    }
    if (aOW())
    {
      finish();
      v.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      GMTrace.o(1162325524480L, 8660);
      return;
    }
    paramBundle = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17761031946240L, 132330);
        AutoLoginActivity.this.a(AutoLoginActivity.b.sGy, paramBundle);
        GMTrace.o(17761031946240L, 132330);
      }
    };
    if (!com.tencent.mm.kernel.h.vJ().gYz.gYV)
    {
      b localb = ((com.tencent.mm.kernel.b.f)com.tencent.mm.kernel.h.vF().vj()).gZo.gZg;
      if (((localb instanceof com.tencent.mm.app.h)) && (((com.tencent.mm.app.h)localb).og())) {
        com.tencent.mm.kernel.h.vJ().a(new com.tencent.mm.kernel.api.h()
        {
          public final void ak(boolean paramAnonymousBoolean)
          {
            GMTrace.i(17761703034880L, 132335);
            GMTrace.o(17761703034880L, 132335);
          }
          
          public final void oh()
          {
            GMTrace.i(17761568817152L, 132334);
            AutoLoginActivity.this.p(paramBundle);
            com.tencent.mm.kernel.h.vJ().b(this);
            GMTrace.o(17761568817152L, 132334);
          }
        });
      }
      v.w("MicroMsg.AutoLoginActivity", "DefaultBootStep was wrong again....");
      GMTrace.o(1162325524480L, 8660);
      return;
    }
    p(paramBundle);
    GMTrace.o(1162325524480L, 8660);
  }
  
  public void onDestroy()
  {
    GMTrace.i(17761971470336L, 132337);
    super.onDestroy();
    GMTrace.o(17761971470336L, 132337);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(1162459742208L, 8661);
    if (paramIntent == null)
    {
      GMTrace.o(1162459742208L, 8661);
      return;
    }
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    int i = r.a(paramIntent, "wizard_activity_result_code", 0);
    v.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = " + i);
    xe(i);
    GMTrace.o(1162459742208L, 8661);
  }
  
  protected final void p(Runnable paramRunnable)
  {
    GMTrace.i(17761837252608L, 132336);
    if ((isFinishing()) || (this.uRh))
    {
      GMTrace.o(17761837252608L, 132336);
      return;
    }
    new a().b(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17851092041728L, 133001);
        com.tencent.mm.ui.base.g.a(AutoLoginActivity.this, AutoLoginActivity.this.getString(R.l.cbL), false, null);
        GMTrace.o(17851092041728L, 133001);
      }
    }, paramRunnable);
    GMTrace.o(17761837252608L, 132336);
  }
  
  public abstract boolean u(Intent paramIntent);
  
  public static final class a
  {
    long s;
    private c<bv> sGt;
    private final AtomicBoolean sGu;
    
    public a()
    {
      GMTrace.i(17851494694912L, 133004);
      this.sGu = new AtomicBoolean(true);
      this.s = System.currentTimeMillis();
      GMTrace.o(17851494694912L, 133004);
    }
    
    /* Error */
    public final boolean F(Runnable paramRunnable)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc2_w 53
      //   7: ldc 55
      //   9: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   12: invokestatic 61	com/tencent/mm/kernel/h:vG	()Lcom/tencent/mm/kernel/a;
      //   15: getfield 67	com/tencent/mm/kernel/a:gXf	Z
      //   18: ifeq +60 -> 78
      //   21: aload_0
      //   22: getfield 38	com/tencent/mm/pluginsdk/ui/AutoLoginActivity$a:sGu	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   25: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   28: ifeq +50 -> 78
      //   31: aload_0
      //   32: getfield 38	com/tencent/mm/pluginsdk/ui/AutoLoginActivity$a:sGu	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   35: iconst_0
      //   36: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   39: aload_1
      //   40: invokeinterface 79 1 0
      //   45: aload_0
      //   46: getfield 81	com/tencent/mm/pluginsdk/ui/AutoLoginActivity$a:sGt	Lcom/tencent/mm/sdk/b/c;
      //   49: ifnull +15 -> 64
      //   52: aload_0
      //   53: getfield 81	com/tencent/mm/pluginsdk/ui/AutoLoginActivity$a:sGt	Lcom/tencent/mm/sdk/b/c;
      //   56: invokevirtual 86	com/tencent/mm/sdk/b/c:dead	()V
      //   59: aload_0
      //   60: aconst_null
      //   61: putfield 81	com/tencent/mm/pluginsdk/ui/AutoLoginActivity$a:sGt	Lcom/tencent/mm/sdk/b/c;
      //   64: iconst_1
      //   65: istore_2
      //   66: ldc2_w 53
      //   69: ldc 55
      //   71: invokestatic 49	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   74: aload_0
      //   75: monitorexit
      //   76: iload_2
      //   77: ireturn
      //   78: ldc2_w 53
      //   81: ldc 55
      //   83: invokestatic 49	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   86: goto -12 -> 74
      //   89: astore_1
      //   90: aload_0
      //   91: monitorexit
      //   92: aload_1
      //   93: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	94	0	this	a
      //   0	94	1	paramRunnable	Runnable
      //   1	76	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   4	64	89	finally
      //   66	74	89	finally
      //   78	86	89	finally
    }
    
    public final boolean b(Runnable paramRunnable1, final Runnable paramRunnable2)
    {
      GMTrace.i(17851628912640L, 133005);
      if (com.tencent.mm.kernel.h.vG().gXf)
      {
        paramRunnable2.run();
        GMTrace.o(17851628912640L, 133005);
        return true;
      }
      if (paramRunnable1 != null) {
        paramRunnable1.run();
      }
      this.sGt = new c() {};
      this.sGt.bIo();
      boolean bool = F(paramRunnable2);
      GMTrace.o(17851628912640L, 133005);
      return bool;
    }
    
    protected final void finalize()
    {
      GMTrace.i(17851897348096L, 133007);
      super.finalize();
      if (this.sGt != null)
      {
        this.sGt.dead();
        this.sGt = null;
      }
      GMTrace.o(17851897348096L, 133007);
    }
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(1225139421184L, 9128);
      sGy = new b("LOGIN_OK", 0);
      sGz = new b("LOGIN_FAIL", 1);
      sGA = new b("LOGIN_CANCEL", 2);
      sGB = new b[] { sGy, sGz, sGA };
      GMTrace.o(1225139421184L, 9128);
    }
    
    private b()
    {
      GMTrace.i(1225005203456L, 9127);
      GMTrace.o(1225005203456L, 9127);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/AutoLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */