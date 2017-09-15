package com.tencent.mm.ui.chatting.gallery;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import java.util.HashSet;

public final class k
  implements c.a
{
  private static k vRF;
  HashSet<Long> vRG;
  c.a vRH;
  
  private k()
  {
    GMTrace.i(2436051763200L, 18150);
    this.vRG = new HashSet();
    GMTrace.o(2436051763200L, 18150);
  }
  
  public static k bXo()
  {
    GMTrace.i(2436185980928L, 18151);
    if (vRF == null) {
      vRF = new k();
    }
    k localk = vRF;
    GMTrace.o(2436185980928L, 18151);
    return localk;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    GMTrace.i(2436722851840L, 18155);
    if (this.vRH != null) {
      this.vRH.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.vRG.remove(Long.valueOf(paramLong2));
    GMTrace.o(2436722851840L, 18155);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2436454416384L, 18153);
    if (this.vRH != null) {
      this.vRH.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramk);
    }
    GMTrace.o(2436454416384L, 18153);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2436588634112L, 18154);
    if (this.vRH != null) {
      this.vRH.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramk);
    }
    for (;;)
    {
      this.vRG.remove(Long.valueOf(paramLong2));
      GMTrace.o(2436588634112L, 18154);
      return;
      ap.yY();
      paramObject = com.tencent.mm.u.c.wT().cA(paramLong2);
      v.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(((ce)paramObject).field_msgId) });
      b.b(aa.getContext(), (au)paramObject, false);
    }
  }
  
  public final boolean eU(long paramLong)
  {
    GMTrace.i(2436320198656L, 18152);
    boolean bool = this.vRG.contains(Long.valueOf(paramLong));
    GMTrace.o(2436320198656L, 18152);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */