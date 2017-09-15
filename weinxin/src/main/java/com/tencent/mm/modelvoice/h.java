package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class h
  implements b
{
  private String fyw;
  private RandomAccessFile iaI;
  
  public h(String paramString)
  {
    GMTrace.i(568143642624L, 4233);
    this.iaI = null;
    this.fyw = "";
    this.fyw = paramString;
    GMTrace.o(568143642624L, 4233);
  }
  
  private boolean lP(String paramString)
  {
    GMTrace.i(568412078080L, 4235);
    if (this.fyw.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.iaI != null) {
        break label127;
      }
      bool = true;
      label34:
      Assert.assertTrue(bool);
      if ((!paramString.equals("r")) && (!paramString.equals("rw"))) {
        break label132;
      }
    }
    label127:
    label132:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      v.d("MicroMsg.SilkFileOperator", "Open file:" + this.iaI + " mode:" + paramString);
      try
      {
        this.iaI = new RandomAccessFile(this.fyw, paramString);
        GMTrace.o(568412078080L, 4235);
        return true;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.SilkFileOperator", "ERR: OpenFile[" + this.fyw + "] failed:[" + paramString.getMessage() + "]");
        this.iaI = null;
        GMTrace.o(568412078080L, 4235);
      }
      bool = false;
      break;
      bool = false;
      break label34;
    }
    return false;
  }
  
  public final void Lv()
  {
    GMTrace.i(568277860352L, 4234);
    if (this.iaI != null) {
      try
      {
        this.iaI.close();
        this.iaI = null;
        v.d("MicroMsg.SilkFileOperator", "Close :" + this.fyw);
        GMTrace.o(568277860352L, 4234);
        return;
      }
      catch (IOException localIOException) {}
    }
    GMTrace.o(568277860352L, 4234);
  }
  
  public final g bd(int paramInt1, int paramInt2)
  {
    GMTrace.i(568546295808L, 4236);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      GMTrace.o(568546295808L, 4236);
      return localg;
    }
    if ((this.iaI == null) && (!lP("r")))
    {
      localg.ret = -2;
      GMTrace.o(568546295808L, 4236);
      return localg;
    }
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.iaI.length();
      this.iaI.seek(paramInt1);
      int i = this.iaI.read(localg.buf, 0, paramInt2);
      v.d("MicroMsg.SilkFileOperator", "DBG: ReadFile[" + this.fyw + "] readOffset:" + paramInt1 + " readRet:" + i + " fileNow:" + this.iaI.getFilePointer() + " fileSize:" + l);
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localg.fAB = paramInt2;
      localg.iav = (paramInt2 + paramInt1);
      localg.ret = 0;
      GMTrace.o(568546295808L, 4236);
      return localg;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.SilkFileOperator", "ERR: ReadFile[" + this.fyw + "] Offset:" + paramInt1 + "  failed:[" + localException.getMessage() + "] ");
      Lv();
      localg.ret = -1;
      GMTrace.o(568546295808L, 4236);
    }
    return localg;
  }
  
  public final int getFormat()
  {
    GMTrace.i(568814731264L, 4238);
    GMTrace.o(568814731264L, 4238);
    return 4;
  }
  
  public final int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    GMTrace.i(568680513536L, 4237);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.iaI != null) || (lP("rw"))) {
        break;
      }
      GMTrace.o(568680513536L, 4237);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.iaI.seek(paramInt2);
        this.iaI.write(paramArrayOfByte, 0, paramInt1);
        long l = this.iaI.getFilePointer();
        int i = (int)l;
        paramInt1 = paramInt2 + paramInt1;
        if (i == paramInt1)
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          if (paramInt1 < 0) {
            break label210;
          }
          bool1 = bool2;
          Assert.assertTrue(bool1);
          GMTrace.o(568680513536L, 4237);
          return paramInt1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        v.e("MicroMsg.SilkFileOperator", "ERR: WriteFile[" + this.fyw + "] Offset:" + paramInt2 + " failed:[" + paramArrayOfByte.getMessage() + "]");
        Lv();
        GMTrace.o(568680513536L, 4237);
        return -3;
      }
      bool1 = false;
      continue;
      label210:
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */