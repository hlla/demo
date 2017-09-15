package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aju
  extends com.tencent.mm.bd.a
{
  public String hAk;
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
  public String tLN;
  public qp tLO;
  public bcl tLj;
  public mx tLk;
  public String tfa;
  public String tov;
  public String tow;
  
  public aju()
  {
    GMTrace.i(4041564225536L, 30112);
    GMTrace.o(4041564225536L, 30112);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4041698443264L, 30113);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfa != null) {
        paramVarArgs.e(1, this.tfa);
      }
      if (this.tLN != null) {
        paramVarArgs.e(2, this.tLN);
      }
      if (this.hAk != null) {
        paramVarArgs.e(3, this.hAk);
      }
      paramVarArgs.eO(4, this.hAl);
      if (this.hAm != null) {
        paramVarArgs.e(5, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(6, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(7, this.hAo);
      }
      paramVarArgs.eO(8, this.hAp);
      if (this.hAq != null) {
        paramVarArgs.e(9, this.hAq);
      }
      if (this.tLO != null)
      {
        paramVarArgs.eQ(10, this.tLO.aUd());
        this.tLO.a(paramVarArgs);
      }
      paramVarArgs.eO(11, this.hAr);
      paramVarArgs.eO(12, this.hAs);
      if (this.hAt != null) {
        paramVarArgs.e(13, this.hAt);
      }
      if (this.tLj != null)
      {
        paramVarArgs.eQ(14, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAu != null) {
        paramVarArgs.e(15, this.hAu);
      }
      if (this.hAv != null) {
        paramVarArgs.e(16, this.hAv);
      }
      if (this.tLk != null)
      {
        paramVarArgs.eQ(17, this.tLk.aUd());
        this.tLk.a(paramVarArgs);
      }
      if (this.tov != null) {
        paramVarArgs.e(20, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(21, this.tow);
      }
      if (this.tAe != null) {
        paramVarArgs.e(22, this.tAe);
      }
      GMTrace.o(4041698443264L, 30113);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tfa != null) {
        i = a.a.a.b.b.a.f(1, this.tfa) + 0;
      }
      paramInt = i;
      if (this.tLN != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tLN);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.hAk);
      }
      i += a.a.a.a.eL(4, this.hAl);
      paramInt = i;
      if (this.hAm != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.hAm);
      }
      i = paramInt;
      if (this.hAn != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.hAn);
      }
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.hAo);
      }
      i = paramInt + a.a.a.a.eL(8, this.hAp);
      paramInt = i;
      if (this.hAq != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.hAq);
      }
      i = paramInt;
      if (this.tLO != null) {
        i = paramInt + a.a.a.a.eN(10, this.tLO.aUd());
      }
      i = i + a.a.a.a.eL(11, this.hAr) + a.a.a.a.eL(12, this.hAs);
      paramInt = i;
      if (this.hAt != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.hAt);
      }
      i = paramInt;
      if (this.tLj != null) {
        i = paramInt + a.a.a.a.eN(14, this.tLj.aUd());
      }
      paramInt = i;
      if (this.hAu != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.hAu);
      }
      i = paramInt;
      if (this.hAv != null) {
        i = paramInt + a.a.a.b.b.a.f(16, this.hAv);
      }
      paramInt = i;
      if (this.tLk != null) {
        paramInt = i + a.a.a.a.eN(17, this.tLk.aUd());
      }
      i = paramInt;
      if (this.tov != null) {
        i = paramInt + a.a.a.b.b.a.f(20, this.tov);
      }
      paramInt = i;
      if (this.tow != null) {
        paramInt = i + a.a.a.b.b.a.f(21, this.tow);
      }
      i = paramInt;
      if (this.tAe != null) {
        i = paramInt + a.a.a.b.b.a.f(22, this.tAe);
      }
      GMTrace.o(4041698443264L, 30113);
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
      GMTrace.o(4041698443264L, 30113);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aju localaju = (aju)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 18: 
      case 19: 
      default: 
        GMTrace.o(4041698443264L, 30113);
        return -1;
      case 1: 
        localaju.tfa = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 2: 
        localaju.tLN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 3: 
        localaju.hAk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 4: 
        localaju.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 5: 
        localaju.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 6: 
        localaju.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 7: 
        localaju.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 8: 
        localaju.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 9: 
        localaju.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qp();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qp)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaju.tLO = ((qp)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 11: 
        localaju.hAr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 12: 
        localaju.hAs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 13: 
        localaju.hAt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 14: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaju.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 15: 
        localaju.hAu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 16: 
        localaju.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 17: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaju.tLk = ((mx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 20: 
        localaju.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      case 21: 
        localaju.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4041698443264L, 30113);
        return 0;
      }
      localaju.tAe = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4041698443264L, 30113);
      return 0;
    }
    GMTrace.o(4041698443264L, 30113);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */