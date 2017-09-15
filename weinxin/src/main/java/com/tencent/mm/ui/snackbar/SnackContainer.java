package com.tencent.mm.ui.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.a;
import com.tencent.mm.s.a.g;
import java.util.LinkedList;
import java.util.Queue;

class SnackContainer
  extends FrameLayout
{
  private final Runnable llX;
  private AnimationSet vIh;
  Queue<a> whQ;
  private AnimationSet whR;
  private float whS;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2866219581440L, 21355);
    this.whQ = new LinkedList();
    this.llX = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2868769718272L, 21374);
        if (SnackContainer.this.getVisibility() == 0) {
          SnackContainer.this.startAnimation(SnackContainer.c(SnackContainer.this));
        }
        GMTrace.o(2868769718272L, 21374);
      }
    };
    init();
    GMTrace.o(2866219581440L, 21355);
  }
  
  SnackContainer(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    GMTrace.i(2866353799168L, 21356);
    this.whQ = new LinkedList();
    this.llX = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2868769718272L, 21374);
        if (SnackContainer.this.getVisibility() == 0) {
          SnackContainer.this.startAnimation(SnackContainer.c(SnackContainer.this));
        }
        GMTrace.o(2868769718272L, 21374);
      }
    };
    paramViewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
    setVisibility(8);
    setId(a.g.hcT);
    init();
    GMTrace.o(2866353799168L, 21356);
  }
  
  private static void a(a parama)
  {
    GMTrace.i(15697971249152L, 116959);
    if (parama.whY != null)
    {
      a.lA(false);
      parama.whY.onHide();
    }
    GMTrace.o(15697971249152L, 116959);
  }
  
  private void init()
  {
    GMTrace.i(2866488016896L, 21357);
    this.vIh = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.vIh.setInterpolator(new DecelerateInterpolator(1.5F));
    this.vIh.addAnimation(localTranslateAnimation);
    this.vIh.addAnimation(localAlphaAnimation);
    this.whR = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.whR.addAnimation(localTranslateAnimation);
    this.whR.addAnimation(localAlphaAnimation);
    this.whR.setDuration(300L);
    this.whR.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        GMTrace.i(2862998355968L, 21331);
        SnackContainer.this.removeAllViews();
        if (!SnackContainer.a(SnackContainer.this).isEmpty()) {
          SnackContainer.b((SnackContainer.a)SnackContainer.a(SnackContainer.this).poll());
        }
        if (!SnackContainer.this.isEmpty())
        {
          SnackContainer.a(SnackContainer.this, (SnackContainer.a)SnackContainer.a(SnackContainer.this).peek());
          GMTrace.o(2862998355968L, 21331);
          return;
        }
        SnackContainer.this.setVisibility(8);
        GMTrace.o(2862998355968L, 21331);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        GMTrace.i(2863132573696L, 21332);
        GMTrace.o(2863132573696L, 21332);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        GMTrace.i(2862864138240L, 21330);
        if ((!SnackContainer.this.isEmpty()) && (((SnackContainer.a)SnackContainer.a(SnackContainer.this).peek()).whY != null))
        {
          a.lA(false);
          ((SnackContainer.a)SnackContainer.a(SnackContainer.this).peek()).whY.azh();
        }
        GMTrace.o(2862864138240L, 21330);
      }
    });
    GMTrace.o(2866488016896L, 21357);
  }
  
  final void a(final a parama, boolean paramBoolean)
  {
    GMTrace.i(2867159105536L, 21362);
    setVisibility(0);
    if (parama.whY != null)
    {
      a.lA(true);
      parama.whY.azg();
    }
    addView(parama.whV);
    parama.whW.setText(parama.whX.mMessage);
    if (parama.whX.whC != null)
    {
      parama.neE.setVisibility(0);
      parama.neE.setText(parama.whX.whC);
    }
    for (;;)
    {
      this.vIh.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.aQX);
      localAnimation.setDuration(500L);
      startAnimation(this.vIh);
      localAnimation.setStartOffset(200L);
      parama.neE.startAnimation(localAnimation);
      parama.whW.startAnimation(localAnimation);
      if (parama.whX.whF > 0) {
        postDelayed(this.llX, parama.whX.whF);
      }
      parama.whV.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(2869977677824L, 21383);
          float f = paramAnonymousMotionEvent.getY();
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            SnackContainer.a(SnackContainer.this, f);
            GMTrace.o(2869977677824L, 21383);
            return true;
            SnackContainer.this.removeCallbacks(SnackContainer.b(SnackContainer.this));
            SnackContainer.b(parama);
            SnackContainer.this.startAnimation(SnackContainer.c(SnackContainer.this));
            if (!SnackContainer.a(SnackContainer.this).isEmpty()) {
              SnackContainer.a(SnackContainer.this).clear();
            }
          }
        }
      });
      GMTrace.o(2867159105536L, 21362);
      return;
      parama.neE.setVisibility(8);
    }
  }
  
  public final void hide()
  {
    GMTrace.i(2867024887808L, 21361);
    removeCallbacks(this.llX);
    this.llX.run();
    GMTrace.o(2867024887808L, 21361);
  }
  
  public final boolean isEmpty()
  {
    GMTrace.i(2866756452352L, 21359);
    boolean bool = this.whQ.isEmpty();
    GMTrace.o(2866756452352L, 21359);
    return bool;
  }
  
  public final boolean isShowing()
  {
    GMTrace.i(2866890670080L, 21360);
    if (!this.whQ.isEmpty())
    {
      GMTrace.o(2866890670080L, 21360);
      return true;
    }
    GMTrace.o(2866890670080L, 21360);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    GMTrace.i(2866622234624L, 21358);
    super.onDetachedFromWindow();
    this.vIh.cancel();
    this.whR.cancel();
    removeCallbacks(this.llX);
    this.whQ.clear();
    GMTrace.o(2866622234624L, 21358);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    GMTrace.i(2867427540992L, 21364);
    super.onVisibilityChanged(paramView, paramInt);
    if (((paramInt == 0) && (a.ash())) || (8 == paramInt))
    {
      removeAllViews();
      if (!this.whQ.isEmpty()) {
        a((a)this.whQ.poll());
      }
      if (isEmpty()) {
        break label100;
      }
      a((a)this.whQ.peek(), false);
    }
    for (;;)
    {
      a.lA(false);
      GMTrace.o(2867427540992L, 21364);
      return;
      label100:
      setVisibility(8);
    }
  }
  
  private static final class a
  {
    final TextView neE;
    final View whV;
    final TextView whW;
    final Snack whX;
    final b.c whY;
    
    public a(Snack paramSnack, View paramView, b.c paramc)
    {
      GMTrace.i(2869172371456L, 21377);
      this.whV = paramView;
      this.neE = ((TextView)paramView.findViewById(a.g.hcS));
      this.whW = ((TextView)paramView.findViewById(a.g.hcU));
      this.whX = paramSnack;
      this.whY = paramc;
      GMTrace.o(2869172371456L, 21377);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/snackbar/SnackContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */