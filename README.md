# SmartSharedPreference
利用注解清晰明了的管理SharedPreference

<pre>
@PalfishSp(key = "IsEyeProtectionOpen", name = "护眼模式是否打开")
boolean IsEyeProtectionOpen;

@PalfishSp(key = "AppName", name = "App名称")
String AppName;

@PalfishSp(key = "Index", name = "Index")
int Index;

@PalfishSp(key = "Time", name = "Time")
long Time;
</pre>
然后会生成所有变量的get和set函数。并不建议直接使用本库，只是提供了一个思路。
