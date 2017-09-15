package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class bdb
  extends com.tencent.mm.bd.a
{
  public int hTa;
  public long hTb;
  public int hTc;
  public int hTd;
  public int hTe;
  public int opType;
  public String ucJ;
  public String ucK;
  public String ucL;
  public String ucM;
  
  public bdb()
  {
    GMTrace.i(3924794802176L, 29242);
    GMTrace.o(3924794802176L, 29242);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3924929019904L, 29243);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.ucJ == null) {
        throw new b("Not all required fields were included: StatusDesc1");
      }
      if (this.ucK == null) {
        throw new b("Not all required fields were included: StatusDesc2");
      }
      if (this.ucL == null) {
        throw new b("Not all required fields were included: DataFlowSourceInfo");
      }
      if (this.ucM == null) {
        throw new b("Not all required fields were included: DataFlowResultInfo");
      }
      paramVarArgs.eO(1, this.opType);
      paramVarArgs.eO(2, this.hTe);
      paramVarArgs.eO(3, this.hTa);
      paramVarArgs.O(4, this.hTb);
      paramVarArgs.eO(5, this.hTc);
      paramVarArgs.eO(6, this.hTd);
      if (this.ucJ != null) {
        paramVarArgs.e(7, this.ucJ);
      }
      if (this.ucK != null) {
        paramVarArgs.e(8, this.ucK);
      }
      if (this.ucL != null) {
        paramVarArgs.e(9, this.ucL);
      }
      if (this.ucM != null) {
        paramVarArgs.e(10, this.ucM);
      }
      GMTrace.o(3924929019904L, 29243);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.opType) + 0 + a.a.a.a.eL(2, this.hTe) + a.a.a.a.eL(3, this.hTa) + a.a.a.a.N(4, this.hTb) + a.a.a.a.eL(5, this.hTc) + a.a.a.a.eL(6, this.hTd);
      paramInt = i;
      if (this.ucJ != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.ucJ);
      }
      i = paramInt;
      if (this.ucK != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.ucK);
      }
      paramInt = i;
      if (this.ucL != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.ucL);
      }
      i = paramInt;
      if (this.ucM != null) {
        i = paramInt + a.a.a.b.b.a.f(10, this.ucM);
      }
      GMTrace.o(3924929019904L, 29243);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.ucJ == null) {
        throw new b("Not all required fields were included: StatusDesc1");
      }
      if (this.ucK == null) {
        throw new b("Not all required fields were included: StatusDesc2");
      }
      if (this.ucL == null) {
        throw new b("Not all required fields were included: DataFlowSourceInfo");
      }
      if (this.ucM == null) {
        throw new b("Not all required fields were included: DataFlowResultInfo");
      }
      GMTrace.o(3924929019904L, 29243);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bdb localbdb = (bdb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3924929019904L, 29243);
        return -1;
      case 1: 
        localbdb.opType = locala.xky.mL();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 2: 
        localbdb.hTe = locala.xky.mL();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 3: 
        localbdb.hTa = locala.xky.mL();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 4: 
        localbdb.hTb = locala.xky.mM();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 5: 
        localbdb.hTc = locala.xky.mL();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 6: 
        localbdb.hTd = locala.xky.mL();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 7: 
        localbdb.ucJ = locala.xky.readString();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 8: 
        localbdb.ucK = locala.xky.readString();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      case 9: 
        localbdb.ucL = locala.xky.readString();
        GMTrace.o(3924929019904L, 29243);
        return 0;
      }
      localbdb.ucM = locala.xky.readString();
      GMTrace.o(3924929019904L, 29243);
      return 0;
    }
    GMTrace.o(3924929019904L, 29243);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */