package com.google.common.util.concurrent;

import com.google.common.base.n;
import com.google.common.base.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class p
  extends k
  implements Runnable
{
  private Object e;
  private al f;
  
  p(al paramal, Object paramObject)
  {
    this.f = ((al)x.a(paramal));
    this.e = x.a(paramObject);
  }
  
  public static al a(al paramal, n paramn, Executor paramExecutor)
  {
    x.a(paramn);
    paramn = new r(paramal, paramn);
    paramal.a(paramn, aq.a(paramExecutor, paramn));
    return paramn;
  }
  
  public static al a(al paramal, s params, Executor paramExecutor)
  {
    x.a(paramExecutor);
    params = new q(paramal, params);
    paramal.a(params, aq.a(paramExecutor, params));
    return params;
  }
  
  abstract Object a(Object paramObject1, Object paramObject2);
  
  protected final String a()
  {
    Object localObject2 = this.f;
    Object localObject1 = this.e;
    String str2 = super.a();
    String str1 = "";
    if (localObject2 != null)
    {
      str1 = String.valueOf(localObject2);
      localObject2 = new StringBuilder(String.valueOf(str1).length() + 16);
      ((StringBuilder)localObject2).append("inputFuture=[");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("], ");
      str1 = ((StringBuilder)localObject2).toString();
    }
    if (localObject1 != null)
    {
      str2 = String.valueOf(localObject1);
      localObject1 = new StringBuilder(String.valueOf(str1).length() + 11 + String.valueOf(str2).length());
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("function=[");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("]");
      return ((StringBuilder)localObject1).toString();
    }
    if (str2 != null)
    {
      str1 = String.valueOf(str1);
      str2 = String.valueOf(str2);
      if (str2.length() == 0) {
        return new String(str1);
      }
      return str1.concat(str2);
    }
    return null;
  }
  
  abstract void a(Object paramObject);
  
  protected final void b()
  {
    a(this.f);
    this.f = null;
    this.e = null;
  }
  
  public final void run()
  {
    int i = 1;
    Object localObject3 = this.f;
    Object localObject1 = this.e;
    boolean bool2 = isCancelled();
    if (localObject3 == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        if ((i | bool1 | bool2) == 0) {
          this.f = null;
        }
        try
        {
          localObject3 = ad.a((Future)localObject3);
        }
        catch (CancellationException localCancellationException)
        {
          cancel(false);
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          a(localExecutionException.getCause());
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          a(localRuntimeException);
          return;
        }
        catch (Error localError)
        {
          a(localError);
          return;
        }
        try
        {
          localObject1 = a(localObject1, localObject3);
          this.e = null;
          a(localObject1);
          return;
        }
        finally
        {
          try
          {
            a(localThrowable);
            return;
          }
          finally
          {
            this.e = null;
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/common/util/concurrent/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */