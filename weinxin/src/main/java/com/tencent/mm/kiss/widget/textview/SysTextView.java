package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public class SysTextView
  extends TextView
  implements a
{
  private static boolean haQ;
  private static Field haR;
  public g haC;
  
  static
  {
    GMTrace.i(441307889664L, 3288);
    haQ = false;
    haR = null;
    GMTrace.o(441307889664L, 3288);
  }
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(435939180544L, 3248);
    this.haC = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    GMTrace.o(435939180544L, 3248);
  }
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(436073398272L, 3249);
    this.haC = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    GMTrace.o(436073398272L, 3249);
  }
  
  private void init()
  {
    GMTrace.i(436207616000L, 3250);
    super.setText(" ", TextView.BufferType.SPANNABLE);
    this.haC.haE = new com.tencent.mm.kiss.widget.textview.a.a();
    this.haC.haE.textColor = super.getTextColors().getDefaultColor();
    this.haC.haE.haq = super.getEllipsize();
    this.haC.haE.gravity = super.getGravity();
    this.haC.haE.haV = super.getTextSize();
    if (!haQ) {
      try
      {
        if (haR == null)
        {
          Field localField = TextView.class.getDeclaredField("mSingleLine");
          haR = localField;
          localField.setAccessible(true);
        }
        if (haR.getBoolean(this)) {
          this.haC.haE.maxLines = 1;
        }
        GMTrace.o(436207616000L, 3250);
        return;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", new Object[] { localException.getMessage() });
        haQ = true;
      }
    }
    GMTrace.o(436207616000L, 3250);
  }
  
  public void dispatchProvideStructure(ViewStructure paramViewStructure)
  {
    GMTrace.i(441039454208L, 3286);
    GMTrace.o(441039454208L, 3286);
  }
  
  public int getBaseline()
  {
    GMTrace.i(441173671936L, 3287);
    try
    {
      int i = super.getBaseline();
      GMTrace.o(441173671936L, 3287);
      return i;
    }
    catch (Throwable localThrowable)
    {
      v.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      GMTrace.o(441173671936L, 3287);
    }
    return -1;
  }
  
  public int getLineCount()
  {
    GMTrace.i(438623535104L, 3268);
    if (this.haC == null)
    {
      GMTrace.o(438623535104L, 3268);
      return 0;
    }
    int i = this.haC.getLineCount();
    GMTrace.o(438623535104L, 3268);
    return i;
  }
  
  public int getLineHeight()
  {
    GMTrace.i(438757752832L, 3269);
    if (this.haC == null)
    {
      GMTrace.o(438757752832L, 3269);
      return 0;
    }
    int i = this.haC.getLineHeight();
    GMTrace.o(438757752832L, 3269);
    return i;
  }
  
  public int getSelectionEnd()
  {
    GMTrace.i(439026188288L, 3271);
    if (getText() == null)
    {
      GMTrace.o(439026188288L, 3271);
      return -1;
    }
    int i = Selection.getSelectionEnd(getText());
    GMTrace.o(439026188288L, 3271);
    return i;
  }
  
  public int getSelectionStart()
  {
    GMTrace.i(438891970560L, 3270);
    if (getText() == null)
    {
      GMTrace.o(438891970560L, 3270);
      return -1;
    }
    int i = Selection.getSelectionStart(getText());
    GMTrace.o(438891970560L, 3270);
    return i;
  }
  
  public CharSequence getText()
  {
    GMTrace.i(438355099648L, 3266);
    if (this.haC == null)
    {
      GMTrace.o(438355099648L, 3266);
      return null;
    }
    CharSequence localCharSequence = this.haC.getText();
    GMTrace.o(438355099648L, 3266);
    return localCharSequence;
  }
  
  public float getTextSize()
  {
    GMTrace.i(438489317376L, 3267);
    if (this.haC == null)
    {
      GMTrace.o(438489317376L, 3267);
      return 0.0F;
    }
    float f = this.haC.getTextSize();
    GMTrace.o(438489317376L, 3267);
    return f;
  }
  
  protected void onAttachedToWindow()
  {
    GMTrace.i(440099930112L, 3279);
    super.onAttachedToWindow();
    GMTrace.o(440099930112L, 3279);
  }
  
  protected void onDetachedFromWindow()
  {
    GMTrace.i(440234147840L, 3280);
    super.onDetachedFromWindow();
    GMTrace.o(440234147840L, 3280);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(439563059200L, 3275);
    try
    {
      g localg = this.haC;
      if (localg == null)
      {
        GMTrace.o(439563059200L, 3275);
        return;
      }
      this.haC.onDraw(paramCanvas);
      GMTrace.o(439563059200L, 3275);
      return;
    }
    catch (Throwable paramCanvas)
    {
      v.printErrStackTrace("MicroMsg.SysPLTextView", paramCanvas, "", new Object[0]);
      GMTrace.o(439563059200L, 3275);
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    GMTrace.i(440502583296L, 3282);
    super.onFinishTemporaryDetach();
    GMTrace.o(440502583296L, 3282);
  }
  
  public void onHoverChanged(boolean paramBoolean)
  {
    GMTrace.i(440636801024L, 3283);
    GMTrace.o(440636801024L, 3283);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(440771018752L, 3284);
    GMTrace.o(440771018752L, 3284);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(439965712384L, 3278);
    try
    {
      Point localPoint = this.haC.aG(paramInt1, paramInt2);
      if (localPoint != null)
      {
        setMeasuredDimension(localPoint.x, localPoint.y);
        GMTrace.o(439965712384L, 3278);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        GMTrace.o(439965712384L, 3278);
        return;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.SysPLTextView", localException, "onMeasure error: %s", new Object[] { localException.getMessage() });
        GMTrace.o(439965712384L, 3278);
      }
      localThrowable = localThrowable;
      v.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      GMTrace.o(439965712384L, 3278);
      return;
    }
  }
  
  public boolean onPreDraw()
  {
    GMTrace.i(436878704640L, 3255);
    GMTrace.o(436878704640L, 3255);
    return true;
  }
  
  public void onProvideStructure(ViewStructure paramViewStructure)
  {
    GMTrace.i(440905236480L, 3285);
    try
    {
      super.onProvideStructure(paramViewStructure);
      GMTrace.o(440905236480L, 3285);
      return;
    }
    catch (Exception paramViewStructure)
    {
      v.printErrStackTrace("MicroMsg.SysPLTextView", paramViewStructure, "onProvideStructure error: %s", new Object[] { paramViewStructure.getMessage() });
      GMTrace.o(440905236480L, 3285);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    GMTrace.i(440368365568L, 3281);
    super.onStartTemporaryDetach();
    GMTrace.o(440368365568L, 3281);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(439294623744L, 3273);
    if (this.haC.wb() == null)
    {
      GMTrace.o(439294623744L, 3273);
      return false;
    }
    boolean bool1 = this.haC.q(paramMotionEvent);
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    if (bool1)
    {
      GMTrace.o(439294623744L, 3273);
      return true;
    }
    GMTrace.o(439294623744L, 3273);
    return bool2;
  }
  
  public boolean performClick()
  {
    GMTrace.i(439428841472L, 3274);
    if (this.haC == null)
    {
      GMTrace.o(439428841472L, 3274);
      return false;
    }
    if (!this.haC.performClick())
    {
      GMTrace.o(439428841472L, 3274);
      return false;
    }
    boolean bool = super.performClick();
    GMTrace.o(439428841472L, 3274);
    return bool;
  }
  
  public final void q(CharSequence paramCharSequence)
  {
    GMTrace.i(437147140096L, 3257);
    if (this.haC == null)
    {
      super.setText("");
      GMTrace.o(437147140096L, 3257);
      return;
    }
    this.haC.setText(paramCharSequence, false);
    GMTrace.o(437147140096L, 3257);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    GMTrace.i(439160406016L, 3272);
    super.setClickable(paramBoolean);
    if (this.haC == null)
    {
      GMTrace.o(439160406016L, 3272);
      return;
    }
    this.haC.haK = paramBoolean;
    GMTrace.o(439160406016L, 3272);
  }
  
  public void setGravity(int paramInt)
  {
    GMTrace.i(437684011008L, 3261);
    if (this.haC == null)
    {
      GMTrace.o(437684011008L, 3261);
      return;
    }
    this.haC.setGravity(paramInt);
    GMTrace.o(437684011008L, 3261);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    GMTrace.i(438086664192L, 3264);
    if (this.haC != null) {
      this.haC.wd();
    }
    super.setLayoutParams(paramLayoutParams);
    GMTrace.o(438086664192L, 3264);
  }
  
  public void setLines(int paramInt)
  {
    GMTrace.i(436744486912L, 3254);
    if (this.haC == null)
    {
      GMTrace.o(436744486912L, 3254);
      return;
    }
    this.haC.setLines(paramInt);
    GMTrace.o(436744486912L, 3254);
  }
  
  public void setMaxLines(int paramInt)
  {
    GMTrace.i(437818228736L, 3262);
    if (this.haC == null)
    {
      GMTrace.o(437818228736L, 3262);
      return;
    }
    this.haC.setMaxLines(paramInt);
    GMTrace.o(437818228736L, 3262);
  }
  
  public void setMinLines(int paramInt)
  {
    GMTrace.i(437952446464L, 3263);
    if (this.haC == null)
    {
      GMTrace.o(437952446464L, 3263);
      return;
    }
    g localg = this.haC;
    if (localg.haE.minLines != paramInt)
    {
      localg.haE.minLines = paramInt;
      localg.wd();
      localg.haN.requestLayout();
      localg.haN.invalidate();
    }
    GMTrace.o(437952446464L, 3263);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(438220881920L, 3265);
    if (this.haC != null) {
      this.haC.wd();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    GMTrace.o(438220881920L, 3265);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    GMTrace.i(436610269184L, 3253);
    if (this.haC == null)
    {
      GMTrace.o(436610269184L, 3253);
      return;
    }
    this.haC.setSingleLine(paramBoolean);
    GMTrace.o(436610269184L, 3253);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    GMTrace.i(437012922368L, 3256);
    q(paramCharSequence);
    GMTrace.o(437012922368L, 3256);
  }
  
  public void setTextColor(int paramInt)
  {
    GMTrace.i(437549793280L, 3260);
    if (this.haC == null)
    {
      GMTrace.o(437549793280L, 3260);
      return;
    }
    this.haC.setTextColor(paramInt);
    GMTrace.o(437549793280L, 3260);
  }
  
  public void setTextSize(float paramFloat)
  {
    GMTrace.i(437281357824L, 3258);
    setTextSize(0, paramFloat);
    GMTrace.o(437281357824L, 3258);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    GMTrace.i(437415575552L, 3259);
    if (this.haC == null)
    {
      GMTrace.o(437415575552L, 3259);
      return;
    }
    this.haC.setTextSize(paramInt, paramFloat);
    GMTrace.o(437415575552L, 3259);
  }
  
  public final int vT()
  {
    GMTrace.i(439697276928L, 3276);
    if (this.haC == null)
    {
      GMTrace.o(439697276928L, 3276);
      return 0;
    }
    int i = this.haC.haH;
    GMTrace.o(439697276928L, 3276);
    return i;
  }
  
  public final int vU()
  {
    GMTrace.i(439831494656L, 3277);
    if (this.haC == null)
    {
      GMTrace.o(439831494656L, 3277);
      return 0;
    }
    int i = this.haC.haI;
    GMTrace.o(439831494656L, 3277);
    return i;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a vY()
  {
    GMTrace.i(436476051456L, 3252);
    if (this.haC == null)
    {
      GMTrace.o(436476051456L, 3252);
      return null;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.haC.haE;
    GMTrace.o(436476051456L, 3252);
    return locala;
  }
  
  protected final f wc()
  {
    GMTrace.i(436341833728L, 3251);
    if (this.haC == null)
    {
      GMTrace.o(436341833728L, 3251);
      return null;
    }
    f localf = this.haC.wc();
    GMTrace.o(436341833728L, 3251);
    return localf;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/SysTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */