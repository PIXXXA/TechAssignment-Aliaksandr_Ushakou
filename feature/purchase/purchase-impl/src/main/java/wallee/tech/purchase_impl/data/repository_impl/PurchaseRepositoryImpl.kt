package wallee.tech.purchase_impl.data.repository_impl

import wallee.tech.purchase_impl.data.api.PurchaseApi
import wallee.tech.purchase_impl.data.dto.toDomainModel
import wallee.tech.purchase_impl.domain.model.PurchaseTransactionDomainModel
import wallee.tech.purchase_impl.domain.repository.PurchaseRepository

internal class PurchaseRepositoryImpl(
    private val purchaseApi: PurchaseApi
) : PurchaseRepository {

    override suspend fun getTransactionReceipt(): PurchaseTransactionDomainModel {
        val response = purchaseApi.getTransactionReceipt()
        return if (response.isSuccessful)
            response.body()?.toDomainModel() ?: PurchaseTransactionDomainModel()
        else PurchaseTransactionDomainModel()
    }
}
