package com.tencent.c.e;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class i
{
  static HashMap<String, byte[]> wQw = null;
  protected String wQs = "UTF-8";
  protected RequestPacket wQt = new RequestPacket();
  protected HashMap<String, byte[]> wQu = new HashMap();
  private HashMap<String, Object> wQv = new HashMap();
  
  public i()
  {
    this.wQt.iVersion = 3;
  }
  
  public final void Vf(String paramString)
  {
    this.wQs = paramString;
  }
  
  public final void Vg(String paramString)
  {
    this.wQt.sServantName = paramString;
  }
  
  public final void Vh(String paramString)
  {
    this.wQt.sFuncName = paramString;
  }
  
  public final void cdD()
  {
    this.wQt.iRequestId = 3;
  }
  
  public final byte[] nW()
  {
    if (this.wQt.sServantName == null) {
      this.wQt.sServantName = "";
    }
    if (this.wQt.sFuncName == null) {
      this.wQt.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.wQs);
    ((JceOutputStream)localObject).write(this.wQu, 0);
    this.wQt.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.wQs);
    this.wQt.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
  
  public final <T> void put(String paramString, T paramT)
  {
    if ((paramString.startsWith(".")) || (paramT == null) || ((paramT instanceof Set))) {
      throw new IllegalArgumentException("wup put err");
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding(this.wQs);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.wQu.put(paramString, paramT);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */