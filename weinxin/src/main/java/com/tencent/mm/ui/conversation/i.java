package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.e.a.li;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;

public final class i
  implements com.tencent.mm.y.e, f
{
  private static boolean wbV;
  public Activity fOZ;
  public ProgressDialog isb;
  PowerManager.WakeLock wakeLock;
  public com.tencent.mm.ui.base.h wbP;
  public volatile boolean wbQ;
  public boolean wbR;
  public g.a wbS;
  boolean wbT;
  public com.tencent.mm.modelmulti.g wbU;
  a wbW;
  a wbX;
  com.tencent.mm.sdk.b.c wbY;
  com.tencent.mm.sdk.b.c wbZ;
  FLock wca;
  
  static
  {
    GMTrace.i(14488401084416L, 107947);
    wbV = false;
    GMTrace.o(14488401084416L, 107947);
  }
  
  public i()
  {
    GMTrace.i(14485716729856L, 107927);
    this.wbP = null;
    this.wbR = false;
    this.wbS = new g.a();
    this.wakeLock = null;
    this.wbT = false;
    this.wbU = null;
    this.isb = null;
    this.wbY = new com.tencent.mm.sdk.b.c() {};
    this.wbZ = new com.tencent.mm.sdk.b.c()
    {
      private boolean bYz()
      {
        GMTrace.i(16020764884992L, 119364);
        if (i.this.fOZ == null)
        {
          v.i("MicroMsg.InitHelper", "inithelper hasn't initialized");
          GMTrace.o(16020764884992L, 119364);
          return false;
        }
        i.this.wbR = false;
        i.this.bYw();
        GMTrace.o(16020764884992L, 119364);
        return false;
      }
    };
    GMTrace.o(14485716729856L, 107927);
  }
  
  private boolean X(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(14486387818496L, 107932);
    ap.yY();
    long l1 = u.d((Long)com.tencent.mm.u.c.vr().get(w.a.uxx, null));
    ap.yY();
    long l2 = u.d((Long)com.tencent.mm.u.c.vr().get(w.a.uxz, null));
    ap.yY();
    long l3 = u.d((Long)com.tencent.mm.u.c.vr().get(w.a.uxy, null));
    ap.yY();
    com.tencent.mm.u.c.vr().a(w.a.uxx, Long.valueOf(0L));
    ap.yY();
    com.tencent.mm.u.c.vr().a(w.a.uxy, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.sXh) && (u.az(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (p.b(this.fOZ, 4, -17))
        {
          GMTrace.o(14486387818496L, 107932);
          return true;
        }
      }
      else if ((l1 == 2L) && (p.b(this.fOZ, 4, -16)))
      {
        GMTrace.o(14486387818496L, 107932);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      v.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (com.tencent.mm.platformtools.r.iip) {
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", u.Nz() - 86400L - 1L).commit();
      }
      if (p.b(this.fOZ, paramInt1, paramInt2))
      {
        GMTrace.o(14486387818496L, 107932);
        return true;
      }
    }
    GMTrace.o(14486387818496L, 107932);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, k paramk)
  {
    GMTrace.i(14486119383040L, 107930);
    if ((paramk == null) || (paramk.getType() != 139))
    {
      GMTrace.o(14486119383040L, 107930);
      return;
    }
    if (paramInt2 != 0) {}
    for (long l = paramInt1 * 100L / paramInt2;; l = 0L)
    {
      com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14492830269440L, 107980);
          if ((!i.this.wbQ) && (i.this.isb != null)) {
            i.this.isb.setMessage(i.this.fOZ.getString(R.l.dHs) + this.irs + "%");
          }
          GMTrace.o(14492830269440L, 107980);
        }
      });
      GMTrace.o(14486119383040L, 107930);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(14486253600768L, 107931);
    if ((paramk.getType() != 138) && (paramk.getType() != 139))
    {
      if (paramk.getType() != 113)
      {
        X(paramInt1, paramInt2, paramk.getType());
        GMTrace.o(14486253600768L, 107931);
        return;
      }
      v.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      GMTrace.o(14486253600768L, 107931);
      return;
    }
    int j = paramk.getType();
    int k = hashCode();
    if (this.wbU == null) {}
    for (int i = -2;; i = this.wbU.hashCode())
    {
      v.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.wbU != null) && (paramk.getType() == 139))
      {
        this.wbU = null;
        v.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.wbS.se()) });
        ag.a.hlA.a(null, null, null);
        if (com.tencent.mm.plugin.sns.b.m.pOZ != null) {
          com.tencent.mm.plugin.sns.b.m.pOZ.bdo();
        }
        this.wbX.bYB();
        if (this.wakeLock.isHeld())
        {
          v.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        ap.vL().bJa();
        if (this.isb != null)
        {
          this.isb.dismiss();
          this.isb = null;
        }
      }
      if (!p.a(this.fOZ, paramInt1, paramInt2, new Intent().setClass(this.fOZ, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        break;
      }
      v.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
      GMTrace.o(14486253600768L, 107931);
      return;
    }
    if (!ap.zb())
    {
      v.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
      GMTrace.o(14486253600768L, 107931);
      return;
    }
    Object localObject;
    if (!this.wbT)
    {
      this.wbT = true;
      ap.yY();
      localObject = (String)com.tencent.mm.u.c.vr().get(5, null);
      ap.yY();
      if (((Integer)com.tencent.mm.u.c.vr().get(57, Integer.valueOf(0))).intValue() == 0) {
        break label598;
      }
    }
    label598:
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (localObject != null)) {
        com.tencent.mm.ui.base.g.b(this.fOZ, this.fOZ.getString(R.l.eJv, new Object[] { localObject }), this.fOZ.getString(R.l.dIG), this.fOZ.getString(R.l.eJx), this.fOZ.getString(R.l.eJw), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(14479005843456L, 107877);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setClassName(i.this.fOZ, "com.tencent.mm.ui.account.RegByFacebookSetPwdUI");
            i.this.fOZ.startActivity(paramAnonymousDialogInterface);
            GMTrace.o(14479005843456L, 107877);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(14491756527616L, 107972);
            paramAnonymousDialogInterface.dismiss();
            GMTrace.o(14491756527616L, 107972);
          }
        });
      }
      if ((paramInt1 == 4) && (paramInt2 == -17) && (!wbV))
      {
        q.Hz().gg(7);
        wbV = true;
      }
      if (!X(paramInt1, paramInt2, paramk.getType())) {
        break;
      }
      v.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
      GMTrace.o(14486253600768L, 107931);
      return;
    }
    if (paramk.getType() == 139)
    {
      localObject = new hz();
      if ((paramInt1 != 3) || (paramInt2 != -1)) {
        break label688;
      }
      this.wbR = true;
      ((hz)localObject).fNu.fMl = false;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      this.wbW.bYi();
    }
    while (p.a.a(this.fOZ, paramInt1, paramInt2, paramString, 4))
    {
      GMTrace.o(14486253600768L, 107931);
      return;
      label688:
      ((hz)localObject).fNu.fMl = true;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    if (paramk.getType() == 139)
    {
      new ad().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14475381964800L, 107850);
          q.Hz().gg(5);
          GMTrace.o(14475381964800L, 107850);
        }
      });
      if ((com.tencent.mm.u.m.xR() & 0x80) != 0)
      {
        ap.yY();
        if (com.tencent.mm.u.c.wW().Rl("masssendapp") == null)
        {
          paramString = new com.tencent.mm.storage.ae();
          paramString.setUsername("masssendapp");
          paramString.setContent(aa.getContext().getResources().getString(R.l.dYB));
          paramString.s(u.NA() + 2000L);
          paramString.dw(0);
          paramString.dt(0);
          ap.yY();
          com.tencent.mm.u.c.wW().d(paramString);
          paramInt1 = com.tencent.mm.u.m.xR();
          ap.yY();
          com.tencent.mm.u.c.vr().set(40, Integer.valueOf(paramInt1 & 0xFF7F));
        }
      }
    }
    if ((paramk.getType() == 138) || (paramk.getType() == 139))
    {
      com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14493098704896L, 107982);
          gc localgc = new gc();
          localgc.fLj.data = "MAIN_UI_EVENT_INIT_FINALLY";
          com.tencent.mm.sdk.b.a.uql.m(localgc);
          GMTrace.o(14493098704896L, 107982);
        }
      });
      this.wbW.bYi();
    }
    GMTrace.o(14486253600768L, 107931);
  }
  
  final boolean bYv()
  {
    GMTrace.i(14485850947584L, 107928);
    if (!com.tencent.mm.modelmulti.m.Hw())
    {
      GMTrace.o(14485850947584L, 107928);
      return false;
    }
    if ((this.wbP != null) && (this.wbP.isShowing()))
    {
      GMTrace.o(14485850947584L, 107928);
      return false;
    }
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.h.vI();
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    int i;
    boolean bool;
    if ((bf.mz((String)locale.gXY.get(8195, null)).length() <= 0) || (bf.f((Integer)locale.gXY.get(15, null)) == 0))
    {
      i = 1;
      if ((i == 0) || (locale.vn() == null)) {
        break label263;
      }
      bool = true;
      label129:
      this.wbQ = bool;
      if (!this.wbQ) {
        break label268;
      }
      this.wbP = new h.a(this.fOZ).zR(R.l.ebc).SW(this.fOZ.getString(R.l.ebb)).kH(false).zU(R.l.ebd).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(14513768235008L, 108136);
          i.this.wbP.dismiss();
          i.this.bYw();
          GMTrace.o(14513768235008L, 108136);
        }
      }).zV(R.l.eba).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(14485582512128L, 107926);
          i.this.wbP.dismiss();
          i.this.wbQ = false;
          i.this.bYw();
          GMTrace.o(14485582512128L, 107926);
        }
      }).WD();
      this.wbP.show();
      com.tencent.mm.kernel.h.vJ();
      new File(com.tencent.mm.kernel.h.vI().cachePath, "EnMicroMsg.db.corrupt").delete();
    }
    for (;;)
    {
      GMTrace.o(14485850947584L, 107928);
      return true;
      i = 0;
      break;
      label263:
      bool = false;
      break label129;
      label268:
      bYw();
    }
  }
  
  public final void bYw()
  {
    GMTrace.i(14485985165312L, 107929);
    if (this.wbR)
    {
      v.i("MicroMsg.InitHelper", "summerinit doInit but hasTryDoInitButFailed true ret");
      GMTrace.o(14485985165312L, 107929);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      v.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.wbX.bYA();
    if (this.wbQ) {
      ((com.tencent.mm.plugin.dbbackup.d)ap.yR().gs("plugin.dbbackup")).b(new com.tencent.mm.plugin.dbbackup.b()
      {
        public final void kV(final int paramAnonymousInt)
        {
          GMTrace.i(14492293398528L, 107976);
          com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(14475650400256L, 107852);
              if (paramAnonymousInt == -2)
              {
                Toast.makeText(i.this.fOZ, R.l.eIL, 1).show();
                GMTrace.o(14475650400256L, 107852);
                return;
              }
              if (paramAnonymousInt == 0)
              {
                Toast.makeText(i.this.fOZ, R.l.eIM, 0).show();
                GMTrace.o(14475650400256L, 107852);
                return;
              }
              Toast.makeText(i.this.fOZ, R.l.eII, 1).show();
              GMTrace.o(14475650400256L, 107852);
            }
          });
          i.this.wbQ = false;
          if (i.this.wbU == null)
          {
            if (com.tencent.mm.plugin.sns.b.m.pOZ != null) {
              com.tencent.mm.plugin.sns.b.m.pOZ.bdn();
            }
            i.this.wbU = new com.tencent.mm.modelmulti.g(i.this);
            v.d("MicroMsg.InitHelper", "dkinit doInit t:%d initScene:%d", new Object[] { Long.valueOf(i.this.wbS.se()), Integer.valueOf(i.this.wbU.hashCode()) });
            i.this.wbS.gSE = SystemClock.elapsedRealtime();
            ap.vd().a(i.this.wbU, 0);
          }
          GMTrace.o(14492293398528L, 107976);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14489474826240L, 107955);
          long l = i.this.wbS.se();
          int i;
          i locali;
          Activity localActivity;
          if (i.this.wbU == null)
          {
            i = -2;
            v.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
            if ((i.this.isb != null) && (i.this.isb.isShowing())) {
              i.this.isb.dismiss();
            }
            if (!i.this.wbQ) {
              break label183;
            }
            locali = i.this;
            localActivity = i.this.fOZ;
            i.this.fOZ.getString(R.l.dIG);
          }
          for (locali.isb = com.tencent.mm.ui.base.g.a(localActivity, i.this.fOZ.getString(R.l.eIJ), false, null);; locali.isb = com.tencent.mm.ui.base.g.a(localActivity, i.this.fOZ.getString(R.l.dHs), false, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(14493367140352L, 107984);
                  ap.vd().c(i.this.wbU);
                  if (com.tencent.mm.plugin.sns.b.m.pOZ != null) {
                    com.tencent.mm.plugin.sns.b.m.pOZ.bdo();
                  }
                  GMTrace.o(14493367140352L, 107984);
                }
              }))
          {
            ap.vL().bIY();
            GMTrace.o(14489474826240L, 107955);
            return;
            i = i.this.wbU.hashCode();
            break;
            label183:
            locali = i.this;
            localActivity = i.this.fOZ;
            i.this.fOZ.getString(R.l.dIG);
          }
        }
      });
      GMTrace.o(14485985165312L, 107929);
      return;
      if (this.wbU == null)
      {
        if (com.tencent.mm.plugin.sns.b.m.pOZ != null) {
          com.tencent.mm.plugin.sns.b.m.pOZ.bdn();
        }
        this.wbU = new com.tencent.mm.modelmulti.g(this);
        v.d("MicroMsg.InitHelper", "dkinit doInit t:%d initScene:%d", new Object[] { Long.valueOf(this.wbS.se()), Integer.valueOf(this.wbU.hashCode()) });
        this.wbS.gSE = SystemClock.elapsedRealtime();
        ap.vd().a(this.wbU, 0);
      }
    }
  }
  
  final int bYx()
  {
    GMTrace.i(14486522036224L, 107933);
    if (this.wbU == null)
    {
      GMTrace.o(14486522036224L, 107933);
      return -2;
    }
    int i = this.wbU.hashCode();
    GMTrace.o(14486522036224L, 107933);
    return i;
  }
  
  public final boolean bYy()
  {
    GMTrace.i(14486656253952L, 107934);
    if (this.wbU != null)
    {
      GMTrace.o(14486656253952L, 107934);
      return true;
    }
    GMTrace.o(14486656253952L, 107934);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void bYA();
    
    public abstract void bYB();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */