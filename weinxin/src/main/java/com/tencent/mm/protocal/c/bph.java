package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bph
  extends com.tencent.mm.bd.a
{
  public String mrE;
  public String tLN;
  public String ume;
  
  public bph()
  {
    GMTrace.i(3863457300480L, 28785);
    GMTrace.o(3863457300480L, 28785);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3863591518208L, 28786);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.ume != null) {
        paramVarArgs.e(1, this.ume);
      }
      if (this.mrE != null) {
        paramVarArgs.e(2, this.mrE);
      }
      if (this.tLN != null) {
        paramVarArgs.e(3, this.tLN);
      }
      GMTrace.o(3863591518208L, 28786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ume == null) {
        break label370;
      }
    }
    label370:
    for (int i = a.a.a.b.b.a.f(1, this.ume) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mrE != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrE);
      }
      i = paramInt;
      if (this.tLN != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tLN);
      }
      GMTrace.o(3863591518208L, 28786);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3863591518208L, 28786);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bph localbph = (bph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3863591518208L, 28786);
          return -1;
        case 1: 
          localbph.ume = locala.xky.readString();
          GMTrace.o(3863591518208L, 28786);
          return 0;
        case 2: 
          localbph.mrE = locala.xky.readString();
          GMTrace.o(3863591518208L, 28786);
          return 0;
        }
        localbph.tLN = locala.xky.readString();
        GMTrace.o(3863591518208L, 28786);
        return 0;
      }
      GMTrace.o(3863591518208L, 28786);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */