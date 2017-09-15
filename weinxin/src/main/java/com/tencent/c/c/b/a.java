package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c wPl = new c();
  static ArrayList<b> wPm = new ArrayList();
  static d wPn = new d();
  public c wPi = null;
  public ArrayList<b> wPj = null;
  public d wPk = null;
  
  static
  {
    b localb = new b();
    wPm.add(localb);
  }
  
  public final JceStruct newInit()
  {
    return new a();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wPi = ((c)paramJceInputStream.read(wPl, 0, false));
    this.wPj = ((ArrayList)paramJceInputStream.read(wPm, 1, false));
    this.wPk = ((d)paramJceInputStream.read(wPn, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.wPi != null) {
      paramJceOutputStream.write(this.wPi, 0);
    }
    if (this.wPj != null) {
      paramJceOutputStream.write(this.wPj, 1);
    }
    if (this.wPk != null) {
      paramJceOutputStream.write(this.wPk, 2);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */