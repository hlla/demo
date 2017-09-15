package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] wPH;
  static byte[] wPI;
  static ArrayList<Integer> wPJ;
  static ArrayList<byte[]> wPK;
  public int wPA = 0;
  public ArrayList<Integer> wPB = null;
  public int wPC = 0;
  public boolean wPD = false;
  public int wPE = 0;
  public int wPF = 0;
  public ArrayList<byte[]> wPG = null;
  public int wPo = 0;
  public byte[] wPp = null;
  public String wPq = "";
  public byte[] wPr = null;
  public long wPs = 0L;
  public String wPt = "";
  public int wPu = 0;
  public String wPv = "";
  public int wPw = 0;
  public String wPx = "";
  public int wPy = 0;
  public int wPz = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    wPH = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    wPI = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    wPJ = new ArrayList();
    wPJ.add(Integer.valueOf(0));
    wPK = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    wPK.add(arrayOfByte);
  }
  
  public final JceStruct newInit()
  {
    return new b();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wPo = paramJceInputStream.read(this.wPo, 0, true);
    this.wPp = ((byte[])paramJceInputStream.read(wPH, 1, false));
    this.wPq = paramJceInputStream.readString(2, false);
    this.wPr = ((byte[])paramJceInputStream.read(wPI, 3, false));
    this.wPs = paramJceInputStream.read(this.wPs, 4, false);
    this.wPt = paramJceInputStream.readString(5, false);
    this.wPu = paramJceInputStream.read(this.wPu, 6, false);
    this.wPv = paramJceInputStream.readString(7, false);
    this.wPw = paramJceInputStream.read(this.wPw, 8, false);
    this.wPx = paramJceInputStream.readString(9, false);
    this.wPy = paramJceInputStream.read(this.wPy, 10, false);
    this.wPz = paramJceInputStream.read(this.wPz, 11, false);
    this.wPA = paramJceInputStream.read(this.wPA, 12, false);
    this.wPB = ((ArrayList)paramJceInputStream.read(wPJ, 13, false));
    this.wPC = paramJceInputStream.read(this.wPC, 14, false);
    this.wPD = paramJceInputStream.read(this.wPD, 15, false);
    this.wPE = paramJceInputStream.read(this.wPE, 16, false);
    this.wPF = paramJceInputStream.read(this.wPF, 17, false);
    this.wPG = ((ArrayList)paramJceInputStream.read(wPK, 18, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wPo, 0);
    if (this.wPp != null) {
      paramJceOutputStream.write(this.wPp, 1);
    }
    if (this.wPq != null) {
      paramJceOutputStream.write(this.wPq, 2);
    }
    if (this.wPr != null) {
      paramJceOutputStream.write(this.wPr, 3);
    }
    if (this.wPs != 0L) {
      paramJceOutputStream.write(this.wPs, 4);
    }
    if (this.wPt != null) {
      paramJceOutputStream.write(this.wPt, 5);
    }
    if (this.wPu != 0) {
      paramJceOutputStream.write(this.wPu, 6);
    }
    if (this.wPv != null) {
      paramJceOutputStream.write(this.wPv, 7);
    }
    if (this.wPw != 0) {
      paramJceOutputStream.write(this.wPw, 8);
    }
    if (this.wPx != null) {
      paramJceOutputStream.write(this.wPx, 9);
    }
    paramJceOutputStream.write(this.wPy, 10);
    if (this.wPz != 0) {
      paramJceOutputStream.write(this.wPz, 11);
    }
    if (this.wPA != 0) {
      paramJceOutputStream.write(this.wPA, 12);
    }
    if (this.wPB != null) {
      paramJceOutputStream.write(this.wPB, 13);
    }
    if (this.wPC != 0) {
      paramJceOutputStream.write(this.wPC, 14);
    }
    paramJceOutputStream.write(this.wPD, 15);
    if (this.wPE != 0) {
      paramJceOutputStream.write(this.wPE, 16);
    }
    paramJceOutputStream.write(this.wPF, 17);
    if (this.wPG != null) {
      paramJceOutputStream.write(this.wPG, 18);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */