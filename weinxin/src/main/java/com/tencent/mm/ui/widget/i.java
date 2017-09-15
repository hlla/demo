package com.tencent.mm.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public class i
  implements DragSortListView.h
{
  private ListView Fg;
  private ImageView kXL;
  private Bitmap wvt;
  int wvu;
  
  public i(ListView paramListView)
  {
    GMTrace.i(13053345136640L, 97255);
    this.wvu = -16777216;
    this.Fg = paramListView;
    GMTrace.o(13053345136640L, 97255);
  }
  
  public final View Ck(int paramInt)
  {
    GMTrace.i(13053479354368L, 97256);
    Object localObject = this.Fg.getChildAt(this.Fg.getHeaderViewsCount() + paramInt - this.Fg.getFirstVisiblePosition());
    if (localObject == null)
    {
      GMTrace.o(13053479354368L, 97256);
      return null;
    }
    ((View)localObject).setPressed(false);
    ((View)localObject).setDrawingCacheEnabled(true);
    this.wvt = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.kXL == null) {
      this.kXL = new ImageView(this.Fg.getContext());
    }
    this.kXL.setBackgroundColor(this.wvu);
    this.kXL.setPadding(0, 0, 0, 0);
    this.kXL.setImageBitmap(this.wvt);
    this.kXL.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    localObject = this.kXL;
    GMTrace.o(13053479354368L, 97256);
    return (View)localObject;
  }
  
  public void d(Point paramPoint)
  {
    GMTrace.i(13053613572096L, 97257);
    GMTrace.o(13053613572096L, 97257);
  }
  
  public final void dB(View paramView)
  {
    GMTrace.i(13053747789824L, 97258);
    ((ImageView)paramView).setImageDrawable(null);
    v.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.wvt.toString() });
    this.wvt.recycle();
    this.wvt = null;
    GMTrace.o(13053747789824L, 97258);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */