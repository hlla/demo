package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bdq
  extends com.tencent.mm.bd.a
{
  public String hjA;
  public String hjt;
  public String hjv;
  public String hjw;
  public String hjx;
  public String hjy;
  public String hjz;
  public int txr;
  
  public bdq()
  {
    GMTrace.i(3631126413312L, 27054);
    GMTrace.o(3631126413312L, 27054);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3631260631040L, 27055);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.hjt != null) {
        paramVarArgs.e(1, this.hjt);
      }
      paramVarArgs.eO(2, this.txr);
      if (this.hjw != null) {
        paramVarArgs.e(3, this.hjw);
      }
      if (this.hjx != null) {
        paramVarArgs.e(4, this.hjx);
      }
      if (this.hjv != null) {
        paramVarArgs.e(5, this.hjv);
      }
      if (this.hjy != null) {
        paramVarArgs.e(6, this.hjy);
      }
      if (this.hjz != null) {
        paramVarArgs.e(7, this.hjz);
      }
      if (this.hjA != null) {
        paramVarArgs.e(8, this.hjA);
      }
      GMTrace.o(3631260631040L, 27055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hjt == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = a.a.a.b.b.a.f(1, this.hjt) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.txr);
      paramInt = i;
      if (this.hjw != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.hjw);
      }
      i = paramInt;
      if (this.hjx != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.hjx);
      }
      paramInt = i;
      if (this.hjv != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.hjv);
      }
      i = paramInt;
      if (this.hjy != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.hjy);
      }
      paramInt = i;
      if (this.hjz != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.hjz);
      }
      i = paramInt;
      if (this.hjA != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.hjA);
      }
      GMTrace.o(3631260631040L, 27055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3631260631040L, 27055);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bdq localbdq = (bdq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3631260631040L, 27055);
          return -1;
        case 1: 
          localbdq.hjt = locala.xky.readString();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        case 2: 
          localbdq.txr = locala.xky.mL();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        case 3: 
          localbdq.hjw = locala.xky.readString();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        case 4: 
          localbdq.hjx = locala.xky.readString();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        case 5: 
          localbdq.hjv = locala.xky.readString();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        case 6: 
          localbdq.hjy = locala.xky.readString();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        case 7: 
          localbdq.hjz = locala.xky.readString();
          GMTrace.o(3631260631040L, 27055);
          return 0;
        }
        localbdq.hjA = locala.xky.readString();
        GMTrace.o(3631260631040L, 27055);
        return 0;
      }
      GMTrace.o(3631260631040L, 27055);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */