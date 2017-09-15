package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class gd
  extends ave
{
  public String jLx;
  public String lda;
  public String tfK;
  public String tfW;
  public int tgi;
  public String thR;
  public String thS;
  public int thT;
  public String thU;
  public int thV;
  public String thW;
  public String thX;
  public avt thY;
  public int thZ;
  public int tia;
  
  public gd()
  {
    GMTrace.i(13168503947264L, 98113);
    GMTrace.o(13168503947264L, 98113);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13168638164992L, 98114);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      if (this.thR != null) {
        paramVarArgs.e(3, this.thR);
      }
      paramVarArgs.eO(4, this.tgi);
      if (this.thS != null) {
        paramVarArgs.e(5, this.thS);
      }
      paramVarArgs.eO(6, this.thT);
      if (this.thU != null) {
        paramVarArgs.e(7, this.thU);
      }
      if (this.tfK != null) {
        paramVarArgs.e(8, this.tfK);
      }
      paramVarArgs.eO(9, this.thV);
      if (this.thW != null) {
        paramVarArgs.e(10, this.thW);
      }
      if (this.thX != null) {
        paramVarArgs.e(11, this.thX);
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(12, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      if (this.lda != null) {
        paramVarArgs.e(13, this.lda);
      }
      paramVarArgs.eO(14, this.thZ);
      paramVarArgs.eO(15, this.tia);
      if (this.tfW != null) {
        paramVarArgs.e(16, this.tfW);
      }
      GMTrace.o(13168638164992L, 98114);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXb != null) {
        i = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.jLx);
      }
      i = paramInt;
      if (this.thR != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.thR);
      }
      i += a.a.a.a.eL(4, this.tgi);
      paramInt = i;
      if (this.thS != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.thS);
      }
      i = paramInt + a.a.a.a.eL(6, this.thT);
      paramInt = i;
      if (this.thU != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.thU);
      }
      i = paramInt;
      if (this.tfK != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.tfK);
      }
      i += a.a.a.a.eL(9, this.thV);
      paramInt = i;
      if (this.thW != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.thW);
      }
      i = paramInt;
      if (this.thX != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.thX);
      }
      paramInt = i;
      if (this.thY != null) {
        paramInt = i + a.a.a.a.eN(12, this.thY.aUd());
      }
      i = paramInt;
      if (this.lda != null) {
        i = paramInt + a.a.a.b.b.a.f(13, this.lda);
      }
      i = i + a.a.a.a.eL(14, this.thZ) + a.a.a.a.eL(15, this.tia);
      paramInt = i;
      if (this.tfW != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.tfW);
      }
      GMTrace.o(13168638164992L, 98114);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13168638164992L, 98114);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      gd localgd = (gd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13168638164992L, 98114);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localgd.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 2: 
        localgd.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 3: 
        localgd.thR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 4: 
        localgd.tgi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 5: 
        localgd.thS = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 6: 
        localgd.thT = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 7: 
        localgd.thU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 8: 
        localgd.tfK = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 9: 
        localgd.thV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 10: 
        localgd.thW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 11: 
        localgd.thX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localgd.thY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 13: 
        localgd.lda = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 14: 
        localgd.thZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      case 15: 
        localgd.tia = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13168638164992L, 98114);
        return 0;
      }
      localgd.tfW = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13168638164992L, 98114);
      return 0;
    }
    GMTrace.o(13168638164992L, 98114);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */