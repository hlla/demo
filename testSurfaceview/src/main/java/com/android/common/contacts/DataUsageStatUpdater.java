package com.android.common.contacts;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataUsageStatUpdater
{
  private static final String TAG = DataUsageStatUpdater.class.getSimpleName();
  private final ContentResolver mResolver;
  
  public DataUsageStatUpdater(Context paramContext)
  {
    this.mResolver = paramContext.getContentResolver();
  }
  
  private boolean update(Collection<Long> paramCollection1, Collection<Long> paramCollection2, String paramString)
  {
    long l = System.currentTimeMillis();
    if (Build.VERSION.SDK_INT >= 14) {
      if (paramCollection2.isEmpty()) {
        if (Log.isLoggable(TAG, 3)) {
          Log.d(TAG, "Given list for data IDs is null. Ignoring.");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          paramCollection1 = DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(TextUtils.join(",", paramCollection2)).appendQueryParameter("type", paramString).build();
          if (this.mResolver.update(paramCollection1, new ContentValues(), null, null) > 0) {
            return true;
          }
        } while (!Log.isLoggable(TAG, 3));
        Log.d(TAG, "update toward data rows " + paramCollection2 + " failed");
        return false;
        if (!paramCollection1.isEmpty()) {
          break;
        }
      } while (!Log.isLoggable(TAG, 3));
      Log.d(TAG, "Given list for contact IDs is null. Ignoring.");
      return false;
      paramCollection2 = new StringBuilder();
      paramString = new ArrayList();
      Object localObject = new String[paramCollection1.size()];
      Iterator localIterator = paramCollection1.iterator();
      while (localIterator.hasNext()) {
        paramString.add(String.valueOf(((Long)localIterator.next()).longValue()));
      }
      Arrays.fill((Object[])localObject, "?");
      paramCollection2.append("_id IN (").append(TextUtils.join(",", (Object[])localObject)).append(")");
      if (Log.isLoggable(TAG, 3))
      {
        Log.d(TAG, "contactId where: " + paramCollection2.toString());
        Log.d(TAG, "contactId selection: " + paramString);
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("last_time_contacted", Long.valueOf(l));
      if (this.mResolver.update(ContactsContract.Contacts.CONTENT_URI, (ContentValues)localObject, paramCollection2.toString(), (String[])paramString.toArray(new String[0])) > 0) {
        return true;
      }
    } while (!Log.isLoggable(TAG, 3));
    Log.d(TAG, "update toward raw contacts " + paramCollection1 + " failed");
    return false;
  }
  
  public boolean updateWithAddress(Collection<String> paramCollection)
  {
    if (Log.isLoggable(TAG, 3)) {
      Log.d(TAG, "updateWithAddress: " + Arrays.toString(paramCollection.toArray()));
    }
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = new StringBuilder();
      Object localObject3 = new String[paramCollection.size()];
      ((ArrayList)localObject1).addAll(paramCollection);
      Arrays.fill((Object[])localObject3, "?");
      ((StringBuilder)localObject2).append("data1 IN (").append(TextUtils.join(",", (Object[])localObject3)).append(")");
      paramCollection = this.mResolver;
      localObject3 = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
      paramCollection = paramCollection.query((Uri)localObject3, new String[] { "contact_id", "_id" }, (String)localObject2, (String[])localObject1, null);
      if (paramCollection == null) {
        Log.w(TAG, "Cursor for Email.CONTENT_URI became null.");
      }
    }
    else
    {
      return false;
    }
    Object localObject1 = new HashSet(paramCollection.getCount());
    Object localObject2 = new HashSet(paramCollection.getCount());
    try
    {
      paramCollection.move(-1);
      while (paramCollection.moveToNext())
      {
        ((Set)localObject1).add(Long.valueOf(paramCollection.getLong(0)));
        ((Set)localObject2).add(Long.valueOf(paramCollection.getLong(1)));
      }
    }
    finally
    {
      paramCollection.close();
    }
    return update(localCollection, (Collection)localObject2, "long_text");
  }
  
  public boolean updateWithPhoneNumber(Collection<String> paramCollection)
  {
    if (Log.isLoggable(TAG, 3)) {
      Log.d(TAG, "updateWithPhoneNumber: " + Arrays.toString(paramCollection.toArray()));
    }
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = new StringBuilder();
      Object localObject3 = new String[paramCollection.size()];
      ((ArrayList)localObject1).addAll(paramCollection);
      Arrays.fill((Object[])localObject3, "?");
      ((StringBuilder)localObject2).append("data1 IN (").append(TextUtils.join(",", (Object[])localObject3)).append(")");
      paramCollection = this.mResolver;
      localObject3 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
      paramCollection = paramCollection.query((Uri)localObject3, new String[] { "contact_id", "_id" }, (String)localObject2, (String[])localObject1, null);
      if (paramCollection == null) {
        Log.w(TAG, "Cursor for Phone.CONTENT_URI became null.");
      }
    }
    else
    {
      return false;
    }
    Object localObject1 = new HashSet(paramCollection.getCount());
    Object localObject2 = new HashSet(paramCollection.getCount());
    try
    {
      paramCollection.move(-1);
      while (paramCollection.moveToNext())
      {
        ((Set)localObject1).add(Long.valueOf(paramCollection.getLong(0)));
        ((Set)localObject2).add(Long.valueOf(paramCollection.getLong(1)));
      }
    }
    finally
    {
      paramCollection.close();
    }
    return update(localCollection, (Collection)localObject2, "short_text");
  }
  
  public boolean updateWithRfc822Address(Collection<CharSequence> paramCollection)
  {
    if (paramCollection == null) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(((CharSequence)paramCollection.next()).toString().trim());
      int j = arrayOfRfc822Token.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(arrayOfRfc822Token[i].getAddress());
        i += 1;
      }
    }
    return updateWithAddress(localHashSet);
  }
  
  public static final class DataUsageFeedback
  {
    static final Uri FEEDBACK_URI = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, "usagefeedback");
    static final String USAGE_TYPE = "type";
    public static final String USAGE_TYPE_CALL = "call";
    public static final String USAGE_TYPE_LONG_TEXT = "long_text";
    public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/contacts/DataUsageStatUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */