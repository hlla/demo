package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;

public class ShareBsDiffPatchInfo
{
  public String fFN;
  public String fvg;
  public String name;
  public String path;
  public String xfu;
  
  private ShareBsDiffPatchInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.fFN = paramString2;
    this.xfu = paramString4;
    this.fvg = paramString5;
    this.path = paramString3;
  }
  
  public static boolean a(ShareBsDiffPatchInfo paramShareBsDiffPatchInfo)
  {
    if (paramShareBsDiffPatchInfo == null) {}
    String str;
    do
    {
      return false;
      str = paramShareBsDiffPatchInfo.name;
      paramShareBsDiffPatchInfo = paramShareBsDiffPatchInfo.fFN;
    } while ((str == null) || (str.length() <= 0) || (paramShareBsDiffPatchInfo == null) || (paramShareBsDiffPatchInfo.length() != 32));
    return true;
  }
  
  public static void j(String paramString, ArrayList<ShareBsDiffPatchInfo> paramArrayList)
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
          arrayOfString = arrayOfString.split(",", 5);
          if ((arrayOfString != null) && (arrayOfString.length >= 5))
          {
            String str1 = arrayOfString[0].trim();
            String str2 = arrayOfString[1].trim();
            paramArrayList.add(new ShareBsDiffPatchInfo(str1, arrayOfString[2].trim(), str2, arrayOfString[3].trim(), arrayOfString[4].trim()));
          }
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.name);
    localStringBuffer.append(",");
    localStringBuffer.append(this.path);
    localStringBuffer.append(",");
    localStringBuffer.append(this.fFN);
    localStringBuffer.append(",");
    localStringBuffer.append(this.xfu);
    localStringBuffer.append(",");
    localStringBuffer.append(this.fvg);
    return localStringBuffer.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/shareutil/ShareBsDiffPatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */