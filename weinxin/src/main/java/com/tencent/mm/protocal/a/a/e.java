package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bd.a
{
  public int nettype;
  public int sYH;
  public LinkedList<d> sYI;
  public String sYR;
  public String sYS;
  public String sYT;
  public String sYU;
  public String sYV;
  public int sYW;
  public int uin;
  
  public e()
  {
    GMTrace.i(13101931954176L, 97617);
    this.sYI = new LinkedList();
    GMTrace.o(13101931954176L, 97617);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13102066171904L, 97618);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uin);
      paramVarArgs.eO(2, this.sYH);
      paramVarArgs.eO(3, this.nettype);
      paramVarArgs.d(4, 8, this.sYI);
      if (this.sYR != null) {
        paramVarArgs.e(5, this.sYR);
      }
      if (this.sYS != null) {
        paramVarArgs.e(6, this.sYS);
      }
      if (this.sYT != null) {
        paramVarArgs.e(7, this.sYT);
      }
      if (this.sYU != null) {
        paramVarArgs.e(8, this.sYU);
      }
      if (this.sYV != null) {
        paramVarArgs.e(9, this.sYV);
      }
      paramVarArgs.eO(10, this.sYW);
      GMTrace.o(13102066171904L, 97618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.uin) + 0 + a.a.a.a.eL(2, this.sYH) + a.a.a.a.eL(3, this.nettype) + a.a.a.a.c(4, 8, this.sYI);
      paramInt = i;
      if (this.sYR != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.sYR);
      }
      i = paramInt;
      if (this.sYS != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.sYS);
      }
      paramInt = i;
      if (this.sYT != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.sYT);
      }
      i = paramInt;
      if (this.sYU != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.sYU);
      }
      paramInt = i;
      if (this.sYV != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.sYV);
      }
      i = a.a.a.a.eL(10, this.sYW);
      GMTrace.o(13102066171904L, 97618);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sYI.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13102066171904L, 97618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13102066171904L, 97618);
        return -1;
      case 1: 
        locale.uin = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 2: 
        locale.sYH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 3: 
        locale.nettype = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          locale.sYI.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 5: 
        locale.sYR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 6: 
        locale.sYS = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 7: 
        locale.sYT = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 8: 
        locale.sYU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      case 9: 
        locale.sYV = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13102066171904L, 97618);
        return 0;
      }
      locale.sYW = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13102066171904L, 97618);
      return 0;
    }
    GMTrace.o(13102066171904L, 97618);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */