package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.c;
import android.support.v4.view.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public class ga
  extends b
{
  private final b b;
  public final RecyclerView c;
  
  public ga(RecyclerView paramRecyclerView)
  {
    this.c = paramRecyclerView;
    this.b = new gb(this);
  }
  
  public b a()
  {
    return this.b;
  }
  
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    parama.b(RecyclerView.class.getName());
    int i;
    int j;
    if ((!this.c.p()) && (this.c.getLayoutManager() != null))
    {
      paramView = this.c.getLayoutManager();
      RecyclerView localRecyclerView = paramView.m;
      fp localfp = localRecyclerView.B;
      fw localfw = localRecyclerView.G;
      if ((localRecyclerView.canScrollVertically(-1)) || (paramView.m.canScrollHorizontally(-1)))
      {
        parama.a(8192);
        parama.j(true);
      }
      if ((paramView.m.canScrollVertically(1)) || (paramView.m.canScrollHorizontally(1)))
      {
        parama.a(4096);
        parama.j(true);
      }
      i = paramView.b(localfp, localfw);
      j = paramView.c(localfp, localfw);
      if (Build.VERSION.SDK_INT < 21) {
        break label195;
      }
      paramView = new c(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false, 0));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        parama.a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramView.a);
      }
      return;
      label195:
      if (Build.VERSION.SDK_INT >= 19) {
        paramView = new c(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false));
      } else {
        paramView = new c(null);
      }
    }
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.c.p()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().a(paramAccessibilityEvent);
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    if (!super.a(paramView, paramInt, paramBundle))
    {
      boolean bool1 = bool2;
      if (!this.c.p())
      {
        bool1 = bool2;
        if (this.c.getLayoutManager() != null)
        {
          paramView = this.c.getLayoutManager();
          paramBundle = paramView.m;
          Object localObject = paramBundle.B;
          localObject = paramBundle.G;
          bool1 = bool2;
          if (paramBundle == null) {}
        }
      }
      int i;
      int j;
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        i = 0;
        if (i == 0)
        {
          bool1 = bool2;
          if (paramInt == 0) {}
        }
        else
        {
          paramView.m.c_(paramInt, i);
          bool1 = true;
        }
        return bool1;
      case 8192: 
        if (paramBundle.canScrollVertically(-1)) {}
        for (paramInt = -(paramView.g - paramView.g() - paramView.h());; paramInt = 0)
        {
          if (paramView.m.canScrollHorizontally(-1))
          {
            j = -(paramView.p - paramView.i() - paramView.j());
            i = paramInt;
            paramInt = j;
            break;
          }
          i = paramInt;
          paramInt = 0;
          break;
        }
      }
      if (paramBundle.canScrollVertically(1)) {}
      for (paramInt = paramView.g - paramView.g() - paramView.h();; paramInt = 0)
      {
        if (paramView.m.canScrollHorizontally(1))
        {
          j = paramView.p;
          int k = paramView.i();
          int m = paramView.j();
          i = paramInt;
          paramInt = j - k - m;
          break;
        }
        i = paramInt;
        paramInt = 0;
        break;
      }
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */