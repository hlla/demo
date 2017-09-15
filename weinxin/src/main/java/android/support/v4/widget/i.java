package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i
{
  private static final c Cp = new a();
  private Object Co;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Cp = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      Cp = new b();
      return;
    }
  }
  
  public i(Context paramContext)
  {
    this.Co = Cp.m(paramContext);
  }
  
  public final boolean ag(int paramInt)
  {
    return Cp.l(this.Co, paramInt);
  }
  
  public final boolean cr()
  {
    return Cp.J(this.Co);
  }
  
  public final boolean draw(Canvas paramCanvas)
  {
    return Cp.a(this.Co, paramCanvas);
  }
  
  public final void finish()
  {
    Cp.I(this.Co);
  }
  
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    return Cp.a(this.Co, paramFloat1, paramFloat2);
  }
  
  public final boolean isFinished()
  {
    return Cp.H(this.Co);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    Cp.a(this.Co, paramInt1, paramInt2);
  }
  
  public final boolean u(float paramFloat)
  {
    return Cp.a(this.Co, paramFloat);
  }
  
  static final class a
    implements i.c
  {
    public final boolean H(Object paramObject)
    {
      return true;
    }
    
    public final void I(Object paramObject) {}
    
    public final boolean J(Object paramObject)
    {
      return false;
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2) {}
    
    public final boolean a(Object paramObject, float paramFloat)
    {
      return false;
    }
    
    public final boolean a(Object paramObject, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public final boolean a(Object paramObject, Canvas paramCanvas)
    {
      return false;
    }
    
    public final boolean l(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public final Object m(Context paramContext)
    {
      return null;
    }
  }
  
  static class b
    implements i.c
  {
    public final boolean H(Object paramObject)
    {
      return ((EdgeEffect)paramObject).isFinished();
    }
    
    public final void I(Object paramObject)
    {
      ((EdgeEffect)paramObject).finish();
    }
    
    public final boolean J(Object paramObject)
    {
      paramObject = (EdgeEffect)paramObject;
      ((EdgeEffect)paramObject).onRelease();
      return ((EdgeEffect)paramObject).isFinished();
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2)
    {
      ((EdgeEffect)paramObject).setSize(paramInt1, paramInt2);
    }
    
    public final boolean a(Object paramObject, float paramFloat)
    {
      return j.a(paramObject, paramFloat);
    }
    
    public boolean a(Object paramObject, float paramFloat1, float paramFloat2)
    {
      return j.a(paramObject, paramFloat1);
    }
    
    public final boolean a(Object paramObject, Canvas paramCanvas)
    {
      return ((EdgeEffect)paramObject).draw(paramCanvas);
    }
    
    public final boolean l(Object paramObject, int paramInt)
    {
      ((EdgeEffect)paramObject).onAbsorb(paramInt);
      return true;
    }
    
    public final Object m(Context paramContext)
    {
      return new EdgeEffect(paramContext);
    }
  }
  
  static abstract interface c
  {
    public abstract boolean H(Object paramObject);
    
    public abstract void I(Object paramObject);
    
    public abstract boolean J(Object paramObject);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract boolean a(Object paramObject, float paramFloat);
    
    public abstract boolean a(Object paramObject, float paramFloat1, float paramFloat2);
    
    public abstract boolean a(Object paramObject, Canvas paramCanvas);
    
    public abstract boolean l(Object paramObject, int paramInt);
    
    public abstract Object m(Context paramContext);
  }
  
  static final class d
    extends i.b
  {
    public final boolean a(Object paramObject, float paramFloat1, float paramFloat2)
    {
      ((EdgeEffect)paramObject).onPull(paramFloat1, paramFloat2);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */