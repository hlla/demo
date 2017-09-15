package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.bm.a.b;
import com.tencent.mm.bm.a.c;
import com.tencent.mm.bm.a.d;
import com.tencent.mm.bm.a.e;
import com.tencent.mm.bm.a.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.a;
import java.util.Iterator;
import java.util.List;

public class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  public static int jZe;
  public static int jZf;
  public static boolean wtA;
  public LayoutInflater Du;
  private DisplayMetrics aQa;
  private Context mContext;
  public View njP;
  public n.d qHE;
  public l qHF;
  public View vwl;
  public MMListPopupWindow vyJ;
  private boolean wtB;
  private a wtu;
  public o wtv;
  private int wtw;
  private boolean wtx;
  public View wty;
  public View.OnCreateContextMenuListener wtz;
  
  static
  {
    GMTrace.i(14903268081664L, 111038);
    wtA = false;
    GMTrace.o(14903268081664L, 111038);
  }
  
  public g(Context paramContext)
  {
    GMTrace.i(14900449509376L, 111017);
    this.mContext = null;
    this.vwl = null;
    this.wtu = null;
    this.wtx = false;
    this.wtB = false;
    this.mContext = paramContext;
    this.Du = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    KD();
    GMTrace.o(14900449509376L, 111017);
  }
  
  public g(Context paramContext, View paramView)
  {
    GMTrace.i(14900315291648L, 111016);
    this.mContext = null;
    this.vwl = null;
    this.wtu = null;
    this.wtx = false;
    this.wtB = false;
    this.mContext = paramContext;
    this.vwl = paramView;
    this.Du = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    KD();
    cas();
    GMTrace.o(14900315291648L, 111016);
  }
  
  private void KD()
  {
    GMTrace.i(14901389033472L, 111024);
    bTO();
    this.qHF = new l();
    this.wtu = new a((byte)0);
    this.aQa = this.mContext.getResources().getDisplayMetrics();
    GMTrace.o(14901389033472L, 111024);
  }
  
  private boolean bTO()
  {
    GMTrace.i(14901120598016L, 111022);
    if (isShowing())
    {
      if (this.vyJ != null) {
        this.vyJ.dismiss();
      }
      GMTrace.o(14901120598016L, 111022);
      return true;
    }
    if (car())
    {
      if (this.wtv != null) {
        this.wtv.dismiss();
      }
      GMTrace.o(14901120598016L, 111022);
      return true;
    }
    GMTrace.o(14901120598016L, 111022);
    return false;
  }
  
  private boolean car()
  {
    GMTrace.i(18950335234048L, 141191);
    if ((this.wtv != null) && (this.wtv.isShowing()))
    {
      GMTrace.o(18950335234048L, 141191);
      return true;
    }
    GMTrace.o(18950335234048L, 141191);
    return false;
  }
  
  private void cas()
  {
    GMTrace.i(14901523251200L, 111025);
    this.vwl.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(18950603669504L, 141193);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          GMTrace.o(18950603669504L, 141193);
          return false;
          g.jZe = (int)paramAnonymousMotionEvent.getRawX();
          g.jZf = (int)paramAnonymousMotionEvent.getRawY();
          g.this.njP = g.this.vwl;
          g.wtA = true;
          v.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + g.jZe + "y_down=" + g.jZf);
        }
      }
    });
    GMTrace.o(14901523251200L, 111025);
  }
  
  private boolean eq(int paramInt1, int paramInt2)
  {
    GMTrace.i(14900852162560L, 111020);
    if ((isShowing()) || (car()))
    {
      GMTrace.o(14900852162560L, 111020);
      return false;
    }
    if (this.wtz != null) {
      this.wtz.onCreateContextMenu(this.qHF, this.vwl, null);
    }
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.f.dkC, null);
    int n = this.wtu.getCount();
    int i1 = this.mContext.getResources().getDimensionPixelSize(a.c.aXP);
    int i2 = this.mContext.getResources().getDimensionPixelSize(a.c.wxR);
    a locala = this.wtu;
    int i = 0;
    Object localObject = null;
    int j = 0;
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i5 = locala.getCount();
    int k = 0;
    if (k < i5)
    {
      int m = locala.getItemViewType(k);
      if (m == j) {
        break label660;
      }
      localObject = null;
      j = m;
    }
    label300:
    label326:
    label337:
    label660:
    for (;;)
    {
      localObject = locala.getView(k, (View)localObject, new FrameLayout(this.mContext));
      ((View)localObject).measure(i3, i4);
      i = Math.max(i, ((View)localObject).getMeasuredWidth());
      k += 1;
      break;
      j = a.U(this.mContext, a.c.wxS);
      boolean bool;
      if (i < j)
      {
        i = j;
        bool = true;
        if (this.qHF.size() >= 3) {
          bool = false;
        }
        if (!this.wtx)
        {
          if (this.wty == null) {
            break label326;
          }
          this.wty.setSelected(true);
        }
        if (!this.wtB) {
          break label337;
        }
        er(paramInt1, paramInt2);
      }
      for (;;)
      {
        GMTrace.o(14900852162560L, 111020);
        return true;
        break;
        this.vwl.setSelected(true);
        break label300;
        localObject = w.a(this.mContext, i, paramInt1, paramInt2, n * i1, i2, bool);
        this.wtw = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(a.c.wxR));
        v.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.wtw);
        this.vyJ = new MMListPopupWindow(this.mContext, null, 0);
        this.vyJ.setOnDismissListener(this);
        this.vyJ.Yi = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            GMTrace.i(14905012912128L, 111051);
            if (g.this.qHE != null) {
              g.this.qHE.c(g.this.qHF.getItem(paramAnonymousInt), paramAnonymousInt);
            }
            if ((g.this.vyJ != null) && (g.this.vyJ.iuy.isShowing())) {
              g.this.vyJ.dismiss();
            }
            GMTrace.o(14905012912128L, 111051);
          }
        };
        this.vyJ.setAdapter(this.wtu);
        this.vyJ.fe();
        this.vyJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.d.bkl));
        this.vyJ.setAnimationStyle(((w.a)localObject).vnS);
        this.vyJ.XX = ((w.a)localObject).juT;
        this.vyJ.setVerticalOffset(((w.a)localObject).qJz);
        this.vyJ.Yg = this.vwl;
        this.vyJ.setContentWidth(i);
        this.vyJ.ff();
        this.vyJ.show();
        this.vyJ.vja.setOnKeyListener(this);
        this.vyJ.vja.setDivider(new ColorDrawable(this.mContext.getResources().getColor(a.b.aVQ)));
        this.vyJ.vja.setSelector(this.mContext.getResources().getDrawable(a.d.bit));
        this.vyJ.vja.setDividerHeight(0);
        this.vyJ.vja.setVerticalScrollBarEnabled(false);
        this.vyJ.vja.setHorizontalScrollBarEnabled(false);
      }
    }
  }
  
  private void er(int paramInt1, int paramInt2)
  {
    GMTrace.i(18950201016320L, 141190);
    int j = this.mContext.getResources().getDimensionPixelOffset(a.c.aXG);
    int k = this.mContext.getResources().getDimensionPixelOffset(a.c.aXs);
    this.wtv = new o(this.mContext);
    this.wtv.setWidth(-2);
    this.wtv.setHeight(-2);
    this.wtv.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.d.bkl));
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(a.b.white));
    final int i = 0;
    if (i < this.qHF.size())
    {
      TextView localTextView = (TextView)this.Du.inflate(a.f.wyd, null, false);
      localTextView.setBackground(this.mContext.getResources().getDrawable(a.d.bit));
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.qHF.vjl.get(i)).getTitle());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(18950066798592L, 141189);
            if (g.this.qHE != null) {
              g.this.qHE.c(g.this.qHF.getItem(i), i);
            }
            g.this.wtv.dismiss();
            GMTrace.o(18950066798592L, 141189);
          }
        });
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.qHF.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.wtv.setContentView(localLinearLayout);
    this.wtv.showAtLocation(this.vwl, 0, paramInt1, paramInt2 - i);
    GMTrace.o(18950201016320L, 141190);
  }
  
  private boolean isShowing()
  {
    GMTrace.i(14900986380288L, 111021);
    if ((this.vyJ != null) && (this.vyJ.iuy.isShowing()))
    {
      GMTrace.o(14900986380288L, 111021);
      return true;
    }
    GMTrace.o(14900986380288L, 111021);
    return false;
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt2, int paramInt3)
  {
    GMTrace.i(14900717944832L, 111019);
    this.qHE = paramd;
    this.vwl = paramView;
    cas();
    this.qHF.clear();
    paramd = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.qHF, paramView, paramd);
    paramView = this.qHF.vjl.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).vjo = paramd;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bv(0, 0);
      GMTrace.o(14900717944832L, 111019);
      return;
    }
    bv(paramInt2, paramInt3);
    GMTrace.o(14900717944832L, 111019);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt1, int paramInt2)
  {
    GMTrace.i(16174041530368L, 120506);
    this.qHE = paramd;
    this.vwl = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      cas();
    }
    this.qHF.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.qHF, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      bv(0, 0);
      GMTrace.o(16174041530368L, 120506);
      return;
    }
    bv(paramInt1, paramInt2);
    GMTrace.o(16174041530368L, 120506);
  }
  
  public boolean bv(int paramInt1, int paramInt2)
  {
    GMTrace.i(14901254815744L, 111023);
    if (((!this.vwl.equals(this.njP)) || (!wtA)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      jZe = paramInt1;
      jZf = paramInt2;
    }
    this.njP = null;
    int k = jZe;
    int n = jZf;
    wtA = false;
    if (this.aQa == null) {
      this.aQa = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    if (this.vwl != null)
    {
      int[] arrayOfInt = new int[2];
      this.vwl.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.vwl.getWidth() / 2;
      }
      int m = arrayOfInt[1];
      j = arrayOfInt[1] + this.vwl.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.aQa.heightPixels) {
        m = this.aQa.heightPixels;
      }
      j = i;
      if (n == 0)
      {
        j = (k + m) / 2;
        k = i;
        i = j;
      }
    }
    for (;;)
    {
      v.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(i) });
      if ((!isShowing()) || (!car()))
      {
        bool1 = eq(k, i);
        GMTrace.o(14901254815744L, 111023);
        return bool1;
      }
      boolean bool1 = bTO();
      boolean bool2 = eq(k, i);
      GMTrace.o(14901254815744L, 111023);
      return bool2 & bool1;
      i = n;
      k = j;
    }
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    GMTrace.i(14900583727104L, 111018);
    this.vwl = paramView;
    cas();
    this.qHE = paramd;
    if ((paramView instanceof AbsListView))
    {
      v.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(14904610258944L, 111048);
          g.this.qHF.clear();
          v.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(g.this.qHF, paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = g.this.qHF.vjl.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).vjo = paramAnonymousAdapterView;
          }
          g.this.bv(0, 0);
          GMTrace.o(14904610258944L, 111048);
          return true;
        }
      });
      GMTrace.o(14900583727104L, 111018);
      return;
    }
    v.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view");
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        GMTrace.i(14900181073920L, 111015);
        v.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click");
        g.this.qHF.clear();
        g.this.vwl = paramAnonymousView;
        paramOnCreateContextMenuListener.onCreateContextMenu(g.this.qHF, paramAnonymousView, null);
        if ((paramAnonymousView.getTag(a.e.cJn) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(a.e.cJn);
          g.this.bv(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          GMTrace.o(14900181073920L, 111015);
          return true;
          g.this.bv(0, 0);
        }
      }
    });
    GMTrace.o(14900583727104L, 111018);
  }
  
  public void onDismiss()
  {
    GMTrace.i(14901925904384L, 111028);
    if (!this.wtx)
    {
      if (this.wty != null)
      {
        this.wty.setSelected(false);
        GMTrace.o(14901925904384L, 111028);
        return;
      }
      this.vwl.setSelected(false);
    }
    GMTrace.o(14901925904384L, 111028);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(14901791686656L, 111027);
    GMTrace.o(14901791686656L, 111027);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(14901657468928L, 111026);
    GMTrace.o(14901657468928L, 111026);
    return false;
  }
  
  private final class a
    extends BaseAdapter
  {
    private a()
    {
      GMTrace.i(14903536517120L, 111040);
      GMTrace.o(14903536517120L, 111040);
    }
    
    private String hM(int paramInt)
    {
      GMTrace.i(14903804952576L, 111042);
      String str = (String)((MenuItem)g.this.qHF.vjl.get(paramInt)).getTitle();
      GMTrace.o(14903804952576L, 111042);
      return str;
    }
    
    public final int getCount()
    {
      GMTrace.i(14903670734848L, 111041);
      int i = g.this.qHF.size();
      GMTrace.o(14903670734848L, 111041);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(14903939170304L, 111043);
      long l = paramInt;
      GMTrace.o(14903939170304L, 111043);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(14904073388032L, 111044);
      if (paramView == null) {}
      for (paramView = (TextView)g.this.Du.inflate(a.f.dkC, paramViewGroup, false);; paramView = (TextView)paramView)
      {
        paramViewGroup = hM(paramInt);
        paramView.setTag(paramViewGroup);
        paramView.setText(paramViewGroup);
        GMTrace.o(14904073388032L, 111044);
        return paramView;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */