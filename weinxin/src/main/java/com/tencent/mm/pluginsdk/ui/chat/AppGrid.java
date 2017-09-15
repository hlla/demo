package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  Context context;
  private SharedPreferences hgn;
  AdapterView.OnItemClickListener jZr;
  AdapterView.OnItemLongClickListener lGQ;
  b sLW;
  int sLX;
  int sLY;
  int sLZ;
  int sMa;
  int sMb;
  a sMc;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(991869009920L, 7390);
    this.sLY = 0;
    this.sLZ = 0;
    this.jZr = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(994150711296L, 7407);
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).xs(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).ur(paramAnonymousInt));
        GMTrace.o(994150711296L, 7407);
      }
    };
    this.lGQ = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1015357112320L, 7565);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).xs(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).ur(paramAnonymousInt);
        paramAnonymousAdapterView.xt(i);
        GMTrace.o(1015357112320L, 7565);
        return true;
      }
    };
    this.context = paramContext;
    GMTrace.o(991869009920L, 7390);
  }
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(991734792192L, 7389);
    this.sLY = 0;
    this.sLZ = 0;
    this.jZr = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(994150711296L, 7407);
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).xs(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).ur(paramAnonymousInt));
        GMTrace.o(994150711296L, 7407);
      }
    };
    this.lGQ = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1015357112320L, 7565);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).xs(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).ur(paramAnonymousInt);
        paramAnonymousAdapterView.xt(i);
        GMTrace.o(1015357112320L, 7565);
        return true;
      }
    };
    this.context = paramContext;
    GMTrace.o(991734792192L, 7389);
  }
  
  public int getCount()
  {
    GMTrace.i(992003227648L, 7391);
    int i = this.sMc.getCount();
    GMTrace.o(992003227648L, 7391);
    return i;
  }
  
  final class a
    extends BaseAdapter
  {
    List<f> sMe;
    private int sMf;
    private int sMg;
    private Map<String, f> sMh;
    
    public a(List<f> paramList, Map<String, f> paramMap)
    {
      GMTrace.i(988647784448L, 7366);
      this.sMh = null;
      this.sMe = paramMap;
      Map localMap;
      this.sMh = localMap;
      this.sMf = BackwardSupportUtil.b.a(paramList, 56.0F);
      this.sMg = BackwardSupportUtil.b.a(paramList, 53.3F);
      GMTrace.o(988647784448L, 7366);
    }
    
    private void a(a parama, String paramString)
    {
      GMTrace.i(989318873088L, 7371);
      if (this.sMh == null)
      {
        v.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        GMTrace.o(989318873088L, 7371);
        return;
      }
      f localf = (f)this.sMh.get(paramString);
      if (localf == null)
      {
        v.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        GMTrace.o(989318873088L, 7371);
        return;
      }
      ap.yY();
      if (c.isSDCardAvailable()) {
        if (!localf.bCN()) {
          break label595;
        }
      }
      label484:
      label595:
      for (paramString = g.b(localf.field_appId, 4, a.getDensity(AppGrid.h(AppGrid.this)));; paramString = null)
      {
        if (paramString != null) {
          parama.jiQ.setBackgroundDrawable(new BitmapDrawable(paramString));
        }
        int i;
        for (;;)
        {
          parama.jiR.setText(g.a(AppGrid.h(AppGrid.this), localf, null));
          if ((localf.bCN()) && (localf.bCO()))
          {
            if (AppGrid.i(AppGrid.this) == null) {
              AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(aa.bIN(), 0));
            }
            if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + localf.field_appId, true)) {
              parama.sMi.setVisibility(0);
            }
          }
          if (!f.sBx.equals(localf.field_appId)) {
            break label484;
          }
          ap.yY();
          i = ((Integer)c.vr().get(w.a.uCm, Integer.valueOf(0))).intValue();
          if (i > 1) {
            break;
          }
          GMTrace.o(989318873088L, 7371);
          return;
          if (f.sBx.equals(localf.field_appId))
          {
            parama.jiQ.setImageResource(R.g.bie);
          }
          else if (f.sBz.equals(localf.field_appId))
          {
            parama.jiQ.setImageResource(R.g.bid);
          }
          else if (f.sBy.equals(localf.field_appId))
          {
            parama.jiQ.setImageResource(R.g.bic);
          }
          else if (f.sBA.equals(localf.field_appId))
          {
            parama.jiQ.setImageResource(R.k.dys);
          }
          else
          {
            parama.jiQ.setImageResource(R.g.bcd);
            continue;
            parama.jiQ.setImageResource(R.g.bjO);
          }
        }
        ap.yY();
        if (!bf.f(((String)c.vr().get(w.a.uEc, "")).split(";")).contains(String.valueOf(i))) {
          parama.sMi.setVisibility(0);
        }
        GMTrace.o(989318873088L, 7371);
        return;
        if (f.sBz.equals(localf.field_appId))
        {
          ap.yY();
          i = ((Integer)c.vr().get(w.a.uCm, Integer.valueOf(0))).intValue();
          if (i <= 1)
          {
            GMTrace.o(989318873088L, 7371);
            return;
          }
          ap.yY();
          if (!bf.f(((String)c.vr().get(w.a.uEd, "")).split(";")).contains(String.valueOf(i))) {
            parama.sMi.setVisibility(0);
          }
        }
        GMTrace.o(989318873088L, 7371);
        return;
      }
    }
    
    public final int getCount()
    {
      GMTrace.i(988782002176L, 7367);
      if (AppGrid.a(AppGrid.this) == AppGrid.e(AppGrid.this) - 1)
      {
        i = AppGrid.f(AppGrid.this);
        int j = AppGrid.a(AppGrid.this);
        int k = AppGrid.b(AppGrid.this);
        GMTrace.o(988782002176L, 7367);
        return i - j * k;
      }
      int i = AppGrid.b(AppGrid.this);
      GMTrace.o(988782002176L, 7367);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(989050437632L, 7369);
      GMTrace.o(989050437632L, 7369);
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(989184655360L, 7370);
      View localView;
      if (paramView == null)
      {
        paramViewGroup = new a();
        localView = View.inflate(AppGrid.h(AppGrid.this), R.i.cUw, null);
        paramViewGroup.jiQ = ((ImageView)localView.findViewById(R.h.bpr));
        paramViewGroup.sMj = localView.findViewById(R.h.bps);
        paramViewGroup.jiR = ((TextView)localView.findViewById(R.h.bpt));
        paramViewGroup.sMi = ((TextView)localView.findViewById(R.h.bpu));
        paramViewGroup.sMk = localView.findViewById(R.h.bpv);
        localView.setTag(paramViewGroup);
        v.v("MicroMsg.AppGrid", "pos:" + paramInt + " page:" + AppGrid.a(AppGrid.this));
        paramViewGroup.jiR.setVisibility(0);
        paramViewGroup.sMk.setVisibility(8);
        paramViewGroup.sMi.setVisibility(8);
        paramViewGroup.sMj.setVisibility(0);
        paramView = paramViewGroup.jiQ.getLayoutParams();
        paramView.width = this.sMf;
        paramView.height = this.sMf;
        paramViewGroup.jiQ.setLayoutParams(paramView);
        int i = AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt;
        int j = AppGrid.c(AppGrid.this).xs(i);
        if (i >= AppGrid.g(AppGrid.this)) {
          break label1361;
        }
        switch (j)
        {
        }
      }
      for (;;)
      {
        paramView = ur(paramInt);
        if ((paramView != null) && (g.j(paramView))) {
          paramViewGroup.sMi.setVisibility(0);
        }
        GMTrace.o(989184655360L, 7370);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        paramViewGroup.jiQ.setImageResource(R.k.dyv);
        paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGQ));
        continue;
        paramViewGroup.jiQ.setImageResource(R.k.dyE);
        paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGZ));
        label1361:
        label1436:
        label1632:
        try
        {
          ap.yY();
          if (((Boolean)c.vr().get(67, Boolean.valueOf(false))).booleanValue())
          {
            paramViewGroup.sMi.setVisibility(0);
            continue;
          }
          paramViewGroup.sMi.setVisibility(8);
        }
        catch (Exception paramView) {}
        paramViewGroup.jiQ.setImageResource(R.k.dyC);
        paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.erT));
        try
        {
          ap.yY();
          if (((Boolean)c.vr().get(73, Boolean.valueOf(false))).booleanValue())
          {
            paramViewGroup.sMi.setVisibility(0);
            continue;
          }
          paramViewGroup.sMi.setVisibility(8);
        }
        catch (Exception paramView) {}
        if (r.ijy)
        {
          paramViewGroup.jiQ.setImageResource(R.k.dyB);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGY));
        }
        else
        {
          paramViewGroup.jiQ.setImageResource(R.k.dyt);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGS));
          continue;
          paramViewGroup.jiQ.setImageResource(R.k.dyz);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGU));
          continue;
          paramViewGroup.jiQ.setImageResource(R.k.dyx);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGR));
          try
          {
            ap.yY();
            if (((Boolean)c.vr().get(290817, Boolean.valueOf(false))).booleanValue())
            {
              paramViewGroup.sMk.setVisibility(0);
              continue;
            }
            paramViewGroup.sMk.setVisibility(8);
          }
          catch (Exception paramView) {}
          paramViewGroup.jiQ.setImageResource(R.k.dyA);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGX));
          try
          {
            ap.yY();
            if (((Boolean)c.vr().get(327744, Boolean.valueOf(true))).booleanValue())
            {
              paramViewGroup.sMk.setVisibility(0);
              continue;
            }
            paramViewGroup.sMk.setVisibility(8);
          }
          catch (Exception paramView) {}
          paramViewGroup.jiQ.setImageResource(R.k.dyw);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGN));
          continue;
          paramViewGroup.jiQ.setImageResource(R.k.dtM);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dHc));
          try
          {
            ap.yY();
            if (((Boolean)c.vr().get(54, Boolean.valueOf(false))).booleanValue())
            {
              paramViewGroup.sMi.setVisibility(0);
              continue;
            }
            paramViewGroup.sMi.setVisibility(8);
          }
          catch (Exception paramView) {}
          paramViewGroup.jiQ.setImageResource(R.k.dyD);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dHd));
          try
          {
            ap.yY();
            if (((Boolean)c.vr().get(62, Boolean.valueOf(false))).booleanValue())
            {
              paramViewGroup.sMi.setVisibility(0);
              continue;
            }
            paramViewGroup.sMi.setVisibility(8);
          }
          catch (Exception paramView) {}
          paramViewGroup.jiQ.setImageResource(R.k.dtK);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.edG));
          try
          {
            ap.yY();
            boolean bool1 = ((Boolean)c.vr().get(208899, Boolean.valueOf(false))).booleanValue();
            ap.yY();
            boolean bool2 = ((Boolean)c.vr().get(208913, Boolean.valueOf(false))).booleanValue();
            if ((bool1) || (bool2))
            {
              paramViewGroup.sMi.setVisibility(0);
              if (bool2)
              {
                paramViewGroup.sMi.setText(R.l.dHi);
                continue;
              }
              paramViewGroup.sMi.setText(R.l.dHG);
              continue;
            }
            paramViewGroup.sMi.setVisibility(8);
          }
          catch (Exception paramView) {}
          a(paramViewGroup, f.sBx);
          continue;
          a(paramViewGroup, f.sBz);
          continue;
          paramViewGroup.jiQ.setImageResource(R.k.dyy);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dHd));
          try
          {
            ap.yY();
            if (((Boolean)c.vr().get(81, Boolean.valueOf(true))).booleanValue())
            {
              paramViewGroup.sMi.setVisibility(0);
              continue;
            }
            paramViewGroup.sMi.setVisibility(8);
          }
          catch (Exception paramView) {}
          paramViewGroup.jiQ.setImageResource(R.k.dyu);
          paramViewGroup.jiR.setText(AppGrid.h(AppGrid.this).getString(R.l.dGP));
          try
          {
            paramViewGroup.sMk.setVisibility(8);
          }
          catch (Exception paramView) {}
          continue;
          a(paramViewGroup, f.sBA);
          continue;
          paramView.width = this.sMg;
          paramView.height = this.sMg;
          paramViewGroup.jiQ.setLayoutParams(paramView);
          f localf = ur(paramInt);
          if (localf != null)
          {
            ap.yY();
            if (c.isSDCardAvailable()) {
              if (localf.field_status == 5)
              {
                paramView = g.b(localf.field_appId, 3, a.getDensity(AppGrid.h(AppGrid.this)));
                if (paramView == null) {
                  break label1632;
                }
                paramViewGroup.jiQ.setBackgroundDrawable(new BitmapDrawable(paramView));
              }
            }
            for (;;)
            {
              paramViewGroup.jiR.setText(g.a(AppGrid.h(AppGrid.this), localf, null));
              if (((!localf.bCN()) || (!localf.bCO())) && (!localf.bCP())) {
                break;
              }
              if (AppGrid.i(AppGrid.this) == null) {
                AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(aa.bIN(), 0));
              }
              if (!AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + localf.field_appId, true)) {
                break;
              }
              paramViewGroup.sMi.setVisibility(0);
              break;
              if (localf.bCN())
              {
                paramView = g.b(localf.field_appId, 4, a.getDensity(AppGrid.h(AppGrid.this)));
                break label1436;
              }
              paramView = g.b(localf.field_appId, 1, a.getDensity(AppGrid.h(AppGrid.this)));
              break label1436;
              if (f.sBx.equals(localf.field_appId))
              {
                paramViewGroup.jiQ.setImageResource(R.g.bie);
              }
              else if (f.sBz.equals(localf.field_appId))
              {
                paramViewGroup.jiQ.setImageResource(R.g.bid);
              }
              else if (f.sBy.equals(localf.field_appId))
              {
                paramViewGroup.jiQ.setImageResource(R.g.bic);
              }
              else if (f.sBA.equals(localf.field_appId))
              {
                paramViewGroup.jiQ.setImageResource(R.k.dys);
              }
              else
              {
                paramViewGroup.jiQ.setBackgroundResource(R.g.bcd);
                continue;
                paramViewGroup.jiQ.setBackgroundResource(R.g.bjO);
              }
            }
            continue;
            continue;
            continue;
            continue;
            continue;
            continue;
          }
        }
      }
    }
    
    public final f ur(int paramInt)
    {
      GMTrace.i(988916219904L, 7368);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.sMe.size()))
      {
        GMTrace.o(988916219904L, 7368);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      v.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      f localf = (f)this.sMe.get(paramInt);
      GMTrace.o(988916219904L, 7368);
      return localf;
    }
    
    final class a
    {
      ImageView jiQ;
      TextView jiR;
      TextView sMi;
      View sMj;
      View sMk;
      
      a()
      {
        GMTrace.i(1016565071872L, 7574);
        GMTrace.o(1016565071872L, 7574);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, f paramf);
    
    public abstract int xs(int paramInt);
    
    public abstract void xt(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/AppGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */