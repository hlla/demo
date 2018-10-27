package android.support.f;

import android.os.IBinder;

final class bl
{
  private final IBinder a;
  
  bl(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bl)) && (((bl)paramObject).a.equals(this.a));
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */