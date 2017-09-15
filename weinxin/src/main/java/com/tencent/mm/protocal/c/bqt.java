package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bqt
  extends com.tencent.mm.bd.a
{
  public int muA;
  public String muw;
  public String muy;
  public String muz;
  public String tiS;
  public int uni;
  public String unj;
  
  public bqt()
  {
    GMTrace.i(4013781155840L, 29905);
    GMTrace.o(4013781155840L, 29905);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4013915373568L, 29906);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uni);
      if (this.tiS != null) {
        paramVarArgs.e(2, this.tiS);
      }
      if (this.muw != null) {
        paramVarArgs.e(3, this.muw);
      }
      if (this.unj != null) {
        paramVarArgs.e(4, this.unj);
      }
      if (this.muy != null) {
        paramVarArgs.e(5, this.muy);
      }
      if (this.muz != null) {
        paramVarArgs.e(6, this.muz);
      }
      paramVarArgs.eO(7, this.muA);
      GMTrace.o(4013915373568L, 29906);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.uni) + 0;
      paramInt = i;
      if (this.tiS != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tiS);
      }
      i = paramInt;
      if (this.muw != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.muw);
      }
      paramInt = i;
      if (this.unj != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.unj);
      }
      i = paramInt;
      if (this.muy != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.muy);
      }
      paramInt = i;
      if (this.muz != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.muz);
      }
      i = a.a.a.a.eL(7, this.muA);
      GMTrace.o(4013915373568L, 29906);
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
      GMTrace.o(4013915373568L, 29906);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bqt localbqt = (bqt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4013915373568L, 29906);
        return -1;
      case 1: 
        localbqt.uni = locala.xky.mL();
        GMTrace.o(4013915373568L, 29906);
        return 0;
      case 2: 
        localbqt.tiS = locala.xky.readString();
        GMTrace.o(4013915373568L, 29906);
        return 0;
      case 3: 
        localbqt.muw = locala.xky.readString();
        GMTrace.o(4013915373568L, 29906);
        return 0;
      case 4: 
        localbqt.unj = locala.xky.readString();
        GMTrace.o(4013915373568L, 29906);
        return 0;
      case 5: 
        localbqt.muy = locala.xky.readString();
        GMTrace.o(4013915373568L, 29906);
        return 0;
      case 6: 
        localbqt.muz = locala.xky.readString();
        GMTrace.o(4013915373568L, 29906);
        return 0;
      }
      localbqt.muA = locala.xky.mL();
      GMTrace.o(4013915373568L, 29906);
      return 0;
    }
    GMTrace.o(4013915373568L, 29906);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */