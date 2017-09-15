package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class baw
  extends com.tencent.mm.bd.a
{
  public int jMq;
  public int ofk;
  public String oog;
  public String tLN;
  public int tPi;
  public int tZX;
  public int tZY;
  public int tZZ;
  public int teq;
  public String tfa;
  public long uaa;
  public long uab;
  public int uad;
  public String uas;
  
  public baw()
  {
    GMTrace.i(3769236455424L, 28083);
    GMTrace.o(3769236455424L, 28083);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3769370673152L, 28084);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfa != null) {
        paramVarArgs.e(1, this.tfa);
      }
      if (this.tLN != null) {
        paramVarArgs.e(2, this.tLN);
      }
      paramVarArgs.eO(3, this.teq);
      paramVarArgs.eO(4, this.jMq);
      if (this.oog != null) {
        paramVarArgs.e(5, this.oog);
      }
      paramVarArgs.eO(6, this.ofk);
      paramVarArgs.eO(7, this.tZY);
      paramVarArgs.eO(8, this.tZX);
      if (this.uas != null) {
        paramVarArgs.e(9, this.uas);
      }
      paramVarArgs.eO(10, this.tZZ);
      paramVarArgs.O(11, this.uaa);
      paramVarArgs.O(12, this.uab);
      paramVarArgs.eO(13, this.tPi);
      paramVarArgs.eO(14, this.uad);
      GMTrace.o(3769370673152L, 28084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tfa == null) {
        break label934;
      }
    }
    label934:
    for (paramInt = a.a.a.b.b.a.f(1, this.tfa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tLN != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tLN);
      }
      i = i + a.a.a.a.eL(3, this.teq) + a.a.a.a.eL(4, this.jMq);
      paramInt = i;
      if (this.oog != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.oog);
      }
      i = paramInt + a.a.a.a.eL(6, this.ofk) + a.a.a.a.eL(7, this.tZY) + a.a.a.a.eL(8, this.tZX);
      paramInt = i;
      if (this.uas != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.uas);
      }
      i = a.a.a.a.eL(10, this.tZZ);
      int j = a.a.a.a.N(11, this.uaa);
      int k = a.a.a.a.N(12, this.uab);
      int m = a.a.a.a.eL(13, this.tPi);
      int n = a.a.a.a.eL(14, this.uad);
      GMTrace.o(3769370673152L, 28084);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3769370673152L, 28084);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        baw localbaw = (baw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3769370673152L, 28084);
          return -1;
        case 1: 
          localbaw.tfa = locala.xky.readString();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 2: 
          localbaw.tLN = locala.xky.readString();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 3: 
          localbaw.teq = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 4: 
          localbaw.jMq = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 5: 
          localbaw.oog = locala.xky.readString();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 6: 
          localbaw.ofk = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 7: 
          localbaw.tZY = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 8: 
          localbaw.tZX = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 9: 
          localbaw.uas = locala.xky.readString();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 10: 
          localbaw.tZZ = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 11: 
          localbaw.uaa = locala.xky.mM();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 12: 
          localbaw.uab = locala.xky.mM();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        case 13: 
          localbaw.tPi = locala.xky.mL();
          GMTrace.o(3769370673152L, 28084);
          return 0;
        }
        localbaw.uad = locala.xky.mL();
        GMTrace.o(3769370673152L, 28084);
        return 0;
      }
      GMTrace.o(3769370673152L, 28084);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/baw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */