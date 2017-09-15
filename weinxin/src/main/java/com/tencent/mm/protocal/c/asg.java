package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class asg
  extends com.tencent.mm.bd.a
{
  public int tEI;
  public int tUZ;
  public String tsQ;
  public int tug;
  public String tyT;
  
  public asg()
  {
    GMTrace.i(3938485010432L, 29344);
    GMTrace.o(3938485010432L, 29344);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3938619228160L, 29345);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tEI);
      if (this.tyT != null) {
        paramVarArgs.e(2, this.tyT);
      }
      if (this.tsQ != null) {
        paramVarArgs.e(3, this.tsQ);
      }
      paramVarArgs.eO(4, this.tug);
      paramVarArgs.eO(5, this.tUZ);
      GMTrace.o(3938619228160L, 29345);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tEI) + 0;
      paramInt = i;
      if (this.tyT != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tyT);
      }
      i = paramInt;
      if (this.tsQ != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tsQ);
      }
      paramInt = a.a.a.a.eL(4, this.tug);
      int j = a.a.a.a.eL(5, this.tUZ);
      GMTrace.o(3938619228160L, 29345);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3938619228160L, 29345);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      asg localasg = (asg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3938619228160L, 29345);
        return -1;
      case 1: 
        localasg.tEI = locala.xky.mL();
        GMTrace.o(3938619228160L, 29345);
        return 0;
      case 2: 
        localasg.tyT = locala.xky.readString();
        GMTrace.o(3938619228160L, 29345);
        return 0;
      case 3: 
        localasg.tsQ = locala.xky.readString();
        GMTrace.o(3938619228160L, 29345);
        return 0;
      case 4: 
        localasg.tug = locala.xky.mL();
        GMTrace.o(3938619228160L, 29345);
        return 0;
      }
      localasg.tUZ = locala.xky.mL();
      GMTrace.o(3938619228160L, 29345);
      return 0;
    }
    GMTrace.o(3938619228160L, 29345);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/asg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */