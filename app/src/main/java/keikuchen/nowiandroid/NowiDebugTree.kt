package keikuchen.nowiandroid

import android.util.Log
import timber.log.Timber

class NowiDebugTree : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        // tagは最大23文字まで
        val validTag = "nowi_${tag?.take(18)}"

        val thread = Throwable().stackTrace
        // 通常はthread[5]が必ずあるが、暗号化等により取得できないこともある？
        @Suppress("SENSELESS_COMPARISON")
        if (thread == null || thread.size < 5) {
            Log.println(priority, validTag, message)
        } else {
            val stack = thread[5]
            // (filename:linenumber)のフォーマットにすると自動的にリンクになるため、それを利用する
            val formattedMsg = "${message.take(2048)}(${stack.fileName}:${stack.lineNumber})"
            Log.println(priority, validTag, formattedMsg)
        }
    }
}
