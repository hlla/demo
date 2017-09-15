package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.ax.b;

public final class j
  extends b
{
  public LinearLayout wdh;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    GMTrace.i(14511218098176L, 108117);
    this.wdh = null;
    this.wdh = new LinearLayout(paramContext);
    this.wdh.setVisibility(8);
    ax.zj().hmh = new ax.b()
    {
      public final void zm()
      {
        GMTrace.i(14496185712640L, 108005);
        j.this.wdh.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(14508533743616L, 108097);
            if (j.this.wdh != null)
            {
              j.this.wdh.setVisibility(8);
              j.this.wdh.removeAllViews();
            }
            a locala = e.a(j.1.this.val$context, e.a.wcT, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(j.1.this.val$context, e.a.wcN, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              v.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              j.this.wdh.setVisibility(0);
              localObject = ((a)localObject).getView();
              j.this.wdh.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            GMTrace.o(14508533743616L, 108097);
          }
        });
        GMTrace.o(14496185712640L, 108005);
      }
    };
    ax.zj().hmh.zm();
    GMTrace.o(14511218098176L, 108117);
  }
  
  public final boolean Xd()
  {
    GMTrace.i(14511352315904L, 108118);
    if ((this.wdh != null) && (this.wdh.getVisibility() == 0))
    {
      GMTrace.o(14511352315904L, 108118);
      return true;
    }
    GMTrace.o(14511352315904L, 108118);
    return false;
  }
  
  public final void destroy()
  {
    GMTrace.i(14511754969088L, 108121);
    ax.zj().hmh = null;
    GMTrace.o(14511754969088L, 108121);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14511620751360L, 108120);
    GMTrace.o(14511620751360L, 108120);
    return -1;
  }
  
  public final View getView()
  {
    GMTrace.i(14511486533632L, 108119);
    LinearLayout localLinearLayout = this.wdh;
    GMTrace.o(14511486533632L, 108119);
    return localLinearLayout;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */