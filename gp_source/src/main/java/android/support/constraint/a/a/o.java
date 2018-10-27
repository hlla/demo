package android.support.constraint.a.a;

import android.support.constraint.a.c;
import java.util.ArrayList;

public class o
  extends f
{
  public ArrayList af = new ArrayList();
  
  public void a()
  {
    this.af.clear();
    super.a();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    paramInt2 = this.af.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((f)this.af.get(paramInt1)).a(this.aa + this.H, this.ab + this.I);
      paramInt1 += 1;
    }
  }
  
  public final void a(f paramf)
  {
    this.af.remove(paramf);
    paramf.J = null;
  }
  
  public final void a(c paramc)
  {
    super.a(paramc);
    int j = this.af.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.af.get(i)).a(paramc);
      i += 1;
    }
  }
  
  public final void m()
  {
    super.m();
    Object localObject = this.af;
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      if (i < j)
      {
        localObject = (f)this.af.get(i);
        ((f)localObject).a(g(), h());
        if ((localObject instanceof i)) {}
        for (;;)
        {
          i += 1;
          break;
          ((f)localObject).m();
        }
      }
    }
  }
  
  public void o()
  {
    m();
    Object localObject = this.af;
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      if (i < j)
      {
        localObject = (f)this.af.get(i);
        if (!(localObject instanceof o)) {}
        for (;;)
        {
          i += 1;
          break;
          ((o)localObject).o();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */