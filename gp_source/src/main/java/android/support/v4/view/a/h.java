package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class h
{
  public final AccessibilityRecord a;
  
  @Deprecated
  public h(Object paramObject)
  {
    this.a = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (this != paramObject)
    {
      boolean bool1 = bool2;
      AccessibilityRecord localAccessibilityRecord;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (getClass() == paramObject.getClass())
        {
          paramObject = (h)paramObject;
          localAccessibilityRecord = this.a;
          if (localAccessibilityRecord != null) {
            break label55;
          }
          bool1 = bool2;
          if (((h)paramObject).a != null) {}
        }
      }
      label55:
      while (localAccessibilityRecord.equals(((h)paramObject).a))
      {
        bool1 = true;
        return bool1;
      }
      return false;
    }
    return true;
  }
  
  @Deprecated
  public final int hashCode()
  {
    AccessibilityRecord localAccessibilityRecord = this.a;
    if (localAccessibilityRecord != null) {
      return localAccessibilityRecord.hashCode();
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */