package com.tencent.mm.pluginsdk.k.a.d;

import android.annotation.SuppressLint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.k.a.b.b.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class p
{
  private static final HashMap<Integer, g> sFl;
  private static volatile List<g> sFm;
  
  static
  {
    GMTrace.i(861409378304L, 6418);
    Object localObject = new HashMap(2);
    sFl = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
    try
    {
      localObject = Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance();
      sFl.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (g)localObject);
      sFm = null;
      GMTrace.o(861409378304L, 6418);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", localException, "", new Object[0]);
      }
    }
  }
  
  public static Collection<g> bDz()
  {
    GMTrace.i(861275160576L, 6417);
    if (sFm != null)
    {
      localObject = sFm;
      GMTrace.o(861275160576L, 6417);
      return (Collection<g>)localObject;
    }
    Object localObject = new LinkedList();
    Iterator localIterator = sFl.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      g localg = (g)sFl.get(Integer.valueOf(i));
      if (localg != null) {
        ((LinkedList)localObject).add(localg);
      }
    }
    sFm = (List)localObject;
    GMTrace.o(861275160576L, 6417);
    return (Collection<g>)localObject;
  }
  
  public static void init()
  {
    GMTrace.i(861140942848L, 6416);
    GMTrace.o(861140942848L, 6416);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */