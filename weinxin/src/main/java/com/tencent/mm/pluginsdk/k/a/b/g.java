package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.k.a.d.a;
import com.tencent.mm.pluginsdk.k.a.d.a.a;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bf;

final class g
  extends a
{
  final int fEs;
  final int fEt;
  private final boolean fEv;
  final boolean fEy;
  final long fileSize;
  private final String sDA;
  final byte[] sDZ;
  private final String sDu;
  final int sDv;
  private final byte[] sDw;
  final String sDx;
  final long sDz;
  final boolean sEa;
  final boolean sEb;
  private final int sEc;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  protected final int Mn(String paramString)
  {
    GMTrace.i(857785499648L, 6391);
    int i = bf.getInt(this.sEK, 0);
    int j = bf.getInt(paramString, 0);
    GMTrace.o(857785499648L, 6391);
    return i - j;
  }
  
  public final q bDl()
  {
    GMTrace.i(857651281920L, 6390);
    q localq = super.bDl();
    localq.field_fileUpdated = this.fEv;
    localq.field_resType = this.fEs;
    localq.field_subType = this.fEt;
    localq.field_reportId = this.sDz;
    localq.field_sampleId = this.sDA;
    localq.field_eccSignature = this.sDw;
    localq.field_originalMd5 = this.sDx;
    localq.field_fileCompress = this.sEa;
    localq.field_fileEncrypt = this.sEb;
    localq.field_encryptKey = this.sDu;
    localq.field_keyVersion = this.sDv;
    localq.field_fileSize = this.fileSize;
    localq.field_EID = this.sEc;
    GMTrace.o(857651281920L, 6390);
    return localq;
  }
  
  public final String toString()
  {
    GMTrace.i(857517064192L, 6389);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.fEv + ", resType=" + this.fEs + ", subType=" + this.fEt + ", reportId=" + this.sDz + ", sampleId='" + this.sDA + '\'' + ", originalMd5='" + this.sDx + '\'' + ", fileCompress=" + this.sEa + ", fileEncrypt=" + this.sEb + ", encryptKey='" + this.sDu + '\'' + ", keyVersion=" + this.sDv + ", EID=" + this.sEc + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.fEy + " | " + super.toString();
    GMTrace.o(857517064192L, 6389);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    int fEs;
    int fEt;
    int fEu;
    boolean fEv;
    boolean fEy;
    long fileSize;
    String sDA;
    byte[] sDZ;
    String sDu;
    int sDv;
    byte[] sDw;
    String sDx;
    long sDz;
    boolean sEa;
    boolean sEb;
    int sEc;
    
    public a(String paramString)
    {
      super();
      GMTrace.i(853624750080L, 6360);
      this.fileSize = 0L;
      GMTrace.o(853624750080L, 6360);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */