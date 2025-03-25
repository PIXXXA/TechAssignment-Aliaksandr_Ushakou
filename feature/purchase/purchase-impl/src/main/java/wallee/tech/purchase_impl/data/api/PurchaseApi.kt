package wallee.tech.purchase_impl.data.api

import retrofit2.Response
import retrofit2.http.GET
import wallee.tech.purchase_impl.data.dto.PurchaseTransactionDto

internal interface PurchaseApi {

    @GET("/")
    suspend fun getTransactionReceipt(): Response<PurchaseTransactionDto>

}
