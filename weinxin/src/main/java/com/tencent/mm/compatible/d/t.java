package com.tencent.mm.compatible.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class t
{
  public static boolean gRo;
  public String gRp;
  Map<String, String> gRq;
  public int gRr;
  
  static
  {
    GMTrace.i(13805098631168L, 102856);
    gRo = false;
    GMTrace.o(13805098631168L, 102856);
  }
  
  public t()
  {
    GMTrace.i(13804427542528L, 102851);
    this.gRp = "";
    this.gRq = null;
    this.gRr = 0;
    GMTrace.o(13804427542528L, 102851);
  }
  
  public static boolean rQ()
  {
    GMTrace.i(13804695977984L, 102853);
    if (gRo)
    {
      gRo = false;
      GMTrace.o(13804695977984L, 102853);
      return true;
    }
    GMTrace.o(13804695977984L, 102853);
    return false;
  }
  
  public final void dv(String paramString)
  {
    GMTrace.i(13804830195712L, 102854);
    this.gRp = paramString;
    GMTrace.o(13804830195712L, 102854);
  }
  
  public final void em(int paramInt)
  {
    GMTrace.i(13804561760256L, 102852);
    this.gRr = paramInt;
    gRo = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    v.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.gRr) });
    GMTrace.o(13804561760256L, 102852);
  }
  
  public final void i(Map<String, String> paramMap)
  {
    GMTrace.i(13804964413440L, 102855);
    this.gRq = paramMap;
    GMTrace.o(13804964413440L, 102855);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */