package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ax
  extends ave
{
  public String bssid;
  public int cFR;
  public String hSS;
  public int hSV;
  public int scene;
  public String ssid;
  public String tcE;
  public long tcF;
  public bi tcG;
  public int tcH;
  public int tcI;
  public String tcJ;
  
  public ax()
  {
    GMTrace.i(3803461976064L, 28338);
    GMTrace.o(3803461976064L, 28338);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3803596193792L, 28339);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.hSS != null) {
        paramVarArgs.e(2, this.hSS);
      }
      paramVarArgs.eO(3, this.hSV);
      if (this.tcE != null) {
        paramVarArgs.e(4, this.tcE);
      }
      paramVarArgs.eO(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.e(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(7, this.bssid);
      }
      paramVarArgs.O(8, this.tcF);
      if (this.tcG != null)
      {
        paramVarArgs.eQ(9, this.tcG.aUd());
        this.tcG.a(paramVarArgs);
      }
      paramVarArgs.eO(10, this.tcH);
      paramVarArgs.eO(11, this.tcI);
      paramVarArgs.eO(12, this.cFR);
      if (this.tcJ != null) {
        paramVarArgs.e(13, this.tcJ);
      }
      GMTrace.o(3803596193792L, 28339);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.hSS != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.hSS);
      }
      i += a.a.a.a.eL(3, this.hSV);
      paramInt = i;
      if (this.tcE != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tcE);
      }
      i = paramInt + a.a.a.a.eL(5, this.scene);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.bssid);
      }
      i += a.a.a.a.N(8, this.tcF);
      paramInt = i;
      if (this.tcG != null) {
        paramInt = i + a.a.a.a.eN(9, this.tcG.aUd());
      }
      i = paramInt + a.a.a.a.eL(10, this.tcH) + a.a.a.a.eL(11, this.tcI) + a.a.a.a.eL(12, this.cFR);
      paramInt = i;
      if (this.tcJ != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.tcJ);
      }
      GMTrace.o(3803596193792L, 28339);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3803596193792L, 28339);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ax localax = (ax)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3803596193792L, 28339);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localax.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 2: 
        localax.hSS = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 3: 
        localax.hSV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 4: 
        localax.tcE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 5: 
        localax.scene = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 6: 
        localax.ssid = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 7: 
        localax.bssid = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 8: 
        localax.tcF = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bi();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bi)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localax.tcG = ((bi)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 10: 
        localax.tcH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 11: 
        localax.tcI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      case 12: 
        localax.cFR = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3803596193792L, 28339);
        return 0;
      }
      localax.tcJ = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3803596193792L, 28339);
      return 0;
    }
    GMTrace.o(3803596193792L, 28339);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */