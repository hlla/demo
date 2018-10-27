package b.b.a;

import com.google.common.util.concurrent.al;

public abstract class a
{
  private volatile al a = null;
  
  protected abstract al c();
  
  public final al d()
  {
    al localal3 = this.a;
    al localal1 = localal3;
    if (localal3 == null) {
      try
      {
        localal3 = this.a;
        localal1 = localal3;
        if (localal3 == null)
        {
          localal3 = c();
          this.a = localal3;
          localal1 = localal3;
          if (localal3 == null) {
            throw new NullPointerException("compute returned null");
          }
        }
      }
      finally {}
    }
    return localal2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */