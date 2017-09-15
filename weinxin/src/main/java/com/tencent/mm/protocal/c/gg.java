package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class gg
  extends avm
{
  public int jLP;
  public int tbY;
  public int tcb;
  public avt tdB;
  public avt tfB;
  public avt tfH;
  public avx tik;
  public String tip;
  public avu tis;
  public avt tit;
  public int tiv;
  public String tiw;
  public String tix;
  
  public gg()
  {
    GMTrace.i(3763062439936L, 28037);
    GMTrace.o(3763062439936L, 28037);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3763196657664L, 28038);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tip != null) {
        paramVarArgs.e(2, this.tip);
      }
      if (this.tdB != null)
      {
        paramVarArgs.eQ(3, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tcb);
      paramVarArgs.eO(5, this.tiv);
      if (this.tiw != null) {
        paramVarArgs.e(6, this.tiw);
      }
      paramVarArgs.eO(7, this.jLP);
      if (this.tix != null) {
        paramVarArgs.e(8, this.tix);
      }
      if (this.tis != null)
      {
        paramVarArgs.eQ(9, this.tis.aUd());
        this.tis.a(paramVarArgs);
      }
      if (this.tfH != null)
      {
        paramVarArgs.eQ(10, this.tfH.aUd());
        this.tfH.a(paramVarArgs);
      }
      if (this.tit != null)
      {
        paramVarArgs.eQ(11, this.tit.aUd());
        this.tit.a(paramVarArgs);
      }
      if (this.tik != null)
      {
        paramVarArgs.eQ(12, this.tik.aUd());
        this.tik.a(paramVarArgs);
      }
      paramVarArgs.eO(13, this.tbY);
      if (this.tfB != null)
      {
        paramVarArgs.eQ(14, this.tfB.aUd());
        this.tfB.a(paramVarArgs);
      }
      GMTrace.o(3763196657664L, 28038);
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
      if (this.tip != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tip);
      }
      i = paramInt;
      if (this.tdB != null) {
        i = paramInt + a.a.a.a.eN(3, this.tdB.aUd());
      }
      i = i + a.a.a.a.eL(4, this.tcb) + a.a.a.a.eL(5, this.tiv);
      paramInt = i;
      if (this.tiw != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tiw);
      }
      i = paramInt + a.a.a.a.eL(7, this.jLP);
      paramInt = i;
      if (this.tix != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tix);
      }
      i = paramInt;
      if (this.tis != null) {
        i = paramInt + a.a.a.a.eN(9, this.tis.aUd());
      }
      paramInt = i;
      if (this.tfH != null) {
        paramInt = i + a.a.a.a.eN(10, this.tfH.aUd());
      }
      i = paramInt;
      if (this.tit != null) {
        i = paramInt + a.a.a.a.eN(11, this.tit.aUd());
      }
      paramInt = i;
      if (this.tik != null) {
        paramInt = i + a.a.a.a.eN(12, this.tik.aUd());
      }
      i = paramInt + a.a.a.a.eL(13, this.tbY);
      paramInt = i;
      if (this.tfB != null) {
        paramInt = i + a.a.a.a.eN(14, this.tfB.aUd());
      }
      GMTrace.o(3763196657664L, 28038);
      return paramInt;
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
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      GMTrace.o(3763196657664L, 28038);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      gg localgg = (gg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3763196657664L, 28038);
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
          localgg.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 2: 
        localgg.tip = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3763196657664L, 28038);
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
          localgg.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 4: 
        localgg.tcb = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 5: 
        localgg.tiv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 6: 
        localgg.tiw = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 7: 
        localgg.jLP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 8: 
        localgg.tix = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localgg.tis = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localgg.tfH = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 11: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localgg.tit = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localgg.tik = ((avx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3763196657664L, 28038);
        return 0;
      case 13: 
        localgg.tbY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3763196657664L, 28038);
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
        localgg.tfB = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3763196657664L, 28038);
      return 0;
    }
    GMTrace.o(3763196657664L, 28038);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */