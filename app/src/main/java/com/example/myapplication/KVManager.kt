package com.example.myapplication

import android.os.Parcelable
import com.tencent.mmkv.MMKV

/**
 * 使用腾讯MMKV库进行轻量的数据持久化，高效稳定
 */
class KVManager private constructor(){
    companion object {
        private var kv: MMKV = MMKV.defaultMMKV()
        /**
         * 支持不同的业务模块创建自己的实例
         * @param name 实例名称，用于区分不同实例
         * @param mode 设置创建模式，MMKV.MULTI_PROCESS_MODE支持多进程访问
         */
        fun build(name: String? = null, mode: Int = MMKV.SINGLE_PROCESS_MODE): KVManager {
            kv = if (name.isNullOrEmpty()) {
                MMKV.defaultMMKV(mode, null)
            } else {
                MMKV.mmkvWithID(name, mode)
            }
            return KVManager()
        }
    }

    fun put(key: String, value: Any) {
        when(value) {
            is Int -> { kv.encode(key, value) }
            is ByteArray -> { kv.encode(key, value) }
            is Long -> { kv.encode(key, value) }
            is Float -> { kv.encode(key, value) }
            is Double -> { kv.encode(key, value) }
            is String -> { kv.encode(key, value) }
            is Boolean -> { kv.encode(key, value) }
            is Parcelable -> { kv.encode(key, value) }
            else -> {}
        }
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return kv.decodeInt(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long = 0L): Long {
        return kv.decodeLong(key, defaultValue)
    }

    fun getFloat(key: String, defaultValue: Float = 0f): Float {
        return kv.decodeFloat(key, defaultValue)
    }

    fun getDouble(key: String, defaultValue: Double = 0.0): Double {
        return kv.decodeDouble(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String? = null): String? {
        return kv.decodeString(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return kv.decodeBool(key, defaultValue)
    }

    fun <T : Parcelable> getParcelable(key: String, clazz: Class<T>): T? {
        return kv.decodeParcelable(key, clazz)
    }

    fun remove(key: String) {
        kv.removeValueForKey(key)
    }

    fun remove(key: Array<String>) {
        kv.removeValuesForKeys(key)
    }
}