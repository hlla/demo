package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.formats.a.f;
import com.google.android.gms.ads.internal.formats.k;
import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.mediation.b;
import com.google.android.gms.ads.internal.mediation.client.n;
import com.google.android.gms.ads.internal.mediation.client.q;
import com.google.android.gms.ads.internal.webview.ao;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class aq
{
  public static View a(com.google.android.gms.ads.internal.v.a parama)
  {
    if (parama == null)
    {
      com.google.android.gms.ads.internal.util.e.c("AdState is null");
      return null;
    }
    if (b(parama))
    {
      com.google.android.gms.ads.internal.webview.i locali = parama.g;
      if (locali != null) {
        return locali.getView();
      }
    }
    try
    {
      parama = parama.B;
      if (parama != null) {}
      for (parama = parama.a();; parama = null)
      {
        if (parama != null) {
          return (View)com.google.android.gms.dynamic.e.a(parama);
        }
        com.google.android.gms.ads.internal.util.e.e("View in mediation adapter is null.");
        return null;
      }
      return null;
    }
    catch (RemoteException parama)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not get View from mediation adapter.", parama);
    }
  }
  
  static com.google.android.gms.ads.internal.formats.a.e a(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return f.a((IBinder)paramObject);
    }
    return null;
  }
  
  static u a(n paramn, q paramq, aa paramaa)
  {
    return new av(paramn, paramaa, paramq);
  }
  
  private static String a(Bitmap paramBitmap)
  {
    Object localObject = new ByteArrayOutputStream();
    if (paramBitmap == null)
    {
      com.google.android.gms.ads.internal.util.e.e("Bitmap is null. Returning empty string");
      return "";
    }
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
    localObject = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
    paramBitmap = String.valueOf("data:image/png;base64,");
    localObject = String.valueOf(localObject);
    if (((String)localObject).length() == 0) {
      return new String(paramBitmap);
    }
    return paramBitmap.concat((String)localObject);
  }
  
  static String a(com.google.android.gms.ads.internal.formats.a.e parame)
  {
    if (parame != null)
    {
      try
      {
        Object localObject = parame.b();
        if (localObject != null)
        {
          localObject = ((Uri)localObject).toString();
          return (String)localObject;
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.e("Unable to get image uri. Trying data uri next");
      }
      return b(parame);
    }
    com.google.android.gms.ads.internal.util.e.e("Image is null. Returning empty string");
    return "";
  }
  
  static JSONObject a(Bundle paramBundle, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (paramBundle.containsKey(str)) {
          if ("image".equals(paramString.getString(str)))
          {
            Object localObject = paramBundle.get(str);
            if ((localObject instanceof Bitmap)) {
              localJSONObject.put(str, a((Bitmap)localObject));
            } else {
              com.google.android.gms.ads.internal.util.e.e("Invalid type. An image type extra should return a bitmap");
            }
          }
          else if ((paramBundle.get(str) instanceof Bitmap))
          {
            com.google.android.gms.ads.internal.util.e.e("Invalid asset type. Bitmap should be returned only for image type");
          }
          else
          {
            localJSONObject.put(str, String.valueOf(paramBundle.get(str)));
          }
        }
      }
      return localJSONObject;
    }
    return localJSONObject;
  }
  
  public static boolean a(com.google.android.gms.ads.internal.webview.i parami, com.google.android.gms.ads.internal.mediation.i parami1, CountDownLatch paramCountDownLatch)
  {
    for (;;)
    {
      try
      {
        localObject1 = parami.getView();
        if (localObject1 != null) {
          continue;
        }
        com.google.android.gms.ads.internal.util.e.e("AdWebView is null");
        bool = false;
      }
      catch (RemoteException parami)
      {
        Object localObject2;
        Object localObject3;
        List localList;
        String str1;
        com.google.android.gms.ads.internal.formats.a.e locale;
        String str2;
        String str3;
        Object localObject4;
        com.google.android.gms.ads.internal.util.e.e("Unable to invoke load assets", parami);
        boolean bool = false;
        continue;
        localObject1 = null;
        continue;
      }
      catch (RuntimeException parami)
      {
        paramCountDownLatch.countDown();
        throw parami;
      }
      if (!bool) {
        paramCountDownLatch.countDown();
      }
      return bool;
      ((View)localObject1).setVisibility(4);
      localObject1 = parami1.b.t;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        continue;
      }
      com.google.android.gms.ads.internal.util.e.e("No template ids present in mediation response");
      bool = false;
    }
    parami.a("/nativeExpressAssetsLoaded", new at(paramCountDownLatch));
    parami.a("/nativeExpressAssetsLoadingFailed", new au(paramCountDownLatch));
    localObject2 = parami1.c.h();
    localObject3 = parami1.c.i();
    if (!((List)localObject1).contains("2"))
    {
      label140:
      if (!((List)localObject1).contains("1")) {}
      while (localObject3 == null)
      {
        com.google.android.gms.ads.internal.util.e.e("No matching template id and mapper");
        bool = false;
        break;
      }
      localObject2 = ((q)localObject3).a();
      localList = ((q)localObject3).b();
      str1 = ((q)localObject3).c();
      locale = ((q)localObject3).d();
      str2 = ((q)localObject3).e();
      str3 = ((q)localObject3).f();
      localObject4 = ((q)localObject3).j();
      if (((q)localObject3).n() == null) {
        break label600;
      }
    }
    label587:
    label600:
    for (Object localObject1 = (View)com.google.android.gms.dynamic.e.a(((q)localObject3).n());; localObject1 = null)
    {
      localObject1 = new k((String)localObject2, localList, str1, locale, str2, str3, null, (Bundle)localObject4, null, (View)localObject1, ((q)localObject3).o(), null);
      localObject2 = parami1.b.h;
      parami.getAdWebViewClient().a(new as((k)localObject1, (String)localObject2, parami));
      for (;;)
      {
        localObject1 = parami1.b;
        parami1 = ((b)localObject1).j;
        localObject1 = ((b)localObject1).a;
        if (localObject1 != null)
        {
          parami.loadDataWithBaseURL((String)localObject1, parami1, "text/html", "UTF-8", null);
          bool = true;
          break;
        }
        parami.loadData(parami1, "text/html", "UTF-8");
        bool = true;
        break;
        if (localObject2 == null) {
          break label140;
        }
        localObject3 = ((n)localObject2).a();
        localList = ((n)localObject2).b();
        str1 = ((n)localObject2).c();
        locale = ((n)localObject2).d();
        str2 = ((n)localObject2).e();
        double d = ((n)localObject2).f();
        str3 = ((n)localObject2).g();
        localObject4 = ((n)localObject2).h();
        Bundle localBundle = ((n)localObject2).l();
        if (((n)localObject2).p() == null) {
          break label587;
        }
        localObject1 = (View)com.google.android.gms.dynamic.e.a(((n)localObject2).p());
        localObject1 = new com.google.android.gms.ads.internal.formats.i((String)localObject3, localList, str1, locale, str2, d, str3, (String)localObject4, null, localBundle, null, (View)localObject1, ((n)localObject2).q(), null);
        localObject2 = parami1.b.h;
        parami.getAdWebViewClient().a(new ar((com.google.android.gms.ads.internal.formats.i)localObject1, (String)localObject2, parami));
      }
    }
  }
  
  private static String b(com.google.android.gms.ads.internal.formats.a.e parame)
  {
    try
    {
      parame = parame.a();
      if (parame != null)
      {
        parame = (Drawable)com.google.android.gms.dynamic.e.a(parame);
        if (!(parame instanceof BitmapDrawable))
        {
          com.google.android.gms.ads.internal.util.e.e("Drawable is not an instance of BitmapDrawable. Returning empty string");
          return "";
        }
        return a(((BitmapDrawable)parame).getBitmap());
      }
      com.google.android.gms.ads.internal.util.e.e("Drawable is null. Returning empty string");
      return "";
    }
    catch (RemoteException parame)
    {
      com.google.android.gms.ads.internal.util.e.e("Unable to get drawable. Returning empty string");
    }
    return "";
  }
  
  public static boolean b(com.google.android.gms.ads.internal.v.a parama)
  {
    if ((parama != null) && (parama.u))
    {
      parama = parama.A;
      if ((parama != null) && (parama.j != null)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */