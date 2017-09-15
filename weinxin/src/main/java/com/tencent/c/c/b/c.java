package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static byte[] wPU;
  static byte[] wPV;
  public int hzz = 0;
  public int requestType = 0;
  public int wPL = 0;
  public int wPM = 0;
  public int wPN = 0;
  public byte[] wPO = null;
  public int wPP = 0;
  public long wPQ = 0L;
  public byte[] wPR = null;
  public int wPS = 0;
  public int wPT = 0;
  public int wPc = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    wPU = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    wPV = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new c();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wPL = paramJceInputStream.read(this.wPL, 0, false);
    this.wPc = paramJceInputStream.read(this.wPc, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.wPM = paramJceInputStream.read(this.wPM, 3, false);
    this.wPN = paramJceInputStream.read(this.wPN, 4, false);
    this.wPO = ((byte[])paramJceInputStream.read(wPU, 5, false));
    this.wPP = paramJceInputStream.read(this.wPP, 6, false);
    this.hzz = paramJceInputStream.read(this.hzz, 7, false);
    this.wPQ = paramJceInputStream.read(this.wPQ, 8, false);
    this.wPR = ((byte[])paramJceInputStream.read(wPV, 9, false));
    this.wPS = paramJceInputStream.read(this.wPS, 10, false);
    this.wPT = paramJceInputStream.read(this.wPT, 11, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.wPL != 0) {
      paramJceOutputStream.write(this.wPL, 0);
    }
    paramJceOutputStream.write(this.wPc, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.wPM != 0) {
      paramJceOutputStream.write(this.wPM, 3);
    }
    if (this.wPN != 0) {
      paramJceOutputStream.write(this.wPN, 4);
    }
    if (this.wPO != null) {
      paramJceOutputStream.write(this.wPO, 5);
    }
    if (this.wPP != 0) {
      paramJceOutputStream.write(this.wPP, 6);
    }
    if (this.hzz != 0) {
      paramJceOutputStream.write(this.hzz, 7);
    }
    if (this.wPQ != 0L) {
      paramJceOutputStream.write(this.wPQ, 8);
    }
    if (this.wPR != null) {
      paramJceOutputStream.write(this.wPR, 9);
    }
    if (this.wPS != 0) {
      paramJceOutputStream.write(this.wPS, 10);
    }
    if (this.wPT != 0) {
      paramJceOutputStream.write(this.wPT, 11);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */