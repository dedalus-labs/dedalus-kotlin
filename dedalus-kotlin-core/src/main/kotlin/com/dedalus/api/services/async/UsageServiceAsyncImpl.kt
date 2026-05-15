// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async

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
import com.dedalus.api.core.http.parseable
import com.dedalus.api.core.prepareAsync
import com.dedalus.api.models.usage.MachineComputeUsage
import com.dedalus.api.models.usage.MachineStorageUsage
import com.dedalus.api.models.usage.OrgUsage
import com.dedalus.api.models.usage.UsageMachineComputeParams
import com.dedalus.api.models.usage.UsageMachineStorageParams
import com.dedalus.api.models.usage.UsageRetrieveParams

class UsageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UsageServiceAsync {

    private val withRawResponse: UsageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UsageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UsageServiceAsync =
        UsageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: UsageRetrieveParams,
        requestOptions: RequestOptions,
    ): OrgUsage =
        // get /v1/usage
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun machineCompute(
        params: UsageMachineComputeParams,
        requestOptions: RequestOptions,
    ): MachineComputeUsage =
        // get /v1/usage/machines/compute
        withRawResponse().machineCompute(params, requestOptions).parse()

    override suspend fun machineStorage(
        params: UsageMachineStorageParams,
        requestOptions: RequestOptions,
    ): MachineStorageUsage =
        // get /v1/usage/machines/storage
        withRawResponse().machineStorage(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UsageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): UsageServiceAsync.WithRawResponse =
            UsageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<OrgUsage> =
            jsonHandler<OrgUsage>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: UsageRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrgUsage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "usage")
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

        private val machineComputeHandler: Handler<MachineComputeUsage> =
            jsonHandler<MachineComputeUsage>(clientOptions.jsonMapper)

        override suspend fun machineCompute(
            params: UsageMachineComputeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MachineComputeUsage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "usage", "machines", "compute")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { machineComputeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val machineStorageHandler: Handler<MachineStorageUsage> =
            jsonHandler<MachineStorageUsage>(clientOptions.jsonMapper)

        override suspend fun machineStorage(
            params: UsageMachineStorageParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MachineStorageUsage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "usage", "machines", "storage")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { machineStorageHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
