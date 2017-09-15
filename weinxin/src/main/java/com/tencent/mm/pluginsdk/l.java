package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
public abstract interface l
{
  public static final class a
  {
    public static l.n szL;
    public static l.o szM;
    public static l.f szN;
    public static l.j szO;
    public static l.c szP;
    public static l.k szQ;
    public static l.q szR;
    public static l.s szS;
    public static l.h szT;
    public static l.w szU;
    public static l.i szV;
    public static l.d szW;
    public static l.b szX;
    
    public static l.j bCf()
    {
      GMTrace.i(1234266226688L, 9196);
      if (szO == null)
      {
        v.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
        szO = new c();
      }
      l.j localj = szO;
      GMTrace.o(1234266226688L, 9196);
      return localj;
    }
    
    public static l.k bCg()
    {
      GMTrace.i(1234534662144L, 9198);
      l.k localk = szQ;
      GMTrace.o(1234534662144L, 9198);
      return localk;
    }
  }
  
  public static final class aa
  {
    public static l.l sAa;
  }
  
  public static final class ab
  {
    public static l.x.a sAb;
  }
  
  public static abstract interface b
  {
    public abstract String jd(String paramString);
    
    public abstract String je(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract boolean afD();
    
    public abstract boolean afE();
    
    public abstract String afF();
    
    public abstract int afG();
    
    public abstract boolean kk(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract int a(com.tencent.mm.pluginsdk.wallet.b paramb, int paramInt, boolean paramBoolean);
    
    public abstract void a(ko paramko, int paramInt);
    
    public abstract void a(ko paramko, int paramInt, String paramString);
    
    public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);
    
    public abstract boolean auL();
    
    public abstract boolean auM();
    
    public abstract boolean auN();
    
    public abstract void auP();
    
    public abstract g auR();
    
    public abstract boolean auS();
    
    public abstract boolean auT();
    
    public abstract void auU();
    
    public abstract boolean auV();
    
    public abstract boolean auW();
    
    public abstract void auX();
    
    public abstract void auY();
    
    public abstract void auZ();
    
    public abstract Map<String, String> ava();
    
    public abstract h avb();
    
    public abstract Map<String, String> avc();
    
    public abstract boolean avd();
    
    public abstract void bY(Context paramContext);
    
    public abstract void bZ(Context paramContext);
    
    public abstract void ei(boolean paramBoolean);
    
    public abstract int type();
  }
  
  public static abstract interface e
  {
    public abstract boolean axw();
    
    public abstract String bmA();
    
    public abstract boolean bmB();
    
    public abstract String bmC();
    
    public abstract String bmD();
    
    public abstract boolean bmx();
    
    public abstract String bmz();
  }
  
  public static abstract interface f
  {
    public abstract void a(Context paramContext, boolean paramBoolean);
    
    public abstract void ai(Context paramContext);
    
    public abstract boolean oK();
  }
  
  public static abstract interface g
  {
    public abstract void LH(String paramString);
  }
  
  public static abstract interface h
  {
    public abstract void AW(String paramString);
    
    public abstract boolean AX(String paramString);
    
    public abstract boolean AY(String paramString);
    
    public abstract List<String> AZ(String paramString);
    
    public abstract boolean Ba(String paramString);
    
    public abstract boolean Bb(String paramString);
    
    public abstract void Bc(String paramString);
    
    public abstract boolean Bd(String paramString);
    
    public abstract boolean Be(String paramString);
    
    public abstract void Bf(String paramString);
    
    public abstract com.tencent.mm.al.b Bj(String paramString);
    
    public abstract void a(l.g paramg);
    
    public abstract boolean aJ(Context paramContext);
    
    public abstract boolean aMF();
    
    public abstract boolean aMH();
    
    public abstract boolean aMT();
    
    public abstract boolean aMU();
    
    public abstract void b(l.g paramg);
    
    public abstract boolean cS(String paramString1, String paramString2);
    
    public abstract String cT(String paramString1, String paramString2);
    
    public abstract int cU(String paramString1, String paramString2);
    
    public abstract String eK(String paramString);
    
    public abstract boolean gR(String paramString);
  }
  
  public static abstract interface i
  {
    public abstract boolean a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener);
    
    public abstract boolean bu(String paramString);
    
    public abstract String p(Context paramContext, String paramString);
  }
  
  public static abstract interface j
  {
    public abstract String Ec(String paramString);
    
    public abstract int baE();
    
    public abstract void baF();
    
    public abstract boolean baG();
    
    public abstract void baH();
    
    public abstract void baI();
    
    public abstract boolean baJ();
  }
  
  public static abstract interface k
  {
    public abstract void B(String paramString, int paramInt1, int paramInt2);
    
    public abstract void I(String paramString1, String paramString2, String paramString3);
    
    public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, long paramLong, String paramString5);
    
    public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
    
    public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3);
    
    public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong);
    
    public abstract boolean aBB();
    
    public abstract void cl(Context paramContext);
    
    public abstract void m(Context paramContext, String paramString1, String paramString2);
  }
  
  public static abstract interface l
  {
    public abstract boolean bmF();
    
    public abstract boolean bmG();
    
    public abstract void bmH();
    
    public abstract void bmI();
    
    public abstract void bmL();
    
    public abstract String bmN();
    
    public abstract l.e bmO();
  }
  
  public static abstract interface m
  {
    public abstract void B(String paramString1, String paramString2, String paramString3);
  }
  
  public static abstract interface n
  {
    public abstract boolean Hp(String paramString);
    
    public abstract LinkedList<beq> Hq(String paramString);
    
    public abstract void a(l.m paramm);
    
    public abstract void a(String paramString1, LinkedList<beq> paramLinkedList, String paramString2, String paramString3, int paramInt);
    
    public abstract void b(l.m paramm);
    
    public abstract boolean bnA();
  }
  
  public static abstract interface o
  {
    public abstract void a(l.p paramp);
    
    public abstract void b(l.p paramp);
    
    public abstract void bR(String paramString, int paramInt);
    
    public abstract boolean bnG();
    
    public abstract void bnH();
    
    public abstract short bnM();
    
    public abstract short bnN();
    
    public abstract boolean bnO();
    
    public abstract void bnp();
  }
  
  public static abstract interface p
  {
    public abstract void C(String paramString, int paramInt1, int paramInt2);
    
    public abstract void aGH();
    
    public abstract void aGI();
    
    public abstract void aGJ();
    
    public abstract void aGK();
    
    public abstract void aGL();
    
    public abstract void aGM();
    
    public abstract void cI(String paramString1, String paramString2);
    
    public abstract void k(int paramInt1, int paramInt2, String paramString);
    
    public abstract void oA(int paramInt);
    
    public abstract void zA(String paramString);
  }
  
  public static abstract interface q
  {
    public abstract String aGe();
  }
  
  public static abstract interface r
  {
    public abstract void LI(String paramString);
  }
  
  public static abstract interface s
  {
    public abstract void a(l.r paramr);
    
    public abstract void a(String paramString1, LinkedList<String> paramLinkedList, double paramDouble1, double paramDouble2, String paramString2, String paramString3, String paramString4);
    
    public abstract boolean aGn();
    
    public abstract String aGo();
    
    public abstract void b(l.r paramr);
    
    public abstract boolean cH(String paramString1, String paramString2);
    
    public abstract LinkedList<String> zo(String paramString);
    
    public abstract boolean zq(String paramString);
  }
  
  public static abstract interface t
  {
    public abstract void update(int paramInt);
  }
  
  public static abstract interface u
  {
    public abstract int bCh();
    
    public abstract String[] bCi();
    
    public abstract abx bCj();
  }
  
  public static abstract interface v
  {
    public abstract String DC(String paramString);
    
    public abstract l.t a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void aXM();
    
    public abstract l.u aXN();
    
    public abstract l.t b(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract l.t cL(Context paramContext);
    
    public abstract void cM(Context paramContext);
    
    public abstract void d(String paramString1, int paramInt, String paramString2, String paramString3);
    
    public abstract void gF(boolean paramBoolean);
    
    public abstract void l(Context paramContext, Intent paramIntent);
    
    public abstract void m(Context paramContext, Intent paramIntent);
  }
  
  public static abstract interface w
  {
    public abstract boolean a(Context paramContext, String paramString, boolean paramBoolean);
    
    public abstract boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle);
    
    public abstract boolean a(Context paramContext, String paramString, boolean paramBoolean, o paramo);
    
    public abstract boolean b(Context paramContext, String paramString, boolean paramBoolean, o paramo);
    
    public abstract boolean b(Context paramContext, String paramString, Object... paramVarArgs);
  }
  
  public static abstract interface x
  {
    public static abstract interface a
    {
      public abstract void bvA();
      
      public abstract boolean bvB();
      
      public abstract String bvz();
    }
  }
  
  public static final class y
  {
    private static l.v szY;
    public static boolean szZ;
    
    static
    {
      GMTrace.i(707461644288L, 5271);
      szZ = false;
      GMTrace.o(707461644288L, 5271);
    }
    
    public static void a(l.v paramv)
    {
      GMTrace.i(707193208832L, 5269);
      szY = paramv;
      GMTrace.o(707193208832L, 5269);
    }
    
    public static l.v bCk()
    {
      GMTrace.i(707327426560L, 5270);
      l.v localv = szY;
      GMTrace.o(707327426560L, 5270);
      return localv;
    }
  }
  
  public static final class z
  {
    public static f bCl()
    {
      GMTrace.i(17950010507264L, 133738);
      f localf = m.pPe;
      GMTrace.o(17950010507264L, 133738);
      return localf;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */