package android.support.v4.g;

public final class t
  extends s
{
  private final Object a = new Object();
  
  public t(int paramInt)
  {
    super(paramInt);
  }
  
  public final Object a()
  {
    synchronized (this.a)
    {
      Object localObject2 = super.a();
      return localObject2;
    }
  }
  
  public final boolean a(Object paramObject)
  {
    synchronized (this.a)
    {
      boolean bool = super.a(paramObject);
      return bool;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */