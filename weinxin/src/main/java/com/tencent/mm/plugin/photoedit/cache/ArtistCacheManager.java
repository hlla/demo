package com.tencent.mm.plugin.photoedit.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager ojk;
  public static HashMap<String, a> ojl;
  private static HashSet<com.tencent.mm.plugin.photoedit.b.a> ojm;
  
  static
  {
    GMTrace.i(9976135286784L, 74328);
    ojl = new HashMap();
    ojm = new HashSet();
    GMTrace.o(9976135286784L, 74328);
  }
  
  public ArtistCacheManager()
  {
    GMTrace.i(9975329980416L, 74322);
    GMTrace.o(9975329980416L, 74322);
  }
  
  public static <T extends com.tencent.mm.plugin.photoedit.c.c> T a(String paramString, com.tencent.mm.plugin.photoedit.b.a parama)
  {
    GMTrace.i(9975598415872L, 74324);
    if (ojl.containsKey(paramString))
    {
      paramString = (a)ojl.get(paramString);
      if (paramString.ojo.containsKey(parama))
      {
        paramString = (com.tencent.mm.plugin.photoedit.c.c)paramString.ojo.get(parama);
        GMTrace.o(9975598415872L, 74324);
        return paramString;
      }
      v.e("MicroMsg.ArtistCacheManager.CacheFactory", "type:%s can't find this cache!", new Object[] { parama });
      GMTrace.o(9975598415872L, 74324);
      return null;
    }
    v.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains !");
    GMTrace.o(9975598415872L, 74324);
    return null;
  }
  
  public static ArtistCacheManager aRY()
  {
    GMTrace.i(9975464198144L, 74323);
    if (ojk == null) {
      ojk = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = ojk;
    GMTrace.o(9975464198144L, 74323);
    return localArtistCacheManager;
  }
  
  public static HashSet<com.tencent.mm.plugin.photoedit.b.a> aSa()
  {
    GMTrace.i(9976001069056L, 74327);
    HashSet localHashSet = ojm;
    GMTrace.o(9976001069056L, 74327);
    return localHashSet;
  }
  
  public final void aRZ()
  {
    GMTrace.i(9975866851328L, 74326);
    v.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator1 = ojl.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((a)((Map.Entry)localIterator1.next()).getValue()).ojo.entrySet().iterator();
      while (localIterator2.hasNext()) {
        ((com.tencent.mm.plugin.photoedit.c.c)((Map.Entry)localIterator2.next()).getValue()).onDestroy();
      }
    }
    ojm.clear();
    ojk = null;
    com.tencent.mm.sdk.f.e.bKi();
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        GMTrace.i(9976806375424L, 74333);
        Object localObject1 = com.tencent.mm.compatible.util.e.gSo;
        v.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", new Object[] { localObject1 });
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).listFiles();
          if (localObject1 != null)
          {
            int j = localObject1.length;
            while (i < j)
            {
              Object localObject2 = localObject1[i];
              if ((((File)localObject2).isFile()) && (!bf.mA(((File)localObject2).getName())) && (((File)localObject2).getName().startsWith("wx_photo_edit_"))) {
                ((File)localObject2).delete();
              }
              i += 1;
            }
          }
        }
        GMTrace.o(9976806375424L, 74333);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    GMTrace.o(9975866851328L, 74326);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(9975732633600L, 74325);
    v.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm..plugin.photoedit.action.clear"))) {
      aRZ();
    }
    GMTrace.o(9975732633600L, 74325);
  }
  
  public final class a
  {
    HashMap<com.tencent.mm.plugin.photoedit.b.a, com.tencent.mm.plugin.photoedit.c.c> ojo;
    
    public a()
    {
      GMTrace.i(9976269504512L, 74329);
      this.ojo = new HashMap();
      this.ojo.put(com.tencent.mm.plugin.photoedit.b.a.ohO, new c());
      ((com.tencent.mm.plugin.photoedit.c.c)this.ojo.get(com.tencent.mm.plugin.photoedit.b.a.ohO)).onCreate();
      this.ojo.put(com.tencent.mm.plugin.photoedit.b.a.ohN, new d());
      ((com.tencent.mm.plugin.photoedit.c.c)this.ojo.get(com.tencent.mm.plugin.photoedit.b.a.ohN)).onCreate();
      this.ojo.put(com.tencent.mm.plugin.photoedit.b.a.ohM, new b());
      ((com.tencent.mm.plugin.photoedit.c.c)this.ojo.get(com.tencent.mm.plugin.photoedit.b.a.ohM)).onCreate();
      this.ojo.put(com.tencent.mm.plugin.photoedit.b.a.ohP, new a());
      ((com.tencent.mm.plugin.photoedit.c.c)this.ojo.get(com.tencent.mm.plugin.photoedit.b.a.ohP)).onCreate();
      GMTrace.o(9976269504512L, 74329);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/cache/ArtistCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */