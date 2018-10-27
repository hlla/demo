package b.b.b.a;

import com.google.common.a.ba;
import com.google.common.a.bc;
import com.google.common.a.be;
import com.google.common.a.bf;
import com.google.common.a.bw;
import com.google.common.a.eq;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

final class e
  extends b.b.b.g
{
  private final be a;
  
  e(Iterable paramIterable)
  {
    this.a = be.a(paramIterable);
  }
  
  public final b.b.b.e a(Object paramObject)
  {
    bf localbf = be.f();
    eq localeq = (eq)this.a.iterator();
    while (localeq.hasNext())
    {
      Object localObject = (b.b.b.g)localeq.next();
      try
      {
        b.b.b.e locale = ((b.b.b.g)localObject).a(paramObject);
        if (locale != null) {
          localbf.b(locale);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        Logger localLogger = a.a;
        Level localLevel = Level.SEVERE;
        localObject = String.valueOf(localObject);
        String str = String.valueOf(paramObject);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 100 + String.valueOf(str).length());
        localStringBuilder.append("RuntimeException while calling ProductionComponentMonitor.Factory.create on factory ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" with component ");
        localStringBuilder.append(str);
        localLogger.logp(localLevel, "dagger.producers.monitoring.internal.Monitors", "logCreateException", localStringBuilder.toString(), localRuntimeException);
      }
    }
    paramObject = localbf.a();
    if (!((be)paramObject).isEmpty())
    {
      if (((be)paramObject).size() == 1) {
        return new g((b.b.b.e)bw.b((Iterable)paramObject));
      }
      return new d((be)paramObject);
    }
    return b.b.b.e.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */