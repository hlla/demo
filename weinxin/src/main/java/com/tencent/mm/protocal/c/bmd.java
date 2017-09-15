package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bmd
  extends com.tencent.mm.bd.a
{
  public String tip;
  public String tiq;
  public avt tit;
  public String uke;
  
  public bmd()
  {
    GMTrace.i(13584042033152L, 101209);
    GMTrace.o(13584042033152L, 101209);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13584176250880L, 101210);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tit == null) {
        throw new b("Not all required fields were included: KSid");
      }
      if (this.tip != null) {
        paramVarArgs.e(1, this.tip);
      }
      if (this.tiq != null) {
        paramVarArgs.e(2, this.tiq);
      }
      if (this.uke != null) {
        paramVarArgs.e(3, this.uke);
      }
      if (this.tit != null)
      {
        paramVarArgs.eQ(4, this.tit.aUd());
        this.tit.a(paramVarArgs);
      }
      GMTrace.o(13584176250880L, 101210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tip != null) {
        i = a.a.a.b.b.a.f(1, this.tip) + 0;
      }
      paramInt = i;
      if (this.tiq != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tiq);
      }
      i = paramInt;
      if (this.uke != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.uke);
      }
      paramInt = i;
      if (this.tit != null) {
        paramInt = i + a.a.a.a.eN(4, this.tit.aUd());
      }
      GMTrace.o(13584176250880L, 101210);
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
      if (this.tit == null) {
        throw new b("Not all required fields were included: KSid");
      }
      GMTrace.o(13584176250880L, 101210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bmd localbmd = (bmd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13584176250880L, 101210);
        return -1;
      case 1: 
        localbmd.tip = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584176250880L, 101210);
        return 0;
      case 2: 
        localbmd.tiq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584176250880L, 101210);
        return 0;
      case 3: 
        localbmd.uke = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584176250880L, 101210);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbmd.tit = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13584176250880L, 101210);
      return 0;
    }
    GMTrace.o(13584176250880L, 101210);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */