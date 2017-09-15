package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a
  implements b
{
  private String fyw;
  private RandomAccessFile iaI;
  
  public a(String paramString)
  {
    GMTrace.i(541165879296L, 4032);
    this.iaI = null;
    this.fyw = "";
    this.fyw = paramString;
    GMTrace.o(541165879296L, 4032);
  }
  
  private boolean lP(String paramString)
  {
    GMTrace.i(541434314752L, 4034);
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
      v.d("MicroMsg.AmrFileOperator", "Open file:" + this.iaI + " mode:" + paramString);
      try
      {
        this.iaI = new RandomAccessFile(this.fyw, paramString);
        GMTrace.o(541434314752L, 4034);
        return true;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fyw + "] failed:[" + paramString.getMessage() + "]");
        this.iaI = null;
        GMTrace.o(541434314752L, 4034);
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
    GMTrace.i(541300097024L, 4033);
    if (this.iaI != null) {
      try
      {
        this.iaI.close();
        this.iaI = null;
        v.d("MicroMsg.AmrFileOperator", "Close :" + this.fyw);
        GMTrace.o(541300097024L, 4033);
        return;
      }
      catch (IOException localIOException) {}
    }
    GMTrace.o(541300097024L, 4033);
  }
  
  public final g bd(int paramInt1, int paramInt2)
  {
    GMTrace.i(541568532480L, 4035);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      GMTrace.o(541568532480L, 4035);
      return localg;
    }
    if ((this.iaI == null) && (!lP("r")))
    {
      localg.ret = -2;
      GMTrace.o(541568532480L, 4035);
      return localg;
    }
    int i = paramInt1 + 6;
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.iaI.length();
      this.iaI.seek(i);
      paramInt2 = this.iaI.read(localg.buf, 0, paramInt2);
      v.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fyw + "] readOffset:" + i + " readRet:" + paramInt2 + " fileNow:" + this.iaI.getFilePointer() + " fileSize:" + l);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      localg.fAB = paramInt1;
      localg.iav = (paramInt1 + i - 6);
      localg.ret = 0;
      GMTrace.o(541568532480L, 4035);
      return localg;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fyw + "] Offset:" + i + "  failed:[" + localException.getMessage() + "] ");
      Lv();
      localg.ret = -1;
      GMTrace.o(541568532480L, 4035);
    }
    return localg;
  }
  
  public final int getFormat()
  {
    GMTrace.i(541836967936L, 4037);
    GMTrace.o(541836967936L, 4037);
    return 0;
  }
  
  public final int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    GMTrace.i(541702750208L, 4036);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.iaI != null) || (lP("rw"))) {
        break;
      }
      GMTrace.o(541702750208L, 4036);
      return -1;
    }
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        this.iaI.write("#!AMR\n".getBytes(), 0, 6);
        int i = paramInt2 + 6;
        long l;
        bool1 = false;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          this.iaI.seek(i);
          this.iaI.write(paramArrayOfByte, 0, paramInt1);
          l = this.iaI.getFilePointer();
          paramInt2 = (int)l;
          paramInt1 = i + paramInt1;
          if (paramInt2 != paramInt1) {
            break label293;
          }
          bool1 = true;
          Assert.assertTrue(bool1);
          paramInt1 -= 6;
          if (paramInt1 < 0) {
            break label299;
          }
          bool1 = bool2;
          Assert.assertTrue(bool1);
          GMTrace.o(541702750208L, 4036);
          return paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          v.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fyw + "] Offset:" + i + " failed:[" + paramArrayOfByte.getMessage() + "]");
          Lv();
          GMTrace.o(541702750208L, 4036);
          return -3;
        }
        paramArrayOfByte = paramArrayOfByte;
        v.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fyw + "] failed:[" + paramArrayOfByte.getMessage() + "]");
        Lv();
        GMTrace.o(541702750208L, 4036);
        return -2;
      }
      label293:
      continue;
      label299:
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */