package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout
  extends OnLayoutChangedLinearLayout
{
  private int RQ;
  public String TAG;
  private boolean mHasInit;
  private boolean uPS;
  public a uPT;
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2532151656448L, 18866);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
    this.mHasInit = false;
    this.RQ = 0;
    this.uPS = false;
    this.TAG += getId();
    GMTrace.o(2532151656448L, 18866);
  }
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(2532285874176L, 18867);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
    GMTrace.o(2532285874176L, 18867);
  }
  
  public void nt(int paramInt)
  {
    GMTrace.i(2532688527360L, 18870);
    if (this.uPT != null) {
      this.uPT.nt(paramInt);
    }
    GMTrace.o(2532688527360L, 18870);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(2532420091904L, 18868);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    wg(paramInt4);
    GMTrace.o(2532420091904L, 18868);
  }
  
  public void wg(int paramInt)
  {
    GMTrace.i(2532554309632L, 18869);
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.RQ = paramInt;
      v.i(this.TAG, "init height:%d", new Object[] { Integer.valueOf(this.RQ) });
      if (this.uPT != null) {
        this.uPT.nt(-1);
      }
      if ((this.mHasInit) && (!this.uPS) && (this.RQ - paramInt > 100))
      {
        this.uPS = true;
        nt(-3);
        v.w(this.TAG, "show keyboard!! mHeight: " + this.RQ + " b: " + paramInt);
      }
      if ((this.mHasInit) && (this.uPS) && (this.RQ - paramInt <= 100))
      {
        this.uPS = false;
        nt(-2);
        v.w(this.TAG, "hide keyboard!! mHeight: " + this.RQ + " b: " + paramInt);
      }
      GMTrace.o(2532554309632L, 18869);
      return;
    }
    if (this.RQ < paramInt) {}
    for (int i = paramInt;; i = this.RQ)
    {
      this.RQ = i;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void nt(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/KeyboardLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */