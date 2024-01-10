@file:Suppress("UNCHECKED_CAST")

package org.app.siekraf.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <VM: ViewModel> ekrafViewModelFactory(crossinline f:() -> VM) =
    object : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return f() as T
        }
    }
