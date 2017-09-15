package com.tencent.mm.protocal.b.a;

import com.tencent.gmtrace.GMTrace;

public final class d
  extends com.tencent.mm.bd.a
{
  public String desc;
  public String fKq;
  public int fSZ;
  public String lCI;
  public String title;
  
  public d()
  {
    GMTrace.i(4079547842560L, 30395);
    GMTrace.o(4079547842560L, 30395);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4079682060288L, 30396);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.fKq != null) {
        paramVarArgs.e(3, this.fKq);
      }
      paramVarArgs.eO(4, this.fSZ);
      if (this.lCI != null) {
        paramVarArgs.e(5, this.lCI);
      }
      GMTrace.o(4079682060288L, 30396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label482;
      }
    }
    label482:
    for (int i = a.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.fKq != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fKq);
      }
      i += a.a.a.a.eL(4, this.fSZ);
      paramInt = i;
      if (this.lCI != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.lCI);
      }
      GMTrace.o(4079682060288L, 30396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(4079682060288L, 30396);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(4079682060288L, 30396);
          return -1;
        case 1: 
          locald.title = locala.xky.readString();
          GMTrace.o(4079682060288L, 30396);
          return 0;
        case 2: 
          locald.desc = locala.xky.readString();
          GMTrace.o(4079682060288L, 30396);
          return 0;
        case 3: 
          locald.fKq = locala.xky.readString();
          GMTrace.o(4079682060288L, 30396);
          return 0;
        case 4: 
          locald.fSZ = locala.xky.mL();
          GMTrace.o(4079682060288L, 30396);
          return 0;
        }
        locald.lCI = locala.xky.readString();
        GMTrace.o(4079682060288L, 30396);
        return 0;
      }
      GMTrace.o(4079682060288L, 30396);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */