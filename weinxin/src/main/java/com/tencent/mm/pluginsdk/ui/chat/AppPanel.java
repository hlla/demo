package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static int paL;
  private static int paM;
  private static boolean sMG;
  Context context;
  private SharedPreferences hgn;
  private boolean isInit;
  private boolean paW;
  private int paX;
  private int paY;
  public MMFlipper paZ;
  private MMDotView pba;
  boolean sMA;
  boolean sMB;
  private Map<String, f> sMC;
  private boolean sMD;
  private final int sME;
  private AppGrid.b sMF;
  boolean sMH;
  private int sMI;
  private int sMb;
  private List<f> sMe;
  private final boolean[] sMm;
  a sMn;
  b sMo;
  private List<AppGrid> sMp;
  private int sMq;
  public a sMr;
  private int sMs;
  private int sMt;
  int sMu;
  private boolean sMv;
  private boolean sMw;
  private boolean sMx;
  private boolean sMy;
  boolean sMz;
  
  static
  {
    GMTrace.i(976970842112L, 7279);
    paL = 215;
    paM = 158;
    sMG = false;
    GMTrace.o(976970842112L, 7279);
  }
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(972139003904L, 7243);
    this.sMm = new boolean[16];
    this.paW = false;
    this.sMb = 16;
    this.sMq = this.sMb;
    this.isInit = false;
    this.sMs = 0;
    this.sMt = 0;
    this.sMu = 0;
    this.sMv = false;
    this.sMw = false;
    this.sMx = false;
    this.sMy = false;
    this.sMz = false;
    this.sMA = false;
    this.sMB = false;
    this.sMC = null;
    this.sMD = true;
    this.sMe = new LinkedList();
    this.sME = 2;
    this.sMF = new AppGrid.b()
    {
      public final void a(int paramAnonymousInt, f paramAnonymousf)
      {
        int i = 0;
        GMTrace.i(1018846773248L, 7591);
        boolean bool1;
        Object localObject;
        if (paramAnonymousf != null)
        {
          bool1 = true;
          v.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousf != null) && (com.tencent.mm.pluginsdk.model.app.g.j(paramAnonymousf)))
          {
            localObject = paramAnonymousf.field_appId;
            HashMap localHashMap = new HashMap();
            m.b(327682, localHashMap);
            localHashMap.put(localObject, "1");
            m.a(327682, localHashMap);
          }
          switch (paramAnonymousInt)
          {
          }
        }
        for (;;)
        {
          GMTrace.o(1018846773248L, 7591);
          return;
          bool1 = false;
          break;
          if (AppPanel.j(AppPanel.this) == null)
          {
            v.e("MicroMsg.AppPanel", "infoList == null");
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          com.tencent.mm.plugin.report.service.g.oSF.A(10305, String.valueOf(AppPanel.j(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(10) });
          h.vI().vr().set(69121, "");
          AppPanel.k(AppPanel.this).aJB();
          GMTrace.o(1018846773248L, 7591);
          return;
          localObject = paramAnonymousf;
          if (paramAnonymousf == null) {
            localObject = (f)AppPanel.l(AppPanel.this).get(f.sBx);
          }
          ap.yY();
          paramAnonymousInt = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uCm, Integer.valueOf(0))).intValue();
          ap.yY();
          paramAnonymousf = bf.f(((String)com.tencent.mm.u.c.vr().get(w.a.uEc, "")).split(";"));
          if (!paramAnonymousf.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousf.add(String.valueOf(paramAnonymousInt));
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.uEc, bf.c(paramAnonymousf, ";"));
            AppPanel.this.refresh();
          }
          ap.yY();
          com.tencent.mm.u.c.vr().set(80, Boolean.valueOf(false));
          AppPanel.k(AppPanel.this).b((f)localObject);
          GMTrace.o(1018846773248L, 7591);
          return;
          if (!AppPanel.this.sMr.sMU.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          if (paramAnonymousf == null)
          {
            v.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          if ((paramAnonymousf.bCN()) || (paramAnonymousf.bCP()))
          {
            if (AppPanel.m(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.i(AppPanel.this).getSharedPreferences(aa.bIN(), 0));
            }
            if (AppPanel.m(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousf.field_appId, true)) {
              AppPanel.m(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousf.field_appId, false).commit();
            }
            if (paramAnonymousf.bCP()) {
              com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(16), paramAnonymousf.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(13), paramAnonymousf.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.k(AppPanel.this).b(paramAnonymousf);
            GMTrace.o(1018846773248L, 7591);
            return;
            com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(11), paramAnonymousf.field_appId });
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousf = AppPanel.k(AppPanel.this);
          if (AppPanel.this.sMr.sNd.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousf.pe(paramAnonymousInt);
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          if (!AppPanel.this.sMr.sMO.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.k(AppPanel.this).aJA();
          GMTrace.o(1018846773248L, 7591);
          return;
          if (!AppPanel.this.sMr.sNe.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          if (paramAnonymousf == null)
          {
            localObject = (f)AppPanel.l(AppPanel.this).get(f.sBz);
            paramAnonymousf = (f)localObject;
            if (localObject == null)
            {
              GMTrace.o(1018846773248L, 7591);
              return;
            }
          }
          if ((paramAnonymousf.bCN()) || (paramAnonymousf.bCP()))
          {
            if (AppPanel.m(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.i(AppPanel.this).getSharedPreferences(aa.bIN(), 0));
            }
            if (AppPanel.m(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousf.field_appId, true)) {
              AppPanel.m(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousf.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(13), paramAnonymousf.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            ap.yY();
            paramAnonymousInt = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uCm, Integer.valueOf(0))).intValue();
            ap.yY();
            paramAnonymousf = bf.f(((String)com.tencent.mm.u.c.vr().get(w.a.uEd, "")).split(";"));
            if (!paramAnonymousf.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousf.add(String.valueOf(paramAnonymousInt));
              ap.yY();
              com.tencent.mm.u.c.vr().a(w.a.uEd, bf.c(paramAnonymousf, ";"));
              AppPanel.this.refresh();
            }
            AppPanel.k(AppPanel.this).aJF();
            GMTrace.o(1018846773248L, 7591);
            return;
            com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(11), paramAnonymousf.field_appId });
          }
          if ((!AppPanel.this.sMr.sNa.value) || (!AppPanel.this.sMr.sNb.value))
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          ap.yY();
          if (((Boolean)com.tencent.mm.u.c.vr().get(290817, Boolean.valueOf(true))).booleanValue())
          {
            ap.yY();
            com.tencent.mm.u.c.vr().set(290817, Boolean.valueOf(false));
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.k(AppPanel.this).aJz();
          GMTrace.o(1018846773248L, 7591);
          return;
          if (!AppPanel.this.sMr.sMS.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          ap.yY();
          if (((Boolean)com.tencent.mm.u.c.vr().get(327744, Boolean.valueOf(true))).booleanValue())
          {
            ap.yY();
            com.tencent.mm.u.c.vr().set(327744, Boolean.valueOf(false));
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.k(AppPanel.this).aJD();
          GMTrace.o(1018846773248L, 7591);
          return;
          if (!AppPanel.this.sMr.sMN.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          GMTrace.o(1018846773248L, 7591);
          return;
          if (!AppPanel.this.sMr.sMQ.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018846773248L, 7591);
            return;
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(8) });
          ap.yY();
          com.tencent.mm.u.c.vr().set(54, Boolean.valueOf(false));
          if (AppPanel.k(AppPanel.this) != null)
          {
            paramAnonymousf = new qk();
            paramAnonymousf.fXk.fXm = true;
            com.tencent.mm.sdk.b.a.uql.m(paramAnonymousf);
            paramAnonymousf = paramAnonymousf.fXl.fXo;
            if (!bf.mA(paramAnonymousf))
            {
              v.v("MicroMsg.AppPanel", "Talkroom is on: " + paramAnonymousf);
              com.tencent.mm.ui.base.g.b(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.eXr), "", AppPanel.i(AppPanel.this).getString(R.l.dHL), AppPanel.i(AppPanel.this).getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(979789414400L, 7300);
                  qk localqk = new qk();
                  localqk.fXk.fXn = true;
                  com.tencent.mm.sdk.b.a.uql.m(localqk);
                  AppPanel.k(AppPanel.this).aJw();
                  paramAnonymous2DialogInterface.dismiss();
                  GMTrace.o(979789414400L, 7300);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(997774589952L, 7434);
                  paramAnonymous2DialogInterface.dismiss();
                  GMTrace.o(997774589952L, 7434);
                }
              });
              GMTrace.o(1018846773248L, 7591);
              return;
            }
            AppPanel.k(AppPanel.this).aJw();
            GMTrace.o(1018846773248L, 7591);
            return;
            if (!AppPanel.this.sMr.sMW.value)
            {
              Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
              GMTrace.o(1018846773248L, 7591);
              return;
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(7) });
            ap.yY();
            com.tencent.mm.u.c.vr().set(62, Boolean.valueOf(false));
            paramAnonymousf = new qk();
            paramAnonymousf.fXk.fXm = true;
            com.tencent.mm.sdk.b.a.uql.m(paramAnonymousf);
            paramAnonymousf = paramAnonymousf.fXl.fXo;
            if (!bf.mA(paramAnonymousf))
            {
              v.v("MicroMsg.AppPanel", "Talkroom is on: " + paramAnonymousf);
              com.tencent.mm.ui.base.g.b(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.eXr), "", AppPanel.i(AppPanel.this).getString(R.l.dHL), AppPanel.i(AppPanel.this).getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(977910366208L, 7286);
                  qk localqk = new qk();
                  localqk.fXk.fXn = true;
                  com.tencent.mm.sdk.b.a.uql.m(localqk);
                  AppPanel.k(AppPanel.this).aJx();
                  paramAnonymous2DialogInterface.dismiss();
                  GMTrace.o(977910366208L, 7286);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(1026899836928L, 7651);
                  paramAnonymous2DialogInterface.dismiss();
                  GMTrace.o(1026899836928L, 7651);
                }
              });
              GMTrace.o(1018846773248L, 7591);
              return;
            }
            AppPanel.k(AppPanel.this).aJx();
            GMTrace.o(1018846773248L, 7591);
            return;
            if (AppPanel.k(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(6) });
              ap.yY();
              com.tencent.mm.u.c.vr().set(67, Boolean.valueOf(false));
              AppPanel.k(AppPanel.this).aJy();
              GMTrace.o(1018846773248L, 7591);
              return;
              com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(9) });
              ap.yY();
              com.tencent.mm.u.c.vr().set(73, Boolean.valueOf(false));
              AppPanel.n(AppPanel.this).bFf();
              GMTrace.o(1018846773248L, 7591);
              return;
              if (!AppPanel.this.sMr.sMP.value)
              {
                Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
                GMTrace.o(1018846773248L, 7591);
                return;
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.k(AppPanel.this) != null)
              {
                AppPanel.k(AppPanel.this).aJC();
                GMTrace.o(1018846773248L, 7591);
                return;
                if (!AppPanel.this.sMr.sNc.value)
                {
                  Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
                  GMTrace.o(1018846773248L, 7591);
                  return;
                }
                if (AppPanel.k(AppPanel.this) != null) {
                  AppPanel.k(AppPanel.this).aJE();
                }
                com.tencent.mm.plugin.report.service.g.oSF.i(10923, new Object[] { Integer.valueOf(15) });
                ap.yY();
                bool1 = ((Boolean)com.tencent.mm.u.c.vr().get(208899, Boolean.valueOf(false))).booleanValue();
                ap.yY();
                boolean bool2 = ((Boolean)com.tencent.mm.u.c.vr().get(208913, Boolean.valueOf(false))).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.g.oSF.i(11594, new Object[] { Integer.valueOf(3) });
                  GMTrace.o(1018846773248L, 7591);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.g.oSF.i(11594, new Object[] { Integer.valueOf(4) });
                  GMTrace.o(1018846773248L, 7591);
                  return;
                  if (AppPanel.k(AppPanel.this) != null)
                  {
                    AppPanel.k(AppPanel.this).aJG();
                    GMTrace.o(1018846773248L, 7591);
                    return;
                    if (!AppPanel.this.sMr.sNg.value)
                    {
                      Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
                      GMTrace.o(1018846773248L, 7591);
                      return;
                    }
                    AppPanel.k(AppPanel.this).aJH();
                    GMTrace.o(1018846773248L, 7591);
                    return;
                    if (AppPanel.k(AppPanel.this) != null)
                    {
                      if (paramAnonymousf == null)
                      {
                        localObject = (f)AppPanel.l(AppPanel.this).get(f.sBA);
                        paramAnonymousf = (f)localObject;
                        if (localObject == null)
                        {
                          v.i("MicroMsg.AppPanel", "empty info");
                          GMTrace.o(1018846773248L, 7591);
                          return;
                        }
                      }
                      if ((paramAnonymousf.bCN()) || (paramAnonymousf.bCP()))
                      {
                        if (AppPanel.m(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.i(AppPanel.this).getSharedPreferences(aa.bIN(), 0));
                        }
                        if (AppPanel.m(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousf.field_appId, true)) {
                          AppPanel.m(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousf.field_appId, false).commit();
                        }
                      }
                      AppPanel.k(AppPanel.this).aJI();
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      public final int xs(int paramAnonymousInt)
      {
        int i = 0;
        GMTrace.i(1018578337792L, 7589);
        if (paramAnonymousInt < AppPanel.f(AppPanel.this))
        {
          int m = AppPanel.g(AppPanel.this).length;
          int k;
          for (int j = 0; i < m; j = k)
          {
            k = j;
            if (AppPanel.g(AppPanel.this)[i] != 0)
            {
              if (j == paramAnonymousInt)
              {
                GMTrace.o(1018578337792L, 7589);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.h(AppPanel.this)))
        {
          GMTrace.o(1018578337792L, 7589);
          return Integer.MIN_VALUE;
        }
        GMTrace.o(1018578337792L, 7589);
        return Integer.MAX_VALUE;
      }
      
      public final void xt(int paramAnonymousInt)
      {
        GMTrace.i(1018712555520L, 7590);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.sMr.sMN.value)
          {
            Toast.makeText(AppPanel.i(AppPanel.this), AppPanel.i(AppPanel.this).getString(R.l.dUD), 0).show();
            GMTrace.o(1018712555520L, 7590);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          GMTrace.o(1018712555520L, 7590);
          return;
        }
        GMTrace.o(1018712555520L, 7590);
      }
    };
    this.sMH = true;
    this.sMI = -1;
    this.context = paramContext;
    GMTrace.o(972139003904L, 7243);
  }
  
  private int bEZ()
  {
    GMTrace.i(973078528000L, 7250);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (int i = 1;; i = 2)
    {
      GMTrace.o(973078528000L, 7250);
      return i;
    }
  }
  
  private void bFa()
  {
    GMTrace.i(973212745728L, 7251);
    v.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.paZ.removeAllViews();
    this.paZ.vhs = new MMFlipper.a()
    {
      public final void cN(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(977641930752L, 7284);
        v.d("MicroMsg.AppPanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + AppPanel.a(AppPanel.this));
        if ((AppPanel.a(AppPanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            v.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
          }
          GMTrace.o(977641930752L, 7284);
          return;
        }
        if (AppPanel.b(AppPanel.this) == 2) {
          v.d("MicroMsg.AppPanel", "landspace");
        }
        for (;;)
        {
          AppPanel.c(AppPanel.this);
          AppPanel.a(AppPanel.this, paramAnonymousInt2);
          AppPanel.b(AppPanel.this, paramAnonymousInt1);
          AppPanel.d(AppPanel.this);
          GMTrace.o(977641930752L, 7284);
          return;
          v.d("MicroMsg.AppPanel", "portrait");
        }
      }
    };
    this.paZ.vhr = new MMFlipper.b()
    {
      public final void sd(int paramAnonymousInt)
      {
        GMTrace.i(997506154496L, 7432);
        AppPanel.e(AppPanel.this).zZ(paramAnonymousInt);
        GMTrace.o(997506154496L, 7432);
      }
    };
    bFc();
    GMTrace.o(973212745728L, 7251);
  }
  
  private void bFb()
  {
    GMTrace.i(973481181184L, 7253);
    if ((this.paX == 0) || (this.paY == 0))
    {
      GMTrace.o(973481181184L, 7253);
      return;
    }
    this.sMp = new ArrayList();
    this.paZ.removeAllViews();
    int i = BackwardSupportUtil.b.a(this.context, 82.0F);
    int m = BackwardSupportUtil.b.a(this.context, 90.0F);
    requestLayout();
    bEY();
    int j = 4;
    if (!this.sMD) {
      j = this.paX / i;
    }
    int k = this.paY / m;
    i = k;
    if (k > 2) {
      i = 2;
    }
    m = (this.paY - m * i) / (i + 1);
    v.d("MicroMsg.AppPanel", "jacks spacing2 = %d", new Object[] { Integer.valueOf(m) });
    v.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", new Object[] { Integer.valueOf(this.paX), Integer.valueOf(this.paY) });
    if (j == 0) {
      j = 1;
    }
    for (;;)
    {
      k = i;
      if (i == 0) {
        k = 1;
      }
      k = j * k;
      if (this.sMr.sMU.value) {}
      Object localObject;
      for (this.sMq = (this.sMb + this.sMe.size());; this.sMq = this.sMb)
      {
        int n = (int)Math.ceil(this.sMq / k);
        v.d("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d", new Object[] { Integer.valueOf(this.sMq), Integer.valueOf(k), Integer.valueOf(n) });
        i = 0;
        while (i < n)
        {
          localObject = (AppGrid)inflate(this.context, R.i.cUv, null);
          List localList = this.sMe;
          Map localMap = this.sMC;
          ((AppGrid)localObject).sMc = new AppGrid.a((AppGrid)localObject, ((AppGrid)localObject).context, localList, localMap);
          ((AppGrid)localObject).setBackgroundResource(0);
          ((AppGrid)localObject).setAdapter(((AppGrid)localObject).sMc);
          ((AppGrid)localObject).setOnItemClickListener(((AppGrid)localObject).jZr);
          ((AppGrid)localObject).setOnItemLongClickListener(((AppGrid)localObject).lGQ);
          int i1 = BackwardSupportUtil.b.a(((AppGrid)localObject).context, 16.0F);
          int i2 = BackwardSupportUtil.b.a(((AppGrid)localObject).context, 16.0F);
          ((AppGrid)localObject).setPadding(i1, BackwardSupportUtil.b.a(((AppGrid)localObject).context, 6.0F), i2, 0);
          i1 = this.sMq;
          i2 = this.sMb;
          ((AppGrid)localObject).sMa = i;
          ((AppGrid)localObject).sLX = i1;
          ((AppGrid)localObject).sLY = k;
          ((AppGrid)localObject).sLZ = n;
          ((AppGrid)localObject).sMb = i2;
          ((AppGrid)localObject).setNumColumns(j);
          if (m > 0)
          {
            ((AppGrid)localObject).setPadding(BackwardSupportUtil.b.a(((AppGrid)localObject).context, 16.0F), m, BackwardSupportUtil.b.a(((AppGrid)localObject).context, 16.0F), 0);
            ((AppGrid)localObject).setVerticalSpacing(m / 2);
          }
          this.paZ.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
          this.sMp.add(localObject);
          i += 1;
        }
      }
      if (this.sMp != null)
      {
        localObject = this.sMp.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((AppGrid)((Iterator)localObject).next()).sLW = this.sMF;
        }
      }
      if (this.sMp.size() <= 1)
      {
        this.pba.setVisibility(4);
        GMTrace.o(973481181184L, 7253);
        return;
      }
      this.pba.setVisibility(0);
      this.pba.zY(this.sMp.size());
      i = this.paZ.bRH();
      this.paZ.Ac(i);
      this.pba.zZ(i);
      GMTrace.o(973481181184L, 7253);
      return;
    }
  }
  
  private static boolean bFd()
  {
    GMTrace.i(974286487552L, 7259);
    l.c localc = l.a.szP;
    if (localc != null)
    {
      if ((localc.afD()) && (localc.afG() > 0))
      {
        GMTrace.o(974286487552L, 7259);
        return true;
      }
      GMTrace.o(974286487552L, 7259);
      return false;
    }
    GMTrace.o(974286487552L, 7259);
    return false;
  }
  
  private void bR(List<f> paramList)
  {
    GMTrace.i(972407439360L, 7245);
    boolean bool1 = this.sMv;
    this.sMv = false;
    boolean bool2 = this.sMw;
    boolean bool3 = this.sMx;
    boolean bool4 = this.sMy;
    this.sMw = false;
    this.sMx = false;
    this.sMy = false;
    int i = this.sMu;
    new ArrayList();
    label132:
    Object localObject;
    if (com.tencent.mm.plugin.w.a.a.a.aRo() == null)
    {
      v.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      i = 0;
      v.d("MicroMsg.AppPanel", "serviceCount, %d", new Object[] { Integer.valueOf(i) });
      this.sMC = new HashMap();
      if ((i <= 0) || (paramList == null) || (paramList.size() <= 0)) {
        break label419;
      }
      i = 0;
      if (i >= paramList.size()) {
        break label419;
      }
      localObject = (f)paramList.get(i);
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((f)localObject).field_appId != null)
        {
          j = i;
          if (((f)localObject).bCN()) {
            if ((((f)localObject).field_serviceAppInfoFlag & 0x1) == 0) {
              break label414;
            }
          }
        }
      }
    }
    label414:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        this.sMv = true;
      }
      j = i;
      if (f.sBx.equals(((f)localObject).field_appId))
      {
        this.sMC.put(f.sBx, localObject);
        if (!this.sMA) {
          this.sMw = true;
        }
        paramList.remove(i);
        j = i - 1;
      }
      i = j;
      if (f.sBz.equals(((f)localObject).field_appId))
      {
        this.sMC.put(f.sBz, localObject);
        if (!this.sMz) {
          this.sMx = true;
        }
        paramList.remove(j);
        i = j - 1;
      }
      j = i;
      if (f.sBA.equals(((f)localObject).field_appId))
      {
        this.sMC.put(f.sBA, localObject);
        if (!this.sMB) {
          this.sMy = true;
        }
        paramList.remove(i);
        j = i - 1;
      }
      i = j + 1;
      break label132;
      localObject = com.tencent.mm.plugin.w.a.a.a.aRo().cG(0, i);
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((Cursor)localObject).getCount();
      ((Cursor)localObject).close();
      break;
    }
    label419:
    v.d("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.sMv) });
    if ((bool1 != this.sMv) || (bool2 != this.sMw) || (bool3 != this.sMx) || (bool4 != this.sMy))
    {
      this.sMr.ju(this.sMv);
      this.sMr.jv(this.sMw);
      this.sMr.jw(this.sMx);
      this.sMr.jx(this.sMy);
      bEY();
    }
    GMTrace.o(972407439360L, 7245);
  }
  
  private static void bS(List<f> paramList)
  {
    GMTrace.i(974152269824L, 7258);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      GMTrace.o(974152269824L, 7258);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      if ((localf != null) && (f.sBy.equals(localf.field_appId)))
      {
        paramList.remove(localf);
        GMTrace.o(974152269824L, 7258);
        return;
      }
      i += 1;
    }
    GMTrace.o(974152269824L, 7258);
  }
  
  public final void anG()
  {
    GMTrace.i(973749616640L, 7255);
    this.paW = false;
    this.paZ.Ac(0);
    bFa();
    requestLayout();
    GMTrace.o(973749616640L, 7255);
  }
  
  public final void bEW()
  {
    GMTrace.i(972541657088L, 7246);
    a locala = this.sMr;
    locala.sML.value = true;
    locala.sMM.value = true;
    locala.sMN.value = true;
    locala.sMO.value = true;
    locala.sMP.value = true;
    locala.sMQ.value = true;
    locala.sMR.value = true;
    locala.sNa.value = true;
    locala.sMY.value = true;
    locala.sMS.value = true;
    locala.sMT.value = true;
    locala.sMU.value = true;
    locala.sMV.value = true;
    locala.sMW.value = true;
    locala.sMX.value = true;
    locala.sMZ.value = true;
    locala.sNb.value = true;
    locala.sNc.value = false;
    locala.sNd.value = true;
    locala.sNe.value = true;
    locala.sNg.value = true;
    locala.sNh.value = true;
    locala.sNg.value = false;
    this.sMz = false;
    this.sMA = false;
    this.sMB = false;
    bEX();
    this.sMr.ju(this.sMv);
    this.sMr.jv(this.sMw);
    this.sMr.jw(this.sMx);
    this.sMr.jx(this.sMy);
    bEY();
    GMTrace.o(972541657088L, 7246);
  }
  
  public final void bEX()
  {
    boolean bool2 = true;
    GMTrace.i(972675874816L, 7247);
    com.tencent.mm.i.g.sW();
    if (com.tencent.mm.i.c.sF() == 2)
    {
      bool1 = true;
      this.sMr.sMR.value = true;
      this.sMr.sMX.value = bool1;
      bool1 = d.Jr("location");
      this.sMr.sNb.value = bool1;
      if ((m.xW() & 0x2000000) != 0) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sMr.sMZ.value = bool1;
      GMTrace.o(972675874816L, 7247);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void bEY()
  {
    int j = 1;
    GMTrace.i(972944310272L, 7249);
    int k = this.sMm.length;
    int i = 0;
    while (i < k)
    {
      this.sMm[i] = true;
      i += 1;
    }
    if (!this.sMr.sMN.value) {
      this.sMm[0] = false;
    }
    for (;;)
    {
      if (this.sMr.sNa.value)
      {
        i = j;
        if (this.sMr.sNb.value) {}
      }
      else
      {
        this.sMm[6] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sMr.sMS.value)
      {
        this.sMm[14] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sMr.sMT.value)
      {
        this.sMm[8] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sMr.sMO.value)
      {
        this.sMm[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sMr.sNc.value)
      {
        this.sMm[13] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sMr.sNf.value)
      {
        this.sMm[3] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sMr.sMP.value)
      {
        this.sMm[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sMr.sMV.value)
      {
        this.sMm[5] = false;
        j = i + 1;
      }
      if (this.sMr.sMX.value)
      {
        i = j;
        if (this.sMr.sMW.value) {}
      }
      else
      {
        this.sMm[4] = false;
        i = j + 1;
      }
      if (this.sMr.sMR.value)
      {
        j = i;
        if (this.sMr.sMQ.value) {}
      }
      else
      {
        this.sMm[2] = false;
        j = i + 1;
      }
      if (this.sMr.sMZ.value)
      {
        i = j;
        if (this.sMr.sMY.value) {}
      }
      else
      {
        this.sMm[10] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sMr.sNe.value)
      {
        this.sMm[7] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sMr.sNg.value)
      {
        this.sMm[15] = false;
        i = j + 1;
      }
      this.sMm[9] = false;
      this.sMb = (16 - (i + 1));
      GMTrace.o(972944310272L, 7249);
      return;
      j = 0;
    }
  }
  
  public final void bFc()
  {
    GMTrace.i(974018052096L, 7257);
    View localView;
    Object localObject2;
    int i;
    Object localObject1;
    if (this.sMH)
    {
      if (bEZ() != 2) {
        break label92;
      }
      v.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(R.h.bpE);
      localObject2 = new LinearLayout.LayoutParams(-1, 0);
      i = BackwardSupportUtil.b.a(this.context, paM);
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((LinearLayout.LayoutParams)localObject2).height = i;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.sMH = false;
      GMTrace.o(974018052096L, 7257);
      return;
      label92:
      v.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(paL) });
      localView = findViewById(R.h.bpE);
      localObject1 = new LinearLayout.LayoutParams(-1, 0);
      Object localObject3;
      if (this.sMI > 0)
      {
        i = this.sMI;
        localObject3 = localObject1;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        i = BackwardSupportUtil.b.a(this.context, paL);
        localObject3 = localObject1;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  public final void init(int paramInt)
  {
    GMTrace.i(972273221632L, 7244);
    this.sMr = new a();
    this.sMu = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.sMs = ((Display)localObject).getWidth();
      this.sMt = ((Display)localObject).getHeight();
      View.inflate(this.context, R.i.cUz, this);
      this.pba = ((MMDotView)findViewById(R.h.bpF));
      this.paZ = ((MMFlipper)findViewById(R.h.bpG));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.i.g.sV().getValue("ShowAPPSuggestion");
        if ((!bf.mA((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.sMe = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sMu);
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.sMe = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sMu);
        continue;
      }
      if (!bFd()) {
        bS(this.sMe);
      }
      bR(this.sMe);
      bFa();
      bEW();
      GMTrace.o(972273221632L, 7244);
      return;
      this.sMs = ((Display)localObject).getHeight();
      this.sMt = ((Display)localObject).getWidth();
      break;
      this.sMe = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.sMu);
    }
  }
  
  public final void jt(boolean paramBoolean)
  {
    GMTrace.i(972810092544L, 7248);
    this.sMr.sMW.value = false;
    bEY();
    v.d("MicroMsg.AppPanel", "enable " + this.sMr.sMX.value + " isVoipAudioEnable false");
    GMTrace.o(972810092544L, 7248);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(973615398912L, 7254);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      v.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label82;
      }
    }
    label82:
    for (this.sMD = true;; this.sMD = false)
    {
      this.sMH = true;
      anG();
      GMTrace.o(973615398912L, 7254);
      return;
    }
  }
  
  public final void refresh()
  {
    GMTrace.i(973346963456L, 7252);
    v.v("MicroMsg.AppPanel", "app panel refleshed");
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.i.g.sV().getValue("ShowAPPSuggestion");
        if ((!bf.mA(str)) && (Integer.valueOf(str).intValue() == 1)) {
          continue;
        }
        this.sMe = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sMu);
        v.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
      }
      catch (Exception localException)
      {
        int i;
        v.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.sMe = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sMu);
        continue;
      }
      if (!bFd()) {
        bS(this.sMe);
      }
      bR(this.sMe);
      if (this.sMr != null)
      {
        this.sMr.ju(this.sMv);
        this.sMr.jv(this.sMw);
        this.sMr.jw(this.sMx);
        this.sMr.jx(this.sMy);
      }
      i = this.paZ.bRH();
      bFb();
      this.paZ.Ac(i);
      this.pba.zZ(i);
      GMTrace.o(973346963456L, 7252);
      return;
      v.d("MicroMsg.AppPanel", "jacks show App Suggestion");
      this.sMe = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.sMu);
    }
  }
  
  public final void xu(int paramInt)
  {
    GMTrace.i(973883834368L, 7256);
    if (this.sMI != paramInt)
    {
      this.sMI = paramInt;
      this.sMH = true;
    }
    GMTrace.o(973883834368L, 7256);
  }
  
  public static abstract interface a
  {
    public abstract void aJA();
    
    public abstract void aJB();
    
    public abstract void aJC();
    
    public abstract void aJD();
    
    public abstract void aJE();
    
    public abstract void aJF();
    
    public abstract void aJG();
    
    public abstract void aJH();
    
    public abstract void aJI();
    
    public abstract void aJw();
    
    public abstract void aJx();
    
    public abstract void aJy();
    
    public abstract void aJz();
    
    public abstract void b(f paramf);
    
    public abstract void pd(int paramInt);
    
    public abstract void pe(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void bFf();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/AppPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */