package com.tencent.mm.t;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class i
  extends com.tencent.mm.bd.a
{
  public String fUH;
  public String fUI;
  public String gxt;
  public LinkedList<l> hkc;
  public int hkd;
  public String name;
  public int type;
  
  public i()
  {
    GMTrace.i(312861523968L, 2331);
    this.hkc = new LinkedList();
    GMTrace.o(312861523968L, 2331);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(312995741696L, 2332);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.type);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.fUH != null) {
        paramVarArgs.e(3, this.fUH);
      }
      if (this.fUI != null) {
        paramVarArgs.e(4, this.fUI);
      }
      if (this.gxt != null) {
        paramVarArgs.e(5, this.gxt);
      }
      paramVarArgs.d(6, 8, this.hkc);
      paramVarArgs.eO(7, this.hkd);
      GMTrace.o(312995741696L, 2332);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.fUH != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fUH);
      }
      paramInt = i;
      if (this.fUI != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.fUI);
      }
      i = paramInt;
      if (this.gxt != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.gxt);
      }
      paramInt = a.a.a.a.c(6, 8, this.hkc);
      int j = a.a.a.a.eL(7, this.hkd);
      GMTrace.o(312995741696L, 2332);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hkc.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(312995741696L, 2332);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(312995741696L, 2332);
        return -1;
      case 1: 
        locali.type = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(312995741696L, 2332);
        return 0;
      case 2: 
        locali.name = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(312995741696L, 2332);
        return 0;
      case 3: 
        locali.fUH = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(312995741696L, 2332);
        return 0;
      case 4: 
        locali.fUI = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(312995741696L, 2332);
        return 0;
      case 5: 
        locali.gxt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(312995741696L, 2332);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          locali.hkc.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(312995741696L, 2332);
        return 0;
      }
      locali.hkd = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(312995741696L, 2332);
      return 0;
    }
    GMTrace.o(312995741696L, 2332);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */