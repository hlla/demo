package com.google.android.finsky.dn;

import com.google.android.finsky.dn.b.b;
import com.google.android.finsky.dn.b.e;
import com.google.android.finsky.dn.b.f;
import com.google.android.finsky.dn.b.g;
import java.util.concurrent.TimeUnit;

public final class c
  extends a
{
  public c()
  {
    a();
    a(new com.google.android.finsky.dn.b.d());
    a(new com.google.android.finsky.dn.b.c());
    a(new e());
    a(new com.google.android.finsky.dn.b.a());
    a(new f());
    a(new g());
    a(new b());
  }
  
  protected final void a()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    a("TestColorTheme", "transparent_background", localBoolean);
    a("TestColorTheme", "title_bar_color", Integer.valueOf(-16776961));
    a("TestColorTheme", "transition_delay", Double.valueOf(10.0D));
    a("TestColorTheme", "color_label", "blue");
    a("TestConfig", "backend_urls", null);
    a("Phenotype", "enable_cache_clearing_ps_exp", localBoolean);
    a("SaturnV", "show_full_size", localBoolean);
    a("SaturnV", "disable_download_optimizations", localBoolean);
    Long localLong = Long.valueOf(0L);
    a("SaturnV", "delay_decompress_ms", localLong);
    a("SaturnV", "delay_installation_ms", localLong);
    a("NativeBrotli", "enable_native_brotli_decompression", localBoolean);
    a("UserLanguages", "number_of_languages_to_record", Integer.valueOf(5));
    a("UserLanguages", "update_splits_on_language_change", Boolean.valueOf(true));
    a("UserLanguages", "language_split_download_threshold", Long.valueOf(1048576L));
    a("UserLanguages", "user_language_change_foreground_timeout_millis", Long.valueOf(10000L));
    localLong = Long.valueOf(10485760L);
    a("DynamicSplits", "dynamic_split_download_size_threshold_metered", localLong);
    a("DynamicSplits", "dynamic_split_download_size_threshold_unmetered", localLong);
    a("DynamicSplits", "dynamic_split_splash_screen_timeout_millis", Long.valueOf(5000L));
    a("DynamicSplits", "dynamic_split_download_threshold_time_window_millis", Long.valueOf(TimeUnit.MINUTES.toMillis(15L)));
    a("DynamicSplits", "min_playcore_client_version_for_splitcompat_on_nop", Integer.valueOf(10300));
    a("DynamicSplits", "instant_importance_for_start_install", Integer.valueOf(125));
    a("DynamicSplits", "persistent_importance_for_start_install", Integer.valueOf(100));
    a("DynamicSplits", "dynamic_deferred_install_max_total_size_bytes", Long.valueOf(104857600L));
    a("DynamicSplits", "dynamic_deferred_install_max_total_size_on_low_battery_bytes", localLong);
    a("DynamicSplits", "dynamic_split_package_controller", "-");
    a("DynamicSplits", "dynamic_split_package_controller_pre_L", "+com.facebook.katana,com.facebook.samples.modularity");
    a("GooglePlayProtect", "enable_per_source_installation_consent", localBoolean);
    a("GooglePlayProtect", "migrate_to_verifier_clearcut_log", localBoolean);
    a("GooglePlayProtect", "enable_psic_uninstallation_dialog", localBoolean);
    a("GooglePlayProtect", "enable_gpp_home_in_phonesky", localBoolean);
    a("GooglePlayProtect", "enable_gpp_permission_warnings", localBoolean);
    a("StickyTab", "sticky_tab_expiration_millis", Long.valueOf(TimeUnit.DAYS.toMillis(28L)));
    a("PlayStoreAppDetailsPromotions", "subscription_promotions_on_details_page", localBoolean);
    a("ZeroPrefixRecentSearchSuggestion", "zero_prefix_recent_search_suggestion_count", com.google.android.finsky.ag.d.fm.b());
    a("OfflineGames", "enable_offline_games", localBoolean);
    a("ExperimentFramework", "enable_heterodyne_periodic_sync", localBoolean);
    a("ExperimentFramework", "heterodyne_periodic_sync_cycle_ms", Long.valueOf(TimeUnit.HOURS.toMillis(12L)));
    a("ExperimentFramework", "heterodyne_periodic_sync_deadline_ms", Long.valueOf(TimeUnit.HOURS.toMillis(18L)));
    a("ExperimentFramework", "enable_heterodyne_periodic_sync_logging", localBoolean);
    a("RequestQos", "enable_latency_tolerant_qos", localBoolean);
    a("InstantAppsAccountManagement", "enable_sync_instant_apps_account_with_phonesky_account", localBoolean);
    a("BlurOptimizations", "blur_radius", Integer.valueOf(20));
    a("BlurOptimizations", "blur_downscale_ratio", Integer.valueOf(2));
    a("SynchronizedGmsUpdate", "enable_synchronized_gms_update", localBoolean);
    a("ScionReporting", "enable_scion_subscription_reporting", localBoolean);
    a("AnimOptimizations", "disable_fadein_animation", localBoolean);
    a("AutoUpdateAnalytics", "app_freshness_logging_delay", Long.valueOf(TimeUnit.DAYS.toMillis(1L)));
    a("InlineVideo", "enable_inline_video_on_details_page", localBoolean);
    a("PromotionCampaignDetailsPage", "CdpClientControlledTerms", localBoolean);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */