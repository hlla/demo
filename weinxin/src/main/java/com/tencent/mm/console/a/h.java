package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import java.util.Map;

public final class h
  implements a
{
  static
  {
    GMTrace.i(417148698624L, 3108);
    b.a(new h(), new String[] { "//version" });
    GMTrace.o(417148698624L, 3108);
  }
  
  public h()
  {
    GMTrace.i(416746045440L, 3105);
    GMTrace.o(416746045440L, 3105);
  }
  
  public static void init()
  {
    GMTrace.i(416880263168L, 3106);
    GMTrace.o(416880263168L, 3106);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    GMTrace.i(417014480896L, 3107);
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append(String.format("[ver  ] %s %08X\n", new Object[] { f.b(paramContext, com.tencent.mm.protocal.d.sXh, true), Integer.valueOf(com.tencent.mm.protocal.d.sXh) }));
    paramArrayOfString.append(e.aKl());
    paramArrayOfString.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(f.fuN) }));
    paramArrayOfString.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(com.tencent.mm.as.d.hOW) }));
    paramArrayOfString.append(String.format("[r.ver] %s\n", new Object[] { "0x26050D33" }));
    try
    {
      Map localMap = bg.q(bf.convertStreamToString(paramContext.getAssets().open("merged_features.xml")), "merged");
      int i;
      if (localMap != null)
      {
        i = 0;
        for (;;)
        {
          String str = (String)localMap.get("merged.feature#" + i);
          if (str == null) {
            break;
          }
          paramArrayOfString.append(String.format("[feature#%02d] %s\n", new Object[] { Integer.valueOf(i), str }));
          i += 1;
        }
      }
      TextView localTextView;
      return true;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.Version", localException, "", new Object[0]);
      localTextView = new TextView(paramContext);
      localTextView.setText(paramArrayOfString);
      localTextView.setGravity(19);
      localTextView.setTextSize(1, 10.0F);
      localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localTextView.setTextColor(-16777216);
      localTextView.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.aXs);
      localTextView.setPadding(i, i, i, i);
      g.a(paramContext, null, localTextView, null);
      GMTrace.o(417014480896L, 3107);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/console/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */