package android.support.v4.a;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;

class f
  extends j
{
  private static File a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/proc/self/fd/");
      localStringBuilder.append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(localStringBuilder.toString());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  /* Error */
  public android.graphics.Typeface a(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.support.v4.e.r[] paramArrayOfr, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: ifle +99 -> 101
    //   5: aload_3
    //   6: iload 4
    //   8: invokestatic 68	android/support/v4/a/j:a	([Landroid/support/v4/e/r;I)Landroid/support/v4/e/r;
    //   11: astore_2
    //   12: aload_1
    //   13: invokevirtual 74	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: astore_3
    //   17: aload_3
    //   18: aload_2
    //   19: getfield 80	android/support/v4/e/r:d	Landroid/net/Uri;
    //   22: ldc 82
    //   24: aconst_null
    //   25: invokevirtual 88	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   28: astore_3
    //   29: aload_3
    //   30: invokestatic 90	android/support/v4/a/f:a	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +39 -> 74
    //   38: new 92	java/io/FileInputStream
    //   41: dup
    //   42: aload_3
    //   43: invokevirtual 96	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   46: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   49: astore_2
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 102	android/support/v4/a/j:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   55: astore_1
    //   56: aload_2
    //   57: invokevirtual 105	java/io/FileInputStream:close	()V
    //   60: aload_1
    //   61: astore_2
    //   62: aload_3
    //   63: ifnull +9 -> 72
    //   66: aload_3
    //   67: invokevirtual 106	android/os/ParcelFileDescriptor:close	()V
    //   70: aload_1
    //   71: astore_2
    //   72: aload_2
    //   73: areturn
    //   74: aload_2
    //   75: invokevirtual 110	java/io/File:canRead	()Z
    //   78: ifeq -40 -> 38
    //   81: aload_2
    //   82: invokestatic 116	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull -17 -> 72
    //   92: aload_3
    //   93: invokevirtual 106	android/os/ParcelFileDescriptor:close	()V
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: aconst_null
    //   100: areturn
    //   101: aconst_null
    //   102: areturn
    //   103: astore_1
    //   104: aload_1
    //   105: athrow
    //   106: astore_2
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 106	android/os/ParcelFileDescriptor:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_1
    //   118: aload_1
    //   119: athrow
    //   120: astore 5
    //   122: aload_2
    //   123: invokevirtual 105	java/io/FileInputStream:close	()V
    //   126: aload 5
    //   128: athrow
    //   129: astore_3
    //   130: aload_1
    //   131: aload_3
    //   132: invokestatic 121	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   135: goto -20 -> 115
    //   138: astore_2
    //   139: aload_1
    //   140: aload_2
    //   141: invokestatic 121	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   144: goto -18 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	f
    //   0	147	1	paramContext	android.content.Context
    //   0	147	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	147	3	paramArrayOfr	android.support.v4.e.r[]
    //   0	147	4	paramInt	int
    //   120	7	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	29	98	java/io/IOException
    //   66	70	98	java/io/IOException
    //   92	96	98	java/io/IOException
    //   115	117	98	java/io/IOException
    //   130	135	98	java/io/IOException
    //   29	34	103	finally
    //   38	50	103	finally
    //   56	60	103	finally
    //   74	86	103	finally
    //   126	129	103	finally
    //   139	144	103	finally
    //   104	106	106	finally
    //   50	56	117	finally
    //   118	120	120	finally
    //   111	115	129	finally
    //   122	126	138	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */