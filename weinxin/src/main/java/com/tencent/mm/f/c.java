package com.tencent.mm.f;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String desc;
  public int fDr;
  public int fDs;
  public String fDt;
  public String gMC;
  public String gMD;
  public int gME;
  public int showType;
  public String url;
  
  public c()
  {
    GMTrace.i(13156290134016L, 98022);
    GMTrace.o(13156290134016L, 98022);
  }
  
  private static boolean dZ(int paramInt)
  {
    GMTrace.i(13156558569472L, 98024);
    if (paramInt == 4)
    {
      GMTrace.o(13156558569472L, 98024);
      return true;
    }
    if (paramInt == 1)
    {
      GMTrace.o(13156558569472L, 98024);
      return true;
    }
    if (paramInt == 5)
    {
      GMTrace.o(13156558569472L, 98024);
      return true;
    }
    if (paramInt == 3)
    {
      GMTrace.o(13156558569472L, 98024);
      return true;
    }
    GMTrace.o(13156558569472L, 98024);
    return false;
  }
  
  public static c dp(String paramString)
  {
    GMTrace.i(13156424351744L, 98023);
    if (bf.mA(paramString))
    {
      GMTrace.o(13156424351744L, 98023);
      return null;
    }
    c localc = new c();
    paramString = bg.q(paramString, "e");
    if (paramString == null)
    {
      v.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      GMTrace.o(13156424351744L, 98023);
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.fDt = ((String)paramString.get(".e.Title"));
    localc.fDs = bf.getInt((String)paramString.get(".e.Action"), 0);
    localc.showType = bf.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.fDr = bf.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.gMC = ((String)paramString.get(".e.Ok"));
    localc.gMD = ((String)paramString.get(".e.Cancel"));
    localc.gME = bf.getInt((String)paramString.get("e.Countdown"), 0);
    if (dZ(localc.showType))
    {
      GMTrace.o(13156424351744L, 98023);
      return localc;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramString.get(".e"));
      localc.desc = localJSONObject.getString("Content");
      localc.url = localJSONObject.getString("Url");
      localc.fDt = localJSONObject.getString("Title");
      localc.fDs = bf.getInt(localJSONObject.getString("Action"), 0);
      localc.showType = bf.getInt(localJSONObject.getString("ShowType"), 0);
      localc.fDr = bf.getInt(localJSONObject.getString("DispSec"), 30);
      localc.gMC = ((String)paramString.get(".e.Ok"));
      localc.gMD = ((String)paramString.get(".e.Cancel"));
      localc.gME = bf.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = dZ(localc.showType);
      if (bool)
      {
        GMTrace.o(13156424351744L, 98023);
        return localc;
      }
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
      GMTrace.o(13156424351744L, 98023);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */