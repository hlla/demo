package com.tencent.mm.modelsfs;

import com.tencent.gmtrace.GMTrace;

public final class e
  extends SFSOutputStream
{
  private a hQK;
  
  public e(long paramLong, String paramString)
  {
    super(paramLong);
    GMTrace.i(13843082248192L, 103139);
    this.hQK = new a(paramString);
    GMTrace.o(13843082248192L, 103139);
  }
  
  public final void close()
  {
    GMTrace.i(13843484901376L, 103142);
    super.close();
    if (this.hQK != null) {
      this.hQK.free();
    }
    GMTrace.o(13843484901376L, 103142);
  }
  
  protected final void finalize()
  {
    GMTrace.i(13843619119104L, 103143);
    super.finalize();
    GMTrace.o(13843619119104L, 103143);
  }
  
  public final void write(int paramInt)
  {
    GMTrace.i(13843216465920L, 103140);
    super.write(paramInt);
    GMTrace.o(13843216465920L, 103140);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    GMTrace.i(13843350683648L, 103141);
    this.hQK.j(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    GMTrace.o(13843350683648L, 103141);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsfs/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */