package com.a.a.a;

import com.a.a.e;
import com.b.a.a;
import com.b.a.a.b;
import com.b.a.a.g;
import com.b.a.c;
import java.nio.ByteBuffer;
import java.util.Date;

public final class d
  extends c
{
  public long a;
  public long b;
  private Date e;
  private g f = g.a;
  private Date g;
  private long h;
  private double i = 1.0D;
  private float j = 1.0F;
  
  public d()
  {
    super("mvhd");
  }
  
  public final void a(ByteBuffer paramByteBuffer)
  {
    this.d = e.a(paramByteBuffer.get());
    e.b(paramByteBuffer);
    paramByteBuffer.get();
    if (!this.c) {
      c();
    }
    if (this.d == 1)
    {
      this.e = b.a(e.c(paramByteBuffer));
      this.g = b.a(e.c(paramByteBuffer));
      this.b = e.a(paramByteBuffer);
    }
    for (this.a = e.c(paramByteBuffer);; this.a = e.a(paramByteBuffer))
    {
      this.i = e.d(paramByteBuffer);
      byte[] arrayOfByte = new byte[2];
      paramByteBuffer.get(arrayOfByte);
      int k = (short)(arrayOfByte[0] << 8 & 0xFF00);
      this.j = ((short)(arrayOfByte[1] & 0xFF | k) / 256.0F);
      e.b(paramByteBuffer);
      e.a(paramByteBuffer);
      e.a(paramByteBuffer);
      this.f = g.a(paramByteBuffer);
      paramByteBuffer.getInt();
      paramByteBuffer.getInt();
      paramByteBuffer.getInt();
      paramByteBuffer.getInt();
      paramByteBuffer.getInt();
      paramByteBuffer.getInt();
      this.h = e.a(paramByteBuffer);
      return;
      this.e = b.a(e.a(paramByteBuffer));
      this.g = b.a(e.a(paramByteBuffer));
      this.b = e.a(paramByteBuffer);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MovieHeaderBox[");
    localStringBuilder.append("creationTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(";");
    localStringBuilder.append("modificationTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(";");
    localStringBuilder.append("timescale=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(";");
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(";");
    localStringBuilder.append("rate=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(";");
    localStringBuilder.append("volume=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(";");
    localStringBuilder.append("matrix=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(";");
    localStringBuilder.append("nextTrackId=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */