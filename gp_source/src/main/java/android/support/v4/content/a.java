package android.support.v4.content;

import android.content.Context;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  extends h
{
  public volatile b a;
  public volatile b b;
  private final Executor c;
  
  public a(Context paramContext)
  {
    this(paramContext, o.b);
  }
  
  private a(Context paramContext, Executor paramExecutor)
  {
    super(paramContext);
    this.c = paramExecutor;
  }
  
  protected final void a()
  {
    super.a();
    b();
    this.b = new b(this);
    c();
  }
  
  final void a(b paramb, Object paramObject)
  {
    a(paramObject);
    if (this.a == paramb)
    {
      if (this.j) {
        m();
      }
      SystemClock.uptimeMillis();
      this.a = null;
      c();
    }
  }
  
  public void a(Object paramObject) {}
  
  @Deprecated
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.b);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.b.a);
    }
    if (this.a != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.a);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.a.a);
    }
  }
  
  protected final boolean b()
  {
    if (this.b != null)
    {
      if (!this.l) {
        this.f = true;
      }
      if (this.a != null)
      {
        bool = this.b.a;
        this.b = null;
      }
    }
    else
    {
      return false;
    }
    boolean bool = this.b.a;
    b localb = this.b;
    localb.c.set(true);
    bool = localb.d.cancel(false);
    if (bool)
    {
      this.a = this.b;
      e();
    }
    this.b = null;
    return bool;
  }
  
  final void c()
  {
    b localb;
    Executor localExecutor;
    if ((this.a == null) && (this.b != null))
    {
      boolean bool = this.b.a;
      localb = this.b;
      localExecutor = this.c;
      if (localb.e == v.b) {}
    }
    switch (s.a[localb.e.ordinal()])
    {
    default: 
      throw new IllegalStateException("We should never reach this state");
      localb.e = v.c;
      w localw = localb.g;
      localExecutor.execute(localb.d);
      return;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public abstract Object d();
  
  public void e() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */