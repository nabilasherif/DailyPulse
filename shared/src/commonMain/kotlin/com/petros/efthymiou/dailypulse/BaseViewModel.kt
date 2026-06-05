package com.petros.efthymiou.dailypulse

import kotlinx.coroutines.CoroutineScope

//open is not final and other classses can extend it
//()  conctructor
expect open class BaseViewModel() {

    val scope: CoroutineScope
}