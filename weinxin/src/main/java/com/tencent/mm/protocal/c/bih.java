package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bih
  extends com.tencent.mm.bd.a
{
  public String gkF;
  public String hAv;
  public bcl tLj;
  public String tPa;
  public String tPb;
  public int tbY;
  public ajg tdL;
  public String thE;
  public avx tik;
  public String tov;
  public String tow;
  public int ugA;
  public int ugB;
  public long ugC;
  public String ugD;
  public String ugk;
  public String ugl;
  public int ugm;
  public int ugn;
  public int ugo;
  public String ugp;
  public int ugq;
  public avu ugr;
  public int ugs;
  public String ugt;
  public String ugu;
  public String ugv;
  public String ugw;
  public String ugx;
  public apa ugy;
  public String ugz;
  
  public bih()
  {
    GMTrace.i(13169040818176L, 98117);
    GMTrace.o(13169040818176L, 98117);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13169175035904L, 98118);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tLj == null) {
        throw new b("Not all required fields were included: SnsUserInfo");
      }
      if (this.tLj != null)
      {
        paramVarArgs.eQ(1, this.tLj.aUd());
        this.tLj.a(paramVarArgs);
      }
      if (this.hAv != null) {
        paramVarArgs.e(2, this.hAv);
      }
      if (this.ugk != null) {
        paramVarArgs.e(3, this.ugk);
      }
      if (this.ugl != null) {
        paramVarArgs.e(4, this.ugl);
      }
      paramVarArgs.eO(5, this.ugm);
      paramVarArgs.eO(6, this.ugn);
      paramVarArgs.eO(7, this.ugo);
      if (this.ugp != null) {
        paramVarArgs.e(8, this.ugp);
      }
      if (this.tov != null) {
        paramVarArgs.e(9, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(10, this.tow);
      }
      paramVarArgs.eO(11, this.ugq);
      if (this.ugr != null)
      {
        paramVarArgs.eQ(12, this.ugr.aUd());
        this.ugr.a(paramVarArgs);
      }
      if (this.tik != null)
      {
        paramVarArgs.eQ(13, this.tik.aUd());
        this.tik.a(paramVarArgs);
      }
      paramVarArgs.eO(14, this.tbY);
      paramVarArgs.eO(15, this.ugs);
      if (this.thE != null) {
        paramVarArgs.e(16, this.thE);
      }
      if (this.tPa != null) {
        paramVarArgs.e(17, this.tPa);
      }
      if (this.tPb != null) {
        paramVarArgs.e(18, this.tPb);
      }
      if (this.ugt != null) {
        paramVarArgs.e(19, this.ugt);
      }
      if (this.ugu != null) {
        paramVarArgs.e(20, this.ugu);
      }
      if (this.ugv != null) {
        paramVarArgs.e(21, this.ugv);
      }
      if (this.ugw != null) {
        paramVarArgs.e(22, this.ugw);
      }
      if (this.tdL != null)
      {
        paramVarArgs.eQ(23, this.tdL.aUd());
        this.tdL.a(paramVarArgs);
      }
      if (this.ugx != null) {
        paramVarArgs.e(24, this.ugx);
      }
      if (this.ugy != null)
      {
        paramVarArgs.eQ(25, this.ugy.aUd());
        this.ugy.a(paramVarArgs);
      }
      if (this.ugz != null) {
        paramVarArgs.e(26, this.ugz);
      }
      paramVarArgs.eO(27, this.ugA);
      if (this.gkF != null) {
        paramVarArgs.e(28, this.gkF);
      }
      paramVarArgs.eO(29, this.ugB);
      paramVarArgs.O(30, this.ugC);
      if (this.ugD != null) {
        paramVarArgs.e(31, this.ugD);
      }
      GMTrace.o(13169175035904L, 98118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tLj != null) {
        i = a.a.a.a.eN(1, this.tLj.aUd()) + 0;
      }
      paramInt = i;
      if (this.hAv != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.hAv);
      }
      i = paramInt;
      if (this.ugk != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.ugk);
      }
      paramInt = i;
      if (this.ugl != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.ugl);
      }
      i = paramInt + a.a.a.a.eL(5, this.ugm) + a.a.a.a.eL(6, this.ugn) + a.a.a.a.eL(7, this.ugo);
      paramInt = i;
      if (this.ugp != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.ugp);
      }
      i = paramInt;
      if (this.tov != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tov);
      }
      paramInt = i;
      if (this.tow != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tow);
      }
      i = paramInt + a.a.a.a.eL(11, this.ugq);
      paramInt = i;
      if (this.ugr != null) {
        paramInt = i + a.a.a.a.eN(12, this.ugr.aUd());
      }
      i = paramInt;
      if (this.tik != null) {
        i = paramInt + a.a.a.a.eN(13, this.tik.aUd());
      }
      i = i + a.a.a.a.eL(14, this.tbY) + a.a.a.a.eL(15, this.ugs);
      paramInt = i;
      if (this.thE != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.thE);
      }
      i = paramInt;
      if (this.tPa != null) {
        i = paramInt + a.a.a.b.b.a.f(17, this.tPa);
      }
      paramInt = i;
      if (this.tPb != null) {
        paramInt = i + a.a.a.b.b.a.f(18, this.tPb);
      }
      i = paramInt;
      if (this.ugt != null) {
        i = paramInt + a.a.a.b.b.a.f(19, this.ugt);
      }
      paramInt = i;
      if (this.ugu != null) {
        paramInt = i + a.a.a.b.b.a.f(20, this.ugu);
      }
      i = paramInt;
      if (this.ugv != null) {
        i = paramInt + a.a.a.b.b.a.f(21, this.ugv);
      }
      paramInt = i;
      if (this.ugw != null) {
        paramInt = i + a.a.a.b.b.a.f(22, this.ugw);
      }
      i = paramInt;
      if (this.tdL != null) {
        i = paramInt + a.a.a.a.eN(23, this.tdL.aUd());
      }
      paramInt = i;
      if (this.ugx != null) {
        paramInt = i + a.a.a.b.b.a.f(24, this.ugx);
      }
      i = paramInt;
      if (this.ugy != null) {
        i = paramInt + a.a.a.a.eN(25, this.ugy.aUd());
      }
      paramInt = i;
      if (this.ugz != null) {
        paramInt = i + a.a.a.b.b.a.f(26, this.ugz);
      }
      i = paramInt + a.a.a.a.eL(27, this.ugA);
      paramInt = i;
      if (this.gkF != null) {
        paramInt = i + a.a.a.b.b.a.f(28, this.gkF);
      }
      i = paramInt + a.a.a.a.eL(29, this.ugB) + a.a.a.a.N(30, this.ugC);
      paramInt = i;
      if (this.ugD != null) {
        paramInt = i + a.a.a.b.b.a.f(31, this.ugD);
      }
      GMTrace.o(13169175035904L, 98118);
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
      if (this.tLj == null) {
        throw new b("Not all required fields were included: SnsUserInfo");
      }
      GMTrace.o(13169175035904L, 98118);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bih localbih = (bih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13169175035904L, 98118);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbih.tLj = ((bcl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 2: 
        localbih.hAv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 3: 
        localbih.ugk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 4: 
        localbih.ugl = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 5: 
        localbih.ugm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 6: 
        localbih.ugn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 7: 
        localbih.ugo = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 8: 
        localbih.ugp = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 9: 
        localbih.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 10: 
        localbih.tow = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 11: 
        localbih.ugq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbih.ugr = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 13: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbih.tik = ((avx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 14: 
        localbih.tbY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 15: 
        localbih.ugs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 16: 
        localbih.thE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 17: 
        localbih.tPa = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 18: 
        localbih.tPb = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 19: 
        localbih.ugt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 20: 
        localbih.ugu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 21: 
        localbih.ugv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 22: 
        localbih.ugw = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 23: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajg();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ajg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbih.tdL = ((ajg)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 24: 
        localbih.ugx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 25: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apa();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apa)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbih.ugy = ((apa)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 26: 
        localbih.ugz = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 27: 
        localbih.ugA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 28: 
        localbih.gkF = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 29: 
        localbih.ugB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      case 30: 
        localbih.ugC = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(13169175035904L, 98118);
        return 0;
      }
      localbih.ugD = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13169175035904L, 98118);
      return 0;
    }
    GMTrace.o(13169175035904L, 98118);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */