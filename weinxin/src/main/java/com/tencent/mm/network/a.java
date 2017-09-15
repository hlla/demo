package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ar;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends d.a
  implements c
{
  private boolean foreground;
  byte[] htw;
  private byte[] idE;
  private a idF;
  byte[] idG;
  String idH;
  private Map<String, byte[]> idI;
  private int uin;
  String username;
  
  public a(a parama)
  {
    GMTrace.i(13665243758592L, 101814);
    this.idF = null;
    this.foreground = true;
    this.idI = new HashMap();
    this.idF = parama;
    Mm();
    GMTrace.o(13665243758592L, 101814);
  }
  
  private void Mm()
  {
    GMTrace.i(13665512194048L, 101816);
    this.htw = bf.PS(ar.ze().getString("server_id", ""));
    GMTrace.o(13665512194048L, 101816);
  }
  
  private String Mn()
  {
    GMTrace.i(13668062330880L, 101835);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.idE).put(this.idG).put(this.htw).putInt(this.uin).put(this.idH.getBytes()).put(this.username.getBytes());
      localObject = g.n(((ByteBuffer)localObject).array());
      GMTrace.o(13668062330880L, 101835);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      GMTrace.o(13668062330880L, 101835);
    }
    return "";
  }
  
  private void clear()
  {
    GMTrace.i(13667928113152L, 101834);
    this.username = null;
    this.idE = null;
    this.htw = null;
    this.uin = 0;
    this.idG = null;
    this.idH = null;
    GMTrace.o(13667928113152L, 101834);
  }
  
  public final int A(byte[] paramArrayOfByte)
  {
    GMTrace.i(13668330766336L, 101837);
    long l = bf.NA();
    if (BY())
    {
      v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      GMTrace.o(13668330766336L, 101837);
      return -2;
    }
    try
    {
      s locals = new s();
      int i = locals.bh(paramArrayOfByte);
      if (i != 0)
      {
        v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        GMTrace.o(13668330766336L, 101837);
        return -3;
      }
      this.username = locals.getString();
      this.idH = locals.getString();
      this.uin = locals.getInt();
      this.htw = locals.getBuffer();
      this.idG = locals.getBuffer();
      this.idE = locals.getBuffer();
      paramArrayOfByte = locals.getString();
      if ((bf.mA(paramArrayOfByte)) || (!paramArrayOfByte.equals(Mn())))
      {
        clear();
        v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        GMTrace.o(13668330766336L, 101837);
        return -4;
      }
      v.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bf.aA(l)), paramArrayOfByte });
      GMTrace.o(13668330766336L, 101837);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bf.g(paramArrayOfByte) });
      GMTrace.o(13668330766336L, 101837);
    }
    return -5;
  }
  
  public final byte[] BX()
  {
    GMTrace.i(13666451718144L, 101823);
    byte[] arrayOfByte = this.htw;
    GMTrace.o(13666451718144L, 101823);
    return arrayOfByte;
  }
  
  public final boolean BY()
  {
    GMTrace.i(13666854371328L, 101826);
    if ((this.idE != null) && (this.idE.length > 0))
    {
      GMTrace.o(13666854371328L, 101826);
      return true;
    }
    GMTrace.o(13666854371328L, 101826);
    return false;
  }
  
  public final byte[] BZ()
  {
    GMTrace.i(13666317500416L, 101822);
    byte[] arrayOfByte = this.idG;
    GMTrace.o(13666317500416L, 101822);
    return arrayOfByte;
  }
  
  public final boolean Ca()
  {
    GMTrace.i(13667659677696L, 101832);
    boolean bool = this.foreground;
    GMTrace.o(13667659677696L, 101832);
    return bool;
  }
  
  public final byte[] Cb()
  {
    GMTrace.i(13668196548608L, 101836);
    long l = bf.NA();
    int i;
    if (bf.mA(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      GMTrace.o(13668196548608L, 101836);
      return null;
      if (bf.bm(this.idE)) {
        i = 0;
      } else if (bf.bm(this.htw)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bf.bm(this.idG)) {
        i = 0;
      } else if (bf.mA(this.idH)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new s();
      ((s)localObject).bIx();
      ((s)localObject).Pl(this.username);
      ((s)localObject).Pl(this.idH);
      ((s)localObject).yo(this.uin);
      ((s)localObject).bi(this.htw);
      ((s)localObject).bi(this.idG);
      ((s)localObject).bi(this.idE);
      String str = Mn();
      ((s)localObject).Pl(str);
      localObject = ((s)localObject).bIy();
      v.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bf.aA(l)), Integer.valueOf(localObject.length), str });
      GMTrace.o(13668196548608L, 101836);
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13668196548608L, 101836);
    }
    return null;
  }
  
  public final String Cv()
  {
    GMTrace.i(13667257024512L, 101829);
    String str = this.idH;
    GMTrace.o(13667257024512L, 101829);
    return str;
  }
  
  public final void E(byte[] paramArrayOfByte)
  {
    GMTrace.i(13665914847232L, 101819);
    this.htw = paramArrayOfByte;
    GMTrace.o(13665914847232L, 101819);
  }
  
  public final void F(byte[] paramArrayOfByte)
  {
    GMTrace.i(13666049064960L, 101820);
    this.idG = paramArrayOfByte;
    GMTrace.o(13666049064960L, 101820);
  }
  
  public final void aY(boolean paramBoolean)
  {
    GMTrace.i(13667793895424L, 101833);
    this.foreground = paramBoolean;
    v.i("MicroMsg.AccInfo", "somr accinfo setForegroundMuteRoom :%b", new Object[] { Boolean.valueOf(this.foreground) });
    GMTrace.o(13667793895424L, 101833);
  }
  
  public final void dj(int paramInt)
  {
    GMTrace.i(13668464984064L, 101838);
    v.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bf.bJP() });
    this.uin = paramInt;
    GMTrace.o(13668464984064L, 101838);
  }
  
  public final String getUsername()
  {
    GMTrace.i(13666585935872L, 101824);
    String str = this.username;
    GMTrace.o(13666585935872L, 101824);
    return str;
  }
  
  public final void h(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(13667391242240L, 101830);
    this.idI.put(paramString, paramArrayOfByte);
    GMTrace.o(13667391242240L, 101830);
  }
  
  public final byte[] hu(String paramString)
  {
    GMTrace.i(13667525459968L, 101831);
    paramString = (byte[])this.idI.get(paramString);
    GMTrace.o(13667525459968L, 101831);
    return paramString;
  }
  
  public final void i(byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(13665780629504L, 101818);
    v.i("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d -> %d stack:[%s]", new Object[] { bf.Qi(bf.bl(paramArrayOfByte)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bf.bJP() });
    this.idE = paramArrayOfByte;
    this.uin = paramInt;
    if (this.idF != null) {
      BY();
    }
    GMTrace.o(13665780629504L, 101818);
  }
  
  public final void mi(String paramString)
  {
    GMTrace.i(13667122806784L, 101828);
    this.idH = paramString;
    GMTrace.o(13667122806784L, 101828);
  }
  
  public final void reset()
  {
    GMTrace.i(13665377976320L, 101815);
    v.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.idE = null;
    Mm();
    this.uin = 0;
    GMTrace.o(13665377976320L, 101815);
  }
  
  public final void setUsername(String paramString)
  {
    GMTrace.i(13665646411776L, 101817);
    this.username = paramString;
    GMTrace.o(13665646411776L, 101817);
  }
  
  public final String toString()
  {
    GMTrace.i(13666988589056L, 101827);
    String str = "AccInfo:\n" + "|-uin     =" + uH() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-wxuser  =" + Cv() + "\n";
    str = str + "|-session =" + bf.bl(vc()) + "\n";
    str = str + "|-ecdhkey =" + bf.bl(BZ()) + "\n";
    str = str + "`-cookie  =" + bf.bl(BX());
    GMTrace.o(13666988589056L, 101827);
    return str;
  }
  
  public final int uH()
  {
    GMTrace.i(13666720153600L, 101825);
    int i = this.uin;
    GMTrace.o(13666720153600L, 101825);
    return i;
  }
  
  public final byte[] vc()
  {
    GMTrace.i(13666183282688L, 101821);
    byte[] arrayOfByte = this.idE;
    GMTrace.o(13666183282688L, 101821);
    return arrayOfByte;
  }
  
  public static abstract interface a {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */