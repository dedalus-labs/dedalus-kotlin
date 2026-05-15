// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.executions.Execution
import com.dedalus.api.models.machines.executions.ExecutionCreateParams
import com.dedalus.api.models.machines.executions.ExecutionDeleteParams
import com.dedalus.api.models.machines.executions.ExecutionEventsPageAsync
import com.dedalus.api.models.machines.executions.ExecutionEventsParams
import com.dedalus.api.models.machines.executions.ExecutionListPageAsync
import com.dedalus.api.models.machines.executions.ExecutionListParams
import com.dedalus.api.models.machines.executions.ExecutionOutput
import com.dedalus.api.models.machines.executions.ExecutionOutputParams
import com.dedalus.api.models.machines.executions.ExecutionRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface ExecutionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionServiceAsync

    /** Create execution */
    suspend fun create(
        params: ExecutionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Execution

    /** Get execution */
    suspend fun retrieve(
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Execution

    /** List executions */
    suspend fun list(
        params: ExecutionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionListPageAsync

    /** Delete execution */
    suspend fun delete(
        params: ExecutionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Execution

    /** List execution events */
    suspend fun events(
        params: ExecutionEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionEventsPageAsync

    /** Get execution output */
    suspend fun output(
        params: ExecutionOutputParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionOutput

    /**
     * A view of [ExecutionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExecutionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/executions`, but is
         * otherwise the same as [ExecutionServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ExecutionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Execution>

        /**
         * Returns a raw HTTP response for `get
         * /v1/machines/{machine_id}/executions/{execution_id}`, but is otherwise the same as
         * [ExecutionServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Execution>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/executions`, but is
         * otherwise the same as [ExecutionServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ExecutionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionListPageAsync>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/machines/{machine_id}/executions/{execution_id}`, but is otherwise the same as
         * [ExecutionServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: ExecutionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Execution>

        /**
         * Returns a raw HTTP response for `get
         * /v1/machines/{machine_id}/executions/{execution_id}/events`, but is otherwise the same as
         * [ExecutionServiceAsync.events].
         */
        @MustBeClosed
        suspend fun events(
            params: ExecutionEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionEventsPageAsync>

        /**
         * Returns a raw HTTP response for `get
         * /v1/machines/{machine_id}/executions/{execution_id}/output`, but is otherwise the same as
         * [ExecutionServiceAsync.output].
         */
        @MustBeClosed
        suspend fun output(
            params: ExecutionOutputParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionOutput>
    }
}
