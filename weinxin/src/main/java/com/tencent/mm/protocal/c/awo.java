package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class awo
  extends avm
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
  public String tAe;
  public int tCj;
  public LinkedList<awm> tCk;
  public avu tJy;
  public int tLd;
  public String tLe;
  public String tLf;
  public String tLg;
  public int tLh;
  public bcl tLj;
  public mx tLk;
  public avt tXU;
  public String tXV;
  public int tXW;
  public avt tdB;
  public String tov;
  public String tow;
  public avu trH;
  public avu trx;
  public avu jdField_try;
  
  public awo()
  {
    GMTrace.i(3966133862400L, 29550);
    this.tCk = new LinkedList();
    GMTrace.o(3966133862400L, 29550);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3966268080128L, 29551);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
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
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
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
      if (this.trx != null)
      {
        paramVarArgs.eQ(4, this.trx.aUd());
        this.trx.a(paramVarArgs);
      }
      if (this.jdField_try != null)
      {
        paramVarArgs.eQ(5, this.jdField_try.aUd());
        this.jdField_try.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.hAl);
      if (this.tdB != null)
      {
        paramVarArgs.eQ(7, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      if (this.hAm != null) {
        paramVarArgs.e(8, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(9, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(10, this.hAo);
      }
      paramVarArgs.eO(11, this.hAp);
      paramVarArgs.eO(12, this.tLd);
      if (this.tLe != null) {
        paramVarArgs.e(13, this.tLe);
      }
      if (this.tLf != null) {
        paramVarArgs.e(14, this.tLf);
      }
      if (this.hAq != null) {
        paramVarArgs.e(15, this.hAq);
      }
      if (this.tLg != null) {
        paramVarArgs.e(16, this.tLg);
      }
      paramVarArgs.eO(17, this.tLh);
      paramVarArgs.eO(18, this.hAs);
      paramVarArgs.eO(19, this.hAr);
      if (this.hAt != null) {
        paramVarArgs.e(20, this.hAt);
      }
      if (this.tLj != null)
      {
        paramVarArgs.eQ(21, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAu != null) {
        paramVarArgs.e(22, this.hAu);
      }
      if (this.hAv != null) {
        paramVarArgs.e(23, this.hAv);
      }
      if (this.tLk != null)
      {
        paramVarArgs.eQ(24, this.tLk.aUd());
        this.tLk.a(paramVarArgs);
      }
      paramVarArgs.eO(25, this.tCj);
      paramVarArgs.d(26, 8, this.tCk);
      if (this.tov != null) {
        paramVarArgs.e(27, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(28, this.tow);
      }
      if (this.tXU != null)
      {
        paramVarArgs.eQ(29, this.tXU.aUd());
        this.tXU.a(paramVarArgs);
      }
      if (this.tAe != null) {
        paramVarArgs.e(30, this.tAe);
      }
      if (this.tXV != null) {
        paramVarArgs.e(31, this.tXV);
      }
      paramVarArgs.eO(32, this.tXW);
      GMTrace.o(3966268080128L, 29551);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.trH != null) {
        paramInt = i + a.a.a.a.eN(2, this.trH.aUd());
      }
      i = paramInt;
      if (this.tJy != null) {
        i = paramInt + a.a.a.a.eN(3, this.tJy.aUd());
      }
      paramInt = i;
      if (this.trx != null) {
        paramInt = i + a.a.a.a.eN(4, this.trx.aUd());
      }
      i = paramInt;
      if (this.jdField_try != null) {
        i = paramInt + a.a.a.a.eN(5, this.jdField_try.aUd());
      }
      i += a.a.a.a.eL(6, this.hAl);
      paramInt = i;
      if (this.tdB != null) {
        paramInt = i + a.a.a.a.eN(7, this.tdB.aUd());
      }
      i = paramInt;
      if (this.hAm != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.hAm);
      }
      paramInt = i;
      if (this.hAn != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.hAn);
      }
      i = paramInt;
      if (this.hAo != null) {
        i = paramInt + a.a.a.b.b.a.f(10, this.hAo);
      }
      i = i + a.a.a.a.eL(11, this.hAp) + a.a.a.a.eL(12, this.tLd);
      paramInt = i;
      if (this.tLe != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.tLe);
      }
      i = paramInt;
      if (this.tLf != null) {
        i = paramInt + a.a.a.b.b.a.f(14, this.tLf);
      }
      paramInt = i;
      if (this.hAq != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.hAq);
      }
      i = paramInt;
      if (this.tLg != null) {
        i = paramInt + a.a.a.b.b.a.f(16, this.tLg);
      }
      i = i + a.a.a.a.eL(17, this.tLh) + a.a.a.a.eL(18, this.hAs) + a.a.a.a.eL(19, this.hAr);
      paramInt = i;
      if (this.hAt != null) {
        paramInt = i + a.a.a.b.b.a.f(20, this.hAt);
      }
      i = paramInt;
      if (this.tLj != null) {
        i = paramInt + a.a.a.a.eN(21, this.tLj.aUd());
      }
      paramInt = i;
      if (this.hAu != null) {
        paramInt = i + a.a.a.b.b.a.f(22, this.hAu);
      }
      i = paramInt;
      if (this.hAv != null) {
        i = paramInt + a.a.a.b.b.a.f(23, this.hAv);
      }
      paramInt = i;
      if (this.tLk != null) {
        paramInt = i + a.a.a.a.eN(24, this.tLk.aUd());
      }
      i = paramInt + a.a.a.a.eL(25, this.tCj) + a.a.a.a.c(26, 8, this.tCk);
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + a.a.a.b.b.a.f(27, this.tov);
      }
      i = paramInt;
      if (this.tow != null) {
        i = paramInt + a.a.a.b.b.a.f(28, this.tow);
      }
      paramInt = i;
      if (this.tXU != null) {
        paramInt = i + a.a.a.a.eN(29, this.tXU.aUd());
      }
      i = paramInt;
      if (this.tAe != null) {
        i = paramInt + a.a.a.b.b.a.f(30, this.tAe);
      }
      paramInt = i;
      if (this.tXV != null) {
        paramInt = i + a.a.a.b.b.a.f(31, this.tXV);
      }
      i = a.a.a.a.eL(32, this.tXW);
      GMTrace.o(3966268080128L, 29551);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tCk.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
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
      GMTrace.o(3966268080128L, 29551);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      awo localawo = (awo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3966268080128L, 29551);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tJy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.trx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.jdField_try = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 6: 
        localawo.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 8: 
        localawo.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 9: 
        localawo.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 10: 
        localawo.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 11: 
        localawo.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 12: 
        localawo.tLd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 13: 
        localawo.tLe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 14: 
        localawo.tLf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 15: 
        localawo.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 16: 
        localawo.tLg = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 17: 
        localawo.tLh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 18: 
        localawo.hAs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 19: 
        localawo.hAr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 20: 
        localawo.hAt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 21: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 22: 
        localawo.hAu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 23: 
        localawo.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 24: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tLk = ((mx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 25: 
        localawo.tCj = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 26: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awm();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awm)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tCk.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 27: 
        localawo.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 28: 
        localawo.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 29: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localawo.tXU = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 30: 
        localawo.tAe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      case 31: 
        localawo.tXV = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3966268080128L, 29551);
        return 0;
      }
      localawo.tXW = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3966268080128L, 29551);
      return 0;
    }
    GMTrace.o(3966268080128L, 29551);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/awo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */