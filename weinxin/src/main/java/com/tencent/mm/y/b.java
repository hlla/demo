package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bf;

public final class b
  extends i
{
  public int fYi;
  public b hrS;
  public c hrT;
  public int hrU;
  public String uri;
  
  public b(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GMTrace.i(13410364293120L, 99915);
    this.hrS = null;
    this.hrT = null;
    this.fYi = 0;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if ((parama1 instanceof ave)) {
        bool1 = true;
      }
    }
    this.hrS = new b(parama1, paramInt1, paramInt2, bool1);
    this.hrT = new c(parama2, paramInt3, paramBoolean);
    this.uri = paramString;
    this.hrU = paramInt1;
    GMTrace.o(13410364293120L, 99915);
  }
  
  public final int BD()
  {
    GMTrace.i(13410901164032L, 99919);
    int i = this.fYi;
    GMTrace.o(13410901164032L, 99919);
    return i;
  }
  
  public final void a(ac paramac)
  {
    GMTrace.i(13410766946304L, 99918);
    this.hrS.sXU = paramac;
    GMTrace.o(13410766946304L, 99918);
  }
  
  public final int getType()
  {
    GMTrace.i(13410498510848L, 99916);
    int i = this.hrU;
    GMTrace.o(13410498510848L, 99916);
    return i;
  }
  
  public final String getUri()
  {
    GMTrace.i(13410632728576L, 99917);
    String str = this.uri;
    GMTrace.o(13410632728576L, 99917);
    return str;
  }
  
  public static final class a
  {
    public int hrU;
    public a hrV;
    public a hrW;
    public int hrX;
    public int hrY;
    public boolean hrZ;
    public String uri;
    
    public a()
    {
      GMTrace.i(13406740414464L, 99888);
      this.hrX = 0;
      this.hrY = 0;
      this.hrZ = true;
      GMTrace.o(13406740414464L, 99888);
    }
    
    public final b BE()
    {
      GMTrace.i(13406874632192L, 99889);
      if ((this.hrV == null) || (this.hrW == null) || (bf.mA(this.uri)) || (this.hrU <= 0) || (this.hrX == Integer.MIN_VALUE) || (this.hrY == Integer.MIN_VALUE)) {
        throw new IllegalArgumentException();
      }
      b localb = new b(this.hrV, this.hrW, this.uri, this.hrU, this.hrX, this.hrY, this.hrZ);
      GMTrace.o(13406874632192L, 99889);
      return localb;
    }
  }
  
  public static final class b
    extends k.d
    implements k.b
  {
    public int cmdId;
    private int hrU;
    public a hsa;
    private boolean hsb;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      GMTrace.i(13411706470400L, 99925);
      this.hsa = parama;
      this.hrU = paramInt1;
      this.cmdId = paramInt2;
      this.hsb = paramBoolean;
      GMTrace.o(13411706470400L, 99925);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13411840688128L, 99926);
      int i = this.cmdId;
      GMTrace.o(13411840688128L, 99926);
      return i;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13412109123584L, 99928);
      if ((this.hsa instanceof ave)) {
        ((ave)this.hsa).tXb = k.a(this);
      }
      byte[] arrayOfByte = this.hsa.toByteArray();
      GMTrace.o(13412109123584L, 99928);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13411974905856L, 99927);
      int i = this.hrU;
      GMTrace.o(13411974905856L, 99927);
      return i;
    }
  }
  
  public static final class c
    extends k.e
    implements k.c
  {
    public int cmdId;
    public a hsa;
    private boolean hsb;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      GMTrace.i(13405666672640L, 99880);
      this.hsa = null;
      this.hsa = parama;
      this.cmdId = paramInt;
      this.hsb = paramBoolean;
      GMTrace.o(13405666672640L, 99880);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13405935108096L, 99882);
      int i = this.cmdId;
      GMTrace.o(13405935108096L, 99882);
      return i;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13405800890368L, 99881);
      this.hsa = this.hsa.aD(paramArrayOfByte);
      if (!(this.hsa instanceof bad))
      {
        k.a(this, ((avm)this.hsa).tXs);
        i = ((avm)this.hsa).tXs.tgr;
        GMTrace.o(13405800890368L, 99881);
        return i;
      }
      int i = ((bad)this.hsa).getRet();
      GMTrace.o(13405800890368L, 99881);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */