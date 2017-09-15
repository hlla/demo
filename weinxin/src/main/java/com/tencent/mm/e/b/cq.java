package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cq
  extends c
{
  private static final int gAA;
  private static final int gAB;
  private static final int gAC;
  private static final int gAD;
  private static final int gAE;
  private static final int gAF;
  private static final int gAG;
  private static final int gAH;
  private static final int gAI;
  private static final int gAJ;
  private static final int gAK;
  private static final int gAL;
  private static final int gAM;
  private static final int gAN;
  private static final int gAO;
  private static final int gAP;
  private static final int gAq;
  private static final int gAr;
  private static final int gAs;
  private static final int gAt;
  private static final int gAu;
  private static final int gAv;
  private static final int gAw;
  private static final int gAx;
  private static final int gAy;
  private static final int gAz;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gcB;
  private static final int gce;
  private static final int gir;
  private static final int gni;
  private static final int gqB;
  private static final int gqD;
  private static final int gse;
  public int field_EID;
  public String field_appId;
  public long field_contentLength;
  public String field_contentType;
  public boolean field_deleted;
  public byte[] field_eccSignature;
  public String field_encryptKey;
  public long field_expireTime;
  public boolean field_fileCompress;
  public boolean field_fileEncrypt;
  public String field_filePath;
  public long field_fileSize;
  public boolean field_fileUpdated;
  public String field_fileVersion;
  public String field_groupId1;
  public String field_groupId2;
  public int field_keyVersion;
  public int field_maxRetryTimes;
  public String field_md5;
  public boolean field_needRetry;
  public int field_networkType;
  public String field_originalMd5;
  public String field_packageId;
  public int field_priority;
  public long field_reportId;
  public int field_resType;
  public int field_retryTimes;
  public String field_sampleId;
  public int field_status;
  public int field_subType;
  public String field_url;
  public String field_urlKey;
  public int field_urlKey_hashcode;
  public int field_wvCacheType;
  private boolean gAa;
  private boolean gAb;
  private boolean gAc;
  private boolean gAd;
  private boolean gAe;
  private boolean gAf;
  private boolean gAg;
  private boolean gAh;
  private boolean gAi;
  private boolean gAj;
  private boolean gAk;
  private boolean gAl;
  private boolean gAm;
  private boolean gAn;
  private boolean gAo;
  private boolean gAp;
  private boolean gaM;
  private boolean gbI;
  private boolean gck;
  private boolean ghY;
  private boolean gmL;
  private boolean gqi;
  private boolean gqk;
  private boolean grV;
  private boolean gzQ;
  private boolean gzR;
  private boolean gzS;
  private boolean gzT;
  private boolean gzU;
  private boolean gzV;
  private boolean gzW;
  private boolean gzX;
  private boolean gzY;
  private boolean gzZ;
  
  static
  {
    GMTrace.i(4171084333056L, 31077);
    gaA = new String[0];
    gAq = "urlKey_hashcode".hashCode();
    gAr = "urlKey".hashCode();
    gir = "url".hashCode();
    gAs = "fileVersion".hashCode();
    gAt = "networkType".hashCode();
    gAu = "maxRetryTimes".hashCode();
    gAv = "retryTimes".hashCode();
    gqD = "filePath".hashCode();
    gaP = "status".hashCode();
    gAw = "contentLength".hashCode();
    gAx = "contentType".hashCode();
    gse = "expireTime".hashCode();
    gni = "md5".hashCode();
    gAy = "groupId1".hashCode();
    gAz = "groupId2".hashCode();
    gAA = "priority".hashCode();
    gAB = "fileUpdated".hashCode();
    gAC = "deleted".hashCode();
    gAD = "resType".hashCode();
    gce = "subType".hashCode();
    gAE = "reportId".hashCode();
    gAF = "sampleId".hashCode();
    gAG = "eccSignature".hashCode();
    gAH = "originalMd5".hashCode();
    gAI = "fileCompress".hashCode();
    gAJ = "fileEncrypt".hashCode();
    gAK = "encryptKey".hashCode();
    gAL = "keyVersion".hashCode();
    gAM = "EID".hashCode();
    gqB = "fileSize".hashCode();
    gAN = "needRetry".hashCode();
    gcB = "appId".hashCode();
    gAO = "wvCacheType".hashCode();
    gAP = "packageId".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4171084333056L, 31077);
  }
  
  public cq()
  {
    GMTrace.i(4170681679872L, 31074);
    this.gzQ = true;
    this.gzR = true;
    this.ghY = true;
    this.gzS = true;
    this.gzT = true;
    this.gzU = true;
    this.gzV = true;
    this.gqk = true;
    this.gaM = true;
    this.gzW = true;
    this.gzX = true;
    this.grV = true;
    this.gmL = true;
    this.gzY = true;
    this.gzZ = true;
    this.gAa = true;
    this.gAb = true;
    this.gAc = true;
    this.gAd = true;
    this.gbI = true;
    this.gAe = true;
    this.gAf = true;
    this.gAg = true;
    this.gAh = true;
    this.gAi = true;
    this.gAj = true;
    this.gAk = true;
    this.gAl = true;
    this.gAm = true;
    this.gqi = true;
    this.gAn = true;
    this.gck = true;
    this.gAo = true;
    this.gAp = true;
    GMTrace.o(4170681679872L, 31074);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4170815897600L, 31075);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4170815897600L, 31075);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gAq == k)
      {
        this.field_urlKey_hashcode = paramCursor.getInt(i);
        this.gzQ = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gAr == k)
        {
          this.field_urlKey = paramCursor.getString(i);
        }
        else if (gir == k)
        {
          this.field_url = paramCursor.getString(i);
        }
        else if (gAs == k)
        {
          this.field_fileVersion = paramCursor.getString(i);
        }
        else if (gAt == k)
        {
          this.field_networkType = paramCursor.getInt(i);
        }
        else if (gAu == k)
        {
          this.field_maxRetryTimes = paramCursor.getInt(i);
        }
        else if (gAv == k)
        {
          this.field_retryTimes = paramCursor.getInt(i);
        }
        else if (gqD == k)
        {
          this.field_filePath = paramCursor.getString(i);
        }
        else if (gaP == k)
        {
          this.field_status = paramCursor.getInt(i);
        }
        else if (gAw == k)
        {
          this.field_contentLength = paramCursor.getLong(i);
        }
        else if (gAx == k)
        {
          this.field_contentType = paramCursor.getString(i);
        }
        else if (gse == k)
        {
          this.field_expireTime = paramCursor.getLong(i);
        }
        else if (gni == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (gAy == k)
        {
          this.field_groupId1 = paramCursor.getString(i);
        }
        else if (gAz == k)
        {
          this.field_groupId2 = paramCursor.getString(i);
        }
        else if (gAA == k)
        {
          this.field_priority = paramCursor.getInt(i);
        }
        else
        {
          boolean bool;
          if (gAB == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileUpdated = bool;
              break;
            }
          }
          if (gAC == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_deleted = bool;
              break;
            }
          }
          if (gAD == k)
          {
            this.field_resType = paramCursor.getInt(i);
          }
          else if (gce == k)
          {
            this.field_subType = paramCursor.getInt(i);
          }
          else if (gAE == k)
          {
            this.field_reportId = paramCursor.getLong(i);
          }
          else if (gAF == k)
          {
            this.field_sampleId = paramCursor.getString(i);
          }
          else if (gAG == k)
          {
            this.field_eccSignature = paramCursor.getBlob(i);
          }
          else if (gAH == k)
          {
            this.field_originalMd5 = paramCursor.getString(i);
          }
          else
          {
            if (gAI == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fileCompress = bool;
                break;
              }
            }
            if (gAJ == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fileEncrypt = bool;
                break;
              }
            }
            if (gAK == k)
            {
              this.field_encryptKey = paramCursor.getString(i);
            }
            else if (gAL == k)
            {
              this.field_keyVersion = paramCursor.getInt(i);
            }
            else if (gAM == k)
            {
              this.field_EID = paramCursor.getInt(i);
            }
            else if (gqB == k)
            {
              this.field_fileSize = paramCursor.getLong(i);
            }
            else
            {
              if (gAN == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_needRetry = bool;
                  break;
                }
              }
              if (gcB == k) {
                this.field_appId = paramCursor.getString(i);
              } else if (gAO == k) {
                this.field_wvCacheType = paramCursor.getInt(i);
              } else if (gAP == k) {
                this.field_packageId = paramCursor.getString(i);
              } else if (gaJ == k) {
                this.uvp = paramCursor.getLong(i);
              }
            }
          }
        }
      }
    }
    GMTrace.o(4170815897600L, 31075);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4170950115328L, 31076);
    ContentValues localContentValues = new ContentValues();
    if (this.gzQ) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.gzR) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.ghY) {
      localContentValues.put("url", this.field_url);
    }
    if (this.gzS) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.gzT) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.gzU) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.gzV) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.gqk) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gzW) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.gzX) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.grV) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.gmL) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.gzY) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.gzZ) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.gAa) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.gAb) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.gAc) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.gAd) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.gbI) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.gAe) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.gAf) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.gAg) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.gAh) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.gAi) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.gAj) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.gAk) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.gAl) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.gAm) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.gqi) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.gAn) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gAo) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.gAp) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4170950115328L, 31076);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */