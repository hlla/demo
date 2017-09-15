package com.tencent.mm.pluginsdk.j;

import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;

public final class d
{
  public static void a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    GMTrace.i(698871709696L, 5207);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new e();
      ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
      GMTrace.o(698871709696L, 5207);
      return;
    }
    new f();
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramCharSequence2);
    GMTrace.o(698871709696L, 5207);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */