package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class biz
  extends com.tencent.mm.bd.a
{
  public String oSl;
  public String tAe;
  public String tXu;
  public String ugV;
  public int ugW;
  public String ugX;
  public String ugY;
  public int ugZ;
  public String uha;
  
  public biz()
  {
    GMTrace.i(3881979346944L, 28923);
    GMTrace.o(3881979346944L, 28923);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3882113564672L, 28924);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.oSl != null) {
        paramVarArgs.e(1, this.oSl);
      }
      if (this.ugV != null) {
        paramVarArgs.e(2, this.ugV);
      }
      if (this.tAe != null) {
        paramVarArgs.e(3, this.tAe);
      }
      paramVarArgs.eO(4, this.ugW);
      if (this.tXu != null) {
        paramVarArgs.e(5, this.tXu);
      }
      if (this.ugX != null) {
        paramVarArgs.e(6, this.ugX);
      }
      if (this.ugY != null) {
        paramVarArgs.e(7, this.ugY);
      }
      paramVarArgs.eO(8, this.ugZ);
      if (this.uha != null) {
        paramVarArgs.e(9, this.uha);
      }
      GMTrace.o(3882113564672L, 28924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oSl == null) {
        break label730;
      }
    }
    label730:
    for (int i = a.a.a.b.b.a.f(1, this.oSl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ugV != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.ugV);
      }
      i = paramInt;
      if (this.tAe != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tAe);
      }
      i += a.a.a.a.eL(4, this.ugW);
      paramInt = i;
      if (this.tXu != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tXu);
      }
      i = paramInt;
      if (this.ugX != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.ugX);
      }
      paramInt = i;
      if (this.ugY != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.ugY);
      }
      i = paramInt + a.a.a.a.eL(8, this.ugZ);
      paramInt = i;
      if (this.uha != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.uha);
      }
      GMTrace.o(3882113564672L, 28924);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3882113564672L, 28924);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        biz localbiz = (biz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3882113564672L, 28924);
          return -1;
        case 1: 
          localbiz.oSl = locala.xky.readString();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 2: 
          localbiz.ugV = locala.xky.readString();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 3: 
          localbiz.tAe = locala.xky.readString();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 4: 
          localbiz.ugW = locala.xky.mL();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 5: 
          localbiz.tXu = locala.xky.readString();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 6: 
          localbiz.ugX = locala.xky.readString();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 7: 
          localbiz.ugY = locala.xky.readString();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        case 8: 
          localbiz.ugZ = locala.xky.mL();
          GMTrace.o(3882113564672L, 28924);
          return 0;
        }
        localbiz.uha = locala.xky.readString();
        GMTrace.o(3882113564672L, 28924);
        return 0;
      }
      GMTrace.o(3882113564672L, 28924);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/biz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */