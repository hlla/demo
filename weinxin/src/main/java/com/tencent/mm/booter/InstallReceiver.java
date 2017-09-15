package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class InstallReceiver
  extends BroadcastReceiver
{
  public InstallReceiver()
  {
    GMTrace.i(505598181376L, 3767);
    GMTrace.o(505598181376L, 3767);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(505732399104L, 3768);
    if ((paramContext == null) || (paramIntent == null))
    {
      GMTrace.o(505732399104L, 3768);
      return;
    }
    String str = paramIntent.getAction();
    v.i("MicroMsg.InstallReceiver", "action:[%s]", new Object[] { str });
    if ((bf.mA(str)) || (!str.equals("com.android.vending.INSTALL_REFERRER")))
    {
      v.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
      GMTrace.o(505732399104L, 3768);
      return;
    }
    str = "";
    try
    {
      paramIntent = paramIntent.getStringExtra("referrer");
      v.i("MicroMsg.InstallReceiver", "get referer:[%s]", new Object[] { paramIntent });
      if (bf.mA(paramIntent))
      {
        v.e("MicroMsg.InstallReceiver", "get referer is null or nil");
        GMTrace.o(505732399104L, 3768);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        v.e("MicroMsg.InstallReceiver", "%s", new Object[] { bf.g(paramIntent) });
        paramIntent = str;
      }
      v.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = " + paramIntent);
      paramContext.getSharedPreferences(aa.bIN(), 0).edit().putString("installreferer", paramIntent).commit();
      GMTrace.o(505732399104L, 3768);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */