// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.ssh

import com.dedalus.api.core.AutoPagerAsync
import com.dedalus.api.core.PageAsync
import com.dedalus.api.core.checkRequired
import com.dedalus.api.services.async.machines.SshServiceAsync
import java.util.Objects

/** @see SshServiceAsync.list */
class SshListPageAsync
private constructor(
    private val service: SshServiceAsync,
    private val params: SshListParams,
    private val response: SshSessionList,
) : PageAsync<SshSession> {

    /**
     * Delegates to [SshSessionList], but gracefully handles missing data.
     *
     * @see SshSessionList.items
     */
    override fun items(): List<SshSession> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [SshSessionList], but gracefully handles missing data.
     *
     * @see SshSessionList.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("next_cursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): SshListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): SshListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<SshSession> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SshListParams = params

    /** The response that this page was parsed from. */
    fun response(): SshSessionList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SshListPageAsync].
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

    /** A builder for [SshListPageAsync]. */
    class Builder internal constructor() {

        private var service: SshServiceAsync? = null
        private var params: SshListParams? = null
        private var response: SshSessionList? = null

        internal fun from(sshListPageAsync: SshListPageAsync) = apply {
            service = sshListPageAsync.service
            params = sshListPageAsync.params
            response = sshListPageAsync.response
        }

        fun service(service: SshServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SshListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SshSessionList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SshListPageAsync].
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
        fun build(): SshListPageAsync =
            SshListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SshListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "SshListPageAsync{service=$service, params=$params, response=$response}"
}
