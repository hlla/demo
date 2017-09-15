package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.cache.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b
{
  private HashMap<String, c> hEr;
  
  public b()
  {
    GMTrace.i(3539321487360L, 26370);
    this.hEr = new HashMap();
    GMTrace.o(3539321487360L, 26370);
  }
  
  public static void f(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(3539589922816L, 26372);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.CdnImageService", "push fail, key is null");
      GMTrace.o(3539589922816L, 26372);
      return;
    }
    a.a.a("local_cdn_img_cache", paramString, paramBitmap);
    GMTrace.o(3539589922816L, 26372);
  }
  
  public static Bitmap gS(String paramString)
  {
    GMTrace.i(3539724140544L, 26373);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.CdnImageService", "get fail, key is null");
      GMTrace.o(3539724140544L, 26373);
      return null;
    }
    paramString = (Bitmap)a.a.x("local_cdn_img_cache", paramString);
    GMTrace.o(3539724140544L, 26373);
    return paramString;
  }
  
  public final void a(String paramString, c paramc)
  {
    GMTrace.i(3539992576000L, 26375);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.CdnImageService", "do load fail, url is empty");
      GMTrace.o(3539992576000L, 26375);
      return;
    }
    Bitmap localBitmap = gS(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      v.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[] { paramString });
      if (paramc != null) {
        paramc.l(localBitmap);
      }
      GMTrace.o(3539992576000L, 26375);
      return;
    }
    if (localBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!this.hEr.containsKey(paramString)) {
        break;
      }
      v.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      GMTrace.o(3539992576000L, 26375);
      return;
    }
    this.hEr.put(paramString, paramc);
    e.post(new b(paramString, this.hEr), "CdnImageService_download");
    GMTrace.o(3539992576000L, 26375);
  }
  
  protected final void finalize()
  {
    GMTrace.i(3539455705088L, 26371);
    super.finalize();
    GMTrace.o(3539455705088L, 26371);
  }
  
  public final void jn(String paramString)
  {
    GMTrace.i(3539858358272L, 26374);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      GMTrace.o(3539858358272L, 26374);
      return;
    }
    this.hEr.remove(paramString);
    GMTrace.o(3539858358272L, 26374);
  }
  
  static final class a
    implements Runnable
  {
    private HashMap<String, b.c> hEr;
    private Bitmap hEs;
    private String url;
    
    public a(String paramString, Bitmap paramBitmap, HashMap<String, b.c> paramHashMap)
    {
      GMTrace.i(3504559095808L, 26111);
      this.url = paramString;
      this.hEs = paramBitmap;
      this.hEr = paramHashMap;
      GMTrace.o(3504559095808L, 26111);
    }
    
    public final void run()
    {
      GMTrace.i(3504693313536L, 26112);
      n.GS();
      b.f(this.url, this.hEs);
      if (this.hEr != null)
      {
        localObject = (b.c)this.hEr.remove(this.url);
        if (localObject != null) {
          ((b.c)localObject).l(this.hEs);
        }
      }
      if (this.url == null) {}
      for (Object localObject = "null";; localObject = this.url)
      {
        v.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", new Object[] { localObject });
        GMTrace.o(3504693313536L, 26112);
        return;
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    private HashMap<String, b.c> hEr;
    private String url;
    
    b(String paramString, HashMap<String, b.c> paramHashMap)
    {
      GMTrace.i(3542274277376L, 26392);
      this.url = paramString;
      this.hEr = paramHashMap;
      GMTrace.o(3542274277376L, 26392);
    }
    
    public final void run()
    {
      GMTrace.i(3542408495104L, 26393);
      Object localObject1 = bf.Qb(this.url);
      if (localObject1 == null)
      {
        v.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
        GMTrace.o(3542408495104L, 26393);
        return;
      }
      try
      {
        localObject1 = d.bd((byte[])localObject1);
        v.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
        ae.v(new b.a(this.url, (Bitmap)localObject1, this.hEr));
        GMTrace.o(3542408495104L, 26393);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[] { this.url, localException.getLocalizedMessage() });
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void l(Bitmap paramBitmap);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */