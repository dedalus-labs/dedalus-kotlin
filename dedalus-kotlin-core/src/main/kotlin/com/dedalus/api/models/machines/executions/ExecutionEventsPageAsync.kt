// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.executions

import com.dedalus.api.core.AutoPagerAsync
import com.dedalus.api.core.PageAsync
import com.dedalus.api.core.checkRequired
import com.dedalus.api.services.async.machines.ExecutionServiceAsync
import java.util.Objects

/** @see ExecutionServiceAsync.events */
class ExecutionEventsPageAsync
private constructor(
    private val service: ExecutionServiceAsync,
    private val params: ExecutionEventsParams,
    private val response: ExecutionEvents,
) : PageAsync<ExecutionEvent> {

    /**
     * Delegates to [ExecutionEvents], but gracefully handles missing data.
     *
     * @see ExecutionEvents.items
     */
    override fun items(): List<ExecutionEvent> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [ExecutionEvents], but gracefully handles missing data.
     *
     * @see ExecutionEvents.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("next_cursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): ExecutionEventsParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): ExecutionEventsPageAsync = service.events(nextPageParams())

    fun autoPager(): AutoPagerAsync<ExecutionEvent> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ExecutionEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): ExecutionEvents = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExecutionEventsPageAsync].
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [ExecutionEventsPageAsync]. */
    class Builder internal constructor() {

        private var service: ExecutionServiceAsync? = null
        private var params: ExecutionEventsParams? = null
        private var response: ExecutionEvents? = null

        internal fun from(executionEventsPageAsync: ExecutionEventsPageAsync) = apply {
            service = executionEventsPageAsync.service
            params = executionEventsPageAsync.params
            response = executionEventsPageAsync.response
        }

        fun service(service: ExecutionServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ExecutionEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExecutionEvents) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExecutionEventsPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExecutionEventsPageAsync =
            ExecutionEventsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExecutionEventsPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ExecutionEventsPageAsync{service=$service, params=$params, response=$response}"
}
