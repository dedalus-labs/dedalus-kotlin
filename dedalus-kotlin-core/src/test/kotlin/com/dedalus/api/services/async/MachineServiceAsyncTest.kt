// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async

import com.dedalus.api.TestServerExtension
import com.dedalus.api.client.okhttp.DedalusOkHttpClientAsync
import com.dedalus.api.models.machines.CreateParams
import com.dedalus.api.models.machines.MachineDeleteParams
import com.dedalus.api.models.machines.MachineRetrieveParams
import com.dedalus.api.models.machines.MachineSleepParams
import com.dedalus.api.models.machines.MachineUpdateParams
import com.dedalus.api.models.machines.MachineWakeParams
import com.dedalus.api.models.machines.UpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MachineServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val machine =
            machineServiceAsync.create(
                CreateParams.builder()
                    .memoryMiB(0L)
                    .storageGiB(0L)
                    .vcpu(0.0)
                    .autosleep("autosleep")
                    .build()
            )

        machine.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val machine =
            machineServiceAsync.retrieve(MachineRetrieveParams.builder().machineId("dm-3").build())

        machine.validate()
    }

    @Test
    suspend fun update() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val machine =
            machineServiceAsync.update(
                MachineUpdateParams.builder()
                    .machineId("dm-3")
                    .updateParams(
                        UpdateParams.builder()
                            .autosleep("autosleep")
                            .memoryMiB(0L)
                            .storageGiB(0L)
                            .vcpu(0.0)
                            .build()
                    )
                    .build()
            )

        machine.validate()
    }

    @Test
    suspend fun list() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val page = machineServiceAsync.list()

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val machine =
            machineServiceAsync.delete(MachineDeleteParams.builder().machineId("dm-3").build())

        machine.validate()
    }

    @Test
    suspend fun sleep() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val machine =
            machineServiceAsync.sleep(MachineSleepParams.builder().machineId("dm-3").build())

        machine.validate()
    }

    @Test
    suspend fun wake() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val machineServiceAsync = client.machines()

        val machine =
            machineServiceAsync.wake(MachineWakeParams.builder().machineId("dm-3").build())

        machine.validate()
    }
}
