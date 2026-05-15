// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.blocking.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.executions.Execution
import com.dedalus.api.models.machines.executions.ExecutionCreateParams
import com.dedalus.api.models.machines.executions.ExecutionDeleteParams
import com.dedalus.api.models.machines.executions.ExecutionEventsPage
import com.dedalus.api.models.machines.executions.ExecutionEventsParams
import com.dedalus.api.models.machines.executions.ExecutionListPage
import com.dedalus.api.models.machines.executions.ExecutionListParams
import com.dedalus.api.models.machines.executions.ExecutionOutput
import com.dedalus.api.models.machines.executions.ExecutionOutputParams
import com.dedalus.api.models.machines.executions.ExecutionRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface ExecutionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionService

    /** Create execution */
    fun create(
        params: ExecutionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Execution

    /** Get execution */
    fun retrieve(
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Execution

    /** List executions */
    fun list(
        params: ExecutionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionListPage

    /** Delete execution */
    fun delete(
        params: ExecutionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Execution

    /** List execution events */
    fun events(
        params: ExecutionEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionEventsPage

    /** Get execution output */
    fun output(
        params: ExecutionOutputParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionOutput

    /** A view of [ExecutionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/executions`, but is
         * otherwise the same as [ExecutionService.create].
         */
        @MustBeClosed
        fun create(
            params: ExecutionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Execution>

        /**
         * Returns a raw HTTP response for `get
         * /v1/machines/{machine_id}/executions/{execution_id}`, but is otherwise the same as
         * [ExecutionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Execution>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/executions`, but is
         * otherwise the same as [ExecutionService.list].
         */
        @MustBeClosed
        fun list(
            params: ExecutionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionListPage>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/machines/{machine_id}/executions/{execution_id}`, but is otherwise the same as
         * [ExecutionService.delete].
         */
        @MustBeClosed
        fun delete(
            params: ExecutionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Execution>

        /**
         * Returns a raw HTTP response for `get
         * /v1/machines/{machine_id}/executions/{execution_id}/events`, but is otherwise the same as
         * [ExecutionService.events].
         */
        @MustBeClosed
        fun events(
            params: ExecutionEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionEventsPage>

        /**
         * Returns a raw HTTP response for `get
         * /v1/machines/{machine_id}/executions/{execution_id}/output`, but is otherwise the same as
         * [ExecutionService.output].
         */
        @MustBeClosed
        fun output(
            params: ExecutionOutputParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionOutput>
    }
}
