// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.artifacts.Artifact
import com.dedalus.api.models.machines.artifacts.ArtifactDeleteParams
import com.dedalus.api.models.machines.artifacts.ArtifactListPageAsync
import com.dedalus.api.models.machines.artifacts.ArtifactListParams
import com.dedalus.api.models.machines.artifacts.ArtifactRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface ArtifactServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ArtifactServiceAsync

    /** Get artifact */
    suspend fun retrieve(
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Artifact

    /** List artifacts */
    suspend fun list(
        params: ArtifactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ArtifactListPageAsync

    /** Delete artifact */
    suspend fun delete(
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Artifact

    /**
     * A view of [ArtifactServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ArtifactServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/artifacts/{artifact_id}`,
         * but is otherwise the same as [ArtifactServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Artifact>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/artifacts`, but is
         * otherwise the same as [ArtifactServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ArtifactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ArtifactListPageAsync>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/machines/{machine_id}/artifacts/{artifact_id}`, but is otherwise the same as
         * [ArtifactServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Artifact>
    }
}
