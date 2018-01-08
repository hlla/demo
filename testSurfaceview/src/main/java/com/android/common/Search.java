package com.android.common;

import android.app.SearchableInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri.Builder;

public class Search
{
  public static final String SOURCE = "source";
  public static final String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";
  
  public static Cursor getSuggestions(Context paramContext, SearchableInfo paramSearchableInfo, String paramString)
  {
    return getSuggestions(paramContext, paramSearchableInfo, paramString, -1);
  }
  
  public static Cursor getSuggestions(Context paramContext, SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    if (paramSearchableInfo == null) {}
    do
    {
      return null;
      localObject = paramSearchableInfo.getSuggestAuthority();
    } while (localObject == null);
    Object localObject = new Uri.Builder().scheme("content").authority((String)localObject).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    paramSearchableInfo = null;
    if (str != null)
    {
      paramSearchableInfo = new String[1];
      paramSearchableInfo[0] = paramString;
    }
    for (;;)
    {
      if (paramInt > 0) {
        ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
      }
      paramString = ((Uri.Builder)localObject).build();
      return paramContext.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
      ((Uri.Builder)localObject).appendPath(paramString);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/Search.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */