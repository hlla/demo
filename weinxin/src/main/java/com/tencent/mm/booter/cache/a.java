package com.tencent.mm.booter.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.cache.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class a
  extends b.a
{
  public static a gKL;
  private final f<String, Bitmap> gKM;
  
  private a()
  {
    GMTrace.i(534723428352L, 3984);
    Context localContext = aa.getContext();
    if (com.tencent.mm.platformtools.a.a.values == null) {}
    try
    {
      com.tencent.mm.platformtools.a.a.values = q.Pk(bf.convertStreamToString(localContext.getAssets().open("profile.ini")));
      if (com.tencent.mm.platformtools.a.a.values == null)
      {
        localContext = null;
        this.gKM = new f(bf.getInt(localContext, 2000));
        GMTrace.o(534723428352L, 3984);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.ProfileUtil", "exception:%s", new Object[] { bf.g(localException) });
        continue;
        String str = (String)com.tencent.mm.platformtools.a.a.values.get("BACKGROUND_BITMAP_CACHE_LIMIT");
      }
    }
  }
  
  public static void destroy()
  {
    GMTrace.i(534991863808L, 3986);
    if (gKL == null)
    {
      GMTrace.o(534991863808L, 3986);
      return;
    }
    gKL.gKM.clear();
    GMTrace.o(534991863808L, 3986);
  }
  
  public static void prepare()
  {
    GMTrace.i(534857646080L, 3985);
    if (gKL == null) {
      gKL = new a();
    }
    GMTrace.o(534857646080L, 3985);
  }
  
  public final void a(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(535394516992L, 3989);
    v.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", new Object[] { paramString });
    this.gKM.k(paramString, paramBitmap);
    GMTrace.o(535394516992L, 3989);
  }
  
  public final MCacheItem cZ(String paramString)
  {
    GMTrace.i(535260299264L, 3988);
    v.v("MicroMsg.MMCacheImpl", "getting cache item: %s", new Object[] { paramString });
    GMTrace.o(535260299264L, 3988);
    return null;
  }
  
  public final void da(String paramString)
  {
    GMTrace.i(535528734720L, 3990);
    v.v("MicroMsg.MMCacheImpl", "setting cache item: %s", new Object[] { paramString });
    GMTrace.o(535528734720L, 3990);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    GMTrace.i(535126081536L, 3987);
    v.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", new Object[] { paramString });
    paramString = (Bitmap)this.gKM.get(paramString);
    GMTrace.o(535126081536L, 3987);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/cache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */