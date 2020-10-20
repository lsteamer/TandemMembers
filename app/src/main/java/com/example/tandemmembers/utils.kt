package com.example.tandemmembers

import java.util.*


inline val List<String>.cleanStringArrays : String
    get() = this.joinToString(" ").toUpperCase(Locale.ROOT)