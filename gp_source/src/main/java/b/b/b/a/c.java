package b.b.b.a;

import com.google.common.a.ba;
import com.google.common.a.be;
import com.google.common.a.eq;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

final class c
  extends b.b.b.a
{
  private final be b;
  
  c(be parambe)
  {
    this.b = parambe;
  }
  
  public final void a()
  {
    eq localeq = (eq)this.b.iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.a)localeq.next();
      try
      {
        ((b.b.b.a)localObject).a();
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf("requested").length() + 59 + String.valueOf(localObject).length());
        localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
        localStringBuilder.append("requested");
        localStringBuilder.append(" on monitor ");
        localStringBuilder.append((String)localObject);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorMethodException", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void a(Object paramObject)
  {
    eq localeq = (eq)this.b.e().iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.a)localeq.next();
      try
      {
        ((b.b.b.a)localObject).a(paramObject);
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        String str = String.valueOf(paramObject);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf("succeeded").length() + 65 + String.valueOf(localObject).length() + String.valueOf(str).length());
        localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
        localStringBuilder.append("succeeded");
        localStringBuilder.append(" on monitor ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" with ");
        localStringBuilder.append(str);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorArgMethodException", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    eq localeq = (eq)this.b.e().iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.a)localeq.next();
      try
      {
        ((b.b.b.a)localObject).a(paramThrowable);
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        String str = String.valueOf(paramThrowable);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf("failed").length() + 65 + String.valueOf(localObject).length() + String.valueOf(str).length());
        localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
        localStringBuilder.append("failed");
        localStringBuilder.append(" on monitor ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" with ");
        localStringBuilder.append(str);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorArgMethodException", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void b()
  {
    eq localeq = (eq)this.b.iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.a)localeq.next();
      try
      {
        ((b.b.b.a)localObject).b();
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf("ready").length() + 59 + String.valueOf(localObject).length());
        localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
        localStringBuilder.append("ready");
        localStringBuilder.append(" on monitor ");
        localStringBuilder.append((String)localObject);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorMethodException", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void c()
  {
    eq localeq = (eq)this.b.iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.a)localeq.next();
      try
      {
        ((b.b.b.a)localObject).c();
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf("methodStarting").length() + 59 + String.valueOf(localObject).length());
        localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
        localStringBuilder.append("methodStarting");
        localStringBuilder.append(" on monitor ");
        localStringBuilder.append((String)localObject);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorMethodException", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void d()
  {
    eq localeq = (eq)this.b.e().iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.a)localeq.next();
      try
      {
        ((b.b.b.a)localObject).d();
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf("methodFinished").length() + 59 + String.valueOf(localObject).length());
        localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
        localStringBuilder.append("methodFinished");
        localStringBuilder.append(" on monitor ");
        localStringBuilder.append((String)localObject);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorMethodException", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */