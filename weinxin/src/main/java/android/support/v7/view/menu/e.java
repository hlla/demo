package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a.h;
import android.support.v7.app.a;
import android.support.v7.app.a.a;
import android.support.v7.app.a.a.1;
import android.support.v7.app.a.a.2;
import android.support.v7.app.a.a.3;
import android.support.v7.app.a.a.4;
import android.support.v7.app.a.c;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public final class e
  implements l, AdapterView.OnItemClickListener
{
  public LayoutInflater Du;
  int PU;
  public ExpandedMenuView Qi;
  public int Qj;
  int Qk;
  public a Ql;
  public l.a dV;
  f dW;
  private int dX;
  Context mContext;
  
  private e(int paramInt)
  {
    this.PU = paramInt;
    this.Qk = 0;
  }
  
  public e(Context paramContext, int paramInt)
  {
    this(paramInt);
    this.mContext = paramContext;
    this.Du = LayoutInflater.from(this.mContext);
  }
  
  public final boolean B()
  {
    return false;
  }
  
  public final void a(Context paramContext, f paramf)
  {
    if (this.Qk != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.Qk);
      this.Du = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.dW = paramf;
      if (this.Ql != null) {
        this.Ql.notifyDataSetChanged();
      }
      return;
      if (this.mContext != null)
      {
        this.mContext = paramContext;
        if (this.Du == null) {
          this.Du = LayoutInflater.from(this.mContext);
        }
      }
    }
  }
  
  public final void a(f paramf, boolean paramBoolean)
  {
    if (this.dV != null) {
      this.dV.a(paramf, paramBoolean);
    }
  }
  
  public final boolean a(p paramp)
  {
    if (!paramp.hasVisibleItems()) {
      return false;
    }
    g localg = new g(paramp);
    Object localObject1 = localg.dW;
    b.a locala = new b.a(((f)localObject1).mContext);
    localg.QL = new e(locala.Go.mContext, a.h.KJ);
    localg.QL.dV = localg;
    localg.dW.a(localg.QL);
    Object localObject2 = localg.QL.getAdapter();
    locala.Go.FA = ((ListAdapter)localObject2);
    locala.Go.FY = localg;
    localObject2 = ((f)localObject1).QB;
    a.a locala1;
    a locala2;
    ListView localListView;
    label406:
    label447:
    label479:
    int i;
    if (localObject2 != null)
    {
      locala.Go.Fz = ((View)localObject2);
      locala.Go.FW = localg;
      localObject2 = new b(locala.Go.mContext, locala.oH);
      locala1 = locala.Go;
      locala2 = b.a((b)localObject2);
      if (locala1.Fz == null) {
        break label777;
      }
      locala2.Fz = locala1.Fz;
      if (locala1.Ff != null)
      {
        localObject1 = locala1.Ff;
        locala2.Ff = ((CharSequence)localObject1);
        if (locala2.jq != null) {
          locala2.jq.setText((CharSequence)localObject1);
        }
      }
      if (locala1.FO != null) {
        locala2.a(-1, locala1.FO, locala1.FP, null);
      }
      if (locala1.FQ != null) {
        locala2.a(-2, locala1.FQ, locala1.FR, null);
      }
      if (locala1.FS != null) {
        locala2.a(-3, locala1.FS, locala1.FT, null);
      }
      if ((locala1.FX != null) || (locala1.Bo != null) || (locala1.FA != null))
      {
        localListView = (ListView)locala1.Du.inflate(locala2.FE, null);
        if (!locala1.Ga) {
          break label966;
        }
        if (locala1.Bo != null) {
          break label938;
        }
        localObject1 = new a.a.1(locala1, locala1.mContext, locala2.FF, locala1.FX, localListView);
        locala2.FA = ((ListAdapter)localObject1);
        locala2.FB = locala1.FB;
        if (locala1.FY == null) {
          break label1082;
        }
        localListView.setOnItemClickListener(new a.a.3(locala1, locala2));
        if (locala1.Gf != null) {
          localListView.setOnItemSelectedListener(locala1.Gf);
        }
        if (!locala1.Gb) {
          break label1111;
        }
        localListView.setChoiceMode(1);
        locala2.Fg = localListView;
      }
      if (locala1.mView == null) {
        break label1153;
      }
      if (!locala1.Fm) {
        break label1128;
      }
      localObject1 = locala1.mView;
      i = locala1.Fi;
      int j = locala1.Fj;
      int k = locala1.Fk;
      int m = locala1.Fl;
      locala2.mView = ((View)localObject1);
      locala2.Fh = 0;
      locala2.Fm = true;
      locala2.Fi = i;
      locala2.Fj = j;
      locala2.Fk = k;
      locala2.Fl = m;
    }
    for (;;)
    {
      ((b)localObject2).setCancelable(locala.Go.oI);
      if (locala.Go.oI) {
        ((b)localObject2).setCanceledOnTouchOutside(true);
      }
      ((b)localObject2).setOnCancelListener(locala.Go.FU);
      ((b)localObject2).setOnDismissListener(locala.Go.FV);
      if (locala.Go.FW != null) {
        ((b)localObject2).setOnKeyListener(locala.Go.FW);
      }
      localg.QK = ((b)localObject2);
      localg.QK.setOnDismissListener(localg);
      localObject1 = localg.QK.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      localg.QK.show();
      if (this.dV != null) {
        this.dV.d(paramp);
      }
      return true;
      localObject2 = ((f)localObject1).QA;
      locala.Go.jQ = ((Drawable)localObject2);
      localObject1 = ((f)localObject1).Qz;
      locala.Go.uI = ((CharSequence)localObject1);
      break;
      label777:
      if (locala1.uI != null) {
        locala2.setTitle(locala1.uI);
      }
      if (locala1.jQ != null)
      {
        localObject1 = locala1.jQ;
        locala2.jQ = ((Drawable)localObject1);
        locala2.Fx = 0;
        if (locala2.kI != null)
        {
          if (localObject1 == null) {
            break label925;
          }
          locala2.kI.setVisibility(0);
          locala2.kI.setImageDrawable((Drawable)localObject1);
        }
      }
      for (;;)
      {
        if (locala1.Fx != 0) {
          locala2.setIcon(locala1.Fx);
        }
        if (locala1.FN == 0) {
          break;
        }
        i = locala1.FN;
        localObject1 = new TypedValue();
        locala2.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject1, true);
        locala2.setIcon(((TypedValue)localObject1).resourceId);
        break;
        label925:
        locala2.kI.setVisibility(8);
      }
      label938:
      localObject1 = new a.a.2(locala1, locala1.mContext, locala1.Bo, localListView, locala2);
      break label406;
      label966:
      if (locala1.Gb) {}
      for (i = locala2.FG;; i = locala2.FH)
      {
        if (locala1.Bo == null) {
          break label1041;
        }
        localObject1 = new SimpleCursorAdapter(locala1.mContext, i, locala1.Bo, new String[] { locala1.Gd }, new int[] { 16908308 });
        break;
      }
      label1041:
      if (locala1.FA != null)
      {
        localObject1 = locala1.FA;
        break label406;
      }
      localObject1 = new a.c(locala1.mContext, i, locala1.FX);
      break label406;
      label1082:
      if (locala1.Gc == null) {
        break label447;
      }
      localListView.setOnItemClickListener(new a.a.4(locala1, localListView, locala2));
      break label447;
      label1111:
      if (!locala1.Ga) {
        break label479;
      }
      localListView.setChoiceMode(2);
      break label479;
      label1128:
      locala2.mView = locala1.mView;
      locala2.Fh = 0;
      locala2.Fm = false;
      continue;
      label1153:
      if (locala1.Fh != 0)
      {
        i = locala1.Fh;
        locala2.mView = null;
        locala2.Fh = i;
        locala2.Fm = false;
      }
    }
  }
  
  public final boolean b(h paramh)
  {
    return false;
  }
  
  public final boolean c(h paramh)
  {
    return false;
  }
  
  public final void f(boolean paramBoolean)
  {
    if (this.Ql != null) {
      this.Ql.notifyDataSetChanged();
    }
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.Ql == null) {
      this.Ql = new a();
    }
    return this.Ql;
  }
  
  public final int getId()
  {
    return this.dX;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.dW.a(this.Ql.ax(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.Qi.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.Qi == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.Qi != null) {
      this.Qi.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  private final class a
    extends BaseAdapter
  {
    private int Qm = -1;
    
    public a()
    {
      dr();
    }
    
    private void dr()
    {
      h localh = e.this.dW.QI;
      if (localh != null)
      {
        ArrayList localArrayList = e.this.dW.dB();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((h)localArrayList.get(i) == localh)
          {
            this.Qm = i;
            return;
          }
          i += 1;
        }
      }
      this.Qm = -1;
    }
    
    public final h ax(int paramInt)
    {
      ArrayList localArrayList = e.this.dW.dB();
      int i = e.this.Qj + paramInt;
      paramInt = i;
      if (this.Qm >= 0)
      {
        paramInt = i;
        if (i >= this.Qm) {
          paramInt = i + 1;
        }
      }
      return (h)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = e.this.dW.dB().size() - e.this.Qj;
      if (this.Qm < 0) {
        return i;
      }
      return i - 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = e.this.Du.inflate(e.this.PU, paramViewGroup, false);
      }
      for (;;)
      {
        ((m.a)paramView).a(ax(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      dr();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */