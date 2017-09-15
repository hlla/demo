package com.tencent.mm.pluginsdk;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.k.a.a;
import com.tencent.mm.plugin.k.a.b;
import java.util.HashMap;

public final class c
{
  private static HashMap<String, Integer> szD;
  
  static
  {
    GMTrace.i(893353197568L, 6656);
    szD = null;
    GMTrace.o(893353197568L, 6656);
  }
  
  public static int LB(String paramString)
  {
    GMTrace.i(893084762112L, 6654);
    if (szD == null)
    {
      HashMap localHashMap = new HashMap();
      szD = localHashMap;
      localHashMap.put("avi", Integer.valueOf(a.b.dth));
      szD.put("m4v", Integer.valueOf(a.b.dth));
      szD.put("vob", Integer.valueOf(a.b.dth));
      szD.put("mpeg", Integer.valueOf(a.b.dth));
      szD.put("mpe", Integer.valueOf(a.b.dth));
      szD.put("asx", Integer.valueOf(a.b.dth));
      szD.put("asf", Integer.valueOf(a.b.dth));
      szD.put("f4v", Integer.valueOf(a.b.dth));
      szD.put("flv", Integer.valueOf(a.b.dth));
      szD.put("mkv", Integer.valueOf(a.b.dth));
      szD.put("wmv", Integer.valueOf(a.b.dth));
      szD.put("wm", Integer.valueOf(a.b.dth));
      szD.put("3gp", Integer.valueOf(a.b.dth));
      szD.put("mp4", Integer.valueOf(a.b.dth));
      szD.put("rmvb", Integer.valueOf(a.b.dth));
      szD.put("rm", Integer.valueOf(a.b.dth));
      szD.put("ra", Integer.valueOf(a.b.dth));
      szD.put("ram", Integer.valueOf(a.b.dth));
      szD.put("mp3pro", Integer.valueOf(a.b.dsW));
      szD.put("vqf", Integer.valueOf(a.b.dsW));
      szD.put("cd", Integer.valueOf(a.b.dsW));
      szD.put("md", Integer.valueOf(a.b.dsW));
      szD.put("mod", Integer.valueOf(a.b.dsW));
      szD.put("vorbis", Integer.valueOf(a.b.dsW));
      szD.put("au", Integer.valueOf(a.b.dsW));
      szD.put("amr", Integer.valueOf(a.b.dsW));
      szD.put("silk", Integer.valueOf(a.b.dsW));
      szD.put("wma", Integer.valueOf(a.b.dsW));
      szD.put("mmf", Integer.valueOf(a.b.dsW));
      szD.put("mid", Integer.valueOf(a.b.dsW));
      szD.put("midi", Integer.valueOf(a.b.dsW));
      szD.put("mp3", Integer.valueOf(a.b.dsW));
      szD.put("aac", Integer.valueOf(a.b.dsW));
      szD.put("ape", Integer.valueOf(a.b.dsW));
      szD.put("aiff", Integer.valueOf(a.b.dsW));
      szD.put("aif", Integer.valueOf(a.b.dsW));
      szD.put("jfif", Integer.valueOf(a.a.bbX));
      szD.put("tiff", Integer.valueOf(a.a.bbX));
      szD.put("tif", Integer.valueOf(a.a.bbX));
      szD.put("jpe", Integer.valueOf(a.a.bbX));
      szD.put("dib", Integer.valueOf(a.a.bbX));
      szD.put("jpeg", Integer.valueOf(a.a.bbX));
      szD.put("jpg", Integer.valueOf(a.a.bbX));
      szD.put("png", Integer.valueOf(a.a.bbX));
      szD.put("bmp", Integer.valueOf(a.a.bbX));
      szD.put("gif", Integer.valueOf(a.a.bbX));
      szD.put("rar", Integer.valueOf(a.b.dtc));
      szD.put("zip", Integer.valueOf(a.b.dtc));
      szD.put("7z", Integer.valueOf(a.b.dtc));
      szD.put("iso", Integer.valueOf(a.b.dtc));
      szD.put("cab", Integer.valueOf(a.b.dtc));
      szD.put("doc", Integer.valueOf(a.b.dtl));
      szD.put("docx", Integer.valueOf(a.b.dtl));
      szD.put("ppt", Integer.valueOf(a.b.dta));
      szD.put("pptx", Integer.valueOf(a.b.dta));
      szD.put("xls", Integer.valueOf(a.b.dsS));
      szD.put("xlsx", Integer.valueOf(a.b.dsS));
      szD.put("txt", Integer.valueOf(a.b.dtd));
      szD.put("rtf", Integer.valueOf(a.b.dtd));
      szD.put("pdf", Integer.valueOf(a.b.dsY));
    }
    paramString = (Integer)szD.get(paramString);
    if (paramString == null)
    {
      i = a.b.dte;
      GMTrace.o(893084762112L, 6654);
      return i;
    }
    int i = paramString.intValue();
    GMTrace.o(893084762112L, 6654);
    return i;
  }
  
  public static int bCe()
  {
    GMTrace.i(15683207299072L, 116849);
    int i = a.b.dte;
    GMTrace.o(15683207299072L, 116849);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */