package com.tencent.mm.modelsfs;

import com.tencent.gmtrace.GMTrace;
import java.io.File;
import java.io.FileOutputStream;

public final class c
  extends FileOutputStream
{
  private a hQK;
  
  public c(File paramFile, long paramLong)
  {
    super(paramFile);
    GMTrace.i(15231564644352L, 113484);
    this.hQK = new a(paramLong);
    GMTrace.o(15231564644352L, 113484);
  }
  
  public c(String paramString1, String paramString2)
  {
    super(paramString1);
    GMTrace.i(13841740070912L, 103129);
    this.hQK = new a(paramString2);
    GMTrace.o(13841740070912L, 103129);
  }
  
  public final void close()
  {
    GMTrace.i(13842008506368L, 103131);
    super.close();
    if (this.hQK != null) {
      this.hQK.free();
    }
    GMTrace.o(13842008506368L, 103131);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    GMTrace.i(13841874288640L, 103130);
    this.hQK.j(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    GMTrace.o(13841874288640L, 103130);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsfs/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */