package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public final class g
{
  public int RQ;
  public int aar;
  private int abF;
  private final Context context;
  private ad mHandler;
  private int qmF;
  public int qmG;
  public int qmH;
  private int qmI;
  private int qmJ;
  private float qmK;
  private float qmL;
  public float qmM;
  float qmN;
  public int qmO;
  public int qmP;
  public int qmQ;
  public int qmR;
  public int qmS;
  private int qmT;
  public int qmU;
  public int qmV;
  public int qmW;
  public int qmX;
  public int qmY;
  public int qmZ;
  public float wkq;
  private float wkr;
  public float wks;
  private int wkt;
  public int wku;
  private int wkv;
  
  public g(Context paramContext)
  {
    GMTrace.i(1941862088704L, 14468);
    this.abF = 0;
    this.qmF = 0;
    this.aar = 0;
    this.RQ = 0;
    this.qmG = 0;
    this.qmH = 0;
    this.qmI = 0;
    this.qmJ = 0;
    this.qmK = 0.0F;
    this.qmL = 0.0F;
    this.qmM = 0.0F;
    this.wkq = 0.0F;
    this.wkr = 1.0F;
    this.wks = 1.0F;
    this.wkt = 0;
    this.wku = 0;
    this.qmN = 1.0F;
    this.qmO = 0;
    this.qmP = 0;
    this.qmQ = 0;
    this.qmR = 0;
    this.qmS = 0;
    this.qmT = 300;
    this.wkv = 10;
    this.qmU = 0;
    this.qmV = 1;
    this.qmW = 2;
    this.qmX = 3;
    this.qmY = 4;
    this.qmZ = this.qmU;
    this.mHandler = new ad();
    this.context = paramContext;
    GMTrace.o(1941862088704L, 14468);
  }
  
  private void k(View paramView, boolean paramBoolean)
  {
    GMTrace.i(1942398959616L, 14472);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.abF == 0) && (this.qmF == 0))
    {
      this.abF = (paramView.getWidth() / 2);
      this.qmF = (paramView.getHeight() / 2);
    }
    this.qmI = (this.abF - arrayOfInt[0]);
    this.qmJ = (this.qmF - arrayOfInt[1]);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k;
    if ((j == 0) || (i == 0))
    {
      i = this.qmG;
      k = this.qmH;
      j = i;
    }
    for (;;)
    {
      if ((j != 0) && (k != 0))
      {
        this.qmK = (this.aar / j);
        this.qmL = (this.RQ / k);
      }
      float f1 = this.wkr;
      if ((this.qmP != 0) || (this.qmQ != 0) || (this.qmR != 0) || (this.qmS != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.qmG != 0)
        {
          f1 = f2;
          if (this.qmH != 0)
          {
            this.qmK = (this.aar / this.qmG);
            this.qmL = (this.RQ / this.qmH);
            f1 = f2;
          }
        }
      }
      if (this.wks != 1.0D)
      {
        this.qmI += arrayOfInt[0];
        this.qmJ += arrayOfInt[1];
        this.qmM = (this.qmK * this.wks);
        this.wkq = this.qmM;
        this.qmJ = ((int)(this.qmJ - this.wku * this.qmM));
        this.qmI = ((int)(this.qmI - this.wkt * this.qmM));
        GMTrace.o(1942398959616L, 14472);
        return;
      }
      if (this.qmK > this.qmL)
      {
        this.qmM = (this.qmK * f1);
        this.qmJ = ((int)(this.qmJ - (k * this.qmM - this.RQ * f1) / 2.0F));
        this.qmJ = ((int)(this.qmJ - this.RQ * (f1 - 1.0F) / 2.0F - this.qmO * this.qmM / 2.0F));
        this.qmI = ((int)(this.qmI - this.aar * (f1 - 1.0F) / 2.0F));
        if ((this.qmH == 0) || (this.qmF >= (k - this.qmH) / 2)) {
          break label693;
        }
        f2 = this.qmJ;
      }
      for (this.qmJ = ((int)((f1 - 1.0F) * this.RQ / 2.0F + f2));; this.qmJ = ((int)(this.qmJ - (f1 - 1.0F) * this.RQ / 2.0F))) {
        label693:
        do
        {
          if ((this.aar == 0) && (this.RQ == 0))
          {
            this.qmM = 0.5F;
            this.qmN = 0.0F;
            this.qmI = ((int)(this.qmI - j * this.qmM / 2.0F));
            this.qmJ = ((int)(this.qmJ - k * this.qmM / 2.0F - this.qmO * this.qmM / 2.0F));
          }
          GMTrace.o(1942398959616L, 14472);
          return;
          this.qmM = (this.qmL * f1);
          this.qmI = ((int)(this.qmI - (j * this.qmM - this.aar * f1) / 2.0F));
          if ((this.qmH == 0) || (this.qmH >= k)) {
            break;
          }
          this.qmJ = ((int)(this.qmJ - (k * this.qmM - this.RQ * f1) / 2.0F));
          break;
        } while ((this.qmH == 0) || (this.qmF + this.RQ <= (this.qmH + k) / 2));
      }
      k = i;
    }
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final b paramb)
  {
    GMTrace.i(1942533177344L, 14473);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.qmZ == this.qmW) || (this.qmZ == this.qmY) || (this.qmZ == this.qmX))
    {
      GMTrace.o(1942533177344L, 14473);
      return;
    }
    k(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.qmM);
    paramView1.setScaleY(this.qmM);
    paramView1.setTranslationX(this.qmI);
    paramView1.setTranslationY(this.qmJ);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.qmT).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F);
    }
    paramView1.animate().setDuration(this.qmT).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        GMTrace.i(1921863647232L, 14319);
        g.this.qmZ = g.this.qmX;
        GMTrace.o(1921863647232L, 14319);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        GMTrace.i(1921729429504L, 14318);
        if (paramb != null) {
          paramb.onAnimationEnd();
        }
        g.this.qmZ = g.this.qmX;
        GMTrace.o(1921729429504L, 14318);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        GMTrace.i(1921997864960L, 14320);
        GMTrace.o(1921997864960L, 14320);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        GMTrace.i(1921595211776L, 14317);
        if (paramb != null) {
          paramb.onAnimationStart();
        }
        g.this.qmZ = g.this.qmW;
        GMTrace.o(1921595211776L, 14317);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2062926479360L, 15370);
        if (g.this.qmZ == g.this.qmU)
        {
          v.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        GMTrace.o(2062926479360L, 15370);
      }
    }, this.wkv);
    GMTrace.o(1942533177344L, 14473);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final b paramb, final a parama)
  {
    GMTrace.i(1942667395072L, 14474);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.qmZ == this.qmW) || (this.qmZ == this.qmY) || (this.qmZ == this.qmV))
    {
      GMTrace.o(1942667395072L, 14474);
      return;
    }
    k(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F);
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.qmM, this.qmM, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        GMTrace.i(2008970952704L, 14968);
        int k;
        int i;
        int n;
        int i1;
        if ((g.this.qmG != 0) && (g.this.qmH != 0) && (g.this.wks == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + g.this.qmO) / 2;
          k = (int)(((g.this.qmG - g.this.aar) * (1.0F - paramAnonymousFloat) + g.this.aar) / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          i = (int)(((g.this.qmH - g.this.RQ) * (1.0F - paramAnonymousFloat) + g.this.RQ) / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          if (g.this.wks != 1.0F)
          {
            g.this.qmM = (g.this.wkq / g.this.wks);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = g.this.wku - localRect.top + (int)(g.this.qmH / 2.0F);
            k = (int)(((g.this.qmG - g.this.aar) * (1.0F - paramAnonymousFloat) + g.this.aar) / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
            i = (int)(((g.this.qmH - g.this.RQ) * (1.0F - paramAnonymousFloat) + g.this.RQ) / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + g.this.qmP * paramAnonymousFloat / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - g.this.qmO * (1.0F - paramAnonymousFloat) / 2.0F + g.this.qmR * paramAnonymousFloat / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          k = (int)(k / 2 + m - g.this.qmQ * paramAnonymousFloat / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          i = (int)(i / 2 + j - g.this.qmS * paramAnonymousFloat / (1.0F - (1.0F - g.this.qmM) * paramAnonymousFloat));
          if (Build.VERSION.SDK_INT < 21) {
            break label569;
          }
          paramView1.setClipBounds(new Rect(n, i1, k, i));
        }
        for (;;)
        {
          super.applyTransformation(paramAnonymousFloat, paramAnonymousTransformation);
          GMTrace.o(2008970952704L, 14968);
          return;
          label569:
          if (Build.VERSION.SDK_INT >= 18) {
            if (parama != null) {
              parama.q(n, i1, k, i);
            } else {
              paramView1.setClipBounds(new Rect(n + paramView1.getScrollX(), i1, k + paramView1.getScrollX(), i));
            }
          }
        }
      }
    };
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new TranslateAnimation(0.0F, this.qmI, 0.0F, this.qmJ);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.qmN);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        GMTrace.i(1928171880448L, 14366);
        if (paramb != null) {
          paramb.onAnimationEnd();
        }
        g.this.qmZ = g.this.qmV;
        GMTrace.o(1928171880448L, 14366);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        GMTrace.i(1928306098176L, 14367);
        GMTrace.o(1928306098176L, 14367);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        GMTrace.i(1928037662720L, 14365);
        if (paramb != null) {
          paramb.onAnimationStart();
        }
        g.this.qmZ = g.this.qmY;
        GMTrace.o(1928037662720L, 14365);
      }
    });
    paramView1.startAnimation(paramView2);
    GMTrace.o(1942667395072L, 14474);
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    GMTrace.i(1942130524160L, 14470);
    this.qmG = paramInt1;
    this.qmH = paramInt2;
    GMTrace.o(1942130524160L, 14470);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    GMTrace.i(1942264741888L, 14471);
    this.wkt = paramInt1;
    this.wku = paramInt2;
    GMTrace.o(1942264741888L, 14471);
  }
  
  public final void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1941996306432L, 14469);
    this.abF = paramInt1;
    this.qmF = paramInt2;
    this.aar = paramInt3;
    this.RQ = paramInt4;
    GMTrace.o(1941996306432L, 14469);
  }
  
  @TargetApi(18)
  public static abstract interface a
  {
    public abstract void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface b
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
  
  public static abstract interface c {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */