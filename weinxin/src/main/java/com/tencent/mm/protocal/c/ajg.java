package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ajg
  extends com.tencent.mm.bd.a
{
  public String thK;
  public String thL;
  public String thM;
  
  public ajg()
  {
    GMTrace.i(13336007671808L, 99361);
    GMTrace.o(13336007671808L, 99361);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13336141889536L, 99362);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.thL != null) {
        paramVarArgs.e(1, this.thL);
      }
      if (this.thK != null) {
        paramVarArgs.e(2, this.thK);
      }
      if (this.thM != null) {
        paramVarArgs.e(3, this.thM);
      }
      GMTrace.o(13336141889536L, 99362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thL == null) {
        break label361;
      }
    }
    label361:
    for (int i = a.a.a.b.b.a.f(1, this.thL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thK != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.thK);
      }
      i = paramInt;
      if (this.thM != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.thM);
      }
      GMTrace.o(13336141889536L, 99362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13336141889536L, 99362);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ajg localajg = (ajg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13336141889536L, 99362);
          return -1;
        case 1: 
          localajg.thL = locala.xky.readString();
          GMTrace.o(13336141889536L, 99362);
          return 0;
        case 2: 
          localajg.thK = locala.xky.readString();
          GMTrace.o(13336141889536L, 99362);
          return 0;
        }
        localajg.thM = locala.xky.readString();
        GMTrace.o(13336141889536L, 99362);
        return 0;
      }
      GMTrace.o(13336141889536L, 99362);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ajg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */