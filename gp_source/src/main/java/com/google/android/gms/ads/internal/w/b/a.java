package com.google.android.gms.ads.internal.w.b;

import com.b.a.f;
import java.nio.ByteBuffer;

@com.google.android.gms.ads.internal.q.a.a
final class a
  implements f
{
  private final ByteBuffer a;
  
  a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer.duplicate();
  }
  
  public final int a(ByteBuffer paramByteBuffer)
  {
    if ((this.a.remaining() != 0) || (paramByteBuffer.remaining() <= 0))
    {
      byte[] arrayOfByte = new byte[Math.min(paramByteBuffer.remaining(), this.a.remaining())];
      this.a.get(arrayOfByte);
      paramByteBuffer.put(arrayOfByte);
      return arrayOfByte.length;
    }
    return -1;
  }
  
  public final long a()
  {
    return this.a.limit();
  }
  
  public final ByteBuffer a(long paramLong1, long paramLong2)
  {
    int i = this.a.position();
    this.a.position((int)paramLong1);
    ByteBuffer localByteBuffer = this.a.slice();
    localByteBuffer.limit((int)paramLong2);
    this.a.position(i);
    return localByteBuffer;
  }
  
  public final void a(long paramLong)
  {
    this.a.position((int)paramLong);
  }
  
  public final long b()
  {
    return this.a.position();
  }
  
  public final void close() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */