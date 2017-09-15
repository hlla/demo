package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ase
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
  public String jLx;
  public String jMD;
  public String tAe;
  public bcl tLj;
  public mx tLk;
  public int tUU;
  public String tUV;
  public int tUW;
  public String tUX;
  public String tov;
  public String tow;
  
  public ase()
  {
    GMTrace.i(3648574717952L, 27184);
    GMTrace.o(3648574717952L, 27184);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3648708935680L, 27185);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tUU);
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      if (this.jMD != null) {
        paramVarArgs.e(3, this.jMD);
      }
      if (this.tUV != null) {
        paramVarArgs.e(4, this.tUV);
      }
      paramVarArgs.eO(5, this.tUW);
      if (this.tUX != null) {
        paramVarArgs.e(6, this.tUX);
      }
      paramVarArgs.eO(7, this.hAl);
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
      if (this.hAq != null) {
        paramVarArgs.e(12, this.hAq);
      }
      paramVarArgs.eO(13, this.hAr);
      paramVarArgs.eO(14, this.hAs);
      if (this.hAt != null) {
        paramVarArgs.e(15, this.hAt);
      }
      if (this.tLj != null)
      {
        paramVarArgs.eQ(16, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAu != null) {
        paramVarArgs.e(17, this.hAu);
      }
      if (this.hAv != null) {
        paramVarArgs.e(18, this.hAv);
      }
      if (this.tLk != null)
      {
        paramVarArgs.eQ(19, this.tLk.aUd());
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
      GMTrace.o(3648708935680L, 27185);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tUU) + 0;
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.jLx);
      }
      i = paramInt;
      if (this.jMD != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.jMD);
      }
      paramInt = i;
      if (this.tUV != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tUV);
      }
      i = paramInt + a.a.a.a.eL(5, this.tUW);
      paramInt = i;
      if (this.tUX != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tUX);
      }
      i = paramInt + a.a.a.a.eL(7, this.hAl);
      paramInt = i;
      if (this.hAm != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.hAm);
      }
      i = paramInt;
      if (this.hAn != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.hAn);
      }
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.hAo);
      }
      i = paramInt + a.a.a.a.eL(11, this.hAp);
      paramInt = i;
      if (this.hAq != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.hAq);
      }
      i = paramInt + a.a.a.a.eL(13, this.hAr) + a.a.a.a.eL(14, this.hAs);
      paramInt = i;
      if (this.hAt != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.hAt);
      }
      i = paramInt;
      if (this.tLj != null) {
        i = paramInt + a.a.a.a.eN(16, this.tLj.aUd());
      }
      paramInt = i;
      if (this.hAu != null) {
        paramInt = i + a.a.a.b.b.a.f(17, this.hAu);
      }
      i = paramInt;
      if (this.hAv != null) {
        i = paramInt + a.a.a.b.b.a.f(18, this.hAv);
      }
      paramInt = i;
      if (this.tLk != null) {
        paramInt = i + a.a.a.a.eN(19, this.tLk.aUd());
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
      GMTrace.o(3648708935680L, 27185);
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
      GMTrace.o(3648708935680L, 27185);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ase localase = (ase)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3648708935680L, 27185);
        return -1;
      case 1: 
        localase.tUU = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 2: 
        localase.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 3: 
        localase.jMD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 4: 
        localase.tUV = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 5: 
        localase.tUW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 6: 
        localase.tUX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 7: 
        localase.hAl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 8: 
        localase.hAm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 9: 
        localase.hAn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 10: 
        localase.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 11: 
        localase.hAp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 12: 
        localase.hAq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 13: 
        localase.hAr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 14: 
        localase.hAs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 15: 
        localase.hAt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 16: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localase.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 17: 
        localase.hAu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 18: 
        localase.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 19: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localase.tLk = ((mx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 20: 
        localase.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      case 21: 
        localase.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3648708935680L, 27185);
        return 0;
      }
      localase.tAe = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3648708935680L, 27185);
      return 0;
    }
    GMTrace.o(3648708935680L, 27185);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */