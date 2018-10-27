package b.b.a;

import b.a.i;
import b.b.b.d;
import b.b.b.e;
import com.google.common.util.concurrent.al;
import com.google.common.util.concurrent.p;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Executor;

public abstract class b
  extends a
  implements s, Executor
{
  private final e.a.a a;
  private volatile b.b.b.a b = null;
  private final e.a.a c;
  private final d d;
  
  public b(e.a.a parama1, d paramd, e.a.a parama2)
  {
    this.c = ((e.a.a)i.a(parama1));
    this.d = paramd;
    this.a = ((e.a.a)i.a(parama2));
  }
  
  public abstract al a();
  
  @Deprecated
  public final al a(Object paramObject)
  {
    this.b.c();
    try
    {
      paramObject = b();
      return (al)paramObject;
    }
    finally
    {
      this.b.d();
    }
  }
  
  public abstract al b();
  
  protected final al c()
  {
    this.b = ((e)this.c.a()).a(this.d);
    this.b.a();
    al localal = p.a(a(), this, this);
    this.b.a(localal);
    return localal;
  }
  
  @Deprecated
  public final void execute(Runnable paramRunnable)
  {
    this.b.b();
    ((Executor)this.a.a()).execute(paramRunnable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */