// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.previews

import com.dedalus.api.core.AutoPagerAsync
import com.dedalus.api.core.PageAsync
import com.dedalus.api.core.checkRequired
import com.dedalus.api.services.async.machines.PreviewServiceAsync
import java.util.Objects

/** @see PreviewServiceAsync.list */
class PreviewListPageAsync
private constructor(
    private val service: PreviewServiceAsync,
    private val params: PreviewListParams,
    private val response: PreviewList,
) : PageAsync<Preview> {

    /**
     * Delegates to [PreviewList], but gracefully handles missing data.
     *
     * @see PreviewList.items
     */
    override fun items(): List<Preview> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [PreviewList], but gracefully handles missing data.
     *
     * @see PreviewList.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("next_cursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): PreviewListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): PreviewListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Preview> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): PreviewListParams = params

    /** The response that this page was parsed from. */
    fun response(): PreviewList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PreviewListPageAsync].
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

    /** A builder for [PreviewListPageAsync]. */
    class Builder internal constructor() {

        private var service: PreviewServiceAsync? = null
        private var params: PreviewListParams? = null
        private var response: PreviewList? = null

        internal fun from(previewListPageAsync: PreviewListPageAsync) = apply {
            service = previewListPageAsync.service
            params = previewListPageAsync.params
            response = previewListPageAsync.response
        }

        fun service(service: PreviewServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PreviewListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PreviewList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PreviewListPageAsync].
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
        fun build(): PreviewListPageAsync =
            PreviewListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PreviewListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "PreviewListPageAsync{service=$service, params=$params, response=$response}"
}
