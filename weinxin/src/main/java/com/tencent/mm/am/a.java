package com.tencent.mm.am;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ch;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;

public final class a
  extends ch
{
  public static c.a gTF;
  public String hMC;
  
  static
  {
    GMTrace.i(4410394542080L, 32860);
    gTF = ch.pw();
    GMTrace.o(4410394542080L, 32860);
  }
  
  public a()
  {
    GMTrace.i(4409455017984L, 32853);
    GMTrace.o(4409455017984L, 32853);
  }
  
  public final boolean HF()
  {
    GMTrace.i(4409723453440L, 32855);
    if ((this.field_songBgColor != 0) && (this.field_songLyricColor != 0))
    {
      GMTrace.o(4409723453440L, 32855);
      return true;
    }
    GMTrace.o(4409723453440L, 32855);
    return false;
  }
  
  public final boolean HG()
  {
    GMTrace.i(4409857671168L, 32856);
    if (!bf.mA(this.field_songHAlbumUrl))
    {
      GMTrace.o(4409857671168L, 32856);
      return true;
    }
    GMTrace.o(4409857671168L, 32856);
    return false;
  }
  
  public final anc HH()
  {
    GMTrace.i(4410260324352L, 32859);
    anc localanc = new anc();
    localanc.tps = this.field_originMusicId;
    localanc.tPV = this.field_musicType;
    localanc.mrA = this.field_appId;
    localanc.tPZ = this.field_songAlbum;
    localanc.tQh = this.field_songAlbumType;
    localanc.tQa = this.field_songAlbumUrl;
    localanc.tQb = this.field_songWifiUrl;
    localanc.tPX = this.field_songName;
    localanc.tPY = this.field_songSinger;
    localanc.tQc = this.field_songWapLinkUrl;
    localanc.tQd = this.field_songWebUrl;
    localanc.tQf = this.field_songAlbumLocalPath;
    localanc.tso = this.field_songMediaId;
    localanc.tQl = this.field_songSnsAlbumUser;
    localanc.tQm = this.field_songSnsShareUser;
    localanc.tQo = this.field_hideBanner;
    localanc.tQp = this.field_jsWebUrlDomain;
    localanc.iMl = this.field_startTime;
    localanc.hMC = this.hMC;
    GMTrace.o(4410260324352L, 32859);
    return localanc;
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(4410126106624L, 32858);
    if (parama == null)
    {
      GMTrace.o(4410126106624L, 32858);
      return false;
    }
    boolean bool = this.field_musicId.equals(parama.field_musicId);
    GMTrace.o(4410126106624L, 32858);
    return bool;
  }
  
  public final boolean f(int[] paramArrayOfInt)
  {
    GMTrace.i(4409991888896L, 32857);
    if ((this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]))
    {
      GMTrace.o(4409991888896L, 32857);
      return true;
    }
    GMTrace.o(4409991888896L, 32857);
    return false;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(4409589235712L, 32854);
    c.a locala = gTF;
    GMTrace.o(4409589235712L, 32854);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/am/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */