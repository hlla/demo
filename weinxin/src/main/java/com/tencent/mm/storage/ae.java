package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;

public final class ae
  extends com.tencent.mm.k.a
  implements com.tencent.mm.bj.a.a<String>
{
  public au uHf;
  
  public ae()
  {
    GMTrace.i(13313459093504L, 99193);
    GMTrace.o(13313459093504L, 99193);
  }
  
  public ae(String paramString)
  {
    super(paramString);
    GMTrace.i(13313324875776L, 99192);
    GMTrace.o(13313324875776L, 99192);
  }
  
  public final void M(int paramInt, long paramLong)
  {
    GMTrace.i(13314264399872L, 99199);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(13314264399872L, 99199);
      return;
      dt((int)paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      dv((int)paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      dw((int)paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      s(paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      t(paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      dy((int)paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      dz((int)paramLong);
      GMTrace.o(13314264399872L, 99199);
      return;
      dC((int)paramLong);
    }
  }
  
  public final void W(au paramau)
  {
    GMTrace.i(13313593311232L, 99194);
    dv(paramau.field_status);
    dw(paramau.field_isSend);
    if (paramau.bMc()) {}
    label104:
    for (;;)
    {
      long l = paramau.field_createTime;
      for (ae localae = this;; localae = this)
      {
        localae.s(l);
        if (!paramau.bLW()) {
          break;
        }
        setContent(paramau.bMs());
        GMTrace.o(13313593311232L, 99194);
        return;
        if (paramau.field_status != 1) {
          break label104;
        }
        l = Long.MAX_VALUE;
      }
      setContent(paramau.field_content);
      GMTrace.o(13313593311232L, 99194);
      return;
    }
  }
  
  public final void ay(int paramInt, String paramString)
  {
    GMTrace.i(13314398617600L, 99200);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(13314398617600L, 99200);
      return;
      setUsername(paramString);
      GMTrace.o(13314398617600L, 99200);
      return;
      setContent(paramString);
      GMTrace.o(13314398617600L, 99200);
      return;
      ct(paramString);
      GMTrace.o(13314398617600L, 99200);
      return;
      cu(paramString);
      GMTrace.o(13314398617600L, 99200);
      return;
      cv(paramString);
      GMTrace.o(13314398617600L, 99200);
      return;
      cx(paramString);
    }
  }
  
  public final void bKC()
  {
    GMTrace.i(13314532835328L, 99201);
    GMTrace.o(13314532835328L, 99201);
  }
  
  public final void bLr()
  {
    GMTrace.i(13313727528960L, 99195);
    dv(0);
    dw(0);
    setContent("");
    ct("0");
    dt(0);
    dC(0);
    u(0L);
    dB(0);
    dB(0);
    super.cu("");
    super.cv("");
    GMTrace.o(13313727528960L, 99195);
  }
  
  public final void m(int paramInt, byte[] paramArrayOfByte)
  {
    GMTrace.i(13313995964416L, 99197);
    GMTrace.o(13313995964416L, 99197);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */