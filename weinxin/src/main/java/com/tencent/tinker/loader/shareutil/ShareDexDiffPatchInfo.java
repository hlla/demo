package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo
{
  public final String gTO;
  public final String path;
  public final String xfA;
  public final String xfB;
  public final String xfC;
  public final boolean xfD;
  public final String xfw;
  public final String xfx;
  public final String xfy;
  public final String xfz;
  
  public ShareDexDiffPatchInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.xfw = paramString1;
    this.path = paramString2;
    this.xfx = paramString3;
    this.xfy = paramString4;
    this.xfB = paramString5;
    this.xfz = paramString6;
    this.xfA = paramString7;
    this.xfC = paramString8;
    if (paramString8.equals("jar"))
    {
      this.xfD = true;
      if (SharePatchFileUtil.VR(paramString1))
      {
        this.gTO = (paramString1 + ".jar");
        return;
      }
      this.gTO = paramString1;
      return;
    }
    if (paramString8.equals("raw"))
    {
      this.xfD = false;
      this.gTO = paramString1;
      return;
    }
    throw new TinkerRuntimeException("can't recognize dex mode:" + paramString8);
  }
  
  public static boolean c(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (paramShareDexDiffPatchInfo == null) {}
    for (;;)
    {
      return false;
      String str = paramShareDexDiffPatchInfo.xfw;
      if (ShareTinkerInternals.cgK()) {}
      for (paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.xfy; (str != null) && (str.length() > 0) && (paramShareDexDiffPatchInfo != null) && (paramShareDexDiffPatchInfo.length() == 32); paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.xfx) {
        return true;
      }
    }
  }
  
  public static void k(String paramString, ArrayList<ShareDexDiffPatchInfo> paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\n");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (arrayOfString.length() > 0))
        {
          arrayOfString = arrayOfString.split(",", 8);
          if ((arrayOfString != null) && (arrayOfString.length >= 8)) {
            paramArrayList.add(new ShareDexDiffPatchInfo(arrayOfString[0].trim(), arrayOfString[1].trim(), arrayOfString[2].trim(), arrayOfString[3].trim(), arrayOfString[4].trim(), arrayOfString[5].trim(), arrayOfString[6].trim(), arrayOfString[7].trim()));
          }
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.xfw);
    localStringBuffer.append(",");
    localStringBuffer.append(this.path);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfx);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfy);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfz);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfA);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfB);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfC);
    return localStringBuffer.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */