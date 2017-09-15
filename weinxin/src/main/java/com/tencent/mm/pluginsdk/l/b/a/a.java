package com.tencent.mm.pluginsdk.l.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.bf;
import java.io.File;

public final class a
{
  public static boolean b(String paramString, Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(839397670912L, 6254);
    o.KW();
    paramBoolean = c(s.lw(paramString), paramContext, paramBoolean);
    GMTrace.o(839397670912L, 6254);
    return paramBoolean;
  }
  
  public static boolean c(String paramString, Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(839531888640L, 6255);
    if (bf.mA(paramString))
    {
      GMTrace.o(839531888640L, 6255);
      return false;
    }
    if (paramContext == null)
    {
      GMTrace.o(839531888640L, 6255);
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW").addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 3);
    paramString = Uri.fromFile(new File(paramString));
    if (paramBoolean) {
      localIntent.setDataAndType(paramString, "video/quicktime");
    }
    while (!bf.j(paramContext, localIntent))
    {
      GMTrace.o(839531888640L, 6255);
      return false;
      localIntent.setDataAndType(paramString, "video/*");
    }
    paramContext.startActivity(localIntent);
    GMTrace.o(839531888640L, 6255);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/l/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */