package com.tencent.mm.ui.a;

import android.view.View;
import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private final String TAG;
  private List<String> uVi;
  
  public b()
  {
    GMTrace.i(1874484789248L, 13966);
    this.TAG = "MicroMsg.Accessibility.Tool";
    this.uVi = new ArrayList();
    GMTrace.o(1874484789248L, 13966);
  }
  
  public final b SJ(String paramString)
  {
    GMTrace.i(1874619006976L, 13967);
    this.uVi.add(paramString);
    GMTrace.o(1874619006976L, 13967);
    return this;
  }
  
  public final void cX(View paramView)
  {
    GMTrace.i(1874753224704L, 13968);
    if ((paramView != null) && (this.uVi.size() > 0))
    {
      Iterator localIterator = this.uVi.iterator();
      String str2;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ",") {
        str2 = (String)localIterator.next();
      }
      paramView.setContentDescription(str1);
    }
    GMTrace.o(1874753224704L, 13968);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */