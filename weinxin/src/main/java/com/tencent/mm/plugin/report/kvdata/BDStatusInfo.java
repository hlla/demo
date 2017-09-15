package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class BDStatusInfo
  extends com.tencent.mm.bd.a
{
  public long favDBSize_;
  public long mmDBSize_;
  public int mmDBTableCount_;
  public long snsDBSize_;
  public LinkedList<TableInfo> tableList_;
  
  public BDStatusInfo()
  {
    GMTrace.i(17508031528960L, 130445);
    this.tableList_ = new LinkedList();
    GMTrace.o(17508031528960L, 130445);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17508165746688L, 130446);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.O(1, this.mmDBSize_);
      paramVarArgs.O(2, this.snsDBSize_);
      paramVarArgs.eO(3, this.mmDBTableCount_);
      paramVarArgs.d(4, 8, this.tableList_);
      paramVarArgs.O(5, this.favDBSize_);
      GMTrace.o(17508165746688L, 130446);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.N(1, this.mmDBSize_);
      i = a.a.a.a.N(2, this.snsDBSize_);
      int j = a.a.a.a.eL(3, this.mmDBTableCount_);
      int k = a.a.a.a.c(4, 8, this.tableList_);
      int m = a.a.a.a.N(5, this.favDBSize_);
      GMTrace.o(17508165746688L, 130446);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tableList_.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(17508165746688L, 130446);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      BDStatusInfo localBDStatusInfo = (BDStatusInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(17508165746688L, 130446);
        return -1;
      case 1: 
        localBDStatusInfo.mmDBSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508165746688L, 130446);
        return 0;
      case 2: 
        localBDStatusInfo.snsDBSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17508165746688L, 130446);
        return 0;
      case 3: 
        localBDStatusInfo.mmDBTableCount_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17508165746688L, 130446);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new TableInfo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((TableInfo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localBDStatusInfo.tableList_.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(17508165746688L, 130446);
        return 0;
      }
      localBDStatusInfo.favDBSize_ = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(17508165746688L, 130446);
      return 0;
    }
    GMTrace.o(17508165746688L, 130446);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/BDStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */