// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.handlers.errorBodyHandler
import com.dedalus.api.core.handlers.errorHandler
import com.dedalus.api.core.handlers.jsonHandler
import com.dedalus.api.core.http.HttpMethod
import com.dedalus.api.core.http.HttpRequest
import com.dedalus.api.core.http.HttpResponse
import com.dedalus.api.core.http.HttpResponse.Handler
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.core.http.json
import com.dedalus.api.core.http.parseable
import com.dedalus.api.core.prepareAsync
import com.dedalus.api.models.machines.executions.Execution
import com.dedalus.api.models.machines.executions.ExecutionCreateParams
import com.dedalus.api.models.machines.executions.ExecutionDeleteParams
import com.dedalus.api.models.machines.executions.ExecutionEvents
import com.dedalus.api.models.machines.executions.ExecutionEventsPageAsync
import com.dedalus.api.models.machines.executions.ExecutionEventsParams
import com.dedalus.api.models.machines.executions.ExecutionList
import com.dedalus.api.models.machines.executions.ExecutionListPageAsync
import com.dedalus.api.models.machines.executions.ExecutionListParams
import com.dedalus.api.models.machines.executions.ExecutionOutput
import com.dedalus.api.models.machines.executions.ExecutionOutputParams
import com.dedalus.api.models.machines.executions.ExecutionRetrieveParams

class ExecutionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ExecutionServiceAsync {

    private val withRawResponse: ExecutionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExecutionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionServiceAsync =
        ExecutionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: ExecutionCreateParams,
        requestOptions: RequestOptions,
    ): Execution =
        // post /v1/machines/{machine_id}/executions
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions,
    ): Execution =
        // get /v1/machines/{machine_id}/executions/{execution_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: ExecutionListParams,
        requestOptions: RequestOptions,
    ): ExecutionListPageAsync =
        // get /v1/machines/{machine_id}/executions
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: ExecutionDeleteParams,
        requestOptions: RequestOptions,
    ): Execution =
        // delete /v1/machines/{machine_id}/executions/{execution_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun events(
        params: ExecutionEventsParams,
        requestOptions: RequestOptions,
    ): ExecutionEventsPageAsync =
        // get /v1/machines/{machine_id}/executions/{execution_id}/events
        withRawResponse().events(params, requestOptions).parse()

    override suspend fun output(
        params: ExecutionOutputParams,
        requestOptions: RequestOptions,
    ): ExecutionOutput =
        // get /v1/machines/{machine_id}/executions/{execution_id}/output
        withRawResponse().output(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExecutionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExecutionServiceAsync.WithRawResponse =
            ExecutionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<Execution> =
            jsonHandler<Execution>(clientOptions.jsonMapper)

        override suspend fun create(
            params: ExecutionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Execution> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "executions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Execution> =
            jsonHandler<Execution>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Execution> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "executions",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<ExecutionList> =
            jsonHandler<ExecutionList>(clientOptions.jsonMapper)

        override suspend fun list(
            params: ExecutionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "executions")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ExecutionListPageAsync.builder()
                            .service(ExecutionServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Execution> =
            jsonHandler<Execution>(clientOptions.jsonMapper)

        override suspend fun delete(
            params: ExecutionDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Execution> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "executions",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val eventsHandler: Handler<ExecutionEvents> =
            jsonHandler<ExecutionEvents>(clientOptions.jsonMapper)

        override suspend fun events(
            params: ExecutionEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionEventsPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "executions",
                        params._pathParam(1),
                        "events",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { eventsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ExecutionEventsPageAsync.builder()
                            .service(ExecutionServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val outputHandler: Handler<ExecutionOutput> =
            jsonHandler<ExecutionOutput>(clientOptions.jsonMapper)

        override suspend fun output(
            params: ExecutionOutputParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionOutput> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "executions",
                        params._pathParam(1),
                        "output",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { outputHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
