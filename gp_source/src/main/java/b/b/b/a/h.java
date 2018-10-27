package b.b.b.a;

import b.b.b.e;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h
  extends b.b.b.g
{
  private final b.b.b.g a;
  
  h(b.b.b.g paramg)
  {
    this.a = paramg;
  }
  
  public final e a(Object paramObject)
  {
    try
    {
      e locale = this.a.a(paramObject);
      if (locale != null) {
        return new g(locale);
      }
      locale = e.a;
      return locale;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.a;
      Logger localLogger = a.a;
      Level localLevel = Level.SEVERE;
      localObject = String.valueOf(localObject);
      paramObject = String.valueOf(paramObject);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 100 + String.valueOf(paramObject).length());
      localStringBuilder.append("RuntimeException while calling ProductionComponentMonitor.Factory.create on factory ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" with component ");
      localStringBuilder.append((String)paramObject);
      localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logCreateException", localStringBuilder.toString(), localRuntimeException);
    }
    return e.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */