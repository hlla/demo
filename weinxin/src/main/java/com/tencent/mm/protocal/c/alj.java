package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class alj
  extends com.tencent.mm.bd.a
{
  public int hAl;
  public String hAm;
  public String hAn;
  public String hAo;
  public int hAp;
  public String hAu;
  public avu tJy;
  public int tLd;
  public String tLe;
  public avu tOA;
  public avu tOB;
  public int tOy;
  public avu tOz;
  public int tqV;
  public avu trN;
  public avu trx;
  public avu jdField_try;
  
  public alj()
  {
    GMTrace.i(3827084296192L, 28514);
    GMTrace.o(3827084296192L, 28514);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3827218513920L, 28515);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trN == null) {
        throw new b("Not all required fields were included: MemberName");
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
      if (this.tOz == null) {
        throw new b("Not all required fields were included: Remark");
      }
      if (this.tOA == null) {
        throw new b("Not all required fields were included: RemarkPYInitial");
      }
      if (this.tOB == null) {
        throw new b("Not all required fields were included: RemarkQuanPin");
      }
      if (this.trN != null)
      {
        paramVarArgs.eQ(1, this.trN.aUd());
        this.trN.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tOy);
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
      if (this.tOz != null)
      {
        paramVarArgs.eQ(9, this.tOz.aUd());
        this.tOz.a(paramVarArgs);
      }
      if (this.tOA != null)
      {
        paramVarArgs.eQ(10, this.tOA.aUd());
        this.tOA.a(paramVarArgs);
      }
      if (this.tOB != null)
      {
        paramVarArgs.eQ(11, this.tOB.aUd());
        this.tOB.a(paramVarArgs);
      }
      paramVarArgs.eO(12, this.tqV);
      if (this.hAm != null) {
        paramVarArgs.e(13, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(14, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(15, this.hAo);
      }
      paramVarArgs.eO(16, this.hAp);
      paramVarArgs.eO(17, this.tLd);
      if (this.tLe != null) {
        paramVarArgs.e(18, this.tLe);
      }
      if (this.hAu != null) {
        paramVarArgs.e(19, this.hAu);
      }
      GMTrace.o(3827218513920L, 28515);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trN != null) {
        paramInt = a.a.a.a.eN(1, this.trN.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tOy);
      paramInt = i;
      if (this.tJy != null) {
        paramInt = i + a.a.a.a.eN(3, this.tJy.aUd());
      }
      i = paramInt;
      if (this.trx != null) {
        i = paramInt + a.a.a.a.eN(4, this.trx.aUd());
      }
      paramInt = i;
      if (this.jdField_try != null) {
        paramInt = i + a.a.a.a.eN(5, this.jdField_try.aUd());
      }
      i = paramInt + a.a.a.a.eL(6, this.hAl);
      paramInt = i;
      if (this.tOz != null) {
        paramInt = i + a.a.a.a.eN(9, this.tOz.aUd());
      }
      i = paramInt;
      if (this.tOA != null) {
        i = paramInt + a.a.a.a.eN(10, this.tOA.aUd());
      }
      paramInt = i;
      if (this.tOB != null) {
        paramInt = i + a.a.a.a.eN(11, this.tOB.aUd());
      }
      i = paramInt + a.a.a.a.eL(12, this.tqV);
      paramInt = i;
      if (this.hAm != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.hAm);
      }
      i = paramInt;
      if (this.hAn != null) {
        i = paramInt + a.a.a.b.b.a.f(14, this.hAn);
      }
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.hAo);
      }
      i = paramInt + a.a.a.a.eL(16, this.hAp) + a.a.a.a.eL(17, this.tLd);
      paramInt = i;
      if (this.tLe != null) {
        paramInt = i + a.a.a.b.b.a.f(18, this.tLe);
      }
      i = paramInt;
      if (this.hAu != null) {
        i = paramInt + a.a.a.b.b.a.f(19, this.hAu);
      }
      GMTrace.o(3827218513920L, 28515);
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
      if (this.trN == null) {
        throw new b("Not all required fields were included: MemberName");
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
      if (this.tOz == null) {
        throw new b("Not all required fields were included: Remark");
      }
      if (this.tOA == null) {
        throw new b("Not all required fields were included: RemarkPYInitial");
      }
      if (this.tOB == null) {
        throw new b("Not all required fields were included: RemarkQuanPin");
      }
      GMTrace.o(3827218513920L, 28515);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      alj localalj = (alj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 7: 
      case 8: 
      default: 
        GMTrace.o(3827218513920L, 28515);
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
          localalj.trN = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 2: 
        localalj.tOy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3827218513920L, 28515);
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
          localalj.tJy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
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
          localalj.trx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
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
          localalj.jdField_try = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 6: 
        localalj.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3827218513920L, 28515);
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
          localalj.tOz = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
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
          localalj.tOA = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 11: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localalj.tOB = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 12: 
        localalj.tqV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 13: 
        localalj.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 14: 
        localalj.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 15: 
        localalj.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 16: 
        localalj.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 17: 
        localalj.tLd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      case 18: 
        localalj.tLe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3827218513920L, 28515);
        return 0;
      }
      localalj.hAu = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3827218513920L, 28515);
      return 0;
    }
    GMTrace.o(3827218513920L, 28515);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/alj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */