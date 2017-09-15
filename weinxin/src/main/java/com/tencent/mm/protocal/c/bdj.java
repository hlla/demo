package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bdj
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public int udd;
  
  public bdj()
  {
    GMTrace.i(3937411268608L, 29336);
    GMTrace.o(3937411268608L, 29336);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3937545486336L, 29337);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      paramVarArgs.eO(2, this.udd);
      GMTrace.o(3937545486336L, 29337);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label290;
      }
    }
    label290:
    for (paramInt = a.a.a.b.b.a.f(1, this.jLx) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.udd);
      GMTrace.o(3937545486336L, 29337);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3937545486336L, 29337);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bdj localbdj = (bdj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3937545486336L, 29337);
          return -1;
        case 1: 
          localbdj.jLx = locala.xky.readString();
          GMTrace.o(3937545486336L, 29337);
          return 0;
        }
        localbdj.udd = locala.xky.mL();
        GMTrace.o(3937545486336L, 29337);
        return 0;
      }
      GMTrace.o(3937545486336L, 29337);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */