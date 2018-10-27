package com.google.android.gms.ads.internal.m;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class l
  extends m
  implements com.google.android.gms.ads.internal.gmsg.u
{
  private final i a;
  private final Context c;
  private int d = -1;
  private int e = -1;
  private float f;
  private final com.google.android.gms.ads.internal.e.a g;
  private DisplayMetrics h;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l = -1;
  private int m = -1;
  private final WindowManager n;
  
  public l(i parami, Context paramContext, com.google.android.gms.ads.internal.e.a parama)
  {
    super(parami);
    this.a = parami;
    this.c = paramContext;
    this.g = parama;
    this.n = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    int i1;
    if ((this.c instanceof Activity))
    {
      localObject = bt.A.e;
      i1 = com.google.android.gms.ads.internal.util.n.c((Activity)this.c)[0];
    }
    for (;;)
    {
      label58:
      int i2;
      int i3;
      if ((this.a.getAdSize() != null) && (this.a.getAdSize().e()))
      {
        i2 = this.e;
        i3 = this.d;
      }
      try
      {
        localObject = new JSONObject().put("x", paramInt1).put("y", paramInt2 - i1).put("width", i2).put("height", i3);
        this.b.a("onDefaultPositionReceived", (JSONObject)localObject);
        this.a.getAdWebViewClient().a(paramInt1, paramInt2);
        return;
        localObject = com.google.android.gms.ads.internal.client.u.h.a;
        this.e = com.google.android.gms.ads.internal.util.client.a.b(this.c, this.a.getWidth());
        localObject = com.google.android.gms.ads.internal.client.u.h.a;
        this.d = com.google.android.gms.ads.internal.util.client.a.b(this.c, this.a.getHeight());
        break label58;
        i1 = 0;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          e.c("Error occured while dispatching default position.", localJSONException);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/m/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */