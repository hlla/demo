package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aiv
  extends com.tencent.mm.bd.a
{
  public float tlt;
  public float tlu;
  public int tvi;
  public String tvj;
  public String tvk;
  public int tvl;
  
  public aiv()
  {
    GMTrace.i(3892045676544L, 28998);
    GMTrace.o(3892045676544L, 28998);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3892179894272L, 28999);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.n(1, this.tlt);
      paramVarArgs.n(2, this.tlu);
      paramVarArgs.eO(3, this.tvi);
      if (this.tvj != null) {
        paramVarArgs.e(4, this.tvj);
      }
      if (this.tvk != null) {
        paramVarArgs.e(5, this.tvk);
      }
      paramVarArgs.eO(6, this.tvl);
      GMTrace.o(3892179894272L, 28999);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.b.b.a.cH(1) + 4 + 0 + (a.a.a.b.b.a.cH(2) + 4) + a.a.a.a.eL(3, this.tvi);
      paramInt = i;
      if (this.tvj != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tvj);
      }
      i = paramInt;
      if (this.tvk != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tvk);
      }
      paramInt = a.a.a.a.eL(6, this.tvl);
      GMTrace.o(3892179894272L, 28999);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3892179894272L, 28999);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aiv localaiv = (aiv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3892179894272L, 28999);
        return -1;
      case 1: 
        localaiv.tlt = locala.xky.readFloat();
        GMTrace.o(3892179894272L, 28999);
        return 0;
      case 2: 
        localaiv.tlu = locala.xky.readFloat();
        GMTrace.o(3892179894272L, 28999);
        return 0;
      case 3: 
        localaiv.tvi = locala.xky.mL();
        GMTrace.o(3892179894272L, 28999);
        return 0;
      case 4: 
        localaiv.tvj = locala.xky.readString();
        GMTrace.o(3892179894272L, 28999);
        return 0;
      case 5: 
        localaiv.tvk = locala.xky.readString();
        GMTrace.o(3892179894272L, 28999);
        return 0;
      }
      localaiv.tvl = locala.xky.mL();
      GMTrace.o(3892179894272L, 28999);
      return 0;
    }
    GMTrace.o(3892179894272L, 28999);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */