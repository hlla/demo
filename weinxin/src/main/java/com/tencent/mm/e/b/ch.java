package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ch
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbd;
  private static final int gcB;
  private static final int gdh;
  private static final int gyA;
  private static final int gyB;
  private static final int gyC;
  private static final int gyD;
  private static final int gyE;
  private static final int gyF;
  private static final int gyG;
  private static final int gyH;
  private static final int gyI;
  private static final int gyJ;
  private static final int gyK;
  private static final int gyL;
  private static final int gyM;
  private static final int gyN;
  private static final int gyO;
  private static final int gyP;
  private static final int gyQ;
  private static final int gyR;
  private static final int gyS;
  private static final int gyT;
  private static final int gyU;
  private static final int gyV;
  private static final int gyW;
  private static final int gyX;
  private static final int gyY;
  private static final int gyZ;
  private static final int gyz;
  private static final int gza;
  private static final int gzb;
  public String field_appId;
  public long field_downloadedLength;
  public int field_endFlag;
  public boolean field_hideBanner;
  public int field_isBlock;
  public String field_jsWebUrlDomain;
  public String field_musicId;
  public int field_musicType;
  public String field_originMusicId;
  public String field_songAlbum;
  public String field_songAlbumLocalPath;
  public int field_songAlbumType;
  public String field_songAlbumUrl;
  public int field_songBgColor;
  public long field_songFileLength;
  public String field_songHAlbumUrl;
  public int field_songId;
  public String field_songLyric;
  public int field_songLyricColor;
  public String field_songMediaId;
  public String field_songName;
  public String field_songSinger;
  public String field_songSnsAlbumUser;
  public String field_songSnsShareUser;
  public String field_songWapLinkUrl;
  public String field_songWebUrl;
  public long field_songWifiFileLength;
  public String field_songWifiUrl;
  public int field_startTime;
  public long field_updateTime;
  public long field_wifiDownloadedLength;
  public int field_wifiEndFlag;
  private boolean gaV;
  private boolean gck;
  private boolean gdd;
  private boolean gxW;
  private boolean gxX;
  private boolean gxY;
  private boolean gxZ;
  private boolean gya;
  private boolean gyb;
  private boolean gyc;
  private boolean gyd;
  private boolean gye;
  private boolean gyf;
  private boolean gyg;
  private boolean gyh;
  private boolean gyi;
  private boolean gyj;
  private boolean gyk;
  private boolean gyl;
  private boolean gym;
  private boolean gyn;
  private boolean gyo;
  private boolean gyp;
  private boolean gyq;
  private boolean gyr;
  private boolean gys;
  private boolean gyt;
  private boolean gyu;
  private boolean gyv;
  private boolean gyw;
  private boolean gyx;
  private boolean gyy;
  
  static
  {
    GMTrace.i(4159138955264L, 30988);
    gaA = new String[0];
    gyz = "musicId".hashCode();
    gyA = "originMusicId".hashCode();
    gyB = "musicType".hashCode();
    gyC = "downloadedLength".hashCode();
    gyD = "wifiDownloadedLength".hashCode();
    gyE = "endFlag".hashCode();
    gyF = "wifiEndFlag".hashCode();
    gdh = "updateTime".hashCode();
    gyG = "songId".hashCode();
    gyH = "songName".hashCode();
    gyI = "songSinger".hashCode();
    gyJ = "songAlbum".hashCode();
    gyK = "songAlbumType".hashCode();
    gyL = "songAlbumUrl".hashCode();
    gyM = "songHAlbumUrl".hashCode();
    gyN = "songAlbumLocalPath".hashCode();
    gyO = "songWifiUrl".hashCode();
    gyP = "songWapLinkUrl".hashCode();
    gyQ = "songWebUrl".hashCode();
    gcB = "appId".hashCode();
    gyR = "songMediaId".hashCode();
    gyS = "songSnsAlbumUser".hashCode();
    gyT = "songSnsShareUser".hashCode();
    gyU = "songLyric".hashCode();
    gyV = "songBgColor".hashCode();
    gyW = "songLyricColor".hashCode();
    gyX = "songFileLength".hashCode();
    gyY = "songWifiFileLength".hashCode();
    gyZ = "hideBanner".hashCode();
    gza = "jsWebUrlDomain".hashCode();
    gzb = "isBlock".hashCode();
    gbd = "startTime".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4159138955264L, 30988);
  }
  
  public ch()
  {
    GMTrace.i(4158602084352L, 30984);
    this.gxW = true;
    this.gxX = true;
    this.gxY = true;
    this.gxZ = true;
    this.gya = true;
    this.gyb = true;
    this.gyc = true;
    this.gdd = true;
    this.gyd = true;
    this.gye = true;
    this.gyf = true;
    this.gyg = true;
    this.gyh = true;
    this.gyi = true;
    this.gyj = true;
    this.gyk = true;
    this.gyl = true;
    this.gym = true;
    this.gyn = true;
    this.gck = true;
    this.gyo = true;
    this.gyp = true;
    this.gyq = true;
    this.gyr = true;
    this.gys = true;
    this.gyt = true;
    this.gyu = true;
    this.gyv = true;
    this.gyw = true;
    this.gyx = true;
    this.gyy = true;
    this.gaV = true;
    GMTrace.o(4158602084352L, 30984);
  }
  
  public static c.a pw()
  {
    GMTrace.i(4158736302080L, 30985);
    c.a locala = new c.a();
    locala.hXn = new Field[32];
    locala.columns = new String[33];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.uvr.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "musicId";
    locala.columns[1] = "originMusicId";
    locala.uvr.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.uvr.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.uvr.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.uvr.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.uvr.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.uvr.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.uvr.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.uvr.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.uvr.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.uvr.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.uvr.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.uvr.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.uvr.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.uvr.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.uvr.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.uvr.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.uvr.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.uvr.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.uvr.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.uvr.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.uvr.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.uvr.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.uvr.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.uvr.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.uvr.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.uvr.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.uvr.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.uvr.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.uvr.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.uvr.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.uvr.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    locala.columns[32] = "rowid";
    locala.uvs = localStringBuilder.toString();
    GMTrace.o(4158736302080L, 30985);
    return locala;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4158870519808L, 30986);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4158870519808L, 30986);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gyz == k)
      {
        this.field_musicId = paramCursor.getString(i);
        this.gxW = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gyA == k)
        {
          this.field_originMusicId = paramCursor.getString(i);
        }
        else if (gyB == k)
        {
          this.field_musicType = paramCursor.getInt(i);
        }
        else if (gyC == k)
        {
          this.field_downloadedLength = paramCursor.getLong(i);
        }
        else if (gyD == k)
        {
          this.field_wifiDownloadedLength = paramCursor.getLong(i);
        }
        else if (gyE == k)
        {
          this.field_endFlag = paramCursor.getInt(i);
        }
        else if (gyF == k)
        {
          this.field_wifiEndFlag = paramCursor.getInt(i);
        }
        else if (gdh == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else if (gyG == k)
        {
          this.field_songId = paramCursor.getInt(i);
        }
        else if (gyH == k)
        {
          this.field_songName = paramCursor.getString(i);
        }
        else if (gyI == k)
        {
          this.field_songSinger = paramCursor.getString(i);
        }
        else if (gyJ == k)
        {
          this.field_songAlbum = paramCursor.getString(i);
        }
        else if (gyK == k)
        {
          this.field_songAlbumType = paramCursor.getInt(i);
        }
        else if (gyL == k)
        {
          this.field_songAlbumUrl = paramCursor.getString(i);
        }
        else if (gyM == k)
        {
          this.field_songHAlbumUrl = paramCursor.getString(i);
        }
        else if (gyN == k)
        {
          this.field_songAlbumLocalPath = paramCursor.getString(i);
        }
        else if (gyO == k)
        {
          this.field_songWifiUrl = paramCursor.getString(i);
        }
        else if (gyP == k)
        {
          this.field_songWapLinkUrl = paramCursor.getString(i);
        }
        else if (gyQ == k)
        {
          this.field_songWebUrl = paramCursor.getString(i);
        }
        else if (gcB == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (gyR == k)
        {
          this.field_songMediaId = paramCursor.getString(i);
        }
        else if (gyS == k)
        {
          this.field_songSnsAlbumUser = paramCursor.getString(i);
        }
        else if (gyT == k)
        {
          this.field_songSnsShareUser = paramCursor.getString(i);
        }
        else if (gyU == k)
        {
          this.field_songLyric = paramCursor.getString(i);
        }
        else if (gyV == k)
        {
          this.field_songBgColor = paramCursor.getInt(i);
        }
        else if (gyW == k)
        {
          this.field_songLyricColor = paramCursor.getInt(i);
        }
        else if (gyX == k)
        {
          this.field_songFileLength = paramCursor.getLong(i);
        }
        else if (gyY == k)
        {
          this.field_songWifiFileLength = paramCursor.getLong(i);
        }
        else
        {
          if (gyZ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_hideBanner = bool;
              break;
            }
          }
          if (gza == k) {
            this.field_jsWebUrlDomain = paramCursor.getString(i);
          } else if (gzb == k) {
            this.field_isBlock = paramCursor.getInt(i);
          } else if (gbd == k) {
            this.field_startTime = paramCursor.getInt(i);
          } else if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4158870519808L, 30986);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4159004737536L, 30987);
    ContentValues localContentValues = new ContentValues();
    if (this.gxW) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.gxX) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.gxY) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.gxZ) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.gya) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.gyb) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.gyc) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.gdd) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.gyd) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.gye) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.gyf) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.gyg) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.gyh) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.gyi) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.gyj) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.gyk) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.gyl) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.gym) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.gyn) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gyo) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.gyp) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.gyq) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.gyr) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.gys) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.gyt) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.gyu) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.gyv) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.gyw) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.gyx) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.gyy) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.gaV) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4159004737536L, 30987);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */