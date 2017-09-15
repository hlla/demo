package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class alw
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
  public String hAv;
  public String tFy;
  public avu tJy;
  public int tLd;
  public String tLe;
  public String tLf;
  public String tLg;
  public int tLh;
  public bcl tLj;
  public mx tLk;
  public avu tOA;
  public avu tOB;
  public int tOP;
  public avu tOz;
  public avt tdB;
  public String tov;
  public String tow;
  public int tqV;
  public avu trH;
  public avu trx;
  public avu jdField_try;
  
  public alw()
  {
    GMTrace.i(3843593076736L, 28637);
    GMTrace.o(3843593076736L, 28637);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3843727294464L, 28638);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tJy == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.trx == null) {
        throw new b("Not all required fields were included: PYInitial");
      }
      if (this.jdField_try == null) {
        throw new b("Not all required fields were included: QuanPin");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tOz == null) {
        throw new b("Not all required fields were included: Remark");
      }
      if (this.tOA == null) {
        throw new b("Not all required fields were included: RemarkPYInitial");
      }
      if (this.tOB == null) {
        throw new b("Not all required fields were included: RemarkQuanPin");
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(1, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      if (this.tJy != null)
      {
        paramVarArgs.eQ(2, this.tJy.aUd());
        this.tJy.a(paramVarArgs);
      }
      if (this.trx != null)
      {
        paramVarArgs.eQ(3, this.trx.aUd());
        this.trx.a(paramVarArgs);
      }
      if (this.jdField_try != null)
      {
        paramVarArgs.eQ(4, this.jdField_try.aUd());
        this.jdField_try.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.hAl);
      if (this.tdB != null)
      {
        paramVarArgs.eQ(6, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      paramVarArgs.eO(7, this.tOP);
      if (this.tOz != null)
      {
        paramVarArgs.eQ(8, this.tOz.aUd());
        this.tOz.a(paramVarArgs);
      }
      if (this.tOA != null)
      {
        paramVarArgs.eQ(9, this.tOA.aUd());
        this.tOA.a(paramVarArgs);
      }
      if (this.tOB != null)
      {
        paramVarArgs.eQ(10, this.tOB.aUd());
        this.tOB.a(paramVarArgs);
      }
      paramVarArgs.eO(11, this.tqV);
      if (this.hAm != null) {
        paramVarArgs.e(12, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(13, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(14, this.hAo);
      }
      paramVarArgs.eO(15, this.hAp);
      paramVarArgs.eO(16, this.tLd);
      if (this.tLe != null) {
        paramVarArgs.e(17, this.tLe);
      }
      if (this.tLf != null) {
        paramVarArgs.e(18, this.tLf);
      }
      if (this.tFy != null) {
        paramVarArgs.e(19, this.tFy);
      }
      if (this.tLg != null) {
        paramVarArgs.e(20, this.tLg);
      }
      paramVarArgs.eO(21, this.tLh);
      paramVarArgs.eO(22, this.hAs);
      paramVarArgs.eO(23, this.hAr);
      if (this.hAt != null) {
        paramVarArgs.e(24, this.hAt);
      }
      if (this.hAq != null) {
        paramVarArgs.e(25, this.hAq);
      }
      if (this.tLj != null)
      {
        paramVarArgs.eQ(26, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAu != null) {
        paramVarArgs.e(27, this.hAu);
      }
      if (this.tov != null) {
        paramVarArgs.e(28, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(29, this.tow);
      }
      if (this.hAv != null) {
        paramVarArgs.e(30, this.hAv);
      }
      if (this.tLk != null)
      {
        paramVarArgs.eQ(31, this.tLk.aUd());
        this.tLk.a(paramVarArgs);
      }
      GMTrace.o(3843727294464L, 28638);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.trH != null) {
        i = a.a.a.a.eN(1, this.trH.aUd()) + 0;
      }
      paramInt = i;
      if (this.tJy != null) {
        paramInt = i + a.a.a.a.eN(2, this.tJy.aUd());
      }
      i = paramInt;
      if (this.trx != null) {
        i = paramInt + a.a.a.a.eN(3, this.trx.aUd());
      }
      paramInt = i;
      if (this.jdField_try != null) {
        paramInt = i + a.a.a.a.eN(4, this.jdField_try.aUd());
      }
      i = paramInt + a.a.a.a.eL(5, this.hAl);
      paramInt = i;
      if (this.tdB != null) {
        paramInt = i + a.a.a.a.eN(6, this.tdB.aUd());
      }
      i = paramInt + a.a.a.a.eL(7, this.tOP);
      paramInt = i;
      if (this.tOz != null) {
        paramInt = i + a.a.a.a.eN(8, this.tOz.aUd());
      }
      i = paramInt;
      if (this.tOA != null) {
        i = paramInt + a.a.a.a.eN(9, this.tOA.aUd());
      }
      paramInt = i;
      if (this.tOB != null) {
        paramInt = i + a.a.a.a.eN(10, this.tOB.aUd());
      }
      i = paramInt + a.a.a.a.eL(11, this.tqV);
      paramInt = i;
      if (this.hAm != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.hAm);
      }
      i = paramInt;
      if (this.hAn != null) {
        i = paramInt + a.a.a.b.b.a.f(13, this.hAn);
      }
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(14, this.hAo);
      }
      i = paramInt + a.a.a.a.eL(15, this.hAp) + a.a.a.a.eL(16, this.tLd);
      paramInt = i;
      if (this.tLe != null) {
        paramInt = i + a.a.a.b.b.a.f(17, this.tLe);
      }
      i = paramInt;
      if (this.tLf != null) {
        i = paramInt + a.a.a.b.b.a.f(18, this.tLf);
      }
      paramInt = i;
      if (this.tFy != null) {
        paramInt = i + a.a.a.b.b.a.f(19, this.tFy);
      }
      i = paramInt;
      if (this.tLg != null) {
        i = paramInt + a.a.a.b.b.a.f(20, this.tLg);
      }
      i = i + a.a.a.a.eL(21, this.tLh) + a.a.a.a.eL(22, this.hAs) + a.a.a.a.eL(23, this.hAr);
      paramInt = i;
      if (this.hAt != null) {
        paramInt = i + a.a.a.b.b.a.f(24, this.hAt);
      }
      i = paramInt;
      if (this.hAq != null) {
        i = paramInt + a.a.a.b.b.a.f(25, this.hAq);
      }
      paramInt = i;
      if (this.tLj != null) {
        paramInt = i + a.a.a.a.eN(26, this.tLj.aUd());
      }
      i = paramInt;
      if (this.hAu != null) {
        i = paramInt + a.a.a.b.b.a.f(27, this.hAu);
      }
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + a.a.a.b.b.a.f(28, this.tov);
      }
      i = paramInt;
      if (this.tow != null) {
        i = paramInt + a.a.a.b.b.a.f(29, this.tow);
      }
      paramInt = i;
      if (this.hAv != null) {
        paramInt = i + a.a.a.b.b.a.f(30, this.hAv);
      }
      i = paramInt;
      if (this.tLk != null) {
        i = paramInt + a.a.a.a.eN(31, this.tLk.aUd());
      }
      GMTrace.o(3843727294464L, 28638);
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
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tJy == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.trx == null) {
        throw new b("Not all required fields were included: PYInitial");
      }
      if (this.jdField_try == null) {
        throw new b("Not all required fields were included: QuanPin");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tOz == null) {
        throw new b("Not all required fields were included: Remark");
      }
      if (this.tOA == null) {
        throw new b("Not all required fields were included: RemarkPYInitial");
      }
      if (this.tOB == null) {
        throw new b("Not all required fields were included: RemarkQuanPin");
      }
      GMTrace.o(3843727294464L, 28638);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      alw localalw = (alw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3843727294464L, 28638);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
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
          localalw.tJy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
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
          localalw.trx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.jdField_try = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 5: 
        localalw.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 7: 
        localalw.tOP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.tOz = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.tOA = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.tOB = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 11: 
        localalw.tqV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 12: 
        localalw.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 13: 
        localalw.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 14: 
        localalw.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 15: 
        localalw.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 16: 
        localalw.tLd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 17: 
        localalw.tLe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 18: 
        localalw.tLf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 19: 
        localalw.tFy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 20: 
        localalw.tLg = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 21: 
        localalw.tLh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 22: 
        localalw.hAs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 23: 
        localalw.hAr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 24: 
        localalw.hAt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 25: 
        localalw.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 26: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalw.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 27: 
        localalw.hAu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 28: 
        localalw.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 29: 
        localalw.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      case 30: 
        localalw.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3843727294464L, 28638);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new mx();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((mx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localalw.tLk = ((mx)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3843727294464L, 28638);
      return 0;
    }
    GMTrace.o(3843727294464L, 28638);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/alw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */