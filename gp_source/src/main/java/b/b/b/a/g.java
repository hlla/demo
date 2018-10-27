package b.b.b.a;

import b.b.b.d;
import b.b.b.e;
import java.util.logging.Level;
import java.util.logging.Logger;

final class g
  extends e
{
  private final e b;
  
  g(e parame)
  {
    this.b = parame;
  }
  
  public final b.b.b.a a(d paramd)
  {
    try
    {
      b.b.b.a locala = this.b.a(paramd);
      if (locala != null) {
        return new f(locala);
      }
      locala = b.b.b.a.a;
      return locala;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = this.b;
      Logger localLogger = a.a;
      Level localLevel = Level.SEVERE;
      localObject = String.valueOf(localObject);
      paramd = String.valueOf(paramd);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 100 + String.valueOf(paramd).length());
      localStringBuilder.append("RuntimeException while calling ProductionComponentMonitor.producerMonitorFor on monitor ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" with token ");
      localStringBuilder.append(paramd);
      localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorForException", localStringBuilder.toString(), localRuntimeException);
    }
    return b.b.b.a.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */