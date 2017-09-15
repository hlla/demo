package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a.d;
import android.support.design.a.f;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.l.a;
import android.support.v7.view.menu.p;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
  implements l
{
  public ColorStateList dS;
  public NavigationMenuView dT;
  public LinearLayout dU;
  private l.a dV;
  public f dW;
  public int dX;
  public b dY;
  public LayoutInflater dZ;
  public int ea;
  public boolean eb;
  public ColorStateList ec;
  public Drawable ed;
  public int ee;
  public int ef;
  public final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      b.this.g(true);
      paramAnonymousView = paramAnonymousView.dR;
      boolean bool = b.this.dW.a(paramAnonymousView, b.this, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        b.this.dY.d(paramAnonymousView);
      }
      b.this.g(false);
      b.this.f(false);
    }
  };
  
  public final boolean B()
  {
    return false;
  }
  
  public final void a(Context paramContext, f paramf)
  {
    this.dZ = LayoutInflater.from(paramContext);
    this.dW = paramf;
    this.ef = paramContext.getResources().getDimensionPixelOffset(a.d.al);
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    this.dS = paramColorStateList;
    f(false);
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.ed = paramDrawable;
    f(false);
  }
  
  public final void a(f paramf, boolean paramBoolean)
  {
    if (this.dV != null) {
      this.dV.a(paramf, paramBoolean);
    }
  }
  
  public final boolean a(p paramp)
  {
    return false;
  }
  
  public final void b(ColorStateList paramColorStateList)
  {
    this.ec = paramColorStateList;
    f(false);
  }
  
  public final boolean b(h paramh)
  {
    return false;
  }
  
  public final boolean c(h paramh)
  {
    return false;
  }
  
  public final void e(int paramInt)
  {
    this.ea = paramInt;
    this.eb = true;
    f(false);
  }
  
  public final void f(boolean paramBoolean)
  {
    if (this.dY != null)
    {
      b localb = this.dY;
      localb.C();
      localb.aab.notifyChanged();
    }
  }
  
  public final void g(boolean paramBoolean)
  {
    if (this.dY != null) {
      this.dY.ek = paramBoolean;
    }
  }
  
  public final int getId()
  {
    return this.dX;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    Object localObject1 = paramParcelable.getSparseParcelableArray("android:menu:list");
    if (localObject1 != null) {
      this.dT.restoreHierarchyState((SparseArray)localObject1);
    }
    localObject1 = paramParcelable.getBundle("android:menu:adapter");
    if (localObject1 != null)
    {
      paramParcelable = this.dY;
      int i = ((Bundle)localObject1).getInt("android:menu:checked", 0);
      Object localObject2;
      if (i != 0)
      {
        paramParcelable.ek = true;
        localIterator = paramParcelable.eh.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (d)localIterator.next();
          if ((localObject2 instanceof f))
          {
            localObject2 = ((f)localObject2).en;
            if ((localObject2 != null) && (((h)localObject2).getItemId() == i)) {
              paramParcelable.d((h)localObject2);
            }
          }
        }
        paramParcelable.ek = false;
        paramParcelable.C();
      }
      localObject1 = ((Bundle)localObject1).getSparseParcelableArray("android:menu:action_views");
      Iterator localIterator = paramParcelable.eh.iterator();
      label225:
      while (localIterator.hasNext())
      {
        paramParcelable = (d)localIterator.next();
        if ((paramParcelable instanceof f))
        {
          localObject2 = ((f)paramParcelable).en;
          if (localObject2 != null) {}
          for (paramParcelable = ((h)localObject2).getActionView();; paramParcelable = null)
          {
            if (paramParcelable == null) {
              break label225;
            }
            paramParcelable.restoreHierarchyState((SparseArray)((SparseArray)localObject1).get(((h)localObject2).getItemId()));
            break;
          }
        }
      }
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.dT != null)
    {
      SparseArray localSparseArray = new SparseArray();
      this.dT.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    }
    if (this.dY != null) {
      localBundle.putBundle("android:menu:adapter", this.dY.D());
    }
    return localBundle;
  }
  
  private static final class a
    extends b.j
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  private final class b
    extends RecyclerView.a<b.j>
  {
    final ArrayList<b.d> eh = new ArrayList();
    private h ei;
    private ColorDrawable ej;
    boolean ek;
    
    public b()
    {
      C();
    }
    
    private void b(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        h localh = ((b.f)this.eh.get(paramInt1)).en;
        if (localh.getIcon() == null)
        {
          if (this.ej == null) {
            this.ej = new ColorDrawable(0);
          }
          localh.setIcon(this.ej);
        }
        paramInt1 += 1;
      }
    }
    
    final void C()
    {
      if (this.ek) {
        return;
      }
      this.ek = true;
      this.eh.clear();
      this.eh.add(new b.c());
      int k = -1;
      int i = 0;
      int j = 0;
      int i3 = b.this.dW.dz().size();
      int i1 = 0;
      while (i1 < i3)
      {
        h localh1 = (h)b.this.dW.dz().get(i1);
        if (localh1.isChecked()) {
          d(localh1);
        }
        if (localh1.isCheckable()) {
          localh1.E(false);
        }
        int m;
        int i2;
        int n;
        if (localh1.hasSubMenu())
        {
          SubMenu localSubMenu = localh1.getSubMenu();
          if (localSubMenu.hasVisibleItems())
          {
            if (i1 != 0) {
              this.eh.add(new b.e(b.this.ef, 0));
            }
            this.eh.add(new b.f(localh1));
            m = 0;
            int i4 = this.eh.size();
            int i5 = localSubMenu.size();
            i2 = 0;
            while (i2 < i5)
            {
              h localh2 = (h)localSubMenu.getItem(i2);
              n = m;
              if (localh2.isVisible())
              {
                n = m;
                if (m == 0)
                {
                  n = m;
                  if (localh2.getIcon() != null) {
                    n = 1;
                  }
                }
                if (localh2.isCheckable()) {
                  localh2.E(false);
                }
                if (localh1.isChecked()) {
                  d(localh1);
                }
                this.eh.add(new b.f(localh2));
              }
              i2 += 1;
              m = n;
            }
            if (m != 0) {
              b(i4, this.eh.size());
            }
          }
          m = j;
          j = k;
          k = i;
          i = m;
          i1 += 1;
          m = j;
          j = i;
          i = k;
          k = m;
        }
        else
        {
          n = localh1.getGroupId();
          if (n != k)
          {
            i2 = this.eh.size();
            if (localh1.getIcon() != null)
            {
              i = 1;
              label402:
              k = i;
              m = i2;
              if (i1 == 0) {
                break label544;
              }
              this.eh.add(new b.e(b.this.ef, b.this.ef));
              j = i;
            }
          }
          for (i = i2 + 1;; i = m)
          {
            if ((j != 0) && (localh1.getIcon() == null)) {
              localh1.setIcon(17170445);
            }
            this.eh.add(new b.f(localh1));
            k = i;
            m = n;
            i = j;
            j = m;
            break;
            i = 0;
            break label402;
            k = j;
            m = i;
            if (j == 0)
            {
              k = j;
              m = i;
              if (localh1.getIcon() != null)
              {
                k = 1;
                b(i, this.eh.size());
                m = i;
              }
            }
            label544:
            j = k;
          }
        }
      }
      this.ek = false;
    }
    
    public final Bundle D()
    {
      Bundle localBundle = new Bundle();
      if (this.ei != null) {
        localBundle.putInt("android:menu:checked", this.ei.getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = this.eh.iterator();
      label129:
      while (localIterator.hasNext())
      {
        Object localObject = (b.d)localIterator.next();
        if ((localObject instanceof b.f))
        {
          h localh = ((b.f)localObject).en;
          if (localh != null) {}
          for (localObject = localh.getActionView();; localObject = null)
          {
            if (localObject == null) {
              break label129;
            }
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            ((View)localObject).saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localh.getItemId(), localParcelableSparseArray);
            break;
          }
        }
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }
    
    public final void d(h paramh)
    {
      if ((this.ei == paramh) || (!paramh.isCheckable())) {
        return;
      }
      if (this.ei != null) {
        this.ei.setChecked(false);
      }
      this.ei = paramh;
      paramh.setChecked(true);
    }
    
    public final int getItemCount()
    {
      return this.eh.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      b.d locald = (b.d)this.eh.get(paramInt);
      if ((locald instanceof b.e)) {
        return 2;
      }
      if ((locald instanceof b.c)) {
        return 3;
      }
      if ((locald instanceof b.f))
      {
        if (((b.f)locald).en.hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
  }
  
  private static final class c
    implements b.d
  {}
  
  private static abstract interface d {}
  
  private static final class e
    implements b.d
  {
    final int el;
    final int em;
    
    public e(int paramInt1, int paramInt2)
    {
      this.el = paramInt1;
      this.em = paramInt2;
    }
  }
  
  private static final class f
    implements b.d
  {
    final h en;
    
    public f(h paramh)
    {
      this.en = paramh;
    }
  }
  
  private static final class g
    extends b.j
  {
    public g(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.abf.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static final class h
    extends b.j
  {
    public h(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static final class i
    extends b.j
  {
    public i(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class j
    extends RecyclerView.t
  {
    public j(View paramView)
    {
      super();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */