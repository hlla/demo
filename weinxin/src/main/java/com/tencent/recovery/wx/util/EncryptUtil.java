package com.tencent.recovery.wx.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class EncryptUtil
{
  public static int a(PByteArray paramPByteArray, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return 2;
    }
    if ((paramArrayOfByte1.length < 0) || (paramArrayOfByte2.length <= 0)) {
      return 2;
    }
    int i = 8 - paramArrayOfByte1.length % 8;
    if (i == 0) {
      i = 8;
    }
    for (;;)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + i];
      int j = 0;
      while (j < paramArrayOfByte1.length)
      {
        arrayOfByte[j] = paramArrayOfByte1[j];
        j += 1;
      }
      j = 0;
      while (j < i)
      {
        arrayOfByte[(paramArrayOfByte1.length + j)] = ((byte)i);
        j += 1;
      }
      paramPByteArray.value = new byte[paramArrayOfByte1.length + i + 32];
      if (MyDES.a(paramPByteArray.value, arrayOfByte, arrayOfByte.length, paramArrayOfByte2.length, paramArrayOfByte2) == 0) {
        return 11;
      }
      paramArrayOfByte1 = new byte[paramArrayOfByte1.length + i + 8];
      i = 0;
      while (i < paramArrayOfByte1.length)
      {
        paramArrayOfByte1[i] = paramPByteArray.value[i];
        i += 1;
      }
      paramPByteArray.value = paramArrayOfByte1;
      return 0;
    }
  }
  
  public static byte[] i(byte[] paramArrayOfByte, String paramString)
  {
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramString);
    int k = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    int i = 0;
    if (k - i > 0)
    {
      if (k - i > 128) {}
      for (paramString = localCipher.doFinal(paramArrayOfByte, i, 128);; paramString = localCipher.doFinal(paramArrayOfByte, i, k - i))
      {
        localByteArrayOutputStream.write(paramString, 0, paramString.length);
        j += 1;
        i = j * 128;
        break;
      }
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  /* Error */
  public static byte[] l(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 86	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 87	java/util/zip/Deflater:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 90	java/util/zip/Deflater:reset	()V
    //   14: aload 4
    //   16: aload_0
    //   17: invokevirtual 93	java/util/zip/Deflater:setInput	([B)V
    //   20: aload 4
    //   22: invokevirtual 96	java/util/zip/Deflater:finish	()V
    //   25: new 60	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: aload_0
    //   30: arraylength
    //   31: invokespecial 99	java/io/ByteArrayOutputStream:<init>	(I)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: sipush 1024
    //   40: newarray <illegal type>
    //   42: astore_3
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 103	java/util/zip/Deflater:finished	()Z
    //   50: ifne +54 -> 104
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: aload_3
    //   57: iconst_0
    //   58: aload 4
    //   60: aload_3
    //   61: invokevirtual 107	java/util/zip/Deflater:deflate	([B)I
    //   64: invokevirtual 69	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -24 -> 43
    //   70: astore_3
    //   71: aload_2
    //   72: astore_1
    //   73: ldc 109
    //   75: aload_3
    //   76: ldc 111
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 117	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 76	java/io/ByteArrayOutputStream:close	()V
    //   95: aload_0
    //   96: astore_1
    //   97: aload 4
    //   99: invokevirtual 120	java/util/zip/Deflater:end	()V
    //   102: aload_1
    //   103: areturn
    //   104: aload_2
    //   105: astore_1
    //   106: aload_2
    //   107: invokevirtual 73	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: astore_3
    //   111: aload_3
    //   112: astore_1
    //   113: aload_2
    //   114: invokevirtual 76	java/io/ByteArrayOutputStream:close	()V
    //   117: goto -20 -> 97
    //   120: astore_0
    //   121: ldc 109
    //   123: aload_0
    //   124: ldc 111
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 117	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: goto -36 -> 97
    //   136: astore_1
    //   137: ldc 109
    //   139: aload_1
    //   140: ldc 111
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 117	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: astore_1
    //   151: goto -54 -> 97
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_1
    //   157: new 82	java/lang/OutOfMemoryError
    //   160: dup
    //   161: new 122	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 124
    //   167: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: arraylength
    //   172: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 136	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   181: athrow
    //   182: astore_0
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 76	java/io/ByteArrayOutputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: ldc 109
    //   196: aload_1
    //   197: ldc 111
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 117	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -15 -> 191
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -29 -> 183
    //   215: astore_1
    //   216: aload_2
    //   217: astore_1
    //   218: goto -61 -> 157
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_2
    //   224: goto -153 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramArrayOfByte	byte[]
    //   36	77	1	localObject1	Object
    //   136	4	1	localIOException1	java.io.IOException
    //   150	1	1	arrayOfByte1	byte[]
    //   154	1	1	localOutOfMemoryError1	OutOfMemoryError
    //   156	32	1	localObject2	Object
    //   193	4	1	localIOException2	java.io.IOException
    //   211	1	1	localObject3	Object
    //   215	1	1	localOutOfMemoryError2	OutOfMemoryError
    //   217	1	1	localByteArrayOutputStream1	ByteArrayOutputStream
    //   34	190	2	localByteArrayOutputStream2	ByteArrayOutputStream
    //   42	19	3	arrayOfByte2	byte[]
    //   70	6	3	localException1	Exception
    //   110	2	3	arrayOfByte3	byte[]
    //   221	1	3	localException2	Exception
    //   7	91	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   37	43	70	java/lang/Exception
    //   45	53	70	java/lang/Exception
    //   55	67	70	java/lang/Exception
    //   106	111	70	java/lang/Exception
    //   113	117	120	java/io/IOException
    //   91	95	136	java/io/IOException
    //   25	35	154	java/lang/OutOfMemoryError
    //   37	43	182	finally
    //   45	53	182	finally
    //   55	67	182	finally
    //   73	85	182	finally
    //   106	111	182	finally
    //   157	182	182	finally
    //   187	191	193	java/io/IOException
    //   25	35	209	finally
    //   37	43	215	java/lang/OutOfMemoryError
    //   45	53	215	java/lang/OutOfMemoryError
    //   55	67	215	java/lang/OutOfMemoryError
    //   106	111	215	java/lang/OutOfMemoryError
    //   25	35	221	java/lang/Exception
  }
  
  public static final String n(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 97;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 98;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 99;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 100;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 101;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 102;
    tmp94_88;
    for (;;)
    {
      Object localObject;
      int k;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < k)
      {
        int m = paramArrayOfByte[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/wx/util/EncryptUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */