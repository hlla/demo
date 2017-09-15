package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;

public abstract interface c
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    long fKY;
    long fileLenInvalidCount;
    final String hJE;
    long hJF;
    long hJG;
    long hJH;
    int hJI;
    ArrayList<c.b> hJJ;
    ArrayList<c.c> hJK;
    boolean hJL;
    
    a(String paramString)
    {
      GMTrace.i(396881821696L, 2957);
      this.hJJ = new ArrayList(20);
      this.hJK = new ArrayList(20);
      this.hJL = false;
      this.hJE = paramString;
      GMTrace.o(396881821696L, 2957);
    }
    
    public final String toString()
    {
      GMTrace.i(397016039424L, 2958);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.hJE, Boolean.valueOf(this.hJL), Long.valueOf(this.hJF), Long.valueOf(this.hJG), Long.valueOf(this.fKY), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.hJJ.size()), Integer.valueOf(this.hJK.size()), Long.valueOf(this.hJH), Integer.valueOf(this.hJI) });
      GMTrace.o(397016039424L, 2958);
      return str;
    }
  }
  
  public static final class b
  {
    long fKY;
    long fileLenInvalidCount;
    final String hJE;
    long hJF;
    long hJG;
    boolean hJL;
    final int tag;
    
    b(String paramString, int paramInt)
    {
      GMTrace.i(409498288128L, 3051);
      this.hJL = false;
      this.hJE = paramString;
      this.tag = paramInt;
      GMTrace.o(409498288128L, 3051);
    }
    
    public final String toString()
    {
      GMTrace.i(409632505856L, 3052);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.hJE, Boolean.valueOf(this.hJL), Long.valueOf(this.hJF), Long.valueOf(this.hJG), Long.valueOf(this.fKY), Long.valueOf(this.fileLenInvalidCount) });
      GMTrace.o(409632505856L, 3052);
      return str;
    }
  }
  
  public static final class c
  {
    long fKY;
    final String hJE;
    long hJF;
    long hJG;
    boolean hJL;
    long hJM;
    
    c(String paramString)
    {
      GMTrace.i(405874409472L, 3024);
      this.hJL = false;
      this.hJE = paramString;
      GMTrace.o(405874409472L, 3024);
    }
    
    public final String toString()
    {
      GMTrace.i(406008627200L, 3025);
      String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.hJE, Boolean.valueOf(this.hJL), Long.valueOf(this.hJF), Long.valueOf(this.hJG), Long.valueOf(this.fKY), Long.valueOf(this.hJM) });
      GMTrace.o(406008627200L, 3025);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */