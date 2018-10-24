package com.kotlin.base.data.net

import com.kotlin.base.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 *  Desc: Retrofit工厂，单例
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 14:22
 */
class RetrofitFactory private constructor() {
    /**
     * 函数对象  单例实现
     */
    companion object {
        // lazy 延迟加载
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor

    init {

        //通用拦截
        interceptor = Interceptor { chain ->
            val request = chain.request()
                    .newBuilder()
                    .addHeader("Content_Type", "application/json")
                    .addHeader("charset", "UTF-8")
                    .build()

            chain.proceed(request)
        }

        //Retrofit实例化
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create()) // 数据转换工厂
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    /**
     * OKHttp创建
     */
    private fun initClient(): OkHttpClient {

        return OkHttpClient.Builder()
                .addInterceptor(interceptor)  // 通用拦截器 与 head 相关
                .addInterceptor(initLogInterceptor())  // 日志拦截器
                .connectTimeout(10, TimeUnit.SECONDS) // 连接时间
                .readTimeout(10, TimeUnit.SECONDS) // 超时时间
                .build()
    }

    /**
     * 构建日志拦截器
     */
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY  // 打印的日志级别
        return interceptor
    }

    /**
     * 具体服务实例化
     */
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}