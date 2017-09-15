package com.tencent.mm.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class ao
  extends c
{
  public static ao hlE;
  
  static
  {
    GMTrace.i(13477338939392L, 100414);
    hlE = new ao(c.hgm);
    GMTrace.o(13477338939392L, 100414);
  }
  
  private ao(c paramc)
  {
    super(paramc.hgn);
    GMTrace.i(13476802068480L, 100410);
    GMTrace.o(13476802068480L, 100410);
  }
  
  public final void L(String paramString1, String paramString2)
  {
    GMTrace.i(13476936286208L, 100411);
    v.d("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.hgn.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      aa.getContext().getSharedPreferences("notify_key_pref_no_account", 4).edit().putString("login_weixin_username", paramString2).commit();
    }
    GMTrace.o(13476936286208L, 100411);
  }
  
  public final void c(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(13477070503936L, 100412);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      L("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!bf.mA(paramString2))
    {
      paramInt = i | 0x2;
      L("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!bf.mA(paramString1))
    {
      i = paramInt | 0x4;
      L("last_login_bind_mobile", paramString1);
    }
    L("last_bind_info", String.valueOf(i));
    GMTrace.o(13477070503936L, 100412);
  }
  
  public final void gf(String paramString)
  {
    GMTrace.i(13477204721664L, 100413);
    v.i("MicroMsg.LastLoginInfo", "Save last avatar: " + paramString);
    String str1 = paramString + ".bm";
    String str2 = e.hgg + "last_avatar";
    String str3 = str2 + ".bm";
    v.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str3, Boolean.valueOf(FileOp.deleteFile(str2) | FileOp.deleteFile(str3)) });
    if (FileOp.p(paramString, str2) <= 0L) {
      FileOp.p(str1, str3);
    }
    L("last_avatar_path", str2);
    GMTrace.o(13477204721664L, 100413);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */