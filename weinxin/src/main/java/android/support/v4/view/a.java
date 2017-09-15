package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.b;
import android.support.v4.view.a.c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class a
{
  private static final b wo;
  private static final Object wp;
  final Object wq = wo.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      wo = new c();
    }
    for (;;)
    {
      wp = wo.bI();
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        wo = new a();
      } else {
        wo = new d();
      }
    }
  }
  
  public static c A(View paramView)
  {
    return wo.b(wp, paramView);
  }
  
  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    wo.a(wp, paramView, paramInt);
  }
  
  public static void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    wo.d(wp, paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, b paramb)
  {
    wo.a(wp, paramView, paramb);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return wo.a(wp, paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    wo.b(wp, paramView, paramAccessibilityEvent);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    wo.c(wp, paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return wo.a(wp, paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return wo.a(wp, paramView, paramInt, paramBundle);
  }
  
  static class a
    extends a.d
  {
    public Object a(final a parama)
    {
      new b.1(new b.a()
      {
        public final void b(View paramAnonymousView, Object paramAnonymousObject)
        {
          parama.a(paramAnonymousView, new b(paramAnonymousObject));
        }
        
        public final boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          a.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public final void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          a.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      });
    }
    
    public final void a(Object paramObject, View paramView, int paramInt)
    {
      ((View.AccessibilityDelegate)paramObject).sendAccessibilityEvent(paramView, paramInt);
    }
    
    public final void a(Object paramObject, View paramView, b paramb)
    {
      paramb = paramb.zL;
      ((View.AccessibilityDelegate)paramObject).onInitializeAccessibilityNodeInfo(paramView, (AccessibilityNodeInfo)paramb);
    }
    
    public final boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return ((View.AccessibilityDelegate)paramObject).dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return ((View.AccessibilityDelegate)paramObject).onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public final void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ((View.AccessibilityDelegate)paramObject).onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final Object bI()
    {
      return new View.AccessibilityDelegate();
    }
    
    public final void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ((View.AccessibilityDelegate)paramObject).onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ((View.AccessibilityDelegate)paramObject).sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    }
  }
  
  static abstract interface b
  {
    public abstract Object a(a parama);
    
    public abstract void a(Object paramObject, View paramView, int paramInt);
    
    public abstract void a(Object paramObject, View paramView, b paramb);
    
    public abstract boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle);
    
    public abstract boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract c b(Object paramObject, View paramView);
    
    public abstract void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Object bI();
    
    public abstract void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
  }
  
  static final class c
    extends a.a
  {
    public final Object a(final a parama)
    {
      new c.1(new c.a()
      {
        public final Object B(View paramAnonymousView)
        {
          paramAnonymousView = a.A(paramAnonymousView);
          if (paramAnonymousView != null) {
            return paramAnonymousView.Ak;
          }
          return null;
        }
        
        public final void b(View paramAnonymousView, Object paramAnonymousObject)
        {
          parama.a(paramAnonymousView, new b(paramAnonymousObject));
        }
        
        public final boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return parama.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
        
        public final void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          a.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public final void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          a.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      });
    }
    
    public final boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
    {
      return ((View.AccessibilityDelegate)paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    
    public final c b(Object paramObject, View paramView)
    {
      paramObject = ((View.AccessibilityDelegate)paramObject).getAccessibilityNodeProvider(paramView);
      if (paramObject != null) {
        return new c(paramObject);
      }
      return null;
    }
  }
  
  static class d
    implements a.b
  {
    public Object a(a parama)
    {
      return null;
    }
    
    public void a(Object paramObject, View paramView, int paramInt) {}
    
    public void a(Object paramObject, View paramView, b paramb) {}
    
    public boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return false;
    }
    
    public boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return true;
    }
    
    public c b(Object paramObject, View paramView)
    {
      return null;
    }
    
    public void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public Object bI()
    {
      return null;
    }
    
    public void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */