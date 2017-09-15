package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;

public class SubDirInfo
  extends com.tencent.mm.bd.a
{
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount;
  public int tag_;
  public long totalSize_;
  
  public SubDirInfo()
  {
    GMTrace.i(17507763093504L, 130443);
    GMTrace.o(17507763093504L, 130443);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17507897311232L, 130444);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tag_);
      paramVarArgs.O(2, this.totalSize_);
      paramVarArgs.O(3, this.dirCount_);
      paramVarArgs.O(4, this.fileCount_);
      paramVarArgs.O(5, this.fileLenInvalidCount);
      GMTrace.o(17507897311232L, 130444);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tag_);
      int i = a.a.a.a.N(2, this.totalSize_);
      int j = a.a.a.a.N(3, this.dirCount_);
      int k = a.a.a.a.N(4, this.fileCount_);
      int m = a.a.a.a.N(5, this.fileLenInvalidCount);
      GMTrace.o(17507897311232L, 130444);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(17507897311232L, 130444);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      SubDirInfo localSubDirInfo = (SubDirInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(17507897311232L, 130444);
        return -1;
      case 1: 
        localSubDirInfo.tag_ = locala.xky.mL();
        GMTrace.o(17507897311232L, 130444);
        return 0;
      case 2: 
        localSubDirInfo.totalSize_ = locala.xky.mM();
        GMTrace.o(17507897311232L, 130444);
        return 0;
      case 3: 
        localSubDirInfo.dirCount_ = locala.xky.mM();
        GMTrace.o(17507897311232L, 130444);
        return 0;
      case 4: 
        localSubDirInfo.fileCount_ = locala.xky.mM();
        GMTrace.o(17507897311232L, 130444);
        return 0;
      }
      localSubDirInfo.fileLenInvalidCount = locala.xky.mM();
      GMTrace.o(17507897311232L, 130444);
      return 0;
    }
    GMTrace.o(17507897311232L, 130444);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/SubDirInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */