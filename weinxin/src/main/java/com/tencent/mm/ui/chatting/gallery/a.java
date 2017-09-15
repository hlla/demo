package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.storage.au;

public abstract class a
{
  protected b vNV;
  
  public a(b paramb)
  {
    GMTrace.i(2466787622912L, 18379);
    this.vNV = paramb;
    GMTrace.o(2466787622912L, 18379);
  }
  
  public final j Bf(int paramInt)
  {
    GMTrace.i(2467190276096L, 18382);
    if (this.vNV == null)
    {
      GMTrace.o(2467190276096L, 18382);
      return null;
    }
    Object localObject = this.vNV.Ag(paramInt);
    if (localObject == null)
    {
      GMTrace.o(2467190276096L, 18382);
      return null;
    }
    localObject = (j)((View)localObject).getTag();
    GMTrace.o(2467190276096L, 18382);
    return (j)localObject;
  }
  
  public final void Bg(int paramInt)
  {
    GMTrace.i(2467324493824L, 18383);
    if (this.vNV == null)
    {
      GMTrace.o(2467324493824L, 18383);
      return;
    }
    View localView = this.vNV.Ag(paramInt);
    if ((localView != null) && (localView.getTag() != null)) {
      a((j)localView.getTag(), this.vNV.Bh(paramInt), paramInt);
    }
    GMTrace.o(2467324493824L, 18383);
  }
  
  public boolean a(j paramj, au paramau, int paramInt)
  {
    GMTrace.i(2467056058368L, 18381);
    GMTrace.o(2467056058368L, 18381);
    return false;
  }
  
  public void detach()
  {
    GMTrace.i(2466921840640L, 18380);
    this.vNV = null;
    GMTrace.o(2466921840640L, 18380);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */