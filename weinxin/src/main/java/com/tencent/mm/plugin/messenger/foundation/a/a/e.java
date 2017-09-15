package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public abstract interface e
{
  public static final class a
    extends e.b
  {
    private int cmdId;
    
    public a(int paramInt, a parama)
    {
      super();
      GMTrace.i(13369025232896L, 99607);
      this.cmdId = paramInt;
      this.nxx = parama;
      GMTrace.o(13369025232896L, 99607);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13369159450624L, 99608);
      int i = this.cmdId;
      GMTrace.o(13369159450624L, 99608);
      return i;
    }
  }
  
  public static class b
  {
    public byte[] buffer;
    public int cmdId;
    public int fRM;
    public long hDk;
    public int id;
    public int nxt;
    public long nxu;
    public String nxv;
    public String nxw;
    public a nxx;
    
    public b(int paramInt)
    {
      GMTrace.i(13368622579712L, 99604);
      this.fRM = -1;
      this.cmdId = paramInt;
      GMTrace.o(13368622579712L, 99604);
    }
    
    public final byte[] getBuffer()
    {
      GMTrace.i(13368891015168L, 99606);
      if ((this.buffer == null) && (this.nxx != null)) {}
      try
      {
        this.buffer = this.nxx.toByteArray();
        byte[] arrayOfByte = this.buffer;
        GMTrace.o(13368891015168L, 99606);
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          v.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
        }
      }
    }
    
    public int getCmdId()
    {
      GMTrace.i(13368756797440L, 99605);
      int i = this.cmdId;
      GMTrace.o(13368756797440L, 99605);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */