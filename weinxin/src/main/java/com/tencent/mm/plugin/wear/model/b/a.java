package com.tencent.mm.plugin.wear.model.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;

public final class a
{
  public static void I(Bundle paramBundle)
  {
    GMTrace.i(9192974843904L, 68493);
    Intent localIntent = new Intent();
    localIntent.setPackage(aa.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.wear.message");
    localIntent.putExtras(paramBundle);
    aa.getContext().sendBroadcast(localIntent);
    GMTrace.o(9192974843904L, 68493);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/wear/model/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */