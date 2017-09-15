package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class afs
  extends com.tencent.mm.bd.a
{
  public int fDs;
  public int tJh;
  public int tJi;
  public int tJj;
  public int tJk;
  public int tJl;
  public int tJm;
  public int tJn;
  
  public afs()
  {
    GMTrace.i(13098442293248L, 97591);
    GMTrace.o(13098442293248L, 97591);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13098576510976L, 97592);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tJh);
      paramVarArgs.eO(2, this.fDs);
      paramVarArgs.eO(3, this.tJi);
      paramVarArgs.eO(4, this.tJj);
      paramVarArgs.eO(5, this.tJk);
      paramVarArgs.eO(6, this.tJl);
      paramVarArgs.eO(7, this.tJm);
      paramVarArgs.eO(8, this.tJn);
      GMTrace.o(13098576510976L, 97592);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tJh);
      int i = a.a.a.a.eL(2, this.fDs);
      int j = a.a.a.a.eL(3, this.tJi);
      int k = a.a.a.a.eL(4, this.tJj);
      int m = a.a.a.a.eL(5, this.tJk);
      int n = a.a.a.a.eL(6, this.tJl);
      int i1 = a.a.a.a.eL(7, this.tJm);
      int i2 = a.a.a.a.eL(8, this.tJn);
      GMTrace.o(13098576510976L, 97592);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13098576510976L, 97592);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      afs localafs = (afs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13098576510976L, 97592);
        return -1;
      case 1: 
        localafs.tJh = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      case 2: 
        localafs.fDs = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      case 3: 
        localafs.tJi = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      case 4: 
        localafs.tJj = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      case 5: 
        localafs.tJk = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      case 6: 
        localafs.tJl = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      case 7: 
        localafs.tJm = locala.xky.mL();
        GMTrace.o(13098576510976L, 97592);
        return 0;
      }
      localafs.tJn = locala.xky.mL();
      GMTrace.o(13098576510976L, 97592);
      return 0;
    }
    GMTrace.o(13098576510976L, 97592);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */