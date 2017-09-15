package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class ait
  extends com.tencent.mm.bd.a
{
  public int hAl;
  public String hAm;
  public String hAn;
  public String hAo;
  public String hAq;
  public String hAu;
  public String hAv;
  public String jLx;
  public String jMD;
  public String tAe;
  public String tFy;
  public String tLc;
  public int tLd;
  public String tLe;
  public String tLf;
  public String tLg;
  public int tLh;
  public int tLi;
  public bcl tLj;
  public mx tLk;
  public int tdA;
  public String tov;
  public String tow;
  
  public ait()
  {
    GMTrace.i(3997943463936L, 29787);
    GMTrace.o(3997943463936L, 29787);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3998077681664L, 29788);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      if (this.jMD != null) {
        paramVarArgs.e(2, this.jMD);
      }
      if (this.hAm != null) {
        paramVarArgs.e(3, this.hAm);
      }
      if (this.hAn != null) {
        paramVarArgs.e(4, this.hAn);
      }
      if (this.hAo != null) {
        paramVarArgs.e(5, this.hAo);
      }
      if (this.tLc != null) {
        paramVarArgs.e(6, this.tLc);
      }
      paramVarArgs.eO(7, this.hAl);
      paramVarArgs.eO(8, this.tdA);
      paramVarArgs.eO(9, this.tLd);
      if (this.tLe != null) {
        paramVarArgs.e(10, this.tLe);
      }
      if (this.tFy != null) {
        paramVarArgs.e(11, this.tFy);
      }
      if (this.hAq != null) {
        paramVarArgs.e(12, this.hAq);
      }
      if (this.tLf != null) {
        paramVarArgs.e(13, this.tLf);
      }
      if (this.tLg != null) {
        paramVarArgs.e(14, this.tLg);
      }
      paramVarArgs.eO(15, this.tLh);
      paramVarArgs.eO(19, this.tLi);
      if (this.tLj != null)
      {
        paramVarArgs.eQ(20, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAu != null) {
        paramVarArgs.e(21, this.hAu);
      }
      if (this.tov != null) {
        paramVarArgs.e(22, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(23, this.tow);
      }
      if (this.hAv != null) {
        paramVarArgs.e(24, this.hAv);
      }
      if (this.tLk != null)
      {
        paramVarArgs.eQ(25, this.tLk.aUd());
        this.tLk.a(paramVarArgs);
      }
      if (this.tAe != null) {
        paramVarArgs.e(26, this.tAe);
      }
      GMTrace.o(3998077681664L, 29788);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.jLx != null) {
        i = a.a.a.b.b.a.f(1, this.jLx) + 0;
      }
      paramInt = i;
      if (this.jMD != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.jMD);
      }
      i = paramInt;
      if (this.hAm != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.hAm);
      }
      paramInt = i;
      if (this.hAn != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.hAn);
      }
      i = paramInt;
      if (this.hAo != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.hAo);
      }
      paramInt = i;
      if (this.tLc != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tLc);
      }
      i = paramInt + a.a.a.a.eL(7, this.hAl) + a.a.a.a.eL(8, this.tdA) + a.a.a.a.eL(9, this.tLd);
      paramInt = i;
      if (this.tLe != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tLe);
      }
      i = paramInt;
      if (this.tFy != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.tFy);
      }
      paramInt = i;
      if (this.hAq != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.hAq);
      }
      i = paramInt;
      if (this.tLf != null) {
        i = paramInt + a.a.a.b.b.a.f(13, this.tLf);
      }
      paramInt = i;
      if (this.tLg != null) {
        paramInt = i + a.a.a.b.b.a.f(14, this.tLg);
      }
      i = paramInt + a.a.a.a.eL(15, this.tLh) + a.a.a.a.eL(19, this.tLi);
      paramInt = i;
      if (this.tLj != null) {
        paramInt = i + a.a.a.a.eN(20, this.tLj.aUd());
      }
      i = paramInt;
      if (this.hAu != null) {
        i = paramInt + a.a.a.b.b.a.f(21, this.hAu);
      }
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + a.a.a.b.b.a.f(22, this.tov);
      }
      i = paramInt;
      if (this.tow != null) {
        i = paramInt + a.a.a.b.b.a.f(23, this.tow);
      }
      paramInt = i;
      if (this.hAv != null) {
        paramInt = i + a.a.a.b.b.a.f(24, this.hAv);
      }
      i = paramInt;
      if (this.tLk != null) {
        i = paramInt + a.a.a.a.eN(25, this.tLk.aUd());
      }
      paramInt = i;
      if (this.tAe != null) {
        paramInt = i + a.a.a.b.b.a.f(26, this.tAe);
      }
      GMTrace.o(3998077681664L, 29788);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3998077681664L, 29788);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ait localait = (ait)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 16: 
      case 17: 
      case 18: 
      default: 
        GMTrace.o(3998077681664L, 29788);
        return -1;
      case 1: 
        localait.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 2: 
        localait.jMD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 3: 
        localait.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 4: 
        localait.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 5: 
        localait.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 6: 
        localait.tLc = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 7: 
        localait.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 8: 
        localait.tdA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 9: 
        localait.tLd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 10: 
        localait.tLe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 11: 
        localait.tFy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 12: 
        localait.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 13: 
        localait.tLf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 14: 
        localait.tLg = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 15: 
        localait.tLh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 19: 
        localait.tLi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998077681664L, 29788);
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
          localait.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 21: 
        localait.hAu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 22: 
        localait.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 23: 
        localait.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 24: 
        localait.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998077681664L, 29788);
        return 0;
      case 25: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localait.tLk = ((mx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3998077681664L, 29788);
        return 0;
      }
      localait.tAe = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3998077681664L, 29788);
      return 0;
    }
    GMTrace.o(3998077681664L, 29788);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ait.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */