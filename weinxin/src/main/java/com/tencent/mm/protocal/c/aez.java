package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aez
  extends com.tencent.mm.bd.a
{
  public String tIG;
  public String tIH;
  public int tII;
  
  public aez()
  {
    GMTrace.i(13573841485824L, 101133);
    GMTrace.o(13573841485824L, 101133);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13573975703552L, 101134);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tIG != null) {
        paramVarArgs.e(1, this.tIG);
      }
      if (this.tIH != null) {
        paramVarArgs.e(2, this.tIH);
      }
      paramVarArgs.eO(3, this.tII);
      GMTrace.o(13573975703552L, 101134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tIG == null) {
        break label345;
      }
    }
    label345:
    for (paramInt = a.a.a.b.b.a.f(1, this.tIG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tIH != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tIH);
      }
      paramInt = a.a.a.a.eL(3, this.tII);
      GMTrace.o(13573975703552L, 101134);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13573975703552L, 101134);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aez localaez = (aez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13573975703552L, 101134);
          return -1;
        case 1: 
          localaez.tIG = locala.xky.readString();
          GMTrace.o(13573975703552L, 101134);
          return 0;
        case 2: 
          localaez.tIH = locala.xky.readString();
          GMTrace.o(13573975703552L, 101134);
          return 0;
        }
        localaez.tII = locala.xky.mL();
        GMTrace.o(13573975703552L, 101134);
        return 0;
      }
      GMTrace.o(13573975703552L, 101134);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */