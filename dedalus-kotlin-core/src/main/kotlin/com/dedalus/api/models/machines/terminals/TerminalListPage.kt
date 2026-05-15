// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.terminals

import com.dedalus.api.core.AutoPager
import com.dedalus.api.core.Page
import com.dedalus.api.core.checkRequired
import com.dedalus.api.services.blocking.machines.TerminalService
import java.util.Objects

/** @see TerminalService.list */
class TerminalListPage
private constructor(
    private val service: TerminalService,
    private val params: TerminalListParams,
    private val response: TerminalList,
) : Page<Terminal> {

    /**
     * Delegates to [TerminalList], but gracefully handles missing data.
     *
     * @see TerminalList.items
     */
    override fun items(): List<Terminal> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [TerminalList], but gracefully handles missing data.
     *
     * @see TerminalList.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("next_cursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): TerminalListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): TerminalListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Terminal> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TerminalListParams = params

    /** The response that this page was parsed from. */
    fun response(): TerminalList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TerminalListPage].
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

    /** A builder for [TerminalListPage]. */
    class Builder internal constructor() {

        private var service: TerminalService? = null
        private var params: TerminalListParams? = null
        private var response: TerminalList? = null

        internal fun from(terminalListPage: TerminalListPage) = apply {
            service = terminalListPage.service
            params = terminalListPage.params
            response = terminalListPage.response
        }

        fun service(service: TerminalService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TerminalListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TerminalList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TerminalListPage].
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
        fun build(): TerminalListPage =
            TerminalListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TerminalListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TerminalListPage{service=$service, params=$params, response=$response}"
}
