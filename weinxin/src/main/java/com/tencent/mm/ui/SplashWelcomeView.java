package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.chatting.en;

public class SplashWelcomeView
  extends FrameLayout
  implements en
{
  private Bitmap bitmap;
  private boolean hasDrawed;
  public en uUJ;
  private boolean uUK;
  private ImageView uUL;
  public a uUM;
  private int uUN;
  
  public SplashWelcomeView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(17920214171648L, 133516);
    eD(paramContext);
    GMTrace.o(17920214171648L, 133516);
  }
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(17920348389376L, 133517);
    eD(paramContext);
    GMTrace.o(17920348389376L, 133517);
  }
  
  public SplashWelcomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(17920482607104L, 133518);
    eD(paramContext);
    GMTrace.o(17920482607104L, 133518);
  }
  
  private void bQt()
  {
    for (;;)
    {
      try
      {
        GMTrace.i(17920751042560L, 133520);
        if (this.uUK) {
          break label104;
        }
        this.uUK = true;
        Bitmap localBitmap = this.bitmap;
        if (localBitmap != null)
        {
          try
          {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(17934709686272L, 133624);
                v.d("SplashWelcomeView", "set top imageView");
                final ImageView localImageView = new ImageView(SplashWelcomeView.this.getContext());
                localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                localImageView.setImageBitmap(SplashWelcomeView.c(SplashWelcomeView.this));
                localImageView.setAlpha(0.0F);
                SplashWelcomeView.this.addView(localImageView, new FrameLayout.LayoutParams(-1, -1));
                ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
                localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                  public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
                  {
                    GMTrace.i(17887465046016L, 133272);
                    float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                    localImageView.setAlpha(f);
                    GMTrace.o(17887465046016L, 133272);
                  }
                });
                localValueAnimator.start();
                v.i("SplashWelcomeView", "start play animation");
                new ai(Looper.getMainLooper(), new ai.a()
                {
                  public final boolean oQ()
                  {
                    GMTrace.i(17887733481472L, 133274);
                    v.i("SplashWelcomeView", "stop show new launch image");
                    SplashWelcomeView.d(SplashWelcomeView.this);
                    GMTrace.o(17887733481472L, 133274);
                    return true;
                  }
                }, false).v(1750L, 0L);
                GMTrace.o(17934709686272L, 133624);
              }
            });
            GMTrace.o(17920751042560L, 133520);
          }
          catch (Exception localException)
          {
            v.printErrStackTrace("SplashWelcomeView", localException, "%s", new Object[] { localException.getMessage() });
            bQu();
            GMTrace.o(17920751042560L, 133520);
            continue;
          }
          return;
        }
      }
      finally {}
      v.i("SplashWelcomeView", "new launch bitmap is null");
      bQu();
      label104:
      GMTrace.o(17920751042560L, 133520);
    }
  }
  
  private void bQu()
  {
    GMTrace.i(17920885260288L, 133521);
    if (this.uUM != null) {
      this.uUM.on();
    }
    GMTrace.o(17920885260288L, 133521);
  }
  
  private void eD(Context paramContext)
  {
    GMTrace.i(17920616824832L, 133519);
    this.uUL = new SplashImageView(paramContext);
    this.uUL.setImageResource(R.g.bmb);
    this.uUL.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((SplashImageView)this.uUL).uUJ = this;
    addView(this.uUL, new FrameLayout.LayoutParams(-1, -1));
    final String str;
    for (;;)
    {
      try
      {
        paramContext = aa.getContext().getSharedPreferences("system_config_prefs", 0);
        long l1 = paramContext.getLong("new_launch_image_begin_time", 0L);
        long l2 = paramContext.getLong("new_launch_image_end_time", 0L);
        long l3 = System.currentTimeMillis() / 1000L;
        v.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        str = a.hgg + "splashWelcomeImg";
        if ((l3 <= l1) || (l3 >= l2)) {
          break label395;
        }
        this.uUN = paramContext.getInt("launch_fail_times", 0);
        int i = paramContext.getInt("launch_last_status", 0);
        if (i == 1)
        {
          v.i("SplashWelcomeView", "last launch status is 'start'.");
          this.uUN += 1;
          paramContext.edit().putInt("launch_fail_times", this.uUN).commit();
          paramContext.edit().putInt("launch_last_status", 1).apply();
          if (this.uUN >= 3)
          {
            v.i("SplashWelcomeView", "launch exceed max failed times, %d", new Object[] { Integer.valueOf(this.uUN) });
            i = 0;
            if (i != 0) {
              break;
            }
            bQu();
            GMTrace.o(17920616824832L, 133519);
          }
        }
        else
        {
          if (i != 2) {
            continue;
          }
          v.i("SplashWelcomeView", "last launch status is 'end'.");
          continue;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        v.printErrStackTrace("SplashWelcomeView", paramContext, "%s", new Object[] { paramContext.getMessage() });
        bQu();
        GMTrace.o(17920616824832L, 133519);
        return;
      }
    }
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17879277764608L, 133211);
        if (com.tencent.mm.a.e.aO(str)) {
          try
          {
            byte[] arrayOfByte = com.tencent.mm.a.e.c(str, 0, com.tencent.mm.a.e.aN(str));
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              SplashWelcomeView.a(SplashWelcomeView.this, BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
              v.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", new Object[] { Boolean.valueOf(SplashWelcomeView.a(SplashWelcomeView.this)) });
              if (SplashWelcomeView.a(SplashWelcomeView.this)) {
                SplashWelcomeView.b(SplashWelcomeView.this);
              }
            }
            GMTrace.o(17879277764608L, 133211);
            return;
          }
          catch (Exception localException)
          {
            v.printErrStackTrace("SplashWelcomeView", localException, "decode new welcome image error: %s", new Object[] { localException.getMessage() });
            GMTrace.o(17879277764608L, 133211);
            return;
          }
        }
        v.i("SplashWelcomeView", "cannot find %s", new Object[] { str });
        GMTrace.o(17879277764608L, 133211);
      }
    }, "readWelcomeBg");
    GMTrace.o(17920616824832L, 133519);
    return;
    label395:
    v.i("SplashWelcomeView", "change launch image activity is finished!");
    b.deleteFile(str);
    GMTrace.o(17920616824832L, 133519);
  }
  
  public final void om()
  {
    GMTrace.i(17921019478016L, 133522);
    v.i("SplashWelcomeView", "hasDrawed:%s", new Object[] { Boolean.valueOf(this.hasDrawed) });
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (!this.uUK) {
        bQt();
      }
      if (this.uUJ != null) {
        this.uUJ.om();
      }
    }
    GMTrace.o(17921019478016L, 133522);
  }
  
  public static abstract interface a
  {
    public abstract void on();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/SplashWelcomeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */