package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  public b wWA = null;
  public b wWB = null;
  
  public static boolean a(b paramb1, b paramb2)
  {
    if ((paramb1 != null) && (paramb1.iyt != null) && (paramb2 != null) && (paramb2.iyt != null))
    {
      Object localObject1 = paramb1.iyt;
      paramb1 = paramb2.iyt;
      paramb2 = ((Map)localObject1).entrySet().iterator();
      while (paramb2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramb2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (a)paramb1.get(localObject1);
          if ((((a)localObject2).kFe != ((a)localObject1).kFe) || (((a)localObject2).wWC != ((a)localObject1).wWC)) {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  final class a
  {
    long kFe;
    private String mName;
    long wWC;
    
    a(String paramString, long paramLong1, long paramLong2)
    {
      this.mName = paramString;
      this.kFe = paramLong1;
      this.wWC = paramLong2;
    }
  }
  
  public final class b
  {
    public Map<String, s.a> iyt = new HashMap();
    
    public b(File paramFile)
    {
      this.iyt.clear();
      M(paramFile);
    }
    
    private void M(File paramFile)
    {
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int i = 0;
        while (i < paramFile.length)
        {
          M(paramFile[i]);
          i += 1;
        }
      }
      if (paramFile.isFile())
      {
        String str = paramFile.getName();
        long l1 = paramFile.length();
        long l2 = paramFile.lastModified();
        if ((str != null) && (str.length() > 0) && (l1 > 0L) && (l2 > 0L))
        {
          paramFile = new s.a(s.this, str, l1, l2);
          if (!this.iyt.containsKey(str)) {
            this.iyt.put(str, paramFile);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/utils/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */