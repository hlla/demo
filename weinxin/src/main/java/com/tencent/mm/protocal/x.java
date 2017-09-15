package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

public final class x
{
  public static final class a
    extends k.d
    implements k.b
  {
    public byte[] fKf;
    public long hMr;
    
    public a()
    {
      GMTrace.i(13565251551232L, 101069);
      this.fKf = null;
      this.hMr = -1L;
      GMTrace.o(13565251551232L, 101069);
    }
    
    public final boolean Cl()
    {
      GMTrace.i(13565788422144L, 101073);
      GMTrace.o(13565788422144L, 101073);
      return false;
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13565519986688L, 101071);
      GMTrace.o(13565519986688L, 101071);
      return 1000000190;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13565385768960L, 101070);
      byte[] arrayOfByte = new byte[this.fKf.length + 8];
      int i = (int)(bf.NA() - this.hMr);
      arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(this.fKf.length >> 24 & 0xFF));
      arrayOfByte[5] = ((byte)(this.fKf.length >> 16 & 0xFF));
      arrayOfByte[6] = ((byte)(this.fKf.length >> 8 & 0xFF));
      arrayOfByte[7] = ((byte)(this.fKf.length & 0xFF));
      System.arraycopy(this.fKf, 0, arrayOfByte, 8, this.fKf.length);
      bf.bl(arrayOfByte);
      GMTrace.o(13565385768960L, 101070);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13565654204416L, 101072);
      GMTrace.o(13565654204416L, 101072);
      return 268369922;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public b()
    {
      GMTrace.i(13596255846400L, 101300);
      GMTrace.o(13596255846400L, 101300);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13596524281856L, 101302);
      GMTrace.o(13596524281856L, 101302);
      return -1;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13596390064128L, 101301);
      GMTrace.o(13596390064128L, 101301);
      return 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */