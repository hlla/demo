package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class WeChatSDInfo
  extends com.tencent.mm.bd.a
{
  public int depth_;
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount_;
  public LinkedList<SubDirInfo> subDirList_;
  public int subDirResultsSize_;
  public long tempAccDirCount_;
  public int tempAccDirResultsSize_;
  public long tempAccFileCount_;
  public long tempAccFileLenInvalidCount_;
  public long tempAccTotalSize_;
  public long totalSize_;
  public long totalTime_;
  
  public WeChatSDInfo()
  {
    GMTrace.i(17508568399872L, 130449);
    this.subDirList_ = new LinkedList();
    GMTrace.o(17508568399872L, 130449);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17508702617600L, 130450);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.O(1, this.totalSize_);
      paramVarArgs.O(2, this.dirCount_);
      paramVarArgs.O(3, this.fileCount_);
      paramVarArgs.O(4, this.fileLenInvalidCount_);
      paramVarArgs.eO(5, this.subDirResultsSize_);
      paramVarArgs.O(6, this.totalTime_);
      paramVarArgs.eO(7, this.depth_);
      paramVarArgs.O(8, this.tempAccTotalSize_);
      paramVarArgs.eO(9, this.tempAccDirResultsSize_);
      paramVarArgs.O(10, this.tempAccDirCount_);
      paramVarArgs.O(11, this.tempAccFileCount_);
      paramVarArgs.O(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.d(13, 8, this.subDirList_);
      GMTrace.o(17508702617600L, 130450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.N(1, this.totalSize_);
      i = a.a.a.a.N(2, this.dirCount_);
      int j = a.a.a.a.N(3, this.fileCount_);
      int k = a.a.a.a.N(4, this.fileLenInvalidCount_);
      int m = a.a.a.a.eL(5, this.subDirResultsSize_);
      int n = a.a.a.a.N(6, this.totalTime_);
      int i1 = a.a.a.a.eL(7, this.depth_);
      int i2 = a.a.a.a.N(8, this.tempAccTotalSize_);
      int i3 = a.a.a.a.eL(9, this.tempAccDirResultsSize_);
      int i4 = a.a.a.a.N(10, this.tempAccDirCount_);
      int i5 = a.a.a.a.N(11, this.tempAccFileCount_);
      int i6 = a.a.a.a.N(12, this.tempAccFileLenInvalidCount_);
      int i7 = a.a.a.a.c(13, 8, this.subDirList_);
      GMTrace.o(17508702617600L, 130450);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(17508702617600L, 130450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(17508702617600L, 130450);
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508702617600L, 130450);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SubDirInfo();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SubDirInfo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localWeChatSDInfo.subDirList_.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(17508702617600L, 130450);
      return 0;
    }
    GMTrace.o(17508702617600L, 130450);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/WeChatSDInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */