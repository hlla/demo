package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class os
  extends ave
{
  public String lda;
  public String tfW;
  public int tgi;
  public String thD;
  public avt thY;
  public String tie;
  public String tsD;
  public String tsE;
  public int tsF;
  
  public os()
  {
    GMTrace.i(4047201370112L, 30154);
    GMTrace.o(4047201370112L, 30154);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4047335587840L, 30155);
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
      paramVarArgs.eO(3, this.tgi);
      if (this.thD != null) {
        paramVarArgs.e(4, this.thD);
      }
      if (this.lda != null) {
        paramVarArgs.e(5, this.lda);
      }
      if (this.tie != null) {
        paramVarArgs.e(6, this.tie);
      }
      if (this.tsD != null) {
        paramVarArgs.e(7, this.tsD);
      }
      if (this.tfW != null) {
        paramVarArgs.e(8, this.tfW);
      }
      if (this.tsE != null) {
        paramVarArgs.e(9, this.tsE);
      }
      paramVarArgs.eO(10, this.tsF);
      GMTrace.o(4047335587840L, 30155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.thY != null) {
        i = paramInt + a.a.a.a.eN(2, this.thY.aUd());
      }
      i += a.a.a.a.eL(3, this.tgi);
      paramInt = i;
      if (this.thD != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.thD);
      }
      i = paramInt;
      if (this.lda != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.lda);
      }
      paramInt = i;
      if (this.tie != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tie);
      }
      i = paramInt;
      if (this.tsD != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tsD);
      }
      paramInt = i;
      if (this.tfW != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tfW);
      }
      i = paramInt;
      if (this.tsE != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tsE);
      }
      paramInt = a.a.a.a.eL(10, this.tsF);
      GMTrace.o(4047335587840L, 30155);
      return i + paramInt;
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
      GMTrace.o(4047335587840L, 30155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      os localos = (os)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4047335587840L, 30155);
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
          localos.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4047335587840L, 30155);
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
          localos.thY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 3: 
        localos.tgi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 4: 
        localos.thD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 5: 
        localos.lda = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 6: 
        localos.tie = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 7: 
        localos.tsD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 8: 
        localos.tfW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      case 9: 
        localos.tsE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047335587840L, 30155);
        return 0;
      }
      localos.tsF = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(4047335587840L, 30155);
      return 0;
    }
    GMTrace.o(4047335587840L, 30155);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/os.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */