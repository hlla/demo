package com.tencent.mm.ui.base;

import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class t
  extends u
{
  public Queue<View> vlV;
  public HashMap<Object, Integer> vlW;
  public SparseArray<Object> vlX;
  
  public t()
  {
    GMTrace.i(3176396750848L, 23666);
    this.vlV = new LinkedList();
    this.vlW = new HashMap();
    this.vlX = new SparseArray();
    GMTrace.o(3176396750848L, 23666);
  }
  
  public final View Ag(int paramInt)
  {
    GMTrace.i(3177336274944L, 23673);
    Object localObject = this.vlX.get(paramInt);
    if (localObject != null)
    {
      localObject = (View)localObject;
      GMTrace.o(3177336274944L, 23673);
      return (View)localObject;
    }
    GMTrace.o(3177336274944L, 23673);
    return null;
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    GMTrace.i(3176933621760L, 23670);
    v.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    v.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.vlV.add((View)paramObject);
    this.vlW.remove(paramObject);
    this.vlX.remove(paramInt);
    GMTrace.o(3176933621760L, 23670);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    GMTrace.i(3177202057216L, 23672);
    if (paramView == paramObject)
    {
      GMTrace.o(3177202057216L, 23672);
      return true;
    }
    GMTrace.o(3177202057216L, 23672);
    return false;
  }
  
  public Object b(ViewGroup paramViewGroup, int paramInt)
  {
    GMTrace.i(3176799404032L, 23669);
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.vlV.size() > 0) {
      localObject = (View)this.vlV.poll();
    }
    localObject = d(paramInt, (View)localObject);
    v.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s position:%s", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.vlW.put(localObject, Integer.valueOf(paramInt));
    this.vlX.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    v.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(3176799404032L, 23669);
    return localObject;
  }
  
  public int bSt()
  {
    GMTrace.i(3177604710400L, 23675);
    GMTrace.o(3177604710400L, 23675);
    return -1;
  }
  
  public int bSu()
  {
    GMTrace.i(3177738928128L, 23676);
    GMTrace.o(3177738928128L, 23676);
    return -1;
  }
  
  public abstract Object d(int paramInt, View paramView);
  
  public void detach()
  {
    GMTrace.i(3177873145856L, 23677);
    reset();
    GMTrace.o(3177873145856L, 23677);
  }
  
  public final int j(Object paramObject)
  {
    GMTrace.i(3177067839488L, 23671);
    if (this.vlW.containsKey(paramObject))
    {
      int i = ((Integer)this.vlW.get(paramObject)).intValue();
      GMTrace.o(3177067839488L, 23671);
      return i;
    }
    GMTrace.o(3177067839488L, 23671);
    return -2;
  }
  
  public abstract MultiTouchImageView ng(int paramInt);
  
  public final void reset()
  {
    GMTrace.i(3177470492672L, 23674);
    this.vlV.clear();
    this.vlW.clear();
    this.vlX.clear();
    GMTrace.o(3177470492672L, 23674);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */