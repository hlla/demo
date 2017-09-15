package com.tencent.mm.pluginsdk.ui.d;

import com.tencent.gmtrace.GMTrace;
import java.util.regex.Pattern;

public final class g
{
  public static final class a
  {
    public static final Pattern sRE;
    public static final Pattern sRF;
    public static final Pattern sRG;
    public static final Pattern sRH;
    public static final Pattern sRI;
    public static final Pattern sRJ;
    public static final Pattern sRK;
    public static final Pattern sRL;
    public static final Pattern sRM;
    public static final Pattern sRN;
    public static final Pattern sRO;
    public static final Pattern sRP;
    public static final Pattern sRQ;
    
    static
    {
      GMTrace.i(1208764858368L, 9006);
      sRE = Pattern.compile("<a.+?href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.+?)</a>");
      sRF = Pattern.compile("<_wc_custom_link_.+?color\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.+?)</_wc_custom_link_>");
      sRG = Pattern.compile("<_wc_custom_link_.+?\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.+?)</_wc_custom_link_>");
      sRH = Pattern.compile("<img.+?src=\"(.+?).png\"/>\\s*");
      sRI = Pattern.compile("weixin://\\S+");
      sRJ = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([-_a-zA-Z0-9]([-_a-zA-Z0-9\\-]{0,61}[-_a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,6}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[-_a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?", 2);
      sRK = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
      sRL = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9._-]+\\.[A-Z]+", 2);
      sRM = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})");
      sRN = Pattern.compile("weixin://wxpay/\\S+");
      sRO = Pattern.compile("weixin://dl/\\w+");
      sRP = Pattern.compile("weixin://dl/business(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~%\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
      sRQ = Pattern.compile("\\d{1,5}\\s(\\w+[\\s,.]*){2,8}\\s\\d{5}(-\\d{4})?([\\s,]*USA)?", 2);
      GMTrace.o(1208764858368L, 9006);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */