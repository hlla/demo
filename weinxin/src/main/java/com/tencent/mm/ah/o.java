package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  implements b.c
{
  List<c> hHD;
  public c hHE;
  public boolean hHF;
  
  public o()
  {
    GMTrace.i(3528181415936L, 26287);
    this.hHD = new LinkedList();
    this.hHE = null;
    this.hHF = false;
    GMTrace.o(3528181415936L, 26287);
  }
  
  public static String jD(String paramString)
  {
    GMTrace.i(3528584069120L, 26290);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (bf.mA(str))
      {
        v.e("MicroMsg.UrlImageCacheService", "encode result is null: " + paramString);
        GMTrace.o(3528584069120L, 26290);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      v.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: " + paramString);
      GMTrace.o(3528584069120L, 26290);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(e.gSo);
    int j = localUnsupportedEncodingException.length();
    int i = 0;
    while (i < j)
    {
      paramString.append('/');
      if (i + 20 < j)
      {
        paramString.append(localUnsupportedEncodingException.substring(i, i + 20));
        i += 20;
      }
      else
      {
        paramString.append(localUnsupportedEncodingException.substring(i, j));
        i = j;
      }
    }
    paramString = paramString.toString();
    GMTrace.o(3528584069120L, 26290);
    return paramString;
  }
  
  public final void Ha()
  {
    GMTrace.i(3528449851392L, 26289);
    for (;;)
    {
      if ((this.hHE != null) || (this.hHD.size() == 0))
      {
        v.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        GMTrace.o(3528449851392L, 26289);
        return;
      }
      this.hHE = ((c)this.hHD.get(0));
      this.hHD.remove(0);
      this.hHF = false;
      n.GS();
      Bitmap localBitmap = b.gS(this.hHE.url);
      if (localBitmap == null) {
        break;
      }
      v.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.hHE.url);
      if (!this.hHF) {
        this.hHE.hHH.g(this.hHE.url, localBitmap);
      }
      this.hHE = null;
    }
    new AsyncTask() {}.execute(new String[] { this.hHE.url });
    GMTrace.o(3528449851392L, 26289);
  }
  
  public final void a(String paramString, a parama)
  {
    GMTrace.i(3528315633664L, 26288);
    if ((bf.mA(paramString)) || (parama == null))
    {
      v.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      GMTrace.o(3528315633664L, 26288);
      return;
    }
    if ((this.hHE != null) && (this.hHE.url.equals(paramString)) && (this.hHE.hHH == parama))
    {
      v.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      GMTrace.o(3528315633664L, 26288);
      return;
    }
    Iterator localIterator = this.hHD.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.hHH == parama))
      {
        v.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        GMTrace.o(3528315633664L, 26288);
        return;
      }
    }
    this.hHD.add(new c(paramString, parama));
    Ha();
    GMTrace.o(3528315633664L, 26288);
  }
  
  public final void l(Bitmap paramBitmap)
  {
    GMTrace.i(3528718286848L, 26291);
    if (paramBitmap == null)
    {
      v.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.hHE.url);
      this.hHE = null;
      Ha();
      GMTrace.o(3528718286848L, 26291);
      return;
    }
    v.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.hHE.url });
    new AsyncTask()new b
    {
      private static Integer a(o.b... paramAnonymousVarArgs)
      {
        GMTrace.i(3512880594944L, 26173);
        if ((paramAnonymousVarArgs.length == 0) || (bf.mA(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
        {
          v.e("MicroMsg.UrlImageCacheService", "nothing to save");
          GMTrace.o(3512880594944L, 26173);
          return null;
        }
        try
        {
          d.a(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
          GMTrace.o(3512880594944L, 26173);
          return null;
        }
        catch (IOException paramAnonymousVarArgs)
        {
          for (;;)
          {
            v.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramAnonymousVarArgs.toString());
          }
        }
      }
    }.execute(new b[] { new b(jD(this.hHE.url), paramBitmap) });
    if (!this.hHF)
    {
      n.GS();
      b.f(this.hHE.url, paramBitmap);
      this.hHE.hHH.g(this.hHE.url, paramBitmap);
    }
    this.hHE = null;
    Ha();
    GMTrace.o(3528718286848L, 26291);
  }
  
  public static abstract interface a
  {
    public abstract void g(String paramString, Bitmap paramBitmap);
  }
  
  private static final class b
  {
    public Bitmap bitmap;
    public String path;
    
    public b(String paramString, Bitmap paramBitmap)
    {
      GMTrace.i(3541468971008L, 26386);
      this.path = paramString;
      this.bitmap = paramBitmap;
      GMTrace.o(3541468971008L, 26386);
    }
  }
  
  private static final class c
  {
    public o.a hHH;
    public String url;
    
    public c(String paramString, o.a parama)
    {
      GMTrace.i(3519054610432L, 26219);
      this.url = paramString;
      this.hHH = parama;
      GMTrace.o(3519054610432L, 26219);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */