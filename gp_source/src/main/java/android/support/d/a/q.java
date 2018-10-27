package android.support.d.a;

import android.support.v4.a.b;
import android.support.v4.a.d;

class q
  extends p
{
  public int n;
  public d[] o = null;
  public String p;
  
  public q()
  {
    super((byte)0);
  }
  
  public q(q paramq)
  {
    super((byte)0);
    this.p = paramq.p;
    this.n = paramq.n;
    this.o = b.a(paramq.o);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public d[] getPathData()
  {
    return this.o;
  }
  
  public String getPathName()
  {
    return this.p;
  }
  
  public void setPathData(d[] paramArrayOfd)
  {
    if (!b.a(this.o, paramArrayOfd)) {
      this.o = b.a(paramArrayOfd);
    }
    for (;;)
    {
      return;
      d[] arrayOfd = this.o;
      int i = 0;
      while (i < paramArrayOfd.length)
      {
        arrayOfd[i].b = paramArrayOfd[i].b;
        int j = 0;
        for (;;)
        {
          float[] arrayOfFloat = paramArrayOfd[i].a;
          if (j >= arrayOfFloat.length) {
            break;
          }
          arrayOfd[i].a[j] = arrayOfFloat[j];
          j += 1;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */