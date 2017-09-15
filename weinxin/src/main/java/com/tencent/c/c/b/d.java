package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public int cze = 0;
  public String hvM = "";
  public String model = "";
  public String platform = "";
  public String wPW = "";
  public String wPX = "";
  public int wPY = 0;
  public String wPZ = "";
  
  public final JceStruct newInit()
  {
    return new d();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wPW = paramJceInputStream.readString(0, false);
    this.wPX = paramJceInputStream.readString(1, false);
    this.hvM = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.wPY = paramJceInputStream.read(this.wPY, 4, false);
    this.wPZ = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.cze = paramJceInputStream.read(this.cze, 7, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.wPW != null) {
      paramJceOutputStream.write(this.wPW, 0);
    }
    if (this.wPX != null) {
      paramJceOutputStream.write(this.wPX, 1);
    }
    if (this.hvM != null) {
      paramJceOutputStream.write(this.hvM, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.wPY != 0) {
      paramJceOutputStream.write(this.wPY, 4);
    }
    if (this.wPZ != null) {
      paramJceOutputStream.write(this.wPZ, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.cze != 0) {
      paramJceOutputStream.write(this.cze, 7);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */