package com.petros.efthymiou.dailypulse

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

//mafesh haga bt automaticallly clear zay android so we will do it manually by a function
actual open class BaseViewModel {
    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear(){
        scope.cancel()
    }
}