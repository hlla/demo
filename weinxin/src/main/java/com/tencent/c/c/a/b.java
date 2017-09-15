package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public int wON = 0;
  public int wOO = 0;
  public int wOP = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wON = paramJceInputStream.read(this.wON, 1, true);
    this.wOO = paramJceInputStream.read(this.wOO, 2, true);
    this.wOP = paramJceInputStream.read(this.wOP, 3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wON, 1);
    paramJceOutputStream.write(this.wOO, 2);
    paramJceOutputStream.write(this.wOP, 3);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */