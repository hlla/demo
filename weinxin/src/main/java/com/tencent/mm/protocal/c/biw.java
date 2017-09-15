package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class biw
  extends avm
{
  public avu tGC;
  public avt tdB;
  public avt tfB;
  public String tfG;
  public avt tfH;
  public avu tis;
  public avt tit;
  public String tsG;
  
  public biw()
  {
    GMTrace.i(13337081413632L, 99369);
    GMTrace.o(13337081413632L, 99369);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13337215631360L, 99370);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tGC == null) {
        throw new b("Not all required fields were included: ImgSid");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tGC != null)
      {
        paramVarArgs.eQ(2, this.tGC.aUd());
        this.tGC.a(paramVarArgs);
      }
      if (this.tdB != null)
      {
        paramVarArgs.eQ(3, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      if (this.tsG != null) {
        paramVarArgs.e(4, this.tsG);
      }
      if (this.tis != null)
      {
        paramVarArgs.eQ(5, this.tis.aUd());
        this.tis.a(paramVarArgs);
      }
      if (this.tfH != null)
      {
        paramVarArgs.eQ(6, this.tfH.aUd());
        this.tfH.a(paramVarArgs);
      }
      if (this.tit != null)
      {
        paramVarArgs.eQ(7, this.tit.aUd());
        this.tit.a(paramVarArgs);
      }
      if (this.tfG != null) {
        paramVarArgs.e(8, this.tfG);
      }
      if (this.tfB != null)
      {
        paramVarArgs.eQ(9, this.tfB.aUd());
        this.tfB.a(paramVarArgs);
      }
      GMTrace.o(13337215631360L, 99370);
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
      if (this.tGC != null) {
        paramInt = i + a.a.a.a.eN(2, this.tGC.aUd());
      }
      i = paramInt;
      if (this.tdB != null) {
        i = paramInt + a.a.a.a.eN(3, this.tdB.aUd());
      }
      paramInt = i;
      if (this.tsG != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tsG);
      }
      i = paramInt;
      if (this.tis != null) {
        i = paramInt + a.a.a.a.eN(5, this.tis.aUd());
      }
      paramInt = i;
      if (this.tfH != null) {
        paramInt = i + a.a.a.a.eN(6, this.tfH.aUd());
      }
      i = paramInt;
      if (this.tit != null) {
        i = paramInt + a.a.a.a.eN(7, this.tit.aUd());
      }
      paramInt = i;
      if (this.tfG != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tfG);
      }
      i = paramInt;
      if (this.tfB != null) {
        i = paramInt + a.a.a.a.eN(9, this.tfB.aUd());
      }
      GMTrace.o(13337215631360L, 99370);
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
      if (this.tGC == null) {
        throw new b("Not all required fields were included: ImgSid");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      GMTrace.o(13337215631360L, 99370);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      biw localbiw = (biw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13337215631360L, 99370);
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
          localbiw.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337215631360L, 99370);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbiw.tGC = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337215631360L, 99370);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbiw.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337215631360L, 99370);
        return 0;
      case 4: 
        localbiw.tsG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13337215631360L, 99370);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbiw.tis = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337215631360L, 99370);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbiw.tfH = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337215631360L, 99370);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbiw.tit = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337215631360L, 99370);
        return 0;
      case 8: 
        localbiw.tfG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13337215631360L, 99370);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localbiw.tfB = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13337215631360L, 99370);
      return 0;
    }
    GMTrace.o(13337215631360L, 99370);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/biw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */