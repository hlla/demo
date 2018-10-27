package android.support.v7.widget;

import android.support.v4.os.c;
import android.view.View;
import android.view.ViewGroup;

public abstract class eu
{
  public boolean a = false;
  public final ev b = new ev();
  
  public boolean Y_()
  {
    return false;
  }
  
  public abstract fz a(ViewGroup paramViewGroup, int paramInt);
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2, null);
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.b.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(RecyclerView paramRecyclerView) {}
  
  public final void a(ew paramew)
  {
    this.b.registerObserver(paramew);
  }
  
  public void a(fz paramfz) {}
  
  public abstract void a(fz paramfz, int paramInt);
  
  public long b(int paramInt)
  {
    return -1L;
  }
  
  public final fz b(ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      c.a("RV CreateView");
      paramViewGroup = a(paramViewGroup, paramInt);
      if (paramViewGroup.c.getParent() != null) {
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
    }
    finally
    {
      c.a();
    }
    paramViewGroup.g = paramInt;
    c.a();
    return paramViewGroup;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.b.c(paramInt1, paramInt2);
  }
  
  public void b(RecyclerView paramRecyclerView) {}
  
  public final void b(ew paramew)
  {
    this.b.unregisterObserver(paramew);
  }
  
  public final void b_(boolean paramBoolean)
  {
    if (!this.b.a())
    {
      this.a = paramBoolean;
      return;
    }
    throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
  }
  
  public abstract int c();
  
  public int c(int paramInt)
  {
    return 0;
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2);
  }
  
  public final void d(int paramInt)
  {
    this.b.a(paramInt, 1, null);
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    this.b.b(paramInt1, paramInt2);
  }
  
  public final void e(int paramInt)
  {
    this.b.b(paramInt, 1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */