package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class du
  extends ave
{
  public String hAo;
  public String jLB;
  public String lcZ;
  public String lda;
  public ek tfS;
  public String tfT;
  public String tfU;
  public int tfV;
  public String tfW;
  public String tfX;
  public avt tfz;
  
  public du()
  {
    GMTrace.i(13580552372224L, 101183);
    GMTrace.o(13580552372224L, 101183);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13580686589952L, 101184);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfz == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tfS != null)
      {
        paramVarArgs.eQ(2, this.tfS.aUd());
        this.tfS.a(paramVarArgs);
      }
      if (this.tfz != null)
      {
        paramVarArgs.eQ(3, this.tfz.aUd());
        this.tfz.a(paramVarArgs);
      }
      if (this.tfT != null) {
        paramVarArgs.e(4, this.tfT);
      }
      if (this.tfU != null) {
        paramVarArgs.e(5, this.tfU);
      }
      paramVarArgs.eO(6, this.tfV);
      if (this.tfW != null) {
        paramVarArgs.e(7, this.tfW);
      }
      if (this.hAo != null) {
        paramVarArgs.e(8, this.hAo);
      }
      if (this.jLB != null) {
        paramVarArgs.e(9, this.jLB);
      }
      if (this.tfX != null) {
        paramVarArgs.e(10, this.tfX);
      }
      if (this.lda != null) {
        paramVarArgs.e(11, this.lda);
      }
      if (this.lcZ != null) {
        paramVarArgs.e(12, this.lcZ);
      }
      GMTrace.o(13580686589952L, 101184);
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
      if (this.tfS != null) {
        paramInt = i + a.a.a.a.eN(2, this.tfS.aUd());
      }
      i = paramInt;
      if (this.tfz != null) {
        i = paramInt + a.a.a.a.eN(3, this.tfz.aUd());
      }
      paramInt = i;
      if (this.tfT != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tfT);
      }
      i = paramInt;
      if (this.tfU != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tfU);
      }
      i += a.a.a.a.eL(6, this.tfV);
      paramInt = i;
      if (this.tfW != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tfW);
      }
      i = paramInt;
      if (this.hAo != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.hAo);
      }
      paramInt = i;
      if (this.jLB != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.jLB);
      }
      i = paramInt;
      if (this.tfX != null) {
        i = paramInt + a.a.a.b.b.a.f(10, this.tfX);
      }
      paramInt = i;
      if (this.lda != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.lda);
      }
      i = paramInt;
      if (this.lcZ != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.lcZ);
      }
      GMTrace.o(13580686589952L, 101184);
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
      if (this.tfz == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      GMTrace.o(13580686589952L, 101184);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      du localdu = (du)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13580686589952L, 101184);
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
          localdu.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ek();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ek)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localdu.tfS = ((ek)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localdu.tfz = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 4: 
        localdu.tfT = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 5: 
        localdu.tfU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 6: 
        localdu.tfV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 7: 
        localdu.tfW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 8: 
        localdu.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 9: 
        localdu.jLB = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 10: 
        localdu.tfX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      case 11: 
        localdu.lda = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580686589952L, 101184);
        return 0;
      }
      localdu.lcZ = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13580686589952L, 101184);
      return 0;
    }
    GMTrace.o(13580686589952L, 101184);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */