package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;

public class IMBehaviorMsgOP
  extends com.tencent.mm.bd.a
{
  public int appMsgInnerType;
  public int count;
  public int msgOpType;
  public int msgType;
  
  public IMBehaviorMsgOP()
  {
    GMTrace.i(10713527484416L, 79822);
    GMTrace.o(10713527484416L, 79822);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(10713661702144L, 79823);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.msgType);
      paramVarArgs.eO(2, this.msgOpType);
      paramVarArgs.eO(3, this.appMsgInnerType);
      paramVarArgs.eO(4, this.count);
      GMTrace.o(10713661702144L, 79823);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.msgType);
      int i = a.a.a.a.eL(2, this.msgOpType);
      int j = a.a.a.a.eL(3, this.appMsgInnerType);
      int k = a.a.a.a.eL(4, this.count);
      GMTrace.o(10713661702144L, 79823);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(10713661702144L, 79823);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      IMBehaviorMsgOP localIMBehaviorMsgOP = (IMBehaviorMsgOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(10713661702144L, 79823);
        return -1;
      case 1: 
        localIMBehaviorMsgOP.msgType = locala.xky.mL();
        GMTrace.o(10713661702144L, 79823);
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.xky.mL();
        GMTrace.o(10713661702144L, 79823);
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.xky.mL();
        GMTrace.o(10713661702144L, 79823);
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.xky.mL();
      GMTrace.o(10713661702144L, 79823);
      return 0;
    }
    GMTrace.o(10713661702144L, 79823);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/IMBehaviorMsgOP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */