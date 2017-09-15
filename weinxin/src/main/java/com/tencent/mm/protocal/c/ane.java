package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ane
  extends com.tencent.mm.bd.a
{
  public String tQs;
  public String tQt;
  public int tQu;
  public int tQv;
  public int tQw;
  public int tQx;
  
  public ane()
  {
    GMTrace.i(13581894549504L, 101193);
    GMTrace.o(13581894549504L, 101193);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13582028767232L, 101194);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tQs != null) {
        paramVarArgs.e(1, this.tQs);
      }
      if (this.tQt != null) {
        paramVarArgs.e(2, this.tQt);
      }
      paramVarArgs.eO(3, this.tQu);
      paramVarArgs.eO(4, this.tQv);
      paramVarArgs.eO(5, this.tQw);
      paramVarArgs.eO(7, this.tQx);
      GMTrace.o(13582028767232L, 101194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tQs == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = a.a.a.b.b.a.f(1, this.tQs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tQt != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tQt);
      }
      paramInt = a.a.a.a.eL(3, this.tQu);
      int j = a.a.a.a.eL(4, this.tQv);
      int k = a.a.a.a.eL(5, this.tQw);
      int m = a.a.a.a.eL(7, this.tQx);
      GMTrace.o(13582028767232L, 101194);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13582028767232L, 101194);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ane localane = (ane)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          GMTrace.o(13582028767232L, 101194);
          return -1;
        case 1: 
          localane.tQs = locala.xky.readString();
          GMTrace.o(13582028767232L, 101194);
          return 0;
        case 2: 
          localane.tQt = locala.xky.readString();
          GMTrace.o(13582028767232L, 101194);
          return 0;
        case 3: 
          localane.tQu = locala.xky.mL();
          GMTrace.o(13582028767232L, 101194);
          return 0;
        case 4: 
          localane.tQv = locala.xky.mL();
          GMTrace.o(13582028767232L, 101194);
          return 0;
        case 5: 
          localane.tQw = locala.xky.mL();
          GMTrace.o(13582028767232L, 101194);
          return 0;
        }
        localane.tQx = locala.xky.mL();
        GMTrace.o(13582028767232L, 101194);
        return 0;
      }
      GMTrace.o(13582028767232L, 101194);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */