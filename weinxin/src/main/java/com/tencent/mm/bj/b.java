package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

final class b
{
  private static int index;
  private static boolean on;
  private static g.a uJO;
  private static long uJP;
  private static int uJQ;
  
  static
  {
    GMTrace.i(13557198487552L, 101009);
    on = false;
    index = 0;
    uJO = null;
    uJP = 0L;
    uJQ = 0;
    GMTrace.o(13557198487552L, 101009);
  }
  
  static void a(String paramString, Cursor paramCursor, long paramLong)
  {
    GMTrace.i(13557064269824L, 101008);
    if (!on)
    {
      GMTrace.o(13557064269824L, 101008);
      return;
    }
    long l = uJO.se();
    Object localObject1 = "Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]";
    Object localObject2 = (String)localObject1 + "[" + index + "][" + l + "]";
    localObject1 = localObject2;
    if (paramLong != 0L) {
      localObject1 = (String)localObject2 + "[INTRANS]";
    }
    localObject2 = localObject1;
    if (paramCursor != null)
    {
      i(paramCursor);
      localObject2 = (String)localObject1 + "[cuCnt:" + uJQ + ",cuTime:" + uJP + "]";
    }
    paramString = (String)localObject2 + "[" + paramString + "]--";
    v.v("MicroMsg.dbtest", paramString + bf.bJP());
    GMTrace.o(13557064269824L, 101008);
  }
  
  static void begin()
  {
    GMTrace.i(13556795834368L, 101006);
    if (!on)
    {
      GMTrace.o(13556795834368L, 101006);
      return;
    }
    uJO = new g.a();
    index += 1;
    GMTrace.o(13556795834368L, 101006);
  }
  
  private static void i(Cursor paramCursor)
  {
    GMTrace.i(13556930052096L, 101007);
    if (!on)
    {
      GMTrace.o(13556930052096L, 101007);
      return;
    }
    if (paramCursor == null)
    {
      GMTrace.o(13556930052096L, 101007);
      return;
    }
    uJQ = paramCursor.getCount();
    g.a locala = new g.a();
    int i = 0;
    while (i < uJQ)
    {
      paramCursor.moveToPosition(i);
      i += 1;
    }
    paramCursor.moveToPosition(-1);
    uJP = locala.se();
    GMTrace.o(13556930052096L, 101007);
  }
  
  public static void i(Exception paramException)
  {
    GMTrace.i(13556661616640L, 101005);
    if (on) {
      v.e("MicroMsg.DKTest", "exception:%s", new Object[] { bf.g(paramException) });
    }
    GMTrace.o(13556661616640L, 101005);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */