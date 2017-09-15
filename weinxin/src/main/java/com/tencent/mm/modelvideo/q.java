package com.tencent.mm.modelvideo;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;

public final class q
{
  private static String D(byte[] paramArrayOfByte)
  {
    GMTrace.i(333799489536L, 2487);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfByte.length <= 0)
    {
      GMTrace.o(333799489536L, 2487);
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    GMTrace.o(333799489536L, 2487);
    return paramArrayOfByte;
  }
  
  public static boolean lp(String paramString)
  {
    GMTrace.i(333933707264L, 2488);
    v.d("MicroMsg.VideoFile", " filepath " + paramString);
    if (bf.mA(paramString))
    {
      GMTrace.o(333933707264L, 2488);
      return false;
    }
    try
    {
      paramString = new FileInputStream(paramString);
      Object localObject = new byte[10];
      paramString.read((byte[])localObject, 0, 10);
      localObject = D((byte[])localObject).toUpperCase();
      paramString.close();
      v.d("MicroMsg.VideoFile", "file type " + (String)localObject);
      if (((String)localObject).contains("00000014667479707174"))
      {
        v.d("MicroMsg.VideoFile", "file type qt ");
        GMTrace.o(333933707264L, 2488);
        return true;
      }
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.VideoFile", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(333933707264L, 2488);
    }
    return false;
  }
  
  public static boolean lq(String paramString)
  {
    GMTrace.i(17479308935168L, 130231);
    if (!e.aO(paramString))
    {
      GMTrace.o(17479308935168L, 130231);
      return false;
    }
    v.d("MicroMsg.VideoFile", "check is h265 video %s", new Object[] { paramString });
    try
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      localMediaExtractor.setDataSource(paramString);
      int j = localMediaExtractor.getTrackCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = null;
        try
        {
          String str = localMediaExtractor.getTrackFormat(i).getString("mime");
          localObject = str;
          bool = "video/hevc".equalsIgnoreCase(str);
          localObject = str;
          if (bool)
          {
            GMTrace.o(17479308935168L, 130231);
            return true;
          }
        }
        catch (Throwable localThrowable2)
        {
          v.printErrStackTrace("MicroMsg.VideoFile", localThrowable2, "check is h265 video %s", new Object[] { paramString });
          boolean bool = "video/hevc".equalsIgnoreCase((String)localObject);
          if (bool)
          {
            GMTrace.o(17479308935168L, 130231);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable1)
    {
      v.printErrStackTrace("MicroMsg.VideoFile", localThrowable1, "check is h265 video %s", new Object[] { paramString });
      GMTrace.o(17479308935168L, 130231);
    }
  }
  
  public static boolean lr(String paramString)
  {
    GMTrace.i(17479443152896L, 130232);
    v.d("MicroMsg.VideoFile", " filepath " + paramString);
    if (bf.mA(paramString))
    {
      GMTrace.o(17479443152896L, 130232);
      return false;
    }
    try
    {
      paramString = new FileInputStream(paramString);
      Object localObject = new byte[7];
      paramString.read((byte[])localObject, 0, 7);
      localObject = D((byte[])localObject).toUpperCase();
      paramString.close();
      v.d("MicroMsg.VideoFile", "file type " + (String)localObject);
      if (((String)localObject).contains("234558544D3355"))
      {
        v.d("MicroMsg.VideoFile", "it is m3u8 file");
        GMTrace.o(17479443152896L, 130232);
        return true;
      }
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.VideoFile", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(17479443152896L, 130232);
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */