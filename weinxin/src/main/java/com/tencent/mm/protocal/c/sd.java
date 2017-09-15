package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class sd
  extends com.tencent.mm.bd.a
{
  public int txQ;
  public int txR;
  public int txS;
  public int txT;
  public int txU;
  public int txV;
  public int txW;
  public int txX;
  public int txY;
  public int txZ;
  public int tya;
  public int tyb;
  public int tyc;
  public int tyd;
  public int tye;
  
  public sd()
  {
    GMTrace.i(3968012910592L, 29564);
    GMTrace.o(3968012910592L, 29564);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3968147128320L, 29565);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.txQ);
      paramVarArgs.eO(2, this.txR);
      paramVarArgs.eO(3, this.txS);
      paramVarArgs.eO(4, this.txT);
      paramVarArgs.eO(5, this.txU);
      paramVarArgs.eO(6, this.txV);
      paramVarArgs.eO(7, this.txW);
      paramVarArgs.eO(8, this.txX);
      paramVarArgs.eO(9, this.txY);
      paramVarArgs.eO(10, this.txZ);
      paramVarArgs.eO(11, this.tya);
      paramVarArgs.eO(12, this.tyb);
      paramVarArgs.eO(13, this.tyc);
      paramVarArgs.eO(14, this.tyd);
      paramVarArgs.eO(15, this.tye);
      GMTrace.o(3968147128320L, 29565);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.txQ);
      int i = a.a.a.a.eL(2, this.txR);
      int j = a.a.a.a.eL(3, this.txS);
      int k = a.a.a.a.eL(4, this.txT);
      int m = a.a.a.a.eL(5, this.txU);
      int n = a.a.a.a.eL(6, this.txV);
      int i1 = a.a.a.a.eL(7, this.txW);
      int i2 = a.a.a.a.eL(8, this.txX);
      int i3 = a.a.a.a.eL(9, this.txY);
      int i4 = a.a.a.a.eL(10, this.txZ);
      int i5 = a.a.a.a.eL(11, this.tya);
      int i6 = a.a.a.a.eL(12, this.tyb);
      int i7 = a.a.a.a.eL(13, this.tyc);
      int i8 = a.a.a.a.eL(14, this.tyd);
      int i9 = a.a.a.a.eL(15, this.tye);
      GMTrace.o(3968147128320L, 29565);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3968147128320L, 29565);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      sd localsd = (sd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3968147128320L, 29565);
        return -1;
      case 1: 
        localsd.txQ = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 2: 
        localsd.txR = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 3: 
        localsd.txS = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 4: 
        localsd.txT = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 5: 
        localsd.txU = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 6: 
        localsd.txV = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 7: 
        localsd.txW = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 8: 
        localsd.txX = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 9: 
        localsd.txY = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 10: 
        localsd.txZ = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 11: 
        localsd.tya = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 12: 
        localsd.tyb = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 13: 
        localsd.tyc = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      case 14: 
        localsd.tyd = locala.xky.mL();
        GMTrace.o(3968147128320L, 29565);
        return 0;
      }
      localsd.tye = locala.xky.mL();
      GMTrace.o(3968147128320L, 29565);
      return 0;
    }
    GMTrace.o(3968147128320L, 29565);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/sd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */