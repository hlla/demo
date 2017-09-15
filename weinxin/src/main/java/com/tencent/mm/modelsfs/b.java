package com.tencent.mm.modelsfs;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public final class b
  extends FileInputStream
{
  private boolean hQG;
  private a hQK;
  private long hQL;
  
  public b(String paramString, long paramLong)
  {
    super(paramString);
    GMTrace.i(13839592587264L, 103113);
    this.hQG = false;
    this.hQL = 0L;
    this.hQK = new a(paramLong);
    GMTrace.o(13839592587264L, 103113);
  }
  
  public final void close()
  {
    GMTrace.i(13839995240448L, 103116);
    super.close();
    if (this.hQK != null) {
      this.hQK.free();
    }
    v.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    GMTrace.o(13839995240448L, 103116);
  }
  
  public final void mark(int paramInt)
  {
    GMTrace.i(13840129458176L, 103117);
    this.hQL = this.hQK.IK();
    GMTrace.o(13840129458176L, 103117);
  }
  
  public final boolean markSupported()
  {
    GMTrace.i(13840397893632L, 103119);
    GMTrace.o(13840397893632L, 103119);
    return true;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    GMTrace.i(13839726804992L, 103114);
    if (this.hQG) {
      v.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bf.bJP().toString());
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      GMTrace.o(13839726804992L, 103114);
      return paramInt1;
    }
    this.hQK.j(paramArrayOfByte, paramInt2);
    GMTrace.o(13839726804992L, 103114);
    return paramInt1;
  }
  
  public final void reset()
  {
    GMTrace.i(13840263675904L, 103118);
    getChannel().position(this.hQL);
    this.hQK.reset();
    GMTrace.o(13840263675904L, 103118);
  }
  
  public final long skip(long paramLong)
  {
    GMTrace.i(13839861022720L, 103115);
    long l = super.skip(paramLong);
    this.hQK.seek(paramLong);
    GMTrace.o(13839861022720L, 103115);
    return l;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsfs/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */