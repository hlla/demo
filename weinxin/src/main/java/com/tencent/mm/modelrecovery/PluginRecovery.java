package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.mb;
import com.tencent.mm.e.a.mb.a;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery
  extends com.tencent.mm.kernel.b.d
  implements com.tencent.mm.kernel.api.bucket.c
{
  private com.tencent.mm.sdk.b.c<mb> hOm;
  private RecoveryLog.RecoveryLogImpl hOn;
  private BroadcastReceiver tF;
  
  static
  {
    GMTrace.i(4515352805376L, 33642);
    GMTrace.o(4515352805376L, 33642);
  }
  
  public PluginRecovery()
  {
    GMTrace.i(4514413281280L, 33635);
    this.hOm = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(mb paramAnonymousmb)
      {
        GMTrace.i(17959137312768L, 133806);
        switch (paramAnonymousmb.fTk.action)
        {
        }
        for (;;)
        {
          GMTrace.o(17959137312768L, 133806);
          return false;
          a.Ig();
          continue;
          paramAnonymousmb = aa.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.wOo = WXRecoveryHandleService.class.getName();
          localBuilder.wOp = WXRecoveryUploadService.class.getName();
          localBuilder.clientVersion = "0x26050D33";
          localBuilder.wOk = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
          localBuilder.mpX = WXUtil.fw(paramAnonymousmb);
          RecoveryLogic.a(paramAnonymousmb, localBuilder.cdq(), new RecoveryContext());
          continue;
          paramAnonymousmb = aa.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.wOo = WXRecoveryHandleService.class.getName();
          localBuilder.wOp = WXRecoveryUploadService.class.getName();
          localBuilder.clientVersion = "0x26050D33";
          localBuilder.wOk = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
          localBuilder.mpX = WXUtil.fw(paramAnonymousmb);
          RecoveryLogic.a(paramAnonymousmb, localBuilder.cdq(), new RecoveryContext());
        }
      }
    };
    this.tF = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        GMTrace.i(4513071104000L, 33625);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.this.postLog();
            GMTrace.o(4513071104000L, 33625);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.this.postReport();
          }
        }
        GMTrace.o(4513071104000L, 33625);
      }
    };
    this.hOn = new RecoveryLog.RecoveryLogImpl()
    {
      public final void If()
      {
        GMTrace.i(18825512747008L, 140261);
        GMTrace.o(18825512747008L, 140261);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(17959539965952L, 133809);
        v.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(17959539965952L, 133809);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(17960076836864L, 133813);
        v.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(17960076836864L, 133813);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(17959808401408L, 133811);
        v.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(17959808401408L, 133811);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(17960211054592L, 133814);
        v.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(17960211054592L, 133814);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(17959674183680L, 133810);
        v.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(17959674183680L, 133810);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(17959942619136L, 133812);
        v.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(17959942619136L, 133812);
      }
    };
    GMTrace.o(4514413281280L, 33635);
  }
  
  public void configure(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(4514681716736L, 33637);
    RecoveryLog.a(this.hOn);
    long l;
    if (parame.ej(":sandbox"))
    {
      l = System.currentTimeMillis();
      parame = new IntentFilter();
      parame.addAction("com.tecent.recovery.intent.action.LOG");
      parame.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
      aa.getContext().registerReceiver(this.tF, parame);
      parame = new File(WXConstantsRecovery.wOA);
      if (!parame.exists()) {
        parame.mkdir();
      }
      parame = new File(parame, "version.info");
      if (parame.exists()) {
        parame.delete();
      }
    }
    try
    {
      FileOp.k(parame.getAbsolutePath(), Integer.toHexString(com.tencent.mm.protocal.d.sXh).getBytes());
      v.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(4514681716736L, 33637);
      return;
    }
    catch (Exception parame)
    {
      for (;;) {}
    }
  }
  
  public void dependency()
  {
    GMTrace.i(4514547499008L, 33636);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    GMTrace.o(4514547499008L, 33636);
  }
  
  public void execute(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(4514815934464L, 33638);
    GMTrace.o(4514815934464L, 33638);
  }
  
  public void installed()
  {
    GMTrace.i(14521284427776L, 108192);
    GMTrace.o(14521284427776L, 108192);
  }
  
  public void onAccountInitialized(e.f paramf)
  {
    GMTrace.i(4514950152192L, 33639);
    this.hOm.bIo();
    GMTrace.o(4514950152192L, 33639);
  }
  
  public void onAccountRelease()
  {
    GMTrace.i(4515084369920L, 33640);
    this.hOm.dead();
    GMTrace.o(4515084369920L, 33640);
  }
  
  public void postLog()
  {
    GMTrace.i(17958868877312L, 133804);
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17958734659584L, 133803);
        v.i("MicroMsg.Recovery.PluginRecovery", "postLog");
        a.Ig();
        GMTrace.o(17958734659584L, 133803);
      }
    }, "RecoveryWriteLogThread");
    GMTrace.o(17958868877312L, 133804);
  }
  
  public void postReport()
  {
    GMTrace.i(17959003095040L, 133805);
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17958600441856L, 133802);
        v.i("MicroMsg.Recovery.PluginRecovery", "postReport");
        b.Ih();
        GMTrace.o(17958600441856L, 133802);
      }
    }, "RecoveryReportStatusThread");
    GMTrace.o(17959003095040L, 133805);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelrecovery/PluginRecovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */