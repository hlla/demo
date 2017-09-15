package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class rv
  extends com.tencent.mm.bd.a
{
  public String appId;
  public String fCA;
  public int fFh;
  public String fOl;
  public String fSc;
  public String fWZ;
  public boolean hFa;
  public String hSD;
  public long hZS;
  public String toUser;
  public String txI;
  public boolean txJ;
  public boolean txd;
  public boolean txe;
  public boolean txf;
  public String txi;
  public boolean txj;
  public boolean txk;
  public boolean txl;
  public boolean txm;
  public boolean txn;
  public String txo;
  public boolean txp;
  public boolean txq;
  
  public rv()
  {
    GMTrace.i(3675418263552L, 27384);
    this.txd = false;
    this.txe = false;
    this.txf = false;
    this.txJ = false;
    this.txj = false;
    this.hFa = false;
    this.txk = false;
    this.txl = false;
    this.txm = false;
    this.txn = false;
    this.txp = false;
    this.txq = false;
    GMTrace.o(3675418263552L, 27384);
  }
  
  public final rv OC(String paramString)
  {
    GMTrace.i(3675686699008L, 27386);
    this.fOl = paramString;
    this.txe = true;
    GMTrace.o(3675686699008L, 27386);
    return this;
  }
  
  public final rv OD(String paramString)
  {
    GMTrace.i(3675820916736L, 27387);
    this.toUser = paramString;
    this.txf = true;
    GMTrace.o(3675820916736L, 27387);
    return this;
  }
  
  public final rv OE(String paramString)
  {
    GMTrace.i(3675955134464L, 27388);
    this.txI = paramString;
    this.txJ = true;
    GMTrace.o(3675955134464L, 27388);
    return this;
  }
  
  public final rv OF(String paramString)
  {
    GMTrace.i(3676089352192L, 27389);
    this.txi = paramString;
    this.txj = true;
    GMTrace.o(3676089352192L, 27389);
    return this;
  }
  
  public final rv OG(String paramString)
  {
    GMTrace.i(3676357787648L, 27391);
    this.fSc = paramString;
    this.txk = true;
    GMTrace.o(3676357787648L, 27391);
    return this;
  }
  
  public final rv OH(String paramString)
  {
    GMTrace.i(3676492005376L, 27392);
    this.fWZ = paramString;
    this.txl = true;
    GMTrace.o(3676492005376L, 27392);
    return this;
  }
  
  public final rv OI(String paramString)
  {
    GMTrace.i(3676626223104L, 27393);
    this.appId = paramString;
    this.txm = true;
    GMTrace.o(3676626223104L, 27393);
    return this;
  }
  
  public final rv OJ(String paramString)
  {
    GMTrace.i(3676760440832L, 27394);
    this.hSD = paramString;
    this.txn = true;
    GMTrace.o(3676760440832L, 27394);
    return this;
  }
  
  public final rv OK(String paramString)
  {
    GMTrace.i(3676894658560L, 27395);
    this.fCA = paramString;
    this.txq = true;
    GMTrace.o(3676894658560L, 27395);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3677028876288L, 27396);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (!this.txd) {
        throw new b("Not all required fields were included: sourceType");
      }
      if (this.txd == true) {
        paramVarArgs.eO(1, this.fFh);
      }
      if (this.fOl != null) {
        paramVarArgs.e(2, this.fOl);
      }
      if (this.toUser != null) {
        paramVarArgs.e(3, this.toUser);
      }
      if (this.txI != null) {
        paramVarArgs.e(4, this.txI);
      }
      if (this.txi != null) {
        paramVarArgs.e(5, this.txi);
      }
      if (this.hFa == true) {
        paramVarArgs.O(6, this.hZS);
      }
      if (this.fSc != null) {
        paramVarArgs.e(7, this.fSc);
      }
      if (this.fWZ != null) {
        paramVarArgs.e(8, this.fWZ);
      }
      if (this.appId != null) {
        paramVarArgs.e(9, this.appId);
      }
      if (this.hSD != null) {
        paramVarArgs.e(10, this.hSD);
      }
      if (this.txo != null) {
        paramVarArgs.e(11, this.txo);
      }
      if (this.fCA != null) {
        paramVarArgs.e(12, this.fCA);
      }
      GMTrace.o(3677028876288L, 27396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.txd != true) {
        break label1070;
      }
    }
    label1070:
    for (int i = a.a.a.a.eL(1, this.fFh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fOl != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.fOl);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.toUser);
      }
      paramInt = i;
      if (this.txI != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.txI);
      }
      i = paramInt;
      if (this.txi != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.txi);
      }
      paramInt = i;
      if (this.hFa == true) {
        paramInt = i + a.a.a.a.N(6, this.hZS);
      }
      i = paramInt;
      if (this.fSc != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.fSc);
      }
      paramInt = i;
      if (this.fWZ != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.fWZ);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.appId);
      }
      paramInt = i;
      if (this.hSD != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.hSD);
      }
      i = paramInt;
      if (this.txo != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.txo);
      }
      paramInt = i;
      if (this.fCA != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.fCA);
      }
      GMTrace.o(3677028876288L, 27396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (!this.txd) {
          throw new b("Not all required fields were included: sourceType");
        }
        GMTrace.o(3677028876288L, 27396);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        rv localrv = (rv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3677028876288L, 27396);
          return -1;
        case 1: 
          localrv.fFh = locala.xky.mL();
          localrv.txd = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 2: 
          localrv.fOl = locala.xky.readString();
          localrv.txe = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 3: 
          localrv.toUser = locala.xky.readString();
          localrv.txf = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 4: 
          localrv.txI = locala.xky.readString();
          localrv.txJ = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 5: 
          localrv.txi = locala.xky.readString();
          localrv.txj = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 6: 
          localrv.hZS = locala.xky.mM();
          localrv.hFa = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 7: 
          localrv.fSc = locala.xky.readString();
          localrv.txk = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 8: 
          localrv.fWZ = locala.xky.readString();
          localrv.txl = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 9: 
          localrv.appId = locala.xky.readString();
          localrv.txm = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 10: 
          localrv.hSD = locala.xky.readString();
          localrv.txn = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        case 11: 
          localrv.txo = locala.xky.readString();
          localrv.txp = true;
          GMTrace.o(3677028876288L, 27396);
          return 0;
        }
        localrv.fCA = locala.xky.readString();
        localrv.txq = true;
        GMTrace.o(3677028876288L, 27396);
        return 0;
      }
      GMTrace.o(3677028876288L, 27396);
      return -1;
    }
  }
  
  public final rv ep(long paramLong)
  {
    GMTrace.i(3676223569920L, 27390);
    this.hZS = paramLong;
    this.hFa = true;
    GMTrace.o(3676223569920L, 27390);
    return this;
  }
  
  public final rv ye(int paramInt)
  {
    GMTrace.i(3675552481280L, 27385);
    this.fFh = paramInt;
    this.txd = true;
    GMTrace.o(3675552481280L, 27385);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/rv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */