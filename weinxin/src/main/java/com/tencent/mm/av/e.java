package com.tencent.mm.av;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class e
{
  public static void d(long paramLong, String paramString)
  {
    boolean bool1 = false;
    GMTrace.i(17614063534080L, 131235);
    v.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    boolean bool2 = l.Kz().c(paramLong, paramString);
    v.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + bool2);
    g localg = l.Ky();
    if ((paramString == null) || (paramString.length() == 0)) {
      v.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
    }
    for (;;)
    {
      v.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + bool1);
      GMTrace.o(17614063534080L, 131235);
      return;
      paramString = "delete from fmessage_msginfo where talker = '" + bf.my(paramString) + "'";
      bool1 = localg.gUp.eE("fmessage_msginfo", paramString);
    }
  }
  
  public static long i(String paramString, long paramLong)
  {
    GMTrace.i(1422976352256L, 10602);
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = l.Ky().lb(paramString);
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.field_createTime + 1L;
      }
    }
    if (l1 > paramLong * 1000L)
    {
      GMTrace.o(1422976352256L, 10602);
      return l1;
    }
    GMTrace.o(1422976352256L, 10602);
    return paramLong * 1000L;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */