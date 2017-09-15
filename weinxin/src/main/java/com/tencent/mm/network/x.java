package com.tencent.mm.network;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class x
{
  private static final byte[] ieP;
  public l ieQ;
  
  static
  {
    GMTrace.i(13654640558080L, 101735);
    ieP = n.cP(7);
    GMTrace.o(13654640558080L, 101735);
  }
  
  public x()
  {
    GMTrace.i(13654372122624L, 101733);
    GMTrace.o(13654372122624L, 101733);
  }
  
  public final void onPush(int paramInt, byte[] paramArrayOfByte)
  {
    GMTrace.i(13654506340352L, 101734);
    StringBuilder localStringBuilder = new StringBuilder("onNotify, datalen=");
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      v.i("MicroMsg.MMNativeNetNotifyAdapter", i + " cmd= " + paramInt);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      GMTrace.o(13654506340352L, 101734);
      return;
      i = paramArrayOfByte.length;
      break;
      v.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
      this.ieQ.d(138, ieP);
      GMTrace.o(13654506340352L, 101734);
      return;
      v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { bf.bl(paramArrayOfByte) });
      this.ieQ.d(138, paramArrayOfByte);
      GMTrace.o(13654506340352L, 101734);
      return;
      v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush GCM notify [%s]", new Object[] { bf.bl(paramArrayOfByte) });
      this.ieQ.d(2147480001, paramArrayOfByte);
      GMTrace.o(13654506340352L, 101734);
      return;
      v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
      this.ieQ.d(39, null);
      GMTrace.o(13654506340352L, 101734);
      return;
      GMTrace.o(13654506340352L, 101734);
      return;
      this.ieQ.d(174, paramArrayOfByte);
      GMTrace.o(13654506340352L, 101734);
      return;
      if (paramArrayOfByte.length > 0)
      {
        this.ieQ.d(10, paramArrayOfByte);
        GMTrace.o(13654506340352L, 101734);
        return;
        GMTrace.o(13654506340352L, 101734);
        return;
        v.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        if (paramArrayOfByte.length > 0)
        {
          this.ieQ.d(120, paramArrayOfByte);
          GMTrace.o(13654506340352L, 101734);
          return;
          v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
          if (paramArrayOfByte.length > 0)
          {
            this.ieQ.d(268369921, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            this.ieQ.d(1000000205, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            this.ieQ.d(192, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
            this.ieQ.d(268369923, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            v.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
            this.ieQ.d(241, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            v.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
            this.ieQ.d(244, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            v.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
            this.ieQ.d(319, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            v.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
            this.ieQ.d(311, paramArrayOfByte);
            GMTrace.o(13654506340352L, 101734);
            return;
            v.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
            this.ieQ.d(318, paramArrayOfByte);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */