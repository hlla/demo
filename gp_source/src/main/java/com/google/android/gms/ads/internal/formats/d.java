package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.common.internal.z;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  extends RelativeLayout
{
  private static final float[] a = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private AnimationDrawable b;
  
  public d(Context paramContext, a parama, RelativeLayout.LayoutParams paramLayoutParams)
  {
    super(paramContext);
    z.a(parama);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(a, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(parama.f);
    setLayoutParams(paramLayoutParams);
    bt.A.g.a(this, (Drawable)localObject1);
    paramLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (!TextUtils.isEmpty(parama.e))
    {
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setId(1195835393);
      ((TextView)localObject1).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject1).setText(parama.e);
      ((TextView)localObject1).setTextColor(parama.g);
      ((TextView)localObject1).setTextSize(parama.h);
      localObject2 = u.h.a;
      int i = com.google.android.gms.ads.internal.util.client.a.a(paramContext, 4);
      localObject2 = u.h.a;
      ((TextView)localObject1).setPadding(i, 0, com.google.android.gms.ads.internal.util.client.a.a(paramContext, 4), 0);
      addView((View)localObject1);
      paramLayoutParams.addRule(1, ((TextView)localObject1).getId());
    }
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams(paramLayoutParams);
    paramContext.setId(1195835394);
    paramLayoutParams = parama.c;
    if ((paramLayoutParams != null) && (paramLayoutParams.size() > 1))
    {
      this.b = new AnimationDrawable();
      paramLayoutParams = paramLayoutParams.iterator();
      while (paramLayoutParams.hasNext())
      {
        localObject1 = (h)paramLayoutParams.next();
        try
        {
          localObject1 = (Drawable)com.google.android.gms.dynamic.e.a(com.google.android.gms.dynamic.e.a(((h)localObject1).a));
          this.b.addFrame((Drawable)localObject1, parama.b);
        }
        catch (Exception localException)
        {
          com.google.android.gms.ads.internal.util.e.c("Error while getting drawable.", localException);
        }
      }
      bt.A.g.a(paramContext, this.b);
    }
    for (;;)
    {
      addView(paramContext);
      return;
      if (paramLayoutParams.size() == 1) {
        try
        {
          paramContext.setImageDrawable((Drawable)com.google.android.gms.dynamic.e.a(com.google.android.gms.dynamic.e.a(((h)paramLayoutParams.get(0)).a)));
        }
        catch (Exception parama)
        {
          com.google.android.gms.ads.internal.util.e.c("Error while getting drawable.", parama);
        }
      }
    }
  }
  
  public final void onAttachedToWindow()
  {
    AnimationDrawable localAnimationDrawable = this.b;
    if (localAnimationDrawable != null) {
      localAnimationDrawable.start();
    }
    super.onAttachedToWindow();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */