package b.b.b.a;

import java.util.logging.Level;
import java.util.logging.Logger;

final class f
  extends b.b.b.a
{
  private final b.b.b.a b;
  
  f(b.b.b.a parama)
  {
    this.b = parama;
  }
  
  public final void a()
  {
    try
    {
      this.b.a();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
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
  
  public final void a(Object paramObject)
  {
    try
    {
      this.b.a(paramObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
      Logger localLogger = a.a;
      Level localLevel = Level.SEVERE;
      localObject = String.valueOf(localObject);
      paramObject = String.valueOf(paramObject);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf("succeeded").length() + 65 + String.valueOf(localObject).length() + String.valueOf(paramObject).length());
      localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
      localStringBuilder.append("succeeded");
      localStringBuilder.append(" on monitor ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" with ");
      localStringBuilder.append((String)paramObject);
      localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorArgMethodException", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    try
    {
      this.b.a(paramThrowable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
      Logger localLogger = a.a;
      Level localLevel = Level.SEVERE;
      localObject = String.valueOf(localObject);
      paramThrowable = String.valueOf(paramThrowable);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf("failed").length() + 65 + String.valueOf(localObject).length() + String.valueOf(paramThrowable).length());
      localStringBuilder.append("RuntimeException while calling ProducerMonitor.");
      localStringBuilder.append("failed");
      localStringBuilder.append(" on monitor ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" with ");
      localStringBuilder.append(paramThrowable);
      localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorArgMethodException", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  public final void b()
  {
    try
    {
      this.b.b();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
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
  
  public final void c()
  {
    try
    {
      this.b.c();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
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
  
  public final void d()
  {
    try
    {
      this.b.d();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */