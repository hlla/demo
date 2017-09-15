package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class afq
  extends com.tencent.mm.bd.a
{
  public String desc;
  public String tJe;
  public String tJf;
  public String title;
  
  public afq()
  {
    GMTrace.i(3700516978688L, 27571);
    GMTrace.o(3700516978688L, 27571);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3700651196416L, 27572);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.tJe != null) {
        paramVarArgs.e(3, this.tJe);
      }
      if (this.tJf != null) {
        paramVarArgs.e(4, this.tJf);
      }
      GMTrace.o(3700651196416L, 27572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label434;
      }
    }
    label434:
    for (int i = a.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.tJe != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tJe);
      }
      paramInt = i;
      if (this.tJf != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tJf);
      }
      GMTrace.o(3700651196416L, 27572);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3700651196416L, 27572);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        afq localafq = (afq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3700651196416L, 27572);
          return -1;
        case 1: 
          localafq.title = locala.xky.readString();
          GMTrace.o(3700651196416L, 27572);
          return 0;
        case 2: 
          localafq.desc = locala.xky.readString();
          GMTrace.o(3700651196416L, 27572);
          return 0;
        case 3: 
          localafq.tJe = locala.xky.readString();
          GMTrace.o(3700651196416L, 27572);
          return 0;
        }
        localafq.tJf = locala.xky.readString();
        GMTrace.o(3700651196416L, 27572);
        return 0;
      }
      GMTrace.o(3700651196416L, 27572);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */