package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class rn
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
  public boolean txd;
  public boolean txe;
  public boolean txf;
  public String txg;
  public boolean txh;
  public String txi;
  public boolean txj;
  public boolean txk;
  public boolean txl;
  public boolean txm;
  public boolean txn;
  public String txo;
  public boolean txp;
  public boolean txq;
  
  public rn()
  {
    GMTrace.i(3624952397824L, 27008);
    this.txd = false;
    this.txe = false;
    this.txf = false;
    this.txh = false;
    this.txj = false;
    this.hFa = false;
    this.txk = false;
    this.txl = false;
    this.txm = false;
    this.txn = false;
    this.txp = false;
    this.txq = false;
    GMTrace.o(3624952397824L, 27008);
  }
  
  public final rn Ol(String paramString)
  {
    GMTrace.i(3625220833280L, 27010);
    this.fOl = paramString;
    this.txe = true;
    GMTrace.o(3625220833280L, 27010);
    return this;
  }
  
  public final rn Om(String paramString)
  {
    GMTrace.i(3625355051008L, 27011);
    this.toUser = paramString;
    this.txf = true;
    GMTrace.o(3625355051008L, 27011);
    return this;
  }
  
  public final rn On(String paramString)
  {
    GMTrace.i(3625489268736L, 27012);
    this.txg = paramString;
    this.txh = true;
    GMTrace.o(3625489268736L, 27012);
    return this;
  }
  
  public final rn Oo(String paramString)
  {
    GMTrace.i(3625623486464L, 27013);
    this.txi = paramString;
    this.txj = true;
    GMTrace.o(3625623486464L, 27013);
    return this;
  }
  
  public final rn Op(String paramString)
  {
    GMTrace.i(3625891921920L, 27015);
    this.fSc = paramString;
    this.txk = true;
    GMTrace.o(3625891921920L, 27015);
    return this;
  }
  
  public final rn Oq(String paramString)
  {
    GMTrace.i(3626026139648L, 27016);
    this.appId = paramString;
    this.txm = true;
    GMTrace.o(3626026139648L, 27016);
    return this;
  }
  
  public final rn Or(String paramString)
  {
    GMTrace.i(3626160357376L, 27017);
    this.hSD = paramString;
    this.txn = true;
    GMTrace.o(3626160357376L, 27017);
    return this;
  }
  
  public final rn Os(String paramString)
  {
    GMTrace.i(3626294575104L, 27018);
    this.fCA = paramString;
    this.txq = true;
    GMTrace.o(3626294575104L, 27018);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3626428792832L, 27019);
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
      if (this.txg != null) {
        paramVarArgs.e(4, this.txg);
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
      GMTrace.o(3626428792832L, 27019);
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
      if (this.txg != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.txg);
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
      GMTrace.o(3626428792832L, 27019);
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
        GMTrace.o(3626428792832L, 27019);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        rn localrn = (rn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3626428792832L, 27019);
          return -1;
        case 1: 
          localrn.fFh = locala.xky.mL();
          localrn.txd = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 2: 
          localrn.fOl = locala.xky.readString();
          localrn.txe = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 3: 
          localrn.toUser = locala.xky.readString();
          localrn.txf = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 4: 
          localrn.txg = locala.xky.readString();
          localrn.txh = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 5: 
          localrn.txi = locala.xky.readString();
          localrn.txj = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 6: 
          localrn.hZS = locala.xky.mM();
          localrn.hFa = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 7: 
          localrn.fSc = locala.xky.readString();
          localrn.txk = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 8: 
          localrn.fWZ = locala.xky.readString();
          localrn.txl = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 9: 
          localrn.appId = locala.xky.readString();
          localrn.txm = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 10: 
          localrn.hSD = locala.xky.readString();
          localrn.txn = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        case 11: 
          localrn.txo = locala.xky.readString();
          localrn.txp = true;
          GMTrace.o(3626428792832L, 27019);
          return 0;
        }
        localrn.fCA = locala.xky.readString();
        localrn.txq = true;
        GMTrace.o(3626428792832L, 27019);
        return 0;
      }
      GMTrace.o(3626428792832L, 27019);
      return -1;
    }
  }
  
  public final rn em(long paramLong)
  {
    GMTrace.i(3625757704192L, 27014);
    this.hZS = paramLong;
    this.hFa = true;
    GMTrace.o(3625757704192L, 27014);
    return this;
  }
  
  public final rn xZ(int paramInt)
  {
    GMTrace.i(3625086615552L, 27009);
    this.fFh = paramInt;
    this.txd = true;
    GMTrace.o(3625086615552L, 27009);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/rn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */