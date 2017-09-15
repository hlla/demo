package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  public int wOL = 0;
  public int wOM = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wOL = paramJceInputStream.read(this.wOL, 0, true);
    this.wOM = paramJceInputStream.read(this.wOM, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wOL, 0);
    paramJceOutputStream.write(this.wOM, 1);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */