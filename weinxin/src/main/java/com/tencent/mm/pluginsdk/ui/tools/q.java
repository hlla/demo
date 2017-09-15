package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.gmtrace.GMTrace;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
{
  static Pattern sWd;
  String aGN;
  String iNt;
  String sWa;
  String sWb;
  int sWc;
  
  static
  {
    GMTrace.i(1060320051200L, 7900);
    sWd = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    GMTrace.o(1060320051200L, 7900);
  }
  
  public q(String paramString)
  {
    GMTrace.i(1060051615744L, 7898);
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.sWa = "";
    this.sWb = "";
    this.sWc = -1;
    this.aGN = "/";
    this.iNt = "";
    paramString = sWd.matcher(paramString);
    String str;
    if (paramString.matches())
    {
      str = paramString.group(1);
      if (str != null) {
        this.sWa = str.toLowerCase();
      }
      str = paramString.group(2);
      if (str != null) {
        this.iNt = str;
      }
      str = paramString.group(3);
      if (str != null) {
        this.sWb = str;
      }
      str = paramString.group(4);
      if ((str == null) || (str.length() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        this.sWc = Integer.parseInt(str);
        paramString = paramString.group(5);
        if ((paramString != null) && (paramString.length() > 0))
        {
          if (paramString.charAt(0) == '/') {
            this.aGN = paramString;
          }
        }
        else
        {
          if ((this.sWc != 443) || (!this.sWa.equals(""))) {
            break label274;
          }
          this.sWa = "https";
          if (this.sWa.equals("")) {
            this.sWa = "http";
          }
          GMTrace.o(1060051615744L, 7898);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        throw new Exception("Bad port");
      }
      this.aGN = ("/" + paramString);
      continue;
      throw new Exception("Bad address");
      label274:
      if (this.sWc == -1) {
        if (this.sWa.equals("https")) {
          this.sWc = 443;
        } else {
          this.sWc = 80;
        }
      }
    }
  }
  
  public final String toString()
  {
    GMTrace.i(1060185833472L, 7899);
    String str2 = "";
    if ((this.sWc == 443) || (!this.sWa.equals("https")))
    {
      str1 = str2;
      if (this.sWc != 80)
      {
        str1 = str2;
        if (!this.sWa.equals("http")) {}
      }
    }
    else
    {
      str1 = ":" + Integer.toString(this.sWc);
    }
    str2 = "";
    if (this.iNt.length() > 0) {
      str2 = this.iNt + "@";
    }
    String str1 = this.sWa + "://" + str2 + this.sWb + str1 + this.aGN;
    GMTrace.o(1060185833472L, 7899);
    return str1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */