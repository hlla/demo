package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.v;

public class MaskLayout
  extends RelativeLayout
{
  private ImageView lLu;
  public View view;
  private Drawable vmc;
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3302158761984L, 24603);
    GMTrace.o(3302158761984L, 24603);
  }
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3302292979712L, 24604);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.frl, paramInt, 0);
    this.vmc = paramContext.getDrawable(a.m.hfI);
    paramContext.recycle();
    GMTrace.o(3302292979712L, 24604);
  }
  
  private void Ah(int paramInt)
  {
    GMTrace.i(3302964068352L, 24609);
    removeView(this.lLu);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    switch (1.vmd[(paramInt - 1)])
    {
    default: 
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      addView(this.lLu, localLayoutParams1);
      GMTrace.o(3302964068352L, 24609);
      return;
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(11);
      localLayoutParams1 = localLayoutParams2;
      continue;
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(9);
      localLayoutParams1 = localLayoutParams2;
      continue;
      localLayoutParams2.addRule(11);
      localLayoutParams1 = localLayoutParams2;
    }
  }
  
  public final void bSw()
  {
    GMTrace.i(3302561415168L, 24606);
    Ah(a.vmi);
    this.lLu.setImageBitmap(null);
    GMTrace.o(3302561415168L, 24606);
  }
  
  public final void bSx()
  {
    GMTrace.i(3302695632896L, 24607);
    Ah(a.vmi);
    this.lLu.setImageDrawable(null);
    GMTrace.o(3302695632896L, 24607);
  }
  
  public final void d(Bitmap paramBitmap, int paramInt)
  {
    GMTrace.i(3302829850624L, 24608);
    Ah(paramInt);
    this.lLu.setImageBitmap(paramBitmap);
    GMTrace.o(3302829850624L, 24608);
  }
  
  public void onFinishInflate()
  {
    GMTrace.i(3302427197440L, 24605);
    super.onFinishInflate();
    this.view = findViewById(a.g.content);
    if (this.view == null)
    {
      v.d("MicroMsg.MaskLayout", "%s", new Object[] { "not found view by id, new one" });
      this.view = new View(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.view.setLayoutParams(localLayoutParams);
      addView(this.view);
    }
    this.lLu = new ImageView(getContext());
    this.lLu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.lLu.setImageDrawable(this.vmc);
    addView(this.lLu);
    GMTrace.o(3302427197440L, 24605);
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(3367925448704L, 25093);
      vme = 1;
      vmf = 2;
      vmg = 3;
      vmh = 4;
      vmi = 5;
      vmj = new int[] { vme, vmf, vmg, vmh, vmi };
      GMTrace.o(3367925448704L, 25093);
    }
    
    public static int[] bSy()
    {
      GMTrace.i(3367791230976L, 25092);
      int[] arrayOfInt = (int[])vmj.clone();
      GMTrace.o(3367791230976L, 25092);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MaskLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */