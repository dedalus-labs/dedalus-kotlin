// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.previews.Preview
import com.dedalus.api.models.machines.previews.PreviewCreateParams
import com.dedalus.api.models.machines.previews.PreviewDeleteParams
import com.dedalus.api.models.machines.previews.PreviewListPageAsync
import com.dedalus.api.models.machines.previews.PreviewListParams
import com.dedalus.api.models.machines.previews.PreviewRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface PreviewServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PreviewServiceAsync

    /** Create preview */
    suspend fun create(
        params: PreviewCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Preview

    /** Get preview */
    suspend fun retrieve(
        params: PreviewRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Preview

    /** List previews */
    suspend fun list(
        params: PreviewListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreviewListPageAsync

    /** Delete preview */
    suspend fun delete(
        params: PreviewDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Preview

    /**
     * A view of [PreviewServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PreviewServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/previews`, but is
         * otherwise the same as [PreviewServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: PreviewCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Preview>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/previews/{preview_id}`,
         * but is otherwise the same as [PreviewServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: PreviewRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Preview>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/previews`, but is
         * otherwise the same as [PreviewServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: PreviewListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreviewListPageAsync>

        /**
         * Returns a raw HTTP response for `delete /v1/machines/{machine_id}/previews/{preview_id}`,
         * but is otherwise the same as [PreviewServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: PreviewDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Preview>
    }
}
