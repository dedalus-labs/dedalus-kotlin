// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.ssh

import com.dedalus.api.core.AutoPager
import com.dedalus.api.core.Page
import com.dedalus.api.core.checkRequired
import com.dedalus.api.services.blocking.machines.SshService
import java.util.Objects

/** @see SshService.list */
class SshListPage
private constructor(
    private val service: SshService,
    private val params: SshListParams,
    private val response: SshSessionList,
) : Page<SshSession> {

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

    override fun nextPage(): SshListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<SshSession> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SshListParams = params

    /** The response that this page was parsed from. */
    fun response(): SshSessionList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SshListPage].
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

    /** A builder for [SshListPage]. */
    class Builder internal constructor() {

        private var service: SshService? = null
        private var params: SshListParams? = null
        private var response: SshSessionList? = null

        internal fun from(sshListPage: SshListPage) = apply {
            service = sshListPage.service
            params = sshListPage.params
            response = sshListPage.response
        }

        fun service(service: SshService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SshListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SshSessionList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SshListPage].
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
        fun build(): SshListPage =
            SshListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SshListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "SshListPage{service=$service, params=$params, response=$response}"
}
