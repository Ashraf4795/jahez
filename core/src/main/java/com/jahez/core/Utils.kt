package com.jahez.core

import android.content.Context


fun Context.language(): String = this.resources.configuration.locale.language