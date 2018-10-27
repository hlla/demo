package android.support.v7.widget;

import android.support.v4.view.ac;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fz
{
  private static final List a = ;
  private int b = 0;
  public final View c;
  public int d;
  public boolean e = false;
  public long f = -1L;
  public int g = -1;
  public WeakReference h;
  public int i = -1;
  public RecyclerView j;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public fp n = null;
  public fz o = null;
  public fz p = null;
  public int q = 0;
  private List r = null;
  private List s = null;
  
  public fz(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.c = paramView;
  }
  
  final void a()
  {
    this.i = -1;
    this.m = -1;
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    this.d = (this.d & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    if (this.i == -1) {
      this.i = this.l;
    }
    if (this.m == -1) {
      this.m = this.l;
    }
    if (!paramBoolean) {}
    for (;;)
    {
      this.l += paramInt;
      if (this.c.getLayoutParams() != null) {
        ((fj)this.c.getLayoutParams()).b = true;
      }
      return;
      this.m += paramInt;
    }
  }
  
  final void a(fp paramfp, boolean paramBoolean)
  {
    this.n = paramfp;
    this.e = paramBoolean;
  }
  
  final void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((this.d & 0x400) == 0)
      {
        if (this.r == null)
        {
          this.r = new ArrayList();
          this.s = Collections.unmodifiableList(this.r);
        }
        this.r.add(paramObject);
      }
      return;
    }
    c(1024);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = this.b - 1;; i1 = this.b + 1)
    {
      this.b = i1;
      i1 = this.b;
      StringBuilder localStringBuilder;
      if (i1 < 0)
      {
        this.b = 0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        localStringBuilder.append(this);
      }
      do
      {
        Log.e("View", localStringBuilder.toString());
        return;
        while (paramBoolean) {
          if ((paramBoolean) && (i1 == 0))
          {
            this.d &= 0xFFFFFFEF;
            return;
          }
        }
      } while (i1 != 1);
      this.d |= 0x10;
      return;
    }
  }
  
  final boolean b()
  {
    return (this.d & 0x80) != 0;
  }
  
  final boolean b(int paramInt)
  {
    return (this.d & paramInt) != 0;
  }
  
  public final int c()
  {
    int i2 = this.m;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.l;
    }
    return i1;
  }
  
  final void c(int paramInt)
  {
    this.d |= paramInt;
  }
  
  public final int d()
  {
    RecyclerView localRecyclerView = this.j;
    if (localRecyclerView != null) {
      return localRecyclerView.c(this);
    }
    return -1;
  }
  
  final boolean e()
  {
    return this.n != null;
  }
  
  final void f()
  {
    this.n.b(this);
  }
  
  final boolean g()
  {
    return (this.d & 0x20) != 0;
  }
  
  final void h()
  {
    this.d &= 0xFFFFFFDF;
  }
  
  final void i()
  {
    this.d &= 0xFEFF;
  }
  
  final boolean j()
  {
    return (this.d & 0x4) != 0;
  }
  
  public final boolean k()
  {
    return (this.d & 0x2) != 0;
  }
  
  public final boolean l()
  {
    return (this.d & 0x8) != 0;
  }
  
  final boolean m()
  {
    return (this.d & 0x100) != 0;
  }
  
  final void n()
  {
    List localList = this.r;
    if (localList != null) {
      localList.clear();
    }
    this.d &= 0xFBFF;
  }
  
  final List o()
  {
    if ((this.d & 0x400) == 0)
    {
      List localList = this.r;
      if ((localList == null) || (localList.size() == 0)) {
        return a;
      }
      return this.s;
    }
    return a;
  }
  
  final void p()
  {
    this.d = 0;
    this.l = -1;
    this.i = -1;
    this.f = -1L;
    this.m = -1;
    this.b = 0;
    this.o = null;
    this.p = null;
    n();
    this.q = 0;
    this.k = -1;
    RecyclerView.b(this);
  }
  
  public final boolean q()
  {
    return ((this.d & 0x10) == 0) && (!ac.d(this.c));
  }
  
  public final boolean r()
  {
    return (this.d & 0x2) != 0;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ViewHolder{");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(" position=");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append(" id=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(", oldPos=");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(", pLpos:");
    ((StringBuilder)localObject).append(this.m);
    StringBuilder localStringBuilder = new StringBuilder(((StringBuilder)localObject).toString());
    if (e())
    {
      localStringBuilder.append(" scrap ");
      if (this.e) {
        break label323;
      }
    }
    label323:
    for (localObject = "[attachedScrap]";; localObject = "[changeScrap]")
    {
      localStringBuilder.append((String)localObject);
      if (j()) {
        localStringBuilder.append(" invalid");
      }
      if ((this.d & 0x1) == 0) {
        localStringBuilder.append(" unbound");
      }
      if (k()) {
        localStringBuilder.append(" update");
      }
      if (l()) {
        localStringBuilder.append(" removed");
      }
      if (b()) {
        localStringBuilder.append(" ignored");
      }
      if (m()) {
        localStringBuilder.append(" tmpDetached");
      }
      if (!q())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" not recyclable(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(")");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if ((this.d & 0x200) != 0) {}
      for (;;)
      {
        localStringBuilder.append(" undefined adapter position");
        do
        {
          if (this.c.getParent() == null) {
            localStringBuilder.append(" no parent");
          }
          localStringBuilder.append("}");
          return localStringBuilder.toString();
        } while (!j());
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */