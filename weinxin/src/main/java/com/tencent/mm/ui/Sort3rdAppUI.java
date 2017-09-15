package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI
  extends MMActivity
{
  private DragSortListView kOT;
  private a uUC;
  private long uUD;
  private List<f> uUE;
  
  public Sort3rdAppUI()
  {
    GMTrace.i(2877091217408L, 21436);
    GMTrace.o(2877091217408L, 21436);
  }
  
  protected final void KD()
  {
    GMTrace.i(2877493870592L, 21439);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(3078552027136L, 22937);
        Sort3rdAppUI.this.finish();
        GMTrace.o(3078552027136L, 22937);
        return true;
      }
    });
    qL(getString(R.l.dBC));
    this.kOT = ((DragSortListView)findViewById(R.h.cbq));
    this.kOT.wqV = new DragSortListView.g()
    {
      public final void bQ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1905891737600L, 14200);
        f localf = (f)Sort3rdAppUI.a(Sort3rdAppUI.this).getItem(paramAnonymousInt1);
        Sort3rdAppUI.a(Sort3rdAppUI.this).remove(localf);
        Sort3rdAppUI.a(Sort3rdAppUI.this).insert(localf, paramAnonymousInt2);
        GMTrace.o(1905891737600L, 14200);
      }
    };
    GMTrace.o(2877493870592L, 21439);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2877225435136L, 21437);
    int i = R.i.doD;
    GMTrace.o(2877225435136L, 21437);
    return i;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    GMTrace.i(2877359652864L, 21438);
    super.onCreate(paramBundle);
    this.uUD = getIntent().getLongExtra("KFlag", -1L);
    KD();
    this.uUE = com.tencent.mm.pluginsdk.model.app.g.b(this, this.uUD, true);
    paramBundle = an.bDd().ef(this.uUD);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.uUE, new Comparator() {});
    }
    this.uUC = new a(this, this.uUE, this.uUD);
    this.kOT.setAdapter(this.uUC);
    GMTrace.o(2877359652864L, 21438);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2877628088320L, 21440);
    super.onDestroy();
    GMTrace.o(2877628088320L, 21440);
  }
  
  protected void onPause()
  {
    GMTrace.i(2877762306048L, 21441);
    super.onPause();
    if (this.uUC != null)
    {
      List localList = this.uUC.kGq;
      o localo = an.bDd();
      long l = this.uUD;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localo.gUp.eE("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        ap.yY();
        l = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
        localo = an.bDd();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new com.tencent.mm.pluginsdk.model.app.n();
          ((com.tencent.mm.pluginsdk.model.app.n)localObject).field_flag = this.uUD;
          ((com.tencent.mm.pluginsdk.model.app.n)localObject).field_appId = ((f)localList.get(i)).field_appId;
          ((com.tencent.mm.pluginsdk.model.app.n)localObject).field_sortId = i;
          localo.a((com.tencent.mm.pluginsdk.model.app.n)localObject);
          i += 1;
        }
        ap.yY();
        com.tencent.mm.u.c.wO().aD(l);
      }
    }
    GMTrace.o(2877762306048L, 21441);
  }
  
  private static final class a
    extends ArrayAdapter<f>
  {
    List<f> kGq;
    private com.tencent.mm.ah.a.a.c lgD;
    private Context mContext;
    private long uUD;
    
    public a(Context paramContext, List<f> paramList, long paramLong)
    {
      super(R.i.doE, paramList);
      GMTrace.i(1886832820224L, 14058);
      this.uUD = paramLong;
      this.mContext = paramContext;
      this.kGq = paramList;
      paramContext = new c.a();
      paramContext.hII = R.g.bhp;
      this.lgD = paramContext.Hh();
      GMTrace.o(1886832820224L, 14058);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool = true;
      GMTrace.i(1886967037952L, 14059);
      final f localf;
      Object localObject;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, R.i.doE, null);
        paramViewGroup = new a(paramView);
        paramView.setTag(paramViewGroup);
        localf = (f)getItem(paramInt);
        paramViewGroup.ipc.setText(localf.field_appName);
        localObject = com.tencent.mm.pluginsdk.model.app.g.b(localf.field_appId, 1, com.tencent.mm.bg.a.getDensity(this.mContext));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label173;
        }
        paramViewGroup.jaK.setImageBitmap((Bitmap)localObject);
        label104:
        localObject = paramViewGroup.srx;
        if ((localf.field_appInfoFlag & 0x4000) != 0) {
          break label195;
        }
      }
      for (;;)
      {
        ((MMSwitchBtn)localObject).lP(bool);
        paramViewGroup.srx.wuy = new MMSwitchBtn.a()
        {
          public final void bK(boolean paramAnonymousBoolean)
          {
            GMTrace.i(2896687005696L, 21582);
            f localf;
            if (paramAnonymousBoolean) {
              localf = localf;
            }
            for (localf.field_appInfoFlag &= 0xBFFF;; localf.field_appInfoFlag |= 0x4000)
            {
              an.aRk().a(localf, new String[0]);
              GMTrace.o(2896687005696L, 21582);
              return;
              localf = localf;
            }
          }
        };
        paramView.setVisibility(0);
        GMTrace.o(1886967037952L, 14059);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label173:
        com.tencent.mm.ah.n.GX().a(localf.field_appIconUrl, paramViewGroup.jaK, this.lgD);
        break label104;
        label195:
        bool = false;
      }
    }
    
    static final class a
    {
      TextView ipc;
      ImageView jaK;
      View kGr;
      ImageView kGs;
      MMSwitchBtn srx;
      
      public a(View paramView)
      {
        GMTrace.i(3471138881536L, 25862);
        this.kGs = ((ImageView)paramView.findViewById(R.h.bWh));
        this.jaK = ((ImageView)paramView.findViewById(R.h.bWo));
        this.ipc = ((TextView)paramView.findViewById(R.h.cIL));
        this.srx = ((MMSwitchBtn)paramView.findViewById(R.h.cGP));
        this.kGr = paramView.findViewById(R.h.bGk);
        GMTrace.o(3471138881536L, 25862);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/Sort3rdAppUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */