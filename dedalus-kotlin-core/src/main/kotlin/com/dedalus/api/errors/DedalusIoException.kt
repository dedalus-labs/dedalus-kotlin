package com.dedalus.api.errors

class DedalusIoException(message: String? = null, cause: Throwable? = null) :
    DedalusException(message, cause)
