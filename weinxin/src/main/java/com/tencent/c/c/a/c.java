package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static b wPh = new b();
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public String kck = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String mpX = "";
  public String qcv = "";
  public String wOQ = "";
  public String wOR = "";
  public String wOS = "";
  public int wOT = 0;
  public int wOU = 0;
  public b wOV = null;
  public int wOW = 0;
  public int wOX = 0;
  public int wOY = 0;
  public int wOZ = 0;
  public short wPa = 0;
  public String wPb = "";
  public int wPc = 0;
  public String wPd = "";
  public String wPe = "";
  public String wPf = "";
  public String wPg = "";
  public String wfm = "";
  
  public final JceStruct newInit()
  {
    return new c();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, true);
    this.wfm = paramJceInputStream.readString(1, false);
    this.kck = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.wOQ = paramJceInputStream.readString(4, false);
    this.wOR = paramJceInputStream.readString(5, false);
    this.wOS = paramJceInputStream.readString(6, false);
    this.wOT = paramJceInputStream.read(this.wOT, 7, false);
    this.wOU = paramJceInputStream.read(this.wOU, 8, false);
    this.wOV = ((b)paramJceInputStream.read(wPh, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.wOW = paramJceInputStream.read(this.wOW, 12, false);
    this.wOX = paramJceInputStream.read(this.wOX, 13, false);
    this.wOY = paramJceInputStream.read(this.wOY, 14, false);
    this.wOZ = paramJceInputStream.read(this.wOZ, 15, false);
    this.mpX = paramJceInputStream.readString(16, false);
    this.wPa = paramJceInputStream.read(this.wPa, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.wPb = paramJceInputStream.readString(20, false);
    this.wPc = paramJceInputStream.read(this.wPc, 21, false);
    this.wPd = paramJceInputStream.readString(22, false);
    this.wPe = paramJceInputStream.readString(23, false);
    this.qcv = paramJceInputStream.readString(24, false);
    this.wPf = paramJceInputStream.readString(25, false);
    this.wPg = paramJceInputStream.readString(26, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    if (this.wfm != null) {
      paramJceOutputStream.write(this.wfm, 1);
    }
    if (this.kck != null) {
      paramJceOutputStream.write(this.kck, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.wOQ != null) {
      paramJceOutputStream.write(this.wOQ, 4);
    }
    if (this.wOR != null) {
      paramJceOutputStream.write(this.wOR, 5);
    }
    if (this.wOS != null) {
      paramJceOutputStream.write(this.wOS, 6);
    }
    if (this.wOT != 0) {
      paramJceOutputStream.write(this.wOT, 7);
    }
    if (this.wOU != 0) {
      paramJceOutputStream.write(this.wOU, 8);
    }
    if (this.wOV != null) {
      paramJceOutputStream.write(this.wOV, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.wOW != 0) {
      paramJceOutputStream.write(this.wOW, 12);
    }
    if (this.wOX != 0) {
      paramJceOutputStream.write(this.wOX, 13);
    }
    if (this.wOY != 0) {
      paramJceOutputStream.write(this.wOY, 14);
    }
    if (this.wOZ != 0) {
      paramJceOutputStream.write(this.wOZ, 15);
    }
    if (this.mpX != null) {
      paramJceOutputStream.write(this.mpX, 16);
    }
    if (this.wPa != 0) {
      paramJceOutputStream.write(this.wPa, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.wPb != null) {
      paramJceOutputStream.write(this.wPb, 20);
    }
    if (this.wPc != 0) {
      paramJceOutputStream.write(this.wPc, 21);
    }
    if (this.wPd != null) {
      paramJceOutputStream.write(this.wPd, 22);
    }
    if (this.wPe != null) {
      paramJceOutputStream.write(this.wPe, 23);
    }
    if (this.qcv != null) {
      paramJceOutputStream.write(this.qcv, 24);
    }
    if (this.wPf != null) {
      paramJceOutputStream.write(this.wPf, 25);
    }
    if (this.wPg != null) {
      paramJceOutputStream.write(this.wPg, 26);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */