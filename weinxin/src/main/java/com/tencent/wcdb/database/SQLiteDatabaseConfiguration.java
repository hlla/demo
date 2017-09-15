package com.tencent.wcdb.database;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteDatabaseConfiguration
{
  private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
  public static final String MEMORY_DB_PATH = ":memory:";
  public final ArrayList<SQLiteCustomFunction> customFunctions = new ArrayList();
  public boolean foreignKeyConstraintsEnabled;
  public final String label;
  public Locale locale;
  public int maxSqlCacheSize;
  public int openFlags;
  public final String path;
  public String vfsName;
  
  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("other must not be null.");
    }
    this.path = paramSQLiteDatabaseConfiguration.path;
    this.label = paramSQLiteDatabaseConfiguration.label;
    updateParametersFrom(paramSQLiteDatabaseConfiguration);
  }
  
  public SQLiteDatabaseConfiguration(String paramString, int paramInt)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("path must not be null.");
    }
    this.path = paramString;
    this.label = stripPathForLogs(paramString);
    this.openFlags = paramInt;
    this.maxSqlCacheSize = 25;
    this.locale = Locale.getDefault();
    if ((paramInt & 0x100) != 0) {}
    for (paramString = "vfslog";; paramString = null)
    {
      this.vfsName = paramString;
      return;
    }
  }
  
  private static String stripPathForLogs(String paramString)
  {
    if (paramString.indexOf('@') == -1) {
      return paramString;
    }
    return EMAIL_IN_DB_PATTERN.matcher(paramString).replaceAll("XX@YY");
  }
  
  public final boolean isInMemoryDb()
  {
    return this.path.equalsIgnoreCase(":memory:");
  }
  
  public final void updateParametersFrom(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("other must not be null.");
    }
    if (!this.path.equals(paramSQLiteDatabaseConfiguration.path)) {
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    }
    this.openFlags = paramSQLiteDatabaseConfiguration.openFlags;
    this.maxSqlCacheSize = paramSQLiteDatabaseConfiguration.maxSqlCacheSize;
    this.locale = paramSQLiteDatabaseConfiguration.locale;
    this.foreignKeyConstraintsEnabled = paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
    this.vfsName = paramSQLiteDatabaseConfiguration.vfsName;
    this.customFunctions.clear();
    this.customFunctions.addAll(paramSQLiteDatabaseConfiguration.customFunctions);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wcdb/database/SQLiteDatabaseConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */