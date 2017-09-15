package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.ek;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.h;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

public final class b
{
  public static p irp;
  public static boolean jUD;
  
  static
  {
    GMTrace.i(1963605360640L, 14630);
    jUD = false;
    irp = null;
    GMTrace.o(1963605360640L, 14630);
  }
  
  public static void a(BizInfo paramBizInfo, Activity paramActivity, x paramx, int paramInt)
  {
    GMTrace.i(1962531618816L, 14622);
    a(paramBizInfo, paramActivity, paramx, false, null, paramInt);
    GMTrace.o(1962531618816L, 14622);
  }
  
  public static void a(BizInfo paramBizInfo, Activity paramActivity, x paramx, boolean paramBoolean)
  {
    GMTrace.i(1962800054272L, 14624);
    a(paramBizInfo, paramActivity, paramx, false, 0);
    GMTrace.o(1962800054272L, 14624);
  }
  
  public static void a(BizInfo paramBizInfo, Activity paramActivity, x paramx, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    GMTrace.i(1962934272000L, 14625);
    if ((paramBizInfo == null) || (paramActivity == null) || (paramx == null))
    {
      boolean bool1;
      if (paramBizInfo == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label90;
        }
        bool1 = true;
        label37:
        if (paramx != null) {
          break label96;
        }
      }
      for (;;)
      {
        v.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        GMTrace.o(1962934272000L, 14625);
        return;
        paramBoolean = false;
        break;
        label90:
        bool1 = false;
        break label37;
        label96:
        bool2 = false;
      }
    }
    String str = paramx.field_username;
    paramx.td();
    ap.yY();
    com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.c(str, paramInt));
    if (o.eS(str))
    {
      ap.yY();
      com.tencent.mm.u.c.wR().Rh(str);
      ap.yY();
      com.tencent.mm.u.c.xa().gb(str);
    }
    label440:
    for (;;)
    {
      if (com.tencent.mm.app.plugin.a.a.a(paramBizInfo))
      {
        paramBizInfo = new ek();
        paramBizInfo.fId.fGj = str;
        com.tencent.mm.sdk.b.a.uql.m(paramBizInfo);
      }
      paramBizInfo = w.DG();
      if (!bf.mA(str)) {
        v.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[] { str, Integer.valueOf(paramBizInfo.gUp.delete("BizKF", "brandUsername = ?", new String[] { str })) });
      }
      if (paramBoolean)
      {
        if (paramActivity.getIntent().getIntExtra("Kdel_from", -1) == 0)
        {
          paramBizInfo = new Intent(paramActivity, LauncherUI.class);
          paramBizInfo.addFlags(67108864);
          paramActivity.startActivity(paramBizInfo);
        }
        paramActivity.finish();
      }
      GMTrace.o(1962934272000L, 14625);
      return;
      jUD = false;
      paramActivity.getString(R.l.dIG);
      irp = g.a(paramActivity, paramActivity.getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(1959176175616L, 14597);
          b.jUD = true;
          GMTrace.o(1959176175616L, 14597);
        }
      });
      ay.a local3 = new ay.a()
      {
        public final void zr()
        {
          GMTrace.i(1909918269440L, 14230);
          w.DH().hP(this.wiN);
          if (b.irp != null)
          {
            b.irp.dismiss();
            b.irp = null;
          }
          GMTrace.o(1909918269440L, 14230);
        }
        
        public final boolean zs()
        {
          GMTrace.i(1909784051712L, 14229);
          boolean bool = b.jUD;
          GMTrace.o(1909784051712L, 14229);
          return bool;
        }
      };
      ap.yY();
      com.tencent.mm.u.c.wR().a(str, paramx);
      if (paramBizInfo.CH()) {
        com.tencent.mm.modelbiz.e.jdMethod_if(paramBizInfo.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label440;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        ay.a(str, local3);
        ap.yY();
        com.tencent.mm.u.c.wW().Rk(str);
      }
    }
  }
  
  public static void a(BizInfo paramBizInfo, final Activity paramActivity, final x paramx, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    GMTrace.i(1962665836544L, 14623);
    if ((paramBizInfo == null) || (paramActivity == null) || (paramx == null))
    {
      boolean bool1;
      if (paramBizInfo == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label91;
        }
        bool1 = true;
        label34:
        if (paramx != null) {
          break label97;
        }
      }
      label91:
      label97:
      for (boolean bool2 = true;; bool2 = false)
      {
        v.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        GMTrace.o(1962665836544L, 14623);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label34;
      }
    }
    if (paramBizInfo.CI()) {}
    for (String str = paramActivity.getString(R.l.dPB);; str = paramActivity.getString(R.l.dPC, new Object[] { paramx.tL() }))
    {
      g.b(paramActivity, str, "", paramActivity.getString(R.l.dZj), paramActivity.getString(R.l.dGk), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1939177734144L, 14448);
          b.a(this.wiJ, paramActivity, paramx, paramBoolean, paramInt);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          GMTrace.o(1939177734144L, 14448);
        }
      }, null);
      GMTrace.o(1962665836544L, 14623);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */