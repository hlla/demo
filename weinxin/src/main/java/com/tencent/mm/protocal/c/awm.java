package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class awm
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
  public String tAe;
  public avu tJy;
  public int tLd;
  public String tLe;
  public String tLf;
  public String tLg;
  public int tLh;
  public bcl tLj;
  public mx tLk;
  public avt tdB;
  public String tov;
  public String tow;
  public avu trH;
  public avu trx;
  public avu jdField_try;
  
  public awm()
  {
    GMTrace.i(3708838477824L, 27633);
    GMTrace.o(3708838477824L, 27633);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3708972695552L, 27634);
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
      if (this.hAm != null) {
        paramVarArgs.e(7, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(8, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(9, this.hAo);
      }
      paramVarArgs.eO(10, this.hAp);
      paramVarArgs.eO(11, this.tLd);
      if (this.tLe != null) {
        paramVarArgs.e(12, this.tLe);
      }
      if (this.tLf != null) {
        paramVarArgs.e(13, this.tLf);
      }
      if (this.hAq != null) {
        paramVarArgs.e(14, this.hAq);
      }
      if (this.tLg != null) {
        paramVarArgs.e(15, this.tLg);
      }
      paramVarArgs.eO(16, this.tLh);
      paramVarArgs.eO(17, this.hAs);
      paramVarArgs.eO(18, this.hAr);
      if (this.hAt != null) {
        paramVarArgs.e(19, this.hAt);
      }
      if (this.tLj != null)
      {
        paramVarArgs.eQ(20, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAu != null) {
        paramVarArgs.e(21, this.hAu);
      }
      if (this.hAv != null) {
        paramVarArgs.e(22, this.hAv);
      }
      if (this.tLk != null)
      {
        paramVarArgs.eQ(23, this.tLk.aUd());
        this.tLk.a(paramVarArgs);
      }
      if (this.tov != null) {
        paramVarArgs.e(24, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(25, this.tow);
      }
      if (this.tAe != null) {
        paramVarArgs.e(26, this.tAe);
      }
      GMTrace.o(3708972695552L, 27634);
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
      i = paramInt;
      if (this.hAm != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.hAm);
      }
      paramInt = i;
      if (this.hAn != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.hAn);
      }
      i = paramInt;
      if (this.hAo != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.hAo);
      }
      i = i + a.a.a.a.eL(10, this.hAp) + a.a.a.a.eL(11, this.tLd);
      paramInt = i;
      if (this.tLe != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.tLe);
      }
      i = paramInt;
      if (this.tLf != null) {
        i = paramInt + a.a.a.b.b.a.f(13, this.tLf);
      }
      paramInt = i;
      if (this.hAq != null) {
        paramInt = i + a.a.a.b.b.a.f(14, this.hAq);
      }
      i = paramInt;
      if (this.tLg != null) {
        i = paramInt + a.a.a.b.b.a.f(15, this.tLg);
      }
      i = i + a.a.a.a.eL(16, this.tLh) + a.a.a.a.eL(17, this.hAs) + a.a.a.a.eL(18, this.hAr);
      paramInt = i;
      if (this.hAt != null) {
        paramInt = i + a.a.a.b.b.a.f(19, this.hAt);
      }
      i = paramInt;
      if (this.tLj != null) {
        i = paramInt + a.a.a.a.eN(20, this.tLj.aUd());
      }
      paramInt = i;
      if (this.hAu != null) {
        paramInt = i + a.a.a.b.b.a.f(21, this.hAu);
      }
      i = paramInt;
      if (this.hAv != null) {
        i = paramInt + a.a.a.b.b.a.f(22, this.hAv);
      }
      paramInt = i;
      if (this.tLk != null) {
        paramInt = i + a.a.a.a.eN(23, this.tLk.aUd());
      }
      i = paramInt;
      if (this.tov != null) {
        i = paramInt + a.a.a.b.b.a.f(24, this.tov);
      }
      paramInt = i;
      if (this.tow != null) {
        paramInt = i + a.a.a.b.b.a.f(25, this.tow);
      }
      i = paramInt;
      if (this.tAe != null) {
        i = paramInt + a.a.a.b.b.a.f(26, this.tAe);
      }
      GMTrace.o(3708972695552L, 27634);
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
      GMTrace.o(3708972695552L, 27634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      awm localawm = (awm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3708972695552L, 27634);
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
          localawm.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
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
          localawm.tJy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
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
          localawm.trx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
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
          localawm.jdField_try = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 5: 
        localawm.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3708972695552L, 27634);
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
          localawm.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 7: 
        localawm.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 8: 
        localawm.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 9: 
        localawm.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 10: 
        localawm.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 11: 
        localawm.tLd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 12: 
        localawm.tLe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 13: 
        localawm.tLf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 14: 
        localawm.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 15: 
        localawm.tLg = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 16: 
        localawm.tLh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 17: 
        localawm.hAs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 18: 
        localawm.hAr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 19: 
        localawm.hAt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 20: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localawm.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 21: 
        localawm.hAu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 22: 
        localawm.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 23: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localawm.tLk = ((mx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 24: 
        localawm.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      case 25: 
        localawm.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3708972695552L, 27634);
        return 0;
      }
      localawm.tAe = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3708972695552L, 27634);
      return 0;
    }
    GMTrace.o(3708972695552L, 27634);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/awm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */