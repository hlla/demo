package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private int kGG;
  private Context mContext;
  private int mScreenWidth;
  private int mYZ;
  private int vgS;
  private int vgT;
  private String vgU;
  public ArrayList<MMAutoSwitchEditText> vgV;
  private c vgW;
  public a vgX;
  public b vgY;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3328599654400L, 24800);
    this.vgV = new ArrayList();
    this.vgW = new c();
    this.kGG = 100;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.fpa);
    this.vgS = paramAttributeSet.getInteger(a.m.hfo, 3);
    this.mYZ = paramAttributeSet.getInteger(a.m.hfr, 4);
    this.vgT = paramAttributeSet.getInteger(a.m.hfq, 2);
    int i = paramAttributeSet.getResourceId(a.m.hfp, 0);
    if (i != 0) {
      this.vgU = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.kGG = ((this.mScreenWidth - 80 - (this.vgS - 1) * 20) / this.vgS);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    bRF();
    GMTrace.o(3328599654400L, 24800);
  }
  
  private void bRF()
  {
    GMTrace.i(3328733872128L, 24801);
    int i = 0;
    if (i < this.vgS)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, a.h.hdA, null);
      localMMAutoSwitchEditText.setInputType(this.vgT);
      if ((this.vgU != null) && (this.vgU.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.vgU));
      }
      localMMAutoSwitchEditText.vgN.mIndex = i;
      int j = this.mYZ;
      localMMAutoSwitchEditText.vgN.vgR = j;
      Object localObject = this.vgW;
      localMMAutoSwitchEditText.vgN.vgO = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.vgW;
      localMMAutoSwitchEditText.vgN.vgP = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.vgW;
      localMMAutoSwitchEditText.vgN.vgQ = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.kGG, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.vgV.add(localMMAutoSwitchEditText);
        addView(localMMAutoSwitchEditText);
        i += 1;
        break;
      }
    }
    GMTrace.o(3328733872128L, 24801);
  }
  
  public static abstract interface a
  {
    public abstract void SK(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void bQz();
  }
  
  private final class c
    implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
  {
    public c()
    {
      GMTrace.i(3327928565760L, 24795);
      GMTrace.o(3327928565760L, 24795);
    }
    
    public final void bRE()
    {
      GMTrace.i(3328331218944L, 24798);
      String str = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bf.mA(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label121;
        }
        str = str + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label121:
      for (;;)
      {
        break;
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).bQz();
        }
        GMTrace.o(3328331218944L, 24798);
        return;
      }
    }
    
    public final void zW(int paramInt)
    {
      GMTrace.i(3328197001216L, 24797);
      if ((MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this) != null) && (paramInt < MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).size()))
      {
        if (paramInt == 0)
        {
          GMTrace.o(3328197001216L, 24797);
          return;
        }
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).get(paramInt - 1);
        if (localMMAutoSwitchEditText != null) {
          localMMAutoSwitchEditText.requestFocus();
        }
      }
      GMTrace.o(3328197001216L, 24797);
    }
    
    public final void zX(int paramInt)
    {
      GMTrace.i(3328062783488L, 24796);
      Object localObject = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bf.mA(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label238;
        }
        localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label238:
      for (;;)
      {
        break;
        if ((!bf.mA((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(MMAutoSwitchEditTextView.this) * MMAutoSwitchEditTextView.c(MMAutoSwitchEditTextView.this)))
        {
          if (MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this) != null) {
            MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this).SK((String)localObject);
          }
          GMTrace.o(3328062783488L, 24796);
          return;
        }
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).bQz();
        }
        if ((MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this) != null) && (paramInt < MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).size() - 1))
        {
          localObject = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).get(paramInt + 1);
          if (localObject != null) {
            ((MMAutoSwitchEditText)localObject).requestFocus();
          }
        }
        GMTrace.o(3328062783488L, 24796);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMAutoSwitchEditTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */