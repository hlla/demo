package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class jz
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public String jMD;
  public String tou;
  public String tov;
  public String tow;
  public int tox;
  public String toy;
  
  public jz()
  {
    GMTrace.i(13343255429120L, 99415);
    GMTrace.o(13343255429120L, 99415);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13343389646848L, 99416);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      if (this.jMD != null) {
        paramVarArgs.e(2, this.jMD);
      }
      if (this.tou != null) {
        paramVarArgs.e(3, this.tou);
      }
      if (this.tov != null) {
        paramVarArgs.e(4, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(5, this.tow);
      }
      paramVarArgs.eO(6, this.tox);
      if (this.toy != null) {
        paramVarArgs.e(7, this.toy);
      }
      GMTrace.o(13343389646848L, 99416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label601;
      }
    }
    label601:
    for (int i = a.a.a.b.b.a.f(1, this.jLx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jMD != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.jMD);
      }
      i = paramInt;
      if (this.tou != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tou);
      }
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tov);
      }
      i = paramInt;
      if (this.tow != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tow);
      }
      i += a.a.a.a.eL(6, this.tox);
      paramInt = i;
      if (this.toy != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.toy);
      }
      GMTrace.o(13343389646848L, 99416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13343389646848L, 99416);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        jz localjz = (jz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13343389646848L, 99416);
          return -1;
        case 1: 
          localjz.jLx = locala.xky.readString();
          GMTrace.o(13343389646848L, 99416);
          return 0;
        case 2: 
          localjz.jMD = locala.xky.readString();
          GMTrace.o(13343389646848L, 99416);
          return 0;
        case 3: 
          localjz.tou = locala.xky.readString();
          GMTrace.o(13343389646848L, 99416);
          return 0;
        case 4: 
          localjz.tov = locala.xky.readString();
          GMTrace.o(13343389646848L, 99416);
          return 0;
        case 5: 
          localjz.tow = locala.xky.readString();
          GMTrace.o(13343389646848L, 99416);
          return 0;
        case 6: 
          localjz.tox = locala.xky.mL();
          GMTrace.o(13343389646848L, 99416);
          return 0;
        }
        localjz.toy = locala.xky.readString();
        GMTrace.o(13343389646848L, 99416);
        return 0;
      }
      GMTrace.o(13343389646848L, 99416);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */