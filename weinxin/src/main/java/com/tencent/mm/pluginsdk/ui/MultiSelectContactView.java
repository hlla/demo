package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  private LayoutInflater mwN;
  private int padding;
  private View qkq;
  private HorizontalScrollView sHK;
  private LinearLayout sHL;
  private View sHM;
  public MMEditText sHN;
  private List<String> sHO;
  private Animation sHP;
  private int sHQ;
  public a sHR;
  public b sHS;
  public c sHT;
  private List<View> sHU;
  boolean sHV;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1166754709504L, 8693);
    this.sHQ = 0;
    this.padding = 0;
    this.sHV = false;
    this.padding = getResources().getDimensionPixelSize(R.f.aWz);
    this.mwN = LayoutInflater.from(paramContext);
    this.mwN.inflate(R.i.djD, this, true);
    this.sHK = ((HorizontalScrollView)findViewById(R.h.clV));
    this.sHN = ((MMEditText)findViewById(R.h.clU));
    this.sHL = ((LinearLayout)findViewById(R.h.clT));
    this.sHM = findViewById(R.h.clW);
    this.sHO = new LinkedList();
    this.sHP = AnimationUtils.loadAnimation(paramContext, R.a.aQX);
    c.d(this.sHN).Cc(100).a(null);
    this.qkq = findViewById(R.h.cze);
    this.sHN.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(1033476505600L, 7700);
        GMTrace.o(1033476505600L, 7700);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1033342287872L, 7699);
        GMTrace.o(1033342287872L, 7699);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1033208070144L, 7698);
        MultiSelectContactView.a(MultiSelectContactView.this);
        if (MultiSelectContactView.b(MultiSelectContactView.this) != null) {
          MultiSelectContactView.b(MultiSelectContactView.this).zC(paramAnonymousCharSequence.toString());
        }
        GMTrace.o(1033208070144L, 7698);
      }
    });
    this.sHN.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(1033744941056L, 7702);
        if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.c(MultiSelectContactView.this).getSelectionStart() == 0) && (MultiSelectContactView.c(MultiSelectContactView.this).getSelectionEnd() == 0)) {
          MultiSelectContactView.d(MultiSelectContactView.this);
        }
        GMTrace.o(1033744941056L, 7702);
        return false;
      }
    });
    this.sHU = new ArrayList();
    this.sHN.clearFocus();
    this.sHN.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        GMTrace.i(1164741443584L, 8678);
        if (paramAnonymousBoolean)
        {
          MultiSelectContactView.e(MultiSelectContactView.this).setBackgroundResource(R.g.bfU);
          MultiSelectContactView.e(MultiSelectContactView.this).setPadding(MultiSelectContactView.f(MultiSelectContactView.this), MultiSelectContactView.f(MultiSelectContactView.this), MultiSelectContactView.f(MultiSelectContactView.this), MultiSelectContactView.f(MultiSelectContactView.this));
        }
        for (;;)
        {
          if (MultiSelectContactView.g(MultiSelectContactView.this) != null) {
            MultiSelectContactView.g(MultiSelectContactView.this).bEj();
          }
          GMTrace.o(1164741443584L, 8678);
          return;
          MultiSelectContactView.e(MultiSelectContactView.this).setBackgroundResource(R.g.bfV);
          MultiSelectContactView.e(MultiSelectContactView.this).setPadding(MultiSelectContactView.f(MultiSelectContactView.this), MultiSelectContactView.f(MultiSelectContactView.this), MultiSelectContactView.f(MultiSelectContactView.this), MultiSelectContactView.f(MultiSelectContactView.this));
        }
      }
    });
    setBackgroundColor(-201326593);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1153332936704L, 8593);
        GMTrace.o(1153332936704L, 8593);
      }
    });
    GMTrace.o(1166754709504L, 8693);
  }
  
  private View MF(String paramString)
  {
    GMTrace.i(1168231104512L, 8704);
    int j = this.sHL.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.sHL.getChildAt(i);
      if (paramString.equals(localView.getTag()))
      {
        GMTrace.o(1168231104512L, 8704);
        return localView;
      }
      i += 1;
    }
    GMTrace.o(1168231104512L, 8704);
    return null;
  }
  
  private void a(final View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(1167560015872L, 8699);
    if ((paramBoolean1) && (this.sHR != null)) {
      this.sHR.mK(paramView.getTag().toString());
    }
    if (paramBoolean2)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.aQY);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GMTrace.i(1038039908352L, 7734);
          paramView.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(1202859278336L, 8962);
              MultiSelectContactView.h(MultiSelectContactView.this).removeView(MultiSelectContactView.6.this.zG);
              MultiSelectContactView.i(MultiSelectContactView.this);
              MultiSelectContactView.a(MultiSelectContactView.this, MultiSelectContactView.h(MultiSelectContactView.this).getChildCount());
              GMTrace.o(1202859278336L, 8962);
            }
          });
          GMTrace.o(1038039908352L, 7734);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          GMTrace.i(1037905690624L, 7733);
          GMTrace.o(1037905690624L, 7733);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          GMTrace.i(1037771472896L, 7732);
          GMTrace.o(1037771472896L, 7732);
        }
      });
      paramView.startAnimation(localAnimation);
      GMTrace.o(1167560015872L, 8699);
      return;
    }
    this.sHL.removeView(paramView);
    bEi();
    xg(this.sHL.getChildCount());
    GMTrace.o(1167560015872L, 8699);
  }
  
  private void bEg()
  {
    GMTrace.i(1167291580416L, 8697);
    if (this.sHL.getChildCount() == 0)
    {
      GMTrace.o(1167291580416L, 8697);
      return;
    }
    if (this.sHV)
    {
      View localView = this.sHL.getChildAt(this.sHL.getChildCount() - 1);
      this.sHV = false;
      localView.findViewById(R.h.mask).setVisibility(8);
    }
    GMTrace.o(1167291580416L, 8697);
  }
  
  private void bEh()
  {
    GMTrace.i(1167694233600L, 8700);
    this.sHL.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1034013376512L, 7704);
        MultiSelectContactView.j(MultiSelectContactView.this).scrollTo(MultiSelectContactView.h(MultiSelectContactView.this).getMeasuredWidth(), 0);
        GMTrace.o(1034013376512L, 7704);
      }
    });
    GMTrace.o(1167694233600L, 8700);
  }
  
  private void bEi()
  {
    GMTrace.i(1167962669056L, 8702);
    if (this.sHL.getChildCount() == 0)
    {
      this.sHM.setVisibility(0);
      GMTrace.o(1167962669056L, 8702);
      return;
    }
    this.sHM.setVisibility(8);
    GMTrace.o(1167962669056L, 8702);
  }
  
  private void xg(int paramInt)
  {
    GMTrace.i(1167828451328L, 8701);
    if (this.sHQ <= 0)
    {
      this.sHQ += getResources().getDimensionPixelSize(R.f.aXt);
      i = BackwardSupportUtil.b.a(getContext(), 40.0F);
      int j = (int)this.sHN.getPaint().measureText(getContext().getString(R.l.dIr));
      int k = this.sHQ;
      this.sHQ = (Math.max(i, j) + k);
    }
    if (this.sHQ <= 0)
    {
      GMTrace.o(1167828451328L, 8701);
      return;
    }
    int i = this.qkq.getWidth();
    paramInt *= (getResources().getDimensionPixelSize(R.f.aWK) + getResources().getDimensionPixelSize(R.f.aWz));
    v.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.sHQ) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sHK.getLayoutParams();
    if (i - paramInt > this.sHQ)
    {
      localLayoutParams.width = -2;
      GMTrace.o(1167828451328L, 8701);
      return;
    }
    localLayoutParams.width = (i - this.sHQ);
    GMTrace.o(1167828451328L, 8701);
  }
  
  public final void MD(String paramString)
  {
    GMTrace.i(1167023144960L, 8695);
    if (bf.mA(paramString))
    {
      GMTrace.o(1167023144960L, 8695);
      return;
    }
    if (this.sHO.contains(paramString))
    {
      v.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
      GMTrace.o(1167023144960L, 8695);
      return;
    }
    bEg();
    View localView = MF(paramString);
    if (localView != null)
    {
      a(localView, false, false);
      GMTrace.o(1167023144960L, 8695);
      return;
    }
    aK(paramString, true);
    GMTrace.o(1167023144960L, 8695);
  }
  
  public final void ME(String paramString)
  {
    GMTrace.i(1167157362688L, 8696);
    paramString = MF(paramString);
    if (paramString != null)
    {
      a(paramString, false, false);
      GMTrace.o(1167157362688L, 8696);
      return;
    }
    GMTrace.o(1167157362688L, 8696);
  }
  
  public final void aK(String paramString, boolean paramBoolean)
  {
    GMTrace.i(1167425798144L, 8698);
    xg(this.sHL.getChildCount() + 1);
    View localView = this.mwN.inflate(R.i.dnl, null, true);
    ImageView localImageView = (ImageView)localView.findViewById(R.h.bqz);
    a.b.a(localImageView, paramString);
    localImageView.setContentDescription(n.eK(paramString));
    localView.setTag(paramString);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1223528808448L, 9116);
        MultiSelectContactView.a(MultiSelectContactView.this, paramAnonymousView);
        GMTrace.o(1223528808448L, 9116);
      }
    });
    if (paramBoolean) {
      localView.startAnimation(this.sHP);
    }
    this.sHL.addView(localView);
    bEi();
    paramString = (LinearLayout.LayoutParams)localView.getLayoutParams();
    paramString.height = getResources().getDimensionPixelSize(R.f.aWK);
    paramString.width = getResources().getDimensionPixelSize(R.f.aWK);
    paramString.rightMargin = getResources().getDimensionPixelSize(R.f.aWz);
    localView.setLayoutParams(paramString);
    bEh();
    GMTrace.o(1167425798144L, 8698);
  }
  
  public final String bzR()
  {
    GMTrace.i(1168096886784L, 8703);
    String str = this.sHN.getText().toString();
    GMTrace.o(1168096886784L, 8703);
    return str;
  }
  
  public void clearFocus()
  {
    GMTrace.i(1166888927232L, 8694);
    this.sHN.clearFocus();
    bEg();
    GMTrace.o(1166888927232L, 8694);
  }
  
  public static abstract interface a
  {
    public abstract void mK(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void zC(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void bEj();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/MultiSelectContactView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */