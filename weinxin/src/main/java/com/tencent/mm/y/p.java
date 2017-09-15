package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class p
  implements e
{
  public final f hsZ;
  private o hta;
  
  public p(f paramf)
  {
    GMTrace.i(13392513335296L, 99782);
    this.hsZ = paramf;
    GMTrace.o(13392513335296L, 99782);
  }
  
  public final boolean BS()
  {
    GMTrace.i(13393855512576L, 99792);
    try
    {
      boolean bool = this.hsZ.BS();
      GMTrace.o(13393855512576L, 99792);
      return bool;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", new Object[] { localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13393855512576L, 99792);
    }
    return true;
  }
  
  public final c Cc()
  {
    GMTrace.i(13393452859392L, 99789);
    try
    {
      if (this.hta == null) {
        this.hta = new o(this.hsZ.Mq());
      }
      o localo = this.hta;
      GMTrace.o(13393452859392L, 99789);
      return localo;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[] { localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13393452859392L, 99789);
    }
    return null;
  }
  
  public final h Cd()
  {
    GMTrace.i(13393989730304L, 99793);
    try
    {
      h localh = this.hsZ.Ms();
      GMTrace.o(13393989730304L, 99793);
      return localh;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13393989730304L, 99793);
    }
    return null;
  }
  
  public final void Ce()
  {
    GMTrace.i(13396271431680L, 99810);
    try
    {
      this.hsZ.Ce();
      GMTrace.o(13396271431680L, 99810);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13396271431680L, 99810);
    }
  }
  
  public final int a(q paramq, k paramk)
  {
    GMTrace.i(13392647553024L, 99783);
    try
    {
      int i = this.hsZ.a(paramq, paramk);
      GMTrace.o(13392647553024L, 99783);
      return i;
    }
    catch (Exception paramq)
    {
      v.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[] { paramq });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramq) });
      GMTrace.o(13392647553024L, 99783);
    }
    return -1;
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    GMTrace.i(13394526601216L, 99797);
    try
    {
      int i = this.hsZ.a(paramString, paramBoolean, paramList);
      GMTrace.o(13394526601216L, 99797);
      return i;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13394526601216L, 99797);
    }
    return -1;
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(13394795036672L, 99799);
    try
    {
      this.hsZ.a(paramInt1, paramString, paramInt2, paramBoolean);
      GMTrace.o(13394795036672L, 99799);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13394795036672L, 99799);
    }
  }
  
  public final void a(b paramb)
  {
    GMTrace.i(13393587077120L, 99790);
    try
    {
      this.hsZ.a(paramb);
      GMTrace.o(13393587077120L, 99790);
      return;
    }
    catch (Exception paramb)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramb) });
      GMTrace.o(13393587077120L, 99790);
    }
  }
  
  public final void a(n paramn)
  {
    GMTrace.i(13395466125312L, 99804);
    try
    {
      this.hsZ.a(paramn);
      GMTrace.o(13395466125312L, 99804);
      return;
    }
    catch (Exception paramn)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramn) });
      GMTrace.o(13395466125312L, 99804);
    }
  }
  
  public final void a(ab paramab)
  {
    GMTrace.i(13394123948032L, 99794);
    try
    {
      this.hsZ.a(paramab);
      GMTrace.o(13394123948032L, 99794);
      return;
    }
    catch (Exception paramab)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramab) });
      GMTrace.o(13394123948032L, 99794);
    }
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    GMTrace.i(13393318641664L, 99788);
    try
    {
      this.hsZ.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
      GMTrace.o(13393318641664L, 99788);
      return;
    }
    catch (Exception paramString1)
    {
      v.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[] { paramString1 });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString1) });
      GMTrace.o(13393318641664L, 99788);
    }
  }
  
  public final void aZ(boolean paramBoolean)
  {
    GMTrace.i(13393721294848L, 99791);
    try
    {
      this.hsZ.aZ(paramBoolean);
      GMTrace.o(13393721294848L, 99791);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[] { localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13393721294848L, 99791);
    }
  }
  
  public final void ba(boolean paramBoolean)
  {
    GMTrace.i(13395868778496L, 99807);
    try
    {
      this.hsZ.ba(paramBoolean);
      GMTrace.o(13395868778496L, 99807);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13395868778496L, 99807);
    }
  }
  
  public final void bb(boolean paramBoolean)
  {
    GMTrace.i(13396002996224L, 99808);
    try
    {
      this.hsZ.bb(paramBoolean);
      GMTrace.o(13396002996224L, 99808);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13396002996224L, 99808);
    }
  }
  
  public final void bc(boolean paramBoolean)
  {
    GMTrace.i(13396137213952L, 99809);
    try
    {
      this.hsZ.bc(paramBoolean);
      GMTrace.o(13396137213952L, 99809);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13396137213952L, 99809);
    }
  }
  
  public final void cancel(int paramInt)
  {
    GMTrace.i(13393050206208L, 99786);
    try
    {
      this.hsZ.cancel(paramInt);
      GMTrace.o(13393050206208L, 99786);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[] { Integer.valueOf(paramInt), localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13393050206208L, 99786);
    }
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    GMTrace.i(13394392383488L, 99796);
    try
    {
      int i = this.hsZ.getHostByName(paramString, paramList);
      GMTrace.o(13394392383488L, 99796);
      return i;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13394392383488L, 99796);
    }
    return -1;
  }
  
  public final String[] getIPsString(boolean paramBoolean)
  {
    GMTrace.i(13392915988480L, 99785);
    try
    {
      String[] arrayOfString = this.hsZ.getIPsString(paramBoolean);
      GMTrace.o(13392915988480L, 99785);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13392915988480L, 99785);
    }
    return null;
  }
  
  public final String getIspId()
  {
    GMTrace.i(13394929254400L, 99800);
    try
    {
      String str = this.hsZ.getIspId();
      GMTrace.o(13394929254400L, 99800);
      return str;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13394929254400L, 99800);
    }
    return null;
  }
  
  public final String getNetworkServerIp()
  {
    GMTrace.i(13392781770752L, 99784);
    try
    {
      String str = this.hsZ.getNetworkServerIp();
      GMTrace.o(13392781770752L, 99784);
      return str;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13392781770752L, 99784);
    }
    return null;
  }
  
  public final void hv(String paramString)
  {
    GMTrace.i(13394258165760L, 99795);
    try
    {
      this.hsZ.hv(paramString);
      GMTrace.o(13394258165760L, 99795);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[] { paramString });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13394258165760L, 99795);
    }
  }
  
  public final void hw(String paramString)
  {
    GMTrace.i(13395734560768L, 99806);
    try
    {
      this.hsZ.hw(paramString);
      GMTrace.o(13395734560768L, 99806);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13395734560768L, 99806);
    }
  }
  
  public final void keepSignalling()
  {
    GMTrace.i(13395197689856L, 99802);
    try
    {
      this.hsZ.keepSignalling();
      GMTrace.o(13395197689856L, 99802);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13395197689856L, 99802);
    }
  }
  
  public final void reportFailIp(String paramString)
  {
    GMTrace.i(13395600343040L, 99805);
    try
    {
      this.hsZ.reportFailIp(paramString);
      GMTrace.o(13395600343040L, 99805);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13395600343040L, 99805);
    }
  }
  
  public final void reset()
  {
    GMTrace.i(13393184423936L, 99787);
    try
    {
      this.hsZ.reset();
      GMTrace.o(13393184423936L, 99787);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[] { localException });
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13393184423936L, 99787);
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    GMTrace.i(13394660818944L, 99798);
    try
    {
      this.hsZ.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      GMTrace.o(13394660818944L, 99798);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(paramArrayOfString1) });
      GMTrace.o(13394660818944L, 99798);
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    GMTrace.i(13395063472128L, 99801);
    try
    {
      this.hsZ.setSignallingStrategy(paramLong1, paramLong2);
      GMTrace.o(13395063472128L, 99801);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13395063472128L, 99801);
    }
  }
  
  public final void stopSignalling()
  {
    GMTrace.i(13395331907584L, 99803);
    try
    {
      this.hsZ.stopSignalling();
      GMTrace.o(13395331907584L, 99803);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13395331907584L, 99803);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */