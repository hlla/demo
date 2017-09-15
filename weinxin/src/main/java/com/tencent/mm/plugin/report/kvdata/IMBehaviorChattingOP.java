package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;

public class IMBehaviorChattingOP
  extends com.tencent.mm.bd.a
{
  public int changeNotifyStatus;
  public int changeSaveAddress;
  public int changeTop;
  public int changeUnread;
  public int expose;
  
  public IMBehaviorChattingOP()
  {
    GMTrace.i(10715138097152L, 79834);
    GMTrace.o(10715138097152L, 79834);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(10715272314880L, 79835);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.changeUnread);
      paramVarArgs.eO(2, this.changeTop);
      paramVarArgs.eO(3, this.changeNotifyStatus);
      paramVarArgs.eO(4, this.changeSaveAddress);
      paramVarArgs.eO(5, this.expose);
      GMTrace.o(10715272314880L, 79835);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.changeUnread);
      int i = a.a.a.a.eL(2, this.changeTop);
      int j = a.a.a.a.eL(3, this.changeNotifyStatus);
      int k = a.a.a.a.eL(4, this.changeSaveAddress);
      int m = a.a.a.a.eL(5, this.expose);
      GMTrace.o(10715272314880L, 79835);
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
      GMTrace.o(10715272314880L, 79835);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      IMBehaviorChattingOP localIMBehaviorChattingOP = (IMBehaviorChattingOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(10715272314880L, 79835);
        return -1;
      case 1: 
        localIMBehaviorChattingOP.changeUnread = locala.xky.mL();
        GMTrace.o(10715272314880L, 79835);
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.xky.mL();
        GMTrace.o(10715272314880L, 79835);
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.xky.mL();
        GMTrace.o(10715272314880L, 79835);
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.xky.mL();
        GMTrace.o(10715272314880L, 79835);
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.xky.mL();
      GMTrace.o(10715272314880L, 79835);
      return 0;
    }
    GMTrace.o(10715272314880L, 79835);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/IMBehaviorChattingOP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */