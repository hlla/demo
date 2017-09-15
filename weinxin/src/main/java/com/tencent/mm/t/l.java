package com.tencent.mm.t;

import com.tencent.gmtrace.GMTrace;

public final class l
  extends com.tencent.mm.bd.a
{
  public String hkg;
  public String hkh;
  public String hki;
  public String hkj;
  public String hkk;
  public int hkl;
  public int hkm;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public l()
  {
    GMTrace.i(311250911232L, 2319);
    GMTrace.o(311250911232L, 2319);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(311385128960L, 2320);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.hkg != null) {
        paramVarArgs.e(3, this.hkg);
      }
      if (this.hkh != null) {
        paramVarArgs.e(4, this.hkh);
      }
      paramVarArgs.O(5, this.time);
      if (this.hki != null) {
        paramVarArgs.e(6, this.hki);
      }
      if (this.hkj != null) {
        paramVarArgs.e(7, this.hkj);
      }
      if (this.hkk != null) {
        paramVarArgs.e(8, this.hkk);
      }
      paramVarArgs.eO(9, this.type);
      paramVarArgs.eO(10, this.hkl);
      paramVarArgs.eO(11, this.hkm);
      GMTrace.o(311385128960L, 2320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label834;
      }
    }
    label834:
    for (int i = a.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.hkg != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.hkg);
      }
      paramInt = i;
      if (this.hkh != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.hkh);
      }
      i = paramInt + a.a.a.a.N(5, this.time);
      paramInt = i;
      if (this.hki != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.hki);
      }
      i = paramInt;
      if (this.hkj != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.hkj);
      }
      paramInt = i;
      if (this.hkk != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.hkk);
      }
      i = a.a.a.a.eL(9, this.type);
      int j = a.a.a.a.eL(10, this.hkl);
      int k = a.a.a.a.eL(11, this.hkm);
      GMTrace.o(311385128960L, 2320);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(311385128960L, 2320);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(311385128960L, 2320);
          return -1;
        case 1: 
          locall.title = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 2: 
          locall.url = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 3: 
          locall.hkg = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 4: 
          locall.hkh = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 5: 
          locall.time = locala.xky.mM();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 6: 
          locall.hki = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 7: 
          locall.hkj = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 8: 
          locall.hkk = locala.xky.readString();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 9: 
          locall.type = locala.xky.mL();
          GMTrace.o(311385128960L, 2320);
          return 0;
        case 10: 
          locall.hkl = locala.xky.mL();
          GMTrace.o(311385128960L, 2320);
          return 0;
        }
        locall.hkm = locala.xky.mL();
        GMTrace.o(311385128960L, 2320);
        return 0;
      }
      GMTrace.o(311385128960L, 2320);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */