package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ajj
  extends com.tencent.mm.bd.a
{
  public int jLP;
  public String jLx;
  public String jMD;
  public String oSl;
  public String tAe;
  public String tov;
  public String tow;
  
  public ajj()
  {
    GMTrace.i(3999285641216L, 29797);
    GMTrace.o(3999285641216L, 29797);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3999419858944L, 29798);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.oSl != null) {
        paramVarArgs.e(1, this.oSl);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      paramVarArgs.eO(3, this.jLP);
      if (this.tov != null) {
        paramVarArgs.e(4, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(5, this.tow);
      }
      if (this.jMD != null) {
        paramVarArgs.e(6, this.jMD);
      }
      if (this.tAe != null) {
        paramVarArgs.e(7, this.tAe);
      }
      GMTrace.o(3999419858944L, 29798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oSl == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = a.a.a.b.b.a.f(1, this.oSl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.jLx);
      }
      i += a.a.a.a.eL(3, this.jLP);
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tov);
      }
      i = paramInt;
      if (this.tow != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tow);
      }
      paramInt = i;
      if (this.jMD != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.jMD);
      }
      i = paramInt;
      if (this.tAe != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tAe);
      }
      GMTrace.o(3999419858944L, 29798);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3999419858944L, 29798);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ajj localajj = (ajj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3999419858944L, 29798);
          return -1;
        case 1: 
          localajj.oSl = locala.xky.readString();
          GMTrace.o(3999419858944L, 29798);
          return 0;
        case 2: 
          localajj.jLx = locala.xky.readString();
          GMTrace.o(3999419858944L, 29798);
          return 0;
        case 3: 
          localajj.jLP = locala.xky.mL();
          GMTrace.o(3999419858944L, 29798);
          return 0;
        case 4: 
          localajj.tov = locala.xky.readString();
          GMTrace.o(3999419858944L, 29798);
          return 0;
        case 5: 
          localajj.tow = locala.xky.readString();
          GMTrace.o(3999419858944L, 29798);
          return 0;
        case 6: 
          localajj.jMD = locala.xky.readString();
          GMTrace.o(3999419858944L, 29798);
          return 0;
        }
        localajj.tAe = locala.xky.readString();
        GMTrace.o(3999419858944L, 29798);
        return 0;
      }
      GMTrace.o(3999419858944L, 29798);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ajj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */