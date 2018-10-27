package com.b.a;

import com.a.a.a.a;
import com.a.a.a.b;
import com.a.a.c;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class d
  implements b, Closeable, Iterator
{
  private static final a e = new e("eof ");
  public c a;
  public f b;
  public long c = 0L;
  public long d = 0L;
  private List f = new ArrayList();
  private a g = null;
  
  static
  {
    com.b.a.a.f.a(d.class);
  }
  
  /* Error */
  private final a a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/b/a/d:g	Lcom/a/a/a/a;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +22 -> 28
    //   9: aload_1
    //   10: getstatic 34	com/b/a/d:e	Lcom/a/a/a/a;
    //   13: if_acmpeq +15 -> 28
    //   16: aload_0
    //   17: getfield 44	com/b/a/d:g	Lcom/a/a/a/a;
    //   20: astore_1
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 44	com/b/a/d:g	Lcom/a/a/a/a;
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield 60	com/b/a/d:b	Lcom/b/a/f;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +76 -> 110
    //   37: aload_0
    //   38: getfield 46	com/b/a/d:d	J
    //   41: aload_0
    //   42: getfield 48	com/b/a/d:c	J
    //   45: lcmp
    //   46: ifge +64 -> 110
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 60	com/b/a/d:b	Lcom/b/a/f;
    //   55: aload_0
    //   56: getfield 46	com/b/a/d:d	J
    //   59: invokeinterface 65 3 0
    //   64: aload_0
    //   65: getfield 67	com/b/a/d:a	Lcom/a/a/c;
    //   68: aload_0
    //   69: getfield 60	com/b/a/d:b	Lcom/b/a/f;
    //   72: aload_0
    //   73: invokeinterface 72 3 0
    //   78: astore_2
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 60	com/b/a/d:b	Lcom/b/a/f;
    //   84: invokeinterface 75 1 0
    //   89: putfield 46	com/b/a/d:d	J
    //   92: aload_1
    //   93: monitorexit
    //   94: aload_2
    //   95: areturn
    //   96: astore_2
    //   97: aload_1
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: new 77	java/util/NoSuchElementException
    //   105: dup
    //   106: invokespecial 78	java/util/NoSuchElementException:<init>	()V
    //   109: athrow
    //   110: aload_0
    //   111: getstatic 34	com/b/a/d:e	Lcom/a/a/a/a;
    //   114: putfield 44	com/b/a/d:g	Lcom/a/a/a/a;
    //   117: new 77	java/util/NoSuchElementException
    //   120: dup
    //   121: invokespecial 78	java/util/NoSuchElementException:<init>	()V
    //   124: athrow
    //   125: astore_1
    //   126: new 77	java/util/NoSuchElementException
    //   129: dup
    //   130: invokespecial 78	java/util/NoSuchElementException:<init>	()V
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	d
    //   4	94	1	localObject1	Object
    //   101	1	1	localEOFException	java.io.EOFException
    //   125	1	1	localIOException	java.io.IOException
    //   78	17	2	locala	a
    //   96	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   51	94	96	finally
    //   97	99	96	finally
    //   49	51	101	java/io/EOFException
    //   99	101	101	java/io/EOFException
    //   49	51	125	java/io/IOException
    //   99	101	125	java/io/IOException
  }
  
  public void a(f paramf, long paramLong, c paramc)
  {
    this.b = paramf;
    this.d = paramf.b();
    paramf.a(paramf.b() + paramLong);
    this.c = paramf.b();
    this.a = paramc;
  }
  
  public final List c()
  {
    if ((this.b != null) && (this.g != e)) {
      return new com.b.a.a.d(this.f, this);
    }
    return this.f;
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public boolean hasNext()
  {
    if ((this.g == e) || (this.g == null)) {}
    try
    {
      this.g = ((a)next());
      return true;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      this.g = e;
    }
    return true;
    return false;
    return false;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("[");
    int i = 0;
    if (i < this.f.size())
    {
      if (i <= 0) {}
      for (;;)
      {
        localStringBuilder.append(((a)this.f.get(i)).toString());
        i += 1;
        break;
        localStringBuilder.append(";");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */