package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;

public final class ajn
  extends com.tencent.mm.bd.a
{
  public float aLh;
  public String hAn;
  public String nbU;
  public String qth;
  public int qtj;
  public int qtl;
  public int score;
  public String tLF;
  public String tLG;
  public int tLH;
  public int tLI;
  public b tLJ;
  public float tlt;
  public float tlu;
  
  public ajn()
  {
    GMTrace.i(3845740560384L, 28653);
    GMTrace.o(3845740560384L, 28653);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3845874778112L, 28654);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.n(1, this.tlt);
      paramVarArgs.n(2, this.tlu);
      if (this.hAn != null) {
        paramVarArgs.e(3, this.hAn);
      }
      if (this.nbU != null) {
        paramVarArgs.e(4, this.nbU);
      }
      if (this.qth != null) {
        paramVarArgs.e(5, this.qth);
      }
      if (this.tLF != null) {
        paramVarArgs.e(6, this.tLF);
      }
      paramVarArgs.eO(7, this.qtj);
      if (this.tLG != null) {
        paramVarArgs.e(8, this.tLG);
      }
      paramVarArgs.eO(9, this.tLH);
      paramVarArgs.eO(10, this.tLI);
      paramVarArgs.eO(11, this.qtl);
      paramVarArgs.n(12, this.aLh);
      if (this.tLJ != null) {
        paramVarArgs.b(13, this.tLJ);
      }
      paramVarArgs.eO(14, this.score);
      GMTrace.o(3845874778112L, 28654);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.b.b.a.cH(1) + 4 + 0 + (a.a.a.b.b.a.cH(2) + 4);
      paramInt = i;
      if (this.hAn != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.hAn);
      }
      i = paramInt;
      if (this.nbU != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.nbU);
      }
      paramInt = i;
      if (this.qth != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.qth);
      }
      i = paramInt;
      if (this.tLF != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.tLF);
      }
      i += a.a.a.a.eL(7, this.qtj);
      paramInt = i;
      if (this.tLG != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tLG);
      }
      i = paramInt + a.a.a.a.eL(9, this.tLH) + a.a.a.a.eL(10, this.tLI) + a.a.a.a.eL(11, this.qtl) + (a.a.a.b.b.a.cH(12) + 4);
      paramInt = i;
      if (this.tLJ != null) {
        paramInt = i + a.a.a.a.a(13, this.tLJ);
      }
      i = a.a.a.a.eL(14, this.score);
      GMTrace.o(3845874778112L, 28654);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3845874778112L, 28654);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ajn localajn = (ajn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3845874778112L, 28654);
        return -1;
      case 1: 
        localajn.tlt = locala.xky.readFloat();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 2: 
        localajn.tlu = locala.xky.readFloat();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 3: 
        localajn.hAn = locala.xky.readString();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 4: 
        localajn.nbU = locala.xky.readString();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 5: 
        localajn.qth = locala.xky.readString();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 6: 
        localajn.tLF = locala.xky.readString();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 7: 
        localajn.qtj = locala.xky.mL();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 8: 
        localajn.tLG = locala.xky.readString();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 9: 
        localajn.tLH = locala.xky.mL();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 10: 
        localajn.tLI = locala.xky.mL();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 11: 
        localajn.qtl = locala.xky.mL();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 12: 
        localajn.aLh = locala.xky.readFloat();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      case 13: 
        localajn.tLJ = locala.chR();
        GMTrace.o(3845874778112L, 28654);
        return 0;
      }
      localajn.score = locala.xky.mL();
      GMTrace.o(3845874778112L, 28654);
      return 0;
    }
    GMTrace.o(3845874778112L, 28654);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ajn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */