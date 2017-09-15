package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class cy
  extends com.tencent.mm.bd.a
{
  public String mqG;
  public String msg;
  public int teN;
  
  public cy()
  {
    GMTrace.i(3753935634432L, 27969);
    GMTrace.o(3753935634432L, 27969);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3754069852160L, 27970);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqG != null) {
        paramVarArgs.e(1, this.mqG);
      }
      paramVarArgs.eO(2, this.teN);
      if (this.msg != null) {
        paramVarArgs.e(3, this.msg);
      }
      GMTrace.o(3754069852160L, 27970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mqG == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = a.a.a.b.b.a.f(1, this.mqG) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.teN);
      paramInt = i;
      if (this.msg != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.msg);
      }
      GMTrace.o(3754069852160L, 27970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3754069852160L, 27970);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3754069852160L, 27970);
          return -1;
        case 1: 
          localcy.mqG = locala.xky.readString();
          GMTrace.o(3754069852160L, 27970);
          return 0;
        case 2: 
          localcy.teN = locala.xky.mL();
          GMTrace.o(3754069852160L, 27970);
          return 0;
        }
        localcy.msg = locala.xky.readString();
        GMTrace.o(3754069852160L, 27970);
        return 0;
      }
      GMTrace.o(3754069852160L, 27970);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */