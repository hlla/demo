package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  implements b
{
  private static e fxN;
  URISpanHandlerSet fxO;
  ArrayList<URISpanHandlerSet.BaseUriSpanHandler> fxP;
  ArrayList<URISpanHandlerSet.BaseUriSpanHandler> fxQ;
  ArrayList<URISpanHandlerSet.BaseUriSpanHandler> fxR;
  Context mContext;
  
  static
  {
    GMTrace.i(13011603423232L, 96944);
    fxN = null;
    GMTrace.o(13011603423232L, 96944);
  }
  
  private e()
  {
    GMTrace.i(13011066552320L, 96940);
    this.mContext = null;
    this.fxP = new ArrayList();
    this.fxQ = new ArrayList();
    this.fxR = new ArrayList();
    long l = bf.NA();
    v.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = aa.getContext();
    this.fxO = new URISpanHandlerSet(this.mContext);
    Class[] arrayOfClass = URISpanHandlerSet.class.getDeclaredClasses();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        if ((localClass != null) && (localClass.getSuperclass() != null) && (localClass.isAnnotationPresent(URISpanHandlerSet.a.class)) && (localClass.getSuperclass().getName().equals(URISpanHandlerSet.BaseUriSpanHandler.class.getName())))
        {
          for (;;)
          {
            Object localObject2;
            try
            {
              Object localObject1 = (URISpanHandlerSet.a)localClass.getAnnotation(URISpanHandlerSet.a.class);
              localObject2 = localClass.getDeclaredConstructor(new Class[] { URISpanHandlerSet.class });
              if (localObject2 == null) {
                break;
              }
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.fxO }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).oO();
              if (localObject1 == URISpanHandlerSet.PRIORITY.LOW)
              {
                this.fxR.add(localObject2);
                v.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
                break label408;
              }
              if (localObject1 == URISpanHandlerSet.PRIORITY.NORMAL)
              {
                this.fxQ.add(localObject2);
                continue;
              }
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
            }
            catch (Exception localException)
            {
              v.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              v.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
            }
            this.fxP.add(localObject2);
          }
          v.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        v.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(bf.NA() - l) });
        GMTrace.o(13011066552320L, 96940);
        return;
      }
      label408:
      i += 1;
    }
  }
  
  private static boolean b(int[] paramArrayOfInt, int paramInt)
  {
    GMTrace.i(13011469205504L, 96943);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt)
      {
        GMTrace.o(13011469205504L, 96943);
        return true;
      }
      i += 1;
    }
    GMTrace.o(13011469205504L, 96943);
    return false;
  }
  
  public static e oM()
  {
    GMTrace.i(13010932334592L, 96939);
    if (fxN == null) {
      fxN = new e();
    }
    e locale = fxN;
    GMTrace.o(13010932334592L, 96939);
    return locale;
  }
  
  public final boolean a(Context paramContext, i parami, com.tencent.mm.pluginsdk.ui.d.e parame)
  {
    GMTrace.i(13011334987776L, 96942);
    if (parami == null)
    {
      v.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      GMTrace.o(13011334987776L, 96942);
      return false;
    }
    int i = parami.type;
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.fxP.size()), Integer.valueOf(this.fxQ.size()), Integer.valueOf(this.fxR.size()) });
      if (paramContext != null) {
        break;
      }
      v.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.fxO.mContext = null;
      GMTrace.o(13011334987776L, 96942);
      return false;
    }
    this.mContext = paramContext;
    this.fxO.mContext = this.mContext;
    paramContext = this.fxP.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((b(localBaseUriSpanHandler.oN(), parami.type)) && (localBaseUriSpanHandler.a(parami, parame)))
      {
        v.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fxO.mContext = null;
        GMTrace.o(13011334987776L, 96942);
        return true;
      }
    }
    paramContext = this.fxQ.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((b(localBaseUriSpanHandler.oN(), parami.type)) && (localBaseUriSpanHandler.a(parami, parame)))
      {
        v.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fxO.mContext = null;
        GMTrace.o(13011334987776L, 96942);
        return true;
      }
    }
    paramContext = this.fxR.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((b(localBaseUriSpanHandler.oN(), parami.type)) && (localBaseUriSpanHandler.a(parami, parame)))
      {
        v.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fxO.mContext = null;
        GMTrace.o(13011334987776L, 96942);
        return true;
      }
    }
    this.mContext = null;
    this.fxO.mContext = null;
    v.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    GMTrace.o(13011334987776L, 96942);
    return false;
  }
  
  public final i q(Context paramContext, String paramString)
  {
    GMTrace.i(13011200770048L, 96941);
    v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.fxP.size()), Integer.valueOf(this.fxQ.size()), Integer.valueOf(this.fxR.size()) });
    if (paramContext == null)
    {
      v.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.fxO.mContext = null;
      GMTrace.o(13011200770048L, 96941);
      return null;
    }
    this.mContext = paramContext;
    this.fxO.mContext = this.mContext;
    if (bf.mA(paramString))
    {
      v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.fxO.mContext = null;
      GMTrace.o(13011200770048L, 96941);
      return null;
    }
    paramContext = this.fxP.iterator();
    i locali;
    while (paramContext.hasNext())
    {
      locali = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).bv(paramString);
      if (locali != null)
      {
        v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(locali.type) });
        this.mContext = null;
        this.fxO.mContext = null;
        GMTrace.o(13011200770048L, 96941);
        return locali;
      }
    }
    paramContext = this.fxQ.iterator();
    while (paramContext.hasNext())
    {
      locali = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).bv(paramString);
      if (locali != null)
      {
        v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(locali.type) });
        this.mContext = null;
        this.fxO.mContext = null;
        GMTrace.o(13011200770048L, 96941);
        return locali;
      }
    }
    paramContext = this.fxR.iterator();
    while (paramContext.hasNext())
    {
      locali = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).bv(paramString);
      if (locali != null)
      {
        v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(locali.type) });
        this.mContext = null;
        this.fxO.mContext = null;
        GMTrace.o(13011200770048L, 96941);
        return locali;
      }
    }
    this.mContext = null;
    this.fxO.mContext = null;
    v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    GMTrace.o(13011200770048L, 96941);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/plugin/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */