package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class ou
  extends com.tencent.mm.bd.a
{
  public String mrm;
  public String ofO;
  public String tfq;
  public String tsH;
  public String tsI;
  public String tsJ;
  public String tsK;
  public String tsL;
  public String tsM;
  public String tsN;
  
  public ou()
  {
    GMTrace.i(3879831863296L, 28907);
    GMTrace.o(3879831863296L, 28907);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3879966081024L, 28908);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tsH == null) {
        throw new b("Not all required fields were included: Md5");
      }
      if (this.tsH != null) {
        paramVarArgs.e(1, this.tsH);
      }
      if (this.mrm != null) {
        paramVarArgs.e(2, this.mrm);
      }
      if (this.ofO != null) {
        paramVarArgs.e(3, this.ofO);
      }
      if (this.tsI != null) {
        paramVarArgs.e(4, this.tsI);
      }
      if (this.tsJ != null) {
        paramVarArgs.e(5, this.tsJ);
      }
      if (this.tsK != null) {
        paramVarArgs.e(6, this.tsK);
      }
      if (this.tfq != null) {
        paramVarArgs.e(7, this.tfq);
      }
      if (this.tsL != null) {
        paramVarArgs.e(8, this.tsL);
      }
      if (this.tsM != null) {
        paramVarArgs.e(9, this.tsM);
      }
      if (this.tsN != null) {
        paramVarArgs.e(10, this.tsN);
      }
      GMTrace.o(3879966081024L, 28908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tsH == null) {
        break label862;
      }
    }
    label862:
    for (int i = a.a.a.b.b.a.f(1, this.tsH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrm);
      }
      i = paramInt;
      if (this.ofO != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.ofO);
      }
      paramInt = i;
      if (this.tsI != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tsI);
      }
      i = paramInt;
      if (this.tsJ != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tsJ);
      }
      paramInt = i;
      if (this.tsK != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tsK);
      }
      i = paramInt;
      if (this.tfq != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tfq);
      }
      paramInt = i;
      if (this.tsL != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tsL);
      }
      i = paramInt;
      if (this.tsM != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tsM);
      }
      paramInt = i;
      if (this.tsN != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tsN);
      }
      GMTrace.o(3879966081024L, 28908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.tsH == null) {
          throw new b("Not all required fields were included: Md5");
        }
        GMTrace.o(3879966081024L, 28908);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ou localou = (ou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3879966081024L, 28908);
          return -1;
        case 1: 
          localou.tsH = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 2: 
          localou.mrm = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 3: 
          localou.ofO = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 4: 
          localou.tsI = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 5: 
          localou.tsJ = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 6: 
          localou.tsK = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 7: 
          localou.tfq = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 8: 
          localou.tsL = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        case 9: 
          localou.tsM = locala.xky.readString();
          GMTrace.o(3879966081024L, 28908);
          return 0;
        }
        localou.tsN = locala.xky.readString();
        GMTrace.o(3879966081024L, 28908);
        return 0;
      }
      GMTrace.o(3879966081024L, 28908);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */