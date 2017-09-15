package com.tencent.mm.plugin.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.aa;

public final class b
{
  private static int FC()
  {
    GMTrace.i(13180851978240L, 98205);
    int i = aa.getContext().getSharedPreferences(aa.bIN(), 0).getInt("reg_style_id", 0);
    GMTrace.o(13180851978240L, 98205);
    return i;
  }
  
  public static String OA()
  {
    GMTrace.i(13181120413696L, 98207);
    String str = aa.getContext().getSharedPreferences(aa.bIN(), 0).getString("reg_last_exit_ui", "");
    GMTrace.o(13181120413696L, 98207);
    return str;
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    GMTrace.i(13181523066880L, 98210);
    if (paramBoolean) {}
    for (paramString = paramString + "," + FC() + "," + com.tencent.mm.sdk.platformtools.bf.NA() + "," + OA();; paramString = paramString + "," + FC() + "," + com.tencent.mm.sdk.platformtools.bf.NA() + "," + aa.getContext().getSharedPreferences(aa.bIN(), 0).getString("reg_next_enter_ui", ""))
    {
      c.oRz.a(10645, paramString, true, true);
      GMTrace.o(13181523066880L, 98210);
      return;
    }
  }
  
  public static void hh(int paramInt)
  {
    GMTrace.i(13180717760512L, 98204);
    if (paramInt > 0)
    {
      com.tencent.mm.u.bf.zK();
      com.tencent.mm.u.bf.zK();
      if (paramInt == 20) {
        aa.getContext().getSharedPreferences(aa.bIN(), 0).edit().putInt("reg_style_id", paramInt).commit();
      }
    }
    GMTrace.o(13180717760512L, 98204);
  }
  
  public static void mM(String paramString)
  {
    GMTrace.i(13180986195968L, 98206);
    aa.getContext().getSharedPreferences(aa.bIN(), 0).edit().putString("reg_last_exit_ui", paramString).commit();
    GMTrace.o(13180986195968L, 98206);
  }
  
  public static void mN(String paramString)
  {
    GMTrace.i(13181254631424L, 98208);
    aa.getContext().getSharedPreferences(aa.bIN(), 0).edit().putString("reg_next_enter_ui", paramString).commit();
    GMTrace.o(13181254631424L, 98208);
  }
  
  public static void mO(String paramString)
  {
    GMTrace.i(13181388849152L, 98209);
    paramString = paramString + "," + FC() + "," + com.tencent.mm.sdk.platformtools.bf.NA() + "," + OA();
    c.oRz.a(10645, paramString, true, true);
    GMTrace.o(13181388849152L, 98209);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */