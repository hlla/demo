package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class n
{
  public static File a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(".font");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Process.myTid());
    ((StringBuilder)localObject).append("-");
    String str = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < 100)
    {
      localObject = paramContext.getCacheDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(i);
      localObject = new File((File)localObject, localStringBuilder.toString());
      try
      {
        boolean bool = ((File)localObject).createNewFile();
        if (bool) {
          break label120;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      i += 1;
    }
    localObject = null;
    label120:
    return (File)localObject;
  }
  
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt)
  {
    Object localObject = null;
    File localFile = a(paramContext);
    paramContext = (Context)localObject;
    if (localFile != null) {}
    try
    {
      if (a(localFile, paramResources, paramInt))
      {
        paramContext = a(localFile);
        return paramContext;
      }
      return null;
    }
    finally
    {
      localFile.delete();
    }
  }
  
  /* Error */
  public static ByteBuffer a(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 71	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc 73
    //   9: aload_1
    //   10: invokevirtual 79	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +49 -> 64
    //   18: new 81	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual 87	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   26: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 94	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 100	java/nio/channels/FileChannel:size	()J
    //   39: lstore_3
    //   40: aload_2
    //   41: getstatic 106	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   44: lconst_0
    //   45: lload_3
    //   46: invokevirtual 110	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 113	java/io/FileInputStream:close	()V
    //   54: aload_0
    //   55: ifnull +66 -> 121
    //   58: aload_0
    //   59: invokevirtual 114	android/os/ParcelFileDescriptor:close	()V
    //   62: aload_2
    //   63: areturn
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 114	android/os/ParcelFileDescriptor:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_1
    //   78: aload_1
    //   79: athrow
    //   80: astore_2
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 114	android/os/ParcelFileDescriptor:close	()V
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: aload_2
    //   93: athrow
    //   94: astore 5
    //   96: aload_1
    //   97: invokevirtual 113	java/io/FileInputStream:close	()V
    //   100: aload 5
    //   102: athrow
    //   103: astore_0
    //   104: aload_1
    //   105: aload_0
    //   106: invokestatic 119	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   109: goto -20 -> 89
    //   112: astore_1
    //   113: aload_2
    //   114: aload_1
    //   115: invokestatic 119	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   118: goto -18 -> 100
    //   121: aload_2
    //   122: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramContext	Context
    //   0	123	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	123	2	paramUri	android.net.Uri
    //   39	7	3	l	long
    //   94	7	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	14	74	java/io/IOException
    //   58	62	74	java/io/IOException
    //   68	72	74	java/io/IOException
    //   89	91	74	java/io/IOException
    //   104	109	74	java/io/IOException
    //   18	30	77	finally
    //   50	54	77	finally
    //   100	103	77	finally
    //   113	118	77	finally
    //   78	80	80	finally
    //   30	50	91	finally
    //   92	94	94	finally
    //   85	89	103	finally
    //   96	100	112	finally
  }
  
  /* Error */
  private static ByteBuffer a(File paramFile)
  {
    // Byte code:
    //   0: new 81	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 94	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 100	java/nio/channels/FileChannel:size	()J
    //   18: lstore_1
    //   19: aload_3
    //   20: getstatic 106	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   23: lconst_0
    //   24: lload_1
    //   25: invokevirtual 110	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   28: astore_3
    //   29: aload_0
    //   30: invokevirtual 113	java/io/FileInputStream:close	()V
    //   33: aload_3
    //   34: areturn
    //   35: astore_0
    //   36: aconst_null
    //   37: areturn
    //   38: astore_3
    //   39: aload_3
    //   40: athrow
    //   41: astore 4
    //   43: aload_0
    //   44: invokevirtual 113	java/io/FileInputStream:close	()V
    //   47: aload 4
    //   49: athrow
    //   50: astore_0
    //   51: aload_3
    //   52: aload_0
    //   53: invokestatic 119	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   56: goto -9 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramFile	File
    //   18	7	1	l	long
    //   13	21	3	localObject1	Object
    //   38	14	3	localThrowable	Throwable
    //   41	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	35	java/io/IOException
    //   29	33	35	java/io/IOException
    //   47	50	35	java/io/IOException
    //   51	56	35	java/io/IOException
    //   9	29	38	finally
    //   39	41	41	finally
    //   43	47	50	finally
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean a(File paramFile, Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.openRawResource(paramInt);
      boolean bool;
      a(paramResources);
    }
    finally
    {
      try
      {
        bool = a(paramFile, paramResources);
        a(paramResources);
        return bool;
      }
      finally {}
      paramFile = finally;
      paramResources = null;
    }
    throw paramFile;
  }
  
  /* Error */
  public static boolean a(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 139	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: iconst_0
    //   6: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   9: astore_0
    //   10: sipush 1024
    //   13: newarray <illegal type>
    //   15: astore_3
    //   16: aload_1
    //   17: aload_3
    //   18: invokevirtual 148	java/io/InputStream:read	([B)I
    //   21: istore_2
    //   22: iload_2
    //   23: iconst_m1
    //   24: if_icmpeq +54 -> 78
    //   27: aload_0
    //   28: aload_3
    //   29: iconst_0
    //   30: iload_2
    //   31: invokevirtual 152	java/io/FileOutputStream:write	([BII)V
    //   34: goto -18 -> 16
    //   37: astore_1
    //   38: new 10	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   45: astore_3
    //   46: aload_3
    //   47: ldc -102
    //   49: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: aload_1
    //   55: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   58: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc -97
    //   64: aload_3
    //   65: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 165	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: aload_0
    //   73: invokestatic 137	android/support/v4/a/n:a	(Ljava/io/Closeable;)V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload_0
    //   79: invokestatic 137	android/support/v4/a/n:a	(Ljava/io/Closeable;)V
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: goto -49 -> 38
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: invokestatic 137	android/support/v4/a/n:a	(Ljava/io/Closeable;)V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: goto -7 -> 93
    //   103: astore_1
    //   104: goto -11 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   0	107	1	paramInputStream	java.io.InputStream
    //   21	10	2	i	int
    //   15	50	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	16	37	java/io/IOException
    //   16	22	37	java/io/IOException
    //   27	34	37	java/io/IOException
    //   0	10	84	java/io/IOException
    //   0	10	90	finally
    //   38	72	99	finally
    //   10	16	103	finally
    //   16	22	103	finally
    //   27	34	103	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */