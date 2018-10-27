package com.google.android.gms.ads.internal.webview;

import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class aj
{
  private static final Pattern a = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
  private static final Pattern b = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);
  
  public static String a()
  {
    Object localObject = (String)n.aY.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", localObject);
      localJSONObject.put("sdk", "Google Mobile Ads");
      localJSONObject.put("sdkVersion", "12.4.51-000");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<script>");
      ((StringBuilder)localObject).append("Object.defineProperty(window,'MRAID_ENV',{get:function(){return ");
      ((StringBuilder)localObject).append(localJSONObject.toString());
      ((StringBuilder)localObject).append("}});");
      ((StringBuilder)localObject).append("</script>");
      return ((StringBuilder)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      e.e("Unable to build MRAID_ENV", localJSONException);
    }
    return null;
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    int j = 0;
    int i = 0;
    int k = paramVarArgs.length;
    Object localObject1 = paramString;
    Object localObject2;
    if (k != 0)
    {
      localObject1 = new StringBuilder();
      localObject2 = a.matcher(paramString);
      if (!((Matcher)localObject2).find()) {
        break label115;
      }
      j = ((Matcher)localObject2).end();
      ((StringBuilder)localObject1).append(paramString.substring(0, j));
      if (i < k) {
        break label87;
      }
      ((StringBuilder)localObject1).append(paramString.substring(j));
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
      label87:
      localObject2 = paramVarArgs[i];
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject1).append((String)localObject2);
      }
      label115:
      i = j;
      if (!b.matcher(paramString).find()) {
        break label140;
      }
      ((StringBuilder)localObject1).append(paramString);
    }
    label140:
    if (i < k)
    {
      localObject2 = paramVarArgs[i];
      if (localObject2 != null) {
        break label163;
      }
    }
    for (;;)
    {
      i += 1;
      break label140;
      break;
      label163:
      ((StringBuilder)localObject1).append((String)localObject2);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */