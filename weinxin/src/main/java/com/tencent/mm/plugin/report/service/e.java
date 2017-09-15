package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static String filePath;
  private static Byte oSt;
  
  static
  {
    GMTrace.i(13119648694272L, 97749);
    filePath = getAppFilePath() + "/kvcomm/exception/";
    oSt = new Byte((byte)0);
    if (!com.tencent.mm.a.e.aO(filePath)) {
      com.tencent.mm.a.e.aS(filePath);
    }
    GMTrace.o(13119648694272L, 97749);
  }
  
  private static int aE(byte[] paramArrayOfByte)
  {
    int i = 0;
    GMTrace.i(13119514476544L, 97748);
    int j = 0;
    while (i < 4)
    {
      j += ((paramArrayOfByte[i] & 0xFF) << (3 - i) * 8);
      i += 1;
    }
    GMTrace.o(13119514476544L, 97748);
    return j;
  }
  
  public static void aXA()
  {
    GMTrace.i(13118709170176L, 97742);
    if (!com.tencent.mm.a.e.aO(filePath))
    {
      v.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
      GMTrace.o(13118709170176L, 97742);
      return;
    }
    File[] arrayOfFile = new File(filePath).listFiles();
    if (arrayOfFile == null)
    {
      v.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
      GMTrace.o(13118709170176L, 97742);
      return;
    }
    for (;;)
    {
      int j;
      String str;
      int i;
      synchronized (oSt)
      {
        int k = arrayOfFile.length;
        j = 0;
        if (j >= k) {
          break label910;
        }
        localObject2 = arrayOfFile[j];
        if (localObject2 == null)
        {
          v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str = ((File)localObject2).getAbsolutePath();
          i = 0;
          int m = com.tencent.mm.a.e.aN(str);
          v.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + ((File)localObject2).getAbsolutePath() + ", filelenth:" + m);
          if (i >= m)
          {
            v.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:" + str);
            com.tencent.mm.loader.stub.b.deleteFile(str);
          }
        }
      }
      Object localObject2 = com.tencent.mm.a.e.c(str, i, 4);
      if (localObject2 == null)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:" + str);
      }
      else
      {
        i += 4;
        int n = aE((byte[])localObject2);
        localObject2 = com.tencent.mm.a.e.c(str, i, n);
        if (localObject2 == null)
        {
          v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:" + str);
        }
        else
        {
          i += n;
          Object localObject3;
          if (str.contains(".statictis")) {
            localObject3 = new c();
          }
          for (;;)
          {
            boolean bool1;
            try
            {
              ((c)localObject3).aD((byte[])localObject2);
              n = ((c)localObject3).oSk;
              localObject2 = ((c)localObject3).oSl;
              bool1 = ((c)localObject3).oSd;
              boolean bool2 = ((c)localObject3).oSm;
              v.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + n + ", value:" + (String)localObject2 + ", isReportNow:" + bool2 + ", isImportant" + bool1);
              g.oSF.a(n, (String)localObject2, bool2, bool1);
              v.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:" + i);
            }
            catch (IOException localIOException1)
            {
              v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + localIOException1.getMessage());
            }
            break;
            if (str.contains(".monitor"))
            {
              localObject3 = new b();
              try
              {
                ((b)localObject3).aD(localIOException1);
                long l1 = ((b)localObject3).fxf;
                long l2 = ((b)localObject3).oSb;
                long l3 = ((b)localObject3).oSc;
                bool1 = ((b)localObject3).oSd;
                v.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
                g.oSF.a(l1, l2, l3, bool1);
              }
              catch (IOException localIOException2)
              {
                v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException2.getMessage());
              }
              break;
            }
            if (!str.contains(".group_monitor")) {
              break label884;
            }
            localObject3 = new a();
            try
            {
              ((a)localObject3).aD(localIOException2);
              ArrayList localArrayList = new ArrayList();
              bool1 = false;
              localObject3 = ((a)localObject3).oSa.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                b localb = (b)((Iterator)localObject3).next();
                IDKey localIDKey = new IDKey(localb.fxf, localb.oSb, localb.oSc);
                bool1 = localb.oSd;
                localArrayList.add(localIDKey);
                v.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.fxf + ", key:" + localb.oSb + ", value:" + localb.oSc + ", isImportant" + bool1);
              }
              g.oSF.b(localArrayList, bool1);
            }
            catch (IOException localIOException3)
            {
              v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException3.getMessage());
            }
          }
          continue;
          label884:
          v.e("MicroMsg.ReportManagerKvCheck", "invalid filename:" + str);
          continue;
          label910:
          GMTrace.o(13118709170176L, 97742);
          return;
          j += 1;
        }
      }
    }
  }
  
  private static String aXB()
  {
    GMTrace.i(13119246041088L, 97746);
    Object localObject = aa.um();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      GMTrace.o(13119246041088L, 97746);
      return "MM";
    }
    localObject = ((String)localObject).split(":");
    if (localObject.length <= 1)
    {
      GMTrace.o(13119246041088L, 97746);
      return "MM";
    }
    localObject = localObject[1];
    GMTrace.o(13119246041088L, 97746);
    return (String)localObject;
  }
  
  public static void b(int paramInt, String arg1, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13118843387904L, 97743);
    if (!com.tencent.mm.a.e.aO(filePath))
    {
      v.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1);
      GMTrace.o(13118843387904L, 97743);
      return;
    }
    v.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1);
    String str = aXB();
    if ("MM".equals(str))
    {
      v.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str + ", logId:" + paramInt + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1);
      GMTrace.o(13118843387904L, 97743);
      return;
    }
    str = filePath + str + ".statictis";
    Object localObject2 = new c();
    ((c)localObject2).oSk = paramInt;
    ((c)localObject2).oSl = ???;
    ((c)localObject2).oSd = paramBoolean2;
    ((c)localObject2).oSm = paramBoolean1;
    try
    {
      localObject2 = ((c)localObject2).toByteArray();
      if (localObject2 == null)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
        GMTrace.o(13118843387904L, 97743);
        return;
      }
    }
    catch (IOException ???)
    {
      v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + ???.getMessage());
      GMTrace.o(13118843387904L, 97743);
      return;
    }
    synchronized (oSt)
    {
      if (com.tencent.mm.a.e.e(str, rT(localObject2.length)) != 0)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str + " fail.");
        GMTrace.o(13118843387904L, 97743);
        return;
      }
      if (com.tencent.mm.a.e.e(str, (byte[])localObject2) != 0) {
        v.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str + " fail.");
      }
      GMTrace.o(13118843387904L, 97743);
      return;
    }
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GMTrace.i(13118977605632L, 97744);
    v.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!com.tencent.mm.a.e.aO(filePath))
    {
      v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      GMTrace.o(13118977605632L, 97744);
      return;
    }
    String str = aXB();
    if ("MM".equals(str))
    {
      v.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      GMTrace.o(13118977605632L, 97744);
      return;
    }
    str = filePath + str + ".monitor";
    ??? = new b();
    ((b)???).fxf = paramInt1;
    ((b)???).oSb = paramInt2;
    ((b)???).oSc = paramInt3;
    ((b)???).oSd = paramBoolean;
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = ((b)???).toByteArray();
      if (arrayOfByte == null)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
        GMTrace.o(13118977605632L, 97744);
        return;
      }
    }
    catch (IOException localIOException)
    {
      v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + localIOException.getMessage());
      GMTrace.o(13118977605632L, 97744);
      return;
    }
    synchronized (oSt)
    {
      if (com.tencent.mm.a.e.e(localIOException, rT(arrayOfByte.length)) != 0)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        GMTrace.o(13118977605632L, 97744);
        return;
      }
      if (com.tencent.mm.a.e.e(localIOException, arrayOfByte) != 0) {
        v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + localIOException + " fail.");
      }
      v.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + com.tencent.mm.a.e.aN(localIOException));
      GMTrace.o(13118977605632L, 97744);
      return;
    }
  }
  
  public static void d(ArrayList<IDKey> arg0, boolean paramBoolean)
  {
    GMTrace.i(13119111823360L, 97745);
    Object localObject1 = ???.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (IDKey)((Iterator)localObject1).next();
      v.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject3).GetID() + ", key:" + ((IDKey)localObject3).GetKey() + ", value:" + ((IDKey)localObject3).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!com.tencent.mm.a.e.aO(filePath))
    {
      v.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      GMTrace.o(13119111823360L, 97745);
      return;
    }
    localObject1 = aXB();
    if ("MM".equals(localObject1))
    {
      v.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + (String)localObject1);
      GMTrace.o(13119111823360L, 97745);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject3 = new a();
    ((a)localObject3).jLr = ???.size();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      IDKey localIDKey = (IDKey)???.next();
      b localb = new b();
      localb.fxf = ((int)localIDKey.GetID());
      localb.oSb = ((int)localIDKey.GetKey());
      localb.oSc = ((int)localIDKey.GetValue());
      localb.oSd = paramBoolean;
      ((a)localObject3).oSa.add(localb);
    }
    try
    {
      localObject3 = ((a)localObject3).toByteArray();
      if (localObject3 == null)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
        GMTrace.o(13119111823360L, 97745);
        return;
      }
    }
    catch (IOException ???)
    {
      v.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + ???.getMessage());
      GMTrace.o(13119111823360L, 97745);
      return;
    }
    synchronized (oSt)
    {
      if (com.tencent.mm.a.e.e((String)localObject1, rT(localObject3.length)) != 0)
      {
        v.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        GMTrace.o(13119111823360L, 97745);
        return;
      }
      if (com.tencent.mm.a.e.e((String)localObject1, (byte[])localObject3) != 0) {
        v.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + (String)localObject1 + " fail.");
      }
      GMTrace.o(13119111823360L, 97745);
      return;
    }
  }
  
  private static String getAppFilePath()
  {
    GMTrace.i(13118574952448L, 97741);
    Object localObject = aa.getContext();
    if (localObject == null)
    {
      GMTrace.o(13118574952448L, 97741);
      return null;
    }
    try
    {
      localObject = ((Context)localObject).getFilesDir();
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = ((File)localObject).toString();
      GMTrace.o(13118574952448L, 97741);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ReportManagerKvCheck", localException.getMessage());
      GMTrace.o(13118574952448L, 97741);
    }
    return null;
  }
  
  private static byte[] rT(int paramInt)
  {
    GMTrace.i(13119380258816L, 97747);
    int i = (byte)(paramInt >> 24 & 0xFF);
    int j = (byte)(paramInt >> 16 & 0xFF);
    int k = (byte)(paramInt >> 8 & 0xFF);
    int m = (byte)(paramInt & 0xFF);
    GMTrace.o(13119380258816L, 97747);
    return new byte[] { i, j, k, m };
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */