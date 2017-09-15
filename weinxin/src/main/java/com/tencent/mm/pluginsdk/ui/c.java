package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.x.d.a;

public final class c
  extends j
  implements d.a
{
  a sGD;
  int sGE;
  
  public c(String paramString)
  {
    this(paramString, (byte)0);
    GMTrace.i(933350080512L, 6954);
    GMTrace.o(933350080512L, 6954);
  }
  
  private c(String paramString, byte paramByte)
  {
    super(new a(a.b.bDS()), paramString, false);
    GMTrace.i(933484298240L, 6955);
    this.sGD = ((a)this.ouZ);
    GMTrace.o(933484298240L, 6955);
  }
  
  private static final class a
    implements j.a
  {
    public Bitmap kat;
    private j.a ouZ;
    
    public a(j.a parama)
    {
      GMTrace.i(1223931461632L, 9119);
      this.kat = null;
      this.ouZ = parama;
      GMTrace.o(1223931461632L, 9119);
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1224065679360L, 9120);
      if (this.ouZ != null)
      {
        paramString = this.ouZ.a(paramString, paramInt1, paramInt2, paramInt3);
        GMTrace.o(1224065679360L, 9120);
        return paramString;
      }
      GMTrace.o(1224065679360L, 9120);
      return null;
    }
    
    public final void a(j paramj)
    {
      GMTrace.i(1224602550272L, 9124);
      if (this.ouZ != null) {
        this.ouZ.a(paramj);
      }
      GMTrace.o(1224602550272L, 9124);
    }
    
    public final Bitmap bf(String paramString)
    {
      GMTrace.i(1224199897088L, 9121);
      if (this.ouZ != null)
      {
        paramString = this.ouZ.bf(paramString);
        GMTrace.o(1224199897088L, 9121);
        return paramString;
      }
      GMTrace.o(1224199897088L, 9121);
      return null;
    }
    
    public final Bitmap bg(String paramString)
    {
      GMTrace.i(1224334114816L, 9122);
      if (this.ouZ != null)
      {
        paramString = this.ouZ.bg(paramString);
        GMTrace.o(1224334114816L, 9122);
        return paramString;
      }
      GMTrace.o(1224334114816L, 9122);
      return null;
    }
    
    public final Bitmap nZ()
    {
      GMTrace.i(1224468332544L, 9123);
      Bitmap localBitmap;
      if ((this.kat != null) && (!this.kat.isRecycled()))
      {
        localBitmap = this.kat;
        GMTrace.o(1224468332544L, 9123);
        return localBitmap;
      }
      if (this.ouZ != null)
      {
        localBitmap = this.ouZ.nZ();
        GMTrace.o(1224468332544L, 9123);
        return localBitmap;
      }
      GMTrace.o(1224468332544L, 9123);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */