package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static final a Aj = new d();
  public final Object Ak;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      Aj = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      Aj = new b();
      return;
    }
  }
  
  public c()
  {
    this.Ak = Aj.a(this);
  }
  
  public c(Object paramObject)
  {
    this.Ak = paramObject;
  }
  
  public static b cb()
  {
    return null;
  }
  
  public static boolean cc()
  {
    return false;
  }
  
  public static List<b> cd()
  {
    return null;
  }
  
  public static b ce()
  {
    return null;
  }
  
  static abstract interface a
  {
    public abstract Object a(c paramc);
  }
  
  static final class b
    extends c.d
  {
    public final Object a(final c paramc)
    {
      new d.1(new d.a()
      {
        public final boolean cc()
        {
          return c.cc();
        }
        
        public final List<Object> cd()
        {
          c.cd();
          new ArrayList();
          throw new NullPointerException();
        }
        
        public final Object cf()
        {
          c.cb();
          return null;
        }
      });
    }
  }
  
  static final class c
    extends c.d
  {
    public final Object a(final c paramc)
    {
      new e.1(new e.a()
      {
        public final boolean cc()
        {
          return c.cc();
        }
        
        public final List<Object> cd()
        {
          c.cd();
          new ArrayList();
          throw new NullPointerException();
        }
        
        public final Object cf()
        {
          c.cb();
          return null;
        }
        
        public final Object cg()
        {
          c.ce();
          return null;
        }
      });
    }
  }
  
  static class d
    implements c.a
  {
    public Object a(c paramc)
    {
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */