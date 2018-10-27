package b.b.b.a;

import b.b.b.e;
import com.google.common.a.ba;
import com.google.common.a.bc;
import com.google.common.a.be;
import com.google.common.a.bf;
import com.google.common.a.bw;
import com.google.common.a.eq;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

final class d
  extends e
{
  private final be b;
  
  d(be parambe)
  {
    this.b = parambe;
  }
  
  public final b.b.b.a a(b.b.b.d paramd)
  {
    bf localbf = be.f();
    eq localeq = (eq)this.b.iterator();
    while (localeq.hasNext())
    {
      Object localObject = (e)localeq.next();
      try
      {
        b.b.b.a locala = ((e)localObject).a(paramd);
        if (locala != null) {
          localbf.b(locala);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        String str = String.valueOf(paramd);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 100 + String.valueOf(str).length());
        localStringBuilder.append("RuntimeException while calling ProductionComponentMonitor.producerMonitorFor on monitor ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" with token ");
        localStringBuilder.append(str);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logProducerMonitorForException", localStringBuilder.toString(), localRuntimeException);
      }
    }
    paramd = localbf.a();
    if (!paramd.isEmpty())
    {
      if (paramd.size() == 1) {
        return new f((b.b.b.a)bw.b(paramd));
      }
      return new c(paramd);
    }
    return b.b.b.a.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */