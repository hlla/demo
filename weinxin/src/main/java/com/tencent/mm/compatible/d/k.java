package com.tencent.mm.compatible.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  private static k gQA;
  private String filePath;
  private boolean gQz;
  private Map<Integer, Object> values;
  
  static
  {
    GMTrace.i(13800401010688L, 102821);
    gQA = null;
    GMTrace.o(13800401010688L, 102821);
  }
  
  private k(String paramString)
  {
    GMTrace.i(13799729922048L, 102816);
    this.gQz = false;
    this.filePath = "";
    this.filePath = paramString;
    for (;;)
    {
      try
      {
        paramString = new File(this.filePath);
        if (!paramString.exists()) {
          paramString.createNewFile();
        }
        if (paramString.length() != 0L) {
          continue;
        }
        this.values = new HashMap();
      }
      catch (Exception paramString)
      {
        ObjectInputStream localObjectInputStream;
        this.values = new HashMap();
        v.printErrStackTrace("MicroMsg.CompatibleFileStorage", paramString, "", new Object[0]);
        continue;
      }
      this.gQz = false;
      GMTrace.o(13799729922048L, 102816);
      return;
      paramString = new FileInputStream(paramString);
      localObjectInputStream = new ObjectInputStream(paramString);
      this.values = ((Map)localObjectInputStream.readObject());
      localObjectInputStream.close();
      paramString.close();
    }
  }
  
  public static k rj()
  {
    try
    {
      GMTrace.i(13799595704320L, 102815);
      if (gQA == null) {
        gQA = new k(e.hgg + "CompatibleInfo.cfg");
      }
      k localk = gQA;
      GMTrace.o(13799595704320L, 102815);
      return localk;
    }
    finally {}
  }
  
  private void rk()
  {
    try
    {
      GMTrace.i(13800266792960L, 102820);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(this.filePath);
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localFileOutputStream);
        localObjectOutputStream.writeObject(this.values);
        localObjectOutputStream.close();
        localFileOutputStream.flush();
        localFileOutputStream.close();
        GMTrace.o(13800266792960L, 102820);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.CompatibleFileStorage", localIOException, "", new Object[0]);
          GMTrace.o(13800266792960L, 102820);
        }
      }
      return;
    }
    finally {}
  }
  
  public final Object ej(int paramInt)
  {
    GMTrace.i(13800132575232L, 102819);
    Object localObject = this.values.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      GMTrace.o(13800132575232L, 102819);
      return null;
    }
    GMTrace.o(13800132575232L, 102819);
    return localObject;
  }
  
  public final Object get(int paramInt)
  {
    GMTrace.i(13799998357504L, 102818);
    Object localObject = this.values.get(Integer.valueOf(paramInt));
    GMTrace.o(13799998357504L, 102818);
    return localObject;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    try
    {
      GMTrace.i(13799864139776L, 102817);
      this.values.put(Integer.valueOf(paramInt), paramObject);
      if (!this.gQz) {
        rk();
      }
      GMTrace.o(13799864139776L, 102817);
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */