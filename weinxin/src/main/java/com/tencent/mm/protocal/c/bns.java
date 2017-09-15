package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bns
  extends com.tencent.mm.bd.a
{
  public int mrC;
  public String oog;
  public String tLN;
  public String ukV;
  public long ukW;
  public long ulb;
  public boolean ulc;
  public com.tencent.mm.bd.b uld;
  
  public bns()
  {
    GMTrace.i(3864262606848L, 28791);
    GMTrace.o(3864262606848L, 28791);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3864396824576L, 28792);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tLN == null) {
        throw new a.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.oog == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      if (this.ukV == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      paramVarArgs.O(1, this.ukW);
      if (this.tLN != null) {
        paramVarArgs.e(2, this.tLN);
      }
      if (this.oog != null) {
        paramVarArgs.e(3, this.oog);
      }
      paramVarArgs.eO(4, this.mrC);
      if (this.ukV != null) {
        paramVarArgs.e(5, this.ukV);
      }
      paramVarArgs.O(6, this.ulb);
      paramVarArgs.an(7, this.ulc);
      if (this.uld != null) {
        paramVarArgs.b(8, this.uld);
      }
      GMTrace.o(3864396824576L, 28792);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.N(1, this.ukW) + 0;
      paramInt = i;
      if (this.tLN != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tLN);
      }
      i = paramInt;
      if (this.oog != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.oog);
      }
      i += a.a.a.a.eL(4, this.mrC);
      paramInt = i;
      if (this.ukV != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.ukV);
      }
      i = paramInt + a.a.a.a.N(6, this.ulb) + (a.a.a.b.b.a.cH(7) + 1);
      paramInt = i;
      if (this.uld != null) {
        paramInt = i + a.a.a.a.a(8, this.uld);
      }
      GMTrace.o(3864396824576L, 28792);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tLN == null) {
        throw new a.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.oog == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      if (this.ukV == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      GMTrace.o(3864396824576L, 28792);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bns localbns = (bns)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3864396824576L, 28792);
        return -1;
      case 1: 
        localbns.ukW = locala.xky.mM();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      case 2: 
        localbns.tLN = locala.xky.readString();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      case 3: 
        localbns.oog = locala.xky.readString();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      case 4: 
        localbns.mrC = locala.xky.mL();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      case 5: 
        localbns.ukV = locala.xky.readString();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      case 6: 
        localbns.ulb = locala.xky.mM();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      case 7: 
        localbns.ulc = locala.chQ();
        GMTrace.o(3864396824576L, 28792);
        return 0;
      }
      localbns.uld = locala.chR();
      GMTrace.o(3864396824576L, 28792);
      return 0;
    }
    GMTrace.o(3864396824576L, 28792);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */