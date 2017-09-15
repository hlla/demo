package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aoe
  extends com.tencent.mm.bd.a
{
  public String hNH;
  public int tRG;
  public int tRH;
  public String tRI;
  public int tRJ;
  public String tRK;
  public int tkk;
  public int tpX;
  public int trj;
  
  public aoe()
  {
    GMTrace.i(3645353492480L, 27160);
    GMTrace.o(3645353492480L, 27160);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3645487710208L, 27161);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.hNH != null) {
        paramVarArgs.e(1, this.hNH);
      }
      paramVarArgs.eO(2, this.tRG);
      paramVarArgs.eO(3, this.tRH);
      paramVarArgs.eO(4, this.tkk);
      if (this.tRI != null) {
        paramVarArgs.e(5, this.tRI);
      }
      paramVarArgs.eO(6, this.trj);
      paramVarArgs.eO(7, this.tRJ);
      paramVarArgs.eO(8, this.tpX);
      if (this.tRK != null) {
        paramVarArgs.e(9, this.tRK);
      }
      GMTrace.o(3645487710208L, 27161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNH == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = a.a.a.b.b.a.f(1, this.hNH) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.tRG) + a.a.a.a.eL(3, this.tRH) + a.a.a.a.eL(4, this.tkk);
      paramInt = i;
      if (this.tRI != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tRI);
      }
      i = paramInt + a.a.a.a.eL(6, this.trj) + a.a.a.a.eL(7, this.tRJ) + a.a.a.a.eL(8, this.tpX);
      paramInt = i;
      if (this.tRK != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.tRK);
      }
      GMTrace.o(3645487710208L, 27161);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3645487710208L, 27161);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aoe localaoe = (aoe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3645487710208L, 27161);
          return -1;
        case 1: 
          localaoe.hNH = locala.xky.readString();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 2: 
          localaoe.tRG = locala.xky.mL();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 3: 
          localaoe.tRH = locala.xky.mL();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 4: 
          localaoe.tkk = locala.xky.mL();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 5: 
          localaoe.tRI = locala.xky.readString();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 6: 
          localaoe.trj = locala.xky.mL();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 7: 
          localaoe.tRJ = locala.xky.mL();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        case 8: 
          localaoe.tpX = locala.xky.mL();
          GMTrace.o(3645487710208L, 27161);
          return 0;
        }
        localaoe.tRK = locala.xky.readString();
        GMTrace.o(3645487710208L, 27161);
        return 0;
      }
      GMTrace.o(3645487710208L, 27161);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */