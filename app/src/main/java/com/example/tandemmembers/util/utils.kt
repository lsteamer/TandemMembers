package com.example.tandemmembers.util

import java.util.*


const val TANDEM_STARTING_PAGE_INDEX = 1
const val TANDEM_MAX_PAGE_VALUES = 20

inline val List<String>.cleanStringArrays: String
    get() = this.joinToString(" ").toUpperCase(Locale.ROOT)