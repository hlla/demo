package com.android.common.contacts;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.android.common.widget.CompositeCursorAdapter;
import com.android.common.widget.CompositeCursorAdapter.Partition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseEmailAddressAdapter
  extends CompositeCursorAdapter
  implements Filterable
{
  private static final int ALLOWANCE_FOR_DUPLICATES = 5;
  private static final int DEFAULT_PREFERRED_MAX_RESULT_COUNT = 10;
  private static final long DIRECTORY_LOCAL_INVISIBLE = 1L;
  private static final String DIRECTORY_PARAM_KEY = "directory";
  private static final String LIMIT_PARAM_KEY = "limit";
  private static final int MESSAGE_SEARCH_PENDING = 1;
  private static final int MESSAGE_SEARCH_PENDING_DELAY = 1000;
  private static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
  private static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
  private static final String SEARCHING_CURSOR_MARKER = "searching";
  private static final String TAG = "BaseEmailAddressAdapter";
  private Account mAccount;
  protected final ContentResolver mContentResolver;
  private boolean mDirectoriesLoaded;
  private Handler mHandler;
  private int mPreferredMaxResultCount;
  
  public BaseEmailAddressAdapter(Context paramContext)
  {
    this(paramContext, 10);
  }
  
  public BaseEmailAddressAdapter(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mContentResolver = paramContext.getContentResolver();
    this.mPreferredMaxResultCount = paramInt;
    this.mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        BaseEmailAddressAdapter.this.showSearchPendingIfNotComplete(paramAnonymousMessage.arg1);
      }
    };
  }
  
  private Cursor createLoadingCursor()
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(new String[] { "searching" });
    localMatrixCursor.addRow(new Object[] { "" });
    return localMatrixCursor;
  }
  
  private boolean hasDuplicates(Cursor paramCursor, int paramInt)
  {
    paramCursor.moveToPosition(-1);
    while (paramCursor.moveToNext()) {
      if (isDuplicate(paramCursor.getString(1), paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isDuplicate(String paramString, int paramInt)
  {
    int j = getPartitionCount();
    int i = 0;
    while (i < j)
    {
      if ((i != paramInt) && (!isLoading(i)))
      {
        Cursor localCursor = getCursor(i);
        if (localCursor != null)
        {
          localCursor.moveToPosition(-1);
          while (localCursor.moveToNext()) {
            if (TextUtils.equals(paramString, localCursor.getString(1))) {
              return true;
            }
          }
        }
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isLoading(int paramInt)
  {
    return ((DirectoryPartition)getPartition(paramInt)).loading;
  }
  
  private final String makeDisplayString(Cursor paramCursor)
  {
    if (paramCursor.getColumnName(0).equals("searching")) {
      paramCursor = "";
    }
    String str2;
    String str1;
    do
    {
      do
      {
        return paramCursor;
        str2 = paramCursor.getString(0);
        str1 = paramCursor.getString(1);
        paramCursor = str1;
      } while (TextUtils.isEmpty(str2));
      paramCursor = str1;
    } while (TextUtils.equals(str2, str1));
    return new Rfc822Token(str2, str1, null).toString();
  }
  
  private Cursor removeDuplicatesAndTruncate(int paramInt, Cursor paramCursor)
  {
    if (paramCursor == null) {
      localObject = null;
    }
    do
    {
      return (Cursor)localObject;
      if (paramCursor.getCount() > 10) {
        break;
      }
      localObject = paramCursor;
    } while (!hasDuplicates(paramCursor, paramInt));
    int i = 0;
    Object localObject = new MatrixCursor(EmailQuery.PROJECTION);
    paramCursor.moveToPosition(-1);
    while ((paramCursor.moveToNext()) && (i < 10))
    {
      String str1 = paramCursor.getString(0);
      String str2 = paramCursor.getString(1);
      if (!isDuplicate(str2, paramInt))
      {
        ((MatrixCursor)localObject).addRow(new Object[] { str1, str2 });
        i += 1;
      }
    }
    paramCursor.close();
    return (Cursor)localObject;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  protected void bindView(View paramView, int paramInt1, Cursor paramCursor, int paramInt2)
  {
    Object localObject1 = (DirectoryPartition)getPartition(paramInt1);
    String str2 = ((DirectoryPartition)localObject1).directoryType;
    String str3 = ((DirectoryPartition)localObject1).displayName;
    if (((DirectoryPartition)localObject1).loading)
    {
      bindViewLoading(paramView, str2, str3);
      return;
    }
    String str1 = paramCursor.getString(0);
    localObject1 = paramCursor.getString(1);
    Object localObject2;
    if (!TextUtils.isEmpty(str1))
    {
      localObject2 = str1;
      paramCursor = (Cursor)localObject1;
      if (!TextUtils.equals(str1, (CharSequence)localObject1)) {}
    }
    else
    {
      paramCursor = null;
      localObject2 = localObject1;
    }
    bindView(paramView, str2, str3, (String)localObject2, paramCursor);
  }
  
  protected abstract void bindView(View paramView, String paramString1, String paramString2, String paramString3, String paramString4);
  
  protected abstract void bindViewLoading(View paramView, String paramString1, String paramString2);
  
  public Filter getFilter()
  {
    return new DefaultPartitionFilter(null);
  }
  
  protected int getItemViewType(int paramInt1, int paramInt2)
  {
    if (((DirectoryPartition)getPartition(paramInt1)).loading) {
      return 1;
    }
    return 0;
  }
  
  protected abstract View inflateItemView(ViewGroup paramViewGroup);
  
  protected abstract View inflateItemViewLoading(ViewGroup paramViewGroup);
  
  protected boolean isEnabled(int paramInt1, int paramInt2)
  {
    return !isLoading(paramInt1);
  }
  
  protected View newView(Context paramContext, int paramInt1, Cursor paramCursor, int paramInt2, ViewGroup paramViewGroup)
  {
    if (((DirectoryPartition)getPartition(paramInt1)).loading) {
      return inflateItemViewLoading(paramViewGroup);
    }
    return inflateItemView(paramViewGroup);
  }
  
  protected void onDirectoryLoadFinished(CharSequence paramCharSequence, Cursor paramCursor1, Cursor paramCursor2)
  {
    int i;
    if (paramCursor1 != null)
    {
      PackageManager localPackageManager = getContext().getPackageManager();
      Object localObject = null;
      ArrayList localArrayList = new ArrayList();
      while (paramCursor1.moveToNext())
      {
        long l = paramCursor1.getLong(0);
        if (l != 1L)
        {
          DirectoryPartition localDirectoryPartition = new DirectoryPartition();
          localDirectoryPartition.directoryId = l;
          localDirectoryPartition.displayName = paramCursor1.getString(3);
          localDirectoryPartition.accountName = paramCursor1.getString(1);
          localDirectoryPartition.accountType = paramCursor1.getString(2);
          String str = paramCursor1.getString(4);
          i = paramCursor1.getInt(5);
          if ((str != null) && (i != 0)) {}
          try
          {
            localDirectoryPartition.directoryType = localPackageManager.getResourcesForApplication(str).getString(i);
            if (localDirectoryPartition.directoryType == null) {
              Log.e("BaseEmailAddressAdapter", "Cannot resolve directory name: " + i + "@" + str);
            }
            if ((this.mAccount != null) && (this.mAccount.name.equals(localDirectoryPartition.accountName)) && (this.mAccount.type.equals(localDirectoryPartition.accountType))) {
              localObject = localDirectoryPartition;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            for (;;)
            {
              Log.e("BaseEmailAddressAdapter", "Cannot resolve directory name: " + i + "@" + str, localNameNotFoundException);
            }
            localArrayList.add(localDirectoryPartition);
          }
        }
      }
      if (localObject != null) {
        localArrayList.add(1, localObject);
      }
      paramCursor1 = localArrayList.iterator();
      while (paramCursor1.hasNext()) {
        addPartition((DirectoryPartition)paramCursor1.next());
      }
    }
    int j = getPartitionCount();
    setNotificationsEnabled(false);
    int k;
    if (paramCursor2 != null)
    {
      try
      {
        if (getPartitionCount() <= 0) {
          break label611;
        }
        changeCursor(0, paramCursor2);
      }
      finally
      {
        setNotificationsEnabled(true);
      }
      k = this.mPreferredMaxResultCount - i;
      i = 1;
    }
    for (;;)
    {
      if (i < j)
      {
        paramCursor1 = (DirectoryPartition)getPartition(i);
        paramCursor1.constraint = paramCharSequence;
        if (k > 0)
        {
          if (paramCursor1.loading) {
            break label621;
          }
          paramCursor1.loading = true;
          changeCursor(i, null);
          break label621;
        }
      }
      label611:
      do
      {
        i = paramCursor2.getCount();
        break;
        paramCursor1.loading = false;
        changeCursor(i, null);
        break label621;
        setNotificationsEnabled(true);
        i = 1;
        if (i < j)
        {
          paramCursor1 = (DirectoryPartition)getPartition(i);
          if (paramCursor1.loading)
          {
            this.mHandler.removeMessages(1, paramCursor1);
            paramCursor2 = this.mHandler.obtainMessage(1, i, 0, paramCursor1);
            this.mHandler.sendMessageDelayed(paramCursor2, 1000L);
            if (paramCursor1.filter == null) {
              paramCursor1.filter = new DirectoryPartitionFilter(i, paramCursor1.directoryId);
            }
            paramCursor1.filter.setLimit(k);
            paramCursor1.filter.filter(paramCharSequence);
          }
          for (;;)
          {
            i += 1;
            break;
            if (paramCursor1.filter != null) {
              paramCursor1.filter.filter(null);
            }
          }
        }
        return;
      } while (paramCursor2 != null);
      i = 0;
      break;
      label621:
      i += 1;
    }
  }
  
  public void onPartitionLoadFinished(CharSequence paramCharSequence, int paramInt, Cursor paramCursor)
  {
    if (paramInt < getPartitionCount())
    {
      localDirectoryPartition = (DirectoryPartition)getPartition(paramInt);
      if ((localDirectoryPartition.loading) && (TextUtils.equals(paramCharSequence, localDirectoryPartition.constraint)))
      {
        localDirectoryPartition.loading = false;
        this.mHandler.removeMessages(1, localDirectoryPartition);
        changeCursor(paramInt, removeDuplicatesAndTruncate(paramInt, paramCursor));
      }
    }
    while (paramCursor == null)
    {
      DirectoryPartition localDirectoryPartition;
      do
      {
        return;
      } while (paramCursor == null);
      paramCursor.close();
      return;
    }
    paramCursor.close();
  }
  
  public void setAccount(Account paramAccount)
  {
    this.mAccount = paramAccount;
  }
  
  void showSearchPendingIfNotComplete(int paramInt)
  {
    if ((paramInt < getPartitionCount()) && (((DirectoryPartition)getPartition(paramInt)).loading)) {
      changeCursor(paramInt, createLoadingCursor());
    }
  }
  
  private final class DefaultPartitionFilter
    extends Filter
  {
    private DefaultPartitionFilter() {}
    
    public CharSequence convertResultToString(Object paramObject)
    {
      return BaseEmailAddressAdapter.this.makeDisplayString((Cursor)paramObject);
    }
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Cursor localCursor1 = null;
      if (!BaseEmailAddressAdapter.this.mDirectoriesLoaded)
      {
        localCursor1 = BaseEmailAddressAdapter.this.mContentResolver.query(BaseEmailAddressAdapter.DirectoryListQuery.URI, BaseEmailAddressAdapter.DirectoryListQuery.PROJECTION, null, null, null);
        BaseEmailAddressAdapter.access$002(BaseEmailAddressAdapter.this, true);
      }
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      Cursor localCursor2 = null;
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        paramCharSequence = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI.buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("limit", String.valueOf(BaseEmailAddressAdapter.this.mPreferredMaxResultCount));
        if (BaseEmailAddressAdapter.this.mAccount != null)
        {
          paramCharSequence.appendQueryParameter("name_for_primary_account", BaseEmailAddressAdapter.this.mAccount.name);
          paramCharSequence.appendQueryParameter("type_for_primary_account", BaseEmailAddressAdapter.this.mAccount.type);
        }
        paramCharSequence = paramCharSequence.build();
        localCursor2 = BaseEmailAddressAdapter.this.mContentResolver.query(paramCharSequence, BaseEmailAddressAdapter.EmailQuery.PROJECTION, null, null, null);
        localFilterResults.count = localCursor2.getCount();
      }
      localFilterResults.values = new Cursor[] { localCursor1, localCursor2 };
      return localFilterResults;
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      if (paramFilterResults.values != null)
      {
        Cursor[] arrayOfCursor = (Cursor[])paramFilterResults.values;
        BaseEmailAddressAdapter.this.onDirectoryLoadFinished(paramCharSequence, arrayOfCursor[0], arrayOfCursor[1]);
      }
      paramFilterResults.count = BaseEmailAddressAdapter.this.getCount();
    }
  }
  
  private static class DirectoryListQuery
  {
    public static final int ACCOUNT_NAME = 1;
    public static final int ACCOUNT_TYPE = 2;
    private static final String DIRECTORY_ACCOUNT_NAME = "accountName";
    private static final String DIRECTORY_ACCOUNT_TYPE = "accountType";
    private static final String DIRECTORY_DISPLAY_NAME = "displayName";
    private static final String DIRECTORY_ID = "_id";
    private static final String DIRECTORY_PACKAGE_NAME = "packageName";
    private static final String DIRECTORY_TYPE_RESOURCE_ID = "typeResourceId";
    public static final int DISPLAY_NAME = 3;
    public static final int ID = 0;
    public static final int PACKAGE_NAME = 4;
    public static final String[] PROJECTION = { "_id", "accountName", "accountType", "displayName", "packageName", "typeResourceId" };
    public static final int TYPE_RESOURCE_ID = 5;
    public static final Uri URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
  }
  
  public static final class DirectoryPartition
    extends CompositeCursorAdapter.Partition
  {
    public String accountName;
    public String accountType;
    public CharSequence constraint;
    public long directoryId;
    public String directoryType;
    public String displayName;
    public BaseEmailAddressAdapter.DirectoryPartitionFilter filter;
    public boolean loading;
    
    public DirectoryPartition()
    {
      super(false);
    }
  }
  
  private final class DirectoryPartitionFilter
    extends Filter
  {
    private final long mDirectoryId;
    private int mLimit;
    private final int mPartitionIndex;
    
    public DirectoryPartitionFilter(int paramInt, long paramLong)
    {
      this.mPartitionIndex = paramInt;
      this.mDirectoryId = paramLong;
    }
    
    public int getLimit()
    {
      try
      {
        int i = this.mLimit;
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        paramCharSequence = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI.buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("directory", String.valueOf(this.mDirectoryId)).appendQueryParameter("limit", String.valueOf(getLimit() + 5)).build();
        localFilterResults.values = BaseEmailAddressAdapter.this.mContentResolver.query(paramCharSequence, BaseEmailAddressAdapter.EmailQuery.PROJECTION, null, null, null);
      }
      return localFilterResults;
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      Cursor localCursor = (Cursor)paramFilterResults.values;
      BaseEmailAddressAdapter.this.onPartitionLoadFinished(paramCharSequence, this.mPartitionIndex, localCursor);
      paramFilterResults.count = BaseEmailAddressAdapter.this.getCount();
    }
    
    public void setLimit(int paramInt)
    {
      try
      {
        this.mLimit = paramInt;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private static class EmailQuery
  {
    public static final int ADDRESS = 1;
    public static final int NAME = 0;
    public static final String[] PROJECTION = { "display_name", "data1" };
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/contacts/BaseEmailAddressAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */