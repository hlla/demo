package ct;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class bi
{
  private static HashMap e = null;
  private HashMap a = new HashMap();
  private bf b = new bf();
  private String c = "GBK";
  private bj d = new bj();
  
  public final void a(int paramInt)
  {
    this.d.b = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.d.d = paramString;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramObject instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new bg();
    ((bg)localObject).a(this.c);
    ((bg)localObject).a(paramObject, 0);
    paramObject = ((bg)localObject).a();
    localObject = new byte[((ByteBuffer)paramObject).position()];
    System.arraycopy(((ByteBuffer)paramObject).array(), 0, localObject, 0, localObject.length);
    this.a.put(paramString, localObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new bf(paramArrayOfByte, (byte)0);
      paramArrayOfByte.b = this.c;
      this.d.a(paramArrayOfByte);
      paramArrayOfByte = new bf(this.d.e);
      paramArrayOfByte.b = this.c;
      if (e == null)
      {
        localHashMap = new HashMap();
        e = localHashMap;
        localHashMap.put("", new byte[0]);
      }
      HashMap localHashMap = e;
      this.a = ((HashMap)paramArrayOfByte.a(new HashMap(), localHashMap, 0, false));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    Object localObject2 = new bg(0);
    ((bg)localObject2).a(this.c);
    ((bg)localObject2).a(this.a, 0);
    this.d.a = 3;
    Object localObject1 = this.d;
    localObject2 = ((bg)localObject2).a();
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((bj)localObject1).e = arrayOfByte;
    localObject1 = new bg(0);
    ((bg)localObject1).a(this.c);
    this.d.a((bg)localObject1);
    localObject2 = ((bg)localObject1).a();
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length;
    localObject2 = ByteBuffer.allocate(i + 4);
    ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final Object b(String paramString, Object paramObject)
  {
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.a.get(paramString);
    try
    {
      this.b.a = ByteBuffer.wrap(paramString);
      this.b.b = this.c;
      paramString = this.b.a(paramObject, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.d.c = paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */