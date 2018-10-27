package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager.BadTokenException;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.List;

@a
public final class ah
{
  public String a;
  public String b;
  public final Context c;
  public String d;
  public String e;
  public int f = 0;
  private Handler g;
  private final float h;
  private float i;
  private float j;
  private float k;
  private Runnable l = new ai(this);
  private float m;
  private float n;
  private float o;
  private float p;
  private int q;
  
  public ah(Context paramContext)
  {
    this.c = paramContext;
    this.h = paramContext.getResources().getDisplayMetrics().density;
    this.q = ViewConfiguration.get(this.c).getScaledTouchSlop();
    bt.A.t.a();
    this.g = bt.A.t.a;
  }
  
  public ah(Context paramContext, String paramString)
  {
    this(paramContext);
    this.d = paramString;
  }
  
  private static int a(List paramList, String paramString)
  {
    paramList.add(paramString);
    return paramList.size() - 1;
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      this.f = 0;
      this.i = paramFloat1;
      this.j = paramFloat2;
      this.k = paramFloat2;
      return;
    }
    label24:
    int i1;
    label91:
    label219:
    do
    {
      do
      {
        i1 = this.f;
      } while (i1 == -1);
      if (paramInt == 2)
      {
        if (paramFloat2 > this.j) {
          this.j = paramFloat2;
        }
        for (;;)
        {
          paramFloat2 = this.j;
          float f1 = this.k;
          float f2 = this.h;
          if (paramFloat2 - f1 <= 30.0F * f2)
          {
            if (i1 == 0) {
              if (paramFloat1 - this.i >= 50.0F * f2)
              {
                this.i = paramFloat1;
                this.f = (i1 + 1);
              }
            }
            for (;;)
            {
              paramInt = this.f;
              if (paramInt == 1)
              {
                if (paramFloat1 <= this.i) {
                  break label24;
                }
                this.i = paramFloat1;
                return;
              }
              if (paramInt == 3) {
                break;
              }
              if ((paramInt != 2) || (paramFloat1 >= this.i)) {
                break label24;
              }
              this.i = paramFloat1;
              return;
              if (i1 == 2) {
                break label91;
              }
              if (i1 == 1) {}
              for (;;)
              {
                if (paramFloat1 - this.i > -50.0F * f2) {
                  break label219;
                }
                this.i = paramFloat1;
                this.f = (i1 + 1);
                break;
                if (i1 != 3) {
                  break;
                }
              }
            }
          }
          this.f = -1;
          return;
          if (paramFloat2 < this.k) {
            this.k = paramFloat2;
          }
        }
      }
    } while ((paramInt != 1) || (i1 != 4));
    a();
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.abs(this.m - paramFloat1) < this.q) && (Math.abs(this.n - paramFloat2) < this.q) && (Math.abs(this.o - paramFloat3) < this.q) && (Math.abs(this.p - paramFloat4) < this.q);
  }
  
  public final void a()
  {
    for (;;)
    {
      try
      {
        if (!(this.c instanceof Activity))
        {
          e.d("Can not create dialog without Activity Context");
          return;
        }
        if (TextUtils.isEmpty(bt.A.o.a())) {
          break label168;
        }
        Object localObject = "Creative Preview (Enabled)";
        if (bt.A.o.b())
        {
          str2 = "Troubleshooting (Enabled)";
          ArrayList localArrayList = new ArrayList();
          int i1 = a(localArrayList, "Ad Information");
          int i2 = a(localArrayList, (String)localObject);
          int i3 = a(localArrayList, str2);
          localObject = new AlertDialog.Builder(this.c, bt.A.g.f());
          ((AlertDialog.Builder)localObject).setTitle("Select a Debug Mode").setItems((CharSequence[])localArrayList.toArray(new String[0]), new aj(this, i1, i2, i3));
          ((AlertDialog.Builder)localObject).create().show();
          return;
        }
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        e.a("", localBadTokenException);
        return;
      }
      String str2 = "Troubleshooting";
      continue;
      label168:
      String str1 = "Creative Preview";
    }
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    int i2;
    int i1;
    if (!((Boolean)n.S.a()).booleanValue())
    {
      i2 = paramMotionEvent.getHistorySize();
      i1 = 0;
      while (i1 < i2)
      {
        a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i1), paramMotionEvent.getHistoricalY(0, i1));
        i1 += 1;
      }
      a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    label141:
    do
    {
      return;
      int i3;
      do
      {
        int i4;
        do
        {
          do
          {
            i1 = paramMotionEvent.getActionMasked();
            i3 = paramMotionEvent.getHistorySize();
            i2 = paramMotionEvent.getPointerCount();
            if (i1 == 0)
            {
              this.f = 0;
              this.m = paramMotionEvent.getX();
              this.n = paramMotionEvent.getY();
              return;
            }
            i4 = this.f;
          } while (i4 == -1);
          if (i4 == 0) {
            break;
          }
        } while (i4 != 5);
        if (i2 != 2)
        {
          this.f = -1;
          this.g.removeCallbacks(this.l);
          return;
        }
      } while (i1 != 2);
      i1 = 0;
      i2 = 0;
      for (;;)
      {
        if (i1 >= i3)
        {
          if (!a(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getX(1), paramMotionEvent.getY(1))) {
            break label141;
          }
          if (i2 == 0) {
            break;
          }
          break label141;
        }
        if (!a(paramMotionEvent.getHistoricalX(0, i1), paramMotionEvent.getHistoricalY(0, i1), paramMotionEvent.getHistoricalX(1, i1), paramMotionEvent.getHistoricalY(1, i1))) {
          i2 = 1;
        }
        i1 += 1;
      }
    } while (i1 != 5);
    this.f = 5;
    this.o = paramMotionEvent.getX(1);
    this.p = paramMotionEvent.getY(1);
    this.g.postDelayed(this.l, ((Long)n.T.a()).longValue());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */