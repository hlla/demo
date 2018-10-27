package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class u
{
  public boolean a;
  private ViewParent b;
  private ViewParent c;
  private int[] d;
  private final View e;
  
  public u(View paramView)
  {
    this.e = paramView;
  }
  
  private final void a(int paramInt, ViewParent paramViewParent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.c = paramViewParent;
      return;
    }
    this.b = paramViewParent;
  }
  
  private final ViewParent c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.b;
    }
    return this.c;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.a) {
      ac.G(this.e);
    }
    this.a = paramBoolean;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a)
    {
      ViewParent localViewParent = c(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = ay.a(localViewParent, this.e, paramFloat1, paramFloat2);
      }
    }
    return bool1;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a)
    {
      ViewParent localViewParent = c(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = ay.a(localViewParent, this.e, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return bool1;
  }
  
  public final boolean a(int paramInt)
  {
    return c(paramInt) != null;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if (!a(paramInt2))
    {
      if (this.a)
      {
        ViewParent localViewParent = this.e.getParent();
        View localView1 = this.e;
        while (localViewParent != null)
        {
          if (ay.a(localViewParent, localView1, this.e, paramInt1, paramInt2))
          {
            a(paramInt2, localViewParent);
            Object localObject = this.e;
            if ((localViewParent instanceof w)) {
              ((w)localViewParent).b((View)localObject, paramInt1, paramInt2);
            }
            for (;;)
            {
              return true;
              if (paramInt2 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                  try
                  {
                    localViewParent.onNestedScrollAccepted(localView1, (View)localObject, paramInt1);
                  }
                  catch (AbstractMethodError localAbstractMethodError)
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("ViewParent ");
                    ((StringBuilder)localObject).append(localViewParent);
                    ((StringBuilder)localObject).append(" does not implement interface ");
                    ((StringBuilder)localObject).append("method onNestedScrollAccepted");
                    Log.e("ViewParentCompat", ((StringBuilder)localObject).toString(), localAbstractMethodError);
                  }
                } else if ((localViewParent instanceof v)) {
                  ((v)localViewParent).onNestedScrollAccepted(localAbstractMethodError, (View)localObject, paramInt1);
                }
              }
            }
          }
          if ((localViewParent instanceof View)) {
            View localView2 = (View)localViewParent;
          }
          localViewParent = localViewParent.getParent();
        }
      }
      return false;
    }
    return true;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    if (this.a)
    {
      ViewParent localViewParent = c(paramInt5);
      if (localViewParent == null) {
        break label277;
      }
      if (paramInt1 != 0) {}
      while ((paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0))
      {
        int j;
        int i;
        if (paramArrayOfInt != null)
        {
          this.e.getLocationInWindow(paramArrayOfInt);
          j = paramArrayOfInt[0];
          i = paramArrayOfInt[1];
        }
        for (;;)
        {
          View localView = this.e;
          if ((localViewParent instanceof w)) {
            ((w)localViewParent).a(localView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
          }
          for (;;)
          {
            if (paramArrayOfInt != null)
            {
              this.e.getLocationInWindow(paramArrayOfInt);
              paramArrayOfInt[0] -= j;
              paramArrayOfInt[1] -= i;
            }
            return true;
            if (paramInt5 == 0) {
              if (Build.VERSION.SDK_INT >= 21) {
                try
                {
                  localViewParent.onNestedScroll(localView, paramInt1, paramInt2, paramInt3, paramInt4);
                }
                catch (AbstractMethodError localAbstractMethodError)
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("ViewParent ");
                  localStringBuilder.append(localViewParent);
                  localStringBuilder.append(" does not implement interface ");
                  localStringBuilder.append("method onNestedScroll");
                  Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
                }
              } else if ((localViewParent instanceof v)) {
                ((v)localViewParent).onNestedScroll(localAbstractMethodError, paramInt1, paramInt2, paramInt3, paramInt4);
              }
            }
          }
          i = 0;
          j = 0;
        }
      }
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
      }
    }
    return false;
    label277:
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    if (this.a)
    {
      ViewParent localViewParent = c(paramInt3);
      if (localViewParent == null) {
        break label310;
      }
      if (paramInt1 != 0) {}
      while (paramInt2 != 0)
      {
        int j;
        int i;
        if (paramArrayOfInt2 != null)
        {
          this.e.getLocationInWindow(paramArrayOfInt2);
          j = paramArrayOfInt2[0];
          i = paramArrayOfInt2[1];
        }
        for (;;)
        {
          if (paramArrayOfInt1 == null)
          {
            if (this.d == null) {
              this.d = new int[2];
            }
            paramArrayOfInt1 = this.d;
          }
          for (;;)
          {
            paramArrayOfInt1[0] = 0;
            paramArrayOfInt1[1] = 0;
            View localView = this.e;
            if ((localViewParent instanceof w)) {
              ((w)localViewParent).a(localView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
            }
            for (;;)
            {
              if (paramArrayOfInt2 != null)
              {
                this.e.getLocationInWindow(paramArrayOfInt2);
                paramArrayOfInt2[0] -= j;
                paramArrayOfInt2[1] -= i;
              }
              return (paramArrayOfInt1[0] != 0) || (paramArrayOfInt1[1] != 0);
              if (paramInt3 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                  try
                  {
                    localViewParent.onNestedPreScroll(localView, paramInt1, paramInt2, paramArrayOfInt1);
                  }
                  catch (AbstractMethodError localAbstractMethodError)
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("ViewParent ");
                    localStringBuilder.append(localViewParent);
                    localStringBuilder.append(" does not implement interface ");
                    localStringBuilder.append("method onNestedPreScroll");
                    Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
                  }
                } else if ((localViewParent instanceof v)) {
                  ((v)localViewParent).onNestedPreScroll(localAbstractMethodError, paramInt1, paramInt2, paramArrayOfInt1);
                }
              }
            }
          }
          i = 0;
          j = 0;
        }
      }
      if (paramArrayOfInt2 != null)
      {
        paramArrayOfInt2[0] = 0;
        paramArrayOfInt2[1] = 0;
      }
    }
    return false;
    label310:
    return false;
  }
  
  public final void b(int paramInt)
  {
    ViewParent localViewParent = c(paramInt);
    View localView;
    if (localViewParent != null)
    {
      localView = this.e;
      if (!(localViewParent instanceof w)) {
        break label40;
      }
      ((w)localViewParent).b(localView, paramInt);
    }
    for (;;)
    {
      a(paramInt, null);
      return;
      label40:
      if (paramInt == 0) {
        if (Build.VERSION.SDK_INT >= 21) {
          try
          {
            localViewParent.onStopNestedScroll(localView);
          }
          catch (AbstractMethodError localAbstractMethodError)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ViewParent ");
            localStringBuilder.append(localViewParent);
            localStringBuilder.append(" does not implement interface ");
            localStringBuilder.append("method onStopNestedScroll");
            Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
          }
        } else if ((localViewParent instanceof v)) {
          ((v)localViewParent).onStopNestedScroll(localAbstractMethodError);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */