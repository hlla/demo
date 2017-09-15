package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView
  extends QImageView
{
  private boolean DEBUG;
  private i hgT;
  private boolean hgU;
  private Runnable hgV;
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1281913520128L, 9551);
    this.DEBUG = false;
    this.hgT = null;
    this.hgU = false;
    this.hgV = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1283658350592L, 9564);
        QPictureView.a(QPictureView.this);
        GMTrace.o(1283658350592L, 9564);
      }
    };
    GMTrace.o(1281913520128L, 9551);
  }
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1282047737856L, 9552);
    this.DEBUG = false;
    this.hgT = null;
    this.hgU = false;
    this.hgV = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1283658350592L, 9564);
        QPictureView.a(QPictureView.this);
        GMTrace.o(1283658350592L, 9564);
      }
    };
    GMTrace.o(1282047737856L, 9552);
  }
  
  private static String av(Object paramObject)
  {
    GMTrace.i(1282181955584L, 9553);
    if (paramObject == null)
    {
      GMTrace.o(1282181955584L, 9553);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).wB() + " " + ((a)paramObject).wB().hashCode();
      GMTrace.o(1282181955584L, 9553);
      return (String)paramObject;
    }
    paramObject = String.valueOf(paramObject);
    GMTrace.o(1282181955584L, 9553);
    return (String)paramObject;
  }
  
  private static void aw(Object paramObject)
  {
    GMTrace.i(1282450391040L, 9555);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).wt();
    }
    GMTrace.o(1282450391040L, 9555);
  }
  
  private void onDetach()
  {
    GMTrace.i(1282718826496L, 9557);
    if (this.DEBUG) {
      v.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + bf.bJP().toString());
    }
    if (!this.hgU)
    {
      GMTrace.o(1282718826496L, 9557);
      return;
    }
    this.hgU = false;
    removeCallbacks(this.hgV);
    postDelayed(this.hgV, 500L);
    GMTrace.o(1282718826496L, 9557);
  }
  
  private void wC()
  {
    GMTrace.i(1282584608768L, 9556);
    if (this.DEBUG) {
      v.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + bf.bJP().toString());
    }
    removeCallbacks(this.hgV);
    if (this.hgU)
    {
      GMTrace.o(1282584608768L, 9556);
      return;
    }
    this.hgU = true;
    GMTrace.o(1282584608768L, 9556);
  }
  
  public void onAttachedToWindow()
  {
    GMTrace.i(1282853044224L, 9558);
    super.onAttachedToWindow();
    wC();
    GMTrace.o(1282853044224L, 9558);
  }
  
  public void onDetachedFromWindow()
  {
    GMTrace.i(1282987261952L, 9559);
    super.onDetachedFromWindow();
    onDetach();
    GMTrace.o(1282987261952L, 9559);
  }
  
  public void onFinishTemporaryDetach()
  {
    GMTrace.i(1283255697408L, 9561);
    super.onFinishTemporaryDetach();
    wC();
    GMTrace.o(1283255697408L, 9561);
  }
  
  public void onStartTemporaryDetach()
  {
    GMTrace.i(1283121479680L, 9560);
    super.onStartTemporaryDetach();
    onDetach();
    GMTrace.o(1283121479680L, 9560);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    GMTrace.i(1282316173312L, 9554);
    removeCallbacks(this.hgV);
    if ((paramDrawable == null) || (paramDrawable.equals(this.hgT)))
    {
      GMTrace.o(1282316173312L, 9554);
      return;
    }
    if (this.DEBUG) {
      v.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + av(this.hgT) + " new:" + av(paramDrawable) + " " + bf.bJP().toString());
    }
    aw(this.hgT);
    if ((paramDrawable instanceof i)) {}
    for (this.hgT = ((i)paramDrawable);; this.hgT = null)
    {
      if ((paramDrawable != null) && ((paramDrawable instanceof i))) {
        ((i)paramDrawable).ws();
      }
      super.setImageDrawable(paramDrawable);
      GMTrace.o(1282316173312L, 9554);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/ui/QPictureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */