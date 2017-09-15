package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.gmtrace.GMTrace;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class o
{
  public static boolean Ph(String paramString)
  {
    GMTrace.i(13743358476288L, 102396);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
      GMTrace.o(13743358476288L, 102396);
      return false;
    }
    if (paramString.length() < 3)
    {
      GMTrace.o(13743358476288L, 102396);
      return false;
    }
    if (!new File(paramString).exists())
    {
      GMTrace.o(13743358476288L, 102396);
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
    paramString = MMBitmapFactory.decodeFile(paramString, localOptions, localDecodeResultLogger, 0, new int[0]);
    if (paramString != null)
    {
      v.i("MicroMsg.ImgUtil", "bitmap recycle %s", new Object[] { paramString });
      paramString.recycle();
    }
    if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0) && (localDecodeResultLogger.getDecodeResult() == 0))
    {
      GMTrace.o(13743358476288L, 102396);
      return true;
    }
    GMTrace.o(13743358476288L, 102396);
    return false;
  }
  
  /* Error */
  public static boolean Pi(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 89
    //   3: ldc 91
    //   5: invokestatic 15	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: new 93	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: bipush 6
    //   19: newarray <illegal type>
    //   21: astore 4
    //   23: aload_0
    //   24: aload 4
    //   26: invokevirtual 100	java/io/InputStream:read	([B)I
    //   29: pop
    //   30: ldc 102
    //   32: astore_3
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: bipush 6
    //   38: if_icmpge +33 -> 71
    //   41: new 104	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   48: aload_3
    //   49: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 4
    //   54: iload_1
    //   55: baload
    //   56: i2c
    //   57: invokevirtual 112	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   60: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_3
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: istore_1
    //   68: goto -33 -> 35
    //   71: aload_3
    //   72: ldc 118
    //   74: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   77: istore_2
    //   78: iload_2
    //   79: ifne +17 -> 96
    //   82: aload_0
    //   83: invokevirtual 124	java/io/InputStream:close	()V
    //   86: ldc2_w 89
    //   89: ldc 91
    //   91: invokestatic 34	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_0
    //   97: invokevirtual 124	java/io/InputStream:close	()V
    //   100: ldc2_w 89
    //   103: ldc 91
    //   105: invokestatic 34	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   108: iconst_1
    //   109: ireturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 124	java/io/InputStream:close	()V
    //   121: ldc2_w 89
    //   124: ldc 91
    //   126: invokestatic 34	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 124	java/io/InputStream:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore_0
    //   145: goto -59 -> 86
    //   148: astore_0
    //   149: goto -49 -> 100
    //   152: astore_0
    //   153: goto -32 -> 121
    //   156: astore_0
    //   157: goto -15 -> 142
    //   160: astore_3
    //   161: goto -27 -> 134
    //   164: astore_3
    //   165: goto -52 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   34	34	1	i	int
    //   77	2	2	bool	boolean
    //   32	40	3	str	String
    //   131	12	3	localObject1	Object
    //   160	1	3	localObject2	Object
    //   164	1	3	localException	Exception
    //   21	32	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	17	110	java/lang/Exception
    //   8	17	131	finally
    //   82	86	144	java/io/IOException
    //   96	100	148	java/io/IOException
    //   117	121	152	java/io/IOException
    //   138	142	156	java/io/IOException
    //   17	30	160	finally
    //   41	64	160	finally
    //   71	78	160	finally
    //   17	30	164	java/lang/Exception
    //   41	64	164	java/lang/Exception
    //   71	78	164	java/lang/Exception
  }
  
  public static boolean a(String paramString, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13743492694016L, 102397);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
      paramDecodeResultLogger.setDecodeResult(1005);
      GMTrace.o(13743492694016L, 102397);
      return false;
    }
    if (paramString.length() < 3)
    {
      paramDecodeResultLogger.setDecodeResult(1005);
      GMTrace.o(13743492694016L, 102397);
      return false;
    }
    if (!new File(paramString).exists())
    {
      paramDecodeResultLogger.setDecodeResult(1005);
      GMTrace.o(13743492694016L, 102397);
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    paramString = MMBitmapFactory.decodeFile(paramString, localOptions, paramDecodeResultLogger, 0, new int[0]);
    if (paramString != null)
    {
      v.i("MicroMsg.ImgUtil", "bitmap recycle %s", new Object[] { paramString });
      paramString.recycle();
    }
    if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0) && (paramDecodeResultLogger.getDecodeResult() == 0))
    {
      GMTrace.o(13743492694016L, 102397);
      return true;
    }
    GMTrace.o(13743492694016L, 102397);
    return false;
  }
  
  public static boolean bf(byte[] paramArrayOfByte)
  {
    GMTrace.i(13743626911744L, 102398);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(13743626911744L, 102398);
      return false;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    paramArrayOfByte = "";
    int i = 0;
    while (i < 6) {
      try
      {
        paramArrayOfByte = paramArrayOfByte + (char)localByteArrayInputStream.read();
        i += 1;
      }
      catch (IOException paramArrayOfByte)
      {
        GMTrace.o(13743626911744L, 102398);
        return false;
      }
    }
    try
    {
      localByteArrayInputStream.close();
      if (!paramArrayOfByte.startsWith("GIF"))
      {
        GMTrace.o(13743626911744L, 102398);
        return false;
      }
      GMTrace.o(13743626911744L, 102398);
      return true;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public static boolean bg(byte[] paramArrayOfByte)
  {
    GMTrace.i(13743895347200L, 102400);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
    {
      GMTrace.o(13743895347200L, 102400);
      return false;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71))
    {
      GMTrace.o(13743895347200L, 102400);
      return true;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70))
    {
      GMTrace.o(13743895347200L, 102400);
      return true;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70))
    {
      GMTrace.o(13743895347200L, 102400);
      return true;
    }
    GMTrace.o(13743895347200L, 102400);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */