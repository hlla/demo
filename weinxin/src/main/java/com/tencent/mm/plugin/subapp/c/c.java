package com.tencent.mm.plugin.subapp.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c
{
  private String fyw;
  private RandomAccessFile iaI;
  
  public c(String paramString)
  {
    GMTrace.i(5842229264384L, 43528);
    this.iaI = null;
    this.fyw = "";
    this.fyw = paramString;
    GMTrace.o(5842229264384L, 43528);
  }
  
  private boolean lP(String paramString)
  {
    GMTrace.i(5842631917568L, 43531);
    if (this.fyw.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.iaI != null) {
        break label125;
      }
      bool = true;
      label33:
      Assert.assertTrue(bool);
      if ((!paramString.equals("r")) && (!paramString.equals("rw"))) {
        break label130;
      }
    }
    label125:
    label130:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      v.d("MicroMsg.SpxFileOperator", "Open file:" + this.iaI + " mode:" + paramString);
      try
      {
        this.iaI = new RandomAccessFile(this.fyw, paramString);
        GMTrace.o(5842631917568L, 43531);
        return true;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fyw + "] failed:[" + paramString.getMessage() + "]");
        this.iaI = null;
        GMTrace.o(5842631917568L, 43531);
      }
      bool = false;
      break;
      bool = false;
      break label33;
    }
    return false;
  }
  
  public static int ly(String paramString)
  {
    GMTrace.i(5842363482112L, 43529);
    if (paramString.length() >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = new File(paramString);
      if (paramString.exists()) {
        break;
      }
      GMTrace.o(5842363482112L, 43529);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      GMTrace.o(5842363482112L, 43529);
      return 0;
    }
    GMTrace.o(5842363482112L, 43529);
    return i;
  }
  
  public final void Lv()
  {
    GMTrace.i(5842497699840L, 43530);
    if (this.iaI != null) {
      try
      {
        this.iaI.close();
        this.iaI = null;
        v.d("MicroMsg.SpxFileOperator", "Close :" + this.fyw);
        GMTrace.o(5842497699840L, 43530);
        return;
      }
      catch (IOException localIOException) {}
    }
    GMTrace.o(5842497699840L, 43530);
  }
  
  public final a uq(int paramInt)
  {
    GMTrace.i(5842766135296L, 43532);
    a locala = new a();
    if (paramInt < 0)
    {
      locala.ret = -3;
      GMTrace.o(5842766135296L, 43532);
      return locala;
    }
    if ((this.iaI == null) && (!lP("r")))
    {
      locala.ret = -2;
      GMTrace.o(5842766135296L, 43532);
      return locala;
    }
    locala.buf = new byte['ᝰ'];
    try
    {
      long l = this.iaI.length();
      this.iaI.seek(paramInt);
      int j = this.iaI.read(locala.buf, 0, 6000);
      v.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fyw + "] readOffset:" + paramInt + " readRet:" + j + " fileNow:" + this.iaI.getFilePointer() + " fileSize:" + l);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      locala.fAB = i;
      locala.iav = (i + paramInt);
      locala.ret = 0;
      GMTrace.o(5842766135296L, 43532);
      return locala;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fyw + "] Offset:" + paramInt + "  failed:[" + localException.getMessage() + "] ");
      Lv();
      locala.ret = -1;
      GMTrace.o(5842766135296L, 43532);
    }
    return locala;
  }
  
  public static final class a
  {
    public byte[] buf;
    public int fAB;
    public int iav;
    public int ret;
    
    public a()
    {
      GMTrace.i(5838336950272L, 43499);
      this.buf = null;
      this.fAB = 0;
      this.iav = 0;
      this.ret = 0;
      GMTrace.o(5838336950272L, 43499);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */