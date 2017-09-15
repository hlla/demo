package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class r
{
  String clientId;
  public int fOr;
  public int fRM;
  public String fRV;
  public long fTG;
  public String fUO;
  public String fVs;
  public String fyw;
  public String hXD;
  public int hYB;
  public long hYm;
  public String hZN;
  public int hZP;
  int hZQ;
  public int hZR;
  public long hZS;
  public long hZT;
  public long hZU;
  public int hZV;
  public int hZW;
  public int hZX;
  private int hZY;
  public int hZZ;
  public int hrb;
  public int hzd;
  public int iaa;
  public String iab;
  public int iac;
  public String iad;
  public bdq iae;
  public akp iaf;
  public int status;
  public int videoFormat;
  
  public r()
  {
    GMTrace.i(360643035136L, 2687);
    this.fRM = -1;
    this.fyw = "";
    this.clientId = "";
    this.fTG = 0L;
    this.hYB = 0;
    this.hZP = 0;
    this.hrb = 0;
    this.hZQ = 0;
    this.hZR = 0;
    this.status = 0;
    this.hZS = 0L;
    this.hZT = 0L;
    this.hZU = 0L;
    this.hZV = 0;
    this.hZW = 0;
    this.hZX = 0;
    this.hZY = 0;
    this.fRV = "";
    this.hZN = "";
    this.hZZ = 0;
    this.iaa = 0;
    this.hXD = "";
    this.iab = "";
    this.iac = 0;
    this.hYm = 0L;
    this.iad = "";
    this.fVs = "";
    this.iae = new bdq();
    this.fUO = "";
    this.hzd = 0;
    this.iaf = new akp();
    this.fOr = 0;
    this.videoFormat = 0;
    GMTrace.o(360643035136L, 2687);
  }
  
  private byte[] Le()
  {
    GMTrace.i(361179906048L, 2691);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.iae.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
      }
    }
    GMTrace.o(361179906048L, 2691);
    return (byte[])localObject;
  }
  
  private byte[] Lm()
  {
    GMTrace.i(362522083328L, 2701);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.iaf.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    GMTrace.o(362522083328L, 2701);
    return (byte[])localObject;
  }
  
  public static String ls(String paramString)
  {
    GMTrace.i(360777252864L, 2688);
    try
    {
      paramString = bg.q(paramString, "msg");
      if (paramString != null)
      {
        paramString = (String)paramString.get(".msg.videomsg.$cdnvideourl");
        GMTrace.o(360777252864L, 2688);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      GMTrace.o(360777252864L, 2688);
    }
    return "";
  }
  
  public final String Lf()
  {
    GMTrace.i(361716776960L, 2695);
    if (this.fRV == null)
    {
      GMTrace.o(361716776960L, 2695);
      return "";
    }
    String str = this.fRV;
    GMTrace.o(361716776960L, 2695);
    return str;
  }
  
  public final String Lg()
  {
    GMTrace.i(361850994688L, 2696);
    if (this.hZN == null)
    {
      GMTrace.o(361850994688L, 2696);
      return "";
    }
    String str = this.hZN;
    GMTrace.o(361850994688L, 2696);
    return str;
  }
  
  public final String Lh()
  {
    GMTrace.i(361985212416L, 2697);
    if (this.hXD == null)
    {
      GMTrace.o(361985212416L, 2697);
      return "";
    }
    String str = this.hXD;
    GMTrace.o(361985212416L, 2697);
    return str;
  }
  
  public final String Li()
  {
    GMTrace.i(362119430144L, 2698);
    if (this.iab == null)
    {
      GMTrace.o(362119430144L, 2698);
      return "";
    }
    String str = this.iab;
    GMTrace.o(362119430144L, 2698);
    return str;
  }
  
  public final boolean Lj()
  {
    GMTrace.i(16268799246336L, 121212);
    if ((this.status == 140) || (this.status == 141) || (this.status == 142))
    {
      GMTrace.o(16268799246336L, 121212);
      return true;
    }
    GMTrace.o(16268799246336L, 121212);
    return false;
  }
  
  public final boolean Lk()
  {
    GMTrace.i(362253647872L, 2699);
    if ((this.status == 121) || (this.status == 122) || (this.status == 120))
    {
      GMTrace.o(362253647872L, 2699);
      return true;
    }
    GMTrace.o(362253647872L, 2699);
    return false;
  }
  
  public final boolean Ll()
  {
    GMTrace.i(362387865600L, 2700);
    if ((this.status == 199) || (this.status == 199))
    {
      GMTrace.o(362387865600L, 2700);
      return true;
    }
    GMTrace.o(362387865600L, 2700);
    return false;
  }
  
  public final void at(long paramLong)
  {
    GMTrace.i(18680557600768L, 139181);
    this.hZT = paramLong;
    GMTrace.o(18680557600768L, 139181);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(360911470592L, 2689);
    this.fyw = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.fTG = paramCursor.getLong(2);
    this.hYB = paramCursor.getInt(3);
    this.hZP = paramCursor.getInt(4);
    this.hrb = paramCursor.getInt(5);
    this.hZQ = paramCursor.getInt(6);
    this.hZR = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.hZS = paramCursor.getLong(9);
    this.hZT = paramCursor.getLong(10);
    this.hZU = paramCursor.getLong(11);
    this.hZV = paramCursor.getInt(12);
    this.hZW = paramCursor.getInt(13);
    this.hZX = paramCursor.getInt(14);
    this.hZY = paramCursor.getInt(15);
    this.fRV = paramCursor.getString(16);
    this.hZN = paramCursor.getString(17);
    this.hZZ = paramCursor.getInt(18);
    this.iaa = paramCursor.getInt(19);
    this.hXD = paramCursor.getString(20);
    this.iab = paramCursor.getString(21);
    this.iac = paramCursor.getInt(22);
    this.hYm = paramCursor.getLong(23);
    this.iad = paramCursor.getString(24);
    this.fVs = paramCursor.getString(25);
    byte[] arrayOfByte = paramCursor.getBlob(26);
    this.iae = new bdq();
    try
    {
      this.iae.aD(arrayOfByte);
      this.fUO = paramCursor.getString(27);
      this.hzd = paramCursor.getInt(28);
      arrayOfByte = paramCursor.getBlob(29);
      this.iaf = new akp();
    }
    catch (Exception localException1)
    {
      try
      {
        this.iaf.aD(arrayOfByte);
        this.fOr = paramCursor.getInt(30);
        this.videoFormat = paramCursor.getInt(31);
        GMTrace.o(360911470592L, 2689);
        return;
        localException1 = localException1;
        v.printErrStackTrace("MicroMsg.VideoInfo", localException1, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public final void gN(int paramInt)
  {
    GMTrace.i(14907160395776L, 111067);
    this.fRM = 1280;
    GMTrace.o(14907160395776L, 111067);
  }
  
  public final String getFileName()
  {
    GMTrace.i(361448341504L, 2693);
    if (this.fyw == null)
    {
      GMTrace.o(361448341504L, 2693);
      return "";
    }
    String str = this.fyw;
    GMTrace.o(361448341504L, 2693);
    return str;
  }
  
  public final int getStatus()
  {
    GMTrace.i(15300955209728L, 114001);
    int i = this.status;
    GMTrace.o(15300955209728L, 114001);
    return i;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(361045688320L, 2690);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.fRM & 0x2) != 0) {
      if (this.clientId != null) {
        break label787;
      }
    }
    label787:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.fRM & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.fTG));
      }
      if ((this.fRM & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.hYB));
      }
      if ((this.fRM & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.hZP));
      }
      if ((this.fRM & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hrb));
      }
      if ((this.fRM & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.hZQ));
      }
      if ((this.fRM & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.hZR));
      }
      if ((this.fRM & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.fRM & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.hZS));
      }
      if ((this.fRM & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.hZT));
      }
      if ((this.fRM & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.hZU));
      }
      if ((this.fRM & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.hZV));
      }
      if ((this.fRM & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.hZW));
      }
      if ((this.fRM & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.hZX));
      }
      if ((this.fRM & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.hZY));
      }
      if ((this.fRM & 0x10000) != 0) {
        localContentValues.put("user", Lf());
      }
      if ((this.fRM & 0x20000) != 0) {
        localContentValues.put("human", Lg());
      }
      if ((this.fRM & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.hZZ));
      }
      if ((this.fRM & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.iaa));
      }
      if ((this.fRM & 0x100000) != 0) {
        localContentValues.put("reserved3", Lh());
      }
      if ((this.fRM & 0x200000) != 0) {
        localContentValues.put("reserved4", Li());
      }
      if ((this.fRM & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.iac));
      }
      if ((this.fRM & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.hYm));
      }
      if ((this.fRM & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.iad);
      }
      if ((this.fRM & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.fVs);
      }
      if ((this.fRM & 0x4000000) != 0) {
        localContentValues.put("streamvideo", Le());
      }
      if ((this.fRM & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.fUO);
      }
      if ((this.fRM & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.hzd));
      }
      if ((this.fRM & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", Lm());
      }
      if ((this.fRM & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.fOr));
      }
      if ((this.fRM & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      GMTrace.o(361045688320L, 2690);
      return localContentValues;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */