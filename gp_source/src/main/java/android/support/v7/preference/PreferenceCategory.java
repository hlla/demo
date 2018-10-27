package android.support.v7.preference;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.a.o;
import android.support.v4.view.a.a;
import android.support.v4.view.a.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class PreferenceCategory
  extends PreferenceGroup
{
  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130969430, 16842892), (byte)0);
  }
  
  private PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(a parama)
  {
    super.a(parama);
    Object localObject;
    if (Build.VERSION.SDK_INT < 28)
    {
      if (Build.VERSION.SDK_INT < 19) {
        break label205;
      }
      localObject = parama.a.getCollectionItemInfo();
      if (localObject == null) {
        break label199;
      }
      localObject = new d(localObject);
    }
    for (;;)
    {
      if (localObject != null) {
        if (Build.VERSION.SDK_INT < 19) {
          break label194;
        }
      }
      label194:
      for (int i = ((AccessibilityNodeInfo.CollectionItemInfo)((d)localObject).a).getRowIndex();; i = 0)
      {
        if (Build.VERSION.SDK_INT >= 19) {}
        for (int j = ((AccessibilityNodeInfo.CollectionItemInfo)((d)localObject).a).getRowSpan();; j = 0)
        {
          if (Build.VERSION.SDK_INT >= 19) {}
          for (int k = ((AccessibilityNodeInfo.CollectionItemInfo)((d)localObject).a).getColumnIndex();; k = 0)
          {
            if (Build.VERSION.SDK_INT >= 19) {}
            for (int m = ((AccessibilityNodeInfo.CollectionItemInfo)((d)localObject).a).getColumnSpan();; m = 0)
            {
              if (Build.VERSION.SDK_INT >= 21) {}
              for (boolean bool = ((AccessibilityNodeInfo.CollectionItemInfo)((d)localObject).a).isSelected();; bool = false)
              {
                parama.a(d.a(i, j, k, m, true, bool));
                return;
              }
            }
          }
        }
      }
      label199:
      localObject = null;
      continue;
      label205:
      localObject = null;
    }
  }
  
  public final void a(ao paramao)
  {
    super.a(paramao);
    if (Build.VERSION.SDK_INT >= 28) {
      paramao.c.setAccessibilityHeading(true);
    }
  }
  
  public final boolean c_()
  {
    return super.i() ^ true;
  }
  
  public final boolean i()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/PreferenceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */