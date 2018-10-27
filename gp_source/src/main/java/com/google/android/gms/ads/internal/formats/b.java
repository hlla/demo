package com.google.android.gms.ads.internal.formats;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.formats.a.ax;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class b
  implements View.OnClickListener
{
  public WeakReference a;
  public final com.google.android.gms.ads.internal.renderer.a.u b;
  public com.google.android.gms.ads.internal.gmsg.u c;
  public String d;
  public ax e;
  public Long f;
  
  public b(com.google.android.gms.ads.internal.renderer.a.u paramu)
  {
    this.b = paramu;
  }
  
  final void a()
  {
    this.d = null;
    this.f = null;
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      this.a = null;
      if (localObject != null)
      {
        ((View)localObject).setClickable(false);
        ((View)localObject).setOnClickListener(null);
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() == paramView)) {
      if ((this.d != null) && (this.f != null)) {
        paramView = new JSONObject();
      }
    }
    try
    {
      paramView.put("id", this.d);
      paramView.put("time_interval", bt.A.l.a() - this.f.longValue());
      paramView.put("messageType", "onePointFiveClick");
      this.b.a("sendMessageToNativeJs", paramView);
      a();
      return;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        e.c("Unable to dispatch sendMessageToNativeJs event", paramView);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */