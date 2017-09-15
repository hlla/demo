package ct;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.GZIPOutputStream;

final class cc
{
  final LinkedBlockingQueue<a> a;
  final bk b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  
  cc(bk parambk)
  {
    this.b = parambk;
    this.a = new LinkedBlockingQueue(3);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TencentLogImpl.isDebugEnabled()) && (paramArrayOfByte != null)) {}
    try
    {
      if (e.o(paramArrayOfByte, 1) < 0) {
        return bu.a(paramInt, 0);
      }
      paramArrayOfByte = bu.a(paramInt, 1);
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte) {}
    return null;
  }
  
  static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject3;
      localObject2 = localObject4;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localGZIPOutputStream.close();
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localObject2 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Error paramArrayOfByte)
    {
      return (byte[])localObject1;
    }
    catch (Exception paramArrayOfByte) {}
    return (byte[])localObject2;
  }
  
  final void a(a parama)
  {
    parama.h -= 1;
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((a)localIterator.next()).e != parama.e);
    for (int i = 1;; i = 0)
    {
      if ((parama.h > 0) && (i == 0))
      {
        b.a.a("TxRequestSender", "retryIfNeed: times=" + parama.h);
        this.a.offer(parama);
      }
      return;
    }
  }
  
  public final void a(String paramString, ci paramci, int paramInt)
  {
    SystemClock.elapsedRealtime();
    try
    {
      byte[] arrayOfByte = b.a.a(paramString.getBytes("GBK"));
      paramci = new a(1, arrayOfByte, a(arrayOfByte, paramInt), paramci);
      paramci.b = paramString;
      boolean bool = false;
      if (paramci.f != null) {
        bool = this.a.offer(paramci);
      }
      if (!bool)
      {
        this.a.clear();
        this.a.offer(paramci);
        b.a.b("TxRequestSender", "postLocationRequest: failed to add request,because the queue has full,so we delete the first");
      }
      return;
    }
    catch (Exception paramString)
    {
      b.a.a("TxRequestSender", "", paramString);
    }
  }
  
  static final class a
  {
    public static final a d = new a();
    final Object a;
    public String b;
    public long c;
    public final int e;
    public final byte[] f;
    public final String g;
    public int h = 1;
    
    private a()
    {
      this.e = 0;
      this.f = null;
      this.g = null;
      this.a = null;
    }
    
    a(int paramInt, byte[] paramArrayOfByte, String paramString, Object paramObject)
    {
      this.e = paramInt;
      this.f = paramArrayOfByte;
      this.g = paramString;
      this.a = paramObject;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */