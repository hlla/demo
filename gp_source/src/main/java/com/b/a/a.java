package com.b.a;

import com.a.a.c;
import java.nio.ByteBuffer;

public abstract class a
  implements com.a.a.a.a
{
  private static com.b.a.a.f a = com.b.a.a.f.a(a.class);
  private ByteBuffer b;
  public boolean c;
  private long d;
  private f e;
  private boolean f;
  private long g = -1L;
  private String h;
  
  public a(String paramString)
  {
    this.h = paramString;
    this.f = true;
    this.c = true;
  }
  
  /* Error */
  private final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/b/a/a:f	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +63 -> 71
    //   11: getstatic 29	com/b/a/a:a	Lcom/b/a/a/f;
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 40	com/b/a/a:h	Ljava/lang/String;
    //   19: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: invokevirtual 56	java/lang/String:length	()I
    //   27: ifne +47 -> 74
    //   30: new 48	java/lang/String
    //   33: dup
    //   34: ldc 58
    //   36: invokespecial 60	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_3
    //   41: aload_2
    //   42: invokevirtual 62	com/b/a/a/f:a	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 64	com/b/a/a:e	Lcom/b/a/f;
    //   50: aload_0
    //   51: getfield 66	com/b/a/a:d	J
    //   54: aload_0
    //   55: getfield 38	com/b/a/a:g	J
    //   58: invokeinterface 71 5 0
    //   63: putfield 73	com/b/a/a:b	Ljava/nio/ByteBuffer;
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 42	com/b/a/a:f	Z
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: ldc 58
    //   76: aload_2
    //   77: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_2
    //   81: goto -41 -> 40
    //   84: astore_2
    //   85: new 79	java/lang/RuntimeException
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 82	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   93: athrow
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	a
    //   6	2	1	bool	boolean
    //   22	59	2	str	String
    //   84	6	2	localIOException	java.io.IOException
    //   94	4	2	localObject	Object
    //   14	27	3	localf	com.b.a.a.f
    // Exception table:
    //   from	to	target	type
    //   11	40	84	java/io/IOException
    //   40	66	84	java/io/IOException
    //   74	81	84	java/io/IOException
    //   2	7	94	finally
    //   11	40	94	finally
    //   40	66	94	finally
    //   66	71	94	finally
    //   74	81	94	finally
    //   85	94	94	finally
  }
  
  public final void a() {}
  
  public final void a(f paramf, ByteBuffer paramByteBuffer, long paramLong, c paramc)
  {
    this.d = paramf.b();
    paramByteBuffer.remaining();
    this.g = paramLong;
    this.e = paramf;
    paramf.a(paramf.b() + paramLong);
    this.f = false;
    this.c = false;
    c();
  }
  
  public abstract void a(ByteBuffer paramByteBuffer);
  
  public final String b()
  {
    return this.h;
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 100	com/b/a/a:d	()V
    //   6: getstatic 29	com/b/a/a:a	Lcom/b/a/a/f;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 40	com/b/a/a:h	Ljava/lang/String;
    //   14: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 56	java/lang/String:length	()I
    //   22: ifne +62 -> 84
    //   25: new 48	java/lang/String
    //   28: dup
    //   29: ldc 102
    //   31: invokespecial 60	java/lang/String:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 62	com/b/a/a/f:a	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 73	com/b/a/a:b	Ljava/nio/ByteBuffer;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +35 -> 81
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 44	com/b/a/a:c	Z
    //   54: aload_1
    //   55: invokevirtual 106	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   58: pop
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 108	com/b/a/a:a	(Ljava/nio/ByteBuffer;)V
    //   64: aload_1
    //   65: invokevirtual 91	java/nio/ByteBuffer:remaining	()I
    //   68: ifle +8 -> 76
    //   71: aload_1
    //   72: invokevirtual 112	java/nio/ByteBuffer:slice	()Ljava/nio/ByteBuffer;
    //   75: pop
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 73	com/b/a/a:b	Ljava/nio/ByteBuffer;
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: ldc 102
    //   86: aload_1
    //   87: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_1
    //   91: goto -56 -> 35
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	a
    //   17	74	1	localObject1	Object
    //   94	4	1	localObject2	Object
    //   9	27	2	localf	com.b.a.a.f
    // Exception table:
    //   from	to	target	type
    //   2	35	94	finally
    //   35	45	94	finally
    //   49	76	94	finally
    //   76	81	94	finally
    //   84	91	94	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */