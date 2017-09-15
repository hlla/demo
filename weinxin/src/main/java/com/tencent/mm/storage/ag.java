package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bd.a
{
  public int uHr;
  public LinkedList<Integer> uHs;
  public LinkedList<Integer> uHt;
  public LinkedList<Integer> uHu;
  public LinkedList<Long> uHv;
  public LinkedList<Long> uHw;
  public LinkedList<Long> uHx;
  
  public ag()
  {
    GMTrace.i(13324464947200L, 99275);
    this.uHs = new LinkedList();
    this.uHt = new LinkedList();
    this.uHu = new LinkedList();
    this.uHv = new LinkedList();
    this.uHw = new LinkedList();
    this.uHx = new LinkedList();
    GMTrace.o(13324464947200L, 99275);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13324599164928L, 99276);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uHr);
      paramVarArgs.d(2, 2, this.uHs);
      paramVarArgs.d(3, 2, this.uHt);
      paramVarArgs.d(4, 2, this.uHu);
      paramVarArgs.d(5, 3, this.uHv);
      paramVarArgs.d(6, 3, this.uHw);
      paramVarArgs.d(7, 3, this.uHx);
      GMTrace.o(13324599164928L, 99276);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.uHr);
      int i = a.a.a.a.c(2, 2, this.uHs);
      int j = a.a.a.a.c(3, 2, this.uHt);
      int k = a.a.a.a.c(4, 2, this.uHu);
      int m = a.a.a.a.c(5, 3, this.uHv);
      int n = a.a.a.a.c(6, 3, this.uHw);
      int i1 = a.a.a.a.c(7, 3, this.uHx);
      GMTrace.o(13324599164928L, 99276);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uHs.clear();
      this.uHt.clear();
      this.uHu.clear();
      this.uHv.clear();
      this.uHw.clear();
      this.uHx.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13324599164928L, 99276);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13324599164928L, 99276);
        return -1;
      case 1: 
        localag.uHr = locala.xky.mL();
        GMTrace.o(13324599164928L, 99276);
        return 0;
      case 2: 
        localag.uHs.add(Integer.valueOf(locala.xky.mL()));
        GMTrace.o(13324599164928L, 99276);
        return 0;
      case 3: 
        localag.uHt.add(Integer.valueOf(locala.xky.mL()));
        GMTrace.o(13324599164928L, 99276);
        return 0;
      case 4: 
        localag.uHu.add(Integer.valueOf(locala.xky.mL()));
        GMTrace.o(13324599164928L, 99276);
        return 0;
      case 5: 
        localag.uHv.add(Long.valueOf(locala.xky.mM()));
        GMTrace.o(13324599164928L, 99276);
        return 0;
      case 6: 
        localag.uHw.add(Long.valueOf(locala.xky.mM()));
        GMTrace.o(13324599164928L, 99276);
        return 0;
      }
      localag.uHx.add(Long.valueOf(locala.xky.mM()));
      GMTrace.o(13324599164928L, 99276);
      return 0;
    }
    GMTrace.o(13324599164928L, 99276);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */