package com.tencent.mm.booter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.l.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class c
{
  private static c gJC;
  private final String[] columns;
  private Context ctx;
  public int gJB;
  private final HashMap<String, Object> values;
  
  private c(Context paramContext)
  {
    GMTrace.i(13461769682944L, 100298);
    this.gJB = -1;
    this.columns = new String[] { "_id", "key", "type", "value" };
    this.values = new HashMap();
    this.ctx = paramContext;
    Object localObject1 = paramContext.getContentResolver();
    try
    {
      localObject1 = ((ContentResolver)localObject1).query(a.a.CONTENT_URI, this.columns, null, null, null);
      if (localObject1 == null)
      {
        GMTrace.o(13461769682944L, 100298);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = null;
      }
      if (((Cursor)localObject2).getCount() <= 0)
      {
        ((Cursor)localObject2).close();
        GMTrace.o(13461769682944L, 100298);
        return;
      }
      if (!"18c867f0717aa67b2ab7347505ba07ed".equals(bf.j("com.tencent.mm.coolassist", paramContext)))
      {
        ((Cursor)localObject2).close();
        GMTrace.o(13461769682944L, 100298);
        return;
      }
      b.bIj();
      int i = ((Cursor)localObject2).getColumnIndex("key");
      int j = ((Cursor)localObject2).getColumnIndex("type");
      int k = ((Cursor)localObject2).getColumnIndex("value");
      while (((Cursor)localObject2).moveToNext())
      {
        paramContext = a.i(((Cursor)localObject2).getInt(j), ((Cursor)localObject2).getString(k));
        this.values.put(((Cursor)localObject2).getString(i), paramContext);
      }
      ((Cursor)localObject2).close();
      GMTrace.o(13461769682944L, 100298);
    }
  }
  
  public static c ao(Context paramContext)
  {
    GMTrace.i(13461635465216L, 100297);
    if (gJC == null) {
      gJC = new c(paramContext);
    }
    paramContext = gJC;
    GMTrace.o(13461635465216L, 100297);
    return paramContext;
  }
  
  public final void cR(String paramString)
  {
    boolean bool3 = true;
    GMTrace.i(13461903900672L, 100299);
    Integer localInteger = getInteger(".com.tencent.mm.debug.log.level");
    boolean bool4 = bf.b(cS(".com.tencent.mm.debug.log.append_mode"), false);
    boolean bool2;
    if ((bf.mA(getString(".com.tencent.mm.debug.log.mmlog"))) && (bf.b(cS(".com.tencent.mm.debug.test.uploadLog"), false)))
    {
      bool1 = true;
      if (bool1)
      {
        String str = getString(".com.tencent.mm.debug.log.tag.skey");
        if ((str != null) && (str.length() > 0)) {
          com.tencent.mars.xlog.Xlog.logDecryptor = new com.tencent.mm.sdk.platformtools.w(str);
        }
      }
      bool2 = this.ctx.getSharedPreferences("system_config_prefs", 4).getBoolean("first_launch_weixin", true);
      if (!"MM".equalsIgnoreCase(paramString)) {
        bool2 = false;
      }
      if (bool2) {
        break label199;
      }
      bool2 = true;
      label131:
      XLogSetup.keep_setupXLog(bool2, com.tencent.mm.storage.w.uxu, e.gSv, localInteger, Boolean.valueOf(bool4), Boolean.valueOf(bool1), paramString);
      v.yp(v.getLogLevel());
      if (bf.getInt(bf.ap(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
        break label204;
      }
    }
    label199:
    label204:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      b.jM(bool1);
      GMTrace.o(13461903900672L, 100299);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label131;
    }
  }
  
  public final Boolean cS(String paramString)
  {
    GMTrace.i(13462306553856L, 100302);
    Object localObject = this.values.get(paramString);
    if (localObject == null)
    {
      GMTrace.o(13462306553856L, 100302);
      return null;
    }
    if ((localObject instanceof Boolean))
    {
      v.d("MicroMsg.Debugger", "getBoolean(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Boolean)localObject;
      GMTrace.o(13462306553856L, 100302);
      return paramString;
    }
    GMTrace.o(13462306553856L, 100302);
    return null;
  }
  
  public final Integer getInteger(String paramString)
  {
    GMTrace.i(13462172336128L, 100301);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof Integer))
    {
      v.d("MicroMsg.Debugger", "getInteger(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Integer)localObject;
      GMTrace.o(13462172336128L, 100301);
      return paramString;
    }
    GMTrace.o(13462172336128L, 100301);
    return null;
  }
  
  public final String getString(String paramString)
  {
    GMTrace.i(13462038118400L, 100300);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof String))
    {
      v.d("MicroMsg.Debugger", "getString(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (String)localObject;
      GMTrace.o(13462038118400L, 100300);
      return paramString;
    }
    GMTrace.o(13462038118400L, 100300);
    return null;
  }
  
  public static final class a
  {
    public static Object i(int paramInt, String paramString)
    {
      GMTrace.i(13463111860224L, 100308);
      switch (paramInt)
      {
      }
      try
      {
        v.e("MicroMsg.Debugger.Resolver", "unknown type");
        GMTrace.o(13463111860224L, 100308);
        return null;
        paramString = Integer.valueOf(paramString);
        GMTrace.o(13463111860224L, 100308);
        return paramString;
        paramString = Long.valueOf(paramString);
        GMTrace.o(13463111860224L, 100308);
        return paramString;
        GMTrace.o(13463111860224L, 100308);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        GMTrace.o(13463111860224L, 100308);
        return paramString;
        paramString = Float.valueOf(paramString);
        GMTrace.o(13463111860224L, 100308);
        return paramString;
        paramString = Double.valueOf(paramString);
        GMTrace.o(13463111860224L, 100308);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */