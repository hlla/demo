package com.google.android.gms.ads.internal.mediation;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.client.e;
import com.google.android.gms.ads.internal.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class k
{
  public static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (e.b()) {
        str = "fakeForAdDebugLog";
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "";
    }
    return paramString1.replaceAll(paramString2, str);
  }
  
  public static List a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramString.add(paramJSONObject.getString(i));
        i += 1;
      }
      return Collections.unmodifiableList(paramString);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, com.google.android.gms.ads.internal.v.a parama, String paramString2, boolean paramBoolean, List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (!paramBoolean) {}
      for (String str = "0";; str = "1")
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = a(a(a(a(a(a(a((String)localIterator.next(), "@gw_adlocid@", paramString2), "@gw_adnetrefresh@", str), "@gw_qdata@", parama.E.q), "@gw_sdkver@", paramString1), "@gw_sessid@", u.h.i), "@gw_seqnum@", parama.O), "@gw_adnetstatus@", parama.D);
          b localb = parama.A;
          paramList = (List)localObject;
          if (localb != null) {
            paramList = a(a((String)localObject, "@gw_adnetid@", localb.d), "@gw_allocid@", parama.A.g);
          }
          paramList = com.google.android.gms.ads.internal.s.c.a(paramList, parama.N);
          localObject = bt.A.e;
          n.a(paramContext, paramString1, paramList);
        }
      }
    }
  }
  
  public static boolean a(String paramString, int[] paramArrayOfInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramArrayOfInt.length == 2)
      {
        paramString = paramString.split("x");
        if (paramString.length != 2) {}
      }
    }
    try
    {
      paramArrayOfInt[0] = Integer.parseInt(paramString[0]);
      paramArrayOfInt[1] = Integer.parseInt(paramString[1]);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
    return false;
    return false;
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */