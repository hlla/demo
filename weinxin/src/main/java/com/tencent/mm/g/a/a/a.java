package com.tencent.mm.g.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bd.a
{
  public int fPt;
  public int fRM;
  public LinkedList<b> gMJ;
  public int gMK;
  public String gML;
  public int gMM;
  public int status;
  public int type;
  
  public a()
  {
    GMTrace.i(1592895995904L, 11868);
    this.gMJ = new LinkedList();
    GMTrace.o(1592895995904L, 11868);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(1593030213632L, 11869);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.gMJ);
      paramVarArgs.eO(2, this.fRM);
      paramVarArgs.eO(3, this.type);
      paramVarArgs.eO(4, this.status);
      paramVarArgs.eO(5, this.gMK);
      if (this.gML != null) {
        paramVarArgs.e(6, this.gML);
      }
      paramVarArgs.eO(7, this.fPt);
      paramVarArgs.eO(8, this.gMM);
      GMTrace.o(1593030213632L, 11869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.c(1, 8, this.gMJ) + 0 + a.a.a.a.eL(2, this.fRM) + a.a.a.a.eL(3, this.type) + a.a.a.a.eL(4, this.status) + a.a.a.a.eL(5, this.gMK);
      paramInt = i;
      if (this.gML != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.gML);
      }
      i = a.a.a.a.eL(7, this.fPt);
      int j = a.a.a.a.eL(8, this.gMM);
      GMTrace.o(1593030213632L, 11869);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.gMJ.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(1593030213632L, 11869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(1593030213632L, 11869);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          locala.gMJ.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(1593030213632L, 11869);
        return 0;
      case 2: 
        locala.fRM = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(1593030213632L, 11869);
        return 0;
      case 3: 
        locala.type = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(1593030213632L, 11869);
        return 0;
      case 4: 
        locala.status = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(1593030213632L, 11869);
        return 0;
      case 5: 
        locala.gMK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(1593030213632L, 11869);
        return 0;
      case 6: 
        locala.gML = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(1593030213632L, 11869);
        return 0;
      case 7: 
        locala.fPt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(1593030213632L, 11869);
        return 0;
      }
      locala.gMM = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(1593030213632L, 11869);
      return 0;
    }
    GMTrace.o(1593030213632L, 11869);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/g/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */