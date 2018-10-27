package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

final class o
  extends Filter
{
  private p a;
  
  o(p paramp)
  {
    this.a = paramp;
  }
  
  public final CharSequence convertResultToString(Object paramObject)
  {
    return this.a.b((Cursor)paramObject);
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.a.a(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      localFilterResults.count = paramCharSequence.getCount();
      localFilterResults.values = paramCharSequence;
      return localFilterResults;
    }
    localFilterResults.count = 0;
    localFilterResults.values = null;
    return localFilterResults;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = this.a.a();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.a.a((Cursor)paramFilterResults.values);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */