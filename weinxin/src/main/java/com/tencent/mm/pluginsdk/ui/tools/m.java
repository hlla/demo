package com.tencent.mm.pluginsdk.ui.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;

public final class m
{
  public static int sVw;
  
  static
  {
    GMTrace.i(1063272841216L, 7922);
    sVw = -1;
    GMTrace.o(1063272841216L, 7922);
  }
  
  public static void a(View paramView, VideoSightView paramVideoSightView)
  {
    GMTrace.i(1062870188032L, 7919);
    if ((paramView == null) || (paramVideoSightView == null))
    {
      v.e("VideoSightHelper", "null view object " + paramView + "," + paramVideoSightView);
      GMTrace.o(1062870188032L, 7919);
      return;
    }
    if (paramView.getVisibility() == 0) {
      paramVideoSightView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(final View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          GMTrace.i(1133200277504L, 8443);
          paramAnonymousInt1 = paramAnonymousInt4 - paramAnonymousInt2;
          if ((paramAnonymousInt1 > 0) && (paramAnonymousInt8 - paramAnonymousInt6 != paramAnonymousInt1)) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(1079513186304L, 8043);
                int j = paramAnonymousView.getResources().getDisplayMetrics().heightPixels - paramAnonymousView.getHeight() >>> 1;
                int i = (int)(j / 1.618D - (m.1.this.sVx.getHeight() >>> 1));
                if (i >= 0)
                {
                  if (m.sVw < 0) {
                    m.sVw = BackwardSupportUtil.b.a(paramAnonymousView.getContext(), 20.0F);
                  }
                  if (m.1.this.sVx.getHeight() + i + m.sVw <= j) {
                    break label206;
                  }
                  i -= m.1.this.sVx.getHeight() + i + m.sVw - j;
                }
                label206:
                for (;;)
                {
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)m.1.this.sVx.getLayoutParams();
                  if ((i > 0) && (i != localLayoutParams.bottomMargin))
                  {
                    v.i("VideoSightHelper", "setting tip marginBottom " + i);
                    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
                    m.1.this.sVx.setLayoutParams(localLayoutParams);
                  }
                  GMTrace.o(1079513186304L, 8043);
                  return;
                }
              }
            });
          }
          GMTrace.o(1133200277504L, 8443);
        }
      });
    }
    GMTrace.o(1062870188032L, 7919);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */