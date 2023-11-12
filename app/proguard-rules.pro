# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.example.voicechanger.MainActivity{*;}
-keep class com.audiosoundeffects.b_pack.a_b_class{*;}
-keep class com.audiosoundeffects.c_pack.a_c_class{*;}
-keep class com.audiosoundeffects.c_pack.b_c_class{*;}
-keep class com.audiosoundeffects.c_pack.c_c_class{*;}
-keep class com.audiosoundeffects.c_pack.d_c_class{*;}
-keep class com.audiosoundeffects.c_pack.e_c_class{*;}
-keep class com.audiosoundeffects.d_pack.a_d_class{*;}
-keep class com.audiosoundeffects.e_pack.a_e_class{*;}
-keep class com.audiosoundeffects.e_pack.b_e_class{*;}
-keep class com.audiosoundeffects.e_pack.c_e_class{*;}
-keep class com.audiosoundeffects.e_pack.d_e_class{*;}
-keep class com.audiosoundeffects.e_pack.e_e_class{*;}


-flattenpackagehierarchy
-ignorewarnings

-keep class com.truenet.** {
      *;
}

-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile,
LineNumberTable, *Annotation*, EnclosingMethod
-dontwarn android.webkit.JavascriptInterface

-dontwarn org.jetbrains.annotations.**

-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**

-keepclassmembers class voicechanger.voiceeditor.funnyvoicemaker.retroFitClient.** {
  *;
}

-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**

-keepclassmembers class com.venilonappsmain.retroFitClient.** {
  *;
}

-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**


-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**

-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { <fields>; }

# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Prevent R8 from leaving Data object members always null
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

# Retain generic signatures of TypeToken and its subclasses with R8 version 3.0 and higher.
-keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
-keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken