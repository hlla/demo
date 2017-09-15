package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class gy
  extends com.tencent.mm.bd.a
{
  public String tjf;
  public int tjp;
  public int tjq;
  public int tjr;
  public int tjs;
  public long tjt;
  public long tju;
  
  public gy()
  {
    GMTrace.i(3667096764416L, 27322);
    GMTrace.o(3667096764416L, 27322);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3667230982144L, 27323);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjf == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.tjf != null) {
        paramVarArgs.e(1, this.tjf);
      }
      paramVarArgs.eO(2, this.tjp);
      paramVarArgs.eO(3, this.tjq);
      paramVarArgs.eO(4, this.tjr);
      paramVarArgs.eO(5, this.tjs);
      paramVarArgs.O(6, this.tjt);
      paramVarArgs.O(7, this.tju);
      GMTrace.o(3667230982144L, 27323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjf == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = a.a.a.b.b.a.f(1, this.tjf) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.tjp);
      int j = a.a.a.a.eL(3, this.tjq);
      int k = a.a.a.a.eL(4, this.tjr);
      int m = a.a.a.a.eL(5, this.tjs);
      int n = a.a.a.a.N(6, this.tjt);
      int i1 = a.a.a.a.N(7, this.tju);
      GMTrace.o(3667230982144L, 27323);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.tjf == null) {
          throw new b("Not all required fields were included: brand_user_name");
        }
        GMTrace.o(3667230982144L, 27323);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        gy localgy = (gy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3667230982144L, 27323);
          return -1;
        case 1: 
          localgy.tjf = locala.xky.readString();
          GMTrace.o(3667230982144L, 27323);
          return 0;
        case 2: 
          localgy.tjp = locala.xky.mL();
          GMTrace.o(3667230982144L, 27323);
          return 0;
        case 3: 
          localgy.tjq = locala.xky.mL();
          GMTrace.o(3667230982144L, 27323);
          return 0;
        case 4: 
          localgy.tjr = locala.xky.mL();
          GMTrace.o(3667230982144L, 27323);
          return 0;
        case 5: 
          localgy.tjs = locala.xky.mL();
          GMTrace.o(3667230982144L, 27323);
          return 0;
        case 6: 
          localgy.tjt = locala.xky.mM();
          GMTrace.o(3667230982144L, 27323);
          return 0;
        }
        localgy.tju = locala.xky.mM();
        GMTrace.o(3667230982144L, 27323);
        return 0;
      }
      GMTrace.o(3667230982144L, 27323);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */