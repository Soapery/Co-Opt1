package com.example.co_opt1


data class Products(
    val products:List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
//    val images: Array<String>
)

// {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Products
//
//        if (!images.contentEquals(other.images)) return false
//
//        return true
//    }

//    override fun hashCode(): Int {
//        return images.contentHashCode()
//    }
//}