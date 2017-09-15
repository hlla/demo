package ct;

import android.content.Context;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class av
{
  private static int a = 5;
  private static int b = 15;
  private static List c;
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    Context localContext = p.a;
    paramString = i.a(paramString);
    a(paramHashMap);
    paramString.a(paramHashMap);
    if (c == null) {
      c = new ArrayList();
    }
    c.add(paramString);
    if (ar.b(p.a))
    {
      paramString = p.a;
      paramString = i.a("rqd_applaunched");
      paramHashMap = new HashMap();
      a(paramHashMap);
      if (!ar.b(p.a)) {
        break label129;
      }
      paramHashMap.put("A21", "Y");
    }
    for (;;)
    {
      paramString.a(paramHashMap);
      c.add(paramString);
      if (c.size() >= a) {
        a(c);
      }
      return;
      label129:
      paramHashMap.put("A21", "N");
    }
  }
  
  private static void a(HashMap paramHashMap)
  {
    as localas = as.k();
    if (localas != null)
    {
      paramHashMap.put("A1", p.e);
      paramHashMap.put("A2", localas.d());
      paramHashMap.put("A4", localas.f());
      paramHashMap.put("A6", localas.g());
      paramHashMap.put("A7", localas.h());
      paramHashMap.put("A23", p.f);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = p.a;
      Object localObject1 = "null";
      if (at.a((Context)localObject2) != null)
      {
        localObject2 = at.f((Context)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
      paramHashMap.put("A33", (String)localObject1);
      paramHashMap.put("A10", localas.j());
      paramHashMap.put("A9", localas.i());
      paramHashMap.put("A19", bc.b);
      paramHashMap.put("A20", bc.c);
    }
  }
  
  private static void a(List paramList)
  {
    try
    {
      localObject1 = new StringBuilder();
      localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        ((StringBuilder)localObject1).append(i.a((au)paramList.next()));
      }
      paramList = i.a(((StringBuilder)localObject1).toString().getBytes());
      localObject1 = new aq("ABC1234567890DEF".getBytes()).a(paramList);
      if (localObject1.length <= 0) {
        break label220;
      }
      paramList = new URL("http://zxcv.3g.qq.com/sdk/beacon.jsp?type=real&size=" + localObject1.length);
      localObject2 = bc.g();
      if (localObject2 == null) {
        break label253;
      }
      paramList = (HttpURLConnection)paramList.openConnection((Proxy)localObject2);
    }
    catch (OutOfMemoryError paramList)
    {
      for (;;)
      {
        Object localObject1;
        ArrayList localArrayList;
        Object localObject2;
        label220:
        c.clear();
        return;
        label253:
        paramList = (HttpURLConnection)paramList.openConnection();
      }
    }
    catch (Exception paramList) {}
    paramList.setConnectTimeout(15000);
    paramList.setReadTimeout(15000);
    paramList.setUseCaches(false);
    paramList.setDoInput(true);
    paramList.setInstanceFollowRedirects(false);
    paramList.setDoOutput(true);
    if (localObject1 != null)
    {
      paramList.setRequestMethod("POST");
      localObject2 = new DataOutputStream(paramList.getOutputStream());
      ((DataOutputStream)localObject2).write((byte[])localObject1);
      ((DataOutputStream)localObject2).close();
    }
    if (paramList.getResponseCode() == 200) {
      c.removeAll(localArrayList);
    }
    if (c.size() >= b)
    {
      c.clear();
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */