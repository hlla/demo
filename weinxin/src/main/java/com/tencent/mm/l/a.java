package com.tencent.mm.l;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  public static final class a
    implements BaseColumns
  {
    public static final Uri CONTENT_URI;
    
    static
    {
      GMTrace.i(14019041689600L, 104450);
      CONTENT_URI = Uri.parse("content://com.tencent.mm.coolassist.debugprovider/config");
      GMTrace.o(14019041689600L, 104450);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */