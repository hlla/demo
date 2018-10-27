package b.b.b.a;

import b.b.b.g;
import com.google.common.a.bw;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a
{
  public static final Logger a = Logger.getLogger(a.class.getName());
  
  static
  {
    new b();
  }
  
  public static b.b.b.e a(e.a.a parama1, e.a.a parama2)
  {
    try
    {
      parama2 = (Collection)parama2.a();
      if (parama2.isEmpty()) {
        parama2 = g.d;
      }
      for (;;)
      {
        return parama2.a(parama1.a());
        if (parama2.size() == 1) {
          parama2 = new h((g)bw.b(parama2));
        } else {
          parama2 = new e(parama2);
        }
      }
      return b.b.b.e.a;
    }
    catch (RuntimeException parama1)
    {
      a.logp(Level.SEVERE, "dagger.producers.monitoring.internal.Monitors", "createMonitorForComponent", "RuntimeException while constructing monitor factories.", parama1);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */