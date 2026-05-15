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
import com.dedalus.api.models.machines.terminals.Terminal
import com.dedalus.api.models.machines.terminals.TerminalCreateParams
import com.dedalus.api.models.machines.terminals.TerminalDeleteParams
import com.dedalus.api.models.machines.terminals.TerminalList
import com.dedalus.api.models.machines.terminals.TerminalListPageAsync
import com.dedalus.api.models.machines.terminals.TerminalListParams
import com.dedalus.api.models.machines.terminals.TerminalRetrieveParams

class TerminalServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TerminalServiceAsync {

    private val withRawResponse: TerminalServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TerminalServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TerminalServiceAsync =
        TerminalServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: TerminalCreateParams,
        requestOptions: RequestOptions,
    ): Terminal =
        // post /v1/machines/{machine_id}/terminals
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: TerminalRetrieveParams,
        requestOptions: RequestOptions,
    ): Terminal =
        // get /v1/machines/{machine_id}/terminals/{terminal_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: TerminalListParams,
        requestOptions: RequestOptions,
    ): TerminalListPageAsync =
        // get /v1/machines/{machine_id}/terminals
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: TerminalDeleteParams,
        requestOptions: RequestOptions,
    ): Terminal =
        // delete /v1/machines/{machine_id}/terminals/{terminal_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TerminalServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TerminalServiceAsync.WithRawResponse =
            TerminalServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<Terminal> =
            jsonHandler<Terminal>(clientOptions.jsonMapper)

        override suspend fun create(
            params: TerminalCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Terminal> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "terminals")
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

        private val retrieveHandler: Handler<Terminal> =
            jsonHandler<Terminal>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: TerminalRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Terminal> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "terminals",
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

        private val listHandler: Handler<TerminalList> =
            jsonHandler<TerminalList>(clientOptions.jsonMapper)

        override suspend fun list(
            params: TerminalListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TerminalListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "terminals")
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
                        TerminalListPageAsync.builder()
                            .service(TerminalServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Terminal> =
            jsonHandler<Terminal>(clientOptions.jsonMapper)

        override suspend fun delete(
            params: TerminalDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Terminal> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "terminals",
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
    }
}
