package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class f
{
  public static final c Aq = new e();
  public final Object Ar;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      Aq = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      Aq = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      Aq = new a();
      return;
    }
  }
  
  public f(Object paramObject)
  {
    this.Ar = paramObject;
  }
  
  public static f ch()
  {
    return new f(Aq.ci());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (f)paramObject;
        if (this.Ar != null) {
          break;
        }
      } while (((f)paramObject).Ar == null);
      return false;
    } while (this.Ar.equals(((f)paramObject).Ar));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.Ar == null) {
      return 0;
    }
    return this.Ar.hashCode();
  }
  
  public final void setFromIndex(int paramInt)
  {
    Aq.e(this.Ar, paramInt);
  }
  
  public final void setItemCount(int paramInt)
  {
    Aq.f(this.Ar, paramInt);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    Aq.f(this.Ar, paramBoolean);
  }
  
  public final void setToIndex(int paramInt)
  {
    Aq.i(this.Ar, paramInt);
  }
  
  static class a
    extends f.e
  {
    public final Object ci()
    {
      return AccessibilityRecord.obtain();
    }
    
    public final void e(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setFromIndex(paramInt);
    }
    
    public final void f(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setItemCount(paramInt);
    }
    
    public final void f(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityRecord)paramObject).setScrollable(paramBoolean);
    }
    
    public final void g(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setScrollX(paramInt);
    }
    
    public final void h(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setScrollY(paramInt);
    }
    
    public final void i(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setToIndex(paramInt);
    }
  }
  
  static class b
    extends f.a
  {
    public final void j(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setMaxScrollX(paramInt);
    }
    
    public final void k(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setMaxScrollY(paramInt);
    }
  }
  
  public static abstract interface c
  {
    public abstract Object ci();
    
    public abstract void e(Object paramObject, int paramInt);
    
    public abstract void f(Object paramObject, int paramInt);
    
    public abstract void f(Object paramObject, boolean paramBoolean);
    
    public abstract void g(Object paramObject, int paramInt);
    
    public abstract void h(Object paramObject, int paramInt);
    
    public abstract void i(Object paramObject, int paramInt);
    
    public abstract void j(Object paramObject, int paramInt);
    
    public abstract void k(Object paramObject, int paramInt);
  }
  
  static final class d
    extends f.b
  {}
  
  static class e
    implements f.c
  {
    public Object ci()
    {
      return null;
    }
    
    public void e(Object paramObject, int paramInt) {}
    
    public void f(Object paramObject, int paramInt) {}
    
    public void f(Object paramObject, boolean paramBoolean) {}
    
    public void g(Object paramObject, int paramInt) {}
    
    public void h(Object paramObject, int paramInt) {}
    
    public void i(Object paramObject, int paramInt) {}
    
    public void j(Object paramObject, int paramInt) {}
    
    public void k(Object paramObject, int paramInt) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */