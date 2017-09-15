package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;

public final class o
  extends e<Bitmap, b>
{
  public static o hgM;
  
  static
  {
    GMTrace.i(1275202633728L, 9501);
    hgM = new o();
    GMTrace.o(1275202633728L, 9501);
  }
  
  private o()
  {
    GMTrace.i(1273457803264L, 9488);
    GMTrace.o(1273457803264L, 9488);
  }
  
  private static Bitmap b(b paramb)
  {
    GMTrace.i(1273860456448L, 9491);
    paramb = Bitmap.createBitmap(paramb.width, paramb.height, k.hgy);
    GMTrace.o(1273860456448L, 9491);
    return paramb;
  }
  
  public final Bitmap a(b paramb)
  {
    try
    {
      GMTrace.i(1273592020992L, 9489);
      Bitmap localBitmap2 = (Bitmap)super.a(paramb);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = b(paramb);
      }
      GMTrace.o(1273592020992L, 9489);
      return localBitmap1;
    }
    finally {}
  }
  
  public final void e(Bitmap paramBitmap)
  {
    try
    {
      GMTrace.i(1273726238720L, 9490);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        super.as(paramBitmap);
      }
      GMTrace.o(1273726238720L, 9490);
      return;
    }
    finally {}
  }
  
  protected final long wj()
  {
    GMTrace.i(1273994674176L, 9492);
    GMTrace.o(1273994674176L, 9492);
    return 1228800L;
  }
  
  protected final long wk()
  {
    GMTrace.i(1274128891904L, 9493);
    GMTrace.o(1274128891904L, 9493);
    return 307200L;
  }
  
  private static final class a
    extends d<Bitmap, o.b>
  {
    public a(o.b paramb)
    {
      super();
      GMTrace.i(1294798422016L, 9647);
      GMTrace.o(1294798422016L, 9647);
    }
  }
  
  public static final class b
    implements Comparable
  {
    public int height;
    private String hgN;
    public int width;
    
    public b(int paramInt1, int paramInt2)
    {
      GMTrace.i(1273055150080L, 9485);
      this.width = paramInt1;
      this.height = paramInt2;
      this.hgN = String.format("SightBitmapSize: [%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(1273055150080L, 9485);
    }
    
    public final int compareTo(Object paramObject)
    {
      GMTrace.i(1273189367808L, 9486);
      if (paramObject == null)
      {
        GMTrace.o(1273189367808L, 9486);
        return 0;
      }
      if ((paramObject instanceof b))
      {
        if ((this.width == ((b)paramObject).width) && (this.height == ((b)paramObject).height))
        {
          GMTrace.o(1273189367808L, 9486);
          return 0;
        }
        int i = this.width;
        if (this.height * i > ((b)paramObject).width * ((b)paramObject).height)
        {
          GMTrace.o(1273189367808L, 9486);
          return 1;
        }
        GMTrace.o(1273189367808L, 9486);
        return -1;
      }
      GMTrace.o(1273189367808L, 9486);
      return 0;
    }
    
    public final String toString()
    {
      GMTrace.i(1273323585536L, 9487);
      String str = this.hgN;
      GMTrace.o(1273323585536L, 9487);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */