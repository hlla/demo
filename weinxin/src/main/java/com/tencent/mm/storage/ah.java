package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

final class ah
{
  protected final long uHy;
  private ag uHz;
  
  public ah()
  {
    GMTrace.i(13199105589248L, 98341);
    this.uHy = 86400L;
    this.uHz = new ag();
    Object localObject = new StringBuilder();
    h.vJ();
    localObject = com.tencent.mm.a.e.d(h.vI().cachePath + "checkmsgid.ini", 0, -1);
    if (!bf.bm((byte[])localObject)) {
      try
      {
        this.uHz.aD((byte[])localObject);
        if (bLF()) {
          bLE();
        }
        GMTrace.o(13199105589248L, 98341);
        return;
      }
      catch (IOException localIOException)
      {
        v.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        v.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bf.g(localIOException) });
      }
    }
    GMTrace.o(13199105589248L, 98341);
  }
  
  private void bLE()
  {
    GMTrace.i(13199239806976L, 98342);
    try
    {
      this.uHz.uHu.clear();
      this.uHz.uHt.clear();
      this.uHz.uHs.clear();
      byte[] arrayOfByte = this.uHz.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      h.vJ();
      com.tencent.mm.a.e.b(h.vI().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      GMTrace.o(13199239806976L, 98342);
      return;
    }
    catch (IOException localIOException)
    {
      v.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bf.g(localIOException) });
      GMTrace.o(13199239806976L, 98342);
    }
  }
  
  private boolean bLF()
  {
    GMTrace.i(13199910895616L, 98347);
    v.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.uHz.uHr), Integer.valueOf(this.uHz.uHv.size()), Integer.valueOf(this.uHz.uHw.size()), Integer.valueOf(this.uHz.uHx.size()) });
    int i = (int)(bf.Nz() / 86400L);
    int j = this.uHz.uHr;
    this.uHz.uHr = i;
    switch (i - j)
    {
    default: 
      this.uHz.uHx.clear();
      this.uHz.uHw.clear();
      this.uHz.uHv.clear();
      GMTrace.o(13199910895616L, 98347);
      return true;
    case 0: 
      GMTrace.o(13199910895616L, 98347);
      return false;
    case 1: 
      this.uHz.uHx = this.uHz.uHw;
      this.uHz.uHw = this.uHz.uHv;
      this.uHz.uHv.clear();
      GMTrace.o(13199910895616L, 98347);
      return true;
    }
    this.uHz.uHx = this.uHz.uHv;
    this.uHz.uHw.clear();
    this.uHz.uHv.clear();
    GMTrace.o(13199910895616L, 98347);
    return true;
  }
  
  protected final void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    GMTrace.i(13199642460160L, 98345);
    if (paramLong1 == 0L)
    {
      GMTrace.o(13199642460160L, 98345);
      return;
    }
    if (paramBoolean) {
      bLF();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      v.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (paramBoolean) {
        bLE();
      }
      GMTrace.o(13199642460160L, 98345);
      return;
      this.uHz.uHv.add(Long.valueOf(paramLong1));
      continue;
      this.uHz.uHw.add(Long.valueOf(paramLong1));
      continue;
      this.uHz.uHx.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void e(int paramInt, long paramLong1, long paramLong2)
  {
    GMTrace.i(13199508242432L, 98344);
    a(paramInt, paramLong1, paramLong2, true);
    GMTrace.o(13199508242432L, 98344);
  }
  
  protected final boolean eA(long paramLong)
  {
    GMTrace.i(13199374024704L, 98343);
    if (bLF()) {
      bLE();
    }
    if ((this.uHz.uHv.contains(Long.valueOf(paramLong))) || (this.uHz.uHw.contains(Long.valueOf(paramLong))) || (this.uHz.uHx.contains(Long.valueOf(paramLong))))
    {
      GMTrace.o(13199374024704L, 98343);
      return true;
    }
    GMTrace.o(13199374024704L, 98343);
    return false;
  }
  
  protected final void i(List<Integer> paramList, List<Long> paramList1)
  {
    GMTrace.i(13199776677888L, 98346);
    v.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    bLF();
    int j = (int)(bf.Nz() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      a(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    bLE();
    GMTrace.o(13199776677888L, 98346);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */