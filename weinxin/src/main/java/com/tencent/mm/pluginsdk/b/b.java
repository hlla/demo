package com.tencent.mm.pluginsdk.b;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class b
{
  private static HashMap<String, a> sAd;
  private static final Pattern sAe;
  
  static
  {
    GMTrace.i(1269028618240L, 9455);
    sAd = new HashMap();
    sAe = Pattern.compile(" +");
    GMTrace.o(1269028618240L, 9455);
  }
  
  public static void B(String... paramVarArgs)
  {
    int i = 0;
    GMTrace.i(1268760182784L, 9453);
    synchronized (sAd)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        sAd.remove(str);
        v.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[] { str });
        i += 1;
      }
      GMTrace.o(1268760182784L, 9453);
      return;
    }
  }
  
  public static void a(a parama, String... paramVarArgs)
  {
    int i = 0;
    GMTrace.i(1268625965056L, 9452);
    synchronized (sAd)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        sAd.put(str, parama);
        v.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[] { str });
        i += 1;
      }
      GMTrace.o(1268625965056L, 9452);
      return;
    }
  }
  
  public static boolean aN(Context paramContext, String arg1)
  {
    GMTrace.i(1268894400512L, 9454);
    String[] arrayOfString = sAe.split(???);
    synchronized (sAd)
    {
      a locala = (a)sAd.get(arrayOfString[0]);
      if (locala != null)
      {
        v.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[] { arrayOfString[0] });
        boolean bool = locala.a(paramContext, arrayOfString);
        GMTrace.o(1268894400512L, 9454);
        return bool;
      }
    }
    GMTrace.o(1268894400512L, 9454);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */