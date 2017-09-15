package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class IMBehavior
  extends com.tencent.mm.bd.a
{
  public IMBehaviorChattingOP chattingOp;
  public IMBehaviorMsgOP msgOp;
  public int opType;
  
  public IMBehavior()
  {
    GMTrace.i(10715674968064L, 79838);
    GMTrace.o(10715674968064L, 79838);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(10715809185792L, 79839);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.opType);
      if (this.chattingOp != null)
      {
        paramVarArgs.eQ(2, this.chattingOp.aUd());
        this.chattingOp.a(paramVarArgs);
      }
      if (this.msgOp != null)
      {
        paramVarArgs.eQ(3, this.msgOp.aUd());
        this.msgOp.a(paramVarArgs);
      }
      GMTrace.o(10715809185792L, 79839);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.opType) + 0;
      paramInt = i;
      if (this.chattingOp != null) {
        paramInt = i + a.a.a.a.eN(2, this.chattingOp.aUd());
      }
      i = paramInt;
      if (this.msgOp != null) {
        i = paramInt + a.a.a.a.eN(3, this.msgOp.aUd());
      }
      GMTrace.o(10715809185792L, 79839);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(10715809185792L, 79839);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      IMBehavior localIMBehavior = (IMBehavior)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(10715809185792L, 79839);
        return -1;
      case 1: 
        localIMBehavior.opType = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(10715809185792L, 79839);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new IMBehaviorChattingOP();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((IMBehaviorChattingOP)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localIMBehavior.chattingOp = ((IMBehaviorChattingOP)localObject1);
          paramInt += 1;
        }
        GMTrace.o(10715809185792L, 79839);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehaviorMsgOP();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((IMBehaviorMsgOP)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localIMBehavior.msgOp = ((IMBehaviorMsgOP)localObject1);
        paramInt += 1;
      }
      GMTrace.o(10715809185792L, 79839);
      return 0;
    }
    GMTrace.o(10715809185792L, 79839);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/IMBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */