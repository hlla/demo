package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aq
  extends com.tencent.mm.bd.a
{
  public String mrA;
  public String tcd;
  public String tce;
  public String tcf;
  
  public aq()
  {
    GMTrace.i(3798361702400L, 28300);
    GMTrace.o(3798361702400L, 28300);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3798495920128L, 28301);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mrA != null) {
        paramVarArgs.e(1, this.mrA);
      }
      if (this.tcd != null) {
        paramVarArgs.e(2, this.tcd);
      }
      if (this.tce != null) {
        paramVarArgs.e(3, this.tce);
      }
      if (this.tcf != null) {
        paramVarArgs.e(4, this.tcf);
      }
      GMTrace.o(3798495920128L, 28301);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mrA == null) {
        break label434;
      }
    }
    label434:
    for (int i = a.a.a.b.b.a.f(1, this.mrA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tcd != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tcd);
      }
      i = paramInt;
      if (this.tce != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tce);
      }
      paramInt = i;
      if (this.tcf != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tcf);
      }
      GMTrace.o(3798495920128L, 28301);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3798495920128L, 28301);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3798495920128L, 28301);
          return -1;
        case 1: 
          localaq.mrA = locala.xky.readString();
          GMTrace.o(3798495920128L, 28301);
          return 0;
        case 2: 
          localaq.tcd = locala.xky.readString();
          GMTrace.o(3798495920128L, 28301);
          return 0;
        case 3: 
          localaq.tce = locala.xky.readString();
          GMTrace.o(3798495920128L, 28301);
          return 0;
        }
        localaq.tcf = locala.xky.readString();
        GMTrace.o(3798495920128L, 28301);
        return 0;
      }
      GMTrace.o(3798495920128L, 28301);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */