package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.CompoundButton;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.v;

public class MMPinProgressBtn
  extends CompoundButton
{
  private Paint CT;
  private int sd;
  private int style;
  public int wtn;
  private Paint wto;
  private RectF wtp;
  private int wtq;
  private final float wtr;
  private Runnable wts;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1629269000192L, 12139);
    this.wtp = new RectF();
    this.wtr = 4.0F;
    this.wts = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1614639267840L, 12030);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          v.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          GMTrace.o(1614639267840L, 12030);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          v.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          GMTrace.o(1614639267840L, 12030);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        GMTrace.o(1614639267840L, 12030);
      }
    };
    b(paramContext, paramAttributeSet, 0);
    GMTrace.o(1629269000192L, 12139);
  }
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1629403217920L, 12140);
    this.wtp = new RectF();
    this.wtr = 4.0F;
    this.wts = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1614639267840L, 12030);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          v.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          GMTrace.o(1614639267840L, 12030);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          v.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          GMTrace.o(1614639267840L, 12030);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        GMTrace.o(1614639267840L, 12030);
      }
    };
    b(paramContext, paramAttributeSet, paramInt);
    GMTrace.o(1629403217920L, 12140);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    GMTrace.i(1629537435648L, 12141);
    this.wtn = 100;
    this.sd = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(a.d.hbp);
    int k = localResources.getColor(a.d.hbq);
    int j = k;
    int i = m;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.fqy, paramInt, 0);
      this.wtn = paramContext.getInteger(a.m.hfE, this.wtn);
      this.sd = paramContext.getInteger(a.m.hfF, this.sd);
      i = paramContext.getColor(a.m.hfC, m);
      j = paramContext.getColor(a.m.hfG, k);
      this.style = paramContext.getInteger(a.m.hfH, 0);
      this.wtq = paramContext.getDimensionPixelSize(a.m.hfD, localResources.getDimensionPixelSize(a.e.hbz));
      paramContext.recycle();
    }
    this.CT = new Paint();
    this.CT.setColor(i);
    this.CT.setStyle(Paint.Style.STROKE);
    this.CT.setStrokeWidth(4.0F);
    this.CT.setAntiAlias(true);
    this.wto = new Paint();
    this.wto.setColor(j);
    this.wto.setAntiAlias(true);
    setClickable(false);
    GMTrace.o(1629537435648L, 12141);
  }
  
  public final void caq()
  {
    GMTrace.i(1629940088832L, 12144);
    removeCallbacks(this.wts);
    post(this.wts);
    GMTrace.o(1629940088832L, 12144);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(1630208524288L, 12146);
    super.onDraw(paramCanvas);
    this.wtp.set(2.0F, 2.0F, this.wtq - 2.0F, this.wtq - 2.0F);
    this.wtp.offset((getWidth() - this.wtq) / 2, (getHeight() - this.wtq) / 2);
    paramCanvas.drawArc(this.wtp, 0.0F, 360.0F, true, this.CT);
    switch (this.style)
    {
    }
    for (;;)
    {
      GMTrace.o(1630208524288L, 12146);
      return;
      this.wtp.set(8.0F, 8.0F, this.wtq - 8.0F, this.wtq - 8.0F);
      this.wtp.offset((getWidth() - this.wtq) / 2, (getHeight() - this.wtq) / 2);
      paramCanvas.drawArc(this.wtp, -90.0F, 360.0F * (this.sd * 1.0F / this.wtn), true, this.wto);
      GMTrace.o(1630208524288L, 12146);
      return;
      this.wtp.set(2.0F, 2.0F, this.wtq - 2.0F, this.wtq - 2.0F);
      this.wtp.offset((getWidth() - this.wtq) / 2, (getHeight() - this.wtq) / 2);
      paramCanvas.drawArc(this.wtp, 270.0F, this.sd * 1.0F / this.wtn * 360.0F - 360.0F, true, this.wto);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1630074306560L, 12145);
    setMeasuredDimension(resolveSize(this.wtq, paramInt1), resolveSize(this.wtq, paramInt2));
    GMTrace.o(1630074306560L, 12145);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    GMTrace.i(1630476959744L, 12148);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      GMTrace.o(1630476959744L, 12148);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.wtn = SavedState.a(paramParcelable);
    this.sd = SavedState.b(paramParcelable);
    GMTrace.o(1630476959744L, 12148);
  }
  
  public Parcelable onSaveInstanceState()
  {
    GMTrace.i(1630342742016L, 12147);
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      SavedState.a((SavedState)localObject, this.wtn);
      SavedState.b((SavedState)localObject, this.sd);
      GMTrace.o(1630342742016L, 12147);
      return (Parcelable)localObject;
    }
    GMTrace.o(1630342742016L, 12147);
    return (Parcelable)localObject;
  }
  
  public final void setMax(int paramInt)
  {
    GMTrace.i(1629671653376L, 12142);
    this.wtn = Math.max(0, paramInt);
    invalidate();
    GMTrace.o(1629671653376L, 12142);
  }
  
  public final void setProgress(int paramInt)
  {
    GMTrace.i(1629805871104L, 12143);
    this.sd = Math.max(0, paramInt);
    this.sd = Math.min(paramInt, this.wtn);
    invalidate();
    GMTrace.o(1629805871104L, 12143);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int sd;
    private int wtn;
    
    static
    {
      GMTrace.i(1628195258368L, 12131);
      CREATOR = new Parcelable.Creator() {};
      GMTrace.o(1628195258368L, 12131);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      GMTrace.i(1627255734272L, 12124);
      this.sd = paramParcel.readInt();
      this.wtn = paramParcel.readInt();
      GMTrace.o(1627255734272L, 12124);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
      GMTrace.i(1627121516544L, 12123);
      GMTrace.o(1627121516544L, 12123);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      GMTrace.i(1627389952000L, 12125);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.sd);
      paramParcel.writeInt(this.wtn);
      GMTrace.o(1627389952000L, 12125);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/MMPinProgressBtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */