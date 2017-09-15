package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class amt
  extends com.tencent.mm.bd.a
{
  public int hAl;
  public String hAm;
  public String hAn;
  public String hAo;
  public int hAp;
  public String hAq;
  public int hAr;
  public int hAs;
  public String hAt;
  public String hAu;
  public int jLP;
  public avu tJy;
  public int tLd;
  public String tLe;
  public String tLf;
  public String tLg;
  public int tLh;
  public int tOV;
  public int tPB;
  public int tPC;
  public com.tencent.mm.bd.b tPD;
  public int tPF;
  public avu tPG;
  public avu tPH;
  public int tPI;
  public int tPJ;
  public int tPK;
  public int tPL;
  public int tPM;
  public adx tPN;
  public int tPO;
  public String tPP;
  public od tPp;
  public int tbS;
  public int tbV;
  public avu trH;
  public long tuV;
  public String tuW;
  
  public amt()
  {
    GMTrace.i(13335202365440L, 99355);
    GMTrace.o(13335202365440L, 99355);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13335336583168L, 99356);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.tJy == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.tPG == null) {
        throw new a.a.a.b("Not all required fields were included: BindEmail");
      }
      if (this.tPH == null) {
        throw new a.a.a.b("Not all required fields were included: BindMobile");
      }
      paramVarArgs.eO(1, this.tPF);
      if (this.trH != null)
      {
        paramVarArgs.eQ(2, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      if (this.tJy != null)
      {
        paramVarArgs.eQ(3, this.tJy.aUd());
        this.tJy.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tbS);
      if (this.tPG != null)
      {
        paramVarArgs.eQ(5, this.tPG.aUd());
        this.tPG.a(paramVarArgs);
      }
      if (this.tPH != null)
      {
        paramVarArgs.eQ(6, this.tPH.aUd());
        this.tPH.a(paramVarArgs);
      }
      paramVarArgs.eO(7, this.jLP);
      paramVarArgs.eO(8, this.tPC);
      if (this.tPD != null) {
        paramVarArgs.b(9, this.tPD);
      }
      paramVarArgs.eO(10, this.hAl);
      if (this.hAm != null) {
        paramVarArgs.e(11, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(12, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(13, this.hAo);
      }
      paramVarArgs.eO(14, this.hAp);
      if (this.tPp != null)
      {
        paramVarArgs.eQ(15, this.tPp.aUd());
        this.tPp.a(paramVarArgs);
      }
      paramVarArgs.eO(16, this.tbV);
      paramVarArgs.eO(17, this.tLd);
      if (this.tLe != null) {
        paramVarArgs.e(18, this.tLe);
      }
      paramVarArgs.eO(19, this.tPI);
      paramVarArgs.eO(20, this.tPJ);
      paramVarArgs.eO(21, this.tOV);
      paramVarArgs.eO(22, this.tPK);
      paramVarArgs.eO(23, this.tPL);
      if (this.tLf != null) {
        paramVarArgs.e(24, this.tLf);
      }
      paramVarArgs.eO(25, this.tPM);
      if (this.tPN != null)
      {
        paramVarArgs.eQ(26, this.tPN.aUd());
        this.tPN.a(paramVarArgs);
      }
      if (this.hAq != null) {
        paramVarArgs.e(27, this.hAq);
      }
      if (this.tLg != null) {
        paramVarArgs.e(28, this.tLg);
      }
      paramVarArgs.eO(29, this.tLh);
      paramVarArgs.eO(30, this.tPO);
      paramVarArgs.O(31, this.tuV);
      if (this.tuW != null) {
        paramVarArgs.e(32, this.tuW);
      }
      paramVarArgs.eO(33, this.hAs);
      paramVarArgs.eO(34, this.hAr);
      if (this.hAt != null) {
        paramVarArgs.e(35, this.hAt);
      }
      paramVarArgs.eO(36, this.tPB);
      if (this.tPP != null) {
        paramVarArgs.e(37, this.tPP);
      }
      if (this.hAu != null) {
        paramVarArgs.e(38, this.hAu);
      }
      GMTrace.o(13335336583168L, 99356);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tPF) + 0;
      paramInt = i;
      if (this.trH != null) {
        paramInt = i + a.a.a.a.eN(2, this.trH.aUd());
      }
      i = paramInt;
      if (this.tJy != null) {
        i = paramInt + a.a.a.a.eN(3, this.tJy.aUd());
      }
      i += a.a.a.a.eL(4, this.tbS);
      paramInt = i;
      if (this.tPG != null) {
        paramInt = i + a.a.a.a.eN(5, this.tPG.aUd());
      }
      i = paramInt;
      if (this.tPH != null) {
        i = paramInt + a.a.a.a.eN(6, this.tPH.aUd());
      }
      i = i + a.a.a.a.eL(7, this.jLP) + a.a.a.a.eL(8, this.tPC);
      paramInt = i;
      if (this.tPD != null) {
        paramInt = i + a.a.a.a.a(9, this.tPD);
      }
      i = paramInt + a.a.a.a.eL(10, this.hAl);
      paramInt = i;
      if (this.hAm != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.hAm);
      }
      i = paramInt;
      if (this.hAn != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.hAn);
      }
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.hAo);
      }
      i = paramInt + a.a.a.a.eL(14, this.hAp);
      paramInt = i;
      if (this.tPp != null) {
        paramInt = i + a.a.a.a.eN(15, this.tPp.aUd());
      }
      i = paramInt + a.a.a.a.eL(16, this.tbV) + a.a.a.a.eL(17, this.tLd);
      paramInt = i;
      if (this.tLe != null) {
        paramInt = i + a.a.a.b.b.a.f(18, this.tLe);
      }
      i = paramInt + a.a.a.a.eL(19, this.tPI) + a.a.a.a.eL(20, this.tPJ) + a.a.a.a.eL(21, this.tOV) + a.a.a.a.eL(22, this.tPK) + a.a.a.a.eL(23, this.tPL);
      paramInt = i;
      if (this.tLf != null) {
        paramInt = i + a.a.a.b.b.a.f(24, this.tLf);
      }
      i = paramInt + a.a.a.a.eL(25, this.tPM);
      paramInt = i;
      if (this.tPN != null) {
        paramInt = i + a.a.a.a.eN(26, this.tPN.aUd());
      }
      i = paramInt;
      if (this.hAq != null) {
        i = paramInt + a.a.a.b.b.a.f(27, this.hAq);
      }
      paramInt = i;
      if (this.tLg != null) {
        paramInt = i + a.a.a.b.b.a.f(28, this.tLg);
      }
      i = paramInt + a.a.a.a.eL(29, this.tLh) + a.a.a.a.eL(30, this.tPO) + a.a.a.a.N(31, this.tuV);
      paramInt = i;
      if (this.tuW != null) {
        paramInt = i + a.a.a.b.b.a.f(32, this.tuW);
      }
      i = paramInt + a.a.a.a.eL(33, this.hAs) + a.a.a.a.eL(34, this.hAr);
      paramInt = i;
      if (this.hAt != null) {
        paramInt = i + a.a.a.b.b.a.f(35, this.hAt);
      }
      i = paramInt + a.a.a.a.eL(36, this.tPB);
      paramInt = i;
      if (this.tPP != null) {
        paramInt = i + a.a.a.b.b.a.f(37, this.tPP);
      }
      i = paramInt;
      if (this.hAu != null) {
        i = paramInt + a.a.a.b.b.a.f(38, this.hAu);
      }
      GMTrace.o(13335336583168L, 99356);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trH == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.tJy == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.tPG == null) {
        throw new a.a.a.b("Not all required fields were included: BindEmail");
      }
      if (this.tPH == null) {
        throw new a.a.a.b("Not all required fields were included: BindMobile");
      }
      GMTrace.o(13335336583168L, 99356);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      amt localamt = (amt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13335336583168L, 99356);
        return -1;
      case 1: 
        localamt.tPF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localamt.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localamt.tJy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 4: 
        localamt.tbS = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localamt.tPG = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localamt.tPH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 7: 
        localamt.jLP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 8: 
        localamt.tPC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 9: 
        localamt.tPD = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 10: 
        localamt.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 11: 
        localamt.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 12: 
        localamt.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 13: 
        localamt.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 14: 
        localamt.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 15: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new od();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((od)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localamt.tPp = ((od)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 16: 
        localamt.tbV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 17: 
        localamt.tLd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 18: 
        localamt.tLe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 19: 
        localamt.tPI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 20: 
        localamt.tPJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 21: 
        localamt.tOV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 22: 
        localamt.tPK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 23: 
        localamt.tPL = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 24: 
        localamt.tLf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 25: 
        localamt.tPM = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 26: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localamt.tPN = ((adx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 27: 
        localamt.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 28: 
        localamt.tLg = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 29: 
        localamt.tLh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 30: 
        localamt.tPO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 31: 
        localamt.tuV = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 32: 
        localamt.tuW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 33: 
        localamt.hAs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 34: 
        localamt.hAr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 35: 
        localamt.hAt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 36: 
        localamt.tPB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      case 37: 
        localamt.tPP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13335336583168L, 99356);
        return 0;
      }
      localamt.hAu = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13335336583168L, 99356);
      return 0;
    }
    GMTrace.o(13335336583168L, 99356);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */