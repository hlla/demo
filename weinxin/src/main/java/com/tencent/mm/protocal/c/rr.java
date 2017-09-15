package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class rr
  extends com.tencent.mm.bd.a
{
  public int fNU;
  public String fRN;
  public String label;
  public double lat;
  public double lng;
  public boolean txv;
  public boolean txw;
  public boolean txx;
  public boolean txy;
  public boolean txz;
  
  public rr()
  {
    GMTrace.i(3983313731584L, 29678);
    this.txv = false;
    this.txw = false;
    this.txx = false;
    this.txy = false;
    this.txz = false;
    GMTrace.o(3983313731584L, 29678);
  }
  
  public final rr Ot(String paramString)
  {
    GMTrace.i(3983850602496L, 29682);
    this.label = paramString;
    this.txy = true;
    GMTrace.o(3983850602496L, 29682);
    return this;
  }
  
  public final rr Ou(String paramString)
  {
    GMTrace.i(3983984820224L, 29683);
    this.fRN = paramString;
    this.txz = true;
    GMTrace.o(3983984820224L, 29683);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3984119037952L, 29684);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.txv == true) {
        paramVarArgs.a(1, this.lng);
      }
      if (this.txw == true) {
        paramVarArgs.a(2, this.lat);
      }
      if (this.txx == true) {
        paramVarArgs.eO(3, this.fNU);
      }
      if (this.label != null) {
        paramVarArgs.e(4, this.label);
      }
      if (this.fRN != null) {
        paramVarArgs.e(5, this.fRN);
      }
      GMTrace.o(3984119037952L, 29684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.txv != true) {
        break label532;
      }
    }
    label532:
    for (int i = a.a.a.b.b.a.cH(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.txw == true) {
        paramInt = i + (a.a.a.b.b.a.cH(2) + 8);
      }
      i = paramInt;
      if (this.txx == true) {
        i = paramInt + a.a.a.a.eL(3, this.fNU);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.label);
      }
      i = paramInt;
      if (this.fRN != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.fRN);
      }
      GMTrace.o(3984119037952L, 29684);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3984119037952L, 29684);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        rr localrr = (rr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3984119037952L, 29684);
          return -1;
        case 1: 
          localrr.lng = locala.xky.readDouble();
          localrr.txv = true;
          GMTrace.o(3984119037952L, 29684);
          return 0;
        case 2: 
          localrr.lat = locala.xky.readDouble();
          localrr.txw = true;
          GMTrace.o(3984119037952L, 29684);
          return 0;
        case 3: 
          localrr.fNU = locala.xky.mL();
          localrr.txx = true;
          GMTrace.o(3984119037952L, 29684);
          return 0;
        case 4: 
          localrr.label = locala.xky.readString();
          localrr.txy = true;
          GMTrace.o(3984119037952L, 29684);
          return 0;
        }
        localrr.fRN = locala.xky.readString();
        localrr.txz = true;
        GMTrace.o(3984119037952L, 29684);
        return 0;
      }
      GMTrace.o(3984119037952L, 29684);
      return -1;
    }
  }
  
  public final rr l(double paramDouble)
  {
    GMTrace.i(3983447949312L, 29679);
    this.lng = paramDouble;
    this.txv = true;
    GMTrace.o(3983447949312L, 29679);
    return this;
  }
  
  public final rr m(double paramDouble)
  {
    GMTrace.i(3983582167040L, 29680);
    this.lat = paramDouble;
    this.txw = true;
    GMTrace.o(3983582167040L, 29680);
    return this;
  }
  
  public final rr ya(int paramInt)
  {
    GMTrace.i(3983716384768L, 29681);
    this.fNU = paramInt;
    this.txx = true;
    GMTrace.o(3983716384768L, 29681);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/rr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */