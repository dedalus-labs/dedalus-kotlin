package com.dedalus.api.errors

class DedalusInvalidDataException(message: String? = null, cause: Throwable? = null) :
    DedalusException(message, cause)
