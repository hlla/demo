package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class abk
  extends ave
{
  public String jMD;
  public String lda;
  public String tFu;
  public String tFv;
  public String tFw;
  public String tFx;
  public String tFy;
  public int tFz;
  public String tfW;
  public avt thY;
  
  public abk()
  {
    GMTrace.i(3797019525120L, 28290);
    GMTrace.o(3797019525120L, 28290);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3797153742848L, 28291);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(2, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      if (this.tFu != null) {
        paramVarArgs.e(3, this.tFu);
      }
      if (this.tFv != null) {
        paramVarArgs.e(4, this.tFv);
      }
      if (this.jMD != null) {
        paramVarArgs.e(5, this.jMD);
      }
      if (this.tFw != null) {
        paramVarArgs.e(6, this.tFw);
      }
      if (this.tFx != null) {
        paramVarArgs.e(7, this.tFx);
      }
      if (this.tFy != null) {
        paramVarArgs.e(8, this.tFy);
      }
      paramVarArgs.eO(9, this.tFz);
      if (this.lda != null) {
        paramVarArgs.e(10, this.lda);
      }
      if (this.tfW != null) {
        paramVarArgs.e(11, this.tfW);
      }
      GMTrace.o(3797153742848L, 28291);
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
      if (this.thY != null) {
        paramInt = i + a.a.a.a.eN(2, this.thY.aUd());
      }
      i = paramInt;
      if (this.tFu != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tFu);
      }
      paramInt = i;
      if (this.tFv != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tFv);
      }
      i = paramInt;
      if (this.jMD != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.jMD);
      }
      paramInt = i;
      if (this.tFw != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tFw);
      }
      i = paramInt;
      if (this.tFx != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tFx);
      }
      paramInt = i;
      if (this.tFy != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tFy);
      }
      i = paramInt + a.a.a.a.eL(9, this.tFz);
      paramInt = i;
      if (this.lda != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.lda);
      }
      i = paramInt;
      if (this.tfW != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.tfW);
      }
      GMTrace.o(3797153742848L, 28291);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      GMTrace.o(3797153742848L, 28291);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      abk localabk = (abk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3797153742848L, 28291);
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
          localabk.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localabk.thY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 3: 
        localabk.tFu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 4: 
        localabk.tFv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 5: 
        localabk.jMD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 6: 
        localabk.tFw = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 7: 
        localabk.tFx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 8: 
        localabk.tFy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 9: 
        localabk.tFz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      case 10: 
        localabk.lda = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3797153742848L, 28291);
        return 0;
      }
      localabk.tfW = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3797153742848L, 28291);
      return 0;
    }
    GMTrace.o(3797153742848L, 28291);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/abk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */