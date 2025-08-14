// API Specification for Responsive Mobile App Monitor

interface AppMonitorApi {
    // Get list of all monitored apps
    @GET("apps")
    suspend fun getApps(): List<App>

    // Get app details by package name
    @GET("apps/{packageName}")
    suspend fun getAppDetails(@Path("packageName") packageName: String): App

    // Get app performance metrics (e.g. CPU, memory usage)
    @GET("apps/{packageName}/metrics")
    suspend fun getAppMetrics(@Path("packageName") packageName: String): AppMetrics

    // Get app crash reports
    @GET("apps/{packageName}/crashes")
    suspend fun getAppCrashes(@Path("packageName") packageName: String): List<CrashReport>

    // Get device information (e.g. OS, screen resolution)
    @GET("device")
    suspend fun getDeviceInformation(): DeviceInfo
}

data class App(
    val packageName: String,
    val appName: String,
    val version: String,
    val icon: String // base64 encoded icon
)

data class AppMetrics(
    val cpuUsage: Float,
    val memoryUsage: Float,
    val networkUsage: Float
)

data class CrashReport(
    val timestamp: Long,
    val crashReason: String,
    val stacktrace: String
)

data class DeviceInfo(
    val os: String,
    val osVersion: String,
    val screenResolution: String,
    val deviceModel: String
)