// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.artifacts

import com.dedalus.api.core.AutoPagerAsync
import com.dedalus.api.core.PageAsync
import com.dedalus.api.core.checkRequired
import com.dedalus.api.services.async.machines.ArtifactServiceAsync
import java.util.Objects

/** @see ArtifactServiceAsync.list */
class ArtifactListPageAsync
private constructor(
    private val service: ArtifactServiceAsync,
    private val params: ArtifactListParams,
    private val response: ArtifactList,
) : PageAsync<Artifact> {

    /**
     * Delegates to [ArtifactList], but gracefully handles missing data.
     *
     * @see ArtifactList.items
     */
    override fun items(): List<Artifact> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [ArtifactList], but gracefully handles missing data.
     *
     * @see ArtifactList.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("next_cursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): ArtifactListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): ArtifactListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Artifact> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ArtifactListParams = params

    /** The response that this page was parsed from. */
    fun response(): ArtifactList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ArtifactListPageAsync].
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

    /** A builder for [ArtifactListPageAsync]. */
    class Builder internal constructor() {

        private var service: ArtifactServiceAsync? = null
        private var params: ArtifactListParams? = null
        private var response: ArtifactList? = null

        internal fun from(artifactListPageAsync: ArtifactListPageAsync) = apply {
            service = artifactListPageAsync.service
            params = artifactListPageAsync.params
            response = artifactListPageAsync.response
        }

        fun service(service: ArtifactServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ArtifactListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ArtifactList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ArtifactListPageAsync].
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
        fun build(): ArtifactListPageAsync =
            ArtifactListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ArtifactListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ArtifactListPageAsync{service=$service, params=$params, response=$response}"
}
