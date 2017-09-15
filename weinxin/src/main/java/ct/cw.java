package ct;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;

public final class cw
{
  private static final FilenameFilter a = new FilenameFilter()
  {
    public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return paramAnonymousString.endsWith(".stacktrace");
    }
  };
  public static boolean b;
  
  public static CountDownLatch a(bk parambk, final String paramString1, final String paramString2, final String paramString3)
  {
    try
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      new Thread()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: getstatic 40	ct/cw:b	Z
          //   3: ifne +55 -> 58
          //   6: iconst_1
          //   7: putstatic 40	ct/cw:b	Z
          //   10: aload_0
          //   11: getfield 20	ct/cw$2:a	Lct/bk;
          //   14: aload_0
          //   15: getfield 22	ct/cw$2:b	Ljava/lang/String;
          //   18: new 42	java/io/File
          //   21: dup
          //   22: aload_0
          //   23: getfield 24	ct/cw$2:c	Ljava/lang/String;
          //   26: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
          //   29: invokevirtual 49	java/io/File:getParentFile	()Ljava/io/File;
          //   32: invokestatic 52	ct/cw:a	(Lct/bk;Ljava/lang/String;Ljava/io/File;)V
          //   35: aload_0
          //   36: getfield 20	ct/cw$2:a	Lct/bk;
          //   39: aload_0
          //   40: getfield 22	ct/cw$2:b	Ljava/lang/String;
          //   43: aload_0
          //   44: getfield 26	ct/cw$2:d	Ljava/lang/String;
          //   47: invokevirtual 58	java/lang/String:getBytes	()[B
          //   50: invokevirtual 63	ct/bk:a	(Ljava/lang/String;[B)Ljava/lang/String;
          //   53: pop
          //   54: iconst_0
          //   55: putstatic 40	ct/cw:b	Z
          //   58: aload_0
          //   59: getfield 28	ct/cw$2:e	Ljava/util/concurrent/CountDownLatch;
          //   62: invokevirtual 68	java/util/concurrent/CountDownLatch:countDown	()V
          //   65: return
          //   66: astore_1
          //   67: ldc 70
          //   69: ldc 72
          //   71: aload_1
          //   72: invokestatic 77	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
          //   75: new 79	java/io/BufferedWriter
          //   78: dup
          //   79: new 81	java/io/FileWriter
          //   82: dup
          //   83: aload_0
          //   84: getfield 24	ct/cw$2:c	Ljava/lang/String;
          //   87: invokespecial 82	java/io/FileWriter:<init>	(Ljava/lang/String;)V
          //   90: invokespecial 85	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
          //   93: astore_1
          //   94: aload_1
          //   95: aload_0
          //   96: getfield 26	ct/cw$2:d	Ljava/lang/String;
          //   99: invokevirtual 88	java/io/BufferedWriter:write	(Ljava/lang/String;)V
          //   102: aload_1
          //   103: invokevirtual 91	java/io/BufferedWriter:flush	()V
          //   106: aload_1
          //   107: invokevirtual 94	java/io/BufferedWriter:close	()V
          //   110: goto -56 -> 54
          //   113: astore_2
          //   114: aload_1
          //   115: invokevirtual 94	java/io/BufferedWriter:close	()V
          //   118: aload_2
          //   119: athrow
          //   120: astore_1
          //   121: goto -67 -> 54
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	124	0	this	2
          //   66	6	1	localException	Exception
          //   93	22	1	localBufferedWriter	java.io.BufferedWriter
          //   120	1	1	localIOException	java.io.IOException
          //   113	6	2	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   35	54	66	java/lang/Exception
          //   94	106	113	finally
          //   75	94	120	java/io/IOException
          //   106	110	120	java/io/IOException
          //   114	120	120	java/io/IOException
        }
      }.start();
      return localCountDownLatch;
    }
    finally
    {
      parambk = finally;
      throw parambk;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */