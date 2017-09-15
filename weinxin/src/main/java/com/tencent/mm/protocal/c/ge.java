package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ge
  extends avm
{
  public String fGM;
  public int tbY;
  public azz tfJ;
  public String tfK;
  public String tfa;
  public String tib;
  public int tic;
  public String tie;
  public afa tif;
  public hr tig;
  public ane tih;
  public String tii;
  public int tij;
  public avx tik;
  public String til;
  public String tim;
  
  public ge()
  {
    GMTrace.i(13170919866368L, 98131);
    GMTrace.o(13170919866368L, 98131);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13171054084096L, 98132);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.fGM != null) {
        paramVarArgs.e(2, this.fGM);
      }
      if (this.tib != null) {
        paramVarArgs.e(3, this.tib);
      }
      paramVarArgs.eO(4, this.tic);
      if (this.tie != null) {
        paramVarArgs.e(5, this.tie);
      }
      if (this.tfa != null) {
        paramVarArgs.e(6, this.tfa);
      }
      if (this.tif != null)
      {
        paramVarArgs.eQ(7, this.tif.aUd());
        this.tif.a(paramVarArgs);
      }
      if (this.tig != null)
      {
        paramVarArgs.eQ(8, this.tig.aUd());
        this.tig.a(paramVarArgs);
      }
      if (this.tih != null)
      {
        paramVarArgs.eQ(9, this.tih.aUd());
        this.tih.a(paramVarArgs);
      }
      if (this.tfK != null) {
        paramVarArgs.e(10, this.tfK);
      }
      paramVarArgs.eO(11, this.tbY);
      if (this.tii != null) {
        paramVarArgs.e(12, this.tii);
      }
      paramVarArgs.eO(13, this.tij);
      if (this.tik != null)
      {
        paramVarArgs.eQ(14, this.tik.aUd());
        this.tik.a(paramVarArgs);
      }
      if (this.til != null) {
        paramVarArgs.e(15, this.til);
      }
      if (this.tim != null) {
        paramVarArgs.e(16, this.tim);
      }
      if (this.tfJ != null)
      {
        paramVarArgs.eQ(17, this.tfJ.aUd());
        this.tfJ.a(paramVarArgs);
      }
      GMTrace.o(13171054084096L, 98132);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.fGM != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.fGM);
      }
      i = paramInt;
      if (this.tib != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tib);
      }
      i += a.a.a.a.eL(4, this.tic);
      paramInt = i;
      if (this.tie != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tie);
      }
      i = paramInt;
      if (this.tfa != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.tfa);
      }
      paramInt = i;
      if (this.tif != null) {
        paramInt = i + a.a.a.a.eN(7, this.tif.aUd());
      }
      i = paramInt;
      if (this.tig != null) {
        i = paramInt + a.a.a.a.eN(8, this.tig.aUd());
      }
      paramInt = i;
      if (this.tih != null) {
        paramInt = i + a.a.a.a.eN(9, this.tih.aUd());
      }
      i = paramInt;
      if (this.tfK != null) {
        i = paramInt + a.a.a.b.b.a.f(10, this.tfK);
      }
      i += a.a.a.a.eL(11, this.tbY);
      paramInt = i;
      if (this.tii != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.tii);
      }
      i = paramInt + a.a.a.a.eL(13, this.tij);
      paramInt = i;
      if (this.tik != null) {
        paramInt = i + a.a.a.a.eN(14, this.tik.aUd());
      }
      i = paramInt;
      if (this.til != null) {
        i = paramInt + a.a.a.b.b.a.f(15, this.til);
      }
      paramInt = i;
      if (this.tim != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.tim);
      }
      i = paramInt;
      if (this.tfJ != null) {
        i = paramInt + a.a.a.a.eN(17, this.tfJ.aUd());
      }
      GMTrace.o(13171054084096L, 98132);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(13171054084096L, 98132);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ge localge = (ge)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13171054084096L, 98132);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localge.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 2: 
        localge.fGM = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 3: 
        localge.tib = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 4: 
        localge.tic = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 5: 
        localge.tie = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 6: 
        localge.tfa = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afa();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afa)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localge.tif = ((afa)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localge.tig = ((hr)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ane();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ane)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localge.tih = ((ane)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 10: 
        localge.tfK = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 11: 
        localge.tbY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 12: 
        localge.tii = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 13: 
        localge.tij = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 14: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localge.tik = ((avx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 15: 
        localge.til = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      case 16: 
        localge.tim = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13171054084096L, 98132);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new azz();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((azz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localge.tfJ = ((azz)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13171054084096L, 98132);
      return 0;
    }
    GMTrace.o(13171054084096L, 98132);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */