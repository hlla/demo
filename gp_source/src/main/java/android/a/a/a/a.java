package android.a.a.a;

public class a
  extends e
{
  private static volatile a c;
  private e a = new d();
  private e b = this.a;
  
  static
  {
    new b();
    new c();
  }
  
  public static a a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new a();
      }
      return c;
    }
    finally {}
    return c;
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.b.a(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    this.b.b(paramRunnable);
  }
  
  public final boolean b()
  {
    return this.b.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */