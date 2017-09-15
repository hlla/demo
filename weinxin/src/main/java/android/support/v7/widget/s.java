package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s
{
  final b VL;
  final a VM;
  final List<View> VN;
  
  s(b paramb)
  {
    this.VL = paramb;
    this.VM = new a();
    this.VN = new ArrayList();
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.VL.getChildCount();; paramInt = aM(paramInt))
    {
      this.VM.n(paramInt, paramBoolean);
      if (paramBoolean) {
        aN(paramView);
      }
      this.VL.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.VL.getChildCount();; paramInt = aM(paramInt))
    {
      this.VM.n(paramInt, paramBoolean);
      if (paramBoolean) {
        aN(paramView);
      }
      this.VL.addView(paramView, paramInt);
      return;
    }
  }
  
  final int aM(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.VL.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.VM.aP(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.VM.get(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  final View aN(int paramInt)
  {
    return this.VL.getChildAt(paramInt);
  }
  
  final void aN(View paramView)
  {
    this.VN.add(paramView);
    this.VL.aR(paramView);
  }
  
  final boolean aO(View paramView)
  {
    if (this.VN.remove(paramView))
    {
      this.VL.aS(paramView);
      return true;
    }
    return false;
  }
  
  final boolean aP(View paramView)
  {
    return this.VN.contains(paramView);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = aM(paramInt);
    this.VM.aO(paramInt);
    this.VL.detachViewFromParent(paramInt);
  }
  
  final int eG()
  {
    return this.VL.getChildCount();
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = aM(paramInt);
    return this.VL.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.VL.getChildCount() - this.VN.size();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.VL.indexOfChild(paramView);
    if (i == -1) {}
    while (this.VM.get(i)) {
      return -1;
    }
    return i - this.VM.aP(i);
  }
  
  public final String toString()
  {
    return this.VM.toString() + ", hidden list:" + this.VN.size();
  }
  
  static final class a
  {
    long VO = 0L;
    a VP;
    
    private void eH()
    {
      if (this.VP == null) {
        this.VP = new a();
      }
    }
    
    final boolean aO(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.eH();
        locala = locala.VP;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.VO & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.VO &= (l1 ^ 0xFFFFFFFFFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.VO;
        locala.VO = (Long.rotateRight((l1 ^ 0xFFFFFFFFFFFFFFFF) & locala.VO, 1) | l2 & l1);
        if (locala.VP != null)
        {
          if (locala.VP.get(0)) {
            locala.set(63);
          }
          locala.VP.aO(0);
        }
        return bool;
      }
    }
    
    final int aP(int paramInt)
    {
      if (this.VP == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.VO);
        }
        return Long.bitCount(this.VO & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.VO & (1L << paramInt) - 1L);
      }
      return this.VP.aP(paramInt - 64) + Long.bitCount(this.VO);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.VP == null) {
          return;
        }
        locala = locala.VP;
        paramInt -= 64;
      }
      locala.VO &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
    }
    
    final boolean get(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.eH();
        locala = locala.VP;
        paramInt -= 64;
      }
      return (locala.VO & 1L << paramInt) != 0L;
    }
    
    final void n(int paramInt, boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.eH();
        locala = locala.VP;
        paramInt -= 64;
      }
      if ((locala.VO & 0x8000000000000000) != 0L)
      {
        paramBoolean = true;
        label47:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.VO;
        locala.VO = (((l1 ^ 0xFFFFFFFFFFFFFFFF) & locala.VO) << 1 | l2 & l1);
        if (!bool) {
          break label132;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.VP == null)) {
          return;
        }
        locala.eH();
        locala = locala.VP;
        paramInt = 0;
        bool = paramBoolean;
        break;
        paramBoolean = false;
        break label47;
        label132:
        locala.clear(paramInt);
      }
    }
    
    final void set(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.eH();
        locala = locala.VP;
        paramInt -= 64;
      }
      locala.VO |= 1L << paramInt;
    }
    
    public final String toString()
    {
      if (this.VP == null) {
        return Long.toBinaryString(this.VO);
      }
      return this.VP.toString() + "xx" + Long.toBinaryString(this.VO);
    }
  }
  
  static abstract interface b
  {
    public abstract RecyclerView.t aQ(View paramView);
    
    public abstract void aR(View paramView);
    
    public abstract void aS(View paramView);
    
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract int indexOfChild(View paramView);
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */