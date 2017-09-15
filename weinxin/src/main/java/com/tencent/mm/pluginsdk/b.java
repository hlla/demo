package com.tencent.mm.pluginsdk;

import com.tencent.gmtrace.GMTrace;
import java.util.HashMap;

public final class b
{
  public static final class a
  {
    public static final HashMap<String, Long> szB;
    
    static
    {
      GMTrace.i(1251043442688L, 9321);
      HashMap localHashMap = new HashMap();
      szB = localHashMap;
      localHashMap.put("doc", Long.valueOf(64L));
      szB.put("docx", Long.valueOf(128L));
      szB.put("ppt", Long.valueOf(256L));
      szB.put("pptx", Long.valueOf(512L));
      szB.put("xls", Long.valueOf(1024L));
      szB.put("xlsx", Long.valueOf(2048L));
      szB.put("pdf", Long.valueOf(4096L));
      szB.put("1", Long.valueOf(1L));
      szB.put("3", Long.valueOf(2L));
      szB.put("48", Long.valueOf(4L));
      szB.put("43", Long.valueOf(8L));
      szB.put("mp3", Long.valueOf(16L));
      szB.put("wav", Long.valueOf(16L));
      szB.put("wma", Long.valueOf(16L));
      szB.put("avi", Long.valueOf(8L));
      szB.put("rmvb", Long.valueOf(8L));
      szB.put("rm", Long.valueOf(8L));
      szB.put("mpg", Long.valueOf(8L));
      szB.put("mpeg", Long.valueOf(8L));
      szB.put("wmv", Long.valueOf(8L));
      szB.put("mp4", Long.valueOf(8L));
      szB.put("mkv", Long.valueOf(8L));
      GMTrace.o(1251043442688L, 9321);
    }
    
    public static Long LA(String paramString)
    {
      GMTrace.i(1250909224960L, 9320);
      if (paramString == null)
      {
        GMTrace.o(1250909224960L, 9320);
        return null;
      }
      paramString = (Long)szB.get(paramString.toLowerCase());
      GMTrace.o(1250909224960L, 9320);
      return paramString;
    }
  }
  
  public static final class b
  {
    public static final HashMap<Integer, Integer> szC;
    
    static
    {
      GMTrace.i(1232521396224L, 9183);
      HashMap localHashMap = new HashMap();
      szC = localHashMap;
      localHashMap.put(Integer.valueOf(22), Integer.valueOf(64));
      szC.put(Integer.valueOf(9), Integer.valueOf(64));
      szC.put(Integer.valueOf(3), Integer.valueOf(64));
      szC.put(Integer.valueOf(23), Integer.valueOf(64));
      szC.put(Integer.valueOf(25), Integer.valueOf(64));
      szC.put(Integer.valueOf(13), Integer.valueOf(64));
      szC.put(Integer.valueOf(29), Integer.valueOf(256));
      szC.put(Integer.valueOf(34), Integer.valueOf(512));
      szC.put(Integer.valueOf(6), Integer.valueOf(512));
      szC.put(Integer.valueOf(35), Integer.valueOf(1024));
      szC.put(Integer.valueOf(36), Integer.valueOf(4096));
      szC.put(Integer.valueOf(37), Integer.valueOf(32768));
      szC.put(Integer.valueOf(38), Integer.valueOf(32768));
      szC.put(Integer.valueOf(42), Integer.valueOf(131072));
      szC.put(Integer.valueOf(40), Integer.valueOf(65536));
      szC.put(Integer.valueOf(41), Integer.valueOf(65536));
      szC.put(Integer.valueOf(46), Integer.valueOf(262144));
      GMTrace.o(1232521396224L, 9183);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */