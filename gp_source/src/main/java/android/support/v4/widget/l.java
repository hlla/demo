package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public abstract class l
  extends BaseAdapter
  implements p, Filterable
{
  public boolean a = true;
  public Context b;
  public Cursor c = null;
  public boolean d = false;
  private m e;
  private o f;
  private DataSetObserver g;
  private int h;
  
  public l(Context paramContext)
  {
    this.b = paramContext;
    this.h = -1;
    this.e = new m(this);
    this.g = new n(this);
  }
  
  public final Cursor a()
  {
    return this.c;
  }
  
  public Cursor a(CharSequence paramCharSequence)
  {
    return this.c;
  }
  
  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public void a(Cursor paramCursor)
  {
    Cursor localCursor = this.c;
    if (paramCursor == localCursor) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Object localObject;
      if (localCursor != null)
      {
        localObject = this.e;
        if (localObject != null) {
          localCursor.unregisterContentObserver((ContentObserver)localObject);
        }
        localObject = this.g;
        if (localObject != null) {
          localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
        }
      }
      this.c = paramCursor;
      if (paramCursor != null)
      {
        localObject = this.e;
        if (localObject != null) {
          paramCursor.registerContentObserver((ContentObserver)localObject);
        }
        localObject = this.g;
        if (localObject == null) {}
        for (;;)
        {
          this.h = paramCursor.getColumnIndexOrThrow("_id");
          this.d = true;
          notifyDataSetChanged();
          paramCursor = localCursor;
          break;
          paramCursor.registerDataSetObserver((DataSetObserver)localObject);
        }
      }
      this.h = -1;
      this.d = false;
      notifyDataSetInvalidated();
      paramCursor = localCursor;
    }
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return a(paramContext, paramCursor, paramViewGroup);
  }
  
  public CharSequence b(Cursor paramCursor)
  {
    if (paramCursor != null) {
      return paramCursor.toString();
    }
    return "";
  }
  
  public int getCount()
  {
    if (this.d)
    {
      Cursor localCursor = this.c;
      if (localCursor != null) {
        return localCursor.getCount();
      }
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.d)
    {
      this.c.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = b(this.b, this.c, paramViewGroup);
      }
      a(localView, this.c);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.f == null) {
      this.f = new o(this);
    }
    return this.f;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.d)
    {
      Cursor localCursor = this.c;
      if (localCursor != null)
      {
        localCursor.moveToPosition(paramInt);
        return this.c;
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.d)
    {
      Cursor localCursor = this.c;
      l1 = l2;
      if (localCursor != null)
      {
        l1 = l2;
        if (localCursor.moveToPosition(paramInt)) {
          l1 = this.c.getLong(this.h);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.d) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.c.moveToPosition(paramInt))
    {
      paramView = new StringBuilder();
      paramView.append("couldn't move cursor to position ");
      paramView.append(paramInt);
      throw new IllegalStateException(paramView.toString());
    }
    View localView = paramView;
    if (paramView == null) {
      localView = a(this.b, this.c, paramViewGroup);
    }
    a(localView, this.c);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */